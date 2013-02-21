package awesome.ide.model;

import java.util.ArrayList;
import java.util.Arrays;
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
import awesome.ide.gen.EffectComparatorGen;
import awesome.ide.model.manifests.Advice;
import awesome.ide.model.manifests.CSManifest;

public class MultiMechanismProject extends MechanismProject {
	public static final String PROJ_PREFIX = "awmm";
	public static final String SPEC_FOLDER = "spec";
	public static final String COMP_SPEC_FILE = "composition.spec";
	public static final String CONFIG_FOLDER = "config";
	public static final String ASPECTJ_ID = "aspectj";
	private static final String AJ_FOLDER_NAME = ASPECTJ_ID + "Src";
	private LibFolder lib;
	private AntFile ant;
	private MechanismSrcFolder ajFolder;
	private SrcDevFolder srcdev;
	private IJavaProject javaProj;
	private SrcFolder config;
	private String name;
	private String[] mechanismNames;
	boolean includeAJ;
	
	private MultiMechanismProject(String projectName, String[] mechanismNames, boolean includeAJ) {
		this.name = projectName;
		lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASM_JAR, Activator.AWESOME_JAR, 
				Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR});
		this.includeAJ = includeAJ;
		if(includeAJ) {
			List<String> mechanisms = new ArrayList<String>(Arrays.asList(mechanismNames));
			mechanisms.add(ASPECTJ_ID);
			this.mechanismNames = mechanisms.toArray(new String[mechanisms.size()]);
		} else {			
			this.mechanismNames = mechanismNames;
		}

		config = new SrcFolder(CONFIG_FOLDER, CONFIG_FOLDER);
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
		linkToSourceFoldersOfMechanisms(mechanismNames);
		
		config.commit(getJavaProject());
		config.addCompilationUnit("EffectComparator.java", new EffectComparatorGen().generate(null));
		lib.commit(getJavaProject());
		ant.commit(getJavaProject());
		
		if(monitor != null)
			monitor.worked(1);
		
		// one day, these two should be made classes...
		createSpecFolder(mechanismNames);
		
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
	 * @param mechanismNames
	 * @param monitor
	 * @return
	 * @throws Exception
	 */
	public static MultiMechanismProject create(String projectName, String[] mechanismNames, boolean includeAJ) throws Exception {
		MultiMechanismProject mmProj = new MultiMechanismProject(projectName, mechanismNames, includeAJ);		
		return mmProj;
	}
	
	/**
	 * Create within the project linked source folders pointing to the
	 * source folders of the aspect mechanisms.
	 * @param dsalNames
	 */
	private void linkToSourceFoldersOfMechanisms(String[] dsalNames) {
		for(String name : dsalNames) {
			if(name.equals(ASPECTJ_ID)) continue;
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
	 * Creates a spec folder within the multi-mechanism project. The folder
	 * contains the manifest of the composed mechanisms and a composition specification file.
	 * @param javaProject
	 * @param mechanismNames
	 * @throws Exception
	 */
	private void createSpecFolder(String[] mechanismNames) {
		try {
			Utils.createFolder(getJavaProject(), SPEC_FOLDER);

			// get the project of each dsal and extract the manifest file
			for(String mech : mechanismNames) {
				if(mech.equals(ASPECTJ_ID)) continue;
				AspectMechanismProject amProj = AspectMechanismProject.create(mech);
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
	 * Currently we only generate for the BEFORE_ADVICE_ORDER key.
	 * Note: this method is called from the action after retrieving the mm project.
	 * However, the method getProject is very dangerous since the fields are not
	 * initialized properly. I guess a major refactoring is needed to solve that.
	 * Anyway, note the commented line below starting with // config.add...
	 * e.g. this is not working because of the problem mentioned above..
	 * also the method getMechanismNames() returns null and so on...
	 * @throws Exception 
	 */
	public void generateConfigurationAspects() throws Exception {
		List<Advice> beforeAdviceOrder = getCompositionSpecification().getAdviceOrder(CSManifest.BEFORE_ADVICE);
		List<Advice> afterAdviceOrder = getCompositionSpecification().getAdviceOrder(CSManifest.AFTER_ADVICE);
		List<Advice> aroundAdviceOrder = getCompositionSpecification().getAdviceOrder(CSManifest.AROUND_ADVICE);

		if(beforeAdviceOrder!=null) {
			generateAdviceOrderAspect(beforeAdviceOrder);			
		}
		if(afterAdviceOrder!=null) {
			generateAdviceOrderAspect(afterAdviceOrder);
		}
		if(aroundAdviceOrder!=null) {
			generateAdviceOrderAspect(aroundAdviceOrder);
		}
	}

	private void generateAdviceOrderAspect(List<Advice> adviceOrder) {
		String contents = new AdviceOrderConfigGen().generate(adviceOrder);
		//config.addCompilationUnit("BeforeAdviceOrderConfig.aj", contents); // do not try this option! see comment of calling method.
		
		// create the aspect in the config folder
		IFolder folder = getConfigFolder();
		Utils.createFileInFolder(folder, Utils.capitalize(adviceOrder.get(0).getType()) + "AdviceOrderConfig.aj", contents);
	}
	
	public IFolder getConfigFolder() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(name).getFolder(CONFIG_FOLDER + "/" + CONFIG_FOLDER);
	}

	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}

	@Override
	public String[] getMechanismNames() {
		return mechanismNames;
	}
}
