package byteCode;

/**
 * Clase de ByteCode Ifeq
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Ifeq extends ConditionalJumps {
    
	/**
	 * Constructora para ByteCode Ifeq
	 */
	public Ifeq(){
		
	}
	/**
	 * Constructora para ByteCode Ifeq
	 * @param param parametro que define el valor que necesita Ifeq
	 */
	public Ifeq(int param){
		super(param);
	}
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	protected ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("IFEQ")){
			int num = Integer.parseInt(s2);
			return new Ifeq(num);
		}
		else return null;
	}

	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	protected String toStringAux() {
		return "IFEQ";
	}

	/**
	 * Metodo que compara dos ByteCode
	 * @param int n1
	 * @param int n2
	 * @return boolean 
	 */
	protected boolean compare(int n1, int n2) {
		if(n1 == n2) return true;
		else return false;
	}

}
