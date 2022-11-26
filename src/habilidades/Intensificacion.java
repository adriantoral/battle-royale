package habilidades;

import personajes.Personaje;

public class Intensificacion extends Habilidad
{
    /*
    Habilidad que intensifica el danio de la herramienta en uso del jugador
    Cada mejora incrementa el poder de intensificacion en 15
     */

    private Integer intensificacion;

    public Intensificacion (Personaje personaje, Integer intensificacion)
    {
        this.setPersonaje(personaje);
        this.setObjetivo(TipoObjetivo.JUGADOR);
        this.intensificacion = intensificacion;
    }

    @Override
    public void invocar ( )
    {
        // Invocacion
        this.getPersonaje( ).getHerramienta( ).setDanio(this.getPersonaje( ).getHerramienta( ).getDanio( ) + this.intensificacion);

        // Depuracion
        System.out.println("\u001B[34m[HABILIDAD] Ha aumentado en " + this.intensificacion + " el danio de la herramienta de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getHerramienta( ).getDanio( ) + ")\u001B[37m");
    }

    @Override
    public void mejorar ( )
    {
        // Mejora
        this.intensificacion += 15;

        // Depuracion
        System.out.println("\u001B[34m[MEJORA] Ha mejorado en 15 la intensificacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.intensificacion + ")\u001B[37m");
    }
}
