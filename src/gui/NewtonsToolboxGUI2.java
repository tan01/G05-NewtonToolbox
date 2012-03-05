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
	private NewtonsToolboxPanel panel;
	
	//search bar
	//JTextField searchBar = new JTextField(50);
	JTextArea searchBar = new JTextArea(1,50);
	
	JTextArea searchResults = new JTextArea(15,57);
	private JButton searchButton = new JButton("Search");
	private JButton printFormsButton = new JButton("Print Formulas");
	private JButton solveFormsButton = new JButton("Solve Formulas");
	private JButton addFormsButton = new JButton("Add Formulas");
	
	public void go() {
		frame = new JFrame("Newton's Toolbox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720,480);
		

		panel = new NewtonsToolboxPanel();
	
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		
		
		//need searchBar action listener
		panel.add(searchBar);
		
		panel.add(searchButton);
		
		panel.add(searchResults);
		
		panel.add(printFormsButton);
		
		panel.add(solveFormsButton);
		
		panel.add(addFormsButton);
		
		
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
