package practica3;

import excepciones.ArrayException;
import instruction.Instruction;

public class ParsedProgram {
	/**
	 * Campos de la clase
	 */
	private Instruction[ ] pProgram;
	private static final int MAX = 100;
	private int contador;
	/**
	 * Constructora de la clase
	 */
	public ParsedProgram (){
		this.pProgram = new Instruction [MAX];
		this.contador = 0;
	}
	
	/**
	 * Metodo que introduce una nueva instruccion en el programa
	 * @param instr instruccion que se quiere introducir
	 * @return boolean que indica si la instriccion se ha añadido o no
	 * @throws ArrayException 
	 */
	public void newInstruction (Instruction instr) throws ArrayException {
		if (this.contador < MAX) {
			this.pProgram[this.contador] = instr;
			this.contador++;
		}
		else throw new ArrayException("ParsedProgram esta lleno");
	}
	
	/**
	 * Metodo que reinicia el programa a su estado original
	 */
	public void reset () {
		this.contador = 0;
	}
	
	/**
	 * Metodo que devuelve la Instruction de una posicion
	 * @param pos Posicion
	 * @return Instruction de esa posicion
	 * @throws ArrayException 
	 */
	public Instruction getInstruction (int pos) throws ArrayException {
		if (pos < 0 || pos >= this.contador) throw new ArrayException("Se ha intentado acceder a una posicion no valida de pProgram");
		return this.pProgram[pos];
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
			s += i + ": " + this.pProgram[i] +  System.getProperty("line.separator");
		}
		return s;
	}
}
