package byteCode;

/**
 * Clase de ByteCode son parametros
 * @author Guillermo Delgado y Guillermo Cortina
 */
public abstract class ByteCodeOneParameter implements ByteCode {
	/**
	 * Campos de la clase
	 */
	protected int param;
	/**
	 * Constructora para ByteCode con parametro
	 * @param param parametro que define el valor que necesita el ByteCodeOneParameter
	 */
	public ByteCodeOneParameter(int param){
		this.param = param;
	}
	/**
	 * Constructora para ByteCode sin parametros
	 */
	public ByteCodeOneParameter(){	
	}
	/**
	 * Metodo que parsea el String
	 * @param String[] a parsear
	 * @return ByteCode o null si no existe o no es correcto
	 */
	public ByteCode parse(String[ ] s) {
		if (s.length == 2) return this.parseAux(s[0], s[1]);
		else return null;
	}
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s1
	 * @param String s2
	 * @return ByteCode
	 */
	abstract protected ByteCodeOneParameter parseAux (String s1, String s2);
	
	public String toString(){
		 return this.toStringAux() + " " + this.param;
	}
	/**
	 * Metodo auxiliar que devuelve el parametro del ByteCode y comprueba cual es 
	 * su ByteCode
	 * @return parametro del ByteCode
	 */
	abstract protected String toStringAux();
}
