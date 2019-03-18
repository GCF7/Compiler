package command;
import practica3.Engine;

/**
 * Clase de comando QUIT
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class Quit implements Command {
	
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 */
	public void execute(Engine engine){
		engine.endExecution();
	}
	
	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	public Command parse(String[] s){
		if(s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;
	}
	
	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String que muestra el texto/ayuda del comando
	 */
	public String textHelp(){
		return "QUIT: Cierra la aplicacion" +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String que muestra el comando
	 */
	public String toString(){
		return "QUIT";
	}

}
