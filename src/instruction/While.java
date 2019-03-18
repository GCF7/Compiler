package instruction;

import byteCode.Goto;
import condition.Condition;
import condition.ConditionParser;
import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import practica3.Compiler;
import practica3.LexicalParser;
import practica3.ParsedProgram;

public class While implements Instruction{
	
	/**
	 * Campos de la clase
	 */
	private Condition condition;
	private ParsedProgram body;
	
	/**
	 * Constructora
	 */
	public While(){
	}
	
	/**
	 * Constructora
	 * @param cond
	 * @param program
	 */
	public While(Condition cond, ParsedProgram program){
		this.condition = cond;
		this.body = program;
	}

	/**
	 * Metodo que parsea la Instruction
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
		// TODO Auto-generated method stub
		if (words.length == 4 && words[0].equalsIgnoreCase("WHILE")) {
			Condition cond = ConditionParser.parse(words[1],words[2], words[3], lexParser);
			//El parseo de la condición devuelve cond
			if (cond != null) {
				ParsedProgram wb = new ParsedProgram();
				try{
					lexParser.increaseProgramCounter();
					lexParser.lexicalParser(wb,"ENDWHILE");
					return new While(cond, wb);
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
		int saltoGoTo = compiler.getBcProgramCont();
		this.condition.compile(compiler);
		int indiceCond = compiler.getBcProgramCont() - 1;
		compiler.compile(this.body);
		compiler.addByteCode(new Goto(saltoGoTo));
		int salto = compiler.getBcProgramCont();
		this.condition.changeJump(indiceCond, salto, compiler);
	}

}
