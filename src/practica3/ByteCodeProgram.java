package practica3;

import excepciones.ArrayException;
import byteCode.ByteCode;

/**
 * Clase que contiene las instucciones ByteCode que se quieren ejecutar
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class ByteCodeProgram {
	/**
	 * Campos de la clase
	 */
	private ByteCode[] program;
	private static final int MAX = 100;
	private int contador;
	/**
	 * Constructora de la clase
	 */
	public ByteCodeProgram (){
		this.program = new ByteCode [MAX];
		this.contador = 0;
	}
	
	/**
	 * Metodo que introduce una nueva instruccion en el programa
	 * @param instr instruccion que se quiere introducir
	 * @return boolean que indica si la instriccion se ha añadido o no
	 */
	public void newInstruction (ByteCode instr) throws ArrayException {
		if (this.contador < MAX) {
			this.program[this.contador] = instr;
			this.contador++;
		}
		else throw new ArrayException("El ByteCode Program esta lleno");
	}
	
	/**
	 * Metodo que reemplaza una instruccion por otra
	 * @param instr instruccion nueva
	 * @param pos posicion de la instruccion a reemplazar
	 * @throws ArrayException 
	 */
	public void replace (ByteCode instr, int pos) throws ArrayException {
		if(pos < 0 || pos >= this.contador) throw new ArrayException("Se ha intentado acceder a una posicion no valida de bcProgram");
		this.program[pos] = instr;
	}
	
	/**
	 * Metodo que reinicia el programa a su estado original
	 */
	public void reset () {
		this.contador = 0;
	}
	
	/**
	 * Metodo que devuelve el ByteCode de una posicion
	 * @param pos Posicion del ByteCode
	 * @return ByteCode de esa posicion
	 */
	public ByteCode getByteCode (int pos) {
		return this.program[pos];
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
			s += i + ": " + this.program[i] +  System.getProperty("line.separator");
		}
		return s;
	}
}
