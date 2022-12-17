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
	}

	public JPanel getPanelPersonajes ( ) {return panelPersonajes;}

	public JPanel getPanelHerramientas ( ) {return panelHerramientas;}
}
