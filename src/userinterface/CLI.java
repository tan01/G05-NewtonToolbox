package userinterface;
import search.*;
import java.io.*;
import java.util.Arrays;
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
	
	static String[] comsearch = new String[]{"Search","search","s"};
	static String[] comquit = new String[]{"quit","exit","q",};
	static String[] comprint = new String[]{"print","p"};
	static String[] comprintall = new String[]{"print all","p all", "p a"};
	
	public static boolean inArray(String prompt, String[] comArray){
		//I know, I know, I should use a binary search algorithm here.
		//Will improve efficiency in a little bit, okay?
		int truthvalue = Arrays.binarySearch(comArray, prompt);
		if(truthvalue < 0)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) throws IOException{
		String uinput = "";
		while(!uinput.equals("exit") && !uinput.equals("quit")){
			System.out.println("Command?");
			System.out.print(">");
			uinput = in.readLine().toLowerCase();
			
			//Search case
			if(inArray(uinput,comsearch)){
				System.out.println("Searching? Haha, no.");
			}
			
			//Print case
			if(inArray(uinput,comprint)){
				//STUB
				break;
			}
			
			if(inArray(uinput,comprintall)){
				//STUB
				break;
			}
			
			//Quit case
			if(inArray(uinput,comquit)){
				break;
			}
			
		}
	}
	
}
