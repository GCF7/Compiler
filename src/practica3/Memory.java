package practica3;

import excepciones.ArrayException;

/**
 * Clase que gestiona la memoria
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class Memory {
	/**
	 * Campos de la clase
	 */
	private Integer[] memory;
	private static final int MAX = 200;
	private boolean vacia;
	
	/**
	 * Constructora de la clase
	 */
	public Memory(){
		this.memory = new Integer[MAX];
		for(int i = 0; i < MAX; i++){
			this.memory[i] = null;
		}
		this.vacia = true;
	}
	
	/**
	 * Metodo que aumenta el tamaño de la memoria pos*2
	 * @param pos pos*2 es el valor al que se aumenta la memoria
	 */
	private void aumenta(int pos){
		Integer[] memoria = new Integer[pos*2];
		for(int i = 0; i < pos*2; i++){
			if(i < this.memory.length)
			memoria[i] = this.memory[i];
			else memoria[i] = null;
		}
		this.memory = memoria;
		
	}
	
	/**
	 * Metodo que escribe en la memoria
	 * @param pos posicion en la que se debe guardar el elemento
	 * @param value elemento a guardar
	 * @throws ArrayException 
	 */
	public void write(int pos, int value) throws ArrayException{
		if(pos >= 0){
			if (pos >= this.memory.length){
				aumenta(pos);	
				}
			this.memory[pos] = value;
			this.vacia = false;
		}
		else throw new ArrayException("Se ha intentado acceder a una posicion no valida de Memoria");
	}
	/**
	 * Metodo que extrae un dato de la memoria
	 * @param pos posicion en la que se encuentra el dato
	 * @return dato que se encuentra en esa posicion
	 * @throws ArrayException 
	 */
	public int read(int pos) throws ArrayException{
		int valor;
		if (pos > this.memory.length || this.memory[pos] == null) {
			write(pos, 0);
			valor = 0;
		}
		else{
			valor = this.memory[pos];
		}
		return valor;
	}
	
	/**
	 * Devuelve un string con el estado de la memoria
	 * @return String con los datos de la memoria
	 */
	public String toString() {
		String s = "";
		if (this.vacia) return "<vacia>";
		for (int i = 0; i < this.memory.length; i++){
			if (this.memory[i] != null) s+= "[" + i + "]: " + this.memory[i] + " ";
		}
		return s;
	}
	/**
	 * Reinicia la memoria a su estado original
	 */
	public void reset(){
		this.memory = new Integer[MAX];
		for(int i = 0; i < MAX; i++){
			this.memory[i] = null;
		}
		this.vacia = true;
	}
}

