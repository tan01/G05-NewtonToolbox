package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * Another GUI to learn a bit about gui making,
 * and to make a slightly different way to format
 * what we want in our GUI
 * 
 * @author May Camp
 * @author Michelle Len
 */
//Forms = Formulas
public class GUIAddVariable extends JPanel {

	private static final long serialVersionUID = 6187284211221392126L;

	private NewtonsToolboxPanel middlePanel;
	
	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel formatPanel;
	private NewtonsToolboxPanel unitPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagPanel;
	
	private JLabel nameLabel   = new JLabel("Name: ");
	private JLabel formatLabel = new JLabel("Format: ");
	private JLabel unitLabel   = new JLabel("Units: ");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagLabel    = new JLabel("Tags: ");
	
	private JTextField nameTextField   = new JTextField(57);
	private JTextField formatTextField = new JTextField(57);
	private JTextField unitTextField   = new JTextField(57); // Change to drop down later
	private JTextArea infoTextArea     = new JTextArea(21, 57);
	private JTextField tagTextField    = new JTextField(57);
	
	public GUIAddVariable() {
		
		setSize(720,480);
		
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

		unitTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		unitTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		infoTextArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		infoTextArea.setAlignmentY(Component.CENTER_ALIGNMENT);

		tagTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tagTextField.setAlignmentY(Component.CENTER_ALIGNMENT);

		middlePanel = new NewtonsToolboxPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.setSize(720, 480);
		add(BorderLayout.NORTH, middlePanel);
		
		namePanel   = new NewtonsToolboxPanel();
		formatPanel = new NewtonsToolboxPanel();
		unitPanel   = new NewtonsToolboxPanel();
		infoPanel   = new NewtonsToolboxPanel();
		tagPanel    = new NewtonsToolboxPanel();
		
		namePanel.setOpaque(false);
		formatPanel.setOpaque(false);
		unitPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagPanel.setOpaque(false);
		
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.X_AXIS));
		unitPanel.setLayout(new BoxLayout(unitPanel, BoxLayout.X_AXIS));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));
		
		// NEED A TON OF ACTION LISTENERS
		
		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(12,0)));
		namePanel.add(nameTextField);
		
		formatPanel.add(formatLabel);
		formatPanel.add(Box.createRigidArea(new Dimension(5,0)));
		formatPanel.add(formatTextField);
		
		unitPanel.add(unitLabel);
		unitPanel.add(Box.createRigidArea(new Dimension(16,0)));
		unitPanel.add(unitTextField);
		
		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(24,0)));
		infoPanel.add(infoTextArea);
		
		tagPanel.add(tagLabel);
		tagPanel.add(Box.createRigidArea(new Dimension(16,0)));
		tagPanel.add(tagTextField);
		
		middlePanel.add(namePanel);
		middlePanel.add(formatPanel);
		middlePanel.add(unitPanel);
		middlePanel.add(infoPanel);
		middlePanel.add(tagPanel);
		
	}
	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = 2571010965858865585L;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(720, 480);
		frame.setVisible(true);
		frame.add(new GUIAddVariable());
	}
	
}
