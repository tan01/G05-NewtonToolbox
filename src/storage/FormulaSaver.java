package storage;

import internalformatting.Formula;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FormulaSaver
{
  public static void SaveForms(FormulaDatabase Forms){
    try{
      FileOutputStream fs = new FileOutputStream("FormulaDatabase.ser");
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
      ObjectInputStream is = new ObjectInputStream(new FileInputStream("FormulaDatabase.ser"));
      One = (FormulaDatabase) is.readObject();
      
    } catch(Exception ex){
      ex.printStackTrace();
    }
    
    return One;
  }
  
  public static void main(){
    Formula Test1 = new Formula("form1", "info1");
    Formula Test2 = new Formula("form2", "info2");
    Formula Test3 = new Formula("form3" ,"info3");
    
    FormulaDatabase Base = new FormulaDatabase();
    FormulaDatabase Res = new FormulaDatabase();
    
    Base.AddFormula(Test1);
    Base.AddFormula(Test2);
    Base.AddFormula(Test3);
    
    SaveForms(Base);
    
    Base = null;
    Test1 = null;
    Test2 = null;
    Test3 = null;
    
    Res = (FormulaDatabase) LoadForms();
    
    for(int i=0; i<=2; i++){
      Formula x = (Formula) Res.get(i);
      System.out.println(i + " = " + x.getName() + " " + x.getInfo());
    }
    
  }
}
