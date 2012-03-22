package awesome.ide.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import awesome.ide.model.MultiMechanismProject;

public class GenerateFromSpecificationAction implements IObjectActionDelegate {

	private ISelection selection;
	
	public GenerateFromSpecificationAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		MultiMechanismProject mmProj = MultiMechanismProject.getProject(getProject().getName());
		try {
			mmProj.generateConfigurationAspects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection; 
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}
	private IProject getProject() {
		return (IProject) ((IStructuredSelection)(selection)).getFirstElement();
	}

}
