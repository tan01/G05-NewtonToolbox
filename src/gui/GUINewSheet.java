package gui;

import gui.GUIAddVariable.addVariableButtonListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.FormulaSheet;
import storage.Saver;

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
  
  private JLabel nameLabel   = new JLabel("Sheet Name:");
  private JLabel formLabel   = new JLabel("Formulas:");
  private JLabel sheetLabel   = new JLabel("Sheet So Far:");
  
  private JTextArea sheetTextArea  = new JTextArea(20, 51);
 
  JTextField nameBar = new JTextField(25);
  
  private JButton addFormulaButton = new JButton("Add Formula");
  private JButton saveButton = new JButton("Save Formula Sheet");
  
  private JScrollPane sheetScrollbar;
  
  private JComboBox<String> formComboBox;
  
  private FormulaSheet userSheet = new FormulaSheet();

  
  GUINewSheet(){
    
    setSize(720,480);
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    
 // formComboBox is the drop-down menu for Formulas
    formComboBox = new JComboBox<String>();
    for(int i=0;i<GUIMain.FORMULAS.getSize();i++){
      formComboBox.addItem(GUIMain.FORMULAS.get(i).getName());
    }
    
    
  //wrap words and lines and make sure you can't edit it
    sheetTextArea.setLineWrap(true);
    sheetTextArea.setWrapStyleWord(true);
    sheetTextArea.setEditable(false);
    
    sheetScrollbar = new JScrollPane(sheetTextArea);
    sheetScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    sheetScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    topPanel.setOpaque(false);
    middlePanel.setOpaque(false);
    bottomPanel.setOpaque(false);
    
    add(BorderLayout.NORTH, topPanel);
    add(BorderLayout.CENTER, middlePanel);
    add(BorderLayout.SOUTH, bottomPanel);
    
    topPanel.add(nameLabel);
    topPanel.add(nameBar);
    topPanel.add(addFormulaButton);
    topPanel.add(formComboBox);
    middlePanel.add(sheetScrollbar);
    bottomPanel.add(saveButton);
    
    saveButton.addActionListener(new saveButtonListener());
    addFormulaButton.addActionListener( new addFormButtonListener());
    
  }
  
  public void setTextBox(FormulaSheet sheet){
     String display = "";
     for(int i=0; i < sheet.size() ;i++){
       display = display + sheet.get(i).allInfoToString() + "\n";
     }
     sheetTextArea.setText(display);
  }
  
  class saveButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      String userInput = nameBar.getText();
      if(!(userInput.equals(""))){
        userSheet.setName(userInput);
        Saver.saveSheet(userSheet);
        sheetTextArea.setText("Formula Sheet Saved");
      }
      else{
         String errorMessage = "You left name blank\n";
         
         JOptionPane.showMessageDialog(middlePanel,
             errorMessage,
             "Error",
             JOptionPane.WARNING_MESSAGE);
      }
    }
  }

    class addFormButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
        userSheet.addFormula(GUIMain.FORMULAS.get((formComboBox.getSelectedIndex())) );
        setTextBox(userSheet);
    }
  
    }
  }
 
  