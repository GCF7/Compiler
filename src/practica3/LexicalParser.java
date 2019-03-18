package practica3;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import instruction.Instruction;
import instruction.InstructionParser;

public class LexicalParser {

	/**
	 * Campos de la clase
	 */
	private SourceProgram sProgram;
	private int programCounter;
	
	/**
	 * Constructora
	 * @param program
	 */
	public LexicalParser(SourceProgram program){
		this.sProgram = program;
		this.programCounter = 0;
		
	}
	
	/**
	 * Metodo que parsea el SourceProgram para generar ParsedProgram
	 * @param pProgram
	 * @param stopKey
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) 
			throws LexicalAnalysisException, ArrayException{
		boolean stop = false;
		int instr;
		if(sProgram.getContador() == 0) throw new ArrayException("SourceProgram esta vacio");
		while (this.programCounter < sProgram.getContador() && !stop) {
			instr = this.programCounter;
			String line = sProgram.getInstruction(programCounter);
			if (line.equalsIgnoreCase(stopKey) || line.equalsIgnoreCase(stopKey + System.getProperty("line.separator")) ) stop = true;
			else {
				Instruction instruction = InstructionParser.parse(line,this);
				if (instruction == null) throw new LexicalAnalysisException("LexicalAnalysisException en la instruccion numero " + instr);
				else{//Si instruction no es null
					pProgram.newInstruction(instruction);
					//Aumentar programCounter
					this.increaseProgramCounter();
				}
			}
		}
		if(!stop) throw new LexicalAnalysisException("LexicalAnalysisException: no se ha encontrado la stopKey " + stopKey);
	}

	/**
	 * Metodo que incrementa el contador de programa
	 */
	public void increaseProgramCounter() {
		// TODO Auto-generated method stub
		this.programCounter++;
	}
}
