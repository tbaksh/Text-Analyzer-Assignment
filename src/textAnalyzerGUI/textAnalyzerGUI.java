package textAnalyzerGUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class textAnalyzerGUI {

	protected Shell shell;
	private Text txtWordCount;
	private Text txtPleaseEnterA;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			textAnalyzerGUI window = new textAnalyzerGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 400);
		shell.setText("SWT Application");
		
		txtWordCount = new Text(shell, SWT.BORDER | SWT.CENTER);
		txtWordCount.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		txtWordCount.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 28, SWT.NORMAL));
		txtWordCount.setText("Word Count");
		txtWordCount.setBounds(129, 10, 196, 45);
		
		txtPleaseEnterA = new Text(shell, SWT.BORDER);
		txtPleaseEnterA.setText("Please enter a website URL for count of words");
		txtPleaseEnterA.setBounds(98, 65, 256, 18);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(44, 114, 375, 20);
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(24, 116, 22, 18);
		btnRadioButton.setText("Radio Button");
		
		Button btnReadFromCurrent = new Button(shell, SWT.RADIO);
		btnReadFromCurrent.setBounds(24, 151, 183, 18);
		btnReadFromCurrent.setText("Read from current database");
		
		Button btnCount = new Button(shell, SWT.NONE);
		btnCount.setBounds(183, 183, 94, 27);
		btnCount.setText("Count!");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setBounds(57, 224, 362, 132);

	}
}
