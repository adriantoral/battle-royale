package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends Frame
{
	private JPanel panelPrincipal, panelBotones, panelInformativo, panelDatosPersonaje, panelDatosHerramienta;
	private JTextPane panelRegistro;
	private JButton botonAtacar, botonHabilidad1Invocar, botonHabilidad2Invocar, botonReparar, botonHabilidad1Mejorar, botonHabilidad2Mejorar;
	private JLabel labelInformativo1, labelInformativo2, labelSalud, labelMana, labelArmadura, labelPenetracionArmadura, labelDatos1, labelDanio, labelDurabilidad, labelDurabilidadReparada, labelDatos2, labelSalud2, labelMana2, labelArmadura2, labelPenetracionArmadura2, labelDatos3;

	public MenuJuego (String title) throws HeadlessException
	{
		super(title);

		// Establecer el contenedor padre
		this.setContentPane(this.panelPrincipal);

		// Dejarla la ventana invisible
		this.setVisible(false);
	}

	public JPanel getPanelBotones ( ) {return panelBotones;}

	public JTextPane getPanelRegistro ( ) {return panelRegistro;}

	public JButton getBotonAtacar ( ) {return botonAtacar;}

	public JButton getBotonHabilidad1Invocar ( ) {return botonHabilidad1Invocar;}

	public JButton getBotonHabilidad2Invocar ( ) {return botonHabilidad2Invocar;}

	public JButton getBotonReparar ( ) {return botonReparar;}

	public JButton getBotonHabilidad1Mejorar ( ) {return botonHabilidad1Mejorar;}

	public JButton getBotonHabilidad2Mejorar ( ) {return botonHabilidad2Mejorar;}

	public JLabel getLabelInformativo1 ( ) {return labelInformativo1;}

	public JLabel getLabelInformativo2 ( ) {return labelInformativo2;}

	public JLabel getLabelSalud ( ) {return labelSalud;}

	public JLabel getLabelMana ( ) {return labelMana;}

	public JLabel getLabelArmadura ( ) {return labelArmadura;}

	public JLabel getLabelPenetracionArmadura ( ) {return labelPenetracionArmadura;}

	public JLabel getLabelDatos1 ( ) {return labelDatos1;}

	public JLabel getLabelDanio ( ) {return labelDanio;}

	public JLabel getLabelDurabilidad ( ) {return labelDurabilidad;}

	public JLabel getLabelDurabilidadReparada ( ) {return labelDurabilidadReparada;}

	public JLabel getLabelDatos2 ( ) {return labelDatos2;}

	public JLabel getLabelSalud2 ( ) {return labelSalud2;}

	public JLabel getLabelMana2 ( ) {return labelMana2;}

	public JLabel getLabelArmadura2 ( ) {return labelArmadura2;}

	public JLabel getLabelPenetracionArmadura2 ( ) {return labelPenetracionArmadura2;}

	public JLabel getLabelDatos3 ( ) {return labelDatos3;}
}
