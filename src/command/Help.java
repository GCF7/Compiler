package command;
import practica3.Engine;

/**
 * Clase de comando HELP
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class Help implements Command {
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 */
	public void execute(Engine engine){
		Engine.showHelp();
	}
	
	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	public Command parse(String[] s){
		if(s.length == 1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else return null;
	}
	
	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	public String textHelp(){
		return "HELP: Muestra esta ayuda" +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "HELP";
	}

}
