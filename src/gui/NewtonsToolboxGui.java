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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

/**
 * Gui will be the gui used for our Newton's Toolbox project (EDIT DESCRIPTION LATER K THX)
 *  
 * @author Michelle Len
 * @version 03/04/2012 for CS 48 Project, W12
 */
public class NewtonsToolboxGui {
		
		// Declare our private variables
		private JFrame frame;
		private NewtonsToolboxPanel panel;
	  
		
		/**
		 * Creates the JFrame, and the JPanel
		 */
	    public void go() {
	    	
	    	// Initialize our frame and set the size
	    	frame = new JFrame("Newton's Toolbox");
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	    	frame.setSize(720,480);
	    	
	    	// Declaring and creating a panel
	    	panel = new NewtonsToolboxPanel();
	 
	    	// Adding the Border Layout
	    	frame.getContentPane().add(BorderLayout.CENTER, panel);
	 
	    	// Displays the frame
	    	frame.setVisible(true);	
	    	
	    }
	    
	    /**
	     * 
	     * @author Michelle Len
	     * Newton's Toolbox panel is a class that creates a JPanel area for drawing stuff associated with
	     * drawing stuff needed for our Newton's Toolbox (EDIT LATER K THX)
	     */
	    public class NewtonsToolboxPanel extends JPanel {     
			
	    	// Included to suppress Eclipse Warning
	    	private static final long serialVersionUID = 1L;

			/** 
			 * This is method that will draw objects on our DamagePanel
	    	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) for more details
	    	 */
	    	public void paintComponent(Graphics g) {
	    		
	    		Graphics2D g2d = (Graphics2D) g;
	    		
				// Enable anti-aliasing for smoothing out shapes :)
	    		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    		
	    		// Draws the White Background
	    		g2d.setColor(Color.WHITE);
	    		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	    		
	    		// Draws the Outer Blue Quadrilateral
	    		Quadrilateral blueQuadrilateral = new Quadrilateral();
	    		blueQuadrilateral.addPoint((int)(0.03125*this.getWidth()), (int)(0.06250*this.getHeight())); //  1/32(W) &  1/16(H)
	    		blueQuadrilateral.addPoint((int)(0.96875*this.getWidth()), (int)(0.03125*this.getHeight())); // 31/32(W) &  1/32(H)
	    		blueQuadrilateral.addPoint((int)(0.90625*this.getWidth()), (int)(0.96875*this.getHeight())); // 29/32(W) & 31/32(H)
	    		blueQuadrilateral.addPoint((int)(0.06250*this.getWidth()), (int)(0.93750*this.getHeight())); //  1/16(W) & 15/16(H)
	    		g2d.setColor(new Color(0x3399CC));	// Web-safe Color. Can change if you guys don't like it.
	    		g2d.drawPolygon(blueQuadrilateral);
	    		g2d.fillPolygon(blueQuadrilateral);
	   
	    		// Draws the Inner Lighter Blue Quadrilateral
	    		Quadrilateral lighterBlueQuadrilateral = new Quadrilateral();
	    		lighterBlueQuadrilateral.addPoint((int)(0.062500*this.getWidth()), (int)(0.093750*this.getHeight())); //  1/32(W) & 15/16(H)
	    		lighterBlueQuadrilateral.addPoint((int)(0.718750*this.getWidth()), (int)(0.093750*this.getHeight())); // 23/32(W) & 15/16(H)
	    		lighterBlueQuadrilateral.addPoint((int)(0.703125*this.getWidth()), (int)(0.250000*this.getHeight())); // 45/64(W) &  1/4 (H)
	    		lighterBlueQuadrilateral.addPoint((int)(0.093750*this.getWidth()), (int)(0.281250*this.getHeight())); //  1/16(W) &  9/32(H)
	    		g2d.setColor(new Color(0x66CCFF));	// Web-safe Color. Can change if you guys don't like it.
	    		g2d.drawPolygon(lighterBlueQuadrilateral);
	    		g2d.fillPolygon(lighterBlueQuadrilateral);
	    		
	    		
	    		// Color is set to White for Search Box
	    		g2d.setColor(Color.WHITE);
	    		g2d.fillRect((int)(0.0937500*this.getWidth()), (int)(0.1250000*this.getHeight()),  //  3/32 (W) &  1/8  (H)
	    				     (int)(0.6015625*this.getWidth()), (int)(0.1015625*this.getHeight())); // 77/128(W) & 13/128(H)
	    	}
	    }
	    
	    // I'm sticking this Main here so I can Ctrl+F11 and view what's drawn
		public static void main (String[] args) {
			NewtonsToolboxGui gui = new NewtonsToolboxGui();
			gui.go();
		}
		
}