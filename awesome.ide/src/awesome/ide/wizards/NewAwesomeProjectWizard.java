package awesome.ide.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ajdt.ui.AspectJUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.osgi.framework.Bundle;

import awesome.ide.Activator;
import awesome.ide.gen.AspectMechanismGen;

/**
 * Thanks goes to:
 * http://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
 * 
 */

public class NewAwesomeProjectWizard extends Wizard implements INewWizard {
	private static final String AJ_FOLDER = "awesome.aj";

	public class AspectMechanismDescriptor {
		private String packageName;
		private String aspectName;
		
		public String getPackageName() {
			return packageName;
		}
		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}
		public String getAspectName() {
			return aspectName;
		}
		public void setAspectName(String aspectName) {
			this.aspectName = aspectName;
		}
	}

	private NewAwesomeProjectWizardPage page;

	public NewAwesomeProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */
	public void addPages() {
		page = new NewAwesomeProjectWizardPage();
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard.
	 */
	public boolean performFinish() {
		final String projectName = page.getProjectName();
		final String dsal1Name = page.getFirstDsalName();
		final String dsal2Name = page.getSecondDsalName();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					List<String> dsalNames = new ArrayList<String>();
					dsalNames.add(dsal1Name);
					if(!dsal2Name.equals(""))
						dsalNames.add(dsal2Name);
					
					doFinish(projectName, dsalNames, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * Code taken from 
	 * http://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
	 * @throws CoreException
	 */
	private void doFinish(String projectName, List<String> dsalNames, IProgressMonitor monitor) 
		throws CoreException {
		monitor.beginTask("Creating Awesome Project...", 2);
		
		IJavaProject project = createJavaProject(projectName);
		
		monitor.worked(1);
		
		AspectJUIPlugin.convertToAspectJProject(project.getProject());
		AspectJUIPlugin.addAjrtToBuildPath(project.getProject());
		
		// Create source folder for each DSAL, and a Java package within each.
		// An aspect (dsal weaver) is generated within each package.
		createDsalSourceFolders(dsalNames, project);
		addDsalSourceFoldersToBuildPath(dsalNames, project);
		 
		// Create the folder extmodules, and put the jars in it
		createExtmodulesFolder(project);
		
		monitor.worked(1);

	}

	private IJavaProject createJavaProject(String projectName) throws CoreException, JavaModelException {
		
		// Create a simple project of type org.eclipse.core.resources.IProject:
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		project.create(null);
		project.open(null);
		
		// Set the Java nature:
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(description, null);
		IJavaProject javaProject = JavaCore.create(project); 
	
		// Set the Java output folder:
		IFolder binFolder = project.getFolder("bin");
		binFolder.create(false, true, null);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
		
		addJavaLibrariesToClassPath(javaProject);
		
		return javaProject;
	}

	private void createExtmodulesFolder(IJavaProject javaProject) throws CoreException {
		String[] jars = {"asm-3.1.jar", "awesome.platform.jar", "commons.jar", "jrockit.jar"};
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		
		IFolder extmodules = javaProject.getProject().getFolder("extmodules");
		extmodules.create(false, true, null);
		
		for(String jar : jars) {
			URL fileURL = bundle.getEntry("resources/" + jar);
			IFile newfile = extmodules.getFile(jar);
			try {
				newfile.create(fileURL.openStream(), true, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// add the jars in extmodules to the build path:
		addExtmodulesJarsToBuildPath(javaProject);
	}

	private void createDsalSourceFolders(List<String> dsalNames, IJavaProject javaProject) 
		throws CoreException, JavaModelException {
		
		IFolder ajSourceFolder = javaProject.getProject().getFolder(AJ_FOLDER);
		ajSourceFolder.create(false, true, null);
		IPackageFragmentRoot src = javaProject.getPackageFragmentRoot(ajSourceFolder);
		IPackageFragment pack = src.createPackageFragment(AJ_FOLDER, false, null);
		AspectMechanismDescriptor desc = new AspectMechanismDescriptor();
		desc.setPackageName(AJ_FOLDER);
		desc.setAspectName("AJMechanism");
		StringBuffer buffer = new StringBuffer();
		buffer.append(new AspectMechanismGen().generate(desc));
		pack.createCompilationUnit("AJMechanism.aj", buffer.toString(), false, null);
		
		for(String dsalName: dsalNames){
			IFolder dsalSourceFolder = javaProject.getProject().getFolder("awesome." + dsalName.toLowerCase());
			dsalSourceFolder.create(false, true, null);
			
			src = javaProject.getPackageFragmentRoot(dsalSourceFolder);
			pack = src.createPackageFragment("awesome." + dsalName.toLowerCase(), false, null);
			
			desc.setPackageName("awesome." + dsalName.toLowerCase());
			desc.setAspectName(dsalName + "Mechanism");
			buffer = new StringBuffer();
			buffer.append(new AspectMechanismGen().generate(desc));
			pack.createCompilationUnit(dsalName + "Mechanism.aj", buffer.toString(), false, null);
		}
	}

	private void addExtmodulesJarsToBuildPath(IJavaProject javaProject) {
		String[] jars = {"asm-3.1.jar", "awesome.platform.jar", "commons.jar", "jrockit.jar"};
		
		IClasspathEntry[] originalCP;
		try {
			for(String jar : jars){
				originalCP = javaProject.getRawClasspath();
				IPath path = new Path(javaProject.getPath() + "/extmodules/" + jar);
				
				IClasspathEntry lib;
				// add awesome.platform.jar to inpath (we saw in our eyes the value needed)
				if(jar.equals("awesome.platform.jar")){
					IClasspathAttribute att = JavaCore.newClasspathAttribute("org.eclipse.ajdt.inpath", "org.eclipse.ajdt.inpath");
					lib = JavaCore.newLibraryEntry(path, null, null, null, new IClasspathAttribute[]{att}, true);
				} else {
					lib = JavaCore.newLibraryEntry(path, null, null);
				}
				
				int originalCPLength = originalCP.length;
				IClasspathEntry[] newCP = new IClasspathEntry[originalCPLength + 1];
				System.arraycopy(originalCP, 0, newCP, 0, originalCPLength);
				newCP[originalCPLength] = lib;
				javaProject.setRawClasspath(newCP, new NullProgressMonitor());
			}
			
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addJavaLibrariesToClassPath(IJavaProject javaProject) throws JavaModelException {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
		 entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
		}
		//add libs to project class path
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}

	private void addDsalSourceFoldersToBuildPath(List<String> dsalNames, IJavaProject javaProject)
			throws JavaModelException {
		IFolder ajSourceFolder = javaProject.getProject().getFolder(AJ_FOLDER);
		IPackageFragmentRoot proot = javaProject.getPackageFragmentRoot(ajSourceFolder);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
		javaProject.setRawClasspath(newEntries, null);
		
		for(String dsalName: dsalNames){
			IFolder dsalSourceFolder = javaProject.getProject().getFolder("awesome." + dsalName.toLowerCase());
			proot = javaProject.getPackageFragmentRoot(dsalSourceFolder);
			oldEntries = javaProject.getRawClasspath();
			newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(proot.getPath());
			javaProject.setRawClasspath(newEntries, null);
		}
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}