package teste.printersafe;

import java.util.Random;

/*
 * Producer
 * Esta classe, que representa um produtor de trabalhos, possui uma referência para a
 * fila de impressão QUEUE. A thread do produtor será responsável por produzir
 * trabalhos de impressão e adicioná-los na fila. Adicione de 10 a 20 trabalhos com
 * nomes e número de páginas diferentes.
 * Os trabalhos devem ser produzidos e adicionados na fila em intervalos de tempo de
 * até 5 segundos. Por exemplo, adicione o primeiro trabalho, espere 1 segundo, adicione
 * o segundo trabalho, espere 3 segundos, adicione o terceiro, espere 2 segundos...
 * 
 */
public class Producer implements Runnable {

	private final String name;
	private final Queue<PrintJob> queue;

	public Producer(String name, Queue<PrintJob> queue) {
		this.name = name;
		this.queue = queue;
	}

	@Override
	public void run() {
		Random gerador = new Random();

		for (int i = 0; i < 20; i++) {
			PrintJob printJob = new PrintJob(String.format("Proposta%d.txt", i), gerador.nextInt(10) + 1);
			System.out.println(String.format("[Producer]: produzindo arquivo: %s, numero de paginas: %d",
					printJob.getJobName(), printJob.getNumberOfPage()));
			queue.enqueue(printJob);
			sleepTime(1000 * (gerador.nextInt(4) + 1));
		}

	}

	private void sleepTime(long value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
	}
}
