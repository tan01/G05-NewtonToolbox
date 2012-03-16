package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * GUI for displaying a few buttons for adding
 * and creating buttons.
 * 
 * @author May Camp
 * @author Michelle Len
 * @author Jonathan Tan
 *
 */
public class GUIAdd extends JPanel {

	private static final long serialVersionUID = -5200304895970513817L;

	// middlePanel is the main panel
	private JPanel middlePanel;

	// Declaring and initializing our buttons
	private JButton createUnitButton     = new JButton("Create Unit");
	private JButton createVariableButton = new JButton("Create Variable");
	private JButton createFormulaButton  = new JButton("Create Formula");

	public GUIAdd() {

		setLayout(new BorderLayout());
		setSize(720,480);

		// Declaring and initializing a new panel called actionPanel.
		JPanel actionPanel = new JPanel();

		actionPanel.setOpaque(false);

		// Adding buttons to actionPanel
		actionPanel.add(createUnitButton);
		actionPanel.add(createVariableButton);
		actionPanel.add(createFormulaButton);

		add(BorderLayout.NORTH,actionPanel);

		// Initializing middlePanel
		middlePanel = new JPanel();

		add(BorderLayout.CENTER, middlePanel);

		middlePanel.setOpaque(false);

		createUnitButton.addActionListener(new createUnitButtonListener());
		createVariableButton.addActionListener(new createVariableButtonListener());
		createFormulaButton.addActionListener(new createFormulaButtonListener());

	}

	// Implementation of the Button Listener classes:

	// Button Listener Class: createUnitButtonListener
	class createUnitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(middlePanel);
			GUIMain.updateUI();
			middlePanel = new GUIAddUnit();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

	// Button Listener Class: createVariableButtonListener
	class createVariableButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(middlePanel);
			GUIMain.updateUI();
			middlePanel = new GUIAddVariable();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

	// Button Listener Class: createFormulaButtonLister
	class createFormulaButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(middlePanel);
			GUIMain.updateUI();
			middlePanel = new GUIAddFormula();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

} // class GUIAdd