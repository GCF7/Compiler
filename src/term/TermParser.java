package term;

public class TermParser {

	private final static Term[] term = { new Number(), new Variable()};
	
	/**
	 * Metodo que parse Term
	 * @param line
	 * @return
	 */
	public static Term parse(String line) {
		int i = 0;
		 Term c;
		 line = line.trim();
		 String []words = line.split(" +");
		 if (words.length == 0) return null;
		 else{
			 do {
				 c = term[i];
				 c = c.parse(words[0]);
				 i++;
			 } while (i < term.length && c == null);
		 }
		return c;
	}
}
