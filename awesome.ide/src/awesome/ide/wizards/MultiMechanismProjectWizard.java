package awesome.ide.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import awesome.ide.model.AspectMechanismTestProject;
import awesome.ide.model.MultiMechanismProject;

/**
 * Thanks goes to:
 * http://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
 * 
 */
public class MultiMechanismProjectWizard extends Wizard implements INewWizard {
	
	private MultiMechanismProjectWizardPage page;

	public MultiMechanismProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */
	public void addPages() {
		page = new MultiMechanismProjectWizardPage();
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard.
	 */
	public boolean performFinish() {
		final String projectName = page.getProjectName();
		final String[] mechanismNames = page.getMechanismNames();
		final boolean includeAJ = page.isAspectJIncluded();
		final boolean isXtext = page.isXtextSupport();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectName, mechanismNames, includeAJ, isXtext, monitor);
				} catch (Exception e) {
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
	
	private void doFinish(String projectName, String[] mechanismNames, boolean includeAJ, boolean isXtext, IProgressMonitor monitor) 
		throws Exception {
		MultiMechanismProject mmProj = MultiMechanismProject.create(projectName, mechanismNames, includeAJ);
		mmProj.commit(monitor);
		AspectMechanismTestProject amtProj = AspectMechanismTestProject.create(mmProj, isXtext);
		amtProj.commit(monitor);
	}
	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}