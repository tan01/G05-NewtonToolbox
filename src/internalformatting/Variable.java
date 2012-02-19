package internalformatting;

import java.io.Serializable;

/** Variable is a class to represent a variable
 * @author Michelle Len
 * @author May Camp
 * @version 02/18/2012 for CS 48 Project, W12
 */

public class Variable implements Serializable{

	private double value; //value of the variable
	private char var; // variable represented as a char
	final private static long serialVersionID = 8383008L;
	
	/** Constructor	
	 * @param var A character of what the variable is
	 */

	public Variable (char var) {
		// assign attributes from parameters
		this.var = var;
	}

	/** Constructor
	 * @param var A character of what the variable is
	 * @param value A double of what the value of the variable is
	 */

	public Variable (char var, double value){
		this.var = var;
		this.value = value;
	}
	
	/**
	 * Get the variable character and value
 	 */
	
	public char getVar () { return this.var; }
	public double getValue() { return this.value; }
	
	/**
	 * set the variable character and value
	 */
	
	public void setVar (char var) { this.var = var; }
	public void setValue (double value) { this.value = value; }

	/**
	 * Returns object as a string
	 */
	
	public String toString() {
		return Character.toString(var);
	} // do we need this method?

} // class Variable