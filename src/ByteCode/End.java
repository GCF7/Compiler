package byteCode;
import practica3.CPU;

/**
 * Clase de ByteCode End
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class End extends ByteCodeWithoutParameter{
	
	/**
	 * Constructora para ByteCode End
	 */
	public End(){
	}
	
	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	public String toString() {
		return "END";
	}

	/**
	 * Metodo ejecuta el ByteCode
	 * @param CPU cpu
	 */
	public void execute(CPU cpu) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	public ByteCodeWithoutParameter parseAux(String s) {
		if(s.equalsIgnoreCase("END")){
			return new End();
		}
		else return null;
	}

}
