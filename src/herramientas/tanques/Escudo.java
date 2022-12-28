package herramientas.tanques;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public class Escudo extends Herramienta
{
    /*
    Herramienta de tipo defensa con muy poco danio pero pasivas muy potentes
    La pasiva quita durabilidad de la herramienta del enemigo y restaura vida del jugador
     */

	public Escudo ( )
	{
		super("Escudo de coran", 12, 200, TiposHerramientas.DEFENSA);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador) throws IOException
	{
		// Pasiva
		personaje.getHerramienta( ).setDurabilidad(personaje.getHerramienta( ).getDurabilidad( ) - 5);
		jugador.setSalud(jugador.getSalud( ) + 10);

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha reducido en 5 la durabilidad de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDurabilidad( ) + ")\u001B[37m");
		Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en 10 su salud (" + jugador.getSalud( ) + ")\u001B[37m");

		return "[PASIVA " + this.getNombre( ) + "] Ha reducido en 5 la durabilidad de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( )
		                                                                                                                                             .getDurabilidad( ) + ")\n[PASIVA " + this.getNombre( ) + "] Ha aumentado en" + " 10 su salud (" + jugador.getSalud( ) + ")";
	}
}
