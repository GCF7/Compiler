package command;


/**
 * Clase que transforma un String en su Command
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class CommandParser {
	/**
	 * Campos de la clase
	 */
	private final static Command[] commands = { new Help(), new Quit(), new Reset(), 
			new ReplaceBC(), new Run(), new Loadf(), new Compile() };

	/**
	 * Metodo que. dado un String, genera su Command correspondiente 
	 * @param line String que indica el Command
	 * @return Command correspondiente al String
	 */
	public static Command parse(String line) {
		int i = 0;
		 Command c;
		 line = line.trim();
		 String []words = line.split(" +");
		 if (words.length == 0) return null;
		 else {
			do {
				 c = CommandParser.commands[i];
				 c = c.parse(words);
				 i++;
			 } while (i < CommandParser.commands.length && c == null);
			 return c;
		}
	}
	/**
	 * Metodo que muestra la ayuda
	 */
	 public static void showHelp() {
		 for (int i=0; i < CommandParser.commands.length; i++)
		 System.out.print(CommandParser.commands[i].textHelp());
		 System.out.println();
		 }
}
