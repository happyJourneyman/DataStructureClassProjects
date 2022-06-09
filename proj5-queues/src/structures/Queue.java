package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {

int size;
Node<T> head;
Node<T> tail;

public Queue() {
	this.size = 0;
	this.head = null;
	this.head = null;
    }

public Queue(Queue<T> other) {
            // TODO 2
	this.size = other.getSize();
	this.head = other.head;
	this.tail = other.tail;
}

@Override
public boolean isEmpty() {
	return size == 0;
}

@Override
public int getSize() {
    return size;
}

@Override
public void enqueue(T element) {
	Node<T> succ = new Node(element);

	if (isEmpty()) {
		head = succ;
		tail = succ;
	}
	else {
		tail.next = succ;
		tail = succ;
	}
	size++;
}

@Override
public T dequeue() throws NoSuchElementException {

if (isEmpty()) {
	throw new NoSuchElementException();
}

	T returnData = head.data;
	head = head.next;
	size--;
	return returnData;
}

@Override
public T peek() throws NoSuchElementException {
	if (isEmpty()) {
	throw new NoSuchElementException();
	}

	return head.data;
}


@Override
public UnboundedQueueInterface<T> reversed() {
            // TODO 8
	Node<T> temp = head;
	Queue<T> stor = new Queue<T>();
	reverser(temp, stor);
	return stor;
}

private void reverser(Node<T> node, Queue<T> queue) {
	if (node != null) {
	reverser(node.next, queue);
	queue.enqueue(node.data);
	}
}

}

class Node<T> {
public T data;
public Node<T> next;
public Node(T data) { this.data=data;}
public Node(T data, Node<T> next) {
this.data = data; this.next=next;
}
}
