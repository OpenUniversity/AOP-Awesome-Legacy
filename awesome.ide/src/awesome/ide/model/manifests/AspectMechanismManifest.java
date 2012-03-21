package awesome.ide.model.manifests;

public class AspectMechanismManifest extends AwesomeManifest {
	private static final String MECHANISM_ID_KEY = "mechanism-id";
	private static final String ASPECT_KEY = "aspect";
	private static final String GRANULARITY_KEY = "granularity";
	private static final String ADVICE_TYPES_KEY = "advice-types";
	
	public AspectMechanismManifest(String contents) {
		super(contents);
	}	
}
