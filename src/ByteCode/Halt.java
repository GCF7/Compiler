package byteCode;
import practica3.CPU;

/**
 * Clase de ByteCode Halt
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Halt extends ByteCodeWithoutParameter {
	
	/**
	 * Constructora para ByteCode Halt
	 */
	public Halt() {
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toString() {
		return "HALT";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu 
	 */
	public void execute(CPU cpu) {
		cpu.halt();
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	public ByteCodeWithoutParameter parseAux(String s) {
		if(s.equalsIgnoreCase("HALT")) return new Halt();
		else return null;
	}

}
