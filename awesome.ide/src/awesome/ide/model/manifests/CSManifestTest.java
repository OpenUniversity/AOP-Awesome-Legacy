package awesome.ide.model.manifests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CSManifestTest {
	private static String NL = "\n";
	private String contents =
		"before-advice-order: a.before_adv1 b.before_adv2" + NL +
		"after-advice-order: b.after_adv1 a.after_adv2";
	private CSManifest manifest;
	
	@Before
	public void setUp() {
		manifest = new CSManifest(contents);
	}

	@Test
	public void testEntries() throws IOException {
		List<ManifestEntry> entries = manifest.getEntries();
		
		assertEquals(2, entries.size());
		assertEquals("before-advice-order", entries.get(0).getKey());
		assertEquals("a.before_adv1 b.before_adv2", entries.get(0).getValue());
		assertEquals("after-advice-order", entries.get(1).getKey());
		assertEquals("b.after_adv1 a.after_adv2", entries.get(1).getValue());
	}
	@Test
	public void testBeforeAdviceOrder() throws IOException {
		List<Advice> advice = manifest.getAdviceOrder(CSManifest.AdviceType.Before);
		
		assertEquals(2, advice.size());
		assertEquals("a", advice.get(0).getMechanism());
		assertEquals("before_adv1", advice.get(0).getType());
		assertEquals("b", advice.get(1).getMechanism());
		assertEquals("before_adv2", advice.get(1).getType());
	}
	@Test
	public void testAfterAdviceOrder() throws IOException {
		List<Advice> advice = manifest.getAdviceOrder(CSManifest.AdviceType.After);
		
		//b.after_adv1 a.after_adv2
		assertEquals(2, advice.size());
		assertEquals("b", advice.get(0).getMechanism());
		assertEquals("after_adv1", advice.get(0).getType());
		assertEquals("a", advice.get(1).getMechanism());
		assertEquals("after_adv2", advice.get(1).getType());
	}
}
