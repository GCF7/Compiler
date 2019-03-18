package instruction;

import excepciones.ArrayException;
import byteCode.Store;
import practica3.LexicalParser;
import term.Term;
import term.TermParser;
import practica3.Compiler;

public class SimpleAssignment implements Instruction {
	
	/**
	 * Campos de la clase
	 */
	private String varName;
	private Term rhs;
	
	/**
	 * Constructora
	 */
	public SimpleAssignment(){
	}
	
	/**
	 * Constructora con parametro
	 * @param nombre
	 * @param termino
	 */
	public SimpleAssignment(String nombre, Term termino){
		this.varName = nombre;
		this.rhs = termino;
	}

	/**
	 * Metodo que parsea la Instruction
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		if(words.length == 3) {
			//if (words[0].length() == 1)
			char name = words[0].charAt(0);
			if ('a' <= name && name <= 'z' && words[1].equals("=")){
				Term termino = TermParser.parse(words[2]);
				if (termino != null) return new SimpleAssignment(words[0], termino);
				else return null;
			}
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
		compiler.addByteCode(this.rhs.compile(compiler));
		int index = compiler.getIndex(this.varName);
		if(index == compiler.getNumVars()) compiler.addVarTable(this.varName); // Si la variable no existe se crea
		compiler.addByteCode(new Store(index));
	}

}
