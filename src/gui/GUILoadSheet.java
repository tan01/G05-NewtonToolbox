package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.FormulaSheet;
import storage.Saver;

/**
 * @author Clayven Anderson
 */
public class GUILoadSheet extends JPanel {
	
	private static final long serialVersionUID = 354678202967285l;
	
	private JPanel loadPanel;
	private JPanel middlePanel;
	
	//search bar
	private JTextField loadBar    = new JTextField(55);
	private JButton loadButton    = new JButton("Load");
	private JTextArea loadResults = new JTextArea(22,55);
	
	private JScrollPane scroller;

	public GUILoadSheet() {

		setSize(720,480);
		setOpaque(false);
		
		//panels
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));	
		middlePanel.setOpaque(false);
		
		loadPanel = new JPanel();
		loadPanel.setLayout(new BoxLayout(loadPanel, BoxLayout.X_AXIS));
		loadPanel.setOpaque(false);
		
		//wrap words and lines and make sure you can't edit it
		loadResults.setLineWrap(true);
		loadResults.setWrapStyleWord(true);
		loadResults.setEditable(false);

		//scroller
		scroller = new JScrollPane(loadResults);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(BorderLayout.CENTER, middlePanel);

		loadPanel.add(loadBar);
		loadPanel.add(Box.createRigidArea(new Dimension(10,0)));
		loadPanel.add(loadButton);
		
		middlePanel.add(loadPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(scroller);

		loadButton.addActionListener(new loadButtonListener());

		loadBar.addKeyListener (
				new KeyAdapter() {
					public void keyPressed(KeyEvent key) {
						if (key.getKeyCode()==KeyEvent.VK_ENTER) {
							display();
						}
					}
				}
				);

	}

	class loadButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display();
		}

	}

	public void display() {
		String display ="";
		String userInput = loadBar.getText();
		FormulaSheet recovered = Saver.loadSheet(userInput);
		if (recovered.getName().equals("")) {
		  String errorMessage = "Sheet Not Found.\n";
      
      JOptionPane.showMessageDialog(middlePanel,
          errorMessage,
          "Error",
          JOptionPane.WARNING_MESSAGE);
		}
		else {
			display = display + "Formula Sheet: " + recovered.getName() + "\n\n";
			for (int i=0; i < recovered.size(); i++) {
				display = display + recovered.get(i).allInfoToString() + "\n";
			}
			loadResults.setText(display);
		}
	}

}