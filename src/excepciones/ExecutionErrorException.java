package excepciones;

@SuppressWarnings("serial")
public class ExecutionErrorException extends Exception {
	/**
	 * Constructora
	 */
	public ExecutionErrorException() {
		 super("División por cero");
	 }
	/**
	 * Constructora con parametro
	 * @param mensaje
	 */
	 public ExecutionErrorException(String mensaje) {
		 super("ExecutionErrorException: " + mensaje);
	 }
}
