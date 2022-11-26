package personajes;

import habilidades.Intensificacion;
import habilidades.Letalidad;
import herramientas.Daga;
import herramientas.TiposHerramientas;

import java.util.Random;

public class Asesino extends Personaje
{
    public Asesino (String nombre)
    {
        // Inicializa las variables de control del personaje
        this.setNombre(nombre);
        this.setSalud(600);
        this.setArmadura(20);
        this.setPenetracionArmadura(90);
        this.setTipo(TiposPersonajes.ASESINO);

        // Inicializa las varibles de utilidad del personaje
        this.setHerramienta(new Daga(120));

        this.setHabilidad1(new Letalidad(this, 20));
        this.setHabilidad2(new Intensificacion(this, 10));

        // Pasiva por ser Asesino
        if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.MELEE))
            this.getHerramienta( ).setDanio(this.getHerramienta( ).getDanio( ) + 10);
    }

    @Override
    public void pasiva (Personaje personaje)
    {
        if (new Random( ).nextInt(25) == 0)
        {
            // Pasiva
            this.getHerramienta( ).setDurabilidad(this.getHerramienta( ).getDurabilidad( ) + 1);

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha recompuesto el uso de la herramienta\u001B[37m");
        }
    }
}
