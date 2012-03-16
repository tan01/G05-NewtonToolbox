package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import storage.FormulaDatabase;
import storage.Saver;
import storage.UnitDatabase;
import storage.VariableDatabase;

import com.sun.awt.AWTUtilities;


/**
 * This is the main, front page of the GUI for Newton's Toolbox.
 * From here, you can access four other screens:
 * Search, Print, Solve, Add
 *  
 * @author Michelle Len
 * @author Jonathan Tan
 * @author http://www.java2s.com/Code/Java/Swing-JFC/Createundecoratedframe.htm
 * @version 03/04/2012 for CS 48 Project, W12
 */
public class GUIMain {

	// For mouse clicks.
	private static Point point = new Point();

	// Declare our private variables
	public static JFrame frame;
	private NewtonsToolboxPanel panel;

	// Dynamic content panel
	private JComponent contentPanel = new JPanel();

	// These are the databases from which all modules can refer to.
	// Use GUIMain.<your>Database
	public static FormulaDatabase FORMULAS   = (FormulaDatabase)Saver.loadForms();
	public static VariableDatabase VARIABLES = (VariableDatabase)Saver.loadVars();
	public static UnitDatabase UNITS         = (UnitDatabase)Saver.loadUnits();

	/**
	 * Creates the JFrame, and the JPanel
	 */
	public void go() {

		// Initialize our frame and set the size
		frame = new JFrame("Newton's Toolbox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.setUndecorated(true);

		// Declaring and creating a panel
		panel = new NewtonsToolboxPanel();

		// Adds invisible dummy panel;
		contentPanel.setOpaque(false);
		panel.add(contentPanel);

		// Default menu state
		// changeContent(new GUISearch());

		// THIS IS HOW YOU ADD BUTTONS TO THE BACKGROUND PANEL
		// 		Create a new panel
		//		Use the setBounds(int x, int y, int width, int height); method to set the size of the panel
		//		Then append it to the main panel panel.
		JPanel quitPanel = new JPanel(new BorderLayout());
		quitPanel.setOpaque(false);
		quitPanel.setBounds(830,20,50,25);

		imgButton quitButton = new imgButton("quitButton");
		quitButton.addActionListener(new quitListener());

		quitPanel.add(quitButton);
		panel.add(quitPanel);

		// Minimize button
		JPanel minimizePanel = new JPanel(new BorderLayout());
		minimizePanel.setOpaque(false);
		minimizePanel.setBounds(805,20,25,25);

		imgButton minimizeButton = new imgButton("minimizeButton");
		minimizeButton.addActionListener(new minimizeListener());

		minimizePanel.add(minimizeButton);
		panel.add(minimizePanel);

		// controlPanel - main controls
		JPanel controlPanel = new JPanel();
		controlPanel.setOpaque(false);
		controlPanel.setBounds(130,520,600,35);
		panel.add(controlPanel);

		// controlPanel - buttons
		JToggleButton searchFormsButton = new JToggleButton("Search");
		searchFormsButton.addActionListener(new searchListener());
		JToggleButton printFormsButton  = new JToggleButton("Print All");
		printFormsButton.addActionListener(new printListener());
		JToggleButton solveFormsButton  = new JToggleButton("Formula Sheet");
		solveFormsButton.addActionListener(new solveListener());
		JToggleButton addFormsButton    = new JToggleButton("Add");
		addFormsButton.addActionListener(new addListener());

		// cpButtons - button group for buttons on the controlPanel.
		ButtonGroup cpButtons = new ButtonGroup();

		cpButtons.add(searchFormsButton);
		cpButtons.add(printFormsButton);
		cpButtons.add(solveFormsButton);
		cpButtons.add(addFormsButton);

		// Adding buttons to controlPanel.
		controlPanel.add(searchFormsButton);
		controlPanel.add(printFormsButton);
		controlPanel.add(solveFormsButton);
		controlPanel.add(addFormsButton);

		// Adding the Border Layout
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		// SHAPE - Blue Quadrilateral
		Quadrilateral blueQuadrilateral = new Quadrilateral();
		blueQuadrilateral.addPoint((int)(0.03125*frame.getWidth()), (int)(0.06250*frame.getHeight())); //  1/32(W) &  1/16(H)
		blueQuadrilateral.addPoint((int)(frame.getWidth()),         (int)(0)); // 32/32(W) &  0/32(H)
		blueQuadrilateral.addPoint((int)(0.90625*frame.getWidth()), (int)(frame.getHeight())); // 29/32(W) & 32/32(H)
		blueQuadrilateral.addPoint((int)(0.06250*frame.getWidth()), (int)(0.93750*frame.getHeight())); //  1/16(W) & 15/16(H)

		AWTUtilities.setWindowShape(frame, blueQuadrilateral);

		// Makes frame draggable.
		// Has a ghosting problem on some machines.
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = frame.getLocation();
				frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		// Decorations
		JLabel titlegraphic = new JLabel(new ImageIcon("img/ntbtitle.png"));
		titlegraphic.setBounds(530,23,265,20);
		titlegraphic.setVisible(true);
		panel.add(titlegraphic);

		// Displays the frame
		frame.setVisible(true);	

	}

	/**
	 * To change the panel shown
	 * @param newPanel
	 */
	public void changeContent (JPanel newPanel) {
		panel.remove(contentPanel);
		contentPanel = newPanel;
		contentPanel.setBounds(80,60,720,480);
		contentPanel.setOpaque(false);
		panel.add(contentPanel);
		updateUI();
	}
	
	/**
	 * To change the content displayed
	 * @param newPanel
	 */
	public void changeContent (JScrollPane newPanel) {
		panel.remove(contentPanel);
		contentPanel = newPanel;
		System.out.println("Components changed: "+contentPanel.getComponentCount());
		contentPanel.setBounds(80,60,720,480);
		contentPanel.setOpaque(false);
		panel.add(contentPanel);
		updateUI();
	}

	public class NewtonsToolboxPanel extends JPanel {     

		public NewtonsToolboxPanel(){
			super(null);
		}
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;

			// Enable anti-aliasing for smoothing out shapes
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Draws a Blue Quadrilateral
			Quadrilateral blueQuadrilateral = new Quadrilateral();
			blueQuadrilateral.addPoint((int)(0.03125*this.getWidth()), (int)(0.06250*this.getHeight())); //  1/32(W) &  1/16(H)
			blueQuadrilateral.addPoint((int)(this.getWidth()),         (int)(0) ); // 32/32(W) &  1/32(H)
			blueQuadrilateral.addPoint((int)(0.90625*this.getWidth()), (int)(this.getHeight())); // 29/32(W) & 32/32(H)
			blueQuadrilateral.addPoint((int)(0.06250*this.getWidth()), (int)(0.93750*this.getHeight())); //  1/16(W) & 15/16(H)
			g2d.setColor(new Color(0x3399CC));
			g2d.drawPolygon(blueQuadrilateral);
			g2d.fillPolygon(blueQuadrilateral);

		}

	} // NewtonToolBoxPanel Delimit

	//Button Listener Classes:
	class quitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class minimizeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setState(Frame.ICONIFIED);
		}
	}

	class searchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeContent(new GUISearch());
		}
	}

	class printListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeContent(new GUIPrint());
		}
	}

	class solveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeContent(new GUIFormulaSheet());
		}
	}

	class addListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeContent(new GUIAdd());
		}
	}

	/* Calls updateUI on all sub-components of the JFrame */
	public static void updateUI() {
		SwingUtilities.updateComponentTreeUI(frame);
	}

	// Main
	public static void main (String[] args) {
		GUIMain gui = new GUIMain();
		gui.go();
	}

}