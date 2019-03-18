package byteCode;
import excepciones.ArrayException;
import excepciones.StackException;
import practica3.CPU;

/**
 * Clase de ByteCode Load
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Load extends ByteCodeOneParameter{
	
	/**
	 * Constructora para ByteCode Load
	 * @param param parametro que define el valor que necesita Load
	 */
	public Load(int param){
		super(param);
	}
	/**
	 * Constructora para ByteCode Goto
	 */
	public Load(){
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toStringAux(){
		return "LOAD";
	}
	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @return boolean 
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	public void execute(CPU cpu) throws StackException, ArrayException {
		cpu.load(this.param);
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	public ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("LOAD")){
			int num = Integer.parseInt(s2);
			return new Load(num);
		}
		else return null;
	}
}
