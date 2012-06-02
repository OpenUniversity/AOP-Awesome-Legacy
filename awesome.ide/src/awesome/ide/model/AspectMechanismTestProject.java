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
import awesome.ide.gen.TestappMain;
import awesome.ide.gen.TestappTestCaseGen;

public class AspectMechanismTestProject extends MechanismProject {
	private static final String TESTAPP_PACKAGE = "testapps";
	private static final String TESTAPP_ID = "1";
	private static final String TESTCASE_NAME = "Testapp";
	private static final String TESTAPP_FOLDER_NAME = "testapp";
	private static final String TESTAPP_ASPECT_NAME = "Aspect";
	private static final String ASPECTS_FOLDER_NAME = "aspects";
	private static final String BASE_FOLDER_NAME = "base";
	private static final String TESTAPP_MAIN_NAME = "Main";
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
		
		// create a Java project and convert to AspectJ project
		IJavaProject javaProj = amtProj.createJavaProject(amtProj.getName());
		AspectJUIPlugin.convertToAspectJProject(javaProj.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(javaProj.getProject());
		
		monitor.worked(1);
		
		// create the lib folder with the required jars
		String[] jars = {Activator.ASPECTJRT_JAR, Activator.ASPECTJTOOLS_JAR};
		amtProj.createLibFolder(javaProj, jars);
		
		// configure classpath
		amtProj.addContainerToClasspath(javaProj, JUNIT4_CONTAINER_PATH);
		amtProj.addProjectToClassPath(javaProj, amProj.getName());
		
		// create the source folder
		amtProj.createSrcFolder(javaProj);
		
		// create a single testapp folder
		amtProj.createTestappFolder(javaProj, TESTAPP_FOLDER_NAME + TESTAPP_ID);
		
		if(monitor != null)
			monitor.worked(2);
		
		return amtProj;
	}
	
	private void createTestappFolder(IJavaProject javaProj, String folderName) {
		try {
			IProject project = javaProj.getProject();
			IFolder folder = project.getFolder(folderName);
			folder.create(false, true, null);
			// create the ASPECTS folder:
			IFolder aspectsFolder = folder.getFolder(ASPECTS_FOLDER_NAME);
			aspectsFolder.create(false, true, null);
			InputStream source = toInputStream(new TestappAspect().generate(new String[]{ASPECTS_FOLDER_NAME, TESTAPP_ASPECT_NAME, amProj.getDsalName()}));
			aspectsFolder.getFile(TESTAPP_ASPECT_NAME + ".aj").create(source, false, null);
			// create the BASE folder:
			IFolder baseFolder = folder.getFolder(BASE_FOLDER_NAME);
			baseFolder.create(false, true, null);
			source = toInputStream(new TestappMain().generate(new String[]{BASE_FOLDER_NAME}));
			baseFolder.getFile(TESTAPP_MAIN_NAME + ".java").create(source, false, null);
			
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
		IFile testcase = pack.getFile(TESTCASE_NAME + TESTAPP_ID + ".java");
		String contents = new TestappTestCaseGen().generate(new String[]{TESTAPP_PACKAGE, TESTAPP_ID});
		testcase.create(toInputStream(contents), true, null);
		
		return srcFolder;
	}

}