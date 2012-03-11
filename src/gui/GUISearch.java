package gui;
import internalformatting.Formula;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import search.Search;
import storage.FormulaDatabase;
import storage.Saver;

/**
 * GUISearch used to search for formulas from the formula database * 
 * @author May Camp
 */
//Forms = Formulas
public class GUISearch extends JPanel{
	private static final long serialVersionUID = 9044967744683200942L;
	private NewtonsToolboxPanel topPanel;
	private NewtonsToolboxPanel middlePanel;

	//search bar
	JTextField searchBar = new JTextField(50);

	private JScrollPane scroller;
	JTextArea searchResults = new JTextArea(25,57);
	private JButton searchButton = new JButton("Search");

	public GUISearch() {
		setOpaque(false);
		setSize(720,480);

		//panels
		topPanel = new NewtonsToolboxPanel();
		middlePanel = new NewtonsToolboxPanel();
		
		topPanel.setOpaque(false);
		middlePanel.setOpaque(false);

		//wrap words and lines and make sure you can't edit it
		searchResults.setLineWrap(true);
		searchResults.setWrapStyleWord(true);
		searchResults.setEditable(false);

		//scroller
		scroller = new JScrollPane(searchResults);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(BorderLayout.NORTH, topPanel);
		add(BorderLayout.CENTER, middlePanel);


		//need searchBar action listener
		searchBar.addKeyListener(
				new KeyAdapter(){
					public void keyPressed(KeyEvent key){
						if(key.getKeyCode()==KeyEvent.VK_ENTER){
							printSearchToTextArea();
						}
					}
				}
				);

		topPanel.add(searchBar);
		topPanel.add(searchButton);

		middlePanel.add(scroller);


		searchButton.addActionListener(new searchButtonListener());


	}

	//THIS SHOULD BE IN THE GUISEARCH MODULE
	public void printSearchToTextArea(){
		String userInput = searchBar.getText().toLowerCase();
		FormulaDatabase defaultFormulas = (FormulaDatabase)Saver.loadForms();
		Search searchObject = new Search(defaultFormulas);
		ArrayList<Formula> foundFormulas = searchObject.searchF(userInput);

		String stringOfFormulas = "";
		for(int i=0; i<foundFormulas.size();i++) {
			stringOfFormulas = stringOfFormulas + foundFormulas.get(i).allInfoToString() + "\n \n";
		}

		searchResults.setText("You searched for: " + userInput + "\n" +
				"Found " + foundFormulas.size() + " formulas:\n\n" +
				stringOfFormulas);
		//Search is done, clears the search bar.
		searchBar.setText("");
	}

	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = -3226654973851691774L;
	}

	//Button Listener Classes:
	class searchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			printSearchToTextArea();
		}
	}



}