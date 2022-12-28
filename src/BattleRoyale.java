import excepciones.LongitudJugadoresInsuficiente;
import habilidades.TipoObjetivo;
import herramientas.Herramienta;
import herramientas.asesinos.Daga;
import herramientas.asesinos.Espada;
import herramientas.asesinos.Hacha;
import herramientas.magos.Arco;
import herramientas.tanques.Escudo;
import herramientas.tanques.Maza;
import interfazgrafica.MenuJuego;
import interfazgrafica.MenuPrincipal;
import personajes.Personaje;
import personajes.asesinos.Samira;
import personajes.asesinos.Zenki;
import personajes.magos.Sariel;
import personajes.tanques.Drukhari;
import utilidades.Depuracion;
import utilidades.Ficheros;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BattleRoyale
{
	// Personajes disponibles para seleccionar
	static final Personaje[] personajesSeleccionables = {new Zenki( ), new Samira( ), new Sariel( ), new Drukhari( )};

	// Herramientas disponibles para seleccionar
	static final Herramienta[] herramientasSeleccionables = {new Daga( ), new Espada( ), new Hacha( ), new Arco( ), new Escudo( ), new Maza( )};

	// Personajes disponibles en el juego
	static final List<Personaje> personajesJugables = new ArrayList<>( );

	// Personaje del jugador, personaje que ataca y personaje atacado
	static Personaje personajeJugador = new Zenki( ), personajeAtacante = new Zenki( ), personajeAtacado = new Zenki( );

	// Herramienta del jugador
	static Herramienta herramientaJugador = new Daga( );

	// Crear el menu principal y menu de juego
	static final MenuPrincipal menuPrincipal = new MenuPrincipal("BattleRoyale Java - Seleccion de personaje");
	static final MenuJuego menuJuego = new MenuJuego("BattleRoyale Java - Interfaz de juego");

	public static void nextPersonajes ( ) throws LongitudJugadoresInsuficiente, IOException
	{
		// Eliminar personajes si mueren
		if (personajeAtacado.getSalud( ) <= 0) Depuracion.mostrarGuardar("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacado));
		if (personajeAtacante.getSalud( ) <= 0) Depuracion.mostrarGuardar("Se ha eliminado al personaje: " + personajesJugables.remove(personajeAtacante));

		if (personajesJugables.size( ) > 1)
		{
			// Seleccion de los personajes
			personajeAtacante = personajesJugables.remove(0); // Primer personaje de la lista
			personajeAtacado = personajesJugables.get(new Random( ).nextInt(personajesJugables.size( ))); // Personaje aleatorio de la lista
			personajesJugables.add(personajeAtacante); // Meter de nuevo al personaje sacado

			Depuracion.mostrarGuardar("Turno del personaje: " + personajeAtacante.getNombre( ) + "\nAtacando al personaje: " + personajeAtacado.getNombre( ));

			// Cambiar de objetivos si la habilidad afecta al enemigo
			if (personajeAtacante.getHabilidad1( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad1( ).setPersonaje(personajeAtacado);
			if (personajeAtacante.getHabilidad2( ).getObjetivo( ).equals(TipoObjetivo.ENEMIGO)) personajeAtacante.getHabilidad2( ).setPersonaje(personajeAtacado);

			// Recargar el mana
			personajeAtacante.setMana(personajeAtacante.getMana( ) + 3);

			// Cambiar el texto de los labels
			actualizarLabels( );

			// Simular la batalla si es un robot
			if (personajeAtacante != personajeJugador) new Thread(( ) -> {
				try {jugar( );}
				catch (IOException e) {throw new RuntimeException(e);}
			}).start( );

			// Hacer visible la interfaz de juego cuando es el jugador
			if (personajeAtacante == personajeJugador) for (Component component : menuJuego.getPanelBotones( ).getComponents( )) component.setVisible(true);
		}

		// Lanzar excepcion para terminar el juego
		else throw new LongitudJugadoresInsuficiente("No quedan jugadores");
	}

	public static void nextPersonajesHandler ( ) throws IOException
	{
		try
		{
			for (Component component : menuJuego.getPanelBotones( ).getComponents( )) component.setVisible(false);
			BattleRoyale.nextPersonajes( );
		}

		catch (LongitudJugadoresInsuficiente | IOException ignored)
		{
			// Mostar en pantalla el ganador
			Depuracion.mostrarGuardar("HA GANADO EL PERSONAJE: " + personajesJugables.get(0));

			// Cerrar la ventana del menu de juego
			menuJuego.dispose( );
		}
	}

	public static void jugar ( ) throws IOException
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
		try {TimeUnit.SECONDS.sleep(2);}
		catch (InterruptedException ex) {throw new RuntimeException(ex);}

		// Pasar al siguiente turno
		BattleRoyale.nextPersonajesHandler( );
	}

	public static void anadirRegistro (String registro) {menuJuego.getPanelRegistro( ).setText(menuJuego.getPanelRegistro( ).getText( ) + "\n" + registro);}

	public static void actualizarLabels ( )
	{
		menuJuego.getLabelInformativo1( ).setText("Personaje atacando: " + personajeAtacante.getNombre( ) + " (" + personajeAtacante.getTipo( ) + (personajeAtacante == personajeJugador ? ") (TU PERSONAJE)" : ")"));
		menuJuego.getLabelInformativo2( ).setText("Personaje atacado: " + personajeAtacado.getNombre( ) + " (" + personajeAtacado.getTipo( ) + (personajeAtacado == personajeJugador ? ") (TU PERSONAJE)" : ")"));

		menuJuego.getLabelSalud( ).setText("Salud: " + personajeAtacante.getSalud( ));
		menuJuego.getLabelMana( ).setText("Mana: " + personajeAtacante.getMana( ));
		menuJuego.getLabelArmadura( ).setText("Armadura: " + personajeAtacante.getArmadura( ));
		menuJuego.getLabelPenetracionArmadura( ).setText("Penetracion: " + personajeAtacante.getPenetracionArmadura( ));

		menuJuego.getLabelSalud2( ).setText("Salud: " + personajeAtacado.getSalud( ));
		menuJuego.getLabelMana2( ).setText("Mana: " + personajeAtacado.getMana( ));
		menuJuego.getLabelArmadura2( ).setText("Armadura: " + personajeAtacado.getArmadura( ));
		menuJuego.getLabelPenetracionArmadura2( ).setText("Penetracion: " + personajeAtacado.getPenetracionArmadura( ));

		menuJuego.getLabelDanio( ).setText("Danio: " + personajeAtacante.getHerramienta( ).getDanio( ));
		menuJuego.getLabelDurabilidad( ).setText("Durabilidad: " + personajeAtacante.getHerramienta( ).getDurabilidad( ));
		menuJuego.getLabelDurabilidadReparada( ).setText("Durabilidad reparada: " + personajeAtacante.getHerramienta( ).getDurabilidadReparada( ));
	}

	public static void main (String[] args) throws IOException
	{
		// Limpiar el fichero de depuracion
		Ficheros.limpiar(new File("depuracion.txt"));

		SwingUtilities.invokeLater(new Runnable( )
		{
			@Override
			public void run ( )
			{
				// Crear los botones para seleccionar el personaje del jugador
				for (Personaje personaje : personajesSeleccionables)
					menuPrincipal.getPanelPersonajes( ).add(new JButton(personaje.getNombre( ))
					{
						public JButton construir ( )
						{
							// Crear el listener del boton
							this.addActionListener(e -> {
								// Cambiando el personaje principal y su herramienta
								personajeJugador = personaje;
								personaje.setHerramienta(herramientaJugador);

								// Cambiando el personaje principal
								personajesJugables.add(0, personajeJugador);

								// Cambiando los personajes en uso
								try {BattleRoyale.nextPersonajesHandler( );}
								catch (IOException ex) {throw new RuntimeException(ex);}

								// Mostrar el personaje del jugador en pantalla
								try {Depuracion.mostrarGuardar(personajeJugador.toString( ));}
								catch (IOException ex) {throw new RuntimeException(ex);}

								// Cambiando el color del boton
								this.setBackground(Color.cyan);

								// Cerrar la ventana del menu principal
								menuPrincipal.dispose( );

								// Hacer la ventana del menu de juego visible
								menuJuego.setVisible(true);
							});

							// Quitando el borde del focus
							this.setFocusPainted(false);

							// Cambiado el color del boton
							this.setBackground(Color.white);
							this.setOpaque(true);

							// Devolver el boton
							return this;
						}
					}.construir( ));

				// Crear los botones para seleccionar la herramienta del jugador
				for (Herramienta herramienta : herramientasSeleccionables)
					menuPrincipal.getPanelHerramientas( ).add(new JButton(herramienta.getNombre( ))
					{
						public JButton construir ( )
						{
							// Crear el listener del boton
							this.addActionListener(e -> {
								// Cambiando el personaje principal
								herramientaJugador = herramienta;

								// Cambiar la herramienta del jugador
								personajeJugador.setHerramienta(herramientaJugador);

								// Mostrar el personaje del jugador en pantalla
								try {Depuracion.mostrarGuardar(personajeJugador.toString( ));}
								catch (IOException ex) {throw new RuntimeException(ex);}

								// Cambiar el color de todos los botones
								for (Component boton : menuPrincipal.getPanelHerramientas( ).getComponents( ))
									if (boton instanceof JButton) boton.setBackground(Color.white);

								// Cambiando el color del boton
								this.setBackground(Color.cyan);
							});

							// Quitando el borde del focus
							this.setFocusPainted(false);

							// Cambiado el color del boton
							this.setBackground(Color.white);
							this.setOpaque(true);

							// Devolver el boton
							return this;
						}
					}.construir( ));

				// Recarcar la interfaz
				// menuPrincipal.validate( );

				// Asignar funciones a los botones de juego

				menuJuego.getBotonAtacar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.atacar(personajeAtacado));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				menuJuego.getBotonHabilidad1Invocar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.getHabilidad1( ).invocar( ));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				menuJuego.getBotonHabilidad1Mejorar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.getHabilidad1( ).mejorar( ));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				menuJuego.getBotonHabilidad2Invocar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.getHabilidad2( ).invocar( ));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				menuJuego.getBotonHabilidad2Mejorar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.getHabilidad2( ).mejorar( ));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				menuJuego.getBotonReparar( ).addActionListener(e -> {
					try
					{
						anadirRegistro(personajeAtacante.getHerramienta( ).reparar( ));
						BattleRoyale.nextPersonajesHandler( );
					}
					catch (IOException ignored) {}
				});

				// Ajustar los componentes de la pantalla principal
				menuPrincipal.pack( );
			}
		});

		// Crea los personajes
		for (int i = 0; i < 2; i++)
		{
			// Crear los personajes haciendo una nueva instancia desde la lista de los personajes
			try
			{
				personajesJugables.add(personajesSeleccionables[new Random( ).nextInt(personajesSeleccionables.length)].getClass( ).newInstance( ));
				personajesJugables.get(personajesJugables.size( ) - 1).setNombre("ROBOT " + i);
				personajesJugables.get(personajesJugables.size( ) - 1).setHerramienta(herramientasSeleccionables[new Random( ).nextInt(herramientasSeleccionables.length)].getClass( ).newInstance( ));
			}
			catch (InstantiationException | IllegalAccessException e) {throw new RuntimeException(e);}
		}
	}
}
