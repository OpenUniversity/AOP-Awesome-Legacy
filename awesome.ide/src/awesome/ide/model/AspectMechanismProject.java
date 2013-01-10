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
	public static final String PROJ_PREFIX = "awm";
	private String dsalName;
	private IJavaProject javaProj;
	private AMSrcFolder src;
	private LibFolder lib;
	private AntFile ant;
	private ManifestFile manifest;
	
	private AspectMechanismProject(String dsalName) {
		this.dsalName = dsalName;
		src = new AMSrcFolder(SRC_FOLDER, getName(),  Utils.capitalize(dsalName) + "Mechanism");
		lib = new LibFolder(new String[]{Activator.ASM_JAR, Activator.AWESOME_JAR, Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR});
		ant = new AntFile();
		manifest = new ManifestFile();
	}
	public class AMSrcFolder extends SrcFolder {
		private String aspectMechanismName;
		
		public AMSrcFolder(String name, String packageName, String aspectMechanismName) {
			super(name, packageName);
			this.aspectMechanismName = aspectMechanismName;
		}
		/**
		 * Creates a src folder within the project, with a package that holds
		 * a single aspect mechanism class.
		 */
		public void commit() {
			// super creates the src folder and the package
			super.commit(getJavaProject());
			
			// generate an aspect mechanism within the package
			StringBuffer buffer = new StringBuffer();
			buffer.append(new AspectMechanismGen().generate(new String[]{getPackageName(), aspectMechanismName, getDsalName()}));
			addCompilationUnit(aspectMechanismName + ".aj", buffer.toString());
		}
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
				project.getFile(getName()).create(toInputStream(content), true, null);
			} catch (CoreException e) {
				 throw new RuntimeException("Failed to create manifest file in aspect mechanism project");
			}
		}
		public InputStream getContents() {
			try {
				return ResourcesPlugin.getWorkspace().getRoot().getProject(AspectMechanismProject.this.getName()).getFile(getName()).getContents();
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
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(this.getName()).exists())
			return;
		
		if(monitor != null)
			monitor.beginTask("Creating Aspect Mechanism Project...", 2);
		
		try {
			javaProj = createJavaProject(getName());
			src.commit();
			manifest.commit();
			
			if(monitor != null)
				monitor.worked(1);
			
			ant.commit(javaProj.getProject());
			
			lib.commit(javaProj);
			
			// convert to AspectJ
			AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
			AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
			
			
			if(monitor != null)
				monitor.worked(2);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String getName() {
		return PROJ_PREFIX + "." + dsalName.toLowerCase();
	}

	public String getDsalName() {
		return dsalName;
	}

	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}

	public AMSrcFolder getSrcFolder() {
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
