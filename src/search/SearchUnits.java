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
	
	/**
	 * method to change the ArrayLise of units you are searching in
	 * @param allUnits
	 */
	public void setAllUnits(ArrayList<Unit> allUnits) {
		this.allUnits = allUnits;
	}
	
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
}