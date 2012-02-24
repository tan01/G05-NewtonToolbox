package userinterface;

import internalformatting.Formula;
import internalformatting.Term;
import internalformatting.Variable;

import java.io.IOException;
import java.util.ArrayList;

import search.Search;


/**
 * 
 * @author May Camp
 *
 */
public class CLISearch extends CLI{

	//CLI search, now compartmentalized!
	public static void searchOption(ArrayList<Formula> allFormulas) throws IOException{
		
		Search searchObject = new Search(allFormulas);
		
		System.out.println("Enter search term: ");
		System.out.print(">");
		String userInput = in.readLine().toLowerCase();
		System.out.println(userInput);
		System.out.println("Searching " + "\"" + userInput + "\"...");
		
		ArrayList<Formula> foundFormulas = searchObject.searchF(userInput);
		System.out.println("Found " + foundFormulas.size() + " formulas:");
		
		Search.printSearch(foundFormulas);
			
	}
	
	//Tester main function: unused.
	public static void main(String[] args) throws IOException {
		ArrayList<Formula> someFormulas = new ArrayList<Formula>();
		
		Variable newVar = new Variable("x");
		
		Term newTerm = new Term(5, newVar, 2, null);
		Term newTerm2 = new Term(6, newVar, 3, null);
		Term newTerm3 = new Term(7, newVar, 4, null);
		Term newTerm4 = new Term(8, newVar,5,null);
		
		Formula newFormula = new Formula();
		Formula newFormula2 = new Formula();
		Formula newFormula3 = new Formula();
		
		newFormula.setName("Mass Formula");
		newFormula.setInfo("Information blah blah");
		newFormula.addTerm(newTerm);
		newFormula.addTag("random");
		newFormula.addTag("mass");
		newFormula.addTag("happy");
		
		newFormula2.setName("Mass Formula 2");
		newFormula2.setInfo("More Info");
		newFormula2.addTerm(newTerm2);
		newFormula2.addTerm(newTerm3);
		newFormula2.addTag("blah");
		newFormula2.addTag("mass");
		
		newFormula3.setName("No Mass Formula");
		newFormula3.setInfo("No mass info");
		newFormula3.addTerm(newTerm4);
		newFormula3.addTag("notMass");
						
		
		someFormulas.add(newFormula);
		someFormulas.add(newFormula2);
		someFormulas.add(newFormula3);
		
		searchOption(someFormulas);
		
	}
	

	
}
