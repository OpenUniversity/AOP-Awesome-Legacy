package awesome.ide.model.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import awesome.ide.model.AspectMechanismProject;
import awesome.ide.model.MultiMechanismProject;


public class MultiMechanismProjectTest {
	MultiMechanismProject mmProj;
	AspectMechanismProject valProj, coolProj;
	@Before
	public void setUp() throws Exception {
		valProj = AspectMechanismProject.createProject("Validate", null);
		coolProj = AspectMechanismProject.createProject("Cool", null);
		mmProj = MultiMechanismProject.createProject("Validate", new String[]{"Validate", "Cool"}, null);
	}
	@After
	public void tearDown() throws CoreException {
		MultiMechanismProject.deleteProject(mmProj, true);
		AspectMechanismProject.deleteProject(valProj, true);
		AspectMechanismProject.deleteProject(coolProj, true);
	}
	@Test
	public void testProjectCreation() {
		// check that the project exists in the workspace
		assertTrue(ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName()).exists());
	}
	@Test
	public void testProjectDeletion() throws CoreException {
		AspectMechanismProject.deleteProject(mmProj, true);
		assertFalse(ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName()).exists());
	}
	@Test
	public void testSpecDirectory() throws CoreException {
		// test that the manifest file exists in the project
//		AspectMechanismProject.Manifest manifest = mmProj.new Manifest();
//		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName());
//		assertTrue(project.getFile(manifest.getName()).exists());
//		// test the content of the manifest file
//		String contents = "mechanism-id: validate";
//		assertEquals(contents, convertStreamToString(manifest.getContents()));
	}
	private String convertStreamToString(java.io.InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}
}
