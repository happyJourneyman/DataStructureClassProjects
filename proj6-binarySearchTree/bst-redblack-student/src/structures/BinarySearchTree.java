package structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root; 
	
	

	public boolean isEmpty() {
		return root == null;
	}

	public int getSize() {
		// TODO
		if (isEmpty()) {
			return 0; 
		}
		return 1 + sizeGetter(root);
	}

	private int sizeGetter(BSTNode<T> node) {
		if (isEmpty() || node == null) {
			return 0; 
		}
		
		int x = 0;
		if (node.getLeft() != null) {
			x+=1; 
		}
		if (node.getRight() != null) {
			x+=1; 
		}
		
		return x + sizeGetter(node.getLeft()) + sizeGetter(node.getRight()); 
		
	} 
	
	public boolean contains(T t) {
		// TODO	
		
		if (t == null) {
			throw new NullPointerException(); 
		}
		
		if (isEmpty()) {
			return false; 
		}
		
		return containsChecker(t, root);
	}
	
	private boolean containsChecker(T t, BSTNode<T> node) {
		if (node == null) {
			return false; 
		}
		
		if (t.compareTo(node.getData()) < 0) {
			return containsChecker(t, node.getLeft()); 
		}
		if (t.compareTo(node.getData()) > 0) {
			return containsChecker(t, node.getRight()); 
		}
		
		return true; 
	}

	public boolean removeElement(T t) {
		// TODO
		
		if (t == null) {
			throw new NullPointerException(); 
		}
		
		if (isEmpty() || !containsChecker(t, root)) {
			return false;
		}
		
		return remover (t, root); 
		
	}
	
	private boolean remover(T t, BSTNode<T> node) {
		if (node == null) {
			return false; 
		}
		
		if (t.compareTo(node.getData()) == 0) {
			if (node.getLeft()!=null) {
				BSTNode<T> nodeRight = node.getRight();
				
			}
		}
		
		return remover(t, node.getLeft()) || remover(t, node.getRight()); 
	}
	
	

	public T getHighestValueFromSubtree(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValueFromSubtree(node.getRight());
		}
	}

	public T getLowestValueFromSubtree(BSTNode<T> node) {
		// TODO
		if (node.getLeft() == null) {
			return node.getData();
		} else {
			return getLowestValueFromSubtree(node.getLeft());
		}
	}

	private BSTNode<T> removeRightmostFromSubtree(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmostFromSubtree(node.getRight()));
			if (node.getRight() != null){
				node.getRight().setParent(node);
			}
			return node;
		}
	}

	public BSTNode<T> removeLeftmostFromSubtree(BSTNode<T> node) {
		// node must not be null
			if (node.getLeft() == null) {
				return node.getRight();
			} else {
				node.setLeft(removeLeftmostFromSubtree(node.getLeft()));
				if (node.getLeft() != null){
					node.getLeft().setParent(node);
				}
				return node;
			}
	}

	public T getElement(T t) {
		// TODO
		
		if (t == null) {
			throw new NullPointerException(); 
		}
		
		Iterator<T> thisIterator = this.inorderIterator(); 
		
		while (thisIterator.hasNext()) {
			T comparison = thisIterator.next(); 
			if (t.compareTo(comparison) == 0) {
				return comparison; 
			}
		}
		return null; 
		
	}

	public void addElement(T t) {
		// TODO
		if (t == null) {
			throw new NullPointerException(); 
		}
		
		if (root == null) {
			root = new BSTNode<T>(t, null, null);
		}
		
		else {
		root = adder(t, root);
		}
		
	}

	private BSTNode<T> adder(T t, BSTNode<T> node) {
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		if (t.compareTo(node.getData()) > 0) {
			node.setRight(adder(t, node.getRight()));
		} else {
			node.setLeft(adder(t, node.getLeft()));
		}
		return node;
	}

	@Override
	public T getMin() {
		// TODO
		
		if (root == null) {
			return null; 
		}
		
		Iterator<T> thisIterator = this.inorderIterator(); 
		T smallest = thisIterator.next(); 
		while (thisIterator.hasNext()) {
			T comparison = thisIterator.next(); 
			if (comparison.compareTo(smallest) < 0) {
				smallest = comparison; 
			}
		}
		return smallest; 
	
	}


	@Override
	public T getMax() {
		// TODO
		
		
		if (root == null) {
			return null; 
		}
		
		Iterator<T> thisIterator = this.inorderIterator(); 
		T biggest = thisIterator.next(); 
		while (thisIterator.hasNext()) {
			T comparison = thisIterator.next(); 
			if (comparison.compareTo(biggest) > 0) {
				biggest = comparison; 
			}
		}
		return biggest; 
	}

	@Override
	public int height() {
		// TODO
		if (isEmpty()) {
			return -1;
		}
		
		if (getSize() == 1) {
			return 0; 
		}
		
		return heightFinder(root) - 1;
	}
	
	private int heightFinder(BSTNode<T> node) {
		if (node == null) {
			return 0; 
		}
		
		return 1 + Math.max(heightFinder(node.getLeft()), heightFinder(node.getRight()));
		
	}

	public Iterator<T> preorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();
	}
	
	
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			inorderTraverse(queue, node.getLeft());
			inorderTraverse(queue, node.getRight());
		}
	}


	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}

	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	public Iterator<T> postorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}

	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		
		if (other == null) {
			throw new NullPointerException(); 
		}
		
		Iterator<T> thisIterator = this.inorderIterator(); 
		Iterator<T> otherIterator = other.inorderIterator(); 
		
		while (thisIterator.hasNext() && otherIterator.hasNext()) {
			if (!thisIterator.next().equals(otherIterator.next())) {
				return false;
			}
		}
		
		if (thisIterator.hasNext() || otherIterator.hasNext()) {
			return false; 
		}
		
		return true; 
		 
	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		
		if (other == null) {
			throw new NullPointerException(); 
		}
		
		Iterator<T> thisIterator = this.inorderIterator(); 
		Iterator<T> otherIterator = other.inorderIterator(); 
		
		while (thisIterator.hasNext() && otherIterator.hasNext()) {
			if (!thisIterator.next().equals(otherIterator.next())) {
				return false;
			}
		}
		
		if (thisIterator.hasNext() || otherIterator.hasNext()) {
			return false; 
		}
		
		return true; 
	}
	
	@Override
	public int countRange(T min, T max) {
    	// TODO
		
		int count = 0; 
		Iterator<T> thisIterator = this.inorderIterator(); 
		while (thisIterator.hasNext()) {
			T comparison = thisIterator.next(); 
			if (comparison.compareTo(max) < 0 && comparison.compareTo(min) > 0) {
				count++; 
			}
		}
		return count; 
  }


	@Override
	public BSTNode<T> getRoot() {
        // DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}

	public static void main(String[] args) {
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			BSTInterface<String> tree = new BinarySearchTree<String>();
			for (String s : new String[] { "d", "b", "a", "c", "f", "e", "g" }) {
				tree.addElement(s);
			}
			Iterator<String> iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.preorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.postorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();

			System.out.println(tree.removeElement(r));

			iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
		}

		BSTInterface<String> tree = new BinarySearchTree<String>();
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			tree.addElement(r);
		}
		System.out.println(tree.getSize());
		System.out.println(tree.height());
		System.out.println(tree.countRange("a", "g"));
		System.out.println(tree.countRange("c", "f"));
	}
}