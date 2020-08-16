package teste.printersafe;

/*
 * A interface QUEUE define a fila de impressão do tipo FIFO (first in first out). Esta fila de
 * impressão deverá conter métodos para adicionar e remover trabalhos. Quando a
 * capacidade da fila for atingida, tentativas de adicionar novos trabalhos ocasionam
 * FullQueueException.IMPORTANTE: Considere para a montagem do seu sistema que existe apenas uma
 * única fila de impressão, thread-safe e compartilhada por printers e producers.
 */
public interface Queue<E> {
	
	
	public E dequeue();
	public void enqueue(E item);
	public boolean isEmpty();
	public boolean isFull();

}
