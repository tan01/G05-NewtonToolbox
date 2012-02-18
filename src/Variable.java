/** Variable is a class to represent a variable
	@author Michelle Len
	@author May Camp
	@version 02/14/2012 for CS 48 Project, W12
*/

public class Variable {

	private double value; //value of the variable
	private char var; // variable represented as a char

	/** Constructor	
	 * @param var A character of what the variable is
	 */

	public Variable (char var) {
		// assign attributes from parameters
		this.var = var;
	}

	/** Constructor
	 * 
	 * @param var A character of what the variable is
	 * @param value A double of what the value of the variable is
	 */
	public Variable (char var, double value){
		this.var = var;
		this.value = value;
	}
	
	/**
		Get the variable character
 	*/
	public char getVar () {
		return this.var;
	}
	/**
	 * Get the variable value
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * set the variable character
	 */
	public void setVar (char var) {
		this.var = var;
	}
	
	/**
	 * set the variable value
	 */
	public void setValue (double value) {
		this.value = value;
	}

	/**
		Returns object as a string
	*/
	public String toString() {
		return Character.toString(var);
	} // do we need this method?

} // class Variable