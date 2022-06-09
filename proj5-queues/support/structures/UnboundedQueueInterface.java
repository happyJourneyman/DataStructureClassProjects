package structures;

import java.util.NoSuchElementException;

/**
 * An unbounded queue.
 * 
 * When implementing this interface, be sure to implement 
 * both a regular no-argument constructor, and a copy constructor.
 * 
 * The copy constructor should have a signature something like:
 * 
 * public Queue(Queue<T> other) { 
 *   ...
 * }
 * 
 * and is fairly straightforward if you utilize the other methods you
 * need to implement (like getSize(), enqueue(), and dequeue()).
 *
 */
public interface UnboundedQueueInterface<T> {
	/**
	 * Returns true if the queue contains no
	 * elements. Must be O(1).
	 */
	public boolean isEmpty();
		
	/**
	 * Returns the number of element in the queue. Must be O(1).
	 * 
	 * @return the number of elements stored in the queue
	 */
	public int getSize();
	
	/**
	 * Enqueue an element at the rear of the queue. Most be O(1).
	 * @param element
	 */
	public void enqueue(T element);
	
	/**
	 * Dequeue (i.e. remove and return) the front element of the queue.
	 * Must be O(1).
	 * @return the front element in the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T dequeue() throws NoSuchElementException;
	
	/**
	 * Return (but do not remove) the front element of the queue.
	 * Must be O(1).
	 * @return the front element in the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek() throws NoSuchElementException;
	
	/**
	 * Returns a new queue with the elements in reverse order.
	 * Must be O(n).
	 * 
	 * @return a reversed copy of the queue
	 */
	public UnboundedQueueInterface<T> reversed();
}
