package structures;

public interface BSTInterface<T extends Comparable<T>> {

	/**
	 * 
	 * @return true if and only if the tree contains no elements
	 */
	boolean isEmpty();

	/**
	 * 
	 * @return the number of elements stored in the tree
	 */
	int size();

	/**
	 * Attempts to remove one copy of an element from the tree, returning true
	 * if and only if such a copy was found and removed.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * @param element
	 * @return true if and only if an element removed
	 * @throws NullPointerException if element is null
	 */
	boolean remove(T element);

	/**
	 * 
	 * @param element
	 * @return the element in the tree which .equals() the argument, or null if
	 *         no such element exists
	 * @throws NullPointerException if element is null
	 */
	T get(T element);

	/**
	 * Adds an element to the tree.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * @param element
	 * @throws NullPointerException if element is null
	 */
	void add(T element);

	/**
	 * 
	 * @return the height of the tree, or -1 if the tree is empty
	 */
	public int height();

	/**
	 * (This is a utility method that you would not include in a real BST's
	 * public interface. It's here to help us grade and to help you write
	 * tests.)
	 * 
	 * @return the root BSTNode of this tree
	 */
	public BSTNode<T> getRoot();

}