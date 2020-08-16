package teste.printersafe;

/*
 * Teste C#
 * Printer
 * Esta classe, que representa numa impressora, possui uma refer�ncia para a fila de
 * impress�o QUEUE. A thread da classe ser� respons�vel por imprimir um trabalho da
 * fila sempre que o mesmo estiver dispon�vel.
 * O m�todo que desliga a impressora halt() faz com que a impressora finalize a
 * impress�o do trabalho corrente e ent�o desligue.
 * Ao retirar um trabalho da fila, a impressora imprime o trabalho multiplicando o valor
 * de MILLIS_PER_PAGE pelo total de p�ginas do trabalho e esperando por este tempo
 * antes de notificar o usu�rio que a impress�o do trabalho foi finalizada.
 * Quando a fila estiver vazia a impressora dever� esperar � e n�o consumir
 * processamento � at� que seja notificada sobre a exist�ncia de novos trabalhos de
 * impress�o na fila.
 */

public class Printer implements Runnable {

	private static final long MILLIS_PER_PAGE = 500;
	private volatile boolean bTurnedOn = true;

	private final String printerName;
	private final Queue<PrintJob> queue;

	public Printer(String printerName, Queue<PrintJob> queue) {
		this.printerName = printerName;
		this.queue = queue;
	}

	@Override
	public void run() {

		System.out.println("Ligando...");
		System.out.println("Aguardando por trabalho...");

		boolean bPrinted = true;

		// Escutar a fila e processar
		while (bTurnedOn) {

			PrintJob printJob = queue.dequeue();
			if (printJob == null) {
				if (!bPrinted) {
					System.out.println("Aguardando por trabalho...");
					bPrinted = true;
				}
				sleepTime(1);
				continue;
			}
			bPrinted = false;

			// Processando trabalho
			System.out.println("Imprimindo " + printJob.getJobName());

			// Printar o conteudo do arquivo -- printJob
			sleepTime(MILLIS_PER_PAGE * printJob.getNumberOfPage());
		}

		System.out.println("Desligando impressora");
	}

	public void halt() {
		bTurnedOn = false;
	}

	private void sleepTime(long value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
	}
}
