import java.io.Serializable;
import java.util.ArrayList;

/**
 * Formula Class for Newton's Toolbox.
 * Implements the method for representing a physics equation within the system.
 * TODO add necessary interactions with term class
 */

/**
 * @author Clayven Anderson
 * @version 2/15/12 for cs48 W12
 */
public class Formula extends ArrayList<Term> implements Serializable{
  
  private String Name;
  private String info = "";
  private Tags Tags = new Tags();
  
  /** default constructor*/
  public Formula(){
    super(1); //creates an array of capacity 1
    this.add(0,null);
    
}
 
  /**
   * @return the name of the formula
   */
  public String getName()
  {
    return Name;
  }


  /**
   * @param name the name of the formula
   */
  public void setName(String name)
  {
    Name = name;
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
    return Tags.getTag(i);
  }

  /**
   * @param tags the tags to set
   */
  public void addATag(String NewTag)
  {
    Tags.AddTag(NewTag);
  }
  
  /**
   * adds a term Object to the formula
   */
  public void AddTerm(Term newTerm){
    this.add(newTerm);
  }
  
  /** 
   * removes a selected Term (by index) from the Formula
   */
  public void deleteTerm(int i){
    this.remove(i);
  }
  
  
}