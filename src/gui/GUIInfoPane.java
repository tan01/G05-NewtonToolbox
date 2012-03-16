package gui;

import java.awt.Color;
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
	
	Font bonnie = new Font("AR BONNIE", Font.BOLD, 30);
	int whichFormula;
	
	public GUIInfoPane(int formulaIndex){
		//allows the InfoPane to know which formula we're talking about
		whichFormula = formulaIndex;
		
		//Layout
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setOpaque(false);
		
		//Title Label
		JLabel titleLabel = new JLabel();
		titleLabel.setFont(bonnie);
		titleLabel.setText(GUIMain.FORMULAS.get(formulaIndex).getName());
		titleLabel.setForeground(Color.WHITE);
		add(titleLabel);
		
		//Formula
		JLabel formulaLabel = new JLabel(GUIMain.FORMULAS.get(formulaIndex).toLaTeXIcon());
		formulaLabel.setForeground(Color.WHITE);
		add(formulaLabel);
		
		//The Rest of the Info:
		JTextArea supInfo = new JTextArea();
		//A bit of formatting
		
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new deleteListener());
		add(deleteButton);
	}
	
	class deleteListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.println(GUIMain.FORMULAS.get(whichFormula).getName() + " was removed.");
			GUIMain.FORMULAS.rmFormula(whichFormula);
			Saver.saveForms(GUIMain.FORMULAS);
		}
	}

	
}