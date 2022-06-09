package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  private int size;
  private Node<T> head = null;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1; 
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void insertAtBeginning(T elem) {
	  
	  if (elem == null) {
		  throw new NullPointerException(); 
	  }
	  
	  if (size == 0) {
		  Node<T> newNode = new Node(elem, head); 
		  head = newNode; 
		  size++;
	  }
	  else {
		  Node<T> newNode = new Node(elem, head); 
		  Node<T> next = head.getNext(); 
		  head = newNode; 
		  size++; 
	  }
  }

  @Override
  public void insertAtEnd(T elem) {
      //TODO: Implement this method.
	  
	  if (elem == null) {
		  throw new NullPointerException(); 
	  }
	  
	  if (size == 0) { 
		  Node<T> newNode = new Node(elem, null);
		  head = newNode; 
		  size++;
	  }
	  
	  else {
		  Node<T> newNode = new Node(elem, null);
		  Node<T> end = findNode(size-1, head);
		  end.setNext(newNode);
		  size++;
	  }
  }
  
  
  
  
 
  @Override
  public void insertAt(int index, T elem) {
      //TODO: Implement this method.
	  
	  if (elem == null) {
		  throw new NullPointerException(); 
	  }
	  
	  if (index >= size || index < 0) {
		  throw new IndexOutOfBoundsException(); 
	  }
	  
	  if (index == 0) {
		  insertAtBeginning(elem); 
	  }
	  else if (index == size) {
		  insertAtEnd(elem);
	  }
	  
	  else {
		  Node<T> curr = new Node<T>(elem, findNode(index, head)); 
		  findNode(index-1, head).setNext(curr);
		  if (index != size) {
			  curr.setNext(findNode(index+1, head));
		  }
		  size++; 
	  }
	 
	  
  }
  
  private final Node<T> findNode(int distance, Node<T> curr) {
	  if (distance != 0) {
		  if (curr.getNext().equals(null)) {
			  throw new IndexOutOfBoundsException();
		  }
		  return findNode(distance - 1, curr.getNext());
	  }
	  
	  return curr;
  }

  @Override
  public T removeFirst() {
      //TODO: Implement this method.
    if (size == 0) {
    	throw new IllegalStateException(); 
    }
    
    T removedItem = head.getData();
    
    if (size == 1) {
    	head = null;
    	size--;
    }
    else {
     head = head.getNext();   
     size--; 
    }
     return removedItem;
    }
  

  @Override
  public T removeLast() {
    
      //TODO: Implement this method.
	  if (size == 0) {
	    	throw new IllegalStateException(); 
	    }
	  
	T removedItem = findNode(size-1, head).getData();  
	
	if (size == 1) {
    	head = null;
    	size--;
    }
    else {
    	
    	Node<T> last = findNode(size-2, head); 
        last.setNext(null);
    	size--; 
    }
	
    return removedItem;
  }

  @Override
  public T removeAt(int i) {

	  if (i >= size || i < 0 || size == 0) {
		  throw new IndexOutOfBoundsException(); 
	  }
	  
	  T removedItem = head.getData();
	  
	  if (size == 1) {
		  head = null;
		  size--; 
		  return removedItem; 
	  }
	  
	  
	  removedItem = findNode(i, head).getData();
      //TODO: Implement this method.
	  
      Node<T> previous = findNode(i-1, head);
	  Node<T> next =  findNode(i+1, head);
      previous.setNext(next);
	  
	  size--; 
    
    return removedItem;
  }

  @Override
  public T getFirst() {
    
	if (size == 0) {
		throw new IllegalStateException(); 
	}
	  
    return head.getData();
  }

  @Override
  public T getLast() {
	  
	  if (size == 0) {
			throw new IllegalStateException(); 
		}
	    
	    return findNode(size-1, head).getData();
  }

  @Override
  public T getAt(int i) {
      //TODO: Implement this method.

	  if (i >= size || i < 0) {
		  throw new IndexOutOfBoundsException(); 
	  }
	  
    return findNode(i, head).getData();
  }

  @Override
  public void removeElement(T elem) {
      //TODO: Implement this method.
	  
	  if (elem == null) {
		  throw new NullPointerException(); 
	  }
	  
	  Node<T> hold = findNode(size-1, head);
	  if (!hold.getData().equals(elem)) {
		  throw new ItemNotFoundException(); 
	  }
	  else if (indexOf(elem) != -1) {
		  
		  removeAt(indexOf(elem));
		  size--;
	  }
  }

  @Override
  public int indexOf(T elem) {
      //TODO: Implement this method.
    
    if (elem == null) {
		  throw new NullPointerException(); 
	  }
    
    return indexOfHelper(elem, 0, head); 
  
  }
  
  private int indexOfHelper(T elem, int index, Node<T> node) {
	  if (node.getData() == elem) {
		  return index;
	  }
	  else if (node.getNext() == null || size == 0 || index >= size) {
		  return -1; 
	  }
	  return indexOfHelper(elem, index + 1, node.getNext());  
	  
  }


  @Override
  public boolean isEmpty() {
    return size == 0;
  }


  public Iterator<T> iterator() {
    Iterator<T> iter = new LinkedNodeIterator(head);
      //TODO: Implement this method.
  
   return iter;
  }
}
