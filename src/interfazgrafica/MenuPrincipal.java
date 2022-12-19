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
		this.panelHerramientas.setLayout(new WrapLayout( ));
		this.panelPersonajes.setLayout(new WrapLayout( ));
	}

	public JPanel getPanelPersonajes ( ) {return panelPersonajes;}

	public JPanel getPanelHerramientas ( ) {return panelHerramientas;}
}
