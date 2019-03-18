package excepciones;

@SuppressWarnings("serial")
public class ArrayException extends Exception {
	/**
	 * Constructora
	 */
	 public ArrayException() {
		 super("Array Exception");
	 }
	 /**
	  * Constructora con parametro
	  * @param mensaje
	  */
	 public ArrayException(String mensaje) {
		 super(mensaje);
	 }
}
