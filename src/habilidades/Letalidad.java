package habilidades;

import personajes.Personaje;

public class Letalidad extends Habilidad
{
    /*
    Habilidad que otorga penetracion de armadura al jugador
    Cuando se mejora incrementa la cantidad de penetracion de armadura en 12
     */

    private Integer letalidad;

    public Letalidad (Personaje personaje, Integer letalidad)
    {
        this.setPersonaje(personaje);
        this.setObjetivo(TipoObjetivo.JUGADOR);
        this.letalidad = letalidad;
    }

    @Override
    public void invocar ( )
    {
        // Invocacion
        this.getPersonaje( ).setPenetracionArmadura(this.getPersonaje( ).getPenetracionArmadura( ) + this.letalidad);

        // Depuracion
        System.out.println("\u001B[34m[HABILIDAD] Ha aumentado en " + this.letalidad + " la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getPenetracionArmadura( ) + ")\u001B[37m");
    }

    @Override
    public void mejorar ( )
    {
        // Mejora
        this.letalidad += 12;

        // Depuracion
        System.out.println("\u001B[34m[MEJORA] Ha mejorado en 12 la penetracion de armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.letalidad + ")\u001B[37m");
    }
}
