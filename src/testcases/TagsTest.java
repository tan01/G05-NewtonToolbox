package testcases;
import static org.junit.Assert.*;
import internalformatting.Tags;
import org.junit.Test;

/** test class for Tags
 * @author Michelle Len
 * @version 02/20/2012 for CS 48 Project, W12
 * @see Tags
 */

public class TagsTest {

	/**
	 * Test case for Tag.addTag()
	 * @See Tags
	 */
	
	@Test
	public void testAddTag() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		testTag.addTag("velocity");
		assertEquals("time", testTag.getTag(0));
	}

	/**
	 * Test case for Tag.deleteTag()
	 * @See Tags
	 */
	
	@Test
	public void testDeleteTag() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		testTag.addTag("velocity");
		testTag.deleteTag("time");
		assertEquals("velocity", testTag.getTag(0));
	}

	/** 
	 * Test case for Tags.clearTags
	 * @See Tags
	 */
	
	@Test
	public void testClearTags() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		testTag.addTag("velocity");
		testTag.clearTags();
		assertEquals(0, testTag.getSize());
	}

	/**
	 * Test case for Tags.getTag(i)
	 * @See Tags
	 */
	
	@Test
	public void testGetTag() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		assertEquals("time", testTag.getTag(0));
	}

	/**
	 * Test case for Tags.returnAllTags
	 * @See Tags
	 */
	
	@Test
	public void testReturnAllTags() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		testTag.addTag("velocity");
		assertEquals(" time velocity", testTag.returnAllTags());
	}
	
	/**
	 * Test case for returning empty tags
	 * @See Tags
	 */
	
	@Test
	public void testReturnEmptyTags() {
		Tags testTag = new Tags();
		assertEquals("No tags Available", testTag.returnAllTags());
	}

	/**
	 * Test case for Tags.getSize()
	 * @See Tags
	 */
	
	@Test
	public void testGetSize() {
		Tags testTag = new Tags();
		testTag.addTag("time");
		testTag.addTag("velocity");
		assertEquals(2, testTag.getSize());
	} 

}
