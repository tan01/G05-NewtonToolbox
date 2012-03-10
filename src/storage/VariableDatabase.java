package storage;

import internalformatting.Variable;

import java.io.Serializable;
import java.util.ArrayList;

public class VariableDatabase extends ArrayList<Variable> implements Serializable
{
  private static final long serialVersionUID = 6746579L;
  
  public VariableDatabase(){
    super(); //creates an Arraylist of capacity 1
    this.clear();
  }
  
  /**
   * Adds a Variable object to Arraylist of Variables
   * @param Var the variable to be added to the database
   */
  public void addVariable(Variable Var){
    this.add(Var);
  }
  
  /**
   * removes the variable at  index i
   * @param i the index of the variable to be removed
   */
  public void rmVariable(int i){
    this.remove(i);
  }
  /**
   * return the size of the database as an int
   * @return size of the Database
   */
  public int getSize(){
    return this.size();
  }

}