package teste.printersafe;

import java.util.Arrays;

/*
 * 
 * CircularQueue
 * A classe que implementa Queue.
 * 
 */
class CircularQueue implements Queue<PrintJob> {

	private volatile int currentSize; // Current Circular Queue Size
	private PrintJob[] circularQueueElements;
	private int maxSize; // Circular Queue maximum size

	private int rear;// rear position of Circular queue(new element enqueued at rear).
	private int front; // front position of Circular queue(element will be dequeued from front).

	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		circularQueueElements = new PrintJob[this.maxSize];
		currentSize = 0;
		front = 0;
		rear = 0;
	}

	/**
	 * Enqueue elements to rear.
	 */
	public synchronized void enqueue(PrintJob item) throws FullQueueException {

		if (isFull()) {
			throw new FullQueueException("Circular Queue is full. Element cannot be added");
		}

		circularQueueElements[rear] = item;
		rear = (rear + 1) % circularQueueElements.length;
		currentSize++;
	}

	/**
	 * Dequeue element from Front.
	 */
	public synchronized PrintJob dequeue() throws EmptyQueueException {

		if (isEmpty()) {
			return null;
		}

		PrintJob deQueuedElement = circularQueueElements[front];
		circularQueueElements[front] = null;
		front = (front + 1) % circularQueueElements.length;
		currentSize--;

		return deQueuedElement;
	}

	/**
	 * Check if queue is full.
	 */
	public boolean isFull() {
		return (currentSize == circularQueueElements.length);
	}

	/**
	 * Check if Queue is empty.
	 */
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	@Override
	public String toString() {
		return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
	}

}
