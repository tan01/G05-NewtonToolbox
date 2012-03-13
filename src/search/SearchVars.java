package search;
/**
 * SearchVars is a class to search through terms
 * of variable class with the search terms entered by the user
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */
import internalformatting.*;

import java.util.ArrayList;

public class SearchVars {
	// for a one word search term
    //assuming we store all Variables in ArrayList<Variable> 
    //and enter that as the first argument
	
	private ArrayList<Variable> allVariables = new ArrayList<Variable>();
	
	private ArrayList<Variable> variables = new ArrayList<Variable>();
	
	/**
	 * Constructor
	 * @param allVariables An ArrayList of all the stored variables to search through
	 */
	public SearchVars(ArrayList<Variable> allVariables) {
		this.allVariables = allVariables;
	}
	
	/**
	 * printSearchVars method: Static method for printing variables from an ArrayList.
	 * @param  VariableArray ArrayList of variables.
	 */
	static public void printSearchVars(ArrayList<Variable> VariableArray)
	{
		for(int i = 0;i<VariableArray.size();i++){
			VariableArray.get(i).printVariable();
			System.out.println();
		}
	}
	
	/**
	 * method to change the ArrayList of variables you are searching in
	 * @param allVariables
	 */
	public void setAllVariables(ArrayList<Variable> allVariables) {
		this.allVariables = allVariables;
	}
	
	/**
	 * @param searchTerm The String term you are searching for in the variables
	 * @return variables An array list of variables
	 */
	public ArrayList<Variable> searchV(String searchTerm) {
		int fsize = allVariables.size(); //size of allVariable ArrayList
		String currentTag;
		for(int i=0; i<fsize; i++) { // loop through variables
			int tsize = allVariables.get(i).getTagSize(); //size of tag ArrayList
			for(int j=0; j<tsize; j++) { // loop through tags
				currentTag = allVariables.get(i).getTag(j);    	
				if(searchTerm.equals(currentTag)) {
					this.variables.add(allVariables.get(i));
				}
			}
		}
		return variables;
	}
}