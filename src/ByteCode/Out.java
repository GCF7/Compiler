package byteCode;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Out
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Out extends ByteCodeWithoutParameter {
	
	/**
	 * Constructora para ByteCode Out
	 */
	public Out(){
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toString() {
		return "OUT";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @return boolean 
	 * @throws StackException 
	 */
	public void execute(CPU cpu) throws StackException {
		cpu.out();
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	public ByteCodeWithoutParameter parseAux(String s) {
		if(s.equalsIgnoreCase("OUT")) return new Out();
		else return null;
	}

}
