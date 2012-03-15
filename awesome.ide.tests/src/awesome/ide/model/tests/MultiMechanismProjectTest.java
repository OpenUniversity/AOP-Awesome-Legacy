package awesome.ide.model.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
		assertTrue(ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName()).exists());
	}
	@Test
	public void testSpecFolderCreation() {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName());
		IFolder specFolder = project.getFolder("spec");
		assertTrue(specFolder.exists());
		assertTrue(specFolder.getFile("validate.manifest").exists());
		assertTrue(specFolder.getFile("cool.manifest").exists());
		assertTrue(specFolder.getFile("composition.spec").exists());
	}
	@Test
	public void testCreationOfSourceFolders() {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName());
		
		// check that the source folder of cool exists
		IFolder coolFolder = project.getFolder("awm.cool");
		assertTrue(coolFolder.exists());
		// check that the package exists in the source folder
		IFolder coolPack = coolFolder.getFolder("awm/cool");
		// check that an aspect mechanism class exists in the package
		assertTrue(coolPack.getFile("CoolMechanism.aj").exists());
		
		// and the same for validate...
	}
	@Test
	public void testProjectDeletion() throws CoreException {
		AspectMechanismProject.deleteProject(mmProj, true);
		assertFalse(ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName()).exists());
	}
	private String convertStreamToString(java.io.InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}
}
