package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


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

  private JToggleButton newFormulaSheetButton = new JToggleButton("Create Formula Sheet");
  private JToggleButton loadFormulaButton = new JToggleButton("Load Formula Sheet");

  ButtonGroup topButtons = new ButtonGroup();

  
	public GUIFormulaSheet() {
		setLayout(new BorderLayout());
		setSize(720,480);

		JPanel topPanel = new JPanel();
    middlePanel = new JPanel();

    add(BorderLayout.CENTER, middlePanel);
    add(BorderLayout.NORTH, topPanel);
    
    topButtons.add(newFormulaSheetButton);
    topButtons.add(loadFormulaButton);
    
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
