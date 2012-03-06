package awesome.ide.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.osgi.framework.Bundle;

import awesome.ide.Activator;
import awesome.ide.gen.AspectMechanismGen;
import awesome.ide.gen.ManifestGen;
import awesome.ide.wizards.AspectMechanismDescriptor;
import awesome.ide.wizards.ManifestDescriptor;

public class AspectMechanismProject {
	private static final String PROJ_PREFIX = "awm";
	private static final String SRC_FOLDER = "src";
	private static final String JARS_FOLDER = "jars";
	private String dsalName;
	
	public AspectMechanismProject(String dsalName) {
		this.dsalName = dsalName;
	}
	public void create(IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Creating Aspect Mechanism Project...", 2);
		
		IJavaProject javaProj = createJavaProject(getName());
		createSrcFolder(javaProj);
		createDSALPackage(javaProj, dsalName);
		createManifestFile(javaProj, dsalName);
		
		monitor.worked(1);
		
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		// Create the 'jars' folder, and put the jars in it
		createJarsFolder(javaProj);
		
		monitor.worked(1);
	}
	public String getName() {
		return PROJ_PREFIX + "." + dsalName.toLowerCase();
	}
	private void createSrcFolder(IJavaProject project) throws CoreException {
		IFolder srcFolder = project.getProject().getFolder(SRC_FOLDER);
		srcFolder.create(false, true, null);
		addFolderToBuildPath(project, SRC_FOLDER);
	}
	/**
	 * Create a DSAL package (same name as project name) and generates an aspect mechanism inside it.
	 * @param project
	 * @param packageName
	 * @throws JavaModelException
	 */
	private void createDSALPackage(IJavaProject project, String dsalName) throws JavaModelException {
		// create the package
		IFolder srcFolder = project.getProject().getFolder(SRC_FOLDER);
		IPackageFragmentRoot src = project.getPackageFragmentRoot(srcFolder);
		String packageName = project.getProject().getName();
		IPackageFragment pack = src.createPackageFragment(packageName, false, null);
		
		// generate an aspect mechanism within the package
		AspectMechanismDescriptor desc = new AspectMechanismDescriptor();
		desc.setPackageName(packageName);
		desc.setAspectName(dsalName + "Mechanism");
		desc.setId(dsalName);
		StringBuffer buffer = new StringBuffer();
		buffer.append(new AspectMechanismGen().generate(desc));
		pack.createCompilationUnit(dsalName + "Mechanism" + ".aj", buffer.toString(), false, null);
	}
	private void createManifestFile(IJavaProject javaProj, String dsalName) {
		IProject project = javaProj.getProject();
		ManifestDescriptor desc = new ManifestDescriptor();
		desc.setDsalName(dsalName);
		String content;
		content = new ManifestGen().generate(desc);
		try {
			project.getFile(dsalName.toLowerCase() + "." + "manifest").create(toInputStream(content), true, null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private InputStream toInputStream(String str) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(str.getBytes("UTF-8"));
	}
	private void createJarsFolder(IJavaProject javaProject) throws CoreException {
		String[] jars = {"asm-3.1.jar", "awesome.platform.jar", "commons.jar", "jrockit.jar"};
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		
		IFolder jarsFolder = javaProject.getProject().getFolder(JARS_FOLDER);
		jarsFolder.create(false, true, null);
		
		for(String jar : jars) {
			URL fileURL = bundle.getEntry("resources/" + jar);
			IFile newfile = jarsFolder.getFile(jar);
			try {
				newfile.create(fileURL.openStream(), true, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// add the jars in jars/ to the build path:
		addJarsToBuildPath(javaProject);
	}
	private void addJarsToBuildPath(IJavaProject javaProject) {
		String[] jars = {"asm-3.1.jar", "awesome.platform.jar", "commons.jar", "jrockit.jar"};
		
		IClasspathEntry[] originalCP;
		try {
			for(String jar : jars){
				originalCP = javaProject.getRawClasspath();
				IPath path = new Path(javaProject.getPath() + "/" + JARS_FOLDER + "/" + jar);
				
				IClasspathEntry lib;
				// add awesome.platform.jar to inpath (we saw in our eyes the value needed)
				if(jar.equals("awesome.platform.jar")){
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
	private IJavaProject createJavaProject(String projectName) throws CoreException, JavaModelException {
		
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
		//add libs to project class path
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}
	private void addFolderToBuildPath(IJavaProject javaProj, String folderName) throws JavaModelException {
		IFolder folder = javaProj.getProject().getFolder(folderName);
		IPackageFragmentRoot proot = javaProj.getPackageFragmentRoot(folder);
		IClasspathEntry[] oldEntries = javaProj.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
		javaProj.setRawClasspath(newEntries, null);
	}

}
