package awesome.ide.model.manifests;

import org.eclipse.core.runtime.IPath;

import awesome.ide.model.AspectMechanismProject;

public class AspectMechanismManifest extends AwesomeManifest {
	// note: when adding a new key update the keyIsNotKnown method!
	public static final String MECHANISM_ID_KEY = "mechanism-id";
	public static final String ASPECT_KEY = "aspect";
	public static final String GRANULARITY_KEY = "granularity";
	public static final String ADVICE_TYPES_KEY = "advice-types";
	
	/**
	 * This constructor is for testing purposes, the created
	 * manifest is not connected to any project
	 * @param contents
	 */
	public AspectMechanismManifest(String contents) {
		super(contents);
	}
	public AspectMechanismManifest(AspectMechanismProject project) {
		super(project);
	}
	@Override
	protected boolean keyIsNotKnown(String key) {
		if(!key.equals(MECHANISM_ID_KEY) && !key.equals(ASPECT_KEY) && !key.equals(GRANULARITY_KEY) && !key.equals(ADVICE_TYPES_KEY))
			return true;
		else
			return false;
	}

	@Override
	public IPath getPath() {
		// TODO Auto-generated method stub
		return null;
	}	
}
