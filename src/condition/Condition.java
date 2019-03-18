package condition;

import excepciones.ArrayException;
import practica3.LexicalParser;
import term.Term;
import term.TermParser;
import byteCode.ConditionalJumps;
import practica3.Compiler;

public abstract class Condition {

	/**
	 * Campos de la clase
	 */
	private Term term1;
	private Term term2;
	protected ConditionalJumps condition; //para la compilación
	
	/**
	 * Constructora con parametro
	 * @param term1
	 * @param term2
	 */
	public Condition(Term term1, Term term2){
		this.term1 = term1;
		this.term2 = term2;
	}
	
	/**
	 * Constructora
	 */
	public Condition(){
	}
	
	/**
	 * Metodo que parsea la condicion
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return
	 */
	public Condition parse(String t1, String op, String t2, LexicalParser parser){
		this.term1 = TermParser.parse(t1);
		this.term2 = TermParser.parse(t2);
		if (term1 != null && term2 != null) return parseop(term1, op, term2, parser);
		else return null;
	}

	/**
	 * Metodo que compila la condicion
	 * @param compiler
	 * @throws ArrayException
	 */
	public void compile(Compiler compiler) throws ArrayException{
		compiler.addByteCode(this.term1.compile(compiler));
		compiler.addByteCode(this.term2.compile(compiler));
		this.compileAux(compiler);
		compiler.addByteCode(this.condition);
	}
	
	/**
	 * Metodo que cambia el salto de la condicion
	 * @param index
	 * @param jump
	 * @param compiler
	 * @throws ArrayException
	 */
	public void changeJump(int index, int jump, Compiler compiler) throws ArrayException{
		changeAux(jump);
		compiler.changeByteCode(index, this.condition);
	}
	/**
	 * Metodo que parse la operacion
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return
	 */
	protected abstract Condition parseop(Term t1, String op, Term t2, LexicalParser parser);
	
	/**
	 * Metodo que compila la operacion
	 * @param compiler
	 * @throws ArrayException
	 */
	protected abstract void compileAux(Compiler compiler) throws ArrayException;
	
	/**
	 * Metodo que cambia el salto de la operacion
	 * @param jump
	 * @throws ArrayException
	 */
	protected abstract void changeAux(int jump) throws ArrayException;
}
