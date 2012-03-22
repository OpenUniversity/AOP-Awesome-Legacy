package awesome.ide.model.manifests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class AspectMechanismManifestTest {
	private static String NL = "\n";
	private String contents =
		"mechanism-id: cool" + NL +
		"aspect: coordinator" + NL +
		"granularity: method-invocation => execution(method)" + NL +
		"advice-types: lock => before, unlock => after";
	@Test
	public void testManifest() throws Exception {
		AspectMechanismManifest manifest = new AspectMechanismManifest(contents);
		List<ManifestEntry> entries = manifest.getEntries();
		
		assertEquals(4, entries.size());
		assertEquals("mechanism-id", entries.get(0).getKey());
		assertEquals("cool", entries.get(0).getValue());
		assertEquals("granularity", entries.get(2).getKey());
		assertEquals("method-invocation => execution(method)", entries.get(2).getValue());	
	}
}
