package personajes.magos;

import habilidades.debilitadores.Envenenamiento;
import habilidades.potenciadores.Intensificacion;
import herramientas.TiposHerramientas;
import herramientas.magos.Arco;
import personajes.Personaje;
import personajes.TiposPersonajes;

public class Sariel extends Personaje
{
	public Sariel ( )
	{
		// Inicializa las variables de control del personaje
		this.setNombre("Sariel");
		this.setSalud(900);
		this.setMana(9);
		this.setArmadura(40);
		this.setPenetracionArmadura(50);
		this.setTipo(TiposPersonajes.MAGO);

		// Inicializa las varibles de utilidad del personaje
		this.setHerramienta(new Arco(80));

		this.setHabilidad1(new Envenenamiento(this, 15));
		this.setHabilidad2(new Intensificacion(this, 10));
	}

	@Override
	public String pasiva (Personaje personaje)
	{
		if (this.getHerramienta( ).getTipo( ).equals(TiposHerramientas.DISTANCIA))
		{
			// Pasiva
			Integer salud = new Double(this.getHerramienta( ).getDanio( ) * 0.25).intValue( );
			this.setSalud(this.getSalud( ) + salud);

			// Depuracion
			System.out.println("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha recuperado " + salud + " de salud (" + this.getSalud( ) + ")\u001B[37m");
		}

		return "\u001B[33m[PASIVA] NO APLICADA\u001B[37m";
	}
}
