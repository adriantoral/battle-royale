import habilidades.TipoObjetivo;
import interfazgrafica.MenuPrincipal;
import personajes.Asesino;
import personajes.Mago;
import personajes.Personaje;
import personajes.Tanque;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BattleRoyale
{
    // Personajes disponibles para seleccionar
    static List<Personaje> personajesSeleccionables = new ArrayList<>(List.of(new Asesino("DefaultAsesion"), new Mago("DefaultMago"), new Tanque("DefaultTanque")));

    // Personaje del jugador
    static Personaje personajeJugador = new Asesino("Default");

    public static void jugar ( )
    {
        List<Personaje> personajesJugables = new ArrayList<>( );

        // Crea los personajes
        for (int i = 0; i < 10; i++) personajesJugables.add(new Tanque("Tanque" + i));

        // Cambiando el personaje principal
        personajesJugables.add(0, personajeJugador);

        // Variables de los personajes del juego
        Personaje personajeAtacante, personajeAtacado;

        // Variables para las opciones de juego
        int opcion = 0, opcion2 = 1;

        // Variable para simular el juego
        boolean isSimulacion = false;

        // Variable para el scanner
        Scanner scanner = new Scanner(System.in);

        // Bucle del juego
        while (personajesJugables.size( ) > 1)
        {
            // Seleccion de los personajes
            personajeAtacante = personajesJugables.remove(0); // Primer personaje de la lista
            personajeAtacado = personajesJugables.get(new Random( ).nextInt(personajesJugables.size( ))); // Personaje aleatorio de la lista
            personajesJugables.add(personajeAtacante); // Meter de nuevo al personaje sacado

            System.out.println("Turno del personaje: " + personajeAtacante.getNombre( ) + "\nAtacando al personaje: " + personajeAtacado.getNombre( ));

            // Cambiar de objetivos si la habilidad afecta al enemigo
            if (personajeAtacante.getHabilidad1( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad1( ).setPersonaje(personajeAtacado);

            if (personajeAtacante.getHabilidad2( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad2( ).setPersonaje(personajeAtacado);

            if (personajeAtacante == personajeJugador && !isSimulacion)
            {
                do
                {
                    System.out.println("Seleccione una opcion del turno:\n 0) Atacar\n 1) Habilidad 1\n 2) Habilidad 2\n 3) Reparar herramienta");
                    opcion = scanner.nextInt( );

                    if (opcion == -1) System.out.println("Menu especial:\n -2) Activar modo simulacion (no control)\n -3) Mostrar informacion de tu personaje\n -4) Mostrar informacion del personaje atacado");

                    else if (opcion == -2)
                    {
                        isSimulacion = true;
                        break;
                    }

                    else if (opcion == -3) System.out.println("\u001B[35m" + personajeAtacante + "\u001B[37m");

                    else if (opcion == -4) System.out.println("\u001B[35m" + personajeAtacado + "\u001B[37m");
                }
                while (opcion < 0 || opcion > 3);
            }
            else opcion = new Random( ).nextInt(4);

            if (opcion == 1 || opcion == 2)
            {
                // Pedir valor al usuario si es su personaje
                if (personajeAtacante == personajeJugador && !isSimulacion)
                {
                    System.out.println("Seleccione una opcion de la habilidad:\n 0) Invocar habilidad\n 1) Mejorar habilidad\n");
                    opcion2 = scanner.nextInt( );
                }
                else opcion2 = new Random( ).nextInt(2);

                if (opcion == 1)
                {
                    if (opcion2 <= 0) personajeAtacante.getHabilidad1( ).invocar( );
                    else personajeAtacante.getHabilidad1( ).mejorar( );
                }

                else
                {
                    if (opcion2 <= 0) personajeAtacante.getHabilidad2( ).invocar( );
                    else personajeAtacante.getHabilidad2( ).mejorar( );
                }
            }

            else if (opcion == 3) personajeAtacante.getHerramienta( ).reparar( );

            else personajeAtacante.atacar(personajeAtacado);

            // Eliminar personajes si mueren
            if (personajeAtacado.getSalud( ) <= 0) System.out.println("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacado));

            if (personajeAtacante.getSalud( ) <= 0) System.out.println("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacante));

            if (personajeAtacante == personajeJugador)
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }

        System.out.println("HA GANADO EL PERSONAJE: " + personajesJugables.get(0));

        scanner.close( );
    }

    public static void main (String[] args)
    {
        // Crear el menu principal
        MenuPrincipal menuPrincipal = new MenuPrincipal("BattleRoyale V3");

        // Crear los botones para seleccionar el personaje del jugador
        for (Personaje personaje : personajesSeleccionables)
            menuPrincipal.getPanelBotones( ).add(new JButton(personaje.getNombre( ).toString( ))
            {
                public JButton construir ( )
                {
                    // Crear el listener del boton
                    this.addActionListener(e -> {
                        // Cambiando el personaje principal
                        personajeJugador = personaje;

                        // Cambiando el label informativo
                        menuPrincipal.getEtiquetaPersonaje( ).setText("Tu personaje es: " + personajeJugador.getNombre( ));

                        // Mostrar el personaje del jugador en pantalla
                        System.out.println(personajeJugador);
                    });

                    // Devolver el boton
                    return this;
                }
            }.construir( ));

        // Crear el listener del boton de empezar el juego
        menuPrincipal.getBotonEmpezar( ).addActionListener(e -> {
            // Cerrar la interfaz grafica
            menuPrincipal.dispose( );

            // Empezar el juego en terminal
            BattleRoyale.jugar( );
        });
    }
}
