package awesome.platform.shadows;

import awesome.platform.utils.TextFile;

/**
 * Is responsible to call the code generator and write the generated aspect code
 * within the target package.
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
		TextFile.write(AddShadow.GEN_PACKAGE_PATH + getAspectName(spec.getId()) + ".aj", code);
	}
	public static String getAspectName(String shadowId) {
		return "Add" + shadowId + "Shadow";
	}

}
