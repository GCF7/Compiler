package byteCode;
import excepciones.DivByZeroException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode aritmeticos
 * @author Guillermo Delgado y Guillermo Cortina
 */
public abstract class Arithmetics extends ByteCodeWithoutParameter {
	
	/**
	 * Constructora para ByteCode sin parametros
	 */
	public Arithmetics () {
	}
	
	/**
	 * Metodo auxiliar que ejecuta  ByteCode aritmetico
	 * @param CPU cpu
	 * @param int valor1
	 * @param int valor2
	 * @return boolean 
	 * @throws StackException 
	 */
	abstract public void executeArithmetics(CPU cpu, int valor1, int valor2) throws DivByZeroException, StackException;
	
	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @return boolean 
	 * @throws StackException 
	 */
	public void execute(CPU cpu) throws DivByZeroException, StackException {
		int contador = cpu.getOperandStackCont();
		if (contador >= 2) {
			int valor1 = cpu.pop();
			int valor2 = cpu.pop();
			this.executeArithmetics(cpu, valor1, valor2);
		}
		else throw new StackException("Se necesitan 2 elementos en la pila");
	}
}
