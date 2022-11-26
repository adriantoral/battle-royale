import habilidades.TipoObjetivo;
import personajes.Asesino;
import personajes.Mago;
import personajes.Personaje;
import personajes.Tanque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleRoyale
{
    public static void main (String[] args)
    {
        Personaje personaje1 = new Mago("VARUS"),
                personaje2 = new Tanque("SHACO"),
                personajeActual,
                personajeAtacando;

        List<Personaje> personajes = new ArrayList<Personaje>( );
        personajes.add(personaje1);
        personajes.add(personaje2);

        Scanner scanner = new Scanner(System.in);
        Integer opcion = 0;

        while (personajes.size( ) > 1)
        {
            personajeActual = personajes.remove(0);
            personajes.add(personajeActual);
            personajeAtacando = personajes.get(0);
            System.out.println("Turno del personaje: " + personajeActual);

            // Cambiar de objetivos si la habilidad afecta al enemigo
            if (personajeActual.getHabilidad1( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO))
                personajeActual.getHabilidad1( ).setPersonaje(personajeAtacando);

            if (personajeActual.getHabilidad2( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO))
                personajeActual.getHabilidad2( ).setPersonaje(personajeAtacando);

            do
            {
                System.out.println("Seleccione una opcion del turno:\n 0) Atacar\n 1) Habilidad 1\n 2) Habilidad 2\n 3) Reparar herramienta\n");
                opcion = scanner.nextInt( );
            }
            while (opcion < 0 || opcion > 3);

            if (opcion == 1)
            {
                System.out.println("Seleccione una opcion de la habilidad:\n 1) Invocar habilidad\n 2) Mejorar habilidad\n");
                if (scanner.nextInt( ) <= 1)
                    personajeActual.getHabilidad1( ).invocar( );

                else
                    personajeActual.getHabilidad1( ).mejorar( );
            }

            else if (opcion == 2)
            {
                System.out.println("Seleccione una opcion de la habilidad:\n 1) Invocar habilidad\n 2) Mejorar habilidad\n");
                if (scanner.nextInt( ) <= 1)
                    personajeActual.getHabilidad2( ).invocar( );

                else
                    personajeActual.getHabilidad2( ).mejorar( );
            }

            else if (opcion == 3) personajeActual.getHerramienta( ).reparar( );

            else personajeActual.atacar(personajeAtacando);

            // Eliminar personajes si mueren
            if (personajeAtacando.getSalud( ) <= 0)
                personajes.remove(personajeAtacando);

            if (personajeActual.getSalud( ) <= 0)
                personajes.remove(personajeActual);
        }

        System.out.println("HA GANADO EL PERSONAJE: " + personajes.get(0));

        scanner.close( );
    }
}
