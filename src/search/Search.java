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
	private String searchTerm;
	
	private ArrayList<Formula> formulas = new ArrayList<Formula>();
	/**
	 * Constructor
	 * @param allFormulas An ArrayList of all the stored formulas
	 * @param searchTerm The String term you are searching for in the formulas
	 */
	public Search(ArrayList<Formula> allFormulas, String searchTerm) {
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
				if(searchTerm == currentTag) {
					this.formulas.add(allFormulas.get(i));
				}
			}
		}
		return formulas;
	}

	public static void main(String[] args) {
		ArrayList<Formula> someFormulas = new ArrayList<Formula>();
		
		Variable newVar = new Variable('x');
		
		Term newTerm = new Term(5, newVar, 2);
		Term newTerm2 = new Term(6, newVar, 3);
		
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.AddTerm(newTerm);
		newFormula.addATag("random");
		newFormula.addATag("mass");
		newFormula.addATag("happy");
		
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.AddTerm(newTerm2);
		newFormula2.addATag("blah");
		newFormula2.addATag("mass");
		
		someFormulas.add(newFormula);
		someFormulas.add(newFormula2);
			
		
		System.out.println("This is the formula we found by searching for 'mass':");
		
		Search searchObject = new Search(someFormulas, "mass");

		System.out.println(searchObject.searchF().get(0).toString());
		
		
		
	}
}