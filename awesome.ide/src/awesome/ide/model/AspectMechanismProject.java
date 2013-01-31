package awesome.ide.model;

import java.io.InputStream;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.Activator;
import awesome.ide.gen.ManifestGen;
import awesome.ide.gen.WeavingInfoCollectorGen;
import awesome.ide.gen.WeavingInfoGen;

public class AspectMechanismProject extends MechanismProject {
	public static final String PROJ_PREFIX = "awm";
	public static final String SRC_DEV = "src-dev";
	private String dsalName;
	private IJavaProject javaProj;
	/**
	 * a source folder holding the mechanism aspect.
	 */
	private MechanismSrcFolder src;
	/**
	 * a source folder for development only, holds utilities that collect weaving info.
	 */
	private SrcFolder srcdev;
	/**
	 * a folder holding required jars.
	 */
	private LibFolder lib;
	/**
	 * an ant buil.xml file for packaging the weaver.
	 */
	private AntFile ant;
	/**
	 * a README file explaining the content and basic usage of the project.
	 */
	private ReadmeFile readme;
	/**
	 * a manifest describing basic properties of the mechanism (currently not in use).
	 */
	private ManifestFile manifest;
	
	private AspectMechanismProject(String dsalName) {
		this.dsalName = dsalName;
		src = new MechanismSrcFolder(SRC_FOLDER, dsalName);
		lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASM_JAR, Activator.AWESOME_JAR, Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR});
		ant = new AntFile();
		readme = new ReadmeFile();
		manifest = new ManifestFile();
		srcdev = new SrcFolder(SRC_DEV, getProjectName());
	}
	
	public class ManifestFile {
		public String getName() {
			return getDsalName().toLowerCase() + ".manifest";
		}
		public void commit() {
			IProject project = javaProj.getProject();
			String content;
			content = new ManifestGen().generate(new String[]{getDsalName()});
			try {
				project.getFile(getName()).create(Utils.toInputStream(content), true, null);
			} catch (CoreException e) {
				 throw new RuntimeException("Failed to create manifest file in aspect mechanism project");
			}
		}
		public InputStream getContents() {
			try {
				return ResourcesPlugin.getWorkspace().getRoot().getProject(AspectMechanismProject.this.getProjectName()).getFile(getName()).getContents();
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}
	

	/**
	 * Note that no content is written yet in the workspace. For that,
	 * use {@link #commit}
	 * @param dsalName
	 * @return
	 */
	public static AspectMechanismProject create(String dsalName) {
		AspectMechanismProject amProj = new AspectMechanismProject(dsalName);	
		return amProj;
	}

	/**
	 * Writes the project to the workspace
	 */
	public void commit(IProgressMonitor monitor) {
		// return in case that the project already exists in the workspace
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(this.getProjectName()).exists())
			return;
		
		if(monitor != null)
			monitor.beginTask("Creating Aspect Mechanism Project...", 2);
		
		try {
			javaProj = Utils.createJavaProject(getProjectName());
			src.commit(getJavaProject());
			commitSrcDev();
			manifest.commit();
			
			if(monitor != null)
				monitor.worked(1);
			
			ant.commit(javaProj);
			lib.commit(javaProj);
			readme.commit(this);
			
			// convert to AspectJ
			AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
			AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
			
			
			if(monitor != null)
				monitor.worked(2);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void commitSrcDev() {
		srcdev.commit(getJavaProject());
		srcdev.addCompilationUnit("WeavingInfo.java", new WeavingInfoGen().generate(getProjectName()));
		srcdev.addCompilationUnit("WeavingInfoCollector.aj", new WeavingInfoCollectorGen().generate(getProjectName()));
	}

	@Override
	public String getProjectName() {
		return PROJ_PREFIX + "." + dsalName.toLowerCase();
	}
	@Override
	public String getDsalName() {
		return dsalName;
	}

	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}

	public MechanismSrcFolder getSrcFolder() {
		return src;
	}
	public LibFolder getLibFolder() {
		return lib;
	}
	public AntFile getAntFile() {
		return ant;
	}
	public ManifestFile getManifestFile() {
		return manifest;
	}
}
