package awesome.ide.model;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.osgi.framework.Bundle;

import awesome.ide.Activator;

public class LibFolder {
	private String[] jars;

	public LibFolder(String[] jars) {
		super();
		this.jars = jars;
	}

	public String[] getJars() {
		return jars;
	}
	
	public String getName() {
		return "lib";
	}
	public void commit(IJavaProject javaProject) {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		IFolder jarsFolder = javaProject.getProject().getFolder(getName());
		try {
		jarsFolder.create(false, true, null);
		
		for(String jar : jars) {
			URL fileURL = bundle.getEntry(Activator.JARS_FOLDER + "/" + jar);
			IFile newfile = jarsFolder.getFile(jar);
			newfile.create(fileURL.openStream(), true, null);
		}
		Utils.addJarsToBuildPath(javaProject, getName(), jars);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
