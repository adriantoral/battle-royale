package habilidades;

import personajes.Personaje;

public class Envenenamiento extends Habilidad
{
    /*
    Habilidad que envenena a un personaje segun la vida del enemigo.
    Cada mejora incrementa el poder del veneno en 5
     */

    private Integer envenenamiento;

    public Envenenamiento (Personaje personaje, Integer envenenamiento)
    {
        this.setPersonaje(personaje);
        this.setObjetivo(TipoObjetivo.ENEMIGO);
        this.envenenamiento = envenenamiento;
    }

    @Override
    public void invocar ( )
    {
        // Invocacion
        Integer veneno = new Double((this.envenenamiento + (this.getPersonaje( ).getSalud( ) * 0.3))).intValue( );
        this.getPersonaje( ).setSalud(this.getPersonaje( ).getSalud( ) - veneno);

        // Depuracion
        System.out.println("\u001B[34m[HABILIDAD] Ha hecho " + veneno + " de danio a " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getSalud( ) + ")\u001B[37m");
    }

    @Override
    public void mejorar ( )
    {
        // Mejora
        this.envenenamiento += 5;

        // Depuracion
        System.out.println("\u001B[34m[MEJORA] Ha mejorado en 5 el veneno del envenenamiento hacia " + this.getPersonaje( ).getNombre( ) + " (" + this.envenenamiento + ")\u001B[37m");
    }
}
