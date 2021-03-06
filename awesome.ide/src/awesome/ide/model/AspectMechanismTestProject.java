package awesome.ide.model;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.Activator;
import awesome.ide.gen.TestappAspect;
import awesome.ide.gen.TestappExecuteLaunchGen;
import awesome.ide.gen.TestappMain;
import awesome.ide.gen.TestappTestCaseGen;
import awesome.ide.gen.TestappWeaveLaunchGen;

/**
 * A test project for both aspect mechanism and multi-mechanism project.
 * @author oren
 *
 */
public class AspectMechanismTestProject extends MechanismProject {
	public static final String TESTAPP_FOLDER = "myapp";
	public static final String TESTCASE_NAME = "MyTests";
	public static final String ASPECTS_FOLDER = "aspects";
	public static final String BASE_FOLDER = "base";
	public static final String TESTAPP_MAIN = "MyBase";
	public static final String TESTAPP_ASPECT = "MyAspect";
	private static final String TESTAPP_WEAVE_LAUNCH_SUFFIX = "weave.launch";
	private static final String TESTAPP_EXECUTE_LAUNCH_SUFFIX = "execute.launch";
	public static final String WEAVING_INFO_FOLDER = "weaving-info";
	private MechanismProject mProj;
	private IJavaProject javaProj;
	private AMTSrcFolder src;
	private SrcFolder srcgen;
	private LibFolder lib;
	private ReadmeFile readme;
	private TestAppFolder testapp;
	
	public class TestAppFolder {
		private String folderName;
		private Boolean isXtext;
		
		public TestAppFolder(String folderName, boolean isXtext) {
			this.folderName = folderName;
			this.isXtext = isXtext;
		}
		public String getFolderName() {
			return folderName;
		}
		public boolean isXtext() {
			return isXtext;
		}
		public void commit() {
			IFolder folder = Utils.createFolder(getJavaProject(), folderName);
			
			IFolder aspectsFolder = Utils.createSubFolder(folder, ASPECTS_FOLDER);
			
			// create an example aspect for each DSAL
			for(String mech : mProj.getMechanismNames()) {
				String aspectName = "My" + Utils.capitalize(mech) + "Aspect";
				Utils.createFileInFolder(aspectsFolder, aspectName + ".java", 
						new TestappAspect().generate(new String[]{ASPECTS_FOLDER, aspectName, mech}));
			}
			
			// for a multi-mechanism project we also create an AspectJ aspect
			// TODO
			
			IFolder baseFolder = Utils.createSubFolder(folder, BASE_FOLDER);
			Utils.createFileInFolder(baseFolder, TESTAPP_MAIN + ".java", new TestappMain().generate(new String[]{BASE_FOLDER}));
			
			// create a weave.launch file
			Utils.createFileInFolder(folder, getProjectName() + "." + TESTAPP_WEAVE_LAUNCH_SUFFIX, 
					new TestappWeaveLaunchGen().generate(new String[]{getProjectName(), TESTAPP_FOLDER, isXtext.toString()}));
			
			// create a execute.launch file
			Utils.createFileInFolder(folder, getProjectName() + "." +  TESTAPP_EXECUTE_LAUNCH_SUFFIX, 
					new TestappExecuteLaunchGen().generate(new String[]{getProjectName(), TESTAPP_FOLDER}));
		}
	}
	public class AMTSrcFolder extends SrcFolder {
		private String testcaseName;
		
		public AMTSrcFolder(String name, String packageName, String testcaseName) {
			super(name, packageName);
			this.testcaseName = testcaseName;
		}
		/**
		 * Creates a src folder within the project, with a package that holds
		 * a single test case.
		 */
		public void commit() {
			// super creates the folder and the package
			super.commit(getJavaProject());
			
			// generate a test case within the package
			StringBuffer buffer = new StringBuffer();
			buffer.append(new TestappTestCaseGen().generate(new Object[]{getPackageName(), mProj.getProjectName(), mProj.getMechanismNames()}));
			addCompilationUnit(testcaseName + ".java", buffer.toString());
		}
	}

	public static AspectMechanismTestProject create(MechanismProject mProj, boolean isXtextSupport) throws Exception {
		AspectMechanismTestProject amtProj = new AspectMechanismTestProject(mProj, isXtextSupport);				
		return amtProj;
	}

	
	private AspectMechanismTestProject(MechanismProject amProj, boolean isXtext) {
		this.mProj = amProj;
		src = new AMTSrcFolder(SRC_FOLDER, getProjectName(),  TESTCASE_NAME);
		if(isXtext) srcgen = new SrcFolder(SRC_GEN_FOLDER, null);
		lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASPECTJRT_JAR, Activator.ASPECTJTOOLS_JAR});
		testapp = new TestAppFolder(TESTAPP_FOLDER, isXtext);
		readme = new ReadmeFile();
	}
	
	@Override
	public String getProjectName() {
		return mProj.getProjectName() + ".tests";
	}
	
	public void commit(IProgressMonitor monitor) {
		// return in case that the project already exists in the workspace
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName()).exists())
			return;
		
		try {
			if(monitor != null)
				monitor.beginTask("Creating Aspect Mechanism Test Project...", 3);
			
			javaProj = Utils.createJavaProject(getProjectName());
			
			// add the am project to the classpath. This should be done before AJ deps (in lib) so it comes first in the build order
			Utils.addProjectToClassPath(getJavaProject(), mProj.getProjectName());

			lib.commit(getJavaProject());
			src.commit();
			srcgen.commit(getJavaProject());
			readme.commit(this);
			
			if(monitor != null)
				monitor.worked(1);
			
			
			Utils.addContainerToClasspath(getJavaProject(), JUNIT4_CONTAINER_PATH);
			
			// create a single testapp folder
			testapp.commit();
			
			if(monitor != null)
				monitor.worked(2);
			
			// create a 'awtrace' folder to hold the weaving trace files
			Utils.createFolder(getJavaProject(), WEAVING_INFO_FOLDER);
			
			// convert to AspectJ project
			AspectJUIPlugin.convertToAspectJProject(getJavaProject().getProject());
			AspectJUIPlugin.addAjrtToBuildPath(getJavaProject().getProject());
			
			if(monitor != null)
				monitor.done();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public IJavaProject getJavaProject() {
		return javaProj;
	}
	@Override
	public String[] getMechanismNames() {
		return mProj.getMechanismNames();
	}

}
