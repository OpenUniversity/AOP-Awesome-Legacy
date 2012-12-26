package awesome.platform.shadows;

import awesome.platform.utils.TextFile;

/**
 * The class is provided with a {@link ShadowSpec}, generates the aspect code
 * by using {@link AddShadowGen}, and then writes the aspect with that code
 * to this package.
 * @author oren
 *
 */
public class AddShadowWriter {
	private ShadowSpec spec;
	
	public AddShadowWriter(ShadowSpec spec) {
		this.spec = spec;
	}
	public void write() {
		String code = new AddShadowGen().generate(spec);
		TextFile.write(AddShadow.MY_PACKAGE_PATH + getAspectName(spec.getId()) + ".aj", code);
	}
	public static String getAspectName(String shadowId) {
		return "Add" + shadowId + "Shadow";
	}

}
