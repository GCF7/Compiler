package instruction;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import practica3.LexicalParser;

public class InstructionParser {

	private final static Instruction[] instructions = {
		 new SimpleAssignment(), new CompoundAssignment(),
		 new Write(), new Return(), new While(), new IfThen()};
	
	/**
	 * Metodo que dado un String, genera su Instruction correspondiente 
	 * @param line String que indica el Command
	 * @return Command correspondiente al String
	 * @throws LexicalAnalysisException 
	 * @throws ArrayException 
	 */
	public static Instruction parse(String line, LexicalParser parser) throws LexicalAnalysisException, ArrayException {
		int i = 0;
		Instruction c;
		line = line.trim();
		String []words = line.split(" +");
		if (words.length == 0) return null;
		else {
			do {
				c = instructions[i];
				c = c.lexParse(words, parser);
				i++;
			} while (i < instructions.length && c == null);
		return c;
		}
	}
}
