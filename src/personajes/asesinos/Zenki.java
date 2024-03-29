package personajes.asesinos;

import habilidades.potenciadores.Intensificacion;
import habilidades.potenciadores.Letalidad;
import herramientas.TiposHerramientas;
import herramientas.asesinos.Daga;
import personajes.Personaje;
import personajes.TiposPersonajes;
import utilidades.Depuracion;

import java.io.IOException;
import java.util.Random;

public class Zenki extends Personaje
{
	public Zenki ( )
	{
		// Inicializa las variables de control del personaje
		this.setNombre("Zenki");
		this.setSalud(600);
		this.setMana(18);
		this.setArmadura(20);
		this.setPenetracionArmadura(90);
		this.setTipo(TiposPersonajes.ASESINO);

		// Inicializa las varibles de utilidad del personaje
		this.setHerramienta(new Daga( ));

		this.setHabilidad1(new Letalidad(this, 20));
		this.setHabilidad2(new Intensificacion(this, 10));

		// Pasiva por ser Asesino
		if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.MELEE)) this.getHerramienta( ).setDanio(this.getHerramienta( ).getDanio( ) + 10);
	}

	@Override
	public String pasiva (Personaje personaje) throws IOException
	{
		if (new Random( ).nextInt(25) == 0)
		{
			// Pasiva
			this.getHerramienta( ).setDurabilidad(this.getHerramienta( ).getDurabilidad( ) + 1);

			// Depuracion
			Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha recompuesto el uso de la herramienta\u001B[37m");

			return "[PASIVA " + this.getNombre( ) + "] Ha recompuesto el uso de la herramienta";
		}

		return "[PASIVA " + this.getNombre( ) + "] NO APLICADA";
	}
}
