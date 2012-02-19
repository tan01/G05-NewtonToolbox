package storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FormulaSaver
{
  public void SaveForm(FormulaDatabase Forms){
    try{
      FileOutputStream fs = new FileOutputStream("FormulaDatabase.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      
      os.writeObject(Forms);
      os.close();
      
    }catch (IOException ex){
      ex.printStackTrace();
    }      
  }
  
  public void LoadForm(){
    try{
      ObjectInputStream is = new ObjectInputStream(new FileInputStream("FormulaDatabase.ser"));
      FormulaDatabase One = (FormulaDatabase) is.readObject();
      
    } catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
