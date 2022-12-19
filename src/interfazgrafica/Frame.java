package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
	static final Integer screenWidth = (int) Toolkit.getDefaultToolkit( ).getScreenSize( ).getWidth( ), screenHeight = (int) Toolkit.getDefaultToolkit( ).getScreenSize( ).getHeight( );

	public Frame (String title) throws HeadlessException
	{
		super(title);

		// Definir el layout
		this.setLayout(new BorderLayout(0, 10));

		// Salir al cerrar
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Definir el tamanio de la interfaz y la posicion
		this.setSize((screenWidth * 60) / 100, (screenHeight * 60) / 100);
		this.setLocation(screenWidth / 5, screenHeight / 10);

		// Hacer la interfaz visible y bloqueada
		this.setVisible(true);
		this.setResizable(false);
	}
}
