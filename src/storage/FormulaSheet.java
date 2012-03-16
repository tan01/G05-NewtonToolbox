package storage;

import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Term;
import internalformatting.Unit;
import internalformatting.Variable;

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
    this.name ="" ;
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
  /**
   * 
   * @return
   */
  public String printSheet()
  {
    String formInfo = "";
    
    for(int i=0; i < this.size();i++){
     formInfo = formInfo + this.get(i).allInfoToString() +"\n";
      
    }
    return formInfo;
   
  }
  
  
  
  
  public static void main(String[] args){
      FormulaDatabase src = Saver.loadForms();
      FormulaSheet des = new FormulaSheet();
      
      for(int i=0; i < 2; i++){
        System.out.println("loop:" + i);
        des.addFormula(src.get(i));
        System.out.println(des.get(i).allInfoToString());
      }
      
      des.setName("test");
      Saver.saveSheet(des);
    
  }
  
  
}
