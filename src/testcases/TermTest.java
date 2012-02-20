package testcases;
import static org.junit.Assert.*;
import internalformatting.Term;
import internalformatting.Unit;
import internalformatting.Variable;
import org.junit.Test;

/** test class for Term
 * @author Michelle Len
 * @version 02/19/2012 for CS 48 Project, W12
 * @see Term
 */

// Do we need a three arg constructor without the Unit parameter?
// What if we have a term, but don't know the units for it?

public class TermTest {

	public static final double TOL = 0.000001;
	
	/**
	 * Testing the no arg constructor
	 * @see Term
	 */
	
	@Test
	public void testTerm() {
		Term testTerm = new Term();
		assertEquals(0, testTerm.getCoefficient(), TOL);
		assertEquals(null, testTerm.getVariable());
		assertEquals(0, testTerm.getExponent());
		assertEquals(null, testTerm.getUnit());
	}
	
	/**
	 * Testing the four arg constructor
	 * @see Term
	 */

	@Test
	public void testTermIntVariableIntUnit() {
		Term testTerm = new Term(4, new Variable("t"), 2, new Unit("second"));
		assertEquals(4, testTerm.getCoefficient(), TOL);
		assertEquals("t", testTerm.getVariable().getVar());
		assertEquals(2, testTerm.getExponent());
		assertEquals("second", testTerm.getUnit().getName());
	}

	/**
	 * Test case for Term.getCoefficient()
	 * @see Term
	 */
	
	@Test
	public void testGetCoefficient() {
		Term testTerm = new Term(3, new Variable("l"), 3, new Unit("meters cubed"));
		assertEquals(3, testTerm.getCoefficient(), TOL);
	}

	/**
	 * Test case for Term.getVariable()
	 * @see Term
	 */
	
	@Test
	public void testGetVariable() {
		Term testTerm = new Term(2, new Variable("l"), 2, new Unit("meters squared"));
		assertEquals("l", testTerm.getVariable().getVar());
	}

	/**
	 * Test case for Term.getExponent()
	 * @see Term
	 */
	
	@Test
	public void testGetExponent() {
		Term testTerm = new Term(4, new Variable("v"), 1, new Unit("meters/second"));
		assertEquals(1, testTerm.getExponent());
	}

	/**
	 * Test case for Term.getUnit()
	 * @see Term
	 */
	
	@Test
	public void testGetUnit() {
		Term testTerm = new Term(7, new Variable("v"), 2, new Unit("meters/second"));
		assertEquals("meters/second", testTerm.getUnit().getName());
	}

	/**
	 * Test case for Term.toString()
	 * @see Term
	 */
	
	@Test
	public void testToString() {
		Term testTerm = new Term(2, new Variable("v"), 2, new Unit("meters/second"));
		assertEquals("2v^2", testTerm.toString());
	}

} // class TermTest