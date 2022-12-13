import excepciones.LongitudJugadoresInsuficiente;
import habilidades.TipoObjetivo;
import interfazgrafica.MenuJuego;
import interfazgrafica.MenuPrincipal;
import personajes.Personaje;
import personajes.asesinos.Zenki;
import personajes.magos.Sariel;
import personajes.tanques.Drukhari;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleRoyale
{
	// Personajes disponibles para seleccionar
	static final Personaje[] personajesSeleccionables = {new Zenki( ), new Sariel( ), new Drukhari( )};

	// Personajes disponibles en el juego
	static List<Personaje> personajesJugables = new ArrayList<>( );

	// Personaje del jugador, personaje que ataca y personaje atacado
	static Personaje personajeJugador = new Zenki( ), personajeAtacante = new Zenki( ), personajeAtacado = new Zenki( );

	// Crear el menu principal y menu de juego
	static MenuPrincipal menuPrincipal = new MenuPrincipal("BattleRoyale V3");
	static MenuJuego menuJuego = new MenuJuego("BattleRoyale V3");

	public static void nextPersonajes ( ) throws LongitudJugadoresInsuficiente
	{
		// Eliminar personajes si mueren
		if (personajeAtacado.getSalud( ) <= 0) System.out.println("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacado));
		if (personajeAtacante.getSalud( ) <= 0) System.out.println("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacante));

		if (personajesJugables.size( ) > 1)
		{
			// Seleccion de los personajes
			personajeAtacante = personajesJugables.remove(0); // Primer personaje de la lista
			personajeAtacado = personajesJugables.get(new Random( ).nextInt(personajesJugables.size( ))); // Personaje aleatorio de la lista
			personajesJugables.add(personajeAtacante); // Meter de nuevo al personaje sacado

			System.out.println("Turno del personaje: " + personajeAtacante.getNombre( ) + "\nAtacando al personaje: " + personajeAtacado.getNombre( ));

			// Cambiar de objetivos si la habilidad afecta al enemigo
			if (personajeAtacante.getHabilidad1( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad1( ).setPersonaje(personajeAtacado);
			if (personajeAtacante.getHabilidad2( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad2( ).setPersonaje(personajeAtacado);

			// Recargar el mana
			personajeAtacante.setMana(personajeAtacante.getMana( ) + 3);

			// Cambiar el texto de los label
			menuJuego.getTextoInformativo1( ).setText("Personaje atacando: " + personajeAtacante.getNombre( ) + " (" + personajeAtacante.getTipo( ) + (personajeAtacante == personajeJugador ? ") (TU PERSONAJE)" : ")"));
			menuJuego.getTextoInformativo2( ).setText("Personaje atacado: " + personajeAtacado.getNombre( ) + " (" + personajeAtacado.getTipo( ) + (personajeAtacado == personajeJugador ? ") (TU PERSONAJE)" : ")"));

			// Simular la batalla si es un robot
			if (personajeAtacante != personajeJugador) new Thread(BattleRoyale::jugar).start( );
		}

		else
		{
			// Mostar en pantalla el ganador
			System.out.println("HA GANADO EL PERSONAJE: " + personajesJugables.get(0));

			// Cerrar la ventana del menu de juego
			menuJuego.dispose( );

			// Lanzar excepcion
			throw new LongitudJugadoresInsuficiente("No quedan jugadores");
		}
	}

	public static void nextPersonajesHandler ( )
	{
		try {BattleRoyale.nextPersonajes( );}
		catch (LongitudJugadoresInsuficiente ignored) {}
	}

	public static void jugar ( )
	{
		// Variables para las opciones de juego
		int opcion = new Random( ).nextInt(4), opcion2 = new Random( ).nextInt(2);

		// Habilidades
		if (opcion == 1 || opcion == 2)
		{
			// Habilidad 1
			if (opcion == 1)
			{
				if (opcion2 <= 0) anadirRegistro(personajeAtacante.getHabilidad1( ).invocar( ));
				else anadirRegistro(personajeAtacante.getHabilidad1( ).mejorar( ));
			}

			// Habilidad 2
			else
			{
				if (opcion2 <= 0) anadirRegistro(personajeAtacante.getHabilidad2( ).invocar( ));
				else anadirRegistro(personajeAtacante.getHabilidad2( ).mejorar( ));
			}
		}

		// Reparacion herramienta
		else if (opcion == 3) anadirRegistro(personajeAtacante.getHerramienta( ).reparar( ));

		else anadirRegistro(personajeAtacante.atacar(personajeAtacado));

		// Espera despues del ataque del jugador
		//try {TimeUnit.SECONDS.sleep(2);}
		//catch (InterruptedException ex) {throw new RuntimeException(ex);}

		// Pasar al siguiente turno
		BattleRoyale.nextPersonajesHandler( );
	}

	public static void anadirRegistro (String registro)
	{
		menuJuego.getPanelRegistro( ).setText(menuJuego.getPanelRegistro( ).getText( ) + "\n" + registro);
	}

	public static void main (String[] args)
	{
		// Crear los botones para seleccionar el personaje del jugador
		for (Personaje personaje : personajesSeleccionables)
			menuPrincipal.getPanelBotones( ).add(new JButton(personaje.getNombre( ))
			{
				public JButton construir ( )
				{
					// Crear el listener del boton
					this.addActionListener(e -> {
						// Cambiando el personaje principal
						personajeJugador = personaje;

						// Cambiando el personaje principal
						personajesJugables.add(0, personajeJugador);

						// Cambiando los personajes en uso
						BattleRoyale.nextPersonajesHandler( );

						// Mostrar el personaje del jugador en pantalla
						System.out.println(personajeJugador);

						// Cerrar la ventana del menu principal
						menuPrincipal.dispose( );

						// Hacer la ventana del menu de juego visible
						menuJuego.setVisible(true);
					});

					// Devolver el boton
					return this;
				}
			}.construir( ));

		// Recarcar la interfaz
		menuPrincipal.validate( );

		// Asignar funciones a los botones de juego
		menuJuego.getBotonAtacar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.atacar(personajeAtacado));
			BattleRoyale.nextPersonajesHandler( );
		});

		menuJuego.getBotonHabilidad1Invocar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.getHabilidad1( ).invocar( ));
			BattleRoyale.nextPersonajesHandler( );
		});

		menuJuego.getBotonHabilidad1Mejorar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.getHabilidad1( ).mejorar( ));
			BattleRoyale.nextPersonajesHandler( );
		});

		menuJuego.getBotonHabilidad2Invocar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.getHabilidad2( ).invocar( ));
			BattleRoyale.nextPersonajesHandler( );
		});

		menuJuego.getBotonHabilidad2Mejorar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.getHabilidad2( ).mejorar( ));
			BattleRoyale.nextPersonajesHandler( );
		});

		menuJuego.getBotonReparar( ).addActionListener(e -> {
			anadirRegistro(personajeAtacante.getHerramienta( ).reparar( ));
			BattleRoyale.nextPersonajesHandler( );
		});

		// Crea los personajes
		for (int i = 0; i < 1; i++)
		{
			// Crear los personajes haciendo una nueva instancia desde la lista de los personajes
			try
			{
				personajesJugables.add(personajesSeleccionables[new Random( ).nextInt(personajesSeleccionables.length)].getClass( ).newInstance( ));
				personajesJugables.get(personajesJugables.size( ) - 1).setNombre("ROBOT " + i);
			}
			catch (InstantiationException | IllegalAccessException e) {throw new RuntimeException(e);}
		}
	}
}
