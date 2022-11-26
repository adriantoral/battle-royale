package personajes;

import habilidades.Envenenamiento;
import habilidades.Intensificacion;
import herramientas.ArcoMagico;
import herramientas.Maza;
import herramientas.TiposHerramientas;

public class Mago extends Personaje
{
    public Mago (String nombre)
    {
        // Inicializa las variables de control del personaje
        this.setNombre(nombre);
        this.setSalud(900);
        this.setArmadura(40);
        this.setPenetracionArmadura(50);
        this.setTipo(TiposPersonajes.MAGO);

        // Inicializa las varibles de utilidad del personaje
        this.setHerramienta(new Maza(80));

        this.setHabilidad1(new Envenenamiento(this, 15));
        this.setHabilidad2(new Intensificacion(this, 10));
    }

    @Override
    public void pasiva (Personaje personaje)
    {
        if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.DISTANCIA))
        {
            // Pasiva
            Integer salud = new Double(this.getHerramienta( ).getDanio( ) * 0.25).intValue( );
            this.setSalud(this.getSalud( ) + salud);

            // Depuracion
            System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha recuperado " + salud + " de salud (" + this.getSalud( ) + ")\u001B[37m");
        }
    }
}
