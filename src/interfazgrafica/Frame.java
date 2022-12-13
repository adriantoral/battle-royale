package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
	public Frame (String title) throws
	                            HeadlessException
	{
		super(title);

		// Definir el layout
		this.setLayout(new BorderLayout(0, 10));

		// Salir al cerrar
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Definir el tamanio de la interfaz y la posicion
		this.setSize(600, 600);
		this.setLocation(500, 100);

		// Hacer la interfaz visible y bloqueada
		this.setVisible(true);
		this.setResizable(false);
	}
}
