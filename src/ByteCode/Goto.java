package byteCode;
import excepciones.ArrayException;
import practica3.CPU;

/**
 * Clase de ByteCode Goto
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Goto extends ByteCodeOneParameter{
	
	/**
	 * Constructora para ByteCode Goto
	 */
	public Goto(){
	}
	/**
	 * Constructora para ByteCode Goto
	 * @param param parametro que define el valor que necesita Goto
	 */
	public Goto (int param){
		super(param);
	}
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	protected ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("GOTO")){
			int num = Integer.parseInt(s2);
			return new Goto(num);
		}
		else return null;
	}

	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "GOTO";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 * @return boolean 
	 * @throws ArrayException 
	 */
	public void execute(CPU cpu) throws ArrayException {
		cpu.setProgramCounter(this.param);
	}

}
