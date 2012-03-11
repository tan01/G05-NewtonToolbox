package gui;
import internalformatting.Formula;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

/**
 * GUIAddUnit used to search for formulas from the formula database * 
 * @author May Camp
 */
//Forms = Formulas
public class GUIAddUnit extends JPanel{
	private static final long serialVersionUID = 9044967744683200942L;
	private NewtonsToolboxPanel topPanel;
	private NewtonsToolboxPanel middlePanel;

	//search bar
	JTextField nameField = new JTextField(50);
	JTextField formatField = new JTextField(50);
	JTextArea infoTextArea = new JTextArea(5,50);
	JTextField tagsField = new JTextField(50);

	private JScrollPane scroller;
	private JLabel nameLabel;
	private JLabel formatLabel;
	private JLabel infoLabel;
	private JLabel tagsLabel;
	private JButton addUnitButton = new JButton("Add Unit");

	public GUIAddUnit() {
		setSize(720,480);

		//panels
		topPanel = new NewtonsToolboxPanel();
		middlePanel = new NewtonsToolboxPanel();

		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setEditable(false);

		//scroller
		scroller = new JScrollPane(infoTextArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(BorderLayout.NORTH, topPanel);
		add(BorderLayout.CENTER, middlePanel);


		//need searchBar action listener
//		searchBar.addKeyListener(
//				new KeyAdapter(){
//					public void keyPressed(KeyEvent key){
//						if(key.getKeyCode()==KeyEvent.VK_ENTER){
//							printSearchToTextArea();
//						}
//					}
//				}
//				);

		topPanel.add(nameLabel);
		topPanel.add(nameField);
		topPanel.add(formatLabel);
		topPanel.add(formatField);
		topPanel.add(infoLabel);
		topPanel.add(scroller);//infoTextArea is inside scroller
		topPanel.add(tagsLabel);
		topPanel.add(tagsField);

		topPanel.add(addUnitButton);

		middlePanel.add(scroller);


//		searchButton.addActionListener(new searchButtonListener());


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
			//////////DO STUFF
		}
	}


}