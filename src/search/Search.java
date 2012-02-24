package search;
/**
 * Search is a class to search through terms
 * of formula class with the search terms entered by the user
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */
import internalformatting.*;

import java.util.ArrayList;

public class Search {
	// for a one word search term
    //assuming we store all formulas in ArrayList<Formula> 
    //and enter that as the first argument
	
	private ArrayList<Formula> allFormulas = new ArrayList<Formula>();
//	private String searchTerm="null";
	
	private ArrayList<Formula> formulas = new ArrayList<Formula>();
	/**
	 * Constructor
	 * @param allFormulas An ArrayList of all the stored formulas to search through
	 */
	public Search(ArrayList<Formula> allFormulas) {
		this.allFormulas = allFormulas;
	}
	
	/**
	 * printSearch method: Static method for printing formulas from an ArrayList. Right now it just
	 * uses the formula's toString() method.
	 * @param  FormulaArray ArrayList of formulas.
	 */
	static public void printSearch(ArrayList<Formula> FormulaArray)
	{
		for(int i = 0;i<FormulaArray.size();i++){
			FormulaArray.get(i).printFormula();
			System.out.println();
		}
	}
	
	
	
//	/**
//	 * Constructor
//	 * @param allFormulas An ArrayList of all the stored formulas
//	 * @param searchTerm The String term you are searching for in the formulas
//	 */
//	public Search(ArrayList<Formula> allFormulas, String searchTerm) {
//		this.allFormulas = allFormulas;
//		this.searchTerm = searchTerm;
//	}
	/**
	 * method to change the ArrayLise of formulas you are searching in
	 * @param allFormulas
	 */
	public void setAllFormulas(ArrayList<Formula> allFormulas) {
		this.allFormulas = allFormulas;
	}
	
//	public void setSearchTerm(String searchTerm) {
//		this.searchTerm = searchTerm;
//	}
//	
//	
//	/**
//	 * Without parameters
//	 * @return formulas An array list of formulas
//	 */
//	public ArrayList<Formula> searchF() {
//		int fsize = allFormulas.size(); //size of allFormula ArrayList
//		String currentTag;
//		for(int i=0; i<fsize; i++) { // loop through formulas
//			int tsize = allFormulas.get(i).getTagSize(); //size of tag ArrayList
//			for(int j=0; j<tsize; j++) { // loop through tags
//				currentTag = allFormulas.get(i).getTag(j);    	
//				if(searchTerm == currentTag) {
//					this.formulas.add(allFormulas.get(i));
//				}
//			}
//		}
//		return formulas;
//	}
	
	/**
	 * @param searchTerm The String term you are searching for in the formulas
	 * @return formulas An array list of formulas
	 */
	public ArrayList<Formula> searchF(String searchTerm) {
		int fsize = allFormulas.size(); //size of allFormula ArrayList
		String currentTag;
		for(int i=0; i<fsize; i++) { // loop through formulas
			int tsize = allFormulas.get(i).getTagSize(); //size of tag ArrayList
			for(int j=0; j<tsize; j++) { // loop through tags
				currentTag = allFormulas.get(i).getTag(j);    	
				if(searchTerm.equals(currentTag)) {
					this.formulas.add(allFormulas.get(i));
				}
			}
		}
		return formulas;
	}

	public static void main(String[] args) {
		// new formula ArrayList
		ArrayList<Formula> someFormulas = new ArrayList<Formula>();
		
		//new variable - x
		Variable newVar = new Variable("x");
		
		//new terms to put in formulas
		Term newTerm = new Term(5, newVar, 2, null); //5x^2
		Term newTerm2 = new Term(6, newVar, 3, null); //6x^3
		Term newTerm3 = new Term(7, newVar, 4, null); //7x^4
		Term newTerm4 = new Term(8, newVar,5,null); //8x^5
		
		//new formulas to put in ArrayList of formulas
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		Formula newFormula3 = new Formula();
		
		//formula 1 tags: random, mass, happy
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.addTerm(newTerm);
		newFormula.addTag("random");
		newFormula.addTag("mass");
		newFormula.addTag("happy");
		
		//formula 2 tags: blah, mass
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.addTerm(newTerm2);
		newFormula2.addTerm(newTerm3);
		newFormula2.addTag("blah");
		newFormula2.addTag("mass");
		
		//formula 3 tags: notMass
		newFormula3.setName("No Mass Formula");
		newFormula3.setInfo("No mass info");
		newFormula3.addTerm(newTerm4);
		newFormula3.addTag("notMass");
						
		
		someFormulas.add(newFormula); // 5x^2
		someFormulas.add(newFormula2); // 6x^3 + 7x^4
		someFormulas.add(newFormula3); // 8x^5
			
		
		System.out.println("This is the formula we found by searching for 'mass':");
		
		Search searchObject = new Search(someFormulas);
		ArrayList<Formula> somelist = searchObject.searchF("mass");
		printSearch(somelist);
//		String Aformula = "";
//		//System.out.println(Aformula);
//		
//		
//		for(int i = 0;i<somelist.size();i++){
//			Aformula = somelist.get(i).toString();
//			System.out.println(Aformula);
//		}
		
	}
}