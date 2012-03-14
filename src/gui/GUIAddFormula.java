package gui;
import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Term;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

	private JPanel middlePanel;
	
	private JPanel namePanel;
	private JPanel currFormPanel;
	private JPanel opPanel; //operator
	private JPanel termPanel;
	private JPanel coeffPanel; //coefficient
	private JPanel varPanel; //variable
	private JPanel addToCurrFormPanel; //add op, coeff, var, exp to current formula panel
	private JPanel expPanel; //exponent
	private JPanel infoPanel; //information
	private JPanel tagPanel;
	private JPanel addFormButtonPanel; //formula

	private JLabel nameLabel   = new JLabel("Name: ");
	private JLabel currFormLabel = new JLabel("Current Formula: ");
	private JLabel opLabel = new JLabel("Operator:");
	private JLabel termLabel = new JLabel("Term:"); //term includes op,coeff,var,exp
	private JLabel coeffLabel = new JLabel("Coefficient:");
	private JLabel varLabel   = new JLabel("Variables:");
	private JLabel expLabel = new JLabel("Exponent:");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagLabel    = new JLabel("Tags: ");

	private JTextField nameTextField   = new JTextField(52);
//	private JTextField opTextField = new JTextField(5); //change to down later
	private JTextField coeffTextField = new JTextField(5);
//	private JTextField varTextField   = new JTextField(51); // change to drop down later
	private JTextField expTextField = new JTextField(4);

	private JTextArea currFormTextArea = new JTextArea(3, 51); //used in scroll later
	private JTextArea infoTextArea     = new JTextArea(7, 51); //used in scroll later
	private JTextArea tagTextArea      = new JTextArea(4, 51); //used in scroll later

	private JScrollPane currFormScrollbar;
	private JScrollPane infoScrollbar;
	private JScrollPane tagScrollbar;

	private JButton addOpToFormButton = new JButton("Add Operator to Formula");
	private JButton addTermToFormButton = new JButton("Add Term to Formula");
	private JButton addFormButton = new JButton("Add Formula");

	private JComboBox<String> opComboBox;
	private JComboBox<String> varComboBox;

	////all operators
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

		FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 5, 5);
		FlowLayout center = new FlowLayout(FlowLayout.CENTER, 5, 5);
		
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

		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		//middlePanel.setSize(720, 480);
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

		namePanel   = new JPanel();
		currFormPanel = new JPanel();
		opPanel   = new JPanel();
		termPanel   = new JPanel();
		coeffPanel   = new JPanel();
		varPanel   = new JPanel();
		addToCurrFormPanel = new JPanel();
		expPanel   = new JPanel();
		infoPanel   = new JPanel();
		tagPanel    = new JPanel();
		addFormButtonPanel = new JPanel();

		namePanel.setLayout(flow);
		currFormPanel.setLayout(flow);
		
		opPanel.setLayout(flow);
		termPanel.setLayout(flow);
		coeffPanel.setLayout(flow);
		varPanel.setLayout(flow);
		expPanel.setLayout(flow);
		
		infoPanel.setLayout(flow);
		tagPanel.setLayout(flow);
		addFormButtonPanel.setLayout(center);
		
		opPanel.setBackground(new Color(0x66CCFF));
		termPanel.setBackground(new Color(0x66CCFF));
		addToCurrFormPanel.setBackground(new Color(0x66CCFF));

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
		namePanel.add(Box.createRigidArea(new Dimension(67,0)));
		namePanel.add(nameTextField);

		currFormPanel.add(currFormLabel);
		currFormPanel.add(Box.createRigidArea(new Dimension(8,0)));
		currFormPanel.add(currFormScrollbar);
		
		opPanel.add(opLabel);
		opPanel.add(opLabel);
		opPanel.add(Box.createRigidArea(new Dimension(5,0)));
		opPanel.add(opComboBox);
		opPanel.add(Box.createRigidArea(new Dimension(10,0)));
		opPanel.add(addOpToFormButton);
		
		termPanel.add(Box.createRigidArea(new Dimension(15,0)));
		termPanel.add(termLabel);
		termPanel.add(Box.createRigidArea(new Dimension(25,0)));
		//term contains op, coeff, var, exp, addToCurrFormButton
		termPanel.add(coeffPanel);
		termPanel.add(varPanel);
		termPanel.add(expPanel);
		termPanel.add(addTermToFormButton);

//		addToCurrFormPanel.add(addTermToFormButton);
		

		coeffPanel.add(coeffLabel);
		coeffPanel.add(Box.createRigidArea(new Dimension(5,0)));
		coeffPanel.add(coeffTextField);
		coeffPanel.add(Box.createRigidArea(new Dimension(10,0)));

		varPanel.add(varLabel);
		varPanel.add(Box.createRigidArea(new Dimension(5,0)));
		varPanel.add(varComboBox);
		varPanel.add(Box.createRigidArea(new Dimension(10,0)));
		
		expPanel.add(expLabel);
		expPanel.add(Box.createRigidArea(new Dimension(5,0)));
		expPanel.add(expTextField);

		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(80,0)));
		infoPanel.add(infoScrollbar);

		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(73,0)));
		tagPanel.add(tagScrollbar);

		addFormButtonPanel.add(addFormButton);

		middlePanel.add(namePanel);
		middlePanel.add(currFormPanel);
		middlePanel.add(opPanel);
		middlePanel.add(termPanel);
		middlePanel.add(addToCurrFormPanel);
		middlePanel.add(infoPanel);
		middlePanel.add(tagPanel);
		middlePanel.add(addFormButtonPanel);

		setOpaque(false);
		middlePanel.setOpaque(false);//THIS THING makes it not opaque
		
//		opPanel.setOpaque(false);
//		termPanel.setOpaque(false);
		coeffPanel.setOpaque(false);
		varPanel.setOpaque(false);
		expPanel.setOpaque(false);
//		addToCurrFormPanel.setOpaque(false);
		
		namePanel.setOpaque(false);
		currFormPanel.setOpaque(false);
		varPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);
		
		addFormButtonPanel.setOpaque(false);

		addOpToFormButton.addActionListener(new addOpToFormButtonListener());
		addTermToFormButton.addActionListener(new addTermToFormButtonListener());
		addFormButton.addActionListener(new addFormButtonListener());

	}

	//Button Listener Classes:
	class addOpToFormButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			currFormTextArea.append ( allOps.get(opComboBox.getSelectedIndex()).toString() + " ");
//			currFormTextArea.append (coeffTextField.getText() );
//			currFormTextArea.append ( GUIMain.VARIABLES.get(varComboBox.getSelectedIndex()).toString() + " ");
//			currFormTextArea.append ( " ^ " );
//			currFormTextArea.append ( expTextField.getText() + " ");

			//to save operator in newFormula
			newFormula.addTerm( allOps.get(opComboBox.getSelectedIndex()) );
			
			//set current formula box
			String formulaString = newFormula.toString();
			currFormTextArea.setText(formulaString);
			
			//clear fields
			opComboBox.setSelectedIndex(2);

			
		}
	}
	
	//Button Listener Classes:
	class addTermToFormButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			currFormTextArea.append ( allOps.get(opComboBox.getSelectedIndex()).toString() + " ");
//			currFormTextArea.append (coeffTextField.getText() );
//			currFormTextArea.append ( GUIMain.VARIABLES.get(varComboBox.getSelectedIndex()).toString() + " ");
//			currFormTextArea.append ( " ^ " );
//			currFormTextArea.append ( expTextField.getText() + " ");

			//convert coefficients and exponents into integers
			String coeffString = coeffTextField.getText();
			String expString2 = expTextField.getText();
			int coeff = Integer.parseInt(coeffString);
			int exp = Integer.parseInt(expString2);
			
			//make a new term
			Term newTerm = new Term( coeff, GUIMain.VARIABLES.get(varComboBox.getSelectedIndex()), exp);
			
			//add new term to formula
			newFormula.addTerm( newTerm );
			
			//set current formula text box
			String formulaString = newFormula.toString();
			currFormTextArea.setText(formulaString);
			
			//clear fields
			opComboBox.setSelectedIndex(2);
			coeffTextField.setText("");
//			varComboBox.setSelectedIndex(0);
			expTextField.setText("");
			
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
			
			nameTextField.setText("");
			currFormTextArea.setText("");
			opComboBox.setSelectedIndex(0);
			coeffTextField.setText("");
			varComboBox.setSelectedIndex(0);
			expTextField.setText("");
			infoTextArea.setText("");
			tagTextArea.setText("");
			
			//so user can create a new formula directly after finishing the past one
			newFormula = new Formula();
		}
	}

}