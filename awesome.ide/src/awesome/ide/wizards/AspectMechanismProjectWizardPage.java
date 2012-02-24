package awesome.ide.wizards;

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

public class AspectMechanismProjectWizardPage extends WizardPage {
//	private Text projectNameText;

	private Text dsalName;

//	private Text dsal2NameText;

	public AspectMechanismProjectWizardPage() {
		super("wizardPage");
		setTitle("New Aspect Mechanism Project");
		setDescription("This wizard creates a new aspect mechanism Project.");
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
		label.setText("&DSAL Name:");

//		projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
//		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
//		projectNameText.setLayoutData(gd);
//		projectNameText.addModifyListener(new ModifyListener() {
//			public void modifyText(ModifyEvent e) {
//				dialogChanged();
//			}
//		});


//		label = new Label(container, SWT.NULL);
//		label.setText("&First DSAL Name:");

		dsalName = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		dsalName.setLayoutData(gd);
		dsalName.addModifyListener(new ModifyListener() {
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
		String dsalName = getDsalName();

//		if (getProjectName().length() == 0) {
//			updateStatus("Project name must be specified");
//			return;
//		}
		if (dsalName.length() == 0) {
			updateStatus("A name for the DSAL must be specified");
			return;
		}
		if (dsalName.contains(" ")) {
			updateStatus("The name of the DSAL cannot contain spaces");
			return;
		}
		
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

//	public String getProjectName() {
//		return projectNameText.getText();
//	}

	public String getDsalName() {
		return dsalName.getText();
	}
//	public String getSecondDsalName() {
//		return dsal2NameText.getText();
//	}
}