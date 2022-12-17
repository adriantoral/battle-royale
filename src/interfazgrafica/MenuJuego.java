package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends Frame
{
	private JPanel panelPrincipal, panelBotones, panelInformativo;
	private JTextPane panelRegistro;
	private JButton botonAtacar, botonHabilidad1Invocar, botonHabilidad2Invocar, botonReparar, botonHabilidad1Mejorar, botonHabilidad2Mejorar;
	private JLabel textoInformativo1, textoInformativo2;

	public MenuJuego (String title) throws HeadlessException
	{
		super(title);

		// Establecer el contenedor padre
		this.setContentPane(this.panelPrincipal);

		// Dejarla la ventana invisible
		this.setVisible(false);
	}

	public JTextPane getPanelRegistro ( ) {return panelRegistro;}

	public JButton getBotonAtacar ( ) {return botonAtacar;}

	public JButton getBotonHabilidad1Invocar ( ) {return botonHabilidad1Invocar;}

	public JButton getBotonHabilidad2Invocar ( ) {return botonHabilidad2Invocar;}

	public JButton getBotonReparar ( ) {return botonReparar;}

	public JButton getBotonHabilidad1Mejorar ( ) {return botonHabilidad1Mejorar;}

	public JButton getBotonHabilidad2Mejorar ( ) {return botonHabilidad2Mejorar;}

	public JLabel getTextoInformativo1 ( ) {return textoInformativo1;}

	public JLabel getTextoInformativo2 ( ) {return textoInformativo2;}
}
