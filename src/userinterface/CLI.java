package userinterface;
import java.io.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

/**
	CLI.java
	User interface for the sake of interfacing with users.
	@author Jonathan Tan
	@version 0.0.1 2/18/12
	
*/

public class CLI{
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Valid search terms go here.
	//May end up making a new class for this thing,
	//Need a smarter way of checking if the term is in the array.
	//Maybe ArrayList?
	//Need Array "find" method!
	
//	static String[] comsearch = new String[]{"Search","search"};
//	static String[] comquit = new String[]{"quit","Quit","Exit","exit"};
//	static String[] 
	
	public static void main(String[] args) throws IOException{
		String uinput = "";
		while(!uinput.equals("exit") && !uinput.equals("quit")){
			System.out.println("Command?");
			System.out.print(">");
			uinput = in.readLine();
			
			if(uinput.toLowerCase().equals("search")){
			System.out.println("Searching? Haha, no.");
			}
			
			if(uinput.toLowerCase().equals("exit")){
			break;
			}
			
		}
	}
	
}
