package instruction;

import byteCode.Load;
import byteCode.Out;
import excepciones.ArrayException;
import practica3.Compiler;
import practica3.LexicalParser;

public class Write implements Instruction{

	/**
	 * Campos de la clase
	 */
	private String varName;
	/**
	 * Constructora
	 */
	public Write(){
	}
	/**
	 * Constructora con parametro
	 * @param varName
	 */
	public Write(String varName) {
		this.varName = varName;
	}
	/**
	 * Metodo que parsea la Instruction
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		if(words.length == 2 && words[0].equalsIgnoreCase("WRITE")){
			char name = words[1].charAt(0);
			if ('a' <= name && name <='z') return new Write(words[1]);
			else return null;
		}
		else return null;
	}

	/**
	 * Metodo que compila la Instruction
	 */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		int index = compiler.getIndex(this.varName);
		if (index == compiler.getNumVars()) throw new ArrayException("No existe un indice para esa variable");
		else{
			compiler.addByteCode(new Load(index));
			compiler.addByteCode(new Out());
		}	
	}

}
