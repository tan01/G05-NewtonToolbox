package userinterface;

/**
	CLIHelp.java
	Help portion of user interface. Right now, prints commands that a user can input.
	@author Jonathan Tan
	@version 0.0.1 2/18/12

 */

public class CLIHelp extends CLI {
	
	/**
	 * printStringArray()
	 *	Helper printStringArray function.
	 *	Does exactly what it says on the tin, separated by comma + space.
	 *	Except for the last element.
	 *	@param com String[] to print.
	 */
	static private void printStringArray(String[] com) {
		for (int i=0; i<com.length-1; i++){
			System.out.print(com[i]+", ");
		}
		System.out.print(com[com.length-1]);
	}

	/**
	 * help()
	 * Prints out valid commands from the static string arrays in the CLI class.
	 * Should probably put duplicate code in the printStringArray function.
	 * Want to eventually put all the commands in one array to iterate through.
	 */
	static public void help() {
		System.out.println("Valid commands: ");

		//Printing comsearch
		System.out.print("Search: ");
		printStringArray(comsearch);
		System.out.println();

		//Printing add
		System.out.print("Add: ");
		printStringArray(comadd);
		System.out.println();

		//Printing print
		System.out.print("Print: ");
		printStringArray(comprint);
		System.out.println();

		//Printing print all
		System.out.print("Print All: ");
		printStringArray(comprintall);
		System.out.println();

		//Printing quit
		System.out.print("Quit: ");
		printStringArray(comquit);
		System.out.println();

		//Printing help
		System.out.print("Help: ");
		printStringArray(comhelp);
		System.out.println();
	}

}