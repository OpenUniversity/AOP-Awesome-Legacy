package awesome.ide.model;

import java.io.InputStream;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.Activator;
import awesome.ide.gen.TestappAspect;
import awesome.ide.gen.TestappLaunchGen;
import awesome.ide.gen.TestappMain;
import awesome.ide.gen.TestappTestCaseGen;

public class AspectMechanismTestProject extends MechanismProject {
	private static final String TESTAPP_PACKAGE = "testapps";
	private static final String TESTAPP_ID = "1";
	private static final String TESTCASE_PREFIX = "Testapp";
	private static final String TESTAPP_PREFIX = "testapp";
	private static final String ASPECTS_FOLDER = "aspects";
	private static final String BASE_FOLDER = "base";
	private static final String TESTAPP_MAIN = "Main";
	private static final String TESTAPP_LAUNCH = TESTAPP_PREFIX + TESTAPP_ID + ".weave.launch";
	private static final String WEAVING_TRACE_FOLDER = "awtrace";
	private AspectMechanismProject amProj;
	
	private AspectMechanismTestProject(AspectMechanismProject amProj) {
		this.amProj = amProj;
	}
	
	@Override
	public String getName() {
		return amProj.getName() + ".tests";
	}

	public static AspectMechanismTestProject create(AspectMechanismProject amProj, IProgressMonitor monitor) throws Exception {
		AspectMechanismTestProject amtProj = new AspectMechanismTestProject(amProj);
		
		// return in case that the project already exists in the workspace
		if(ResourcesPlugin.getWorkspace().getRoot().getProject(amtProj.getName()).exists())
			return amtProj;
		
		if(monitor != null)
			monitor.beginTask("Creating Aspect Mechanism Test Project...", 3);
		
		// create a Java project
		IJavaProject javaProj = amtProj.createJavaProject(amtProj.getName());

		// add the am project to the classpath. This should be done before AJ deps so it comes first in the build order
		amtProj.addProjectToClassPath(javaProj, amProj.getName());
		
		// convert to AspectJ project
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		monitor.worked(1);
		
		// create the lib folder with the required jars
		String[] jars = {Activator.ASPECTJRT_JAR, Activator.ASPECTJTOOLS_JAR};
		amtProj.createLibFolder(javaProj, jars);
		
		// configure classpath
		amtProj.addContainerToClasspath(javaProj, JUNIT4_CONTAINER_PATH);
		
		// create the source folder
		amtProj.createSrcFolder(javaProj);
		
		// create a single testapp folder
		amtProj.createTestappFolder(javaProj, TESTAPP_PREFIX + TESTAPP_ID);
		
		// create a 'awtrace' folder to hold the weaving trace files
		amtProj.createWeavingTraceFolder(javaProj);
		
		if(monitor != null)
			monitor.worked(2);
		
		return amtProj;
	}
	
	private void createWeavingTraceFolder(IJavaProject javaProj) {
		IProject project = javaProj.getProject();
		IFolder folder = project.getFolder(WEAVING_TRACE_FOLDER);
		try {
			folder.create(false, true, null);
		} catch (CoreException e) {
			throw new RuntimeException("Creation of folder " + WEAVING_TRACE_FOLDER + " failed");
		}
	}

	private void createTestappFolder(IJavaProject javaProj, String folderName) {
		try {
			IProject project = javaProj.getProject();
			IFolder folder = project.getFolder(folderName);
			folder.create(false, true, null);
			// create the ASPECTS folder:
			IFolder aspectsFolder = folder.getFolder(ASPECTS_FOLDER);
			aspectsFolder.create(false, true, null);
			InputStream source = toInputStream(new TestappAspect().generate(new String[]{ASPECTS_FOLDER, getTestAppAspectName(), amProj.getDsalName()}));
			aspectsFolder.getFile(getTestAppAspectName() + ".java").create(source, false, null);
			// create the BASE folder:
			IFolder baseFolder = folder.getFolder(BASE_FOLDER);
			baseFolder.create(false, true, null);
			source = toInputStream(new TestappMain().generate(new String[]{BASE_FOLDER}));
			baseFolder.getFile(TESTAPP_MAIN + ".java").create(source, false, null);
			// create a launch configuration file
			source = toInputStream(new TestappLaunchGen().generate(new String[]{getName(), TESTAPP_PREFIX + TESTAPP_ID}));
			folder.getFile(TESTAPP_LAUNCH).create(source, false, null);
			
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected IFolder createSrcFolder(IJavaProject javaProj) throws CoreException {
		IFolder srcFolder = super.createSrcFolder(javaProj);
		IFolder pack = srcFolder.getFolder(TESTAPP_PACKAGE);
		pack.create(false, true, null);
		// create a JUnit test case for the testapp
		IFile testcase = pack.getFile(TESTCASE_PREFIX + TESTAPP_ID + ".java");
		String contents = new TestappTestCaseGen().generate(new String[]{TESTAPP_PACKAGE, TESTAPP_ID, getTestAppAspectName()});
		testcase.create(toInputStream(contents), true, null);
		
		return srcFolder;
	}
	private String getTestAppAspectName() {
		return capitalize(amProj.getDsalName()) + "Aspect";
	}

}
