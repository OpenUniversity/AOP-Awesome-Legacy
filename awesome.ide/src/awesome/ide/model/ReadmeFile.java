package awesome.ide.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import awesome.ide.gen.AMReadmeGen;
import awesome.ide.gen.AMTestReadmeGen;

public class ReadmeFile {
	public String getName() {
		return "README";
	}
	public void commit(MechanismProject mechProj) {
		String content;
		IProject project = mechProj.getJavaProject().getProject();
		if(mechProj.getClass() == AspectMechanismTestProject.class)
			content = new AMTestReadmeGen().generate(mechProj);
		else
			content = new AMReadmeGen().generate(mechProj);
			
		try {
			project.getFile(getName()).create(Utils.toInputStream(content), true, null);
		} catch (CoreException e) {
			 throw new RuntimeException("Failed to create " + getName() + " file in project");
		}
	}
}
