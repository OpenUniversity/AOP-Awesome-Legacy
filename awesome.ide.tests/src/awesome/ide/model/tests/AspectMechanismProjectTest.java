package awesome.ide.model.tests;

import static org.junit.Assert.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import awesome.ide.model.AspectMechanismProject;

public class AspectMechanismProjectTest {
	AspectMechanismProject amProj;
	@Before
	public void setUp() throws Exception {
		amProj = AspectMechanismProject.createProject("Validate", null);
	}
	@After
	public void tearDown() throws CoreException {
		AspectMechanismProject.deleteProject(amProj);
	}
	@Test
	public void testProjectCreation() {
		// check that the project exists in the workspace
		assertTrue(ResourcesPlugin.getWorkspace().getRoot().getProject(amProj.getName()).exists());
	}
	@Test
	public void testProjectDeletion() throws CoreException {
		AspectMechanismProject.deleteProject(amProj);
		assertFalse(ResourcesPlugin.getWorkspace().getRoot().getProject(amProj.getName()).exists());
	}
	@Test
	public void testManifest() throws CoreException {
		// test that the manifest file exists in the project
		AspectMechanismProject.Manifest manifest = amProj.new Manifest();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(amProj.getName());
		assertTrue(project.getFile(manifest.getName()).exists());
		// test the content of the manifest file
		String contents = "mechanism-id: validate";
		assertEquals(contents, convertStreamToString(manifest.getContents()));
	}
	public String convertStreamToString(java.io.InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}
}
