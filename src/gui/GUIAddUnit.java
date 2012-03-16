package gui;
import internalformatting.Tags;
import internalformatting.Unit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import storage.Saver;
import storage.UnitDatabase;

/**
 * GUIAddUnit used to search for formulas from the formula database * 
 * @author May Camp
 * @author Michelle Len
 */
public class GUIAddUnit extends JPanel {

	private static final long serialVersionUID = 9044967744683200942L;

	// middlePanel is the main panel
	private NewtonsToolboxPanel middlePanel;

	// sub-panels to be added to main panel
	private NewtonsToolboxPanel namePanel;
	private NewtonsToolboxPanel formatPanel;
	private NewtonsToolboxPanel infoPanel;
	private NewtonsToolboxPanel tagsPanel;
	private NewtonsToolboxPanel addUnitButtonPanel;

	// Initializing all widgets: Labels, TextFields, TextAreas, and Buttons
	private JLabel nameLabel   = new JLabel("<HTML>Name <BR>(like 'meter'): </HTML>");
	private JLabel formatLabel = new JLabel("<HTML>Format <BR>(like 'm'): </HTML>");
	private JLabel infoLabel   = new JLabel("Info: ");
	private JLabel tagsLabel   = new JLabel("<HTML>Tags <BR>(separated by ','): </HTML>");

	private JTextField nameField   = new JTextField(51);
	private JTextField formatField = new JTextField(51);
	private JTextArea infoTextArea = new JTextArea(13, 50);
	private JTextArea tagsTextArea = new JTextArea(4, 50);

	private JButton addUnitButton = new JButton("Add Unit");

	// Declaring Scrollbars
	private JScrollPane infoScroller;
	private JScrollPane tagScroller;

	public GUIAddUnit() {

		setSize(720,480);

		// Initializing middlePanel, and setting the layout
		middlePanel = new NewtonsToolboxPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));		
		middlePanel.setSize(720,480);
		add(BorderLayout.CENTER, middlePanel);

		// Scroll-bar for the infoTextArea
		infoScroller = new JScrollPane(infoTextArea);
		infoScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Scroll-bar for the tagsTextArea
		tagScroller = new JScrollPane(tagsTextArea);
		tagScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tagScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Initializing all sub-panels
		namePanel   = new NewtonsToolboxPanel();
		formatPanel = new NewtonsToolboxPanel();
		infoPanel   = new NewtonsToolboxPanel();
		tagsPanel   = new NewtonsToolboxPanel();

		// Initializing the panel containing the "Add Unit" Button
		addUnitButtonPanel = new NewtonsToolboxPanel();

		// Setting the layout of all sub-panels
		namePanel.setLayout  (new BoxLayout(namePanel,   BoxLayout.X_AXIS));
		formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.X_AXIS));
		infoPanel.setLayout  (new BoxLayout(infoPanel,   BoxLayout.X_AXIS));
		tagsPanel.setLayout  (new BoxLayout(tagsPanel,   BoxLayout.X_AXIS));

		// Setting the layout of the "Add Unit" Button panel
		addUnitButtonPanel.setLayout (new BoxLayout(addUnitButtonPanel, BoxLayout.X_AXIS));

		// Wrap words and lines and make sure you can't edit it
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		tagsTextArea.setLineWrap(true);
		tagsTextArea.setWrapStyleWord(true);

		// Setting all panels' opacities to FALSE.
		setOpaque(false);
		middlePanel.setOpaque(false);
		namePanel.setOpaque(false);
		formatPanel.setOpaque(false);
		infoPanel.setOpaque(false);
		tagsPanel.setOpaque(false);
		addUnitButtonPanel.setOpaque(false);

		// Adding widgets to the Name Panel (Label and TextField)
		namePanel.add(nameLabel);
		namePanel.add(Box.createRigidArea(new Dimension(33,0)));
		namePanel.add(nameField);

		// Adding widgets to the Format Panel (Label and TextField)
		formatPanel.add(formatLabel);
		formatPanel.add(Box.createRigidArea(new Dimension(56,0)));
		formatPanel.add(formatField);

		// Adding widgets to the Info Panel (Label and ScrollPane)
		infoPanel.add(infoLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(80,0)));
		infoPanel.add(infoScroller);// infoTextArea is inside the Scroll-Pane

		// Adding widgets to the Tag Panel (Label and ScrollPane)
		tagsPanel.add(tagsLabel);
		tagsPanel.add(Box.createRigidArea(new Dimension(10,0)));
		tagsPanel.add(tagScroller);

		// Adding Button widget to the Add Variable Button Panel
		addUnitButtonPanel.add(addUnitButton);


		// Finally, add all panels to the panels~
		middlePanel.add(namePanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(formatPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(infoPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(tagsPanel);
		middlePanel.add(Box.createRigidArea(new Dimension(0,10)));
		middlePanel.add(addUnitButtonPanel);	

		// Adding an Action Listener to our Button
		addUnitButton.addActionListener(new addUnitButtonListener());
		//Sets the addUnitButton to default so you can hit enter in a text field and it'll make with the magic.
		GUIMain.frame.getRootPane().setDefaultButton(addUnitButton);

	}

	public class NewtonsToolboxPanel extends JPanel {
		// Included to suppress Eclipse Warning
		private static final long serialVersionUID = -3226654973851691774L;
	}

	//Button Listener Classes:
	class addUnitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String unitName       = nameField.getText();			
			String unitFormat     = formatField.getText();
			String unitInfo       = infoTextArea.getText();
			String unitTagsString = tagsTextArea.getText();

			if (!(unitName.equals("") || unitFormat.equals("") ||
					unitInfo.equals("") || unitTagsString.equals(""))) {

				Tags tagsTemp = Tags.convertToTags(unitTagsString);

				Unit newUnit = new Unit(unitName);
				newUnit.setTypicalForm(unitFormat);
				newUnit.setInfo(unitInfo);

				for (int i=0; i<tagsTemp.size(); i++){
					newUnit.addTag(tagsTemp.get(i));
				}

				((UnitDatabase)GUIMain.UNITS).addUnit(newUnit);
				Saver.saveUnits(GUIMain.UNITS);

				nameField.setText("");
				formatField.setText("");
				infoTextArea.setText("");
				tagsTextArea.setText("");
			} 
			else {

				String errorMessage = "You left something blank:\n";

				if(unitName.equals(""))
					errorMessage += "-Name\n";
				if(unitFormat.equals(""))
					errorMessage += "-Format\n";
				if(unitInfo.equals(""))
					errorMessage += "-Info\n";
				if(unitTagsString.equals(""))
					errorMessage += "-Tags\n";

				JOptionPane.showMessageDialog(middlePanel,
						errorMessage,
						"Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		
	}

} // class GUIAddUnit