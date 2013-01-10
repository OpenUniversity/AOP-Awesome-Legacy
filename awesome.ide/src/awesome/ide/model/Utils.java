package awesome.ide.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;

import awesome.ide.Activator;

/**
 * A variety of static methods, mostly to perform workspace Java-related 
 * operations, e.g., creating a Java project, a package etc.
 * @author oren
 *
 */
public class Utils {
	public static void addJarsToBuildPath(IJavaProject javaProject, String libFolder, String[] jars) {	
		IClasspathEntry[] originalCP;
		try {
			for(String jar : jars){
				originalCP = javaProject.getRawClasspath();
				IPath path = new Path(javaProject.getPath() + "/" + libFolder + "/" + jar);
				
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
	public static InputStream toInputStream(String str) {
		try {
			return new ByteArrayInputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Creates a folder and add it to the build path.
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	public static void createSrcFolder(IJavaProject project, String folderName) {
		IFolder srcFolder = project.getProject().getFolder(folderName);
		try {
			srcFolder.create(false, true, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		addFolderToClasspath(project, folderName);
	}
	public static void addFolderToClasspath(IJavaProject javaProj, String folderName) {
		IFolder folder = javaProj.getProject().getFolder(folderName);
		IPackageFragmentRoot proot = javaProj.getPackageFragmentRoot(folder);
		IClasspathEntry entry = JavaCore.newSourceEntry(proot.getPath());
		addEntryToClasspath(javaProj, entry);
	}
	public static void addEntryToClasspath(IJavaProject javaProj, IClasspathEntry entry) {
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
	 * Add the project with the given name to the classpath of the java project.
	 * @param javaProj
	 * @param projectName
	 */
	public static void addProjectToClassPath(IJavaProject javaProj, String projectName) {
		IClasspathEntry entry = JavaCore.newProjectEntry(new Path("/" + projectName), true);
		addEntryToClasspath(javaProj, entry);
	}
	/**
	 * Add the given container to the java project's classpath.
	 * @param javaProj
	 * @param containerPath
	 */
	public static void addContainerToClasspath(IJavaProject javaProj, IPath containerPath) {
		IClasspathEntry entry =  JavaCore.newContainerEntry(containerPath, false);
		addEntryToClasspath(javaProj, entry);
	}
	/**
	 * @param str e.g., "heLLO"
	 * @return "Hello"
	 */
	public static String capitalize(String str) {
		if(str == null || str.length() == 0)
			return str;
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
	public static IFolder createFolder(IJavaProject javaProject, String folderName) {
		IProject project = javaProject.getProject();
		IFolder folder = project.getFolder(folderName);
		try {
			folder.create(false, true, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		return folder;
	}
	public static IFolder createSubFolder(IFolder folder, String subfolderName) {
		IFolder subfolder = folder.getFolder(subfolderName);
		try {
			subfolder.create(false, true, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		return subfolder;
	}
	public static IFile createFileInFolder(IFolder folder, String fileName, String content) {
		InputStream source = toInputStream(content);
		try {
			IFile file = folder.getFile(fileName);
			file.create(source, false, null);
			return file;
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	public static IJavaProject createJavaProject(String projectName) {
		
		try {
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
		IFolder binFolder = project.getFolder("bin");
		binFolder.create(false, true, null);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
		
		//addContainerToBuildPath(javaProject, JRE_CONTAINER_PATH);
		addJavaLibrariesToClassPath(javaProject);
		
		return javaProject;
		
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	private static void addJavaLibrariesToClassPath(IJavaProject javaProject) throws JavaModelException {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
		 entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
		}
		//add libs to project class path. should be changed to append!
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}
}
