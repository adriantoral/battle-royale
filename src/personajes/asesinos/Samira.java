package personajes.asesinos;

import habilidades.potenciadores.Intensificacion;
import habilidades.potenciadores.Letalidad;
import herramientas.TiposHerramientas;
import herramientas.asesinos.Hacha;
import personajes.Personaje;
import personajes.TiposPersonajes;

public class Samira extends Personaje
{
	public Samira ( )
	{
		// Inicializa las variables de control del personaje
		this.setNombre("Samira");
		this.setSalud(700);
		this.setMana(23);
		this.setArmadura(30);
		this.setPenetracionArmadura(110);
		this.setTipo(TiposPersonajes.ASESINO);

		// Inicializa las varibles de utilidad del personaje
		this.setHerramienta(new Hacha( ));

		this.setHabilidad1(new Intensificacion(this, 40));
		this.setHabilidad2(new Letalidad(this, 30));

		// Pasiva por ser Asesino
		if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.MELEE)) this.getHerramienta( ).setDanio(this.getHerramienta( ).getDanio( ) + 20);
	}

	@Override
	public String pasiva (Personaje personaje)
	{
		this.getHerramienta( ).setDanio(this.getHerramienta( ).getDanio( ) + ((this.getHerramienta( ).getDanio( ) * 5) / 10));

		// Depuracion
		System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha aumentado el danio de la herramienta (" + this.getHerramienta( ).getDanio( ) + ")\u001B[37m");

		return "[PASIVA " + this.getNombre( ) + "] Ha aumentado el danio de la herramienta (" + this.getHerramienta( ).getDanio( ) + ")";
	}
}
