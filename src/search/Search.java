package search;
/**
 * Search is a class to search through terms
 * of formula class with the search terms entered by the user
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */
import internalformatting.Formula;

import java.util.ArrayList;

public class Search {
	// for a one word search term
    //assuming we store all formulas in ArrayList<Formula> 
    //and enter that as the first argument
    //and there are tags in ArrayList<Tag> under each formula
	private ArrayList<Formula> allFormulas = new ArrayList<Formula>();
	private String searchTerm;
	
	private ArrayList<Formula> formulas = new ArrayList<Formula>();
	/**
	 * Constructor
	 * @param allFormulas An ArrayList of all the stored formulas
	 * @param searchTerm The String term you are searching for in the formulas
	 */
	public Search(ArrayList<Formula> allFormulas, String searchTerm) {
		this.allFormulas = allFormulas;
		this.searchTerm = searchTerm;
	}
	
	/**
	 * 
	 * @return formulas An array list of formulas
	 */
	public ArrayList<Formula> foundFormulas() {
		int fsize = allFormulas.size(); //size of allFormula ArrayList
		String currentTag;
		for(int i=0; i<fsize; i++) { // loop through formulas
			int tsize = allFormulas.get(i).getTagSize(); //size of tag ArrayList
			for(int j=0; j<tsize; j++) { // loop through tags
				currentTag = allFormulas.get(i).getTag(j);    	
				if(searchTerm == currentTag) {
					this.formulas.add(formulas.get(i));
				}
			}
		}
		return formulas;
		
	}

}