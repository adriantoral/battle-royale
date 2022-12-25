package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends Frame
{
	private JPanel panelPrincipal, panelPersonajes, panelHerramientas;

	public MenuPrincipal (String title) throws
	                                    HeadlessException
	{
		super(title);

		// Establecer el contenedor padre
		this.setContentPane(this.panelPrincipal);

		// Cambiando los layouts de los paneles
		this.panelHerramientas.setLayout(new GridLayout(2, 8));
		this.panelPersonajes.setLayout(new GridLayout(2, 8));
	}

	public JPanel getPanelPersonajes ( ) {return panelPersonajes;}

	public JPanel getPanelHerramientas ( ) {return panelHerramientas;}
}
