package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * GUI for displaying a few buttons for adding
 * and creating buttons.
 * 
 * @author May Camp
 * @author Michelle Len
 *
 */
public class GUIAdd extends JPanel {

	private static final long serialVersionUID = -5200304895970513817L;

	private NewtonsToolboxPanel middlePanel;

	private JButton createUnitButton = new JButton("Create Unit");
	private JButton createVariableButton = new JButton("Create Variable");
	private JButton createFormulaButton = new JButton("Create Formula");

	public GUIAdd() {

		setSize(720,480);
		
		middlePanel = new NewtonsToolboxPanel();

		add(BorderLayout.CENTER, middlePanel);

		//need action listeners
		middlePanel.add(createUnitButton);
		middlePanel.add(createVariableButton);
		middlePanel.add(createFormulaButton);
		
	}
	
	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = 5110086507916942106L;
	}
	
} // class GUIAdd