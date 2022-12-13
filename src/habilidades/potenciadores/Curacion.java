package habilidades.potenciadores;

import habilidades.Habilidad;
import habilidades.TipoObjetivo;
import personajes.Personaje;

public class Curacion extends Habilidad
{
    /*
    Habilidad que cura una parte de la vida del jugador
    Cuando se mejora incrementa la cantidad de curacion en 20
     */

	static final Integer manaNecesitado = 4;

	private Integer curacion;

	public Curacion (Personaje personaje, Integer curacion)
	{
		this.setPersonaje(personaje);
		this.setObjetivo(TipoObjetivo.JUGADOR);
		this.curacion = curacion;
	}

	@Override
	public String invocar ( )
	{
		if (this.getPersonaje( ).getMana( ) >= Curacion.manaNecesitado)
		{
			// Invocacion
			this.getPersonaje( ).setSalud(this.getPersonaje( ).getSalud( ) + this.curacion);
			this.getPersonaje( ).setMana(this.getPersonaje( ).getMana( ) - Curacion.manaNecesitado);

			// Depuracion
			System.out.println("\u001B[34m[HABILIDAD] Ha curado " + this.curacion + " a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")\u001B[37m");

			return "\u001B[34m[HABILIDAD] Ha curado " + this.curacion + " a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")\u001B[37m";
		}

		System.out.println("NO has tenido mana para invocar la habilidad, se mejorara automaticamente...");
		this.mejorar( );

		return "NO has tenido mana para invocar la habilidad, se mejorara automaticamente...";

	}

	@Override
	public String mejorar ( )
	{
		// Mejora
		this.curacion += 20;

		// Depuracion
		System.out.println("\u001B[34m[MEJORA] Ha mejorado en 20 curacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.curacion + ")\u001B[37m");

		return "\u001B[34m[MEJORA] Ha mejorado en 20 curacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.curacion + ")\u001B[37m";
	}
}
