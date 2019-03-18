package byteCode;

import excepciones.BadFormatByteCodeException;

/**
 * Clase que transforma un String en su ByteCode
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class ByteCodeParser {
    /**
     * Constructora de la clase
     */
	public ByteCodeParser(){
	}
	
	/**
	 * Campos de la clase
	 */
	private final static ByteCode[] bytecode = { new Load(), new Push(), new Store(), 
		new Add(), new Sub(), new Mul(), new Div(), new Out(), new Halt(), new End(),
		new Ifeq(), new Ifneq(), new Ifle(), new Ifleq(), new Goto()};

	/**
	 * Metodo que. dado un String, genera su ByteCode correspondiente 
	 * @param S String que indica el ByteCode
	 * @return ByteCode correspondiente al String
	 * @throws BadFormatByteCodeException 
	 */
	public static ByteCode parse(String line) throws BadFormatByteCodeException {
		int i = 0;
		ByteCode c;
		line = line.trim();
		String []words = line.split(" +");
		if (words.length == 0) return null;
		else{
			do {
				c = bytecode[i];
				c = c.parse(words);
				i++;
			} while (i < bytecode.length && c == null);
		}
		if(c == null) throw new BadFormatByteCodeException();
		return c;
	}
}
