package awesome.ide.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import awesome.ide.Activator;
import awesome.ide.gen.AdviceOrderConfigGen;
import awesome.ide.model.manifests.Advice;
import awesome.ide.model.manifests.CSManifest;

public class MultiMechanismProject extends MechanismProject {
	public static final String PROJ_PREFIX = "awmm";
	public static final String SPEC_FOLDER = "spec";
	public static final String COMP_SPEC_FILE = "composition.spec";
	public static final String CONFIG_FOLDER = "config";
	private static final String ASPECTJ_ID = "aspectj";
	private static final String AJ_FOLDER_NAME = ASPECTJ_ID + "Src";
	private LibFolder lib;
	private AntFile ant;
	private MechanismSrcFolder ajFolder;
	private SrcDevFolder srcdev;
	private IJavaProject javaProj;
	private String name;
	private String[] dsalNames;
	boolean includeAJ;
	
	private MultiMechanismProject(String projectName, String[] dsalNames, boolean includeAJ) {
		this.name = projectName;
		lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASM_JAR, Activator.AWESOME_JAR, 
				Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR});
		this.dsalNames = dsalNames;
		this.includeAJ = includeAJ;
		ant = new AntFile();
		if(includeAJ) ajFolder = new MechanismSrcFolder(AJ_FOLDER_NAME, ASPECTJ_ID);
		srcdev = new SrcDevFolder(getProjectName());
		
	}
	
	/**
	 * Returns a handle for an existing multi-mechanism project
	 * @param name
	 * @return
	 */
	public static MultiMechanismProject getProject(String name) {
		MultiMechanismProject mmProj = new MultiMechanismProject(name, null, false);

		// set javaProj
		IProject proj = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		mmProj.javaProj = JavaCore.create(proj);
	
		return mmProj;
	}
	
	public void commit(IProgressMonitor monitor) {
		// return in case that the project already exists in the workspace
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName()).exists())
			return;
		if(monitor != null)
			monitor.beginTask("Creating Multi-Mechanism Project...", 2);
		
		javaProj = Utils.createJavaProject(getProjectName());
		// note: creation of source folders MUST precede lib.commit.
		// a matter or build order, otherwise we get weave-time errors. 
		if(includeAJ) ajFolder.commit(getJavaProject());
		srcdev.commit(getJavaProject());
		linkToSourceFoldersOfMechanisms(dsalNames);
		
		lib.commit(getJavaProject());
		ant.commit(getJavaProject());
		
		if(monitor != null)
			monitor.worked(1);
		
		// one day, these two should be made classes...
		createAspectConfigurationFolder();
		createSpecFolder(dsalNames);
		
		try {
			AspectJUIPlugin.convertToAspectJProject(getJavaProject().getProject());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		AspectJUIPlugin.addAjrtToBuildPath(getJavaProject().getProject());
		
				
		if(monitor != null)
			monitor.done();
	}
	/**
	 * Creates a new multi-mechanism project
	 * @param projectName
	 * @param dsalNames
	 * @param monitor
	 * @return
	 * @throws Exception
	 */
	public static MultiMechanismProject create(String projectName, String[] dsalNames, boolean includeAJ) throws Exception {
		MultiMechanismProject mmProj = new MultiMechanismProject(projectName, dsalNames, includeAJ);		
		return mmProj;
	}
	
	/**
	 * Create within the project linked source folders pointing to the
	 * source folders of the aspect mechanisms.
	 * @param dsalNames
	 */
	private void linkToSourceFoldersOfMechanisms(String[] dsalNames) {
		for(String name : dsalNames) {
			IFolder srcFolder = javaProj.getProject().getFolder(name + "Src");
			try {
				srcFolder.createLink(new Path("WORKSPACE_LOC/" + AspectMechanismProject.PROJ_PREFIX + "." +
						name.toLowerCase() + "/src"), IResource.NONE, null);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
			
			IClasspathEntry entry = JavaCore.newSourceEntry(new Path(javaProj.getProject().getName() + "/" + srcFolder.getName()).makeAbsolute());
			Utils.addEntryToClasspath(javaProj, entry);
		}
	}

	/**
	 * A folder is generated for holding the generated configuration aspects. 
	 * @throws Exception
	 */
	private void createAspectConfigurationFolder() {
		Utils.createFolder(getJavaProject(), CONFIG_FOLDER);
	}

	/**
	 * Creates a spec folder within the multi-mechanism project. The folder
	 * contains the manifest of the composed mechanisms and a composition specification file.
	 * @param javaProject
	 * @param dsalNames
	 * @throws Exception
	 */
	private void createSpecFolder(String[] dsalNames) {
		try {
			Utils.createFolder(getJavaProject(), SPEC_FOLDER);

			// get the project of each dsal and extract the manifest file
			for(String dsalName : dsalNames) {
				AspectMechanismProject amProj = AspectMechanismProject.create(dsalName);
				AspectMechanismProject.ManifestFile manifest = amProj.new ManifestFile();

				// create the manifest in the multi-mechanism project
				IFile newManifest = javaProj.getProject().getFile(new Path(SPEC_FOLDER + "/" + manifest.getName()));
				newManifest.create(manifest.getContents(), true, null);
			}

			// create a composition specification file
			javaProj.getProject().getFile(new Path(SPEC_FOLDER + "/" + COMP_SPEC_FILE)).create(Utils.toInputStream(""), true, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getProjectName() {
		return name;
	}

	public CSManifest getCompositionSpecification() {
		return new CSManifest(this);
	}

	/**
	 * Currently we generate for the BEFORE_ADVICE_ORDER key
	 * @throws Exception 
	 */
	public void generateConfigurationAspects() throws Exception {
		AdviceOrderConfigGen gen = new AdviceOrderConfigGen();
		
		// get the before advice order
		List<Advice> advice = getCompositionSpecification().getAdviceOrder(CSManifest.AdviceType.Before);
		
		// generate the contents of the configuration aspect
		List<String> mechanisms = getMechanismsCapitalized(advice);
		Object[] argument = new Object[]{advice, mechanisms};
		String contents = gen.generate(argument);
		
		// create the aspect in the config folder
		IFolder folder = getConfigFolder();
		IFile file = folder.getFile("BeforeAdviceOrderConfig.aj");
		file.create(Utils.toInputStream(contents), true, null);
	}
	public IFolder getConfigFolder() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(name).getFolder(CONFIG_FOLDER);
	}

	private List<String> getMechanismsCapitalized(List<Advice> advice) {
		List<String> result = new LinkedList<String>();
		for(Advice adv : advice)
			if(!result.contains(Utils.capitalize(adv.getMechanism()))) result.add(Utils.capitalize(adv.getMechanism()));
		return result;
	}

	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}

	@Override
	public String[] getMechanismNames() {
		return dsalNames;
	}
}
