package excepciones;

@SuppressWarnings("serial")
public class DivByZeroException extends ExecutionErrorException {
	/**
	 * Constructora
	 */
	 public DivByZeroException() {
		 super("División por cero");
	 }
	 /**
	  * Constructora con parametro
	  * @param mensaje
	  */
	 public DivByZeroException(String mensaje) {
		 super(mensaje);
	 }
}

