package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import storage.Saver;

/**
 * GUIPrint
 * Prints all formulas in database. I guess.
 * @author Jonathan Tan
 *
 */
//Forms = Formulas
public class GUIPrint extends JPanel{

	private static final long serialVersionUID = 4873979511500578495L;
	private JPanel contentPanel = new JPanel();
	private JTextPane output = new JTextPane();
	private StyledDocument doc = output.getStyledDocument();
	private JScrollPane scroller = new JScrollPane(output);
	
	private GUIPrint thisReference = this;

	public GUIPrint(){
		//formatting text pane
		addStylesToDocument(doc);
		output.setPreferredSize(new Dimension(706,450));
		
		//Scroller
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		String writeBuffer = "";
		
		

		//FORMULA HEADER
		//		writeBuffer ="[FORMULAS] \n";
		//		try{
		//			doc.insertString(doc.getLength(),writeBuffer,doc.getStyle("bold"));
		//			}catch(BadLocationException ble){
		//				System.err.println("Couldn't insert text into text pane.");
		//			}
		output.insertIcon(new ImageIcon("img/formulaheader.png"));
		//This is retarded.
		//There has to be a better way to force newlines in a TextPane.
		//I loving hate TextPanes.
		try{
			doc.insertString(doc.getLength(),"\n",doc.getStyle("regular"));
		}catch(BadLocationException ble){
			System.err.println("Couldn't insert text into text pane.");
		}

		for(int i=0; i<GUIMain.FORMULAS.size();i++) {
			infoLabel formulaLabel = new infoLabel(GUIMain.FORMULAS.get(i).toLaTeXIcon(),i);
			output.insertComponent(formulaLabel);
			formulaLabel.addMouseListener(formulaLabel);
			writeBuffer = "\n" + GUIMain.FORMULAS.get(i).getName() + "\n \n";
			try{
				doc.insertString(doc.getLength(),writeBuffer,doc.getStyle("regular"));
			}catch(BadLocationException ble){
				System.err.println("Couldn't insert text into text pane.");
			}
		}


		//VARIABLE HEADER
		output.insertIcon(new ImageIcon("img/varheader.png"));
		//This is retarded.
		//There has to be a better way to force newlines in a TextPane.
		//I loving hate TextPanes.
		try{
			doc.insertString(doc.getLength(),"\n",doc.getStyle("regular"));
		}catch(BadLocationException ble){
			System.err.println("Couldn't insert text into text pane.");
		}


		for(int i=0; i<GUIMain.VARIABLES.size();i++) {
			writeBuffer =
					GUIMain.VARIABLES.get(i).getVar() + "   Units: " +
							GUIMain.VARIABLES.get(i).getUnit() + "\n" + "Info: " +
							GUIMain.VARIABLES.get(i).getInfo() + "\n" + "Tags: " +
							GUIMain.VARIABLES.get(i).getTags() + "\n";
			
			try{
				doc.insertString(doc.getLength(),writeBuffer,doc.getStyle("regular"));
				genericDeleteButton del = new genericDeleteButton(i,(byte) 1);
				output.insertComponent(del);
				doc.insertString(doc.getLength(),"\n\n",doc.getStyle("regular"));
			}catch(BadLocationException ble){
				System.err.println("Couldn't insert text into text pane.");
			}
			
		}


		//UNIT HEADER
		output.insertIcon(new ImageIcon("img/unitheader.png"));
		//This is retarded.
		//There has to be a better way to force newlines in a TextPane.
		//I loving hate TextPanes.
		try{
			doc.insertString(doc.getLength(),"\n",doc.getStyle("regular"));
		}catch(BadLocationException ble){
			System.err.println("Couldn't insert text into text pane.");
		}


		for(int i=0; i<GUIMain.UNITS.size();i++) {
			writeBuffer =
					GUIMain.UNITS.get(i).getName() + "\n" + "Info: " +
							GUIMain.UNITS.get(i).getInfo() + "\n" + "Tags: " +
							GUIMain.UNITS.get(i).getAllTags() + "\n";
			try{
				doc.insertString(doc.getLength(),writeBuffer,doc.getStyle("regular"));
				genericDeleteButton del = new genericDeleteButton(i,(byte) 0);
				output.insertComponent(del);
				doc.insertString(doc.getLength(),"\n\n",doc.getStyle("regular"));
			}catch(BadLocationException ble){
				System.err.println("Couldn't insert text into text pane.");
			}
			
		}

		contentPanel.setOpaque(false);
		contentPanel.add(scroller);
		add(contentPanel);
	}

	private void addStylesToDocument(StyledDocument doc) {
		//Taken right out of the TextSamplerDemo from Oracle.
		//Initialize some styles.
		Style def = StyleContext.getDefaultStyleContext().
				getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = doc.addStyle("regular", def);
		StyleConstants.setFontFamily(def, "SansSerif");

		Style s = doc.addStyle("italic", regular);
		StyleConstants.setItalic(s, true);

		s = doc.addStyle("bold", regular);
		StyleConstants.setBold(s, true);

		s = doc.addStyle("small", regular);
		StyleConstants.setFontSize(s, 10);

		s = doc.addStyle("large", regular);
		StyleConstants.setFontSize(s, 16);

	}
	
	public void back(){
		contentPanel.removeAll();
		contentPanel.add(scroller);
		GUIMain.updateUI();
	}
	
	/**
	 * infoLabel inner class allows the JLabel to be used as its own MouseListener, so that
	 * it can replace this panel with the appropriate info page when clicked, or take other action.
	 * Right now, it deletes the formula.
	 * @author Jonny
	 * @version WIP
	 */
	public class infoLabel extends JLabel implements MouseListener{
		
		private static final long serialVersionUID = 8846844615910775776L;
		public int index;
		
		public infoLabel(Icon image, int i){
			super(image);
			index = i;
		}
		
		public void mouseClicked(MouseEvent arg0) {

			GUIInfoPane formulaInfo = new GUIInfoPane(index,thisReference);
			formulaInfo.setSize(720,480);
			contentPanel.removeAll();
			contentPanel.add(formulaInfo);
			GUIMain.updateUI();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		
		
	}//infolabel class delimit
	
	public class genericDeleteButton extends JButton implements ActionListener{

		private static final long serialVersionUID = -1546008546894170764L;
		public int index;
		//Units is 0
		//Variables is 1
		public byte type;
		
		private final byte UNIT = 0;
		private final byte VAR = 1;
		
		public genericDeleteButton(int i, byte type){
			super("Delete");
			index = i;
			this.type = type;
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {
			if(type==UNIT){
			System.out.println(GUIMain.UNITS.get(index).getName() + " was removed.");
			GUIMain.UNITS.rmUnit(index);
			Saver.saveUnits(GUIMain.UNITS);
			}
			
			if(type==VAR){
				System.out.println(GUIMain.VARIABLES.get(index).getVar() + " was removed.");
				GUIMain.VARIABLES.rmVariable(index);
				Saver.saveVars(GUIMain.VARIABLES);
				}
		}
		
		
		
	}
	
}
