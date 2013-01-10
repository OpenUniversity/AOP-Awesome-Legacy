package awesome.ide.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;

import awesome.ide.gen.AntFileGen;

public class AntFile {
	public String getName() {
		return "build.xml";
	}
	public void commit(IJavaProject javaProj) {
		String content;
		IProject project = javaProj.getProject();
		content = new AntFileGen().generate(new String[]{project.getName()});
		try {
			project.getFile(getName()).create(Utils.toInputStream(content), true, null);
		} catch (CoreException e) {
			 throw new RuntimeException("Failed to create ant file in project");
		}
	}
}
