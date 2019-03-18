package condition;

import practica3.LexicalParser;

public class ConditionParser {

private final static Condition[] condition = { new Less(), new LessEq(), new Equal(), new NotEqual()};
	
/**
 * Metodo que parse la condicion
 * @param words0
 * @param words1
 * @param words2
 * @param parser
 * @return
 */
	public static Condition parse(String words0,String words1, String words2, LexicalParser parser) {
		int i = 0;
		Condition c;
		do {
			c = condition[i];
			c = c.parse(words0, words1, words2, parser);
			i++;
		} while (i < condition.length && c == null);
		return c;
	}
}
