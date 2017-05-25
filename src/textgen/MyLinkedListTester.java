/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	//LLNode<Integer> prev;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		String s= shortList.remove(1);
		assertEquals("Remove: check s is correct ", "B", s);
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		//assertEquals("Remove: check pointer equal ", list1.get(0).prev, list1.head);
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		int s =list1.size;
		//System.out.print(s);
		assertEquals("Check end",(Integer) 42, list1.get(s-1));
		assertEquals("Check secondLast",(Integer) 21, list1.get(s-2));
		try {
			list1.add(null);
			fail("Check for null ");
		}
		catch (NullPointerException e) {
		
		}
		
        // TODO: implement this test
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		
		assertEquals("Check size",(Integer)3,(Integer)list1.size());
		assertEquals("Check size",(Integer)10,(Integer)longerList.size());
		assertEquals("Check size",(Integer)0,(Integer)emptyList.size());
		
		
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		list1.add(2,45);
		assertEquals("Check add at index",(Integer) 45, list1.get(2));
		longerList.add(3,21);
		assertEquals("Check add at index",(Integer) 21, longerList.get(3));
		shortList.add(0,"C");
		assertEquals("Check add at index", "C", shortList.get(0));
		try {
			list1.add(-1,37);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.add(5,89);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.add(2,null);
			fail("check for null");
		}
		catch (NullPointerException e) {
		
		}
		
		
        // TODO: implement this test
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		list1.set(2,45);
		assertEquals("Check add at index",(Integer) 45, list1.get(2));
		longerList.set(3,21);
		assertEquals("Check add at index",(Integer) 21, longerList.get(3));
		try {
			list1.set(-1,37);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.set(5,89);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.set(2,null);
			fail("Check for null");
		}
		catch (NullPointerException e) {
		
		}
		
		
		
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
