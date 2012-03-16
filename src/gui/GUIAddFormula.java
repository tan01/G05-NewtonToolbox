package gui;
import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Tags;
import internalformatting.Term;
import internalformatting.Variable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.FormulaDatabase;
import storage.Saver;

/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to currForm
 * what we want in our GUI
 * 
 * @author May Camp
 * @author Michelle Len
 */
public class GUIAddFormula extends JPanel {

	private static final long serialVersionUID = 6187284211221392126L;

	// middlePanel is the main panel
	private JPanel middlePanel;

	// sub-panels to be added to main panel
	private JPanel namePanel;			// Enter the Name
	private JPanel currFormPanel;		// Displays the Current Formula the user is adding
	private JPanel opPanel; 			// Select the Operator
	private JPanel termPanel;			// Create the Term
	private JPanel coeffPanel; 			// Coefficient for Term
	private JPanel varPanel; 			// Variable for Term
	private JPanel expPanel; 			// Exponent for Term
	private JPanel infoPanel; 			// Information regarding the Formula
	private JPanel tagPanel;			// Tags/Keywords for searching Formulae
	private JPanel addFormButtonPanel; 	// Add a Formula

	// Initializing all widgets: Labels, TextFields, TextAreas, and Buttons
	private JLabel nameLabel     = new JLabel("Name: ");
	private JLabel currFormLabel = new JLabel("Current Formula: ");
	private JLabel opLabel       = new JLabel("Operator:");
	private JLabel termLabel     = new JLabel("Term:");
	private JLabel coeffLabel    = new JLabel("Coefficient:");
	private JLabel varLabel      = new JLabel("Variables:");
	private JLabel expLabel      = new JLabel("Exponent:");
	private JLabel infoLabel     = new JLabel("Info: ");
	private JLabel tagLabel      = new JLabel("<HTML>Tags <BR>(separated by ','): </HTML>");

	private JTextField nameTextField   = new JTextField(53);
	private JTextField coeffTextField  = new JTextField(5);
	private JTextField expTextField    = new JTextField(4);

	private JTextArea currFormTextArea = new JTextArea(3, 52); //used in scroll later
	private JTextArea infoTextArea     = new JTextArea(7, 52); //used in scroll later
	private JTextArea tagTextArea      = new JTextArea(2, 52); //used in scroll later

	private JButton addOpToFormButton   = new JButton("Add Operator to Formula");
	private JButton addTermToFormButton = new JButton("Add Term to Formula");
	private JButton addFormButton       = new JButton("Add Formula");

	// Declaring Scrollbars and ComboBoxes
	private JScrollPane currFormScrollbar;
	private JScrollPane infoScrollbar;
	private JScrollPane tagScrollbar;

	private JComboBox<String> opComboBox;
	private JComboBox<String> varComboBox;

	// Creating and initializing all operators
	Operator leftParen  = new Operator("(");
	Operator rightParen = new Operator(")");
	Operator plus       = new Operator("+");
	Operator minus      = new Operator("-");
	Operator times      = new Operator("*");
	Operator divide     = new Operator("/");
	Operator equals     = new Operator("=");

	ArrayList<Operator> allOps = new ArrayList<Operator>();

	Formula newFormula = new Formula();

	public GUIAddFormula() {

		setSize(720,480);

		// Adding all operators to an ArrayList
		allOps.add(leftParen);
		allOps.add(rightParen);
		allOps.add(plus);
		allOps.add(minus);
		allOps.add(times);
		allOps.add(divide);
		allOps.add(equals);

		// For the Operator drop-down menu
		opComboBox = new JComboBox<String>();
		for(int i=0; i<allOps.size(); i++) {
			opComboBox.addItem(allOps.get(i).getOperator());
		}

		// For the Variable drop-down menu
		varComboBox = new JComboBox<String>();
		for(int j=0; j<GUIMain.VARIABLES.getSize(); j++) {
			varComboBox.addItem(GUIMain.VARIABLES.get(j).getVar());
		}

		// Initializing middlePanel, and setting the layout
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		add(BorderLayout.CENTER, middlePanel);

		// Scroll-bar for the currForm JTextArea
		currFormScrollbar = new JScrollPane(currFormTextArea);
		currFormScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		currFormScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll-bar for the info JTextArea
		infoScrollbar = new JScrollPane(infoTextArea);
		infoScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll-bar for the tag JTextArea
		tagScrollbar = new JScrollPane(tagTextArea);
		tagScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tagScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Initializing all sub-panels
		namePanel     = new JPanel();
		currFormPanel = new JPanel();
		opPanel       = new JPanel();
		termPanel     = new JPanel();
		coeffPanel    = new JPanel();
		varPanel      = new JPanel();
		expPanel      = new JPanel();
		infoPanel     = new JPanel();
		tagPanel      = new JPanel();
		addFormButtonPanel = new JPanel();

		// Set the layout for all sub-panels
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		currFormPanel.setLayout(new BoxLayout(currFormPanel, BoxLayout.X_AXIS));
		opPanel.setLayout(new BoxLayout(opPanel, BoxLayout.X_AXIS));
		termPanel.setLayout(new BoxLayout(termPanel, BoxLayout.X_AXIS));
		coeffPanel.setLayout(new BoxLayout(coeffPanel, BoxLayout.X_AXIS));
		varPanel.setLayout(new BoxLayout(varPanel, BoxLayout.X_AXIS));
		expPanel.setLayout(new BoxLayout(expPanel, BoxLayout.X_AXIS));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));

		// Setting the background colors for the Operator and Term panels
		opPanel.setBackground(new Color(0xCCFFFF));
		termPanel.setBackground(new Color(0x66CCFF));

		// Wrap words and lines and make sure you can't edit it
		currFormTextArea.setLineWrap(true);
		currFormTextArea.setWrapStyleWord(true);
		currFormTextArea.setEditable(false);
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		tagTextArea.setLineWrap(true);
		tagTextArea.setWrapStyleWord(true);

		// Adding widgets to the Name Panel (Label and TextField)
		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(62,0)));
		namePanel.add(nameTextField);

		// Adding widgets to the Current Formula Panel (Label and ScrollPane)
		currFormPanel.add(currFormLabel);
		currFormPanel.add(Box.createRigidArea(new Dimension(3,0)));
		currFormPanel.add(currFormScrollbar);

		// Adding widgets to the Operator Panel (Label, ComboBox, and Button)
		opPanel.add(opLabel);
		opPanel.add(opLabel);
		opPanel.add(Box.createRigidArea(new Dimension(48,0)));
		opPanel.add(opComboBox);
		opPanel.add(Box.createRigidArea(new Dimension(371,0)));
		opPanel.add(addOpToFormButton);

		/* Adding widgets to the Term Panel 
		 * (Label, Coefficient, Variable, Exponent, and Button) */
		termPanel.add(termLabel);
		termPanel.add(Box.createRigidArea(new Dimension(64,0)));
		termPanel.add(coeffPanel);
		termPanel.add(Box.createRigidArea(new Dimension(10,0)));
		termPanel.add(varPanel);
		termPanel.add(Box.createRigidArea(new Dimension(10,0)));
		termPanel.add(expPanel);
		termPanel.add(Box.createRigidArea(new Dimension(10,0)));
		termPanel.add(addTermToFormButton);

		// Adding widgets to the Coefficient Panel (Label and TextField)
		coeffPanel.add(coeffLabel);
		coeffPanel.add(Box.createRigidArea(new Dimension(5,0)));
		coeffPanel.add(coeffTextField);

		// Adding widgets to the Variable Panel (Label and ComboBox)
		varPanel.add(varLabel);
		varPanel.add(Box.createRigidArea(new Dimension(5,0)));
		varPanel.add(varComboBox);

		// Adding widgets to the Exponent Panel (Label and TextField)
		expPanel.add(expLabel);
		expPanel.add(Box.createRigidArea(new Dimension(5,0)));
		expPanel.add(expTextField);

		// Adding widgets to the Information Panel (Label and ScrollPane)
		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(75,0)));
		infoPanel.add(infoScrollbar);

		// Adding widgets to the Tag Panel (Label and ScrollPane)
		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(5,0)));
		tagPanel.add(tagScrollbar);

		// Adding Button widget to the Add Formula Button Panel
		addFormButtonPanel.add(addFormButton);

		/* Creating panels of colored boxes for the top and bottom "borders"
		 * for the Operator and Term Panels */
		JPanel opPanelTopBlueBox = new JPanel();
		opPanelTopBlueBox.setBackground(new Color(0xCCFFFF));
		JPanel opPanelBottomBlueBox = new JPanel();
		opPanelBottomBlueBox.setBackground(new Color(0xCCFFFF));
		JPanel termPanelTopBlueBox = new JPanel();
		termPanelTopBlueBox.setBackground(new Color(0x66CCFF));
		JPanel termPanelBottomBlueBox = new JPanel();
		termPanelBottomBlueBox.setBackground(new Color(0x66CCFF));

		// Adding all sub-panels to the main panel, separated by boxes
		middlePanel.add(namePanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(currFormPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(opPanelTopBlueBox);
		middlePanel.add(opPanel);
		middlePanel.add(opPanelBottomBlueBox);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(termPanelTopBlueBox);
		middlePanel.add(termPanel);
		middlePanel.add(termPanelBottomBlueBox);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(infoPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(tagPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(addFormButtonPanel);

		// Sets selected panels' opacity to false so that the background can display
		setOpaque(false);
		middlePanel.setOpaque(false);
		coeffPanel.setOpaque(false);
		varPanel.setOpaque(false);
		expPanel.setOpaque(false);
		namePanel.setOpaque(false);
		currFormPanel.setOpaque(false);
		varPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);
		addFormButtonPanel.setOpaque(false);

		// Add Action Listeners for our Buttons
		addOpToFormButton.addActionListener(new addOpToFormButtonListener());
		addTermToFormButton.addActionListener(new addTermToFormButtonListener());
		addFormButton.addActionListener(new addFormButtonListener());

	}

	// Implementation of the Button Listener classes:
	
	//Button Listener Class: addOpToFormButtonListener
	class addOpToFormButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		
			//to save operator in newFormula
			newFormula.addTerm( allOps.get(opComboBox.getSelectedIndex()) );

			//set current formula box
			String formulaString = newFormula.toString();
			currFormTextArea.setText(formulaString);

			//clear fields
			opComboBox.setSelectedIndex(2);

		}
	}
	
	// Button Listener Class: addTermToFormButtonListener
	class addTermToFormButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Convert coefficients and exponents into integers
			String coeffString = coeffTextField.getText();
			String expString = expTextField.getText();
			int coeff = 1;
			int exp = 1;
			if (coeffString.equals("")) {
				coeff = 1; 
			} 
			else {
				try {
					coeff = Integer.parseInt(coeffString);	
				} catch (Exception ex) {
					coeff = 1;
				}
			}
			if (expString.equals("")) {
				exp = 1;
			} 
			else {
				try {
					exp = Integer.parseInt(expString);
				} catch (NullPointerException ex) {
					coeff = 1;
				}
			}

			// Make a new term
			Variable newVariable = GUIMain.VARIABLES.get(varComboBox.getSelectedIndex());
			Term newTerm = new Term( coeff, newVariable, exp);
			
			// Add variable tags to formula
			for(int i=0; i<newVariable.getTagSize(); i++) {
				newFormula.addTag(newVariable.getTag(i));
			}
			
			// Show added tags in formula tags text section
			tagTextArea.setText(newVariable.getAllTags());

			// Add new term to formula
			newFormula.addTerm( newTerm );

			// Set current formula text box
			String formulaString = newFormula.toString();
			currFormTextArea.setText(formulaString);

			// Clear fields
			opComboBox.setSelectedIndex(2);
			coeffTextField.setText("");
			expTextField.setText("");

		}
	}

	//Button Listener Class: addFormButtonListener
	class addFormButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		
			String formName = nameTextField.getText();
			if (formName.equals("")) { }

			String formInfo = infoTextArea.getText();
			Tags formTags   = Tags.convertToTags(tagTextArea.getText());

			newFormula.setName(formName);
			newFormula.setInfo(formInfo);
			for (int i=0; i<formTags.size(); i++){
				newFormula.addTag(formTags.get(i));
			}
			((FormulaDatabase)GUIMain.FORMULAS).addFormula(newFormula);
			Saver.saveForms(GUIMain.FORMULAS);

			nameTextField.setText("");
			currFormTextArea.setText("");
			opComboBox.setSelectedIndex(0);
			coeffTextField.setText("");
			varComboBox.setSelectedIndex(0);
			expTextField.setText("");
			infoTextArea.setText("");
			tagTextArea.setText("");

			// Allows the user to create a new formula directly after finishing the past one
			newFormula = new Formula();
		}
	}

} // class GUIAddFormula