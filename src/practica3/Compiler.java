package practica3;

import instruction.Instruction;
import excepciones.ArrayException;
import byteCode.ByteCode;

public class Compiler {

	/**
	 * Campos de la clase
	 */
	 private ByteCodeProgram bcProgram;
	 private String[] varTable;
	 private int numVars;
	 private int MAX = 20;
	 
	 /**
	  * Constructora
	  * @param bcProgram
	  */
	 public Compiler(ByteCodeProgram bcProgram){
		 this.numVars = 0;
		 this.varTable = new String[MAX];
		 this.bcProgram = bcProgram;
	 }
	 
	 /**
	  * Metodo que compila el ParsedProgram para generar el BytecodeProgram
	  * @param pProgram
	  * @throws ArrayException
	  */
	 public void compile(ParsedProgram pProgram) throws ArrayException {
			// TODO Auto-generated method stub
		int i = 0;
		try {
			while (i < pProgram.getContador()){
				Instruction instr = pProgram.getInstruction(i);
				instr.compile(this);
				i++;
			}
		}
		catch (ArrayException e) {
			throw new ArrayException("ArrayException en la instruccion numero " + i + ": " + e.getMessage());
		}
	}
	 
	 /**
	  * Metodo que devuelve el indice de la posicion en la que se encuentra varName
	  * @param varName
	  * @return index
	  */
	 public int getIndex(String varName) {
		 int i = 0, index = this.numVars;
		 boolean encontrado = false;
		 while(i < this.numVars && !encontrado){
			 if(varTable[i].equals(varName)){
				 index = i;
				 encontrado = true;
			 }
			 i++;
		 }
		 return index;
	 }

	 /**
	  * Metodo que añade un ByteCode al ByteCodeProgram
	  * @param bc
	  * @throws ArrayException
	  */
	public void addByteCode(ByteCode bc) throws ArrayException {
		// TODO Auto-generated method stub
			this.bcProgram.newInstruction(bc);
	}
	
	/**
	 * Metodo que añade una variable a varTable
	 * @param varName
	 * @throws ArrayException
	 */
	public void addVarTable(String varName) throws ArrayException {
		// TODO Auto-generated method stub
		if (this.numVars >= this.MAX) throw new ArrayException("El vector de Variables esta lleno");
		else{
			this.varTable[this.numVars] = varName;
			this.increaseVarCounter();
		}
		
	}
	
	/**
	 * Metodo que cambia un Bytecode por otro
	 * @param index
	 * @param byteCode
	 * @throws ArrayException
	 */
	public void changeByteCode(int index, ByteCode byteCode) throws ArrayException {
		// TODO Auto-generated method stub
		this.bcProgram.replace(byteCode, index);	
	}
	
	/**
	 * Metodo que incrementa el contador de variables
	*/
	public void increaseVarCounter() {
		this.numVars++;
	}
	
	/**
	 * Metodo que devuelve el numero de variables
	 * @return numVras
	 */
	public int getNumVars(){
		return this.numVars;
	}
	
	/**
	 * Metodo que devuelve el contador de ByteCodeProgram
	 * @return cont
	 */
	public int getBcProgramCont(){
		return this.bcProgram.getContador();
	}

}
