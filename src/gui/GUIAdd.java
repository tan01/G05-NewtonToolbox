package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

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
	private JToggleButton createUnitButton     = new JToggleButton("Create Unit");
	private JToggleButton createVariableButton = new JToggleButton("Create Variable");
	private JToggleButton createFormulaButton  = new JToggleButton("Create Formula");

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
		
		// Setting Button icons
		createUnitButton.setSelectedIcon(new ImageIcon("img/buttons/createUnitButton.png"));
		createVariableButton.setSelectedIcon(new ImageIcon("img/buttons/createVariableButton.png"));
		createFormulaButton.setSelectedIcon(new ImageIcon("img/buttons/createFormulaButton.png"));
		
		//creating button group
		ButtonGroup topButtons = new ButtonGroup();
		topButtons.add(createUnitButton);
		topButtons.add(createVariableButton);
		topButtons.add(createFormulaButton);
		
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
			createUnitButton.setSelected(true);
			createVariableButton.setSelected(false);
			createFormulaButton.setSelected(false);
			middlePanel = new GUIAddUnit();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

	// Button Listener Class: createVariableButtonListener
	class createVariableButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(middlePanel);
			GUIMain.updateUI();
			createUnitButton.setSelected(false);
			createVariableButton.setSelected(true);
			createFormulaButton.setSelected(false);
			middlePanel = new GUIAddVariable();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

	// Button Listener Class: createFormulaButtonLister
	class createFormulaButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(middlePanel);
			GUIMain.updateUI();
			createUnitButton.setSelected(false);
			createVariableButton.setSelected(false);
			createFormulaButton.setSelected(true);
			middlePanel = new GUIAddFormula();
			add(BorderLayout.CENTER,middlePanel);
		}
	}

} // class GUIAdd