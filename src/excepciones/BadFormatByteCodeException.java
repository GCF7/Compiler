package excepciones;

@SuppressWarnings("serial")
public class BadFormatByteCodeException extends Exception {
	/**
	 * Constructora
	 */
	public BadFormatByteCodeException() {
			 super("BadFormatByteCodeException");
	}
	
	/**
	 * Constructora con parametro
	 * @param mensaje
	 */
	public BadFormatByteCodeException(String mensaje) {
			 super(mensaje);
		 
	}
}
