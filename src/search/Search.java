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
	
	/**
	 * method to change the ArrayLise of formulas you are searching in
	 * @param allFormulas
	 */
	public void setAllFormulas(ArrayList<Formula> allFormulas) {
		this.allFormulas = allFormulas;
	}
	
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
}