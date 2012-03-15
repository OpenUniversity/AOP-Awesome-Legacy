package awesome.ide.model.manifests;

public abstract class ManifestEntry {
	private String key;
	private String value;
	public enum Kind {
		MECHANISM_ID_ENTRY,
		ASPECT_ENTRY,
		GRANULARITY_ENTRY,
		ADVICE_TYPES_ENTRY,
		BEFORE_ADVICE_ORDER_ENTRY,
		AFTER_ADVICE_ORDER_ENTRY
	}
	
	public abstract ManifestEntry.Kind getKind();
	
	protected String getKey() {
		return key;
	}
	protected void setKey(String key) {
		this.key = key;
	}
	protected String getValue() {
		return value;
	}
	protected void setValue(String value) {
		this.value = value;
	}
}
