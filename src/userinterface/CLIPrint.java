package userinterface;

/**
	CLIPrint.java
	Handles the printing of the formulas.
	Uses whatever default database is loaded into CLI.java.
	OR you can specify a database. Maybe.
			Not sure exactly how I'm supposed to do this.
		@author Jonathan Tan
		@version 0.0.1 2/21/12
 */

//Does this even deserve to be a class?
//Will this eventually get more complicated?

public class CLIPrint extends CLI {

	static public void printAll() {
		for(int i=0; i<defaultFormulas.getSize(); i++) {
			defaultFormulas.get(i).printFormula();
			System.out.println();
		}
	}

	//Will probably be a single "print" method when I can think of a way to make an adequate
	//"Database Explorer."

}