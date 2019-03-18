package instruction;

import excepciones.ArrayException;
import byteCode.Halt;
import practica3.Compiler;
import practica3.LexicalParser;

public class Return implements Instruction{

	/**
	 * Metodo que parsea la Instruction
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		if(words.length == 1 && words[0].equalsIgnoreCase("RETURN")) return new Return();
		else return null;
	}

	/**
	 * Metodo que compila la Instruction
	 */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		compiler.addByteCode(new Halt());
	}

}
