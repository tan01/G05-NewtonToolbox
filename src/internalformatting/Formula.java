package internalformatting;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

/**
 * Formula Class for Newton's Toolbox.
 * Implements the method for representing a physics equation within the system.
 */

/**
 * @author Clayven Anderson
 * @version 2/15/12 for cs48 W12
 */
public class Formula extends ArrayList<Component> implements Serializable{

	private String name;
	private String info = "";
	private Tags tags = new Tags();
	private static final long serialVersionUID =  3969121L;

	/** default constructor*/
	public Formula(){
		super(); //creates an ArrayList of capacity 1
		this.clear();   
	}

	/**
	 * 
	 * @param name Name of the formula
	 * @param info A String of a formula
	 */
	public Formula(String name, String info){
		super(); //creates an ArrayList of capacity 1
		this.clear();
		this.name = name;
		this.info = info;
	}

	public String getName()	{return name;}
	public String getInfo()	{return info;}

	/**
	 * returns the "tag" at position i in the tags Array list
	 * @return the tags
	 * @param i i is the index of the desired tag
	 */
	public String getTag(int i)	{return tags.getTag(i);}
	public int getTagSize(){return tags.getSize();}
	public Tags getTags() { return this.tags; }
	public String getAllTags(){return tags.returnAllTags();}
	public void setName(String name){this.name = name;}
	public void setInfo(String info){this.info = info;}
	public void setTags(Tags tags) { this.tags = tags; }

	public void addTag(String NewTag){tags.addTag(NewTag);}

	/**
	 * adds a term Object to the formula
	 */
	public void addTerm(Component newTerm){
		this.ensureCapacity(this.size() + 1);
		if(newTerm.getType() == 1 ) {
			// Add variable tags to formula
			for(int i=0; i<((Term) newTerm).getVariable().getTagSize(); i++) {
				addTag(((Term) newTerm).getVariable().getTag(i));
			}
			getTags().deleteDuplicateTags();
		}
		this.add(newTerm);
	}

	/** 
	 * removes a selected Term (by index) from the Formula
	 */
	public void deleteTerm(int i){this.remove(i);}

	/**
	 * prints the formula's name and info (as well as the formula itself) if a neatly formatted way
	 * (at least it should)
	 */
	public void printFormula(){
		System.out.println("Name: " + this.getName());
		System.out.println("Info: " + this.getInfo());
		System.out.println("Formula: " + this.toString());
		System.out.println("Tags: " + this.getAllTags());
	}

	/** TEMPORARY TOSTRING METHOD
	 * NEEDS PROPER UNIT OPERATOR SUPPORT
	 */
	public String toString(){
		String result = "";
		for(int i=0;i<this.size();i++){
			result += this.get(i).toString();
			result += (" ");
		}
		return result;
	}

	/**
	 * puts formula's name and info (as well as the formula itself) if a neatly formatted String
	 * (at least it should)
	 */
	public String allInfoToString(){
		String allInfo = "";

		allInfo = allInfo + "Name: "    + this.getName() + "\n";
		allInfo = allInfo + "Info: "    + this.getInfo() + "\n";
		allInfo = allInfo + "Formula: " + this.toString() + "\n";
		allInfo = allInfo + "Tags: "    + this.getAllTags() + "\n";

		return allInfo;
	}

	/**
	 * toLaTeX() returns this formula with LaTeX formatting.
	 */
	public String toLaTeX(){
		//PLACEHOLDER - INCOMPLETE
		String LaTeXString = "";
		for(int i=0;i<this.size();i++){
			LaTeXString += this.get(i).toLaTeX();
		}
		System.out.println(LaTeXString);
		return LaTeXString;
	}

	//Can't get this to work.
	public BufferedImage toLaTeXImage() {
		TeXFormula fomule = new TeXFormula("x = a_0 + \\cfrac{1}{a_1 + \\cfrac{1}{a_2 + \\cfrac{1}{a_3 + a_4}}}");
		TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, 40);
		BufferedImage b = new BufferedImage(ti.getIconWidth(), ti
				.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		return b;
	}

	public TeXIcon toLaTeXIcon() {
		TeXFormula fomule = new TeXFormula(toLaTeX());
		TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, 24);
		BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);
		return ti;
	}
}