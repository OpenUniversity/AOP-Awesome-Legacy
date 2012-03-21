package awesome.ide.model.manifests;

public class CompositionSpecificationManifest extends AwesomeManifest {
	private static final String BEFORE_ADVICE_ORDER_KEY = "before-advice-order";
	private static final String AFTER_ADVICE_ORDER_KEY = "after-advice-order";
	
	public CompositionSpecificationManifest(String contents) {
		super(contents);
	}
}
