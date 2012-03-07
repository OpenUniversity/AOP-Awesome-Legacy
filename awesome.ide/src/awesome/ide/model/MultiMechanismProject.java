package awesome.ide.model;

import java.io.InputStream;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
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
	private String projectName;
	private String[] dsalNames;
	
	private MultiMechanismProject(String projectName, String[] dsalNames) {
		this.projectName = projectName;
		this.dsalNames = dsalNames;
	}
	
	public static MultiMechanismProject create(String projectName, String[] dsalNames, IProgressMonitor monitor) throws Exception {
		MultiMechanismProject mmProj = new MultiMechanismProject(projectName, dsalNames);
		
		if(monitor != null)
			monitor.beginTask("Creating Multi-Mechanism Project...", 2);
		
		IJavaProject javaProj = mmProj.createJavaProject(projectName);
		
		if(monitor != null)
			monitor.worked(1);
		
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		// Create a source folder for each DSAL, and a Java package within it.
		// An aspect mechanism class is generated within each package.
		mmProj.createDsalSourceFolders(dsalNames, javaProj);
		mmProj.addDsalSourceFoldersToBuildPath(dsalNames, javaProj);
		 
		// Create a folder with the dependent jars
		mmProj.createJarsFolder(javaProj);
		
		mmProj.createSpecFolder(javaProj, dsalNames);
		
		if(monitor != null)
			monitor.worked(1);
		
		return mmProj;
	}
	
	/**
	 * Creates a spec folder within the multi-mechanism project. The folder
	 * contains the manifest of the composed mechanisms and a composition specification file.
	 * @param javaProject
	 * @param dsalNames
	 * @throws Exception
	 */
	private void createSpecFolder(IJavaProject javaProject, String[] dsalNames) throws Exception {
		IFolder spec = javaProject.getProject().getFolder(SPEC_FOLDER);
		spec.create(false, true, null);
		
		// get the project of each dsal and extract the manifest file
		for(String dsalName : dsalNames) {
			AspectMechanismProject amProj = AspectMechanismProject.createProject(dsalName, null);
			AspectMechanismProject.Manifest manifest = amProj.new Manifest();
			
			// create the manifest in the multi-mechanism project
			IFile newManifest = javaProject.getProject().getFile(new Path(SPEC_FOLDER + "/" + manifest.getName()));
			newManifest.create(manifest.getContents(), true, null);
		}
		
		// create a composition specification file
		javaProject.getProject().getFile(new Path(SPEC_FOLDER + "/" + COMP_SPEC_FILE)).create(toInputStream(""), true, null);
	}
	
	private void createDsalSourceFolders(String[] dsalNames, IJavaProject javaProject) 
		throws CoreException, JavaModelException {

		IPackageFragmentRoot src;
		IPackageFragment pack;
		AspectMechanismDescriptor desc = new AspectMechanismDescriptor();
		StringBuffer buffer;
		
		for(String dsalName: dsalNames){
			IFolder dsalSourceFolder = javaProject.getProject().getFolder("awm." + dsalName.toLowerCase());
			dsalSourceFolder.create(false, true, null);
			
			src = javaProject.getPackageFragmentRoot(dsalSourceFolder);
			pack = src.createPackageFragment("awm." + dsalName.toLowerCase(), false, null);
			
			desc.setPackageName("awm." + dsalName.toLowerCase());
			desc.setAspectName(dsalName + "Mechanism");
			desc.setId(dsalName);
			buffer = new StringBuffer();
			buffer.append(new AspectMechanismGen().generate(desc));
			pack.createCompilationUnit(dsalName + "Mechanism.aj", buffer.toString(), false, null);
		}
	}
	private void addDsalSourceFoldersToBuildPath(String[] dsalNames, IJavaProject javaProject) throws JavaModelException {
		for(String dsalName: dsalNames){
			IFolder dsalSourceFolder = javaProject.getProject().getFolder("awm." + dsalName.toLowerCase());
			IPackageFragmentRoot proot = javaProject.getPackageFragmentRoot(dsalSourceFolder);
			IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
			javaProject.setRawClasspath(newEntries, null);
		}
	}


}
