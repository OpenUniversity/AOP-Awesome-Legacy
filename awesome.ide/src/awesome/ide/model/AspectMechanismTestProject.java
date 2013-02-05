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

public class AspectMechanismTestProject extends MechanismProject {
	private static final String TESTAPP_PACKAGE = "testapps";
	private static final String TESTAPP_ID = "1";
	private static final String TESTAPP_PREFIX = "testapp";
	public static final String TESTCASE_NAME = "MyTests";
	public static final String ASPECTS_FOLDER = "aspects";
	public static final String BASE_FOLDER = "base";
	public static final String TESTAPP_MAIN = "MyBase";
	public static final String TESTAPP_ASPECT = "MyAspect";
	private static final String TESTAPP_WEAVE_LAUNCH_SUFFIX = TESTAPP_PREFIX + TESTAPP_ID + ".weave.launch";
	private static final String TESTAPP_EXECUTE_LAUNCH_SUFFIX = TESTAPP_PREFIX + TESTAPP_ID + ".execute.launch";
	public static final String WEAVING_INFO_FOLDER = "weaving-info";
	private AspectMechanismProject amProj;
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
			Utils.createFileInFolder(aspectsFolder, TESTAPP_ASPECT + ".java", 
					new TestappAspect().generate(new String[]{ASPECTS_FOLDER, TESTAPP_ASPECT, amProj.getDsalName()}));
			
			IFolder baseFolder = Utils.createSubFolder(folder, BASE_FOLDER);
			Utils.createFileInFolder(baseFolder, TESTAPP_MAIN + ".java", new TestappMain().generate(new String[]{BASE_FOLDER}));
			
			// create a weave.launch file
			Utils.createFileInFolder(folder, amProj.getDsalName() + "." + TESTAPP_WEAVE_LAUNCH_SUFFIX, 
					new TestappWeaveLaunchGen().generate(new String[]{getProjectName(), TESTAPP_PREFIX + TESTAPP_ID, isXtext.toString()}));
			
			// create a execute.launch file
			Utils.createFileInFolder(folder, amProj.getDsalName() + "." +  TESTAPP_EXECUTE_LAUNCH_SUFFIX, 
					new TestappExecuteLaunchGen().generate(new String[]{getProjectName(), TESTAPP_PREFIX + TESTAPP_ID}));
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
			buffer.append(new TestappTestCaseGen().generate(new String[]{getPackageName(), amProj.getProjectName(), amProj.getDsalName()}));
			addCompilationUnit(testcaseName + ".java", buffer.toString());				
		}
	}

	public static AspectMechanismTestProject create(AspectMechanismProject amProj, boolean isXtextSupport) throws Exception {
		AspectMechanismTestProject amtProj = new AspectMechanismTestProject(amProj, isXtextSupport);				
		return amtProj;
	}

	
	private AspectMechanismTestProject(AspectMechanismProject amProj, boolean isXtext) {
		this.amProj = amProj;
		src = new AMTSrcFolder(SRC_FOLDER, TESTAPP_PACKAGE,  TESTCASE_NAME);
		if(isXtext) srcgen = new SrcFolder(SRC_GEN_FOLDER, null);
		lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASPECTJRT_JAR, Activator.ASPECTJTOOLS_JAR});
		testapp = new TestAppFolder(TESTAPP_PREFIX + TESTAPP_ID, isXtext);
		readme = new ReadmeFile();
	}
	
	@Override
	public String getProjectName() {
		return amProj.getProjectName() + ".tests";
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
			Utils.addProjectToClassPath(getJavaProject(), amProj.getProjectName());

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
	public String getDsalName() {
		return amProj.getDsalName();
	}

}
