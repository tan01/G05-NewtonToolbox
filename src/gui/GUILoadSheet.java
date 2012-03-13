package gui;

import gui.GUISearch.NewtonsToolboxPanel;
import gui.GUISearch.searchButtonListener;

import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Term;
import internalformatting.Unit;
import internalformatting.Variable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import storage.FormulaDatabase;
import storage.FormulaSheet;
import storage.Saver;

/**
 * 
 * @author Clayven Anderson
 *
 */
public class GUILoadSheet extends JPanel
{
  private static final long serialVersionUID = 354678202967285l;
  private NewtonsToolboxPanel topPanel;
  private NewtonsToolboxPanel middlePanel;
  
  
  //search bar
  JTextField loadBar = new JTextField(50);

  private JScrollPane scroller;
  JTextArea loadResults = new JTextArea(25,57);
  private JButton loadButton = new JButton("Load");
  
  public GUILoadSheet(){
    setSize(720,480);
    
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    
  //panels
    topPanel = new NewtonsToolboxPanel();
    middlePanel = new NewtonsToolboxPanel();
    
    
    topPanel.setOpaque(false);
    middlePanel.setOpaque(false);
   
    
  //wrap words and lines and make sure you can't edit it
    loadResults.setLineWrap(true);
    loadResults.setWrapStyleWord(true);
    loadResults.setEditable(false);
    
  //scroller
    scroller = new JScrollPane(loadResults);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    add(BorderLayout.NORTH, topPanel);
    add(BorderLayout.CENTER, middlePanel);
    
    
    topPanel.add(loadBar);
    topPanel.add(loadButton);

    middlePanel.add(scroller);
    
    loadButton.addActionListener(new loadButtonListener());
  }
  
  public class NewtonsToolboxPanel extends JPanel {
    // Included to suppress Eclipse Warning
    private static final long serialVersionUID = 965858862357885585L;
  }
  
  class loadButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String userInput = loadBar.getText();
     loadResults.append(Saver.loadSheet(userInput).printSheet());
  
      }  
    }
  
  }