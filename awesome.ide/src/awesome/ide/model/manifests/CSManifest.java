package awesome.ide.model.manifests;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import awesome.ide.model.MultiMechanismProject;

public class CSManifest extends AwesomeManifest {
	// note: when adding a new key update the keyIsNotKnown method!
	public static final String BEFORE_ADVICE_ORDER_KEY = "before-advice-order";
	public static final String AFTER_ADVICE_ORDER_KEY = "after-advice-order";
	public static final String AROUND_ADVICE_ORDER_KEY = "after-advice-order";

	public enum AdviceType {
		Before,
		After,
		Around
	}
	
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

	public List<Advice> getAdviceOrder(AdviceType type) throws Exception {
		ManifestEntry entry = null;
		switch(type) {
		case Before:
			entry = super.getEntry(BEFORE_ADVICE_ORDER_KEY); break;
		case After:
			entry = super.getEntry(AFTER_ADVICE_ORDER_KEY); break;
		case Around:
			entry = super.getEntry(AROUND_ADVICE_ORDER_KEY); break;
		}
		
		if(entry == null)
			return null;
		
		List<Advice> result = new LinkedList<Advice>();
		String[] values = entry.getValue().split(" "); // entry is in the form "before-advice-order: a.before_adv1 b.before_adv2"
		
		for(String value : values) {
			Advice advice = new Advice();
			advice.setMechanism(value.split("\\.")[0]);
			advice.setType(value.split("\\.")[1]);
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
