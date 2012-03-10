package userinterface;
import internalformatting.Formula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import storage.*;
/**
	CLI.java
	User interface for the sake of interfacing with users.
	@author Jonathan Tan
	@version 0.0.1 2/18/12
*/

public class CLI
{
	
	//Valid search terms go here.
	//May end up making a new class for this thing,
	//Need a smarter way of checking if the term is in the array.
	//Maybe ArrayList?
	//Need Array "find" method!
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static String[] comsearch = new String[]{"s","search"};
	static String[] comadd = new String[]{"a","add","new"};
	static String[] comprint = new String[]{"p","print"};
	static String[] comprintall = new String[]{"p a", "p all", "print all"};
	static String[] comquit = new String[]{"exit","q","quit",};
	static String[] comhelp = new String[]{"help"};
	
	//Loads FormulaDatabase from FormulaSaver.
	static FormulaDatabase defaultFormulas = (FormulaDatabase)Saver.loadForms();	
	
	public static boolean inArray(String prompt, String[] comArray){
		int truthvalue = Arrays.binarySearch(comArray, prompt);
		if(truthvalue < 0)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		String uinput = "";
		while(!uinput.equals("exit") && !uinput.equals("quit")){
			//System.out.println("Command?");
	
			System.out.print(">");
			uinput = in.readLine().toLowerCase();
			
			//Search case
			//Need to add search argument so user can put like, "search THISTHING"
			//instead of "search -> THISTHING."
			if(inArray(uinput,comsearch)){
				CLISearch.searchOption(defaultFormulas);
				}
				
			
			//Add case
			//Tester functionality to see if we can add and save formulas to .ntb.
			if(inArray(uinput,comadd)){
				Formula newFormula = CLIAdd.addFormula();
				newFormula.printFormula();
				((FormulaDatabase) defaultFormulas).addFormula(newFormula);
				Saver.saveForms(defaultFormulas);
	
			}
			
			//Print case
			//Doesn't do anything right now!
			//Need to implement functionality:
					// Should print search results.
					// Should be able to print specific categories. Tags?
					// Invisible tags for categorization?
			if(inArray(uinput,comprint)){
				//STUB
				break;
			}
			
			//Print all case
			//Prints everything in the .ntb file loaded.
			if(inArray(uinput,comprintall)){
				CLIPrint.printAll();
			}
			
			//Quit case
			//Terminates program.
			if(inArray(uinput,comquit)){
				break;
			}
			
			//Help case
			//Basically prints the static com--- fields.
			if(inArray(uinput,comhelp)){
				CLIHelp.help();
			}
		}

	}

}