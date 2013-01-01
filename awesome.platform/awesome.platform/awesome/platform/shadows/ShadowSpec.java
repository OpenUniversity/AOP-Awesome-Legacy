package awesome.platform.shadows;

import java.util.List;

/**
 * A shadow specification.
 * @author oren
 *
 */
public class ShadowSpec {
	private String id;
	private List<String> opcodes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getOpcodes() {
		return opcodes;
	}
	public void setOpcodes(List<String> opcodes) {
		this.opcodes = opcodes;
	}
	@Override
	public String toString() {
		return "ShadowSpec [id=" + id + ", opcodes=" + opcodes + "]";
	}
	
	
}
