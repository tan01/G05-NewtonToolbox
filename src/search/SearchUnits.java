package search;
/**
 * SearchUnits is a class to search through terms
 * of unit class with the search terms entered by the user
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */
import internalformatting.*;

import java.util.ArrayList;

public class SearchUnits {
	// for a one word search term
    //assuming we store all units in ArrayList<Unit> 
    //and enter that as the first argument
	
	private ArrayList<Unit> allUnits = new ArrayList<Unit>();
//	private String searchTerm="null";
	
	private ArrayList<Unit> units = new ArrayList<Unit>();
	/**
	 * Constructor
	 * @param allUnits An ArrayList of all the stored units to search through
	 */
	public SearchUnits(ArrayList<Unit> allUnits) {
		this.allUnits = allUnits;
	}
	
	/**
	 * printSearchUnits method: Static method for printing units from an ArrayList. Right now it just
	 * uses the unit's toString() method.
	 * @param  UnitArray ArrayList of units.
	 */
	static public void printSearchUnits(ArrayList<Unit> UnitArray)
	{
		for(int i = 0;i<UnitArray.size();i++){
			UnitArray.get(i).printUnit();
			System.out.println();
		}
	}
	
	
	
//	/**
//	 * Constructor
//	 * @param allUnits An ArrayList of all the stored units
//	 * @param searchTerm The String term you are searching for in the units
//	 */
//	public SearchUnits(ArrayList<Unit> allUnits, String searchTerm) {
//		this.allUnits = allUnits;
//		this.searchTerm = searchTerm;
//	}
	/**
	 * method to change the ArrayLise of units you are searching in
	 * @param allUnits
	 */
	public void setAllUnits(ArrayList<Unit> allUnits) {
		this.allUnits = allUnits;
	}
	
//	public void setSearchUnitsTerm(String searchTerm) {
//		this.searchTerm = searchTerm;
//	}
//	
//	
//	/**
//	 * Without parameters
//	 * @return units An array list of units
//	 */
//	public ArrayList<Unit> searchF() {
//		int fsize = allUnits.size(); //size of allUnit ArrayList
//		String currentTag;
//		for(int i=0; i<fsize; i++) { // loop through units
//			int tsize = allUnits.get(i).getTagSize(); //size of tag ArrayList
//			for(int j=0; j<tsize; j++) { // loop through tags
//				currentTag = allUnits.get(i).getTag(j);    	
//				if(searchTerm == currentTag) {
//					this.units.add(allUnits.get(i));
//				}
//			}
//		}
//		return units;
//	}
	
	/**
	 * @param searchTerm The String term you are searching for in the units
	 * @return units An array list of units
	 */
	public ArrayList<Unit> searchU(String searchTerm) {
		int fsize = allUnits.size(); //size of allUnit ArrayList
		String currentTag;
		for(int i=0; i<fsize; i++) { // loop through units
			int tsize = allUnits.get(i).getTagSize(); //size of tag ArrayList
			for(int j=0; j<tsize; j++) { // loop through tags
				currentTag = allUnits.get(i).getTag(j);    	
				if(searchTerm.equals(currentTag)) {
					this.units.add(allUnits.get(i));
				}
			}
		}
		return units;
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
		
//		SearchUnits searchObject = new SearchUnits(someFormulas);
//		ArrayList<Formula> somelist = searchObject.searchF("mass");
//		printSearchUnits(somelist);
////		String Aformula = "";
//		//System.out.println(Aformula);
//		
//		
//		for(int i = 0;i<somelist.size();i++){
//			Aformula = somelist.get(i).toString();
//			System.out.println(Aformula);
//		}
		
	}
}