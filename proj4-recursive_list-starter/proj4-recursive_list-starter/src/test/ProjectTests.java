package test;

import static org.junit.Assert.*;

import app.*;
import org.junit.Before;
import org.junit.Test;


public class ProjectTests {

	private ListInterface<String> list;

	@Before
	public void setup() {
		list = new RecursiveList<String>();
	}

	@Test
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
	}

	@Test
	public void testInsertFirstIsEmptySizeAndGetFirst3() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.insertAtBeginning("hello");
		assertEquals("Inserted and then got an element at the first position", "hello", list.getFirst());
	}

	@Test(timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyGetLast() {
		list.getLast();
	}

	@Test(timeout = 500, expected = ItemNotFoundException.class)
	public void testItemNotFoundExceptionOnRemove() {
		list.insertAtBeginning("hello");
		list.removeElement("there");
	}

	@Test
	public void testInsertsAts() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertAtEnd("B");
		list.insertAtEnd("E");
		list.insertAt(1, "D");
		list.insertAt(1, "C");
		list.insertAtEnd("G");
		list.insertAtBeginning("A");
		list.insertAt(5, "F");

		assertEquals("Checking position 0.", "A", list.getAt(0));
		assertEquals("Checking position 1.", "B", list.getAt(1));
		assertEquals("Checking position 2.", "C", list.getAt(2));
		assertEquals("Checking position 3.", "D", list.getAt(3));
		assertEquals("Checking position 4.", "E", list.getAt(4));
		assertEquals("Checking position 5.", "F", list.getAt(5));
		assertEquals("Checking position 6.", "G", list.getAt(6));
	}

	@Test
	public void testIndexOf() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertAtEnd("B");
		list.insertAtEnd("E");
		list.insertAt(1, "D");
		list.insertAt(1, "C");
		list.insertAtEnd("G");
		list.insertAtBeginning("A");
		list.insertAt(5, "F");

		assertEquals("Checking index of A.", 0, list.indexOf("A"));
		assertEquals("Checking index of B.", 1, list.indexOf("B"));
		assertEquals("Checking index of C.", 2, list.indexOf("C"));
		assertEquals("Checking index of D.", 3, list.indexOf("D"));
		assertEquals("Checking index of E.", 4, list.indexOf("E"));
		assertEquals("Checking index of F.", 5, list.indexOf("F"));
		assertEquals("Checking index of G.", 6, list.indexOf("G"));
	}

	@Test
	public void testRemoveAts() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertAtEnd("B");
		list.insertAtEnd("E");
		list.insertAt(1, "D");
		list.insertAt(1, "C");
		list.insertAtEnd("G");
		list.insertAtBeginning("A");
		list.insertAt(5, "F");

		list.removeFirst();
		list.removeAt(4);
		list.removeLast();

		assertEquals("Checking position 0.", "B", list.getAt(0));
		assertEquals("Checking position 1.", "C", list.getAt(1));
		assertEquals("Checking position 2.", "D", list.getAt(2));
		assertEquals("Checking position 3.", "E", list.getAt(3));
	}

	@Test
	public void testInsertsGetsRemovesSize() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertAtEnd("Hello");
		list.insertAtEnd("World!");
		list.insertAt(1, "There");

		assertEquals("Checking position 1.", "There", list.getAt(1));

		assertEquals("Size should be 3", 3, list.size());
		assertEquals("0th element should .equals \"Hello\"", "Hello", list.getAt(0));
		assertEquals("Last element should .equals \"World!\"", "World!", list.getLast());
		assertEquals("Size should be 3", 3, list.size());
		list.insertAt(0, "foo"); // HERE ITS ADDED TWICE
		list.insertAt(4, "bar");
		assertEquals("foo", list.getAt(0));
		assertEquals("bar", list.getAt(4));
		assertEquals("Size should be 5", 5, list.size());
		assertEquals("The third element should have been \"World!\"", "World!", list.removeAt(3));
		assertEquals("Size should be 4", 4, list.size());
		assertEquals("Last element should be \"bar\"", "bar", list.getLast());
	}

}
