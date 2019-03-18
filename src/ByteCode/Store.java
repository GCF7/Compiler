package byteCode;
import excepciones.ArrayException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Store
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Store extends ByteCodeOneParameter {
	
	/**
	 * Constructora para ByteCode Store
	 * @param param parametro que define el valor que necesita Store
	 */
	public Store (int param) {
		super(param);
	}
	/**
	 * Constructora para ByteCode Store
	 */
	public Store() {
	}
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toStringAux() {
		return "STORE";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @return boolean 
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	public void execute(CPU cpu) throws StackException, ArrayException {
		cpu.store(this.param);
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	public ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("STORE")){
			int num = Integer.parseInt(s2);
			return new Store(num);
		}
		else return null;
	}
}
