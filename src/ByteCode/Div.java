package byteCode;
import excepciones.DivByZeroException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Div
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Div extends Arithmetics{
	
	/**
	 * Constructora para ByteCode Div
	 */
	public Div () {
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toString() {
		return "DIV";
	}

	/**
	 * Metodo auxiliar que ejecuta  ByteCode aritmetico
	 * @param CPU cpu
	 * @param int valor1
	 * @param int valor2
	 * @throws StackException 
	 */
	public void executeArithmetics(CPU cpu, int valor1, int valor2) throws DivByZeroException, StackException {
		if (valor1 != 0) {
			cpu.push(valor2 / valor1);
		}
		else throw new DivByZeroException();
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	public Arithmetics parseAux (String s) {
		if(s.equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}

}
