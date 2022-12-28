package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros
{
	public static void limpiar (File fichero) throws IOException
	{
		limpiar(new FileWriter(fichero));
	}

	public static void limpiar (FileWriter fileWriter) throws IOException
	{
		escribir(fileWriter, "INICIO DEL PROGRAMA\n");
	}

	public static void escribir (File fichero, String cadena) throws IOException
	{
		// Abrir un nuevo file writer
		escribir(new FileWriter(fichero, true), cadena);
	}

	public static void escribir (FileWriter fileWriter, String cadena) throws IOException
	{
		// Anadir la cadena al file writer
		fileWriter.append("\n").append(cadena);

		// Cerrar el file writer
		fileWriter.close( );
	}

	public static String leerCompleto (File fichero) throws FileNotFoundException
	{
		// Devolver el contenido del fichero
		return leerCompleto(new Scanner(fichero));
	}

	public static String leerCompleto (Scanner scanner)
	{
		// Resultado
		StringBuilder resultado = new StringBuilder( );

		// Leer mientras tenga siguiente linea
		while (scanner.hasNextLine( )) resultado.append(leer(scanner));

		// Cerrar el scanner
		scanner.close( );

		// Devolver el resultado
		return resultado.toString( );
	}

	public static String leer (File fichero) throws FileNotFoundException
	{
		// Resultado
		String resultado = "";

		Scanner scanner = new Scanner(fichero);

		// Devolver la siguiente linea
		resultado = leer(scanner);

		// Cerrar el scanner
		scanner.close( );

		// Devolver el resultado
		return resultado;
	}

	public static String leer (Scanner scanner)
	{
		// Devolver la siguiente linea si existe
		return scanner.hasNextLine( ) ? scanner.nextLine( ) : "";
	}
}
