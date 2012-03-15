package awesome.ide.model.manifests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class CompositionSpecificationManifestTest {
	private static String NL = "\n";
	private String contents =
		"before-advice-order: a.a b.b" + NL +
		"after-advice-order: b.b a.a";

	@Test
	public void testManifest() throws IOException {
		CompositionSpecificationManifest manifest = new CompositionSpecificationManifest(contents);
		List<ManifestEntry> entries = manifest.getEntries();
		
		assertEquals(2, entries.size());
		assertEquals("before-advice-order", entries.get(0).getKey());
		assertEquals("a.a b.b", entries.get(0).getValue());
		assertEquals("after-advice-order", entries.get(1).getKey());
		assertEquals("b.b a.a", entries.get(1).getValue());
		
		ManifestEntry first = entries.get(0);
		assertEquals(BeforeAdviceOrderEntry.class, first.getClass());
		
		ManifestEntry second = entries.get(1);
		assertEquals(AfterAdviceOrderEntry.class, second.getClass());
	}
}
