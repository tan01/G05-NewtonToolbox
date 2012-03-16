package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Clayven Anderson
 *
 */

public class GUINewSheet extends JPanel
{
  private static final long serialVersionUID = 56556326265896987l;
  private JPanel topPanel = new JPanel();
  private JPanel middlePanel = new JPanel();
  private JPanel bottomPanel = new JPanel();
  
  
  JTextField nameBar = new JTextField(25);

  
  GUINewSheet(){
    add(BorderLayout.NORTH, topPanel);
    topPanel.add(nameBar);
    
  }
}
  