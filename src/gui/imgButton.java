package gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * imageButton extends JButton.
 * Constructs with just a name,
 * needs corresponding images in the img folder.
 * 		img/buttons/<name>.png
 * 		img/buttons/<name>Pressed.png
 * Automatically creates an button that is just an image.
 * @author Jonny
 *
 */

public class imgButton extends JButton{
	
	private static final long serialVersionUID = 1021089159744389525L;

	/**
	 * Takes name of button which should also be the name of the image.
	 * @param name String containing the name of the button/image.
	 */
	
	imgButton(String name){
		setIcon(new ImageIcon("img/buttons/" + name + ".png"));
		try{
			setPressedIcon(new ImageIcon("img/buttons/" + name + "Pressed.png"));
		}catch(Exception ex){}
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		setHorizontalAlignment(JButton.LEADING);
		setBorderPainted(false);
		setContentAreaFilled(false);
	}
	
}