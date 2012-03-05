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
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;


/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to format
 * what we want in our GUI
 * 
 * @author May Camp
 *
 */
//Forms = Formulas
public class NewtonsToolboxGUI2 {
	private JFrame frame;
	private NewtonsToolboxPanel topPanel;
	private NewtonsToolboxPanel middlePanel;
	private NewtonsToolboxPanel bottomPanel;
	private NewtonsToolboxPanel panel;
	
	
	JTextField searchBar = new JTextField(30);
	TextArea searchResults = new TextArea();
	private JButton searchButton = new JButton("Search");
	private JButton printFormsButton = new JButton("Print Formulas");
	private JButton solveFormsButton = new JButton("Solve Formulas");
	private JButton addFormsButton = new JButton("Add Formulas");
	
	public void go() {
		frame = new JFrame("Newton's Toolbox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720,480);
		
		topPanel = new NewtonsToolboxPanel();
		middlePanel = new NewtonsToolboxPanel();
		bottomPanel = new NewtonsToolboxPanel();
		panel = new NewtonsToolboxPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, topPanel);
		frame.getContentPane().add(BorderLayout.CENTER, middlePanel);
		frame.getContentPane().add(BorderLayout.CENTER, bottomPanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		
		//need searchBar action listener
		topPanel.add(searchBar);
		
		topPanel.add(searchButton);
		
		middlePanel.add(searchResults);
		
		bottomPanel.add(printFormsButton);
		
		bottomPanel.add(solveFormsButton);
		
		bottomPanel.add(addFormsButton);
		
		
		frame.setVisible(true);
	}
	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
    	private static final long serialVersionUID = 1L;

    	

	}
	
	public static void main(String[] args) {
		
		NewtonsToolboxGUI2 gui = new NewtonsToolboxGUI2();
		gui.go();
	}
	
	
	
}
