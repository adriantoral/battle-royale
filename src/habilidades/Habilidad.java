package habilidades;

import personajes.Personaje;

import java.io.IOException;

public abstract class Habilidad
{
    /*
    Esta clase es la padre de todas la habilides.
    Todas las clases hijas tendran una variable llamada 'personaje' que sera al objeto al que afectan, ya sea enemigo o el propio jugador.
    Ademas tendran dos funciones clave:
        - invocar : Ejecutara la funcion de la habilidad
        - mejorar : Mejorara la habilidad llamada en invocar

    Ejemplo:
        Habilidad curacion:
            - Curacion inicial : 10hp
            - invocar() -> cura 10hp al jugador
            - mejorar() -> mejora la funcion invocar(), ahora cura 20hp
            - invocar() -> cura 20hp al jugador
     */

	private Personaje personaje;

	private TipoObjetivo objetivo;

	public abstract String invocar ( ) throws IOException;

	public abstract String mejorar ( ) throws IOException;

	@Override
	public String toString ( )
	{
		return "Habilidad{" + ", objetivo=" + objetivo + '}';
	}

	public Personaje getPersonaje ( ) {return personaje;}

	public void setPersonaje (Personaje personaje) {this.personaje = personaje;}

	public TipoObjetivo getObjetivo ( ) {return objetivo;}

	public void setObjetivo (TipoObjetivo objetivo) {this.objetivo = objetivo;}
}
