package practica3;

import excepciones.ArrayException;

public class SourceProgram {

	/**
	 * Campos de la clase
	 */
	private String[ ] sProgram;
	private static final int MAX = 100;
	private int contador;
	/**
	 * Constructora de la clase
	 */
	public SourceProgram (){
		this.sProgram = new String [MAX];
		this.contador = 0;
	}
	
	/**
	 * Metodo que introduce una nueva instruccion en el programa
	 * @param instr instruccion que se quiere introducir
	 * @return boolean que indica si la instriccion se ha añadido o no
	 * @throws ArrayException 
	 */
	public void newInstruction (String instr) throws ArrayException {
		if (this.contador < MAX) {
			this.sProgram[this.contador] = instr;
			this.contador++;
		}
		else throw new ArrayException("El SourceProgram esta lleno");
	}
	
	/**
	 * Metodo que reinicia el programa a su estado original
	 */
	public void reset () {
		this.contador = 0;
	}
	
	/**
	 * Metodo que devuelve el texto de una posicion
	 * @param pos Posicion del ByteCode
	 * @return texto de esa posicion
	 * @throws ArrayException 
	 */
	public String getInstruction (int pos) throws ArrayException {
		if (pos < 0 || pos >= this.contador) throw new ArrayException("Se ha intentado acceder a una posicion no valida de sProgram");
		return this.sProgram[pos];
	}
	
	/**
	 * Metodo que devuelve el contador del programa
	 * @return numero de instrucciones almacenadas
	 */
	public int getContador() {
		return this.contador;
	}
	
	/**
	 * Metodo que devuelve un String con los datos del programa
	 * @return String con las instrucciones del programa
	 */
	public String toString(){
		String s = "";
		for (int i = 0; i < this.contador; i++) {
			s += i + ": " + this.sProgram[i] +  System.getProperty("line.separator");
		}
		return s;
	}
}
