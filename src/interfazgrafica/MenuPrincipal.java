package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends Frame
{
	private JPanel panelPrincipal, panelBotones;

	public MenuPrincipal (String title) throws
	                                    HeadlessException
	{
		super(title);

		// Establecer el contenedor padre
		this.setContentPane(this.panelPrincipal);
	}

	public JPanel getPanelPrincipal ( ) {return panelPrincipal;}

	public JPanel getPanelBotones ( ) {return panelBotones;}
}
