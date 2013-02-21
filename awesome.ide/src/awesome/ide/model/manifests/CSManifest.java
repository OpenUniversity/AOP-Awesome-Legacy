package awesome.ide.model.manifests;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import awesome.ide.model.MultiMechanismProject;

public class CSManifest extends AwesomeManifest {
	// note: when adding a new key update the keyIsNotKnown method!
	/**
	 * Legal values are mechanism names, e.g., before-advice-order: aspectj cool
	 */
	public static final String BEFORE_ADVICE_ORDER_KEY = "before-advice-order";
	/**
	 * Legal values are mechanism names, e.g., after-advice-order: aspectj cool
	 */
	public static final String AFTER_ADVICE_ORDER_KEY = "after-advice-order";
	/**
	 * Legal values are mechanism names, e.g., around-advice-order: aspectj cool
	 */
	public static final String AROUND_ADVICE_ORDER_KEY = "around-advice-order";
	
	public static final String BEFORE_ADVICE = "before";
	public static final String AFTER_ADVICE = "after";
	public static final String AROUND_ADVICE = "around";
	
	/**
	 * This constructor creates a composition specification that is not connected
	 * to any particular multi-mechanism project. It should probably used for
	 * testing purposes only.
	 * @param contents
	 */
	public CSManifest(String contents) {
		super(contents);
	}

	public CSManifest(MultiMechanismProject mmProject) {
		super(mmProject);
	}

	public List<Advice> getAdviceOrder(String adviceType) throws Exception {
		ManifestEntry entry = null;
		
		if(adviceType.equals(BEFORE_ADVICE))
			entry = super.getEntry(BEFORE_ADVICE_ORDER_KEY);
		else if(adviceType.equals(AFTER_ADVICE))
			entry = super.getEntry(AFTER_ADVICE_ORDER_KEY);
		else if(adviceType.equals(AROUND_ADVICE))
			entry = super.getEntry(AROUND_ADVICE_ORDER_KEY);
		
		if(entry == null)
			return null;
		
		List<Advice> result = new LinkedList<Advice>();
		String[] mechanisms = entry.getValue().split(" "); // entry is in the form "before-advice-order: a.before_adv1 b.before_adv2"
		
		for(String mech : mechanisms) {
			Advice advice = new Advice();
			advice.setMechanism(mech);
			if(entry.getKey().equals(BEFORE_ADVICE_ORDER_KEY))
				advice.setType(BEFORE_ADVICE);
			else if(entry.getKey().equals(AFTER_ADVICE_ORDER_KEY))
				advice.setType(AFTER_ADVICE);
			else if(entry.getKey().equals(AROUND_ADVICE_ORDER_KEY))
				advice.setType(AROUND_ADVICE);
			
			result.add(advice);
		}
		
		return result;
	}

	protected boolean keyIsNotKnown(String key) {
		if(!key.equals(BEFORE_ADVICE_ORDER_KEY) && !key.equals(AROUND_ADVICE_ORDER_KEY) && !key.equals(AFTER_ADVICE_ORDER_KEY))
			return true;
		else
			return false;
	}

	@Override
	public IPath getPath() {
		return new Path(MultiMechanismProject.SPEC_FOLDER + "/" + MultiMechanismProject.COMP_SPEC_FILE);
	}
}
