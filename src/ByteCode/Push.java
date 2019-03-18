package byteCode;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Push
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Push extends ByteCodeOneParameter {
	
	/**
	 * Constructora para ByteCode Push
	 * @param param parametro que define el valor que necesita Push
	 */
	public Push(int param){
		super(param);
	}
	/**
	 * Constructora para ByteCode Push
	 */
	public Push(){
	}
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toStringAux() {
		return "PUSH";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @throws StackException 
	 */
	public void execute(CPU cpu) throws StackException {
		cpu.push(this.param);
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	public ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("PUSH")){
			int num = Integer.parseInt(s2);
			return new Push(num);
		}
		else return null;
	}
}
