package term;

import excepciones.ArrayException;
import byteCode.ByteCode;
import byteCode.Load;
import practica3.Compiler;

public class Variable implements Term{

	/**
	 * Campos de la clase
	 */
	private String varName;
	/**
	 * Constructora de la clase
	 */
	public Variable(){
	}
	/**
	 * Constructora de la clase con parámetro
	 * @param term
	 */
	public Variable(String term) {
		this.varName = term;
	}

	/**
	 * Metodo que parsea Term
	 */
	@Override
	public Term parse(String term) {
		if (term.length()!=1) return null;
		else{
			char name = term.charAt(0);
			if ('a' <= name && name <='z') return new Variable(term);
			else return null;
		}
	}

	/**
	 * Metodo que compila Term
	 */
	@Override
	public ByteCode compile(Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		if (index == compiler.getNumVars()) throw new ArrayException("No existe un indice para esa variable (variable no creada)");
		else return new Load(index);
	}
	
	/**
	 * Metodo que devuelve varName
	 */
	public String toString(){
		return this.varName;
	}

}
