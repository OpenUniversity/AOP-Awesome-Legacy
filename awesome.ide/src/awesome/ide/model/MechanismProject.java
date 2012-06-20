package awesome.ide.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.osgi.framework.Bundle;

import awesome.ide.Activator;

public abstract class MechanismProject {
	private static final String BIN_FOLDER = "bin";
	private static final String LIB_FOLDER = "lib";
	private static final String SRC_FOLDER = "src";
	public static final IPath JUNIT4_CONTAINER_PATH = new Path("org.eclipse.jdt.junit.JUNIT_CONTAINER/4");
	public static final IPath JRE_CONTAINER_PATH = new Path("org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6");

	public abstract String getName();
	
	/**
	 * @param busyWait try to delete again and again in case of failure (note infinite loop danger). This option is
	 * for testing purposes only. Otherwise use busyWait=false.
	 * @throws CoreException
	 */
	public static void deleteProject(MechanismProject mProj, boolean busyWait) throws CoreException {
		String name = mProj.getName();
		if(!ResourcesPlugin.getWorkspace().getRoot().getProject(name).exists())
			return;
		else { 
			try {
				ResourcesPlugin.getWorkspace().getRoot().getProject(name).delete(true, null);
			} catch (CoreException e) {
				if(busyWait)
					deleteProject(mProj, true);
				else
					throw e;
			}
		}
	}
	
	protected IJavaProject createJavaProject(String projectName) throws CoreException, JavaModelException {
		
		// Create a simple project of type org.eclipse.core.resources.IProject:
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		project.create(null);
		project.open(null);
		
		// Set the Java nature:
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(description, null);
		IJavaProject javaProject = JavaCore.create(project);
		
		// Set the Java output folder:
		IFolder binFolder = project.getFolder(BIN_FOLDER);
		binFolder.create(false, true, null);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
		
		//addContainerToBuildPath(javaProject, JRE_CONTAINER_PATH);
		addJavaLibrariesToClassPath(javaProject);
		
		return javaProject;
	}
	private void addJavaLibrariesToClassPath(IJavaProject javaProject) throws JavaModelException {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
		 entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
		}
		//add libs to project class path. should be changed to append!
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}
	private void addEntriesToClasspath(IJavaProject javaProj, List<IClasspathEntry> entries) {
		// move redundant code here...
	}
	protected void createLibFolder(IJavaProject javaProject, String[] jars) throws CoreException {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		
		IFolder jarsFolder = javaProject.getProject().getFolder(LIB_FOLDER);
		jarsFolder.create(false, true, null);
		
		for(String jar : jars) {
			URL fileURL = bundle.getEntry(Activator.JARS_FOLDER + "/" + jar);
			IFile newfile = jarsFolder.getFile(jar);
			try {
				newfile.create(fileURL.openStream(), true, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addJarsToBuildPath(javaProject, jars);
	}
	private void addJarsToBuildPath(IJavaProject javaProject, String[] jars) {	
		IClasspathEntry[] originalCP;
		try {
			for(String jar : jars){
				originalCP = javaProject.getRawClasspath();
				IPath path = new Path(javaProject.getPath() + "/" + LIB_FOLDER + "/" + jar);
				
				IClasspathEntry lib;
				// add awesome.platform.jar to inpath (we saw in our eyes the value needed)
				if(jar.equals(Activator.AWESOME_JAR)){
					IClasspathAttribute att = JavaCore.newClasspathAttribute("org.eclipse.ajdt.inpath", "org.eclipse.ajdt.inpath");
					lib = JavaCore.newLibraryEntry(path, null, null, null, new IClasspathAttribute[]{att}, true);
				} else {
					lib = JavaCore.newLibraryEntry(path, null, null);
				}
				
				int originalCPLength = originalCP.length;
				IClasspathEntry[] newCP = new IClasspathEntry[originalCPLength + 1];
				System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
				newCP[originalCPLength] = lib;
				javaProject.setRawClasspath(newCP, new NullProgressMonitor());
			}
			
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected InputStream toInputStream(String str) {
		try {
			return new ByteArrayInputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Creates a folder named 'src' and add it to the build path.
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	protected IFolder createSrcFolder(IJavaProject project) throws CoreException {
		IFolder srcFolder = project.getProject().getFolder(SRC_FOLDER);
		srcFolder.create(false, true, null);
		addFolderToClasspath(project, SRC_FOLDER);
		
		return srcFolder;
	}
	private void addFolderToClasspath(IJavaProject javaProj, String folderName) throws JavaModelException {
		IFolder folder = javaProj.getProject().getFolder(folderName);
		IPackageFragmentRoot proot = javaProj.getPackageFragmentRoot(folder);
		IClasspathEntry entry = JavaCore.newSourceEntry(proot.getPath());
		addEntryToClasspath(javaProj, entry);
		
		//IFolder folder = javaProj.getProject().getFolder(folderName);
		//IPackageFragmentRoot proot = javaProj.getPackageFragmentRoot(folder);
//		IClasspathEntry[] oldEntries = javaProj.getRawClasspath();
//		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
//		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
//		newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
//		javaProj.setRawClasspath(newEntries, null);
	}
	protected void addContainerToClasspath(IJavaProject javaProj, IPath containerPath) {
		IClasspathEntry entry =  JavaCore.newContainerEntry(containerPath, false);
		addEntryToClasspath(javaProj, entry);
	}
	protected void addProjectToClassPath(IJavaProject javaProj, String projectName) {
		IClasspathEntry entry = JavaCore.newProjectEntry(new Path("/" + projectName), true);
		addEntryToClasspath(javaProj, entry);
	}
	private void addEntryToClasspath(IJavaProject javaProj, IClasspathEntry entry) {
		try {
			IClasspathEntry[] oldEntries = javaProj.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = entry;
			javaProj.setRawClasspath(newEntries, null);
		} catch(JavaModelException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * @param str e.g., "heLLO"
	 * @return "Hello"
	 */
	protected String capitalize(String str) {
		if(str == null || str.length() == 0)
			return str;
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
}
