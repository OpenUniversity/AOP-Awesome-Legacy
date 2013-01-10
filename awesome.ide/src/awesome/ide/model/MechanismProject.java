package awesome.ide.model;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;

public abstract class MechanismProject {
	protected static final String SRC_FOLDER = "src";
	protected static final String SRC_GEN_FOLDER = "src-gen";
	public static final IPath JUNIT4_CONTAINER_PATH = new Path("org.eclipse.jdt.junit.JUNIT_CONTAINER/4");
	public static final IPath JRE_CONTAINER_PATH = new Path("org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6");

	public abstract String getProjectName();
	
	/**
	 * @param busyWait try to delete again and again in case of failure (note infinite loop danger). This option is
	 * for testing purposes only. Otherwise use busyWait=false.
	 * @throws CoreException
	 */
	public static void deleteProject(MechanismProject mProj, boolean busyWait) throws CoreException {
		String name = mProj.getProjectName();
		if(!ResourcesPlugin.getWorkspace().getRoot().getProject(name).exists())
			return;
		else { 
			try {
				ResourcesPlugin.getWorkspace().getRoot().getProject(name).delete(true, null);
			} catch (CoreException e) {
				if(busyWait)
					deleteProject(mProj, true);
				else
					throw e;
			}
		}
	}
	public abstract IJavaProject getJavaProject();
}
