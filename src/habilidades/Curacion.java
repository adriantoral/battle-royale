package habilidades;

import personajes.Personaje;

public class Curacion extends Habilidad
{
    /*
    Habilidad que cura una parte de la vida del jugador
    Cuando se mejora incrementa la cantidad de curacion en 20
     */

    private Integer curacion;

    public Curacion (Personaje personaje, Integer curacion)
    {
        this.setPersonaje(personaje);
        this.setObjetivo(TipoObjetivo.JUGADOR);
        this.curacion = curacion;
    }

    @Override
    public void invocar ( )
    {
        // Invocacion
        this.getPersonaje( ).setSalud(this.getPersonaje( ).getSalud( ) + this.curacion);

        // Depuracion
        System.out.println("\u001B[34m[HABILIDAD] Ha curado " + this.curacion + " a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")\u001B[37m");
    }

    @Override
    public void mejorar ( )
    {
        // Mejora
        this.curacion += 20;

        // Depuracion
        System.out.println("\u001B[34m[MEJORA] Ha mejorado en 20 curacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.curacion + ")\u001B[37m");
    }

    public Integer getCuracion ( )
    {
        return curacion;
    }

    public void setCuracion (Integer curacion)
    {
        this.curacion = curacion;
    }
}
