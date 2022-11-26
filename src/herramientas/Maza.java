package herramientas;

import personajes.Personaje;

import java.util.Random;

public class Maza extends Herramienta
{
    /*
    Herramienta de tipo defensa disenada para prolongar las batallas
    La pasiva mejora automaticamente una habilidad aleatoriamente
     */

    public Maza (Integer danio)
    {
        super("Maza de forja", danio, 100, TiposHerramientas.DEFENSA);
    }

    @Override
    public void pasiva (Personaje personaje, Personaje jugador)
    {
        if (new Random( ).nextInt(100) <= 50)
        {
            // Pasiva
            jugador.getHabilidad1( ).mejorar( );

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 1\u001B[37m");
        }

        else
        {
            // Pasiva
            jugador.getHabilidad2( ).mejorar( );

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha mejorado la habilidad 2\u001B[37m");
        }
    }
}
