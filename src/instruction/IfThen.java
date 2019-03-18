package instruction;

import practica3.LexicalParser;
import practica3.ParsedProgram;
import condition.Condition;
import condition.ConditionParser;
import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import practica3.Compiler;

public class IfThen implements Instruction {
	
	/**
	 * Campos de la clase
	 */
	private Condition condition;
	private ParsedProgram body;
	
	/**
	 * Constructora
	 */
	public IfThen(){
	}
	
	/**
	 * Constructora con parametro
	 * @param cond
	 * @param program
	 */
	public IfThen(Condition cond, ParsedProgram program){
		this.condition = cond;
		this.body = program;
	}

	/**
	 * Metodo que parsea la Instruction
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
		// TODO Auto-generated method stub
		if (words.length == 4 && words[0].equalsIgnoreCase("IF")) {
			Condition cond = ConditionParser.parse(words[1],words[2], words[3], lexParser);
			//El parseo de la condición devuelve cond
			if (cond != null) {
				ParsedProgram wb = new ParsedProgram();
				try{
					lexParser.increaseProgramCounter();
					lexParser.lexicalParser(wb,"ENDIF");
					return new IfThen(cond, wb);
				}
				catch(LexicalAnalysisException e){
					return null;
				}
			}
			else return null; // o throw new LexicalAnalysisException("LexicalAnalysisException: Condicion incorrecta");
		}
		else return null;
	}

	/**
	 * Metodo que compila la Instruction
	 */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		this.condition.compile(compiler);
		int indice = compiler.getBcProgramCont() - 1;
		compiler.compile(this.body);
		int salto = compiler.getBcProgramCont();
		this.condition.changeJump(indice, salto, compiler);
	}
}
