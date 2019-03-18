package term;

import excepciones.ArrayException;
import byteCode.ByteCode;
import practica3.Compiler;

public interface Term {

	 Term parse(String term);
	 ByteCode compile(Compiler compiler) throws ArrayException;
}
