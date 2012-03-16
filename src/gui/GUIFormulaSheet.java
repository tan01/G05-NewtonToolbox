package gui;
import gui.GUIAdd.createUnitButtonListener;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;


/**
 * The GUI for the formula sheet function
 * 
 * @author Clayven Anderson
 *
 */
//Forms = Formulas
public class GUIFormulaSheet extends JPanel{
  
  private static final long serialVersionUID = 257392854603458L;
  
  private JPanel middlePanel;

  private JButton newFormulaSheetButton = new JButton("Create Formula Sheet");
  private JButton loadFormulaButton = new JButton("Load Formula Sheet");
   
  
	public GUIFormulaSheet() {
		setLayout(new BorderLayout());
		setSize(720,480);

		JPanel topPanel = new JPanel();
    middlePanel = new JPanel();

    add(BorderLayout.CENTER, middlePanel);
    add(BorderLayout.NORTH, topPanel);
    
    topPanel.add(newFormulaSheetButton);
    topPanel.add(loadFormulaButton);
    
    middlePanel.setOpaque(false);
    topPanel.setOpaque(false);
    
    newFormulaSheetButton.addActionListener(new newFormulaButtonListener());
    loadFormulaButton.addActionListener(new loadFormulaButtonListener());
	}
	
	 class newFormulaButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      middlePanel.removeAll();
	      GUIMain.updateUI();
	      middlePanel.add(new GUINewSheet());
	    }
	  }
	  
	  class loadFormulaButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      middlePanel.removeAll();
	      GUIMain.updateUI();
	      middlePanel.add(new GUILoadSheet());
	    }
	  }
}
