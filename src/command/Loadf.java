package command;

import java.io.FileNotFoundException;

import excepciones.ArrayException;
import practica3.Engine;

public class Loadf implements Command{

	private String fich;
	public Loadf() {
	}
	
	public Loadf(String archivo) {
		this.fich = archivo;
	}

	/**
	 * Metodo que ejecuta el comando
	 * @param engine define la maquina
	 */
	@Override
	public void execute(Engine engine) throws FileNotFoundException, ArrayException {
		// TODO Auto-generated method stub
		engine.loadf(this.fich);
	}

	/**
	 * Metodo que parsea el comando
	 * @param String[] a parsear
	 * @return Command si existe o null en caso contrario
	 */
	@Override
	public Command parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("LOAD")){
			return new Loadf(s[1]);
		}	
		else return null;
	}

	/**
	 * Metodo que muestra el texto/ayuda del comando
	 * @return String 
	 */
	@Override
	public String textHelp() {
		return "LOAD FICH: carga el fichero de nombre FICH como programa fuente" +
	              System.getProperty("line.separator");
	}
	
	/**
	 * Metodo que muestra el nombre del comando
	 * @return String 
	 */
	public String toString(){
		return "LOAD" + " " + this.fich;
	}

}
