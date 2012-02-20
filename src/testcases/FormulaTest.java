package testcases;
import static org.junit.Assert.*;
import internalformatting.Formula;
import internalformatting.Operator;
import internalformatting.Term;
import internalformatting.Unit;
import internalformatting.Variable;
import org.junit.Test;

/** test class for Formula
 * @author Michelle Len
 * @version 02/20/2012 for CS 48 Project, W12
 * @see Formula
 */

public class FormulaTest {

	// Formula is x = x_0 + v*t + 1/2a*t^2
	// Tags are kinematics, distance, velocity, acceleration
	
	Variable x = new Variable("x");
	Variable x_0 = new Variable("x_0");
	Variable v = new Variable("v");
	Variable a = new Variable("a");
	Variable t = new Variable("t");
	Term x_term = new Term(1, x, 1, new Unit("meters"));
	Operator equals = new Operator("=");
	Operator plus = new Operator("+");
	Operator times = new Operator("*");
	Term x_0_term = new Term(1, x_0, 1, new Unit("meters"));
	Term v_term = new Term(1, v, 1, new Unit("meters/second"));
	Term a_term = new Term(0.5, a, 1, new Unit("meters/second_squared"));
	Term t_term = new Term(1, t, 1, new Unit("seconds"));
	Term t2_term = new Term(1, t, 2, new Unit("seconds_squared"));
	Formula testFormula = new Formula("Kinematics Equation #1", 
			"Basic Kinematic Equation");
	
	@Test
	public void testFormulaStringString() {
		assertEquals("Kinematics Equation #1", testFormula.getName());
		assertEquals("Basic Kinematic Equation", testFormula.getInfo());
		System.out.println("Name: " + testFormula.getName());
		System.out.println("Info: " + testFormula.getInfo());
	}

	@Test
	public void testGetTag() {
		testFormula.addTag("kinematics");
		testFormula.addTag("distance");
		testFormula.addTag("velocity");
		testFormula.addTag("acceleration");
		assertEquals("kinematics", testFormula.getTag(0));
		assertEquals("distance", testFormula.getTag(1));
		assertEquals("velocity", testFormula.getTag(2));
		assertEquals("acceleration", testFormula.getTag(3));
		System.out.println("Tags are:" + testFormula.getAllTags());
	}

	@Test
	public void testGetTagSize() {
		testFormula.addTag("kinematics");
		testFormula.addTag("distance");
		testFormula.addTag("velocity");
		testFormula.addTag("acceleration");
		assertEquals(4, testFormula.getTagSize());
		System.out.println("Tag size is " + testFormula.getTagSize());
	}

	@Test
	public void testAddTerm() {
		testFormula.addTerm(x_term);
		testFormula.addTerm(equals);
		testFormula.addTerm(x_0_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(v_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(a_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t2_term);
		assertEquals("x = x_0 + v * t + 0.5a * t^2 ", testFormula.toString());
		System.out.println("Formula is: " + testFormula.toString());
	}

	// Formula is x = x_0 + v*t + 1/2a*t^2
	// Formula is x = x_0 + v*t if a is zero
	
	@Test
	public void testDeleteTerm() {
		testFormula.addTerm(x_term);
		testFormula.addTerm(equals);
		testFormula.addTerm(x_0_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(v_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(a_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t2_term);
		testFormula.deleteTerm(10);
		testFormula.deleteTerm(9);
		testFormula.deleteTerm(8);
		testFormula.deleteTerm(7);
		assertEquals("x = x_0 + v * t ", testFormula.toString());
		System.out.println("After deleting terms: " + testFormula.toString());
	}

	@Test
	public void testToString() {
		testFormula.addTerm(x_term);
		testFormula.addTerm(equals);
		testFormula.addTerm(x_0_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(v_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t_term);
		testFormula.addTerm(plus);
		testFormula.addTerm(a_term);
		testFormula.addTerm(times);
		testFormula.addTerm(t2_term);
		assertEquals("x = x_0 + v * t + 0.5a * t^2 ", testFormula.toString());
	}
	
} // class FormulaTest