package byteCode;

/**
 * Clase de ByteCode Ifneq
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Ifneq extends ConditionalJumps{
	
	/**
	 * Constructora para ByteCode Ifneq
	 */
	public Ifneq(){
	}
	/**
	 * Constructora para ByteCode Ifneq
	 * @param param parametro que define el valor que necesita Ifeq
	 */
	public Ifneq(int param){
		super(param);
	}
	/**
	 * Metodo que compara dos ByteCode
	 * @param int n1
	 * @param int n2
	 * @return boolean 
	 */
	protected boolean compare(int n1, int n2) {
		if (n2 != n1) return true;
		else return false;
	}

	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	protected ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("IFNEQ")){
			int num = Integer.parseInt(s2);
			return new Ifneq(num);
		}
		else return null;
	}

	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "IFNEQ";
	}

}
