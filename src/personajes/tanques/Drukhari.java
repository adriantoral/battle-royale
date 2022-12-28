package personajes.tanques;

import habilidades.potenciadores.Curacion;
import habilidades.potenciadores.Mitigacion;
import herramientas.TiposHerramientas;
import herramientas.tanques.Escudo;
import personajes.Personaje;
import personajes.TiposPersonajes;
import utilidades.Depuracion;

import java.io.IOException;

public class Drukhari extends Personaje
{
	public Drukhari ( )
	{
		// Inicializa las variables de control del personaje
		this.setNombre("Drukhari");
		this.setSalud(1500);
		this.setMana(27);
		this.setArmadura(100);
		this.setPenetracionArmadura(5);
		this.setTipo(TiposPersonajes.TANQUE);

		// Inicializa las varibles de utilidad del personaje
		this.setHerramienta(new Escudo( ));

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
	public String pasiva (Personaje personaje) throws IOException
	{
		// Pasiva
		Integer danio = new Double(personaje.getHerramienta( ).getDanio( ) * 0.05).intValue( );
		personaje.getHerramienta( ).setDanio(personaje.getHerramienta( ).getDanio( ) - danio);

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[33m[PASIVA " + this.getNombre( ) + "] Ha bajado en " + danio + " el danio de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDanio( ) + ")\u001B[37m");

		return "[PASIVA " + this.getNombre( ) + "] Ha bajado en " + danio + " el danio de la herramienta de " + personaje.getNombre( ) + " (" + personaje.getHerramienta( ).getDanio( ) + ")";
	}
}
