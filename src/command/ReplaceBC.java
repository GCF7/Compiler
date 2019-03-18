package command;
import excepciones.ArrayException;
import excepciones.BadFormatByteCodeException;
import practica3.Engine;

/**
 * Clase de comando REPLACE
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class ReplaceBC implements Command {
	/**
	 * Campos de la clase
	 */
	private int replace;
	/**
	 * Constructora de la clase
	 */
	public ReplaceBC() {
	}

	/**
	 * Constructora para comandos con parametro int
	 * @param replace parametro int 
	 */
	public ReplaceBC (int replace){
		this.replace = replace;
	}
	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 * @throws BadFormatByteCodeException 
	 * @throws ArrayException 
	 */
	public void execute(Engine engine) throws ArrayException, BadFormatByteCodeException{
		engine.replaceByteCode(this.replace);
	}
	
	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	public Command parse(String[] s){
		if(s.length == 2 && s[0].equalsIgnoreCase("REPLACEBC")){
			try {
				Integer num = Integer.parseInt(s[1]);
				return new ReplaceBC(num);
			}
			catch(NumberFormatException e){
				return null;
			}
		}	
		else return null;
	}
	
	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	public String textHelp(){
		return "REPLACEBC N: Reemplaza la instruccion N por la solicitada al usuario" +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "REPLACE" + " " + this.replace;
	}

}

