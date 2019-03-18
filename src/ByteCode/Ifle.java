package byteCode;

/**
 * Clase de ByteCode Ifle
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Ifle extends ConditionalJumps{
	
	/**
	 * Constructora para ByteCode Ifle
	 * @param param parametro que define el valor que necesita Ifle
	 */
	public Ifle (int param) {
		super(param);
	}

	/**
	 * Constructora para ByteCode Ifeq
	 */
	public Ifle () {
	}
	
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	protected ByteCodeOneParameter parseAux(String s1, String s2) {
		if(s1.equalsIgnoreCase("IFLE")){
			int num = Integer.parseInt(s2);
			return new Ifle(num);
		}
		else return null;
	}

	/**Metodo que devuelve el String del ByteCode
	 * @return String del ByteCode
	 */
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "IFLE";
	}

	/**
	 * Metodo que compara dos ByteCode
	 * @param int n1
	 * @param int n2
	 * @return boolean 
	 */
	protected boolean compare(int n1, int n2) {
		if (n2 < n1) return true;
		else return false;
	}

}
