package awesome.ide.wizards;

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

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class AspectMechanismProjectWizardPage extends WizardPage {
	private static final String XTEXT_SUPPORT_LABEL = "Xtext support";
	
	private Text mechanismName;
	private Button isXtext;
	
	public AspectMechanismProjectWizardPage() {
		super("wizardPage");
		setTitle("New Aspect Mechanism Project");
		setDescription("This wizard creates a new aspect mechanism project");
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
		label.setText("&Mechanism Name:");

		mechanismName = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		mechanismName.setLayoutData(gd);
		mechanismName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		isXtext = new Button(container, SWT.CHECK);
		isXtext.setText(XTEXT_SUPPORT_LABEL);
		isXtext.setSelection(true);
		
		dialogChanged();
		setControl(container);
	}

	private void dialogChanged() {
		String mechName = getMechanismName();

		if (mechName.length() == 0) {
			updateStatus("A name for the aspect mechanism must be specified");
			return;
		}
		if (mechName.contains(" ")) {
			updateStatus("The name of the aspect mechanism cannot contain spaces");
			return;
		}
		
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getMechanismName() {
		return mechanismName.getText();
	}
	
	public boolean isXtextSupport() {
		return isXtext.getSelection();
	}
	
}