package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
public class GUINewSheet extends JPanel {
	
	private static final long serialVersionUID = 56556326265896987l;
	
	private JPanel topPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();

	private JLabel nameLabel   = new JLabel("Sheet Name:");

	private JTextArea sheetTextArea  = new JTextArea(20, 51);

	JTextField nameBar = new JTextField(25);

	private JButton addFormulaButton = new JButton("Add Formula");
	private JButton saveButton = new JButton("Save Formula Sheet");

	private JScrollPane sheetScrollbar;

	private JComboBox<String> formComboBox;

	private FormulaSheet userSheet = new FormulaSheet();


	GUINewSheet() {

		setSize(720,480);
		setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// formComboBox is the drop-down menu for Formulas
		formComboBox = new JComboBox<String>();
		for (int i=0; i<GUIMain.FORMULAS.getSize(); i++) {
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

		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		add(BorderLayout.CENTER, middlePanel);

		topPanel.add(nameLabel);
		topPanel.add(Box.createRigidArea(new Dimension(5,0)));
		topPanel.add(nameBar);
		topPanel.add(Box.createRigidArea(new Dimension(10,0)));
		topPanel.add(addFormulaButton);
		topPanel.add(Box.createRigidArea(new Dimension(10,0)));
		topPanel.add(formComboBox);
		
		bottomPanel.add(saveButton);
		
		middlePanel.add(topPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(sheetScrollbar);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(bottomPanel);

		saveButton.addActionListener(new saveButtonListener());
		addFormulaButton.addActionListener( new addFormButtonListener());

	}

	public void setTextBox(FormulaSheet sheet) {
		String display = "";
		for (int i=0; i<sheet.size(); i++) {
			display = display + sheet.get(i).allInfoToString() + "\n";
		}
		sheetTextArea.setText(display);
	}

	class saveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = nameBar.getText();
			if (!(userInput.equals(""))) {
				userSheet.setName(userInput);
				Saver.saveSheet(userSheet);
				sheetTextArea.setText("Formula Sheet Saved");
			}
			else {
				String errorMessage = "You must give your sheet a name\n";

				JOptionPane.showMessageDialog(middlePanel,
						errorMessage,
						"Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	class addFormButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userSheet.addFormula(GUIMain.FORMULAS.get((formComboBox.getSelectedIndex())) );
			setTextBox(userSheet);
		}

	}
}