package interfazgrafica;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends Frame
{
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JLabel etiquetaPersonaje;
    private JPanel panelInformativo;
    private JButton botonEmpezar;

    public MenuPrincipal (String title) throws HeadlessException
    {
        super(title);
        this.setContentPane(this.panelPrincipal);
    }

    public JPanel getPanelPrincipal ( )
    {
        return panelPrincipal;
    }

    public JPanel getPanelBotones ( )
    {
        return panelBotones;
    }

    public JLabel getEtiquetaPersonaje ( )
    {
        return etiquetaPersonaje;
    }

    public JPanel getPanelInformativo ( )
    {
        return panelInformativo;
    }

    public JButton getBotonEmpezar ( )
    {
        return botonEmpezar;
    }
}
