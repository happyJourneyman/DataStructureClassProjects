package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> implements PriorityQueueADT<T> {

  private int numElements;
  private T[] heap;
  private boolean isMaxHeap;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  /**
   * Constructor for the heap.
   * @param comparator comparator object to define a sorting order for the heap elements.
   * @param isMaxHeap Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
      //TODO: Implement this method.
      this.comparator = comparator; 
      this.isMaxHeap = isMaxHeap; 
      heap = (T[])new Object[INIT_SIZE];
      numElements = 0;  
  }

  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time.
   * Note: When enqueue is called, an entry is placed at the next available index in 
   * the array and then this method is called on that index. 
   *
   * @param index the index to bubble up
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleUp(int index) {
    //TODO: Implement this method.
    if (index >= heap.length || index < 0) {
      throw new IndexOutOfBoundsException(); 
    }

    while (index > 0) {
      int parentIndex = (index - 1) / 2; 
      if (heap[index] == null || heap[parentIndex] == null) {
        return; 
      }
      if (compareElements(heap[index], heap[parentIndex]) <=0)
         return;
      else {
         swap(index, parentIndex);
         index = parentIndex;
      }
    }

  }

  private void swap(int nodeIndex, int parentIndex){
    T tempNode = heap[nodeIndex];
    heap[nodeIndex] = heap[parentIndex];
    heap[parentIndex] = tempNode;
 }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * Note: When remove is called, if there are elements remaining in this
   *  the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   * 
   * @param index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleDown(int index) {
      //TODO: Implement this method.
    if (index >= heap.length || index < 0) {
      throw new IndexOutOfBoundsException(); 
    }

    int childIndex = 2 * index + 1;
     T value = heap[index];
     while (childIndex < numElements) {
       T maxValue = value;
       int maxIndex = -1;
       for (int i = 0; i < 2 && i + childIndex < numElements; i++) {
          if (compareElements(heap[i + childIndex], maxValue) > 0) {
             maxValue = heap[i + childIndex];
             maxIndex = i + childIndex;
          }
       }
       if (maxValue == value) {
          return;
       }
       else {
         swap(index, maxIndex);
         index = maxIndex;
         childIndex = 2 * index + 1;
      }
    }
  }

  /**
   * Test for if the queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    boolean isEmpty = (numElements == 0);
      //TODO: Implement this method.
    return isEmpty;
  }

  /**
   * Number of data elements in the queue.
   * @return the size
   */
  public int getSize(){
    int size = numElements;
      //TODO: Implement this method.
    return size;
  }

  /**
   * Compare method to implement max/min heap behavior. It changes the value of a variable, compareSign, 
   * based on the state of the boolean variable isMaxHeap. It then calls the compare method from the 
   * comparator object and multiplies its output by compareSign.
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * negative int otherwise (if isMaxHeap),
   * return negative int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * positive int otherwise (if ! isMinHeap).
   */
  public int compareElements(T element1 , T element2) {
    int result = 0;
    int compareSign =  -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap 
   * without removing the element.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {

    if (isEmpty()) {
      throw new QueueUnderflowException(); 
    }

     T data = heap[0];
     
      //TODO: Implement this method.
  
    return data;
  }  

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority in the heap.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeueElement() throws QueueUnderflowException{
      //TODO: Implement this method.
      if (isEmpty()) {
        throw new QueueUnderflowException();
      }
      T data = heap[0];
      numElements--;
      heap[0] = heap[numElements];
      heap[numElements]=null;
      bubbleDown(0);
      return data;
  }

  /**
   * Enqueue the element.
   * @param the new element
   */
  public void enqueueElement(T newElement) {
      //TODO: Implement this method.
      if (newElement == null) {
        throw new NullPointerException(); 
      }

      if(numElements == heap.length) {
        expand();
      }
    
      heap[numElements] = newElement;
      bubbleUp(numElements);
      numElements++;
  }

  private void expand(){
    T[] newArray = (T[])new Object[numElements*2];
    for(int i=0;i<heap.length;i++) {
        newArray[i]=heap[i];
    }
     heap = newArray;
 }


}