package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends Frame
{
	private JPanel panelPrincipal;
	private JTextPane panelRegistro;
	private JPanel panelBotones;
	private JButton botonAtacar;
	private JButton botonHabilidad1Invocar;
	private JButton botonHabilidad2Invocar;
	private JButton botonReparar;
	private JLabel textoInformativo1;
	private JLabel textoInformativo2;
	private JPanel panelInformativo;
	private JButton botonHabilidad1Mejorar;
	private JButton botonHabilidad2Mejorar;

	public MenuJuego (String title) throws
	                                HeadlessException
	{
		super(title);

		// Establecer el contenedor padre
		this.setContentPane(this.panelPrincipal);

		// Dejarla la ventana invisible
		this.setVisible(false);
	}

	public JPanel getPanelPrincipal ( ) {return panelPrincipal;}

	public JTextPane getPanelRegistro ( ) {return panelRegistro;}

	public JPanel getPanelBotones ( ) {return panelBotones;}

	public JButton getBotonAtacar ( ) {return botonAtacar;}

	public JButton getBotonHabilidad1 ( ) {return botonHabilidad1Invocar;}

	public JButton getBotonHabilidad2 ( ) {return botonHabilidad2Invocar;}

	public JButton getBotonReparar ( ) {return botonReparar;}

	public JLabel getTextoInformativo1 ( ) {return textoInformativo1;}

	public JLabel getTextoInformativo2 ( ) {return textoInformativo2;}

	public JButton getBotonHabilidad1Invocar ( ) {return botonHabilidad1Invocar;}

	public JButton getBotonHabilidad2Invocar ( ) {return botonHabilidad2Invocar;}

	public JPanel getPanelInformativo ( ) {return panelInformativo;}

	public JButton getBotonHabilidad1Mejorar ( ) {return botonHabilidad1Mejorar;}

	public JButton getBotonHabilidad2Mejorar ( ) {return botonHabilidad2Mejorar;}
}
