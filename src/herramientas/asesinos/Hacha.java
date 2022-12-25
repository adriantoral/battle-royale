package herramientas.asesinos;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;

public class Hacha extends Herramienta
{
    /*
    Herramienta de tipo distancia corta disenada para quitar armadura a tanques y vida extra a magos
     */

	public Hacha ( )
	{
		super("Hacha hachosa", 180, 22, TiposHerramientas.MELEE);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador)
	{
		return "[PASIVA " + this.getNombre( ) + "] NO APLICADA";
	}
}
