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
	String stringOfFormulas = "";
	for(int i=0; i<GUIMain.FORMULAS.size();i++) {
		stringOfFormulas = stringOfFormulas + GUIMain.FORMULAS.get(i).allInfoToString() + "\n \n";
	}
	infoField.setText(stringOfFormulas);
	add(infoField);
	}
}
