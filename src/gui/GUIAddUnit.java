package gui;
import internalformatting.Formula;
import internalformatting.Tags;
import internalformatting.Unit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import search.Search;
import storage.FormulaDatabase;
import storage.Saver;
import storage.UnitDatabase;
import userinterface.CLIAdd;

/**
 * GUIAddUnit used to search for formulas from the formula database * 
 * @author May Camp
 */
//Forms = Formulas
public class GUIAddUnit extends JPanel{
	private static final long serialVersionUID = 9044967744683200942L;
	private NewtonsToolboxPanel topPanel;
	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel formatPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagsPanel;
	private NewtonsToolboxPanel addUnitButtonPanel;

	//search bar
	JTextField nameField = new JTextField(40);
	JTextField formatField = new JTextField(40);
	JTextArea infoTextArea = new JTextArea(5,40);
	JTextArea tagsTextArea = new JTextArea(5,40);

	private JScrollPane scroller;
	private JScrollPane scroller2;
	
	
	private JLabel nameLabel = new JLabel();
	private JLabel formatLabel = new JLabel();
	private JLabel infoLabel = new JLabel();
	private JLabel tagsLabel = new JLabel();
	private JButton addUnitButton = new JButton("Add Unit");

	public GUIAddUnit() {
		setSize(300,480);

		//panels
		topPanel = new NewtonsToolboxPanel();
		namePanel = new NewtonsToolboxPanel();
		formatPanel = new NewtonsToolboxPanel();
		infoPanel = new NewtonsToolboxPanel();
		tagsPanel = new NewtonsToolboxPanel();
		addUnitButtonPanel = new NewtonsToolboxPanel();
		
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));		
		
		topPanel.setSize(200,200);

		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);

		//scroller
		scroller = new JScrollPane(infoTextArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//scroller2
		scroller2 = new JScrollPane(tagsTextArea);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(BorderLayout.NORTH, topPanel);
		
		setOpaque(false);
		topPanel.setOpaque(false);
		namePanel.setOpaque(false);
		formatPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagsPanel.setOpaque(false);
		addUnitButtonPanel.setOpaque(false);
		
		nameLabel.setText("Name (like 'meter'):     ");
		formatLabel.setText("Format (like 'm'):           ");
		infoLabel.setText("Info:                                     ");
		tagsLabel.setText("Tags (separated by ','): ");

		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		formatPanel.add(formatLabel);
		formatPanel.add(formatField);
		
		infoPanel.add(infoLabel);
		infoPanel.add(scroller);//infoTextArea is inside scroller
		
		tagsPanel.add(tagsLabel);
		tagsPanel.add(scroller2);

		addUnitButtonPanel.add(addUnitButton);
		
		topPanel.add(namePanel);
		topPanel.add(formatPanel);
		topPanel.add(infoPanel);
		topPanel.add(tagsPanel);
		topPanel.add(addUnitButtonPanel);
		
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