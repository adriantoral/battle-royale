package herramientas;

import personajes.Personaje;
import personajes.TiposPersonajes;

public class Daga extends Herramienta
{
    /*
    Herramienta de tipo distancia corta disenada para quitar armadura a tanques y vida extra a magos
     */

    public Daga (Integer danio)
    {
        super("Daga", danio, 20, TiposHerramientas.MELEE);
    }

    @Override
    public void pasiva (Personaje personaje, Personaje jugador)
    {
        if (personaje.getTipo( ).equals(TiposPersonajes.TANQUE))
        {
            // Pasiva
            personaje.setArmadura(personaje.getArmadura( ) - 20);

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha reducido en 20 la armadura de " + personaje.getNombre( ) + " (" + personaje.getArmadura( ) + ")\u001B[37m");
        }

        else if (personaje.getTipo( ).equals(TiposPersonajes.MAGO))
        {
            // Pasiva
            personaje.setSalud(personaje.getSalud( ) - 10);

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha quitado 10 de salud a " + personaje.getNombre( ) + " (" + personaje.getSalud( ) + ")\u001B[37m");
        }
    }
}
