package byteCode;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Mul
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Mul extends Arithmetics{
	
	/**
	 * Constructora para ByteCode Mul
	 */
	public Mul(){
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toString() {
		return "MUL";
	}

	/**
	 * Metodo auxiliar que ejecuta  ByteCode aritmetico
	 * @param CPU cpu
	 * @param int valor1
	 * @param int valor2
	 * @return boolean 
	 * @throws StackException 
	 */
	public void executeArithmetics(CPU cpu, int valor1, int valor2) throws StackException {
		cpu.push(valor1 * valor2);
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	public Arithmetics parseAux(String s) {
		if(s.equalsIgnoreCase("MUL")) return new Mul();
		else return null;
	}
}
