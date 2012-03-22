package awesome.ide.model.manifests;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSManifest extends AwesomeManifest {
	private static final String BEFORE_ADVICE_ORDER_KEY = "before-advice-order";
	private static final String AFTER_ADVICE_ORDER_KEY = "after-advice-order";
	private static final String AROUND_ADVICE_ORDER_KEY = "after-advice-order";

	public enum AdviceType {
		Before,
		After,
		Around
	}
	
	public CSManifest(String contents) {
		super(contents);
	}

	public List<Advice> getAdviceOrder(AdviceType type) throws IOException {
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
}
