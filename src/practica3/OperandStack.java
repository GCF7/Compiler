package practica3;

import excepciones.StackException;

/**
 * Clase que gestiona la pila
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class OperandStack {
	/**
	 * Campos de la clase
	 */
	private int[] stack;
	private static final int MAX = 20;
	private int contador;
	
	/**
	 * Constructora de la clase
	 */
	public OperandStack(){
		this.stack = new int[MAX];
		this.contador = 0;
	}
	/**
	 * Metodo que escribe en al pila el elemento dado por el parametro
	 * @param value es el elemento que hay que introducir en la pila
	 * @return boolean que indica si se ha podido introducir o no (si la pila esta llena)
	 * @throws StackException 
	 */
	public void write(int value) throws StackException{
		if (contador < MAX){
				this.stack[this.contador] = value;
				this.contador++;
		}else throw new StackException("Stack overflow exception");
	}
	
	/**
	 * Metodo que devuelve el elemento que esta en la cima de la pila (el ultimo introducido)
	 * @return elemento que esta en la cima de la pila
	 * @throws StackException 
	 */
	public int read() throws StackException{
		int valor;
		if(this.contador == 0) throw new StackException("Empty stack exception");
		valor = this.stack[this.contador -1];
		this.contador--;
		return valor;
	}
	/**
	 * Metodo que devuelve un string con el estado de la pila
	 * @return String con los datos de la pila
	 */
	public String toString() {
		String s = "";
		if (this.contador == 0) return "<vacia>";
		else {
			for (int i = 0; i < this.contador; i++){
				s += this.stack[i] + " ";
			}
		}
		return s;
	}
	/**
	 * Metodo que reinicia la pila a su estado original
	 */
	public void reset() {
		this.contador = 0;
	}
	/**
	 * Metodo que devuelve el contador de la pila
	 * @return numero de elementos que contiene la pila
	 */
	public int getCont(){
		return this.contador;
	} 
}
