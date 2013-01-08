package awesome.ide.acceptance;

import static org.junit.Assert.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import awesome.ide.model.MultiMechanismProject;
import awesome.ide.model.manifests.CSManifest;


/**
 * In this acceptance test, we test the feature that generates an AspectJ
 * aspect that configures the advice order based on the composition
 * specification. The test consists of the following steps:
 * <ol>
 * <li>Creating a multi-mechanism project with a particular before 
 * advice order in the specification file.</li>
 * <li>Requesting code generation of the aspect based on the composition
 * specification.</li>
 * <li>Checking that the correct aspect reside in the configuration directory.
 *  </ol>
 * @author Oren
 *
 */
public class TestGenerationOfAdviceOrderConfigAspects {
	private MultiMechanismProject mmProj;
	@Before
	public void setUp() throws Exception {
		// step 1: creating a multi-mechanism project
		mmProj = MultiMechanismProject.create("coolajval", new String[]{"aspectj", "cool", "validate"}, false, null);
	}
	@Test
	public void theTest() throws Exception {
		// add an entry to the manifest
		CSManifest manifest = mmProj.getCompositionSpecification();
		manifest.addEntry(CSManifest.BEFORE_ADVICE_ORDER_KEY, "validate.validate cool.lock aspectj.before");
		
		// check the added entry
		assertEquals(3, manifest.getAdviceOrder(CSManifest.AdviceType.Before).size());
		
		mmProj.generateConfigurationAspects();
		
		// now check that the config folder contains a single file: BeforeAdviceOrderConfig.aj
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getProject(mmProj.getName()).getFolder(MultiMechanismProject.CONFIG_FOLDER); 
		assertTrue(folder.getFile("BeforeAdviceOrderConfig.aj").exists());
	}
	@After
	public void tearDown() throws CoreException {
		MultiMechanismProject.deleteProject(mmProj, true);
	}
}
