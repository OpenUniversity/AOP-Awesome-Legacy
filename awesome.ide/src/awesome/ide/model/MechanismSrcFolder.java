package awesome.ide.model;

import org.eclipse.jdt.core.IJavaProject;
import awesome.ide.gen.AspectMechanismGen;

public class MechanismSrcFolder extends SrcFolder {

	private String mechanismId;

	public String getMechanismId() {
		return mechanismId;
	}
	public MechanismSrcFolder(String folderName, String mechanismId) {
		super(folderName, AspectMechanismProject.PROJ_PREFIX + "." + mechanismId);
		this.mechanismId = mechanismId;
	}
	@Override
	public void commit(IJavaProject project) {
		super.commit(project);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(new AspectMechanismGen().generate(new String[]{getPackageName(), 
				Utils.capitalize(getMechanismId()) + "Mechanism", getMechanismId()}));
		addCompilationUnit(Utils.capitalize(getMechanismId()) + "Mechanism" + ".aj", buffer.toString());
	}

}
