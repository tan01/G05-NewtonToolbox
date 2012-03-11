package search;
/**
 * SearchVars is a class to SearchVars through terms
 * of variable class with the SearchVars terms entered by the user
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */
import internalformatting.*;

import java.util.ArrayList;

public class SearchVars {
	// for a one word SearchVars term
    //assuming we store all Variables in ArrayList<Variable> 
    //and enter that as the first argument
	
	private ArrayList<Variable> allVariables = new ArrayList<Variable>();
//	private String SearchVarsTerm="null";
	
	private ArrayList<Variable> variables = new ArrayList<Variable>();
	/**
	 * Constructor
	 * @param allVariables An ArrayList of all the stored variables to SearchVars through
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
	
	
	
//	/**
//	 * Constructor
//	 * @param allVariables An ArrayList of all the stored variables
//	 * @param SearchVarsTerm The String term you are SearchVarsing for in the variables
//	 */
//	public SearchVars(ArrayList<Variable> allVariables, String SearchVarsTerm) {
//		this.allVariables = allVariables;
//		this.SearchVarsTerm = SearchVarsTerm;
//	}
	/**
	 * method to change the ArrayLise of variables you are SearchVarsing in
	 * @param allVariables
	 */
	public void setAllVariables(ArrayList<Variable> allVariables) {
		this.allVariables = allVariables;
	}
	
//	public void setSearchVarsTerm(String SearchVarsTerm) {
//		this.SearchVarsTerm = SearchVarsTerm;
//	}
//	
//	
//	/**
//	 * Without parameters
//	 * @return variables An array list of variables
//	 */
//	public ArrayList<Variable> SearchVarsF() {
//		int fsize = allVariables.size(); //size of allVariable ArrayList
//		String currentTag;
//		for(int i=0; i<fsize; i++) { // loop through variables
//			int tsize = allVariables.get(i).getTagSize(); //size of tag ArrayList
//			for(int j=0; j<tsize; j++) { // loop through tags
//				currentTag = allVariables.get(i).getTag(j);    	
//				if(SearchVarsTerm == currentTag) {
//					this.variables.add(allVariables.get(i));
//				}
//			}
//		}
//		return variables;
//	}
	
	/**
	 * @param SearchVarsTerm The String term you are SearchVarsing for in the variables
	 * @return variables An array list of variables
	 */
	public ArrayList<Variable> SearchVarsF(String SearchVarsTerm) {
		int fsize = allVariables.size(); //size of allVariable ArrayList
		String currentTag;
		for(int i=0; i<fsize; i++) { // loop through variables
			int tsize = allVariables.get(i).getTagSize(); //size of tag ArrayList
			for(int j=0; j<tsize; j++) { // loop through tags
				currentTag = allVariables.get(i).getTag(j);    	
				if(SearchVarsTerm.equals(currentTag)) {
					this.variables.add(allVariables.get(i));
				}
			}
		}
		return variables;
	}

	public static void main(String[] args) {
		// new variable ArrayList
		ArrayList<Variable> someVariables = new ArrayList<Variable>();
		
		//new variable - x
		Variable newVar = new Variable("x");
		
		//new terms to put in variables
		Term newTerm = new Term(5, newVar, 2, null); //5x^2
		Term newTerm2 = new Term(6, newVar, 3, null); //6x^3
		Term newTerm3 = new Term(7, newVar, 4, null); //7x^4
		Term newTerm4 = new Term(8, newVar,5,null); //8x^5
		
		//new variables to put in ArrayList of variables
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		Formula newFormula3 = new Formula();
		
		//variable 1 tags: random, mass, happy
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.addTerm(newTerm);
		newFormula.addTag("random");
		newFormula.addTag("mass");
		newFormula.addTag("happy");
		
		//variable 2 tags: blah, mass
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.addTerm(newTerm2);
		newFormula2.addTerm(newTerm3);
		newFormula2.addTag("blah");
		newFormula2.addTag("mass");
		
		//variable 3 tags: notMass
		newFormula3.setName("No Mass Formula");
		newFormula3.setInfo("No mass info");
		newFormula3.addTerm(newTerm4);
		newFormula3.addTag("notMass");
						
		
//		someVariables.add(newFormula); // 5x^2
//		someVariables.add(newFormula2); // 6x^3 + 7x^4
//		someVariables.add(newFormula3); // 8x^5
//			
//		
//		System.out.println("This is the variable we found by SearchVarsing for 'mass':");
//		
//		SearchVars SearchVarsObject = new SearchVars(someVariables);
//		ArrayList<Formula> somelist = SearchVarsObject.SearchVarsF("mass");
//		printSearchVars(somelist);
//		String Avariable = "";
//		//System.out.println(Avariable);
//		
//		
//		for(int i = 0;i<somelist.size();i++){
//			Avariable = somelist.get(i).toString();
//			System.out.println(Avariable);
//		}
		
	}
}