package testcases;
import static org.junit.Assert.*;
import internalformatting.Unit;
import org.junit.Test;

/** test class for Unit
 * @author Michelle Len
 * @version 02/19/2012 for CS 48 Project, W12
 * @see Unit
 */

public class UnitTest {

	/**
	 * Testing the no arg constructor
	 * @see Unit
	 */
	
	@Test
	public void testUnit() {
		Unit testUnit = new Unit();
		assertEquals(null, testUnit.getName());
		assertEquals(null, testUnit.getInfo());
		assertEquals(null, testUnit.getTypicalForm());
	}

	/**
	 * Testing the constructor with the String arg
	 * @see Unit
	 */
	
	@Test
	public void testUnitString() {
		Unit testUnit = new Unit("second");
		assertEquals("second", testUnit.getName());
		assertEquals("unspecified info", testUnit.getInfo());
		assertEquals("unset typical physics form", testUnit.getTypicalForm());
	}

	/**
	 * Test case for Unit.getName()
	 * @see Unit
	 */
	
	@Test
	public void testGetName() {
		Unit testUnit = new Unit("second");
		assertEquals("second", testUnit.getName());
	}

	/**
	 * Test case for Unit.getInfo()
	 * @see Unit
	 */
	
	@Test
	public void testGetInfo() {
		Unit testUnit = new Unit("second");
		assertEquals("unspecified info", testUnit.getInfo());
	}

	/**
	 * Test case for Unit.getTypicalForm()
	 * @see Unit
	 */
	
	@Test
	public void testGetTypicalForm() {
		Unit testUnit = new Unit("second");
		assertEquals("unset typical physics form", testUnit.getTypicalForm());
	}

}
