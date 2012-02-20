package testcases;
import static org.junit.Assert.*;
import internalformatting.Variable;
import org.junit.Test;

/** test class for Variable
 * @author Michelle Len
 * @version 02/19/2012 for CS 48 Project, W12
 * @see Variable
 */

public class VariableTest {
	
	public static final double TOL = 0.000001;
	
	/**
	 * Testing the one arg constructor
	 * @see Variable
	 */
	
	@Test
	public void testVariableString() {
		Variable testVar = new Variable("m");
		assertEquals("m", testVar.getVar());
	}

	/**
	 * Testing the two arg constructor
	 * @see Variable
	 */
	
	@Test
	public void testVariableStringDouble() {
		Variable testVar = new Variable("m", 100.0);
		assertEquals("m", testVar.getVar());
		assertEquals(100.0, testVar.getValue(), TOL);
	}

	/**
	 * Test case for Variable.getVar()
	 * @see Variable
	 */
	
	@Test
	public void testGetVar() {
		Variable testVar = new Variable("m", 100.00);
		assertEquals("m", testVar.getVar());
	}

	/**
	 * Test case for Variable.getValue()
	 * @see Variable
	 */
	
	@Test
	public void testGetValue() {
		Variable testVar = new Variable("m", 100.00);
		assertEquals(100.00, testVar.getValue(), TOL);
	}

	/**
	 * Test case for Variable.toString()
	 * @see Variable
	 */
	
	@Test
	public void testToString() {
		Variable testVar = new Variable("a");
		assertEquals("a", testVar.toString());
	}

} // class VariableTest