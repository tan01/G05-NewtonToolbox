package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.FormulaDatabase;
import storage.Saver;
import storage.UnitDatabase;
import storage.VariableDatabase;

/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to format
 * what we want in our GUI
 * 
 * @author May Camp
 * @author Michelle Len
 */
public class GUIAddVariable extends JPanel {

	private static final long serialVersionUID = 6187284211221392126L;

	private NewtonsToolboxPanel middlePanel;

	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel formatPanel;
	private NewtonsToolboxPanel unitPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagPanel;
	private NewtonsToolboxPanel addVariableButtonPanel;

	private JLabel nameLabel   = new JLabel("Name: ");
	private JLabel formatLabel = new JLabel("Format: ");
	private JLabel unitLabel   = new JLabel("Units: ");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagLabel    = new JLabel("Tags: ");

	private JTextField nameTextField   = new JTextField(57);
	private JTextField formatTextField = new JTextField(57);
	private JTextField unitTextField   = new JTextField(57); // Change to drop down later
	private JTextArea infoTextArea     = new JTextArea(16, 57);
	private JTextArea tagTextArea      = new JTextArea(4, 57);

	private JScrollPane infoScrollbar;
	private JScrollPane tagScrollbar;
	
	private JButton addVariableButton = new JButton("Add Variable");

	public GUIAddVariable() {
		
		//////////////NOTE TO SELF
		//need to add a scrollpanel to the units drop down units thing (JComboBox)
		//need to make action listener for button at bottom to save variables
		//need to delete unneeded setOpaque thing
		//need to reorganize
		//might want to change color of units JComboBox, as it is a gray-ish color

		setSize(720,480);
		//setBackground(new Color(0x3399CC));
		
		UnitDatabase defaultUnits = (UnitDatabase)Saver.loadUnits();
		JComboBox unitComboBox = new JComboBox();
		for(int i=0;i<defaultUnits.getSize();i++){
			unitComboBox.addItem(defaultUnits.get(i).getName());
		}
		
		middlePanel = new NewtonsToolboxPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.setSize(720, 480);
		//middlePanel.setBackground(new Color(0x3399CC));
		add(BorderLayout.NORTH, middlePanel);

		nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		formatLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		formatLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		unitLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		unitLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		infoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		infoLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		tagLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		tagLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		nameTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		nameTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		formatTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		formatTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		
		unitComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		unitComboBox.setAlignmentY(Component.CENTER_ALIGNMENT);
//		unitTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
//		unitTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		infoTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		infoTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);

		tagTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tagTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		addVariableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addVariableButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		// Scroll-bar for the Info JTextArea
		infoScrollbar = new JScrollPane(infoTextArea);
		infoScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll-bar for the Info JTextArea
		tagScrollbar = new JScrollPane(tagTextArea);
		tagScrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tagScrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		namePanel   = new NewtonsToolboxPanel();
		formatPanel = new NewtonsToolboxPanel();
		unitPanel   = new NewtonsToolboxPanel();
		infoPanel   = new NewtonsToolboxPanel();
		tagPanel    = new NewtonsToolboxPanel();
		
		addVariableButtonPanel = new NewtonsToolboxPanel();

		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		//namePanel.setBackground(new Color(0x3399CC));
		formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.X_AXIS));
		//formatPanel.setBackground(new Color(0x3399CC));
		unitPanel.setLayout(new BoxLayout(unitPanel, BoxLayout.X_AXIS));
		//unitPanel.setBackground(new Color(0x3399CC));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		//infoPanel.setBackground(new Color(0x3399CC));
		tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));
		//tagPanel.setBackground(new Color(0x3399CC));
		
		addVariableButtonPanel.setLayout(new BoxLayout(addVariableButtonPanel, BoxLayout.X_AXIS));
		//addVariableButtonPanel.setBackground(new Color(0x3399CC));
		
		//wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		//wrap words and lines and make sure you can't edit it
		tagTextArea.setLineWrap(true);
		tagTextArea.setWrapStyleWord(true);
		
		// NEED A TON OF ACTION LISTENERS (actually, only need one, there's only one button)

		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(12,0)));
		namePanel.add(nameTextField);

		formatPanel.add(formatLabel);
		formatPanel.add(Box.createRigidArea(new Dimension(5,0)));
		formatPanel.add(formatTextField);

		unitPanel.add(unitLabel);
		unitPanel.add(Box.createRigidArea(new Dimension(16,0)));
//		unitPanel.add(unitTextField);
		unitPanel.add(unitComboBox);

		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(24,0)));
		infoPanel.add(infoScrollbar);

		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(17,0)));
		tagPanel.add(tagScrollbar);
		
		addVariableButtonPanel.add(addVariableButton);

		middlePanel.add(namePanel);
		middlePanel.add(formatPanel);
		middlePanel.add(unitPanel);
		middlePanel.add(infoPanel);
		middlePanel.add(tagPanel);
		middlePanel.add(addVariableButtonPanel);
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		setOpaque(false);
		middlePanel.setOpaque(false);//THIS THING makes it not opaque
		
//		nameLabel.setOpaque(false);
//		formatLabel.setOpaque(false);
//		unitLabel.setOpaque(false);
//		infoLabel.setOpaque(false);
//		tagLabel.setOpaque(false);
//		addVariableButton.setOpaque(false);

		//nameTextField.setOpaque(false);
		//formatTextField.setOpaque(false);
		//unitTextField.setOpaque(false);
		//infoTextArea.setOpaque(false);
		//tagTextArea.setOpaque(false);
		
		//infoScrollbar.setOpaque(false);
		//tagScrollbar.setOpaque(false);
		
		namePanel.setOpaque(false);
		formatPanel.setOpaque(false);
		unitPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);
		
		addVariableButtonPanel.setOpaque(false);

	}
	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = 2571010965858865585L;
	}

}
