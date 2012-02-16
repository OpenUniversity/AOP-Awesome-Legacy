package awesome.ide.wizards;

public class AspectMechanismDescriptor {
	private String packageName;
	private String aspectName;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getAspectName() {
		return aspectName;
	}
	public void setAspectName(String aspectName) {
		this.aspectName = aspectName;
	}
}
