package internalformatting;

import java.io.Serializable;

/** Unit is a class to represent units such as "mass," "gram," and "second"
 * @author May Camp
 * @author Michelle Len
 * @version 02/18/2012 for CS 48 Project, W12
 */

public class Unit implements Serializable {
	
	private String name; // name of the Unit
	private String info; //	information about the Unit
	private String typicalForm; // typical form of a Unit i.e. kg instead of g
	private Tags tags = new Tags();
	final private static long serialVersionUID = 7147438L;
	
	/** 
	 * Default constructor with null values
	 */
	
	public Unit () {
		this.name = null;
		this.info = null;
		this.typicalForm = null;
	}
	
	/** Constructor
	 * 
	 * @param unitName A string containing the unit name
	 */
	
	public Unit (String unitName) {
		this.name = unitName;
		this.info = "unspecified info";
		this.typicalForm = "unset typical physics form";
	}
	
	/**
	 * Get methods for name, info, tags, and typical form
	 */
	
	public String getName() { return this.name; }
	public String getInfo() { return this.info; }
	public String getTypicalForm() { return this.typicalForm; }
	
	/**
	 * Set methods for name, info, tags, and typical form
	 */
	
	public void setName(String n) { this.name = n; }
	public void setInfo(String i) { this.info = i; }
	public void setTypicalForm(String tf) { this.typicalForm = tf; }
	
	
	/**
   * returns the "tag" at position i in the tags Array list
   * @return the tags
   * @param i i is the index of the desired tag
   */
  public String getTag(int i)
  {
    return tags.getTag(i);
  }
/**
 * returns size of tag array associated with the unit
 * @return
 */
  public int getTagSize(){
    return tags.getSize();
  }
/**
 * returns all tags associated with unit
 * @return
 */
  public String getAllTags(){
    return tags.returnAllTags();
  }

  /**
   * @param tags the tags to set
   */
  public void addTag(String NewTag)
  {
    tags.addTag(NewTag);
  }
	
} // class Unit