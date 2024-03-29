package herramientas.asesinos;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;
import personajes.TiposPersonajes;
import utilidades.Depuracion;

import java.io.IOException;

public class Espada extends Herramienta
{
    /*
    Herramienta de tipo distancia corta disenada para mejorar estadisticas en general
    La pasiva en tanques otorga armadura, en magos otorga danio y en asesinos otorga penetracion de armadura extra
     */

	public Espada ( )
	{
		super("Espada de coran", 76, 40, TiposHerramientas.MELEE);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador) throws IOException
	{
		if (jugador.getTipo( ).equals(TiposPersonajes.MAGO))
		{
			// Pasiva
			jugador.getHerramienta( ).setDanio(jugador.getHerramienta( ).getDanio( ) + 3);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en 3 el danio de la herramienta (" + jugador.getHerramienta( ).getDanio( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha aumentado en 3 el danio de la herramienta (" + jugador.getHerramienta( ).getDanio( ) + ")";
		}

		else if (jugador.getTipo( ).equals(TiposPersonajes.ASESINO))
		{
			// Pasiva
			jugador.setPenetracionArmadura(jugador.getPenetracionArmadura( ) + 3);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en 3 la penetracion de armadura (" + jugador.getPenetracionArmadura( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha aumentado en 3 la penetracion de armadura (" + jugador.getPenetracionArmadura( ) + ")";
		}

		else if (jugador.getTipo( ).equals(TiposPersonajes.TANQUE))
		{
			// Pasiva
			jugador.setArmadura(jugador.getArmadura( ) + 13);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en 13 la armadura (" + jugador.getArmadura( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha aumentado en 13 la armadura (" + jugador.getArmadura( ) + ")";
		}

		return "[PASIVA " + this.getNombre( ) + "] NO APLICADA";
	}
}
