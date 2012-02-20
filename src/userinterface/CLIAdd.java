package userinterface;
import java.io.*;
import internalformatting.*;

/**
 * CLIAdd.java : Add module for the CLI that lets a user create formulas to save to the database.
 * 	@author Jonathan Tan
 * 	@version -0.0.1
 */

public class CLIAdd extends CLI{
	
	public static Formula AddFormula() throws IOException{
		Formula newFormula = new Formula();
		System.out.println("Enter name of formula:");
		System.out.print(">");
		try{
			newFormula.setName(in.readLine());
		}
		catch(IOException ex){
			System.out.println("Invalid name! Ceasing operation.");
			newFormula.setName("YOU MESSED UP");
			return newFormula;
		}
		String input = "";
		System.out.println("Enter term and/or operator. When finished entering terms, enter 'done'.");
		System.out.print(">");
		while(!input.equals("done")){
			input = in.readLine();
			if(input.equals("term")){
				System.out.println("Enter term as coefficient (double) <SPACE> variable (char) <space> exponent (int):");
				System.out.print(">");
				String[] termTerms = input.split(" ");
				Double coeff = 0.0;
				Variable var = null;
				Integer exp = 0;
				if(termTerms.length==3){
					coeff = Double.parseDouble(termTerms[1]);
					var = new Variable(termTerms[2]);
					exp = Integer.parseInt(termTerms[2]);
				}else{
					System.out.println("Error: parameters not passed correctly. Debug values are used.");
				}
				Term tempTerm = new Term(coeff,var,exp);
				newFormula.add(tempTerm);
			}
			if(input.equals("operator")){
			
			}
		}
		return newFormula;
	}
	
}