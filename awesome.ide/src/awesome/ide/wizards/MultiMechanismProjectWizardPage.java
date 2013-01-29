package awesome.ide.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import awesome.ide.model.AspectMechanismProject;
import awesome.ide.model.MultiMechanismProject;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class MultiMechanismProjectWizardPage extends WizardPage {
	/**
	 * A text field where the name of the project should be provided
	 */
	private Text projectName;
	/**
	 * A text field holding the names of the DSALs that should be included in the project
	 */
	private Text dsalNames;
	/**
	 * A checkbox indicating whether an AspectJ
	 * mechanism should be included in the generated project
	 */
	private Button includeAJ;
	private static final String ASPECTJ_SUPPORT_LABEL = "Include AspectJ mechanism";

	public MultiMechanismProjectWizardPage() {
		super("wizardPage");
		setTitle("New Multi-Mechanism Project");
		setDescription("This wizard creates a new multi-mechanism project");
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project Name:");
		projectName = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		projectName.setLayoutData(gd);
		projectName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});


		label = new Label(container, SWT.NULL);
		label.setText("&DSALs (Comma Separated):");

		dsalNames = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		dsalNames.setLayoutData(gd);
		dsalNames.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		includeAJ = new Button(container, SWT.CHECK);
		includeAJ.setText(ASPECTJ_SUPPORT_LABEL);
		includeAJ.setSelection(true);
		
		dialogChanged();
		setControl(container);
	}

	private void dialogChanged() {
		String dsalsText = getDsalsText();

		if(getProjectNameText().length() == 0) {
			updateStatus("A name for the project must be specified");
			return;
		}
		// list of DSALs should not contains spaces
		if(dsalsText.indexOf(' ') != -1) {
			updateStatus("The list of DSALs should not contains spaces");
			return;
		}
//		if(dsalsText.indexOf(',') == -1 || dsalsText.split(",").length < 2) {
//			updateStatus("At least two DSALs should be specified");
//			return;
//		}
		// the corresponding project of each DSAL should exist in the workspace
		if(dsalsText.length() > 0) {
			String[] dsals = dsalsText.split(",");
			for(String dsal : dsals) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IProject project = root.getProject(AspectMechanismProject.PROJ_PREFIX + "." + dsal.toLowerCase());
				if(!project.exists()) {
					updateStatus("Aspect mechanism project " + AspectMechanismProject.PROJ_PREFIX + "." + dsal.toLowerCase() + " does not exist in the workspace");
					return;
				}
			}
		}
	
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectName() {
		return MultiMechanismProject.PROJ_PREFIX + "." + projectName.getText();
	}
	private String getProjectNameText() {
		return projectName.getText();
	}
	/**
	 * @return the dsals to be composed that were entered by the user
	 */
	private String getDsalsText() {
		return dsalNames.getText();
	}
	public String[] getDsalNames() {
		return getDsalsText().split(",");
	}
	public boolean isAspectJIncluded() {
		return includeAJ.getSelection();
	}
}