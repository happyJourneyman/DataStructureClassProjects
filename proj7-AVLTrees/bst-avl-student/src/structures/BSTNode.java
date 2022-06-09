package structures;

/**
 * A node in a BST.
 * 
 * Note that BSTNode MUST implement BSTNodeInterface; removing this will resulit
 * in your program failing to compile for the autograder.
 * 
 * @author liberato
 *
 * @param <T>
 */
public class BSTNode<T extends Comparable<T>> implements BSTNodeInterface<T> {
	private T data;
	private int height;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private BSTNode<T> parent;

	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
		this.data = data;
		this.left = left;
		if (left != null) {left.setParent(this);}
		this.right = right;
		if (right != null) {right.setParent(this);}
		parent = null;
		height = 0;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	public BSTNode<T> getParent() {
		return parent;
	}
	
	public void setParent(BSTNode<T> p) {
		this.parent = p;
	}
	
	public void printSubtree(int spaces) {
		if (right != null) {
			right.printSubtree(spaces + 5);
		}
		for (int i = 0; i < spaces; i++) {
			System.out.print(" ");
		}
		System.out.print(data);
		System.out.print('-');
		if (left != null) {
			left.printSubtree(spaces + 5);
		}
	}
}