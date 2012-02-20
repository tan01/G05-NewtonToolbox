package testcases;
import static org.junit.Assert.*;
import internalformatting.Operator;
import org.junit.Test;

/** test class for Operator
 * @author Michelle Len
 * @version 02/18/2012 for CS 48 Project, W12
 * @see Operator
 */

public class OperatorTest {

	/**
	 * Test case for Operator constructor
	 * @See Operator
	 */
	
	@Test
	public void testOperatorString() {
		Operator plus = new Operator("+");
		assertEquals("+", plus.getOperator());
	}

	/**
	 * Test case for Operator.getOperator()
	 * @See Operator
	 */
	
	@Test
	public void testGetOperator() {
		Operator minus = new Operator("-");
		assertEquals("-", minus.getOperator());
	}
	
	/**
	 * Test case for Operator.toString()
	 * @See Operator
	 */
	
	@Test
	public void testToString() {
		Operator times = new Operator("*");
		assertEquals("*", times.getOperator());
	}

}
