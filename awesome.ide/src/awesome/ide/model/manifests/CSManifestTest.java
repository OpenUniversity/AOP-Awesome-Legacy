package awesome.ide.model.manifests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CSManifestTest {
	private static String NL = "\n";
	private String contents =
		"before-advice-order: a b" + NL +
		"after-advice-order: b a";
	private CSManifest manifest;
	
	@Before
	public void setUp() {
		manifest = new CSManifest(contents);
	}

	@Test
	public void testEntries() throws Exception {
		List<ManifestEntry> entries = manifest.getEntries();
		
		assertEquals(2, entries.size());
		assertEquals("before-advice-order", entries.get(0).getKey());
		assertEquals("a b", entries.get(0).getValue());
		assertEquals("after-advice-order", entries.get(1).getKey());
		assertEquals("b a", entries.get(1).getValue());
	}
	@Test
	public void testBeforeAdviceOrder() throws Exception {
		List<Advice> advice = manifest.getAdviceOrder(CSManifest.BEFORE_ADVICE);
		
		assertEquals(2, advice.size());
		assertEquals("a", advice.get(0).getMechanism());
		assertEquals(CSManifest.BEFORE_ADVICE, advice.get(0).getType());
		assertEquals("b", advice.get(1).getMechanism());
		assertEquals(CSManifest.BEFORE_ADVICE, advice.get(1).getType());
	}
	@Test
	public void testAfterAdviceOrder() throws Exception {
		List<Advice> advice = manifest.getAdviceOrder(CSManifest.AFTER_ADVICE);
		
		assertEquals(2, advice.size());
		assertEquals("b", advice.get(0).getMechanism());
		assertEquals(CSManifest.AFTER_ADVICE, advice.get(0).getType());
		assertEquals("a", advice.get(1).getMechanism());
		assertEquals(CSManifest.AFTER_ADVICE, advice.get(1).getType());
	}
}
