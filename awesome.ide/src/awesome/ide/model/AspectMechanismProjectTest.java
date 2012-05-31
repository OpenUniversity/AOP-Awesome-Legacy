package awesome.ide.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AspectMechanismProjectTest {
	//private String dsalName;
	private AspectMechanismProject amProj;
	@Before
	public void setUp() throws Exception {
		//dsalName = "Validate" + new Random().nextInt(100000);
		amProj = AspectMechanismProject.create("Validate", null);
		//System.out.println("Created project " + amProj.getName() + "...");
	}
	@After
	public void tearDown() throws CoreException {
		//System.out.println("Deleting project " + amProj.getName() + "...");
		AspectMechanismProject.deleteProject(amProj, true);
	}
	@Test
	public void testProjectCreation() {
		// check that the project exists in the workspace
		assertTrue(ResourcesPlugin.getWorkspace().getRoot().getProject(amProj.getName()).exists());
	}
	@Test
	public void testProjectDeletion() throws CoreException {
		AspectMechanismProject.deleteProject(amProj, true);
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
