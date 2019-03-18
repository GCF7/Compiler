package practica3;

import java.util.NoSuchElementException;
import java.util.Scanner;

import byteCode.ByteCode;
import byteCode.ByteCodeParser;
import command.Command;
import command.CommandParser;

import java.io.File;
import java.io.FileNotFoundException;

import excepciones.ArrayException;
import excepciones.BadFormatByteCodeException;
import excepciones.DivByZeroException;
import excepciones.ExecutionErrorException;
import excepciones.LexicalAnalysisException;
/**
 * Clase que gestiona la maquina virtual
 * @author Guillermo Delgado y Guillermo Cortina
 *
 */
public class Engine {
	/**
	 * Campos de la clase
	 */
	private ByteCodeProgram program;
	private boolean end;
	private CPU cpu;
	private static Scanner in = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	private SourceProgram sProgram;
	private ParsedProgram parsedProgram;
	/**
	 * Constructora de la clase
	 */
	public Engine() {
		this.program = new ByteCodeProgram();
		this.end = false;
		this.sProgram = new SourceProgram();
		this.parsedProgram = new ParsedProgram();
	}
	
	/**
	 * Metodo que muestra la ayuda por pantalla 
	 */
	public static void showHelp() {
		CommandParser.showHelp();
	}
	/**
	 * Metodo que finaliza la ejecucion de la maquina
	 * @return true
	 */
	public void endExecution() {
		this.end = true;
	}
	/**
	 * Metodo que reinicia la maquina a su estado original
	 * @return true
	 */
	public void resetProgram() {
		this.program.reset();
		if (cpu != null) this.cpu.reset();
		this.sProgram.reset();
		this.parsedProgram.reset();
	}
	
	/**
	 * Metodo que reemplaza una instruccion por otra
	 * @param replace
	 * @return booleano que indica si se ha reemplazado correctamente
	 * @throws ArrayException 
	 * @throws BadFormatByteCodeException 
	 */
	public void replaceByteCode(int replace) throws ArrayException, BadFormatByteCodeException{
		String instr = "";
		System.out.print("Nueva instruccion: ");
		instr = in.next();
		ByteCode byteCode = ByteCodeParser.parse(instr);
		this.program.replace(byteCode, replace);
	}
	/**
	 * Metodo que ejecuta el comando run
	 * @return booleano que indica si la ejecucion ha sido correcta o no
	 * @throws ArrayException 
	 * @throws DivByZeroException 
	 */
	public void executeCommandRun() throws ExecutionErrorException, ArrayException {
		this.cpu = new CPU(this.program);
		this.cpu.run();
	} 
	/**
	 * Metodo que inicia la maquina virtual
	 * @throws ExecutionErrorException 
	 */
	public void start() {
		String linea = "";
		while (!this.end){
			System.out.print("Introduce un comando: ");
			linea = in.next();
			Command command = CommandParser.parse(linea);
			if(command != null) {
				try {
					command.execute(this);
				} catch (FileNotFoundException | LexicalAnalysisException
						| ArrayException | BadFormatByteCodeException | ExecutionErrorException | NoSuchElementException e) {
					System.out.println("Excepcion al ejecutar " + command + ": " + e.getMessage());
				}
				finally{
					if (this.sProgram.getContador() > 0){
						System.out.println("Programa almacenado: ");
						System.out.println(this.sProgram);
					}
					if (this.program.getContador() > 0){
						System.out.println("Programa almacenado: ");
						System.out.println(this.program);
					}
				}
			}
			else System.out.println("Error: Ejecucion incorrecta del comando");
		}
		System.out.println("Fin de la ejecucion....");
		in.close();
	}

	/**
	 * Metodo que compila al SourceProgram
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	public void compile() throws LexicalAnalysisException, ArrayException {
		// TODO Auto-generated method stub
		LexicalParser lexical = new LexicalParser(this.sProgram);
		try{
			lexical.lexicalParser(this.parsedProgram, "END");
			try{
				Compiler compiler = new Compiler(this.program);
				compiler.compile(this.parsedProgram);
			}
			catch(ArrayException e){
				throw new ArrayException("Excepcion ejecutando Compile: " + e.getMessage());
			}
		}
		catch (LexicalAnalysisException e){
			throw new LexicalAnalysisException("Excepcion ejecutando LexicalParser: " + e.getMessage());
		}
		catch(ArrayException e){
			throw new ArrayException("Excepcion ejecutando LexicalParser: " + e.getMessage());
		}
	}

	/**
	 * Metodo que lee el SourceProgram del archivo.txt
	 * @param fich
	 * @throws FileNotFoundException
	 * @throws ArrayException
	 * @throws NoSuchElementException
	 */
	public void loadf(String fich) throws FileNotFoundException, ArrayException, NoSuchElementException {
		// TODO Auto-generated method stub
		this.resetProgram();
		String s = "";
		boolean fin = false;
		try {
			Scanner sc = new Scanner(new File(fich)).useDelimiter(System.getProperty("line.separator"));
				try {
					while(!s.equalsIgnoreCase("END") && sc.hasNextLine() && !fin){
						s = sc.next();
						if(s.equals("")) fin = true;
						else this.sProgram.newInstruction(s);
					}
				}
				catch(NoSuchElementException e){
					throw new NoSuchElementException("El archivo de lectura no se ha podido leer correctamente");
				}
				finally{
					sc.close();
				}
		}
		catch(FileNotFoundException e){
			throw new FileNotFoundException("No se ha encontrado el archivo");
		}
	}
}
