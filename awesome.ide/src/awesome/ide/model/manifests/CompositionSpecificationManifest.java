package awesome.ide.model.manifests;

public class CompositionSpecificationManifest extends AbstractManifest {
	private static final String BEFORE_ADVICE_ORDER_KEY = "before-advice-order";
	private static final String AFTER_ADVICE_ORDER_KEY = "after-advice-order";
	
	public CompositionSpecificationManifest(String contents) {
		super(contents);
	}

	@Override
	protected ManifestEntry getEntryByKey(String key) {
		if( key.equals(BEFORE_ADVICE_ORDER_KEY) ) {
			return new BeforeAdviceOrderEntry();
		}
		if( key.equals(AFTER_ADVICE_ORDER_KEY) ) {
			return new AfterAdviceOrderEntry();
		}
		return null;
	}
}
