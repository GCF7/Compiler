package practica3;

import excepciones.ArrayException;
import excepciones.ExecutionErrorException;
import excepciones.StackException;

/**
 * Clase que ejecuta los ByteCodes
 * @author Guillermo Delgado y Guillermo Cortina
 */
public class CPU {
	/**
	 * Campos de la clase
	 */
	private Memory memory;
	private OperandStack operandStack;
	boolean halt;
	private ByteCodeProgram program;
	private int programCounter;
	
	 /**
	  * Constructora para la CPU
     */
	public CPU(ByteCodeProgram program) {
	 this.memory = new Memory();
	 this.operandStack = new OperandStack();
	 this.halt = false;
	 this.program = program;
	 this.programCounter = 0;
	}
	/**
	 * Arithmetics
	 * @throws StackException 
	 */
	public int pop() throws StackException {
		return this.operandStack.read();
	}
	public int getOperandStackCont() {
		return this.operandStack.getCont();
	}
	/**
	 * ByteCodes
	 */
	/**
	 * Metodo que introduce en la pila un elemento de la memoria
	 * @param param posicion de la memoria
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	public void load(int param) throws StackException, ArrayException {
		int valor;
		if(param >= 0) {
			valor = this.memory.read(param);
			this.operandStack.write(valor);
		}
		this.increaseProgramCounter();
	}
	
	/**
	 * Metodo que introduce un elemento en la pila
	 * @param param elemento que se quiere introducir
	 * @throws StackException 
	 */
	public void push(int param) throws StackException {
		this.increaseProgramCounter();
		this.operandStack.write(param);
	}
	/**
	 * Metodo que guarda la cima de la pila en la memoria
	 * @param param posicion donde se quiere guardar
	 * @return boolean que indica si la instriccion se ha añadido o no
	 * @throws StackException 
	 * @throws ArrayException 
	 */
	public boolean store(int param) throws StackException, ArrayException {
		boolean correcto = false;
		int valor;
		valor = this.operandStack.read();
		this.memory.write(param, valor);
		this.increaseProgramCounter();
		return correcto;
	}
	/**
	 * Metodo que para la maquina
	 * @return true
	 */
	public void halt() {
		this.halt = true;
		this.increaseProgramCounter();
	}
	
	/**
	 * Metodo que muestra el valor de la cima de la pila
	 * @return boolean que indica si se ha podido mostrar o no
	 * @throws StackException 
	 */
	public void out () throws StackException {
		int valor = this.operandStack.read();
		System.out.println("El valor de la cima de la pila es: " + valor + System.getProperty("line.separator"));
		this.increaseProgramCounter();
	}
	/**
	 * Metodo que ejecuta el programa
	 * @throws ArrayException 
	 * @throws ExecutionErrorException 
	 */
	public void run() throws ExecutionErrorException, ArrayException{
		int instruccionAnterior;
		if(this.program.getContador() > 0){
			while (this.programCounter < this.program.getContador() && !this.halt) {
				instruccionAnterior = this.programCounter;
				try {
					this.program.getByteCode(this.programCounter).execute(this);
				}
				catch(ExecutionErrorException e){
					throw new ExecutionErrorException("ExecutionErrorException en la instruccion " + instruccionAnterior + ": " + e.getMessage());
				}
				catch(ArrayException e){
					throw new ArrayException("ArrayException en la instruccion " + instruccionAnterior + ": " + e.getMessage());
				}
			}
			System.out.println("El estado de la maquina tras ejecutar el programa es:" );
			System.out.println(this);
			this.changeHalt();
			this.reset();
		}
		else throw new ArrayException("bcProgram esta vacio");
	}
	/**
	 * Metodo que devuelve un string
	 * @return String con el estado de la CPU (Pila y Memoria)
    */
	public String toString() {
		String s = System.getProperty("line.separator") + "Estado de la CPU:" +  System.getProperty("line.separator") +
		" Memoria: " + this.memory +  System.getProperty("line.separator") +
		" Pila: " + this.operandStack +  System.getProperty("line.separator");
		return s;
	}
	
	/**
	 * Metodo que reinicia la CPU(Pila y Mmeoria) ha sus valores originales
    */
	public void reset() {
		this.memory.reset();
		this.operandStack.reset();
		this.programCounter = 0;
	}
	
	/**
	 * Metodo que devuelve si se ha ejecutado la instruccion halt
	 * @return boolean que indica si la ejecucion halt se ha ejecutado
    */
	public boolean getHalt() {
		return this.halt;
	}
	/**
	 * Metodo que reinicia halt a falso
	*/
	public void changeHalt() {
		this.halt = false;
	}
	/**
	 * Metodo que incrementa el contador de programa
	*/
	public void increaseProgramCounter() {
		this.programCounter++;
	}
	/**
	 * Metodo que modifica el contador de programa
	 * @param jump linea de salto
	 * @return boolean que indica si se ha podido ir a esa instruccion
	 * @throws ArrayException 
	 */
	public void setProgramCounter(int jump) throws ArrayException {
		if(jump >= 0 && jump < this.program.getContador()){
			this.programCounter = jump;
		}
		else throw new ArrayException("No se puede efectuar el salto a una posicion inexistente");
	}
}
