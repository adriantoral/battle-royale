package herramientas.magos;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;
import personajes.TiposPersonajes;
import utilidades.Depuracion;

import java.io.IOException;

public class Arco extends Herramienta
{
    /*
    Herramienta de tipo distancia disenada para hacer danio dependiendo de la vida del enemigo (baja tanques)
    La pasiva quita vida segun el danio maximo de la herramienta
     */

	public Arco ( )
	{
		super("Arco vitalicio", 80, 15, TiposHerramientas.DISTANCIA);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador) throws IOException
	{
		if (personaje.getTipo( ).equals(TiposPersonajes.TANQUE))
		{
			// Pasiva
			Integer danio = new Double(this.getDanio( ) * 0.2).intValue( );
			personaje.setSalud(personaje.getSalud( ) - danio);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha hecho " + danio + " de danio a " + personaje.getNombre( ) + " (" + personaje.getSalud( ) + ")\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha hecho " + danio + " de danio a " + personaje.getNombre( ) + " (" + personaje.getSalud( ) + ")";
		}

		return "[PASIVA " + this.getNombre( ) + "] NO APLICADA";
	}
}
