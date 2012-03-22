package awesome.ide.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;

import awesome.ide.gen.AdviceOrderConfigGen;
import awesome.ide.model.manifests.Advice;
import awesome.ide.model.manifests.CSManifest;

public class MultiMechanismProject extends MechanismProject {
	public static final String SPEC_FOLDER = "spec";
	public static final String COMP_SPEC_FILE = "composition.spec";
	public static final String CONFIG_FOLDER = "config";
	
	private IJavaProject javaProj;
	private String projectName;
	private String[] dsalNames;
	private IFolder configFolder;
	
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
		
		mmProj.createSourceFolders();
		mmProj.addSourceFoldersToBuildPath();
		 
		// Create a folder with the dependent jars
		mmProj.createJarsFolder(mmProj.javaProj);
		
		mmProj.createSpecFolder();
		
		if(monitor != null)
			monitor.worked(1);
		
		return mmProj;
	}
	
	/**
	 * For each aspect mechanism, its source folder is copied from its project.
	 * In addition, a folder is generated for holding the generated configuration aspects. 
	 * @throws Exception
	 */
	private void createSourceFolders() throws Exception {
		for(String dsalName : dsalNames) {
			AspectMechanismProject amProj = AspectMechanismProject.createProject(dsalName, null);
			IFolder amSrc = amProj.getSrcFolder();
			// source folder is copied under a folder with the name of the am project
			amSrc.copy(new Path(javaProj.getProject().getFullPath() + "/" + amProj.getName()), true, null);
		}
		
		// create a folder for the configuration aspects
		configFolder = javaProj.getProject().getFolder(CONFIG_FOLDER);
		configFolder.create(false, true, null);
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
		file.create(toInputStream(contents), true, null);
	}
	public IFolder getConfigFolder() {
		return configFolder;
	}

	private List<String> getMechanismsCapitalized(List<Advice> advice) {
		List<String> result = new LinkedList<String>();
		for(Advice adv : advice)
			if(!result.contains(capitalize(adv.getMechanism()))) result.add(capitalize(adv.getMechanism()));
		return result;
	}
	private String capitalize(String str) {
		char[] stringArray = str.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		return new String(stringArray);
	}
}
