package awesome.ide.actions;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import awesome.ide.Activator;
import awesome.ide.gen.EndUserExecuteLaunchGen;
import awesome.ide.gen.EndUserWeaveLaunchGen;
import awesome.ide.model.LibFolder;
import awesome.ide.model.Utils;

public class AddAwesomeSupport implements IObjectActionDelegate {
	public static final String AWESOME_FOLDER = "awesome";
	public static final String XTEXT_FOLDER = "src-gen";
	public static final String AW_WEAVE_FILE = "awesome.weave.launch";
	public static final String AW_EXECUTE_FILE = "awesome.execute.launch";
	private ISelection selection;
	private Shell shell;
	
	public AddAwesomeSupport() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		// Thanks to http://www.vogella.com/articles/EclipseDialogs/article.html
		// File standard dialog
	    FileDialog fileDialog = new FileDialog(shell);
	    // Set the text
	    fileDialog.setText("Please Provide an Awesome Weaver:");
	    // Set filter on .txt files
	    fileDialog.setFilterExtensions(new String[] { "*.jar" });
	    // Open Dialog and save result of selection
	    String weaverJar = fileDialog.open();
	    
		IJavaProject project = getJavaProject();
		Utils.createSrcFolder(project, XTEXT_FOLDER);
		// create a lib folder with dependent jars. Important! the jar of the weaver
		// must come before ASPECTJTOOLS_JAR in the build order. This is guaranteed by
		// the method LibFolder.commit (see its Javadoc).
		LibFolder lib = new LibFolder();
		lib.setLocalJars(new String[]{Activator.ASPECTJTOOLS_JAR});
		lib.setExternalJars(new String[]{weaverJar});
		lib.setName(AWESOME_FOLDER);
		lib.commit(project);
		// create weave.launch
		Utils.createFileInFolder(Utils.getFolder(project, lib.getName()), 
				AW_WEAVE_FILE, new EndUserWeaveLaunchGen().generate(project.getProject().getName()));
		// create weave.execute
		Utils.createFileInFolder(Utils.getFolder(project, lib.getName()), 
				AW_EXECUTE_FILE, new EndUserExecuteLaunchGen().generate(project.getProject().getName()));
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection; 
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();		
	}
	private IJavaProject getJavaProject() {
		return (IJavaProject) ((IStructuredSelection)(selection)).getFirstElement();
	}

}
