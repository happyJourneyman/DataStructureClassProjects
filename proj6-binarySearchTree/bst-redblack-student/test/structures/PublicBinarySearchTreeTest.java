package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class PublicBinarySearchTreeTest {

	private BSTInterface<Integer> emptyTree;
	private BSTInterface<String> oneNodeTree;
	private static final String FOO = "foo";

	@Rule
    public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		emptyTree = new BinarySearchTree<Integer>();
		oneNodeTree = new BinarySearchTree<String>();
		oneNodeTree.addElement(FOO);
	}
	
	@Test
	public void testEmpty() {
		assertTrue(emptyTree.isEmpty());
	}

	@Test
	public void testNotEmpty() {
		assertFalse(oneNodeTree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyTree.getSize());
		assertEquals(1, oneNodeTree.getSize());
	}
	
	@Test
	public void testContains() {
		assertTrue(oneNodeTree.contains(FOO));
	}
	
	@Test
    public void testRemove() {
		assertFalse(emptyTree.removeElement(0));
	}
	
	@Test
	public void testGet() {
		assertEquals(FOO, oneNodeTree.getElement(FOO));
	}
	
	@Test
	public void testAdd() {
		emptyTree.addElement(1);
		assertFalse(emptyTree.isEmpty());
		assertEquals(1, emptyTree.getSize());
	}
	
	@Test
	public void testgetMin() {
		assertEquals(null, emptyTree.getMin());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(FOO, oneNodeTree.getMax());
	}

	@Test
	public void testHeight() {
		assertEquals(-1, emptyTree.height());
		assertEquals(0, oneNodeTree.height());
	}
	
	@Test
	public void testPreorderIterator() {
		Iterator<String> i = oneNodeTree.preorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}

	@Test
	public void testInorderIterator() {
		Iterator<String> i = oneNodeTree.inorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> i = emptyTree.postorderIterator();
		assertFalse(i.hasNext());
	}
	
	@Test
	public void testEquals() {
		BSTInterface<String> tree = new BinarySearchTree<String>();
		assertFalse(oneNodeTree.equals(tree));
		tree.addElement(new String("foo"));
		assertTrue(oneNodeTree.equals(tree));
	}
	
	@Test
	public void testSameValues() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.addElement(1);
		emptyTree.addElement(2);
		
		tree.addElement(2);
		tree.addElement(1);
		
		assertTrue(emptyTree.sameValues(tree));
	}

	@Test
	public void testLowestValue() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(1);
		tree.addElement(7);
		tree.addElement(2);
		tree.addElement(6);

		assertTrue(tree.getLowestValueFromSubtree(tree.getRoot()) == 1);
	}

	@Test
	public void testHighestValue() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(1);
		tree.addElement(7);
		tree.addElement(2);
		tree.addElement(6);

		assertTrue(tree.getHighestValueFromSubtree(tree.getRoot()) == 7);
	}

	@Test
	public void testRemoveLeftmost() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(1);
		tree.addElement(7);
		tree.addElement(2);
		tree.addElement(6);

		assertTrue(tree.getLowestValueFromSubtree(tree.getRoot()) == 1);
		tree.removeLeftmostFromSubtree(tree.getRoot());
		assertTrue(tree.getLowestValueFromSubtree(tree.getRoot()) == 2);
		tree.removeLeftmostFromSubtree(tree.getRoot());
		assertTrue(tree.getLowestValueFromSubtree(tree.getRoot()) == 3);
		tree.removeLeftmostFromSubtree(tree.getRoot());
		assertTrue(tree.getLowestValueFromSubtree(tree.getRoot()) == 3);
	}

	@Test
	public void testCountRange() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(1);
		tree.addElement(7);
		tree.addElement(2);
		tree.addElement(6);

		assertTrue(tree.countRange(1, 7) == 5);
		assertTrue(tree.countRange(2, 7) == 4);
	}

	@Test
	public void testCountRangeSameMinAndMax() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);
		tree.addElement(1);
		tree.addElement(7);
		tree.addElement(2);
		tree.addElement(6);

		assertTrue(tree.countRange(3, 3) == 0);
	}
}
