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

import awesome.ide.model.AspectMechanismProject;
import awesome.ide.model.AspectMechanismTestProject;

/**
 * Thanks to:
 * http://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
 * 
 */
public class AspectMechanismProjectWizard extends Wizard implements INewWizard {

	private AspectMechanismProjectWizardPage page;

	public AspectMechanismProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */
	public void addPages() {
		page = new AspectMechanismProjectWizardPage();
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard.
	 */
	public boolean performFinish() {
		final String dsalName = page.getMechanismName();
		final boolean isXtext = page.isXtextSupport();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(dsalName, isXtext, monitor);
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
	
	private void doFinish(String dsalName, boolean isXtext, IProgressMonitor monitor) 
		throws Exception {
		AspectMechanismProject amProj = AspectMechanismProject.create(dsalName);
		amProj.commit(monitor);
		AspectMechanismTestProject amtProj = AspectMechanismTestProject.create(amProj, isXtext);
		amtProj.commit(monitor);
	}
	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}