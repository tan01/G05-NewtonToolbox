package internalformatting;

/** Operator is a class to represent an operator such as (, ), +, -, *, /
 * @author Michelle Len
 * @version 02/19/2012 for CS 48 Project, W12
 */

public class Operator extends Term {
	
	private String operator;
	private static final long serialVersionUID =  1767185L;
	
	public Operator() {
		super();
	}
	
	/** Constructor
	 * 
	 * @param operator A String of the operator
	 * Operators consist of: ( ) + - * /
	 * If input is not part of the above operators, then this.operator is null
	 */
	
	public Operator(String operator) {
		// Operators consist of: ( ) + - * /
		if ((	operator.equals("(") || operator.equals(")") || operator.equals("+") || 
				operator.equals("-") || operator.equals("*") || operator.equals("/") || 
				operator.equals("="))) 
			this.operator = operator;
		else
			System.out.println("Invalid Operator");
	}

	/**
	 * Get method for operator
	 */
	
	public String getOperator() { return this.operator; }
	
	/** 
	 * Set method for operator
	 */
	
	public void setOperator(String operator) { 
		/** Operators consist of: ( ) + - * /
		 * If input is not part of the above operators, then this.operator is null
		 */
		if ((	operator.equals("(") || operator.equals(")") || operator.equals("+") || 
				operator.equals("-") || operator.equals("*") || operator.equals("/") 	)) 
				this.operator = operator;
		else
				System.out.println("Invalid Operator");
	}
	
	/**
	 * Returns object as a string
	 */
	
	public String toString() {
		return operator;
	}
	
} // class Operator