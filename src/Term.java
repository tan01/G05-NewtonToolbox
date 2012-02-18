/** Term is a class to represent a term consisting of a coefficient, variable, and exponent
 * @author Michelle Len
 * @version 02/18/2012 for CS 48 Project, W12
 */

public class Term {
	
	private int coefficient; // a coefficient represented as an int
	private Variable x; // a variable object
	private int exponent; // an exponent represented as an int

	/** Constructor
	 * @param coefficient Value of coefficient
	 * @param x What the variable is
	 * @param exponent Value of exponent
	 */
	
	public Term (int coefficient, Variable x, int exponent) {
		// assign attributes from parameters
		this.coefficient = coefficient;
		this.x = x;
		this.exponent = exponent;
	}
	
	/**
	 * Get methods for coefficient, variable, and exponent
	 */
	
	public int getCoefficient() { return this.coefficient; }
	public Variable getVariable () { return this.x; }
	public int getExponent () { return this.exponent; }
	
	/** 
	 * Set methods for coefficient, variable, and exponent
	 */
	
	public void setCoefficient (int coefficient) { this.coefficient = coefficient; }
	public void setVariable (Variable x) { this.x = x; }
	public void setExponent (int exponent) { this.exponent = exponent; }
	
	/**
	 * Returns object as a string
	 */
	
	public String toString() {
		return "" + coefficient + x + "^" + exponent;
	} // Do we need a toString method?
	
} // class Term