package awesome.ide.model;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Represents a source folder of a Java project with (at most) one package.
 * Provides means to generate the folder itself (include updating the classpath),
 * and to add compilation units to the (optional) package.
 * @author oren
 *
 */
public class SrcFolder {
	private String name;
	private String packageName;
	private IPackageFragment pack;
	
	public SrcFolder(String name, String packageName) {
		this.name = name;
		this.packageName = packageName;
	}
	/**
	 * The default commit only creates the src folder itself,
	 * and the package within it (if exists).
	 */
	public void commit(IJavaProject project) {
		// create the src folder
		Utils.createSrcFolder(project, getName());
		
		// create a package within the src folder
		if(getPackageName() != null) {
			IFolder folder = project.getProject().getFolder(getName());
			IPackageFragmentRoot root = project.getPackageFragmentRoot(folder);
			try {
				pack = root.createPackageFragment(packageName, false, null);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			//IPackageFragment pack;
		}
		
//		try {
//			pack = root.createPackageFragment(packageName, false, null);
//			// generate an aspect mechanism within the package
//			StringBuffer buffer = new StringBuffer();
//			buffer.append(new AspectMechanismGen().generate(new String[]{packageName, aspectMechanismName, getDsalName()}));
//			pack.createCompilationUnit(aspectMechanismName + ".aj", buffer.toString(), false, null);
//		} catch (JavaModelException e) {
//			throw new RuntimeException(e);
//		}
		
	}
	/**
	 * Adds a compilation unit (e.g., A.java, B.aj) to the package
	 * within the src folder.
	 * @param name
	 * @param content
	 */
	public void addCompilationUnit(String name, String content) {
		try {
			pack.createCompilationUnit(name, content, false, null);
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
	}
	public String getName() {
		return name;
	}
	public String getPackageName() {
		return packageName;
	}

}
