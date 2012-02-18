package internalformatting;
/** Unit is a class to represent units such as "mass," "gram," and "second"
 * @author May Camp
 * @author Michelle Len
 * @version 02/18/2012 for CS 48 Project, W12
 */

public class Unit {
	
	private String name; // name of the Unit
	private String info; //	information about the Unit
	private String tags; // Unit tags
	private String typicalForm; // typical form of a Unit i.e. kg instead of g

	/** 
	 * Default constructor with null values
	 */
	
	public Unit () {
		this.name = null;
		this.info = null;
		this.tags = null;
		this.typicalForm = null;
	}
	
	/** Constructor
	 * @param unitName A string containing the unit name
	 */
	
	public Unit (String unitName) {
		this.name = unitName;
		this.info = "unspecified info";
		this.tags = "untagged";
		this.typicalForm = "unset typical physics form";
	}
	
	/**
	 * Get methods for name, info, tags, and typical form
	 */
	
	public String getName() { return this.name; }
	public String getInfo() { return this.info; }
	public String getTags() { return this.tags; }
	public String getTypicalForm() { return this.typicalForm; }
	
	/**
	 * Set methods for name, info, tags, and typical form
	 */
	
	public void setName(String n) { this.name = n; }
	public void setInfo(String i) { this.info = i; }
	public void setTags(String t) { this.tags = t; }
	public void setTypicalForm(String tf) { this.typicalForm = tf; }
	
} // class Unit