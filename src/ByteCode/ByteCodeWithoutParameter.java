package byteCode;

/**
 * Clase de ByteCode sin parametros
 * @author Guillermo Delgado y Guillermo Cortina
 */
public abstract class ByteCodeWithoutParameter implements ByteCode {
	
	/**
	 * Constructora para ByteCode sin parametros
	 */
	public ByteCodeWithoutParameter(){
	}
	
	/**
	 * Metodo que parsea el String
	 * @param String[] a parsear
	 * @return ByteCode o null si no existe o no es correcto
	 */
	public ByteCode parse(String[ ] s) {
		if (s.length == 1) return this.parseAux(s[0]);
		else return null;
	}
	
	/**
	 * Metodo que comprueba que ByteCode es
	 * @param String s
	 * @return ByteCode
	 */
	abstract protected ByteCodeWithoutParameter parseAux (String s);
}
