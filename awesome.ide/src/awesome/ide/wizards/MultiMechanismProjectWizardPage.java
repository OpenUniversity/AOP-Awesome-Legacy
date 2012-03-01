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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class MultiMechanismProjectWizardPage extends WizardPage {
	private Text projectNameText;

	private Text dsalsText;

	private Text dsal2NameText;

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
		projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		projectNameText.setLayoutData(gd);
		projectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});


		label = new Label(container, SWT.NULL);
		label.setText("&DSALs (Comma Separated):");

		dsalsText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		dsalsText.setLayoutData(gd);
		dsalsText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
//		label = new Label(container, SWT.NULL);
//		label.setText("&Second DSAL Name (Optional):");
//		
//		dsal2NameText = new Text(container, SWT.BORDER | SWT.SINGLE);
//		gd = new GridData(GridData.FILL_HORIZONTAL);
//		dsal2NameText.setLayoutData(gd);
		
		dialogChanged();
		setControl(container);
	}

	private void dialogChanged() {
		String dsalsText = getDsalsText();

		if (getProjectName().length() == 0) {
			updateStatus("A name for the project must be specified");
			return;
		}
		// list of DSALs should not contains spaces
		if(dsalsText.indexOf(' ') != -1) {
			updateStatus("The list of DSALs should not contains spaces");
			return;
		}
		if(dsalsText.indexOf(',') == -1 || dsalsText.split(",").length < 2) {
			updateStatus("At least two DSALs should be specified");
			return;
		}
		// the corresponding project of each DSAL should exist in the workspace
		String[] dsals = dsalsText.split(",");
		for(String dsal : dsals) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject("awm." + dsal.toLowerCase());
			if(!project.exists()) {
				updateStatus("Aspect mechanism project " + "awm." + dsal.toLowerCase() + " does not exist in the workspace");
				return;
			}
		}
	
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectName() {
		return projectNameText.getText();
	}

	/**
	 * @return the dsals to be composed that were entered by the user
	 */
	private String getDsalsText() {
		return dsalsText.getText();
	}
	public String[] getDsalNames() {
		return getDsalsText().split(",");
	}
}