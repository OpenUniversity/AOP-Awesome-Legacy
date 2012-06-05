package awesome.ide.model;

import java.io.InputStream;
import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

import awesome.ide.Activator;
import awesome.ide.gen.AspectMechanismGen;
import awesome.ide.gen.ManifestGen;

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
	public static AspectMechanismProject create(String dsalName, IProgressMonitor monitor) throws Exception {
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
		
		// Create the 'lib' folder, and put the jars in it. This should be done before AJ deps so it comes first in the build order
		String[] jars = {Activator.ASM_JAR, Activator.AWESOME_JAR, Activator.COMMONS_JAR, Activator.JROCKIT_JAR};
		amProj.createLibFolder(javaProj, jars);
		
		// convert to AspectJ
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		
		if(monitor != null)
			monitor.worked(2);
		
		return amProj;
	}
	
	@Override
	public String getName() {
		return PROJ_PREFIX + "." + dsalName.toLowerCase();
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
		StringBuffer buffer = new StringBuffer();
		buffer.append(new AspectMechanismGen().generate(new String[]{packageName, dsalName + "Mechanism", dsalName}));
		pack.createCompilationUnit(dsalName + "Mechanism" + ".aj", buffer.toString(), false, null);
	}
	private void createManifestFile(IJavaProject javaProj, String dsalName) {
		IProject project = javaProj.getProject();
		String content;
		content = new ManifestGen().generate(new String[]{dsalName});
		try {
			project.getFile(this.new Manifest().getName()).create(toInputStream(content), true, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the package where the source files of the mechanism reside.
	 */
	public IFolder getSrcFolder() {
		String srcPath = SRC_FOLDER;// + "/" + PROJ_PREFIX + "/" + dsalName.toLowerCase();
		return ResourcesPlugin.getWorkspace().getRoot().getProject(this.getName()).getFolder(srcPath);
	}
	public String getDsalName() {
		return dsalName;
	}

}
