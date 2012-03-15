package awesome.ide.model.manifests;

public class AspectMechanismManifest extends AbstractManifest {
	private static final String MECHANISM_ID_KEY = "mechanism-id";
	private static final String ASPECT_KEY = "aspect";
	private static final String GRANULARITY_KEY = "granularity";
	private static final String ADVICE_TYPES_KEY = "advice-types";
	
	public AspectMechanismManifest(String contents) {
		super(contents);
	}	
	@Override
	protected ManifestEntry getEntryByKey(String key) {
		if( key.equals(MECHANISM_ID_KEY) ) {
			return new MechanismIdEntry();
		}
		if( key.equals(ASPECT_KEY) ) {
			return new AspectEntry();
		}
		if( key.equals(GRANULARITY_KEY) ) {
			return new GranularityEntry();
		}
		if( key.equals(ADVICE_TYPES_KEY) ) {
			return new AdviceTypesEntry();
		}
		return null;
	}
}
