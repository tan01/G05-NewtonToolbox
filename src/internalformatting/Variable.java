package internalformatting;

import java.io.Serializable;

/** Variable is a class to represent a variable
 * @author Michelle Len
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */

public class Variable implements Serializable{
	private String var; // variable represented as a char
	private double value; //value of the variable
	private String info = "";
	private Unit unit;
	private Tags tags = new Tags();
	final private static long serialVersionUID = 8383008L;

	/** Constructor	to make a Variable with just a string to represent it
	 * @param var  A short String representation of the variable
	 */
	public Variable (String var) {
		// assign attributes from parameters
		this.var = var;
	}

	/** Constructor with variable and value
	 * @param var    A short String representation of the variable
	 * @param value  A double representing the variable value
	 */
	public Variable (String var, double value){
		this.var = var;
		this.value = value;
	}

	/** Constructor
	 * @param var
	 * @param info
	 */
	public Variable (String var, String info) {
		this.var = var;
		this.info = info;
	}
	/** Constructor
	 * @param var
	 * @param info
	 * @param tags
	 */
	public Variable (String var, String info, Tags tags) {
		this.var = var;
		this.info = info;
		this.tags = tags;
	}

	public void setVar (String var) { this.var = var; }

	public void setValue (double value) { this.value = value; }

	public void setInfo (String info) { this.info = info; }

	public void setUnit(Unit unit) { 
		// Add unit tags to variable
		for(int i=0; i<unit.getTagSize(); i++) {
			addTag(unit.getTag(i));
		}
		getTags().deleteDuplicateTags();

		this.unit = unit;
	}

	/**
	 * @param tags the tags to set
	 */
	public void addTag(String NewTag){tags.addTag(NewTag);}

	public void setTags(Tags tags) { this.tags = tags; }

	public String getVar () { return this.var; }
	public double getValue() { return this.value; }
	public String getInfo() { return this.info; }
	public Unit getUnit() { return this.unit; }
	/**
	 * returns the "tag" at position i in the tags Array list
	 * @return the tags
	 * @param i i is the index of the desired tag
	 */
	public String getTag(int i){return tags.getTag(i);}

	public Tags getTags() { return this.tags; }

	public int getTagSize(){return tags.getSize();}

	public String getAllTags(){return tags.returnAllTags();}

	/**
	 * prints the formula's name and info (as well as the formula itself) if a neatly formatted way
	 * (at least it should)
	 */
	public void printVariable(){
		System.out.println("Name: " + this.getVar());
		System.out.println("Units: " + this.getUnit());
		System.out.println("Info: " + this.getInfo());
		System.out.println("Tags: " + this.getAllTags());
	}

	/**
	 * @return var  Variable as a string
	 */
	public String toString() {
		return var;
	} // do we need this method?

	public String allInfoToString(){
		String allInfo = "";

		allInfo = allInfo + "Name: "    + this.getVar() + "\n";
		allInfo = allInfo + "Info: "    + this.getInfo() + "\n";
		allInfo = allInfo + "Unit: "    + this.getUnit() + "\n";
		allInfo = allInfo + "Tags: "    + this.getAllTags() + "\n";

		return allInfo;
	}

} // class Variable