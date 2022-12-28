package habilidades.potenciadores;

import habilidades.Habilidad;
import habilidades.TipoObjetivo;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public class Intensificacion extends Habilidad
{
    /*
    Habilidad que intensifica el danio de la herramienta en uso del jugador
    Cada mejora incrementa el poder de intensificacion en 15
     */

	static final Integer manaNecesitado = 3;

	private Integer intensificacion;

	public Intensificacion (Personaje personaje, Integer intensificacion)
	{
		this.setPersonaje(personaje);
		this.setObjetivo(TipoObjetivo.JUGADOR);
		this.intensificacion = intensificacion;
	}

	@Override
	public String invocar ( ) throws IOException
	{
		if (this.getPersonaje( ).getMana( ) >= Intensificacion.manaNecesitado)
		{
			// Invocacion
			this.getPersonaje( ).getHerramienta( ).setDanio(this.getPersonaje( ).getHerramienta( ).getDanio( ) + this.intensificacion);
			this.getPersonaje( ).setMana(this.getPersonaje( ).getMana( ) - Intensificacion.manaNecesitado);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[34m[HABILIDAD] Ha aumentado en " + this.intensificacion + " el danio de la herramienta de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getHerramienta( ).getDanio( ) + ")\u001B[37m");

			return "[HABILIDAD] Ha aumentado en " + this.intensificacion + " el danio de la herramienta de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getHerramienta( ).getDanio( ) + ")";
		}

		Depuracion.mostrarGuardar("NO has tenido mana para invocar la habilidad, se mejorara automaticamente...");
		this.mejorar( );

		return "NO has tenido mana para invocar la habilidad, se mejorara automaticamente...";
	}

	@Override
	public String mejorar ( ) throws IOException
	{
		// Mejora
		this.intensificacion += 15;

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[34m[MEJORA] Ha mejorado en 15 la intensificacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.intensificacion + ")\u001B[37m");

		return "[MEJORA] Ha mejorado en 15 la intensificacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.intensificacion + ")";
	}
}
