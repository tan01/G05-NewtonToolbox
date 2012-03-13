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
  /**
   * 
   * @return
   */
  public String printSheet()
  {
    if(this == null){
      return("Sheet Not Found");
    }
    String formInfo = "";
    
    for(int i=0; i > this.size();i++){
     formInfo = formInfo + this.get(i)+"\n";
      
    }
    return formInfo;
   
  }
  
  
  public static void main(String[] args){
    FormulaDatabase el = Saver.loadForms();
    el = Saver.loadForms();
    
    FormulaSheet test = new FormulaSheet();
    
    for(int i=0; i > 3; i++){
      test.add(el.getFormula(i));
    }
    
    
    test.setName("blah");
    Saver.saveSheet(test);
    
    test.printSheet();
  }
  
}
