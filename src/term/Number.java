package term;

import byteCode.ByteCode;
import byteCode.Push;
import practica3.Compiler;

public class Number implements Term {
	
	/**
	 * Campos de la clase
	 */
	private int number;
	/**
	 * Constructora de la clase
	 */
	public Number(){
	}
	/**
	 * Constructora de la clase con parámetro
	 * @param term
	 */
	public Number(int term) {
		this.number = term;
	}
	/**
	 * Metodo que parsea Term
	 */
	@Override
	public Term parse(String term) {
		try{	
			int numero = Integer.parseInt(term);
			return new Number(numero);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Metodo que compila Term
	 */
	@Override
	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return new Push(this.number);
	}
	
	/**
	 * Metodo que devuelve number
	 * @return
	 */
	public int getNumber(){
		return this.number;
	}

}
