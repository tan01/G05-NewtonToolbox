package gui;
import internalformatting.Tags;
import internalformatting.Unit;
import internalformatting.Variable;

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

import storage.Saver;
import storage.VariableDatabase;

/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to format
 * what we want in our GUI
 * 
 * @author May Camp
 * @author Michelle Len
 * @author Jonathan Tan
 */
public class GUIAddVariable extends JPanel {

	private static final long serialVersionUID = 6187284211221392126L;

	private JPanel middlePanel;

	private JPanel namePanel;
	private JPanel unitPanel;
	private JPanel infoPanel;
	private JPanel tagPanel;
	private JPanel addVariableButtonPanel;

	// INCORPORATED TWO-LINED LABELS - MICHELLE
	private JLabel nameLabel   = new JLabel("<HTML>Name <BR>(like 'x'): </HTML>");
	private JLabel unitLabel   = new JLabel("Units: ");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagLabel    = new JLabel("<HTML>Tags <BR>(separated by ','): </HTML>");

	private JTextField nameTextField   = new JTextField(52);
	private JTextField unitTextField   = new JTextField(51);
	private JTextArea infoTextArea     = new JTextArea(13, 51);
	private JTextArea tagsTextArea      = new JTextArea(4, 51);

	private JScrollPane infoScrollbar;
	private JScrollPane tagScrollbar;

	private JButton addVariableButton = new JButton("Add Variable");

	private JComboBox<String> unitComboBox;

	public GUIAddVariable() {

		setSize(720,480);

		// unitComboBox is the drop-down menu for Units
		unitComboBox = new JComboBox<String>();
		for(int i=0;i<GUIMain.UNITS.getSize();i++){
			unitComboBox.addItem(GUIMain.UNITS.get(i).getName());
		}

		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.setSize(720, 480);
		add(BorderLayout.CENTER, middlePanel);

		// Scroll-bar for the Info JTextArea
		infoScrollbar = new JScrollPane(infoTextArea);
		infoScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll-bar for the Info JTextArea
		tagScrollbar = new JScrollPane(tagsTextArea);
		tagScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tagScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		namePanel   = new JPanel();
		unitPanel   = new JPanel();
		infoPanel   = new JPanel();
		tagPanel    = new JPanel();

		addVariableButtonPanel = new JPanel();

		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		unitPanel.setLayout(new BoxLayout(unitPanel, BoxLayout.X_AXIS));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		tagPanel.setLayout (new BoxLayout(tagPanel, BoxLayout.X_AXIS));

		addVariableButtonPanel.setLayout(new BoxLayout(addVariableButtonPanel, BoxLayout.X_AXIS));

		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		//wrap words and lines and make sure you can't edit it
		tagsTextArea.setLineWrap(true);
		tagsTextArea.setWrapStyleWord(true);

		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(58,0)));
		namePanel.add(nameTextField);

		unitPanel.add(unitLabel);
		unitPanel.add(Box.createRigidArea(new Dimension(69,0)));
		unitPanel.add(unitComboBox);

		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(77,0)));
		infoPanel.add(infoScrollbar);

		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(7,0)));
		tagPanel.add(tagScrollbar);

		addVariableButtonPanel.add(addVariableButton);

		middlePanel.add(namePanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(unitPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(infoPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(tagPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(addVariableButtonPanel);

		setOpaque(false);
		middlePanel.setOpaque(false);//THIS THING makes it not opaque

		namePanel.setOpaque(false);
		unitPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);

		addVariableButton.addActionListener(new addVariableButtonListener());

		addVariableButtonPanel.setOpaque(false);

	}

	//Button Listener Class
	class addVariableButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String variableName = nameTextField.getText();
			String variableInfo = infoTextArea.getText();
			String variableTagsString = tagsTextArea.getText();

			if(!(variableName.equals("") || variableInfo.equals("") ||
					variableTagsString.equals(""))) {	
				
				Tags tagsTemp = Tags.convertToTags(variableTagsString);

				Variable newVariable = new Variable(variableName);
				newVariable.setInfo(variableInfo);
				
				Unit newUnit = GUIMain.UNITS.get(unitComboBox.getSelectedIndex());
				
				newVariable.setUnit(newUnit);
				for(int i=0;i<tagsTemp.size();i++){
					newVariable.addTag(tagsTemp.get(i));
				}
				
				// Add unit tags to variable
				for(int i=0; i<newUnit.getTagSize(); i++) {
					newVariable.addTag(newUnit.getTag(i));
				}
				
				((VariableDatabase)GUIMain.VARIABLES).addVariable(newVariable);
				Saver.saveVars(GUIMain.VARIABLES);

				nameTextField.setText("");
				unitTextField.setText("");
				infoTextArea.setText("");
				tagsTextArea.setText("");
				


			}else {
				String errorMessage = "You left something blank:\n";
				if(variableName.equals(""))
					errorMessage += "-Name\n";
				if(variableInfo.equals(""))
					errorMessage += "-Info\n";
				if(variableTagsString.equals(""))
					errorMessage += "-Tags\n";
				JOptionPane.showMessageDialog(middlePanel,
						errorMessage,
						"Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	class createUnitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			middlePanel.removeAll();
			GUIMain.updateUI();
			middlePanel.add(new GUIAddUnit());
		}
	}

}
