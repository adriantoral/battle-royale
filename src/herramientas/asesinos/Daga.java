package herramientas.asesinos;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;
import personajes.TiposPersonajes;
import utilidades.Depuracion;

import java.io.IOException;

public class Daga extends Herramienta
{
    /*
    Herramienta de tipo distancia corta disenada para quitar armadura a tanques y vida extra a magos
     */

	public Daga ( )
	{
		super("Daga del asesino", 120, 20, TiposHerramientas.MELEE);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador) throws IOException
	{
		if (personaje.getTipo( ).equals(TiposPersonajes.TANQUE))
		{
			// Pasiva
			personaje.setArmadura(personaje.getArmadura( ) - 20);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha reducido en 20 la armadura de " + personaje.getNombre( ) + " (" + personaje.getArmadura( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha reducido en 20 la armadura de " + personaje.getNombre( ) + " (" + personaje.getArmadura( ) + ")";
		}

		else if (personaje.getTipo( ).equals(TiposPersonajes.MAGO))
		{
			// Pasiva
			personaje.setSalud(personaje.getSalud( ) - 10);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha quitado 10 de salud a " + personaje.getNombre( ) + " (" + personaje.getSalud( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha quitado 10 de salud a " + personaje.getNombre( ) + " (" + personaje.getSalud( ) + ")";
		}

		return "[PASIVA " + this.getNombre( ) + "] NO APLICADA";
	}
}
