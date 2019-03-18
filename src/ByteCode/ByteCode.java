package byteCode;
import excepciones.ArrayException;
import excepciones.DivByZeroException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Esta clase construye ByteCodes para su posterior utilizacion
 * @author Guillermo Delgado y Guillermo Cortina
 */
public interface ByteCode {
	
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public abstract String toString();
	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @throws DivByZeroException 
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	abstract public void execute(CPU cpu) throws DivByZeroException, StackException, ArrayException;
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	abstract public ByteCode parse(String[ ] s);
		
	
}
