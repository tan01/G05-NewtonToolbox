package gui;
import internalformatting.Formula;
import internalformatting.Unit;
import internalformatting.Variable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;

import search.Search;
import search.SearchUnits;
import search.SearchVars;
import storage.FormulaDatabase;
import storage.Saver;

/**
 * GUISearch used to search for formulas from the formula database * 
 * @author May Camp
 * @author Jonathan Tan
 */
//Forms = Formulas
public class GUISearch extends JPanel{
	private static final long serialVersionUID = 9044967744683200942L;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel rightPanel;
	
	//search bar
	JTextField searchBar = new JTextField(50);

	private JScrollPane scroller;
	JTextArea searchResults = new JTextArea(25,57);
	private JButton searchButton = new JButton("Search");

	//Search criterion
	public boolean searchFormula = true;
	public boolean searchVar = false;
	public boolean searchUnit = false;
	
	//check boxes go here
	JCheckBox formulaBox = new JCheckBox("Form");
	JCheckBox varBox = new JCheckBox("Vars");
	JCheckBox unitBox = new JCheckBox("Unit");
	
	public GUISearch() {
		setSize(720,480);

		//panels
		topPanel = new JPanel();
		middlePanel = new JPanel();
		rightPanel = new JPanel();
		//rightPanel.setPreferredSize(new Dimension(100,600));
		
		topPanel.setOpaque(false);
		middlePanel.setOpaque(false);
		rightPanel.setOpaque(false);

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
		add(BorderLayout.EAST, rightPanel);


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

		//right panel contains checkboxes
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		JCheckBox formulaBox = new JCheckBox("Form",true);
		formulaBox.setOpaque(false);
		formulaBox.addItemListener(new formListener());
		JCheckBox varBox = new JCheckBox("Vars");
		varBox.setOpaque(false);
		varBox.addItemListener(new varListener());
		JCheckBox unitBox = new JCheckBox("Unit");
		unitBox.setOpaque(false);
		unitBox.addItemListener(new unitListener());
		
		topPanel.add(searchBar);
		topPanel.add(searchButton);

		middlePanel.add(scroller);

		rightPanel.add(formulaBox);
		rightPanel.add(varBox);
		rightPanel.add(unitBox);
		
		searchButton.addActionListener(new searchButtonListener());


	}
	
	//THIS SHOULD BE IN THE GUISEARCH MODULE
	public void printSearchToTextArea(){
		//clear previous search
		String userInput = searchBar.getText().toLowerCase();
		searchResults.setText("You searched for: " + userInput + "\n");
		
		if(searchFormula){
		Search searchObject = new Search(GUIMain.FORMULAS);
		ArrayList<Formula> foundFormulas = searchObject.searchF(userInput);
		String writeBuffer = "";
		
		for(int i=0; i<foundFormulas.size();i++) {
			writeBuffer = writeBuffer + foundFormulas.get(i).allInfoToString() + "\n \n";
		}

		searchResults.append("Found " + foundFormulas.size());
		searchResults.append(" formula");
		if(foundFormulas.size()!=1)
			searchResults.append("e");
		if(foundFormulas.size()!=0)
			searchResults.append(": ");
		else
			searchResults.append(".");
		searchResults.append("\n\n" + writeBuffer);
		//Search is done, clears the search bar.
		searchBar.setText("");
		}
		
		if(searchVar){
			SearchVars searchObject = new SearchVars(GUIMain.VARIABLES);
			ArrayList<Variable> foundVars = searchObject.searchV(userInput);
			String writeBuffer = "";
			
			for(int i=0; i<foundVars.size();i++) {
				writeBuffer = writeBuffer + foundVars.get(i).allInfoToString() + "\n \n";
			}

			searchResults.append("Found " + foundVars.size());
			searchResults.append(" variable");
			if(foundVars.size()!=1)
				searchResults.append("s");
			if(foundVars.size()!=0)
				searchResults.append(": ");
			else
				searchResults.append(".");
			searchResults.append("\n\n" + writeBuffer);
			//Search is done, clears the search bar.
			searchBar.setText("");
			}
		
		if(searchUnit){
			SearchUnits searchObject = new SearchUnits(GUIMain.UNITS);
			ArrayList<Unit> foundUnits = searchObject.searchU(userInput);
			String writeBuffer = "";
			
			for(int i=0; i<foundUnits.size();i++) {
				writeBuffer = writeBuffer + foundUnits.get(i).allInfoToString() + "\n \n";
			}

			searchResults.append("Found " + foundUnits.size());
			searchResults.append(" unit");
			if(foundUnits.size()!=1)
				searchResults.append("s");
			if(foundUnits.size()!=0)
				searchResults.append(": ");
			else
				searchResults.append(".");
			searchResults.append("\n\n" + writeBuffer);
			//Search is done, clears the search bar.
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
}