package instruction;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import practica3.LexicalParser;
import practica3.Compiler;

public interface Instruction {

	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException;
	void compile(Compiler compiler) throws ArrayException;
}
