package command;
import excepciones.ArrayException;
import excepciones.ExecutionErrorException;
import practica3.Engine;

/**
 * Clase de comando RUN
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class Run implements Command {
	
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 */
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException{
		engine.executeCommandRun();
	}
	
	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	public Command parse(String[] s){
		if(s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;
	}
	
	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	public String textHelp(){
		return "RUN: Ejecuta el programa" +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "RUN";
	}

}
