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
 * GUIPrint
 * Prints all formulas in database. I guess.
 * @author Jonathan Tan
 *
 */
//Forms = Formulas
public class GUIPrint extends JPanel{
	JTextArea infoField = new JTextArea(27,57);
	public GUIPrint(){
	infoField.setLineWrap(true);
	infoField.setWrapStyleWord(true);
	infoField.setEditable(false);
	//Scroller
	JScrollPane scroller = new JScrollPane(infoField);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	String writeBuffer = "";
	
	writeBuffer +="[FORMULAS] \n";
	
	for(int i=0; i<GUIMain.FORMULAS.size();i++) {
		writeBuffer = writeBuffer + GUIMain.FORMULAS.get(i).allInfoToString() + "\n \n";
	}
	
	writeBuffer +="[VARIABLES] \n";
	
	for(int i=0; i<GUIMain.VARIABLES.size();i++) {
		writeBuffer = writeBuffer + 
				GUIMain.VARIABLES.get(i).getVar() + "   Units: " +
				GUIMain.VARIABLES.get(i).getUnit() + "\n" + "Info: " +
				GUIMain.VARIABLES.get(i).getInfo() + "\n" + "Tags: " +
				GUIMain.VARIABLES.get(i).getTags() + "\n\n";
	}
	
	writeBuffer +="[UNITS] \n";
	
	for(int i=0; i<GUIMain.UNITS.size();i++) {
		writeBuffer = writeBuffer + 
				GUIMain.UNITS.get(i).getName() + "\n" + "Info: " +
				GUIMain.UNITS.get(i).getInfo() + "\n" + "Tags: " +
				GUIMain.UNITS.get(i).getAllTags() + "\n\n";
	}
	
	infoField.append(writeBuffer);
	add(scroller);
	}
}
