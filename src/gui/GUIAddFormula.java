package gui;
import gui.GUIAddUnit.addUnitButtonListener;
import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Term;
import internalformatting.Unit;

import java.awt.BorderLayout;
import java.awt.Component;
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
import storage.UnitDatabase;
import storage.VariableDatabase;

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

	private NewtonsToolboxPanel middlePanel;

	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel currFormPanel;
	private NewtonsToolboxPanel opPanel;
	private NewtonsToolboxPanel termPanel;
	private NewtonsToolboxPanel coeffPanel;
	private NewtonsToolboxPanel varPanel;
	private NewtonsToolboxPanel addToCurrFormPanel;
	private NewtonsToolboxPanel expPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagPanel;
	private NewtonsToolboxPanel addFormButtonPanel;

	private JLabel nameLabel   = new JLabel("Name: ");
	private JLabel currFormLabel = new JLabel("Current Formula: ");
	private JLabel opLabel = new JLabel("Operator:");
	private JLabel termLabel = new JLabel("Term:");
	private JLabel coeffLabel = new JLabel("Coefficient:");
	private JLabel varLabel   = new JLabel("Variables:");
	private JLabel expLabel = new JLabel("Exponent:");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagLabel    = new JLabel("Tags: ");

	private JTextField nameTextField   = new JTextField(50);
	private JTextField opTextField = new JTextField(5); //change to down later
	private JTextField coeffTextField = new JTextField(5);
	private JTextField varTextField   = new JTextField(50); // change to drop down later
	private JTextField expTextField = new JTextField(5);

	private JTextArea currFormTextArea = new JTextArea(3, 50); //used in scroll later
	private JTextArea infoTextArea     = new JTextArea(6, 50); //used in scroll later
	private JTextArea tagTextArea      = new JTextArea(4, 50); //used in scroll later

	private JScrollPane currFormScrollbar;
	private JScrollPane infoScrollbar;
	private JScrollPane tagScrollbar;

	private JButton addToCurrFormButton = new JButton("Add Op & Term");
	private JButton addFormButton = new JButton("Add Formula");

	private JComboBox<String> opComboBox;
	private JComboBox<String> varComboBox;

	////all operators
	Operator blank = new Operator(" ");
	Operator leftParen = new Operator("(");
	Operator rightParen = new Operator(")");
	Operator plus = new Operator("+");
	Operator minus = new Operator("-");
	Operator times = new Operator("*");
	Operator divide = new Operator("/");
	Operator equals = new Operator("=");
	ArrayList<Operator> allOps = new ArrayList<Operator>();

	Formula newFormula = new Formula();

	public GUIAddFormula() {
		setSize(720,480);

		allOps.add(blank);
		allOps.add(leftParen);
		allOps.add(rightParen);
		allOps.add(plus);
		allOps.add(minus);
		allOps.add(times);
		allOps.add(divide);
		allOps.add(equals);

		//for operator drop down menu
		opComboBox = new JComboBox<String>();
		for(int i=0;i<allOps.size();i++){
			opComboBox.addItem(allOps.get(i).getOperator());
		}

		//for variable drop down menu
		varComboBox = new JComboBox<String>();
		for(int j=0;j<GUIMain.VARIABLES.getSize();j++){
			varComboBox.addItem(GUIMain.VARIABLES.get(j).getVar());
		}

		middlePanel = new NewtonsToolboxPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		//middlePanel.setSize(720, 480);
		add(BorderLayout.CENTER, middlePanel);

		nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		currFormLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		currFormLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		opLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		opLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		termLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		termLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		coeffLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		coeffLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		varLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		varLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		expLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		expLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		infoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		infoLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		tagLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		tagLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		nameTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		nameTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
		opTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		opTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
		coeffTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		coeffTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
		varTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		varTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
		expTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		expTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		currFormTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		currFormTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		infoTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		infoTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		tagTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tagTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);		

		opComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		opComboBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		varComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		varComboBox.setAlignmentY(Component.CENTER_ALIGNMENT);

		addToCurrFormButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addToCurrFormButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		addFormButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addFormButton.setAlignmentY(Component.CENTER_ALIGNMENT);

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

		namePanel   = new NewtonsToolboxPanel();
		currFormPanel = new NewtonsToolboxPanel();
		opPanel   = new NewtonsToolboxPanel();
		termPanel   = new NewtonsToolboxPanel();
		coeffPanel   = new NewtonsToolboxPanel();
		varPanel   = new NewtonsToolboxPanel();
		addToCurrFormPanel = new NewtonsToolboxPanel();
		expPanel   = new NewtonsToolboxPanel();
		infoPanel   = new NewtonsToolboxPanel();
		tagPanel    = new NewtonsToolboxPanel();
		addFormButtonPanel = new NewtonsToolboxPanel();

		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		currFormPanel.setLayout(new BoxLayout(currFormPanel, BoxLayout.X_AXIS));
		opPanel.setLayout(new BoxLayout(opPanel, BoxLayout.X_AXIS));
		termPanel.setLayout(new BoxLayout(termPanel, BoxLayout.X_AXIS));
		coeffPanel.setLayout(new BoxLayout(coeffPanel, BoxLayout.X_AXIS));
		varPanel.setLayout(new BoxLayout(varPanel, BoxLayout.X_AXIS));
		expPanel.setLayout(new BoxLayout(expPanel, BoxLayout.X_AXIS));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));
		addFormButtonPanel.setLayout(new BoxLayout(addFormButtonPanel, BoxLayout.X_AXIS));

		currFormTextArea.setLineWrap(true);

		//wrap words and lines and make sure you can't edit it
		currFormTextArea.setLineWrap(true);
		currFormTextArea.setWrapStyleWord(true);
		currFormTextArea.setEditable(false);
		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		//wrap words and lines and make sure you can't edit it
		tagTextArea.setLineWrap(true);
		tagTextArea.setWrapStyleWord(true);

		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(12,0)));
		namePanel.add(nameTextField);

		currFormPanel.add(currFormLabel);
		currFormPanel.add(Box.createRigidArea(new Dimension(5,0)));
		currFormPanel.add(currFormScrollbar);

		termPanel.add(opPanel);
		termPanel.add(termLabel);
		termPanel.add(Box.createRigidArea(new Dimension(12,0)));
		//term contains op, coeff, var, exp, addToCurrFormButton
		termPanel.add(coeffPanel);
		termPanel.add(varPanel);
		termPanel.add(expPanel);

		addToCurrFormPanel.add(addToCurrFormButton);

		//out of order
		opPanel.add(opLabel);
		opPanel.add(Box.createRigidArea(new Dimension(4,0)));
		opPanel.add(opComboBox);

		coeffPanel.add(coeffLabel);
		coeffPanel.add(Box.createRigidArea(new Dimension(12,0)));
		coeffPanel.add(coeffTextField);

		varPanel.add(varLabel);
		varPanel.add(Box.createRigidArea(new Dimension(16,0)));
		varPanel.add(varComboBox);

		expPanel.add(expLabel);
		expPanel.add(Box.createRigidArea(new Dimension(12,0)));
		expPanel.add(expTextField);

		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(24,0)));
		infoPanel.add(infoScrollbar);

		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(17,0)));
		tagPanel.add(tagScrollbar);

		addFormButtonPanel.add(addFormButton);

		middlePanel.add(namePanel);
		middlePanel.add(currFormPanel);
		//middlePanel.add(opPanel);
		middlePanel.add(termPanel);
		middlePanel.add(addToCurrFormPanel);
		middlePanel.add(infoPanel);
		middlePanel.add(tagPanel);
		middlePanel.add(addFormButtonPanel);

		setOpaque(false);
		middlePanel.setOpaque(false);//THIS THING makes it not opaque

		namePanel.setOpaque(false);
		currFormPanel.setOpaque(false);
		varPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);

		addFormButtonPanel.setOpaque(false);

		addToCurrFormButton.addActionListener(new addToCurrFormButtonListener());
		addFormButton.addActionListener(new addFormButtonListener());

	}
	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = 2571010965858865585L;
	}
	//Button Listener Classes:
	class addToCurrFormButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currFormTextArea.append ( allOps.get(opComboBox.getSelectedIndex()).toString() + " ");
			currFormTextArea.append (coeffTextField.getText() );
			currFormTextArea.append ( GUIMain.VARIABLES.get(varComboBox.getSelectedIndex()).toString() + " ");
			currFormTextArea.append ( " ^ " );
			currFormTextArea.append ( expTextField.getText() + " ");

			//to save term in newFormula
			String coeffString = coeffTextField.getText();
			String expString2 = expTextField.getText();
			int coeff = Integer.parseInt(coeffString);
			int exp = Integer.parseInt(expString2);
			Term newTerm = new Term( coeff, GUIMain.VARIABLES.get(varComboBox.getSelectedIndex()), exp);
			newFormula.addTerm( allOps.get(opComboBox.getSelectedIndex()) );
			newFormula.addTerm( newTerm );
		}
	}

	//Button Listener Classes:
	class addFormButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String formName = nameTextField.getText();
			String formInfo = infoTextArea.getText();
			String[] formTags = tagTextArea.getText().split(",");
			
			newFormula.setName(formName);
			newFormula.setInfo(formInfo);
			for(int i=0;i<formTags.length;i++){
				newFormula.addTag(formTags[i].toLowerCase());
			}
			((FormulaDatabase)GUIMain.FORMULAS).addFormula(newFormula);
			Saver.saveForms(GUIMain.FORMULAS);

			//			String formFormat = formatTextField.getText();
			//			String unitInfo = infoTextArea.getText();
			//			String[] tagsTemp = tagsTextArea.getText().split(",");
			//			
			//			Formula newForm = new Formula(formName);
			//			newUnit.setTypicalForm(unitFormat);
			//			newUnit.setInfo(unitInfo);
			//			for(int i=0;i<tagsTemp.length;i++){
			//				newUnit.addTag(tagsTemp[i].toLowerCase());
			//				}
			//			((UnitDatabase)GUIMain.UNITS).addUnit(newUnit);
			//			Saver.saveUnits(GUIMain.UNITS);
			//			
			//			nameField.setText("");
			//			formatField.setText("");
			//			infoTextArea.setText("");
			//			tagsTextArea.setText("");
		}
	}

}


