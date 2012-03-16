package gui;
import internalformatting.Formula;
import internalformatting.Unit;
import internalformatting.Variable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import search.Search;
import search.SearchUnits;
import search.SearchVars;

/**
 * GUISearch used to search for formulas from the formula database * 
 * @author May Camp
 * @author Jonathan Tan
 */
public class GUISearch extends JPanel {

	private static final long serialVersionUID = 9044967744683200942L;

	// Declaring panels
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel rightPanel;

	// Search bar and search results
	private JTextField searchBar    = new JTextField(50);
	private JTextArea searchResults = new JTextArea(25,57);
	private JButton searchButton    = new JButton("Search");

	// Scroll-bar for results
	private JScrollPane scroller;

	// Search criterion
	public boolean searchFormula = true;
	public boolean searchVar = false;
	public boolean searchUnit = false;

	// Check boxes go here
	JCheckBox formulaBox = new JCheckBox("Form");
	JCheckBox varBox     = new JCheckBox("Vars");
	JCheckBox unitBox    = new JCheckBox("Unit");

	public GUISearch() {

		setSize(720,480);

		// Initializing all panels
		topPanel = new JPanel();
		middlePanel = new JPanel();
		rightPanel = new JPanel();

		// Setting all panels' opacities to false
		topPanel.setOpaque(false);
		middlePanel.setOpaque(false);
		rightPanel.setOpaque(false);

		// Wrap words and lines and make sure you can't edit it
		searchResults.setLineWrap(true);
		searchResults.setWrapStyleWord(true);
		searchResults.setEditable(false);

		// Adding searchResults to the ScrollPane
		scroller = new JScrollPane(searchResults);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Adding the panels to a BorderLayout
		add(BorderLayout.NORTH,  topPanel);
		add(BorderLayout.CENTER, middlePanel);
		add(BorderLayout.EAST,   rightPanel);


		// Need searchBar action listener
		searchBar.addKeyListener(
				new KeyAdapter() {
					public void keyPressed(KeyEvent key) {
						if (key.getKeyCode()==KeyEvent.VK_ENTER) {
							printSearchToTextArea();
						}
					}
				}
				);

		// Right panel contains check-boxes
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// Initializing all JCheckBoxes
		JCheckBox formulaBox = new JCheckBox("Form", true);
		JCheckBox varBox     = new JCheckBox("Vars");
		JCheckBox unitBox    = new JCheckBox("Unit");

		// Set opacities of check-boxes to false
		formulaBox.setOpaque(false);
		varBox.setOpaque(false);
		unitBox.setOpaque(false);

		// Adding widgets to all of the panels
		topPanel.add(searchBar);
		topPanel.add(searchButton);

		middlePanel.add(scroller);

		rightPanel.add(formulaBox);
		rightPanel.add(varBox);
		rightPanel.add(unitBox);

		// Adding Listener to the Search Button
		searchButton.addActionListener(new searchButtonListener());

		// Adding Listeners to the CheckBoxes
		formulaBox.addItemListener(new formListener());
		varBox.addItemListener(new varListener());
		unitBox.addItemListener(new unitListener());

	}

	// THIS SHOULD BE IN THE GUISEARCH MODULE
	public void printSearchToTextArea(){
		// Clear previous search
		String userInput = searchBar.getText().toLowerCase();
		searchResults.setText("You searched for: " + userInput + "\n");

		if (searchFormula) {
			Search searchObject = new Search(GUIMain.FORMULAS);
			ArrayList<Formula> foundFormulas = searchObject.searchF(userInput);
			String writeBuffer = "";

			for (int i=0; i<foundFormulas.size(); i++) {
				writeBuffer = writeBuffer + foundFormulas.get(i).allInfoToString() + "\n \n";
			}

			searchResults.append("Found " + foundFormulas.size());
			searchResults.append(" formula");
			if (foundFormulas.size()!=1)
				searchResults.append("e");
			if (foundFormulas.size()!=0)
				searchResults.append(": ");
			else
				searchResults.append(".");
			searchResults.append("\n\n" + writeBuffer);
			// Search is done, clears the search bar.
			searchBar.setText("");
		}

		if (searchVar) {
			SearchVars searchObject = new SearchVars(GUIMain.VARIABLES);
			ArrayList<Variable> foundVars = searchObject.searchV(userInput);
			String writeBuffer = "";

			for (int i=0; i<foundVars.size(); i++) {
				writeBuffer = writeBuffer + foundVars.get(i).allInfoToString() + "\n \n";
			}

			searchResults.append("Found " + foundVars.size());
			searchResults.append(" variable");
			if (foundVars.size()!=1)
				searchResults.append("s");
			if (foundVars.size()!=0)
				searchResults.append(": ");
			else
				searchResults.append(".");
			searchResults.append("\n\n" + writeBuffer);
			// Search is done, clears the search bar.
			searchBar.setText("");
		}

		if (searchUnit) {
			SearchUnits searchObject = new SearchUnits(GUIMain.UNITS);
			ArrayList<Unit> foundUnits = searchObject.searchU(userInput);
			String writeBuffer = "";

			for (int i=0; i<foundUnits.size(); i++) {
				writeBuffer = writeBuffer + foundUnits.get(i).allInfoToString() + "\n \n";
			}

			searchResults.append("Found " + foundUnits.size());
			searchResults.append(" unit");
			if (foundUnits.size()!=1)
				searchResults.append("s");
			if (foundUnits.size()!=0)
				searchResults.append(": ");
			else
				searchResults.append(".");
			searchResults.append("\n\n" + writeBuffer);
			// Search is done, clears the search bar.
			searchBar.setText("");
		}
	}

	//Button Listener Classes:
	class searchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			printSearchToTextArea();
		}
	}

	//Check Box Listener inner classes
	class formListener implements ItemListener {
		public void itemStateChanged(ItemEvent ev) {
			if(ev.getStateChange()==ItemEvent.SELECTED)
				searchFormula = true;
			else
				searchFormula = false;
		}
	}

	class varListener implements ItemListener {
		public void itemStateChanged(ItemEvent ev) {
			if(ev.getStateChange()==ItemEvent.SELECTED)
				searchVar = true;
			else
				searchVar = false;
		}
	}

	class unitListener implements ItemListener {
		public void itemStateChanged(ItemEvent ev) {
			if(ev.getStateChange()==ItemEvent.SELECTED)
				searchUnit = true;
			else
				searchUnit = false;
		}
	}

} // class GUISearch