package command;

import java.io.FileNotFoundException;

import excepciones.ArrayException;
import excepciones.BadFormatByteCodeException;
import excepciones.ExecutionErrorException;
import excepciones.LexicalAnalysisException;
import practica3.Engine;

/**
 * Construye Commands y gestiona su ejecucion
 * @author Guillermo Delgado y Guillermo Cortina
 */
public interface Command {
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 * @return boolean que indica si la ejecucion es correcta o no
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws FileNotFoundException 
	 * @throws BadFormatByteCodeException 
	 */
	abstract public void execute(Engine engine) throws ExecutionErrorException, LexicalAnalysisException, ArrayException, FileNotFoundException, BadFormatByteCodeException;
	/**
	 * Metodo que parsea un comando
	 * @param String s define la linea a parsear
	 * @return Command devuelve un comando o null
	 */
	abstract public Command parse(String[] s);
	/**
	 * Metodo que muestra la ayuda
	 * @return String 
	 */
	abstract public String textHelp();

	 
}
