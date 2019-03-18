package byteCode;
import excepciones.ArrayException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode condicionales
 * @author Guillermo Delgado y Guillermo Cortina
 */
public abstract class ConditionalJumps extends ByteCodeOneParameter {

	/**
	 * Constructora para ByteCode condicionales
	 * @param param parametro que define el valor que necesita el ByteCodeOneParameter
	 */
	public ConditionalJumps (int param) {
		super(param);
	}
	
	/**
	 * Constructora para ByteCode condicionales sin parametros
	 */
	public ConditionalJumps(){
	}
	
	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	public void execute(CPU cpu) throws StackException, ArrayException{
		int contador = cpu.getOperandStackCont();
		if (contador >= 2) {
			int valor1 = cpu.pop();
			int valor2 = cpu.pop();
			if(this.compare(valor1,valor2)) cpu.increaseProgramCounter();
			else cpu.setProgramCounter(this.param);
		}
		else throw new StackException("Se necesitan 2 elementos en la pila");
	}
	
	/**
	 * Metodo que compara dos ByteCode
	 * @param int n1
	 * @param int n2
	 * @return boolean 
	 */
	abstract protected boolean compare(int n1, int n2);
}
