package excepciones;

@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception {
	/**
	 * Constructora
	 */
	 public LexicalAnalysisException() {
		 super("LexicalAnalysisException");
	 }
	 /**
	  * Constructora con parametro
	  * @param mensaje
	  */
	 public LexicalAnalysisException(String mensaje) {
		 super(mensaje);
	 }
}