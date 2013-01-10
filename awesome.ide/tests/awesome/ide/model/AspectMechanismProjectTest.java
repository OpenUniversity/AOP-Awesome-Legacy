package awesome.ide.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import awesome.ide.Activator;

public class AspectMechanismProjectTest {
	@Before
	public void setUp() {
		
	}
	@Test
	public void test() {
		AspectMechanismProject project = AspectMechanismProject.create("Comprendo");
		
		// test src folder
		MechanismSrcFolder src = project.getSrcFolder();
		assertEquals("src", src.getName());
		assertEquals("awm.comprendo", src.getPackageName());
		
		// test lib folder
		LibFolder lib = project.getLibFolder();
		assertEquals("lib", lib.getName());
		String[] jars = new String[]{Activator.ASM_JAR, Activator.AWESOME_JAR, Activator.COMMONS_JAR, Activator.JROCKIT_JAR, Activator.ASPECTJTOOLS_JAR};
		assertTrue(Arrays.equals(jars, lib.getJars()));
		
		// test ant file
		AntFile ant = project.getAntFile();
		assertEquals("build.xml", ant.getName());
		
		// test the manifest
		AspectMechanismProject.ManifestFile manifest = project.getManifestFile();
		assertEquals("comprendo.manifest", manifest.getName());
	}

}
