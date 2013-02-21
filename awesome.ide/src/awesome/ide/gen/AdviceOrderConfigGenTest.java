package awesome.ide.gen;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import awesome.ide.model.manifests.Advice;
import awesome.ide.model.manifests.CSManifest;


/**
 * This is a test for the AdviceOrderGen class. The class generates
 * an AspectJ configuration aspect based on the composition specification. Specifically,
 * an aspect that configures the specified advice order.
 * @author Oren
 *
 */
public class AdviceOrderConfigGenTest {
	private static final String NL = System.getProperties().getProperty("line.separator");
	public static final String CS_CONTENT = 
		"before-advice-order: validate.validate cool.lock aspectj.before";
	public static final String EXPECTED =
		"public aspect BeforeAdviceOrderConfig {" + NL +
		"	List around(MultiMechanism mm, List multiEffects, BcelShadow shadow):" + NL +
		"		execution(List MultiMechanism.multiOrderBefore(List, BcelShadow))" + NL +
		"			&& this(mm) && args(multiEffects, shadow) {" + NL +
		NL +
		"			int validatePos = mm.getMechanismPos(ValidateMechanism.class);" + NL +
		"			int coolPos = mm.getMechanismPos(CoolMechanism.class);" + NL +
	    "			int aspectjPos = mm.getMechanismPos(AspectjMechanism.class);" + NL +
		"			List<IEffect> result = new ArrayList<IEffect>();" + NL +
		NL +
		"			// multiEffects is a List of List<IEffect>" + NL +
		"			List<IEffect> validateEffects = (List<IEffect>)multiEffects.get(validatePos);" + NL +
		"			List<IEffect> coolEffects = (List<IEffect>)multiEffects.get(coolPos);" + NL +
		"			List<IEffect> aspectjEffects = (List<IEffect>)multiEffects.get(aspectjPos);" + NL +
		NL +
	    "			// setting the desired advice order" + NL +
	    "			result.addAll(validateEffects);" + NL +
	    "			result.addAll(coolEffects);" + NL +
	    "			result.addAll(aspectjEffects);" + NL +
	    NL +
	    "			return result;" + NL +
		"}";


	
	@Test
	public void testGenerate() throws Exception {
		AdviceOrderConfigGen gen = new AdviceOrderConfigGen();
		List<Advice> advice = new CSManifest(CS_CONTENT).getAdviceOrder(CSManifest.BEFORE_ADVICE);
		List<String> mechanisms = getMechanismsCapitalized(advice);
		Object[] argument = new Object[]{advice, mechanisms};
		assertEquals(EXPECTED, gen.generate(argument));
	}
	private List<String> getMechanismsCapitalized(List<Advice> advice) {
		List<String> result = new LinkedList<String>();
		for(Advice adv : advice)
			if(!result.contains(capitalize(adv.getMechanism()))) result.add(capitalize(adv.getMechanism()));
		return result;
	}
	private String capitalize(String str) {
		char[] stringArray = str.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		return new String(stringArray);
	}
}
