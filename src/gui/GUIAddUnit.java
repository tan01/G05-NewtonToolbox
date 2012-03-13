package gui;
import internalformatting.Unit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.Saver;
import storage.UnitDatabase;

/**
 * GUIAddUnit used to search for formulas from the formula database * 
 * @author May Camp
 */
public class GUIAddUnit extends JPanel {

	private static final long serialVersionUID = 9044967744683200942L;

	private NewtonsToolboxPanel middlePanel;

	private NewtonsToolboxPanel topButtonPanel;
	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel formatPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagsPanel;
	private NewtonsToolboxPanel addUnitButtonPanel;
	
	private JButton createUnitButton     = new JButton("Create Unit");
	private JButton createVariableButton = new JButton("Create Variable");
	private JButton createFormulaButton  = new JButton("Create Formula");

	private JLabel nameLabel   = new JLabel("Name (like 'meter'): ");
	private JLabel formatLabel = new JLabel("Format (like 'm'): ");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagsLabel   = new JLabel("Tags (separated by ','): ");

	private JTextField nameField   = new JTextField(50);
	private JTextField formatField = new JTextField(50);
	private JTextArea infoTextArea = new JTextArea(14, 49);
	private JTextArea tagsTextArea = new JTextArea(4, 49);

	private JScrollPane scroller;
	private JScrollPane scroller2;

	private JButton addUnitButton = new JButton("Add Unit");

	public GUIAddUnit() {

		setSize(720,480);

		// Setting flow layouts so that certain components will either center
		// align or align left
		FlowLayout center = new FlowLayout(FlowLayout.CENTER, 5, 5);
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 5, 5);
		
		middlePanel = new NewtonsToolboxPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));		
		middlePanel.setSize(720,480);

		add(BorderLayout.CENTER, middlePanel);

		//scroller
		scroller = new JScrollPane(infoTextArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		//scroller2
		scroller2 = new JScrollPane(tagsTextArea);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		//panels
		topButtonPanel = new NewtonsToolboxPanel();
		
		namePanel   = new NewtonsToolboxPanel();
		formatPanel = new NewtonsToolboxPanel();
		infoPanel   = new NewtonsToolboxPanel();
		tagsPanel   = new NewtonsToolboxPanel();
		
		addUnitButtonPanel = new NewtonsToolboxPanel();
		
		topButtonPanel.setLayout(center);
		
		namePanel.setLayout  (flow);
		formatPanel.setLayout(flow);
		infoPanel.setLayout  (flow);
		tagsPanel.setLayout  (flow);
		
		addUnitButtonPanel.setLayout (new BoxLayout(addUnitButtonPanel, BoxLayout.X_AXIS));

		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		tagsTextArea.setLineWrap(true);
		tagsTextArea.setWrapStyleWord(true);

		// set all opaque-ness to FALSE.
		setOpaque(false);
		topButtonPanel.setOpaque(false);
		middlePanel.setOpaque(false);
		namePanel.setOpaque(false);
		formatPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagsPanel.setOpaque(false);
		addUnitButtonPanel.setOpaque(false);

		// Adding labels and such to panels, and separating them with a "box"
		topButtonPanel.add(createUnitButton);
		topButtonPanel.add(createVariableButton);
		topButtonPanel.add(createFormulaButton);
		
		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(28,0)));
		namePanel.add(nameField);

		formatPanel.add(formatLabel);
		formatPanel.add(Box.createRigidArea(new Dimension(44,0)));
		formatPanel.add(formatField);

		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(114,0)));
		infoPanel.add(scroller);//infoTextArea is inside scroller

		tagsPanel.add(tagsLabel);
		tagsPanel.add(Box.createRigidArea(new Dimension(10,0)));
		tagsPanel.add(scroller2);

		addUnitButtonPanel.add(addUnitButton);

		// Finally, add all panels to the panels~
		middlePanel.add(topButtonPanel);
		middlePanel.add(namePanel);
		middlePanel.add(formatPanel);
		middlePanel.add(infoPanel);
		middlePanel.add(tagsPanel);
		middlePanel.add(addUnitButtonPanel);

		createUnitButton.addActionListener(new createUnitButtonListener());
		createVariableButton.addActionListener(new createVariableButtonListener());
		createFormulaButton.addActionListener(new createFormulaButtonListener());
		
		addUnitButton.addActionListener(new addUnitButtonListener());
		//Sets the addUnitButton to default so you can hit enter in a text field and it'll make with the magic.
		GUIMain.frame.getRootPane().setDefaultButton(addUnitButton);

	}

	//THIS SHOULD BE IN THE GUIAddUnit MODULE
	//	public void printSearchToTextArea(){
	//		String userInput = searchBar.getText().toLowerCase();
	//		FormulaDatabase defaultFormulas = (FormulaDatabase)Saver.loadForms();
	//		Search searchObject = new Search(defaultFormulas);
	//		ArrayList<Formula> foundFormulas = searchObject.searchF(userInput);
	//
	//		String stringOfFormulas = "";
	//		for(int i=0; i<foundFormulas.size();i++) {
	//			stringOfFormulas = stringOfFormulas + foundFormulas.get(i).allInfoToString() + "\n \n";
	//		}
	//
	//		searchResults.setText("You searched for: " + userInput + "\n" +
	//				"Found " + foundFormulas.size() + " formulas:\n\n" +
	//				stringOfFormulas);
	//		//Search is done, clears the search bar.
	//		searchBar.setText("");
	//	}

	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = -3226654973851691774L;
	}

	class createUnitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			middlePanel.removeAll();
			GUIMain.updateUI();
			middlePanel.add(new GUIAddUnit());
		}
	}
	
	class createVariableButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			middlePanel.removeAll();
			GUIMain.updateUI();
			middlePanel.add(new GUIAddVariable());
		}
	}
	
	class createFormulaButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			middlePanel.removeAll();
			GUIMain.updateUI();
			middlePanel.add(new GUIAddFormula());
		}
	}
	
	//Button Listener Classes:
	class addUnitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String unitName = nameField.getText();
			String unitFormat = formatField.getText();
			String unitInfo = infoTextArea.getText();
			String[] tagsTemp = tagsTextArea.getText().split(",");

			Unit newUnit = new Unit(unitName);
			newUnit.setTypicalForm(unitFormat);
			newUnit.setInfo(unitInfo);
			for(int i=0;i<tagsTemp.length;i++){
				newUnit.addTag(tagsTemp[i].toLowerCase());
			}
			((UnitDatabase)GUIMain.UNITS).addUnit(newUnit);
			Saver.saveUnits(GUIMain.UNITS);

			nameField.setText("");
			formatField.setText("");
			infoTextArea.setText("");
			tagsTextArea.setText("");
		}
	}

}