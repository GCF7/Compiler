package command;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import practica3.Engine;

public class Compile implements Command {

	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 */
	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		// TODO Auto-generated method stub
		engine.compile();
	}

	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else return null;
	}

	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	@Override
	public String textHelp() {
		return "COMPILE: genera un programa bytecode a partir de un archivo de texto." +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "COMPILE";
	}

}
