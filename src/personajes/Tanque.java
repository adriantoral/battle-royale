package personajes;

import habilidades.Curacion;
import habilidades.Mitigacion;
import herramientas.Escudo;
import herramientas.TiposHerramientas;

public class Tanque extends Personaje
{
    public Tanque (String nombre)
    {
        // Inicializa las variables de control del personaje
        this.setNombre(nombre);
        this.setSalud(1500);
        this.setArmadura(100);
        this.setPenetracionArmadura(5);
        this.setTipo(TiposPersonajes.TANQUE);

        // Inicializa las varibles de utilidad del personaje
        this.setHerramienta(new Escudo(2));

        this.setHabilidad1(new Curacion(this, 100));
        this.setHabilidad2(new Mitigacion(this, 10));

        // Pasiva por ser Tanque
        if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.DEFENSA))
        {
            this.setSalud(this.getSalud( ) + 200);
            this.setArmadura(this.getArmadura( ) + 30);
        }
    }

    @Override
    public void pasiva (Personaje personaje)
    {
        // Pasiva
        Integer danio = new Double(personaje.getHerramienta( ).getDanio( ) * 0.05).intValue( );
        personaje.getHerramienta( ).setDanio(personaje.getHerramienta( ).getDanio( ) - danio);

        // Depuracion
        System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha bajado en " + danio + " el danio de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDanio( ) + ")\u001B[37m");
    }
}
