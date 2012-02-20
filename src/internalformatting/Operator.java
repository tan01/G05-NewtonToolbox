package internalformatting;

/** Operator is a class to represent an operator such as (, ), +, -, *, /
 * @author Michelle Len
 * @version 02/19/2012 for CS 48 Project, W12
 */

public class Operator extends Component {
	
	private String operator;
	private static final long serialVersionUID =  1767185L;
	
	public Operator() {
		super();
	}
	
	/** Constructor
	 * 
	 * @param operator A String of the operator
	 */
	
	public Operator(String operator) {
		this.operator = operator;
	}
	
	byte getType(){
	  return 1;
	}

	/**
	 * Get method for operator
	 */
	
	public String getOperator() { return this.operator; }
	
	/** 
	 * Set method for operator
	 */
	
	public void setOperator(String operator) { this.operator = operator; }
	
	/**
	 * Returns object as a string
	 */
	
	public String toString() {
		return operator;
	}
	
} // class Operator