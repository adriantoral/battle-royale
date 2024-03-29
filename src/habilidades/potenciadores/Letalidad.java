package habilidades.potenciadores;

import habilidades.Habilidad;
import habilidades.TipoObjetivo;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public class Letalidad extends Habilidad
{
    /*
    Habilidad que otorga penetracion de armadura al jugador
    Cuando se mejora incrementa la cantidad de penetracion de armadura en 12
     */

	static final Integer manaNecesitado = 3;

	private Integer letalidad;

	public Letalidad (Personaje personaje, Integer letalidad)
	{
		this.setPersonaje(personaje);
		this.setObjetivo(TipoObjetivo.JUGADOR);
		this.letalidad = letalidad;
	}

	@Override
	public String invocar ( ) throws IOException
	{
		if (this.getPersonaje( ).getMana( ) >= Letalidad.manaNecesitado)
		{
			// Invocacion
			this.getPersonaje( ).setPenetracionArmadura(this.getPersonaje( ).getPenetracionArmadura( ) + this.letalidad);
			this.getPersonaje( ).setMana(this.getPersonaje( ).getMana( ) - Letalidad.manaNecesitado);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[34m[HABILIDAD] Ha aumentado en " + this.letalidad + " la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getPenetracionArmadura( ) + ")\u001B[37m");

			return "[HABILIDAD] Ha aumentado en " + this.letalidad + " la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getPenetracionArmadura( ) + ")";
		}

		Depuracion.mostrarGuardar("NO has tenido mana para invocar la habilidad, se mejorara automaticamente...");
		this.mejorar( );

		return "NO has tenido mana para invocar la habilidad, se mejorara automaticamente...";
	}

	@Override
	public String mejorar ( ) throws IOException
	{
		// Mejora
		this.letalidad += 12;

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[34m[MEJORA] Ha mejorado en 12 la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.letalidad + ")\u001B[37m");

		return "[MEJORA] Ha mejorado en 12 la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.letalidad + ")";
	}
}
