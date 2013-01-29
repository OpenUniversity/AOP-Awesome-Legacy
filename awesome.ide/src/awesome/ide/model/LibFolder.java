package awesome.ide.model;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.osgi.framework.Bundle;

import awesome.ide.Activator;

public class LibFolder {
	private String[] localJars = new String[]{};
	private String[] externalJars = new String[]{};
	private String name;

	public LibFolder() {
		super();
		name = "lib";
	}
	/**
	 * Use this method to add jars defined as constants in awesome.ide.Activator.
	 * @param jars
	 */
	public void setLocalJars(String[] jars) {
		localJars = jars;
	}
	/**
	 * Use this method to add jars in the local file system.
	 * @param externalJars
	 */
	public void setExternalJars(String[] externalJars) {
		this.externalJars = externalJars;
	}
	public String[] getJars() {
		return localJars;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	/**
	 * Note that external jars are added to the build path before local jars.
	 * This allows the user for some control... e.g., when an Awesome support
	 * is added we want the external weaver's jar to precede local jars.
	 * @param javaProject
	 */
	public void commit(IJavaProject javaProject) {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		IFolder jarsFolder = javaProject.getProject().getFolder(getName());
		try {
		jarsFolder.create(false, true, null);
		
		for(String jar : externalJars) {
			URL fileURL = new File(jar).toURI().toURL();
			InputStream is = fileURL.openStream();
			IFile newfile = jarsFolder.getFile(getJarSimpleName(jar));
			newfile.create(is, true, null);
			is.close();
			Utils.addJarToBuildPath(javaProject, getName(), getJarSimpleName(jar));
		}
		for(String jar : localJars) {
			URL fileURL = bundle.getEntry(Activator.JARS_FOLDER + "/" + jar);
			IFile newfile = jarsFolder.getFile(jar);
			InputStream is = fileURL.openStream();
			newfile.create(is, true, null);
			is.close();
			Utils.addJarToBuildPath(javaProject, getName(), jar);
		}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	private String getJarSimpleName(String jar) {
		String[] split = jar.split("/");
		return split[split.length-1];
	}
}
