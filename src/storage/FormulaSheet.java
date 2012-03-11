package storage;

import java.io.Serializable;

/**
 * An arraylist object that serves the purpose of a cheat sheet for exams
 * @author Clayven Anderson
 * 
 */
public class FormulaSheet extends FormulaDatabase implements Serializable
{
  private String name; 
  final private static long serialVersionUID = 9258040L;
  
  public FormulaSheet(){
    super();
    this.name ="NewFormulaSheet" ;
  }
  
  /**
   * sets  the name of the formula sheet
   * @param n the name to be set
   */
  public void setName(String n){
    this.name = n;
  }
  
  /**
   * return the name of the formula sheet
   * @return the name of the formula sheet
   */
  public String getName(){
    return this.name;
  }
}
