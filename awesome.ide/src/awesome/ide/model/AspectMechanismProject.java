package awesome.ide.model;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import awesome.ide.gen.AspectMechanismGen;
import awesome.ide.gen.ManifestGen;
import awesome.ide.wizards.AspectMechanismDescriptor;
import awesome.ide.wizards.ManifestDescriptor;

public class AspectMechanismProject extends MechanismProject {
	private static final String PROJ_PREFIX = "awm";
	private static final String SRC_FOLDER = "src";
	private String dsalName;
	
	public class Manifest {
		public String getName() {
			return dsalName.toLowerCase() + ".manifest";
		}
		public InputStream getContents() throws CoreException {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(AspectMechanismProject.this.getName()).getFile(getName()).getContents();
		}
	}
	
	private AspectMechanismProject(String dsalName) {
		this.dsalName = dsalName;
	}
	/**
	 * Creates an aspect mechanism project for the given dsal within the workspace, and returns an handle
	 * for the created project. If a corresponding aspect mechanism project already exists in the
	 * workspace, a handle for it is returned.
	 * @param dsalName e.g., Validate, Cool
	 * @param monitor (or null)
	 * @return an handle for the project
	 * @throws Exception
	 */
	public static AspectMechanismProject createProject(String dsalName, IProgressMonitor monitor) throws Exception {
		AspectMechanismProject amProj = new AspectMechanismProject(dsalName);
		
		// return in case that the project already exists in the workspace
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(amProj.getName()).exists())
			return amProj;
		
		if(monitor != null)
			monitor.beginTask("Creating Aspect Mechanism Project...", 2);
		
		IJavaProject javaProj = amProj.createJavaProject(amProj.getName());
		amProj.createSrcFolder(javaProj);
		amProj.createDSALPackage(javaProj, dsalName);
		amProj.createManifestFile(javaProj, dsalName);
		
		if(monitor != null)
			monitor.worked(1);
		
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		// Create the 'jars' folder, and put the jars in it
		amProj.createJarsFolder(javaProj);
		
		if(monitor != null)
			monitor.worked(1);
		
		return amProj;
	}
	
	@Override
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
			project.getFile(this.new Manifest().getName()).create(toInputStream(content), true, null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	/**
	 * @return the package where the source files of the mechanism reside.
	 */
	public IFolder getSrcFolder() {
		String srcPath = SRC_FOLDER;// + "/" + PROJ_PREFIX + "/" + dsalName.toLowerCase();
		return ResourcesPlugin.getWorkspace().getRoot().getProject(this.getName()).getFolder(srcPath);
	}

}
