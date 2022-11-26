package habilidades;

import personajes.Personaje;

public class Mitigacion extends Habilidad
{
    /*
    Habilidad que otorga mas armadura al jugador
    Cuando se mejora incrementa la cantidad de armadura en 12
     */

    private Integer mitigacion;

    public Mitigacion (Personaje personaje, Integer mitigacion)
    {
        this.setPersonaje(personaje);
        this.setObjetivo(TipoObjetivo.JUGADOR);
        this.mitigacion = mitigacion;
    }

    @Override
    public void invocar ( )
    {
        // Invocacion
        this.getPersonaje( ).setArmadura(this.getPersonaje( ).getArmadura( ) + this.mitigacion);

        // Depuracion
        System.out.println("\u001B[34m[HABILIDAD] Ha aumentado en " + this.mitigacion + " la armadura de " + this.getPersonaje( ).getNombre( ) + " (" + this.getPersonaje( ).getArmadura( ) + ")\u001B[37m");
    }

    @Override
    public void mejorar ( )
    {
        // Mejora
        this.mitigacion += 10;

        // Depuracion
        System.out.println("\u001B[34m[MEJORA] Ha mejorado en 10 la mitigacion de " + this.getPersonaje( ).getNombre( ) + " (" + this.mitigacion + ")\u001B[37m");
    }

    public Integer getMitigacion ( )
    {
        return mitigacion;
    }

    public void setMitigacion (Integer mitigacion)
    {
        this.mitigacion = mitigacion;
    }
}
