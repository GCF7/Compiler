package command;
import practica3.Engine;

/**
 * Clase de comando RESET
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class Reset implements Command {
	
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 */
	public void execute(Engine engine){
		engine.resetProgram();
	}
	
	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	public Command parse(String[] s){
		if(s.length == 1 && s[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else return null;
	}
	
	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	public String textHelp(){
		return "RESET: Vacia el programa actual " +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "RESET";
	}
}
