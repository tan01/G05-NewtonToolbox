package storage;

import internalformatting.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class saves and loads the formula database
 * @author Clayven Anderson
 *
 */


public class FormulaSaver
{
  public static void SaveForms(FormulaDatabase Forms){
    try{
      File dir = new File("data");
      dir.mkdir();
      File store = new File("data/" ,"FormulaDatabase.ntb" );
      FileOutputStream fs = new FileOutputStream(store);
      ObjectOutputStream os = new ObjectOutputStream(fs);
      
      os.writeObject(Forms);
      os.close();
      
    }catch (IOException ex){
      ex.printStackTrace();
    }      
  }
  
  public static  Object LoadForms(){
    FormulaDatabase One = new FormulaDatabase(); 
    try{
      ObjectInputStream is = new ObjectInputStream(new FileInputStream("data/FormulaDatabase.ntb"));
      One = (FormulaDatabase) is.readObject();
      
    } catch(Exception ex){
      ex.printStackTrace();
    }
    
    return One;
  }
  
  public static void main(String[] args){
	  
	  //May's default formulas
	  ArrayList<Formula> someFormulas = new ArrayList<Formula>();
		
		Variable newVar = new Variable("x");
		
		Term newTerm = new Term(5.0, newVar, 2, null);
		Term newTerm2 = new Term(6.0, newVar, 3, null);
		Term newTerm3 = new Term(7.0, newVar, 4, null);
		Term newTerm4 = new Term(8.0, newVar,5,null);
		
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		Formula newFormula3 = new Formula();
		
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.addTerm(newTerm);
		newFormula.addATag("random");
		newFormula.addATag("mass");
		newFormula.addATag("happy");
		
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.addTerm(newTerm2);
		newFormula2.addTerm(newTerm3);
		newFormula2.addATag("blah");
		newFormula2.addATag("mass");
		
		newFormula3.setName("No Mass Formula");
		newFormula3.setInfo("No mass info");
		newFormula3.addTerm(newTerm4);
		newFormula3.addATag("notMass");
						
		
		someFormulas.add(newFormula);
		someFormulas.add(newFormula2);
		someFormulas.add(newFormula3);  
    
    FormulaDatabase Base = new FormulaDatabase();
   // FormulaDatabase Res = new FormulaDatabase();
    
    Base.AddFormula(newFormula);
    Base.AddFormula(newFormula2);
    Base.AddFormula(newFormula3);
    
    SaveForms(Base);
    
    Base = null;
    
    //Res = (FormulaDatabase) LoadForms();
    
    for(int i=0; i<=2; i++){
      Formula x = ((ArrayList<Formula>) LoadForms()).get(i);
      System.out.println(x.getName() + " " + x + " " + x.getInfo() + " " + x.getAllTags() );
    }
  }  
  
}
