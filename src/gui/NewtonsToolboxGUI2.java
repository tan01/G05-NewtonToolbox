package gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//for textbox?
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

import internalformatting.Formula;
import internalformatting.Term;
import internalformatting.Variable;

import java.io.IOException;
import java.util.ArrayList;

import search.Search;
import storage.FormulaDatabase;
import storage.Saver;


/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to format
 * what we want in our GUI
 * 
 * @author May Camp
 *
 */
//Forms = Formulas
public class NewtonsToolboxGUI2{
	private JFrame frame;
	private NewtonsToolboxPanel topPanel;
	private NewtonsToolboxPanel middlePanel;
	private NewtonsToolboxPanel bottomPanel;


	private JScrollPane scroller;
	//search bar
	JTextField searchBar = new JTextField(50);
	//JTextArea searchBar = new JTextArea(1,50);

	JTextArea searchResults = new JTextArea(22,57);
	private JButton searchButton = new JButton("Search");
	private JButton searchFormsButton = new JButton("Search Formulas");
	private JButton printFormsButton = new JButton("Print Formulas");
	private JButton solveFormsButton = new JButton("Solve Formulas");
	private JButton addFormsButton = new JButton("Add Formulas");

	public void go() {
		frame = new JFrame("Newton's Toolbox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720,480);

		//panels
		topPanel = new NewtonsToolboxPanel();
		middlePanel = new NewtonsToolboxPanel();
		bottomPanel = new NewtonsToolboxPanel();


		//not needed? setborder thing
		//		middlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		//wrap words and lines and make sure you can't edit it
		searchResults.setLineWrap(true);
		searchResults.setWrapStyleWord(true);
		searchResults.setEditable(false);

		//scroller
		scroller = new JScrollPane(searchResults);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		//setting layout of panels
		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, middlePanel);
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);


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

		//add stuff to panels
		topPanel.add(searchBar);
		topPanel.add(searchButton);

		//searchResults was added to scroller, so DO NOT add to panel
		middlePanel.add(scroller);

		bottomPanel.add(searchFormsButton);
		bottomPanel.add(printFormsButton);
		bottomPanel.add(solveFormsButton);
		bottomPanel.add(addFormsButton);

		searchButton.addActionListener(new searchButtonListener());
		frame.setVisible(true);
	}

	//THIS SHOULD BE IN THE GUISEARCH MODULE
	public void printSearchToTextArea(){
		String userInput = searchBar.getText();
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
		private static final long serialVersionUID = 1L;
	}

	//Button Listener Classes:
	class searchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			printSearchToTextArea();
		}
	}

	public static void main(String[] args) {

		NewtonsToolboxGUI2 gui = new NewtonsToolboxGUI2();
		gui.go();
	}



}
