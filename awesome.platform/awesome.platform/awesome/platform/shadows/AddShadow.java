package awesome.platform.shadows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import awesome.platform.utils.TextFile;

public class AddShadow {
	public static final String SHADOW_SPEC_FILE = "Shadows.Spec";
	public static final String MY_PACKAGE_PATH = "awesome.platform/awesome/platform/shadows/";
	public static final String ID_PREFIX = "ID:";
	public static final String INSTRUCTION_SET_PREFIX = "INSTRUCTION_SET:";
	
	
	/**
	 * For each of the shadow specifications found in SHADOW_SPEC_FILE,
	 * produces an aspect that adds the shadow. The aspects are stored in this package.
	 * @param args
	 */
	public static void main(String[] args) {
		TextFile specFile = new TextFile(new File(MY_PACKAGE_PATH + SHADOW_SPEC_FILE).getPath());
		List<ShadowSpec> shadowSpecs = new ArrayList<ShadowSpec>();
		
		for(int i=0; i < specFile.size(); i++) {
			String line = specFile.get(i);
			
			if(line.equals(""))
				continue;
			if(line.startsWith(ID_PREFIX)) {	// parse the content of this and next line and set a new spec.
				ShadowSpec spec = new ShadowSpec();
				spec.setId(line.split(":")[1].trim());
				line = specFile.get(++i);
				if(line.startsWith(INSTRUCTION_SET_PREFIX)) {
					String rawOpcodes = line.split(":")[1].trim();
					List<String> opcodes = new ArrayList<String>();
					// removing the curly braces, leading/trailing spaces from each opcode, and then insert to opcodes: 
					for(String opcode : rawOpcodes.substring(1, rawOpcodes.length()-1).split(",")) {
						opcodes.add(opcode.trim());
					}
					spec.setOpcodes(opcodes);
					shadowSpecs.add(spec);
				} else {
					throw new RuntimeException("Bad format for file " + SHADOW_SPEC_FILE + ": " + INSTRUCTION_SET_PREFIX + " expected" + " (line " + ++i + ")");
				}			
			}	
		}
		
		// here we have all shadows specifications within shadowSpecs.
		for(ShadowSpec spec : shadowSpecs) {
			new AddShadowWriter(spec).write();
		}
	}

}
