package teste.printersafe;

/*
 * PrinterApp
 * A main class PrinterApp dever� criar a fila de impress�o, que dever� ser compartilhada
 * por 2 inst�ncias de Producer e uma �nica inst�ncia de Printer.
 * 
 */
public class PrinterApp {

	public static void main(String[] args) {

		// Criar a fila de impressao - tamanho da fila no parametro no construtor 
		Queue<PrintJob> printerQueue = new CircularQueue(20);

		// Criar o runnable do printer
		Runnable printer = new Printer("MyPrinter", printerQueue);

		// Cria a thread do printer
		Thread thread1 = new Thread(printer, "Printer");
		thread1.start();


		// Criar o runnable do producer
		Runnable producer = new Producer("MyProducer", printerQueue);

		// Cria a thread do producer
		Thread thread2 = new Thread(producer, "Producer");
		thread2.start();

	}

}
