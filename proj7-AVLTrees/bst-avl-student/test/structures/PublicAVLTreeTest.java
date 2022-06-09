package structures;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class PublicAVLTreeTest {

	private AVLTree<Integer> tree;
	
	@Before
	public void before() {
		tree = new AVLTree<Integer>();
	}

	@Test
	public void testUpdateHeight() {
		BSTNode<Integer> testNodeL = new BSTNode<Integer>(186, null, null);
		BSTNode<Integer> testNodeR = new BSTNode<Integer>(121, null, null);
		BSTNode<Integer> testNode = new BSTNode<Integer>(187, testNodeL, testNodeR);

		testNodeL.setHeight(1);
		testNodeR.setHeight(2);
		tree.updateHeight(testNode);
		assertEquals(3, testNode.getHeight());
	}

	@Test
	public void testBalanceFactor() {
		BSTNode<Integer> testNodeL = new BSTNode<Integer>(186, null, null);
		BSTNode<Integer> testNodeR = new BSTNode<Integer>(121, null, null);
		BSTNode<Integer> testNode = new BSTNode<Integer>(187, testNodeL, testNodeR);

		testNodeL.setHeight(1);
		testNodeR.setHeight(2);
		assertEquals(1, tree.balanceFactor(testNode));
	}

	@Test
	public void testLeftRotate() {
		BSTNode<Integer> testNode1 = new BSTNode<Integer>(186, null, null);
		BSTNode<Integer> testNode2 = new BSTNode<Integer>(121, null, testNode1);
		BSTNode<Integer> testNode3 = new BSTNode<Integer>(187, null, testNode2);

		assertTrue(testNode3.getRight() == testNode2);
		assertTrue(testNode1.getParent() == testNode2);
		assertTrue(testNode2.getRight() == testNode1);
		assertTrue(testNode2.getParent() == testNode3);

		BSTNode<Integer> node = tree.rotateLeft(testNode3);
		assertTrue(node == testNode2);
		assertTrue(testNode1.getParent() == testNode2);
		assertTrue(testNode3.getParent() == testNode2);
		assertTrue(testNode2.getLeft() == testNode3);
		assertTrue(testNode2.getRight() == testNode1);
	}

	@Test
	public void testRotateRight() {
		BSTNode<Integer> testNode1 = new BSTNode<Integer>(186, null, null);
		BSTNode<Integer> testNode2 = new BSTNode<Integer>(121, testNode1, null);
		BSTNode<Integer> testNode3 = new BSTNode<Integer>(187, testNode2, null);

		assertTrue(testNode3.getLeft() == testNode2);
		assertTrue(testNode1.getParent() == testNode2);
		assertTrue(testNode2.getLeft() == testNode1);
		assertTrue(testNode2.getParent() == testNode3);

		BSTNode<Integer> node = tree.rotateRight(testNode3);
		assertTrue(node == testNode2);
		assertTrue(testNode1.getParent() == testNode2);
		assertTrue(testNode3.getParent() == testNode2);
		assertTrue(testNode2.getLeft() == testNode1);
		assertTrue(testNode2.getRight() == testNode3);
	}
	
	@Test
	public void testAdd3() {
		tree.add(0);
		assertTrue(tree.getRoot().getData().equals(0));
		tree.add(1);
		assertTrue(tree.getRoot().getData().equals(0));
		assertTrue(tree.getRoot().getRight().getData().equals(1));
		assertTrue(tree.getRoot().getRight().getParent().getData().equals(0));
		tree.add(2);
		assertTrue(tree.getRoot().getData().equals(1));
		assertTrue(tree.getRoot().getLeft().getData().equals(0));
		assertTrue(tree.getRoot().getLeft().getParent().getData().equals(1));
		assertTrue(tree.getRoot().getRight().getData().equals(2));
		assertTrue(tree.getRoot().getRight().getParent().getData().equals(1));
		assertEquals(3, tree.size());
	}

	@Test
	public void testHeight6() {
		tree.add(0);
		assertEquals(0, tree.height());
		tree.add(1);
		assertEquals(1, tree.height(tree.getRoot()));
		assertEquals(0, tree.height(tree.getRoot().getRight()));
		tree.add(2);
		assertEquals(1, tree.height(tree.getRoot()));
		assertEquals(0, tree.height(tree.getRoot().getLeft()));
		assertEquals(0, tree.height(tree.getRoot().getRight()));
		assertEquals(3, tree.size());
		tree.add(3);
		assertEquals(2, tree.height(tree.getRoot()));
		assertEquals(0, tree.height(tree.getRoot().getLeft()));
		assertEquals(1, tree.height(tree.getRoot().getRight()));
		assertEquals(0, tree.height(tree.getRoot().getRight().getRight()));
		tree.add(4);
		assertEquals(2, tree.height(tree.getRoot()));
		assertEquals(0, tree.height(tree.getRoot().getLeft()));
		assertEquals(1, tree.height(tree.getRoot().getRight()));
		assertEquals(0, tree.height(tree.getRoot().getRight().getLeft()));
		assertEquals(0, tree.height(tree.getRoot().getRight().getRight()));
		tree.add(5);
		assertEquals(2, tree.height(tree.getRoot()));
		assertEquals(1, tree.height(tree.getRoot().getLeft()));
		assertEquals(0, tree.height(tree.getRoot().getLeft().getLeft()));
		assertEquals(0, tree.height(tree.getRoot().getLeft().getRight()));
		assertEquals(1, tree.height(tree.getRoot().getRight()));
		assertEquals(0, tree.height(tree.getRoot().getRight().getRight()));
		assertEquals(6, tree.size());
	}

	@Test
	public void testAdd6() {
		tree.add(0);
		assertEquals(0, tree.height());
		assertTrue(tree.getRoot().getData().equals(0));
		tree.add(1);
		assertEquals(1, tree.height());
		assertTrue(tree.getRoot().getData().equals(0));
		tree.add(2);
		assertEquals(1, tree.height());
		assertTrue(tree.getRoot().getData().equals(1));
		tree.add(3);
		assertEquals(2, tree.height());
		assertTrue(tree.getRoot().getData().equals(1));
		tree.add(4);
		assertEquals(2, tree.height());
		assertTrue(tree.getRoot().getData().equals(1));
		tree.add(5);
		assertEquals(2, tree.height());
		assertTrue(tree.getRoot().getData().equals(3));
		assertEquals(6, tree.size());
	}
	
}
