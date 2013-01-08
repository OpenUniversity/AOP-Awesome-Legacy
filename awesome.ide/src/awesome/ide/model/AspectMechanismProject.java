package awesome.ide.model;

import java.io.InputStream;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.Activator;
import awesome.ide.gen.ManifestGen;

public class AspectMechanismProject extends MechanismProject {
	public static final String PROJ_PREFIX = "awm";
	private String dsalName;
	private IJavaProject javaProj;
	
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
		
		amProj.javaProj = amProj.createJavaProject(amProj.getName());
		amProj.createSrcFolder(MechanismProject.SRC_FOLDER);
		amProj.createAspectMechanism(amProj.javaProj.getProject().getName(), dsalName);
		amProj.createManifestFile(dsalName);
		amProj.createAntFile();
		
		if(monitor != null)
			monitor.worked(1);
		
		// Create the 'lib' folder, and put the jars in it. This should be done before AJ deps so it comes first in the build order
		String[] jars = {Activator.ASM_JAR, Activator.AWESOME_JAR, Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR};
		amProj.createLibFolder(jars);
		
		// convert to AspectJ
		AspectJUIPlugin.convertToAspectJProject(amProj.javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(amProj.javaProj.getProject());
		
		
		if(monitor != null)
			monitor.worked(2);
		
		return amProj;
	}
	
	
	@Override
	public String getName() {
		return PROJ_PREFIX + "." + dsalName.toLowerCase();
	}

	private void createManifestFile(String dsalName) {
		IProject project = javaProj.getProject();
		String content;
		content = new ManifestGen().generate(new String[]{dsalName});
		try {
			project.getFile(this.new Manifest().getName()).create(toInputStream(content), true, null);
		} catch (CoreException e) {
			 throw new RuntimeException("Failed to create manifest file in aspect mechanism project");
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
	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}

}
