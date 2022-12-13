package herramientas.tanques;

import herramientas.Herramienta;
import herramientas.TiposHerramientas;
import personajes.Personaje;

public class Escudo extends Herramienta
{
    /*
    Herramienta de tipo defensa con muy poco danio pero pasivas muy potentes
    La pasiva quita durabilidad de la herramienta del enemigo y restaura vida del jugador
     */

	public Escudo (Integer danio)
	{
		super("Escudo de coran", danio, 200, TiposHerramientas.DEFENSA);
	}

	@Override
	public String pasiva (Personaje personaje, Personaje jugador)
	{
		// Pasiva
		personaje.getHerramienta( ).setDurabilidad(personaje.getHerramienta( ).getDurabilidad( ) - 5);
		jugador.setSalud(jugador.getSalud( ) + 10);

		// Depuracion
		System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha reducido en 5 la durabilidad de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDurabilidad( ) + ")\u001B[37m");
		System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en 10 su salud (" + jugador.getSalud( ) + ")\u001B[37m");

		return "\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha reducido en 5 la durabilidad de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDurabilidad( ) + ")\u001B[37m\n" + "\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado en" + " 10 su salud (" + jugador.getSalud( ) + ")\u001B[37m";
	}
}
