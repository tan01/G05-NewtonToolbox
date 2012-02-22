package internalformatting;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Formula Class for Newton's Toolbox.
 * Implements the method for representing a physics equation within the system.
 */

/**
 * @author Clayven Anderson
 * @version 2/15/12 for cs48 W12
 */
public class Formula extends ArrayList<Term> implements Serializable{
  
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
 
  /**
   * @return the name of the formula
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name of the formula
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @return the info, a short description of the function
   */
  public String getInfo()
  {
    return info;
  }


  /**
   * @param info the info to set, a string describing the function
   */
  public void setInfo(String info)
  {
    this.info = info;
  }


  /**
   * returns the "tag" at position i in the tags Array list
   * @return the tags
   * @param i i is the index of the desired tag
   */
  public String getTag(int i)
  {
    return tags.getTag(i);
  }
  
  public int getTagSize(){
    return tags.getSize();
  }

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
  
  /**
   * adds a term Object to the formula
   */
  public void addTerm(Term newTerm){
    this.add(newTerm);
  }
  
  /** 
   * removes a selected Term (by index) from the Formula
   */
  public void deleteTerm(int i){
    this.remove(i);
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
   * prints the formula's name and info 9as well as the formula itself) if a neatly formatted way
   * (at least it should)
   */
  public void printFormula(){
    System.out.println("Name: " + this.getName());
    System.out.println("Info: " + this.getInfo());
    System.out.println("Formula: " + this.toString());
    System.out.println("Tags: " + this.getAllTags());
  }
  
}