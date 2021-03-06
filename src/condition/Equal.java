package condition;

import excepciones.ArrayException;
import byteCode.Ifeq;
import practica3.Compiler;
import practica3.LexicalParser;
import term.Term;

public class Equal extends Condition {

	/**
	 * Constructora
	 */
	public Equal(){
	}
	/***
	 * Constructora con parametro
	 * @param term1
	 * @param term2
	 */
	public Equal(Term term1, Term term2){
		super(term1, term2);
	}

	/**
	 * Metodo que parse la operacion
	 */
	@Override
	protected Condition parseop(Term t1, String op, Term t2, LexicalParser parser) {
		if (op.equals("=")) return new Equal(t1, t2);
		else return null;
	}

	/**
	 * Metodo que compila la operacion
	 */
	@Override
	protected void compileAux(Compiler compiler) throws ArrayException {
		this.condition = new Ifeq();
	}

	/**
	 * Metodo que cambia el salto
	 */
	@Override
	protected void changeAux(int jump) throws ArrayException {
		// TODO Auto-generated method stub
		this.condition = new Ifeq(jump);
	}
}
