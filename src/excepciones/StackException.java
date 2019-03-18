package excepciones;

@SuppressWarnings("serial")
public class StackException extends ExecutionErrorException {
	/**
	 * Constructora
	 */
	public StackException() {
		 super("StackException");
	 }
	/**
	 * Constructora con parametro
	 * @param mensaje
	 */
	 public StackException(String mensaje) {
		 super(mensaje);
	 }

}
