package teste.printersafe;

/*
 * Teste C#
 * 	PrintJob
 * 	Esta classe representa um arquivo a ser impresso e tem como atributos o nome e o
 *  número de páginas do arquivo. O número de páginas será usado pela impressora para
 *  “imprimir” o trabalho. Quanto maior o número de páginas mais tempo a impressora
 *  levará para imprimi-lo.
 * 
 */
class PrintJob {

	private final int numberOfPage;
	private final String jobName;

	PrintJob(String jobName, int numberOfPage) {
		this.jobName = jobName;
		this.numberOfPage = numberOfPage;
	}

	public String getJobName() {
		return jobName;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	@Override
	public String toString() {
		return "";
	}

}