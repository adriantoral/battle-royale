package utilidades;

import java.io.File;
import java.io.IOException;

public class Depuracion
{
	public static void mostrarGuardar (String cadena) throws IOException
	{
		// Mostrar la cadena por terminal
		mostrar(cadena);

		// Guardar la cadena en el fichero de depuracion
		guardar(cadena);
	}

	public static void mostrar (String cadena)
	{
		// Mostrar cadena por terminal
		System.out.println(cadena);
	}

	public static void guardar (String cadena) throws IOException
	{
		// Guardar la cadena en el fichero de depuracion
		Ficheros.escribir(new File("depuracion.txt"), cadena);
	}
}
