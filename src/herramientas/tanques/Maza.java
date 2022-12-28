package herramientas.tanques;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;
import java.util.Random;

public class Maza extends Herramienta
{
    /*
    Herramienta de tipo defensa disenada para prolongar las batallas
    La pasiva mejora automaticamente una habilidad aleatoriamente
     */

	public Maza ( )
	{
		super("Maza de forja", 45, 100, TiposHerramientas.DEFENSA);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador) throws IOException
	{
		if (new Random( ).nextInt(100) <= 50)
		{
			// Pasiva
			jugador.getHabilidad1( ).mejorar( );

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 1\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 1";
		}

		else
		{
			// Pasiva
			jugador.getHabilidad2( ).mejorar( );

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 2\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 2";
		}
	}
}
