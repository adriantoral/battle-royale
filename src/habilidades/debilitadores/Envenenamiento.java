package habilidades.debilitadores;

import habilidades.Habilidad;
import habilidades.TipoObjetivo;
import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public class Envenenamiento extends Habilidad
{
    /*
    Habilidad que envenena a un personaje segun la vida del enemigo.
    Cada mejora incrementa el poder del veneno en 5
     */

	static final Integer manaNecesitado = 6;

	private Integer envenenamiento;

	public Envenenamiento (Personaje personaje, Integer envenenamiento)
	{
		this.setPersonaje(personaje);
		this.setObjetivo(TipoObjetivo.ENEMIGO);
		this.envenenamiento = envenenamiento;
	}

	@Override
	public String invocar ( ) throws IOException
	{
		if (this.getPersonaje( ).getMana( ) >= Envenenamiento.manaNecesitado)
		{
			// Invocacion
			Integer veneno = new Double((this.envenenamiento + (this.getPersonaje( ).getSalud( ) * 0.3))).intValue( );
			this.getPersonaje( ).setSalud(this.getPersonaje( ).getSalud( ) - veneno);
			this.getPersonaje( ).setMana(this.getPersonaje( ).getMana( ) - Envenenamiento.manaNecesitado);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[34m[HABILIDAD] Ha hecho " + veneno + " de danio a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")\u001B[37m");

			return "[HABILIDAD] Ha hecho " + veneno + " de danio a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")";
		}

		Depuracion.mostrarGuardar("NO has tenido mana para invocar la habilidad, se mejorara automaticamente...");
		this.mejorar( );

		return "NO has tenido mana para invocar la habilidad, se mejorara automaticamente...";
	}

	@Override
	public String mejorar ( ) throws IOException
	{
		// Mejora
		this.envenenamiento += 5;

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[34m[MEJORA] Ha mejorado en 5 el veneno del envenenamiento hacia " + this.getPersonaje( ).getNombre( ) + " (" + this.envenenamiento + ")\u001B[37m");

		return "[MEJORA] Ha mejorado en 5 el veneno del envenenamiento hacia " + this.getPersonaje( ).getNombre( ) + " (" + this.envenenamiento + ")";
	}
}
