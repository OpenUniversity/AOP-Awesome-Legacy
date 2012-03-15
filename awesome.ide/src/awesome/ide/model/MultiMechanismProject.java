package awesome.ide.model;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import awesome.ide.gen.AspectMechanismGen;
import awesome.ide.wizards.AspectMechanismDescriptor;

public class MultiMechanismProject extends MechanismProject {
	private static final String SPEC_FOLDER = "spec";
	private static final String COMP_SPEC_FILE = "composition.spec";
	private IJavaProject javaProj;
	private String projectName;
	private String[] dsalNames;
	
//	public class Spec {
//		public String getDirName() {
//			return SPEC_FOLDER;
//		}
//		public boolean exists() {
//			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(MultiMechanismProject.this.getName());
//			return project.getFolder(getDirName()).exists();
//		}
//	}
	
	private MultiMechanismProject(String projectName, String[] dsalNames) {
		this.projectName = projectName;
		this.dsalNames = dsalNames;
	}
	
	public static MultiMechanismProject createProject(String projectName, String[] dsalNames, IProgressMonitor monitor) throws Exception {
		MultiMechanismProject mmProj = new MultiMechanismProject(projectName, dsalNames);
		
		if(monitor != null)
			monitor.beginTask("Creating Multi-Mechanism Project...", 2);
		
		mmProj.javaProj = mmProj.createJavaProject(projectName);
		
		if(monitor != null)
			monitor.worked(1);
		
		AspectJUIPlugin.convertToAspectJProject(mmProj.javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(mmProj.javaProj.getProject());
		
		mmProj.copySourceFolderFromAspectMechanismProjects();
		mmProj.addSourceFoldersToBuildPath();
		
		// Create a source folder for each DSAL, and a Java package within it.
		// An aspect mechanism class is generated within each package.
		//mmProj.createDsalSourceFolders(dsalNames, javaProj);
		//mmProj.addDsalSourceFoldersToBuildPath(dsalNames, javaProj);
		 
		// Create a folder with the dependent jars
		mmProj.createJarsFolder(mmProj.javaProj);
		
		mmProj.createSpecFolder();
		
		if(monitor != null)
			monitor.worked(1);
		
		return mmProj;
	}
	
	private void copySourceFolderFromAspectMechanismProjects() throws Exception {
		// TODO Auto-generated method stub
		for(String dsalName : dsalNames) {
			AspectMechanismProject amProj = AspectMechanismProject.createProject(dsalName, null);
			IFolder amSrc = amProj.getSrcFolder();
			// source folder is copied under a folder with the name of the am project
			amSrc.copy(new Path(javaProj.getProject().getFullPath() + "/" + amProj.getName()), true, null);
		}
	}

	/**
	 * Creates a spec folder within the multi-mechanism project. The folder
	 * contains the manifest of the composed mechanisms and a composition specification file.
	 * @param javaProject
	 * @param dsalNames
	 * @throws Exception
	 */
	private void createSpecFolder() throws Exception {
		IFolder spec = javaProj.getProject().getFolder(SPEC_FOLDER);
		spec.create(false, true, null);
		
		// get the project of each dsal and extract the manifest file
		for(String dsalName : dsalNames) {
			AspectMechanismProject amProj = AspectMechanismProject.createProject(dsalName, null);
			AspectMechanismProject.Manifest manifest = amProj.new Manifest();
			
			// create the manifest in the multi-mechanism project
			IFile newManifest = javaProj.getProject().getFile(new Path(SPEC_FOLDER + "/" + manifest.getName()));
			newManifest.create(manifest.getContents(), true, null);
		}
		
		// create a composition specification file
		javaProj.getProject().getFile(new Path(SPEC_FOLDER + "/" + COMP_SPEC_FILE)).create(toInputStream(""), true, null);
	}
	
	private void createDsalSourceFolders() throws CoreException, JavaModelException {

		IPackageFragmentRoot src;
		IPackageFragment pack;
		AspectMechanismDescriptor desc = new AspectMechanismDescriptor();
		StringBuffer buffer;
		
		for(String dsalName: dsalNames){
			IFolder dsalSourceFolder = javaProj.getProject().getFolder("awm." + dsalName.toLowerCase());
			dsalSourceFolder.create(false, true, null);
			
			src = javaProj.getPackageFragmentRoot(dsalSourceFolder);
			pack = src.createPackageFragment("awm." + dsalName.toLowerCase(), false, null);
			
			desc.setPackageName("awm." + dsalName.toLowerCase());
			desc.setAspectName(dsalName + "Mechanism");
			desc.setId(dsalName);
			buffer = new StringBuffer();
			buffer.append(new AspectMechanismGen().generate(desc));
			pack.createCompilationUnit(dsalName + "Mechanism.aj", buffer.toString(), false, null);
		}
	}
	private void addSourceFoldersToBuildPath() throws Exception {
		for(String dsalName: dsalNames){
			AspectMechanismProject amProj = AspectMechanismProject.createProject(dsalName, null);
			IFolder dsalSourceFolder = javaProj.getProject().getFolder(amProj.getName());
			IPackageFragmentRoot proot = javaProj.getPackageFragmentRoot(dsalSourceFolder);
			IClasspathEntry[] oldEntries = javaProj.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
			javaProj.setRawClasspath(newEntries, null);
		}
	}

	@Override
	public String getName() {
		return projectName;
	}
}
