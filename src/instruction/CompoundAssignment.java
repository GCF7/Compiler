package instruction;

import byteCode.Add;
import byteCode.Div;
import byteCode.Mul;
import byteCode.Store;
import byteCode.Sub;
import excepciones.ArrayException;
import practica3.Compiler;
import practica3.LexicalParser;
import term.Term;
import term.TermParser;

public class CompoundAssignment implements Instruction {

	/**
	 * Campos de la clase
	 */
	private String varName;
	private String operator;
	private Term term1;
	private Term term2;
	
	/**
	 * Constructora
	 */
	public CompoundAssignment(){
	}
	
	/**
	 * Constructora con parametro
	 * @param variable
	 * @param operacion
	 * @param t1
	 * @param t2
	 */
	public CompoundAssignment(String variable, String operacion, Term t1, Term t2){
		this.varName = variable;
		this.operator = operacion;
		this.term1 = t1;
		this.term2 = t2;
	}
	
	/**
	 * Metodo que parse la instruccion
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		if(words.length == 5) {
			//if (words[0].length() == 1)
			char name = words[0].charAt(0);
			if ('a' <= name && name <= 'z' && words[1].equals("=")){
				Term termino1 = TermParser.parse(words[2]);
				if (termino1 != null){
					if(words[3].equals("+") || words[3].equals("-") || words[3].equals("*") || words[3].equals("/")){
						Term termino2 = TermParser.parse(words[4]);
						if (termino2 != null)return new CompoundAssignment(words[0], words[3], termino1, termino2);
						else return null; // o throw new LexicalAnalysisException("CompoundAssignment incorrecto: Termino 2 incorrecto");
					}
					else return null; // o throw new LexicalAnalysisException("CompoundAssignment incorrecto: Operador incorrecto");
				}
				else return null; // o throw new LexicalAnalysisException("CompoundAssignment incorrecto: Termino 1 incorrecto");
			}
			else return null;
		}
		else return null;
	}

	/**
	 * Metodo que compila la instruccion
	 */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		compiler.addByteCode(this.term1.compile(compiler));
		compiler.addByteCode(this.term2.compile(compiler));
		if(this.operator.equals("+")) compiler.addByteCode(new Add());
		else if(this.operator.equals("-")) compiler.addByteCode(new Sub());
		else if(this.operator.equals("/")) compiler.addByteCode(new Div());
		else if(this.operator.equals("*")) compiler.addByteCode(new Mul());
		int index = compiler.getIndex(this.varName);
		if(index == compiler.getNumVars()) compiler.addVarTable(this.varName); // Si la variable no existe se crea
		compiler.addByteCode(new Store(index));
	}

}
