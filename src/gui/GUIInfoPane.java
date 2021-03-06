package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import storage.Saver;

/**
 * Info pane. Displays the formula and any and all information associated with it in a panel of its own.
 * Needs to be a relatively lightweight class constructed by the GUIPrint and GUISearch modules.
 * Needs to have two options for the user:
 * Add to Formula Sheet
 * Delete Formula
 * @author Jonny
 *
 */
public class GUIInfoPane extends JPanel{
	
	private static final long serialVersionUID = 5140672486667781254L;
	Font bonnie = new Font("AR BONNIE", Font.BOLD, 30);
	int whichFormula;
	GUIPrint referrer = null;
	
	public GUIInfoPane(int formulaIndex,GUIPrint creator){
		//allows the InfoPane to know which formula we're talking about
		whichFormula = formulaIndex;
		referrer = creator;
		
		//Layout
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(700,440));
		setOpaque(false);
		
		//Title Label
		JLabel titleLabel = new JLabel();
		titleLabel.setFont(bonnie);
		titleLabel.setText(GUIMain.FORMULAS.get(formulaIndex).getName());
		titleLabel.setForeground(Color.WHITE);
		add(titleLabel,BorderLayout.NORTH);
		
		//Formula
		JLabel formulaLabel = new JLabel(GUIMain.FORMULAS.get(formulaIndex).toLaTeXIcon());
		formulaLabel.setForeground(Color.WHITE);
		add(formulaLabel);
		
		//The Rest of the Info:
		JTextArea supInfo = new JTextArea();
		supInfo.setLineWrap(true);
		supInfo.setWrapStyleWord(true);
		supInfo.setEditable(false);
		supInfo.append(GUIMain.FORMULAS.get(formulaIndex).allInfoToString());
		supInfo.append("LaTeX: " + GUIMain.FORMULAS.get(formulaIndex).toLaTeX());
		add(supInfo);
		//A bit of formatting
		
		//The Action Button Panel
		JPanel actionPanel = new JPanel();
		//All buttons are added to this thing using its layout.
		//Back button - Just goes back to the GUIPrint/search page
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new backListener());
		actionPanel.add(backButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new deleteListener());
		actionPanel.add(deleteButton);
		add(actionPanel);
	}
	

	
	class deleteListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.println(GUIMain.FORMULAS.get(whichFormula).getName() + " was removed.");
			GUIMain.FORMULAS.rmFormula(whichFormula);
			Saver.saveForms(GUIMain.FORMULAS);
		}
	}
	
	class backListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			referrer.back();
			referrer.requestFocus();
		}
	}

}