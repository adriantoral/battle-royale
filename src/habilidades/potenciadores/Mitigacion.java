package habilidades.potenciadores;

import habilidades.Habilidad;
import habilidades.TipoObjetivo;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public class Mitigacion extends Habilidad
{
    /*
    Habilidad que otorga mas armadura al jugador
    Cuando se mejora incrementa la cantidad de armadura en 12
     */

	static final Integer manaNecesitado = 5;

	private Integer mitigacion;

	public Mitigacion (Personaje personaje, Integer mitigacion)
	{
		this.setPersonaje(personaje);
		this.setObjetivo(TipoObjetivo.JUGADOR);
		this.mitigacion = mitigacion;
	}

	@Override
	public String invocar ( ) throws IOException
	{
		if (this.getPersonaje( ).getMana( ) >= Mitigacion.manaNecesitado)
		{
			// Invocacion
			this.getPersonaje( ).setArmadura(this.getPersonaje( ).getArmadura( ) + this.mitigacion);
			this.getPersonaje( ).setMana(this.getPersonaje( ).getMana( ) - Mitigacion.manaNecesitado);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[34m[HABILIDAD] Ha aumentado en " + this.mitigacion + " la armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getArmadura( ) + ")\u001B[37m");

			return "[HABILIDAD] Ha aumentado en " + this.mitigacion + " la armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getArmadura( ) + ")";
		}

		Depuracion.mostrarGuardar("NO has tenido mana para invocar la habilidad, se mejorara automaticamente...");
		this.mejorar( );

		return "NO has tenido mana para invocar la habilidad, se mejorara automaticamente...";
	}

	@Override
	public String mejorar ( ) throws IOException
	{
		// Mejora
		this.mitigacion += 10;

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[34m[MEJORA] Ha mejorado en 10 la mitigacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.mitigacion + ")\u001B[37m");

		return "[MEJORA] Ha mejorado en 10 la mitigacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.mitigacion + ")";
	}
}
