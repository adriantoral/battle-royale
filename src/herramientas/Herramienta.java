package herramientas;

import personajes.Personaje;
import utilidades.Depuracion;

import java.io.IOException;

public abstract class Herramienta
{
	private String nombre;

	private Integer danio, durabilidad;
	private final Integer durabilidadReparada;

	private TiposHerramientas tipo;

	public Herramienta (String nombre, Integer danio, Integer durabilidad, TiposHerramientas tipo)
	{
		this.nombre = nombre;
		this.danio = danio;
		this.durabilidad = durabilidad;
		this.durabilidadReparada = durabilidad;
		this.tipo = tipo;
	}

	final public String reparar ( ) throws IOException
	{
		// Invocacion
		this.durabilidad = this.durabilidadReparada;

		// Depuracion
		Depuracion.mostrarGuardar("\u001B[32m[REPARACION " + this.getNombre( ) + "] Ha reparado su herramienta (" + this.durabilidad + ")\u001B[37m");
		return "[REPARACION " + this.getNombre( ) + "] Ha reparado su herramienta (" + this.durabilidad + ")";
	}

	public abstract String pasiva (Personaje personaje, Personaje jugador) throws IOException;

	@Override
	public String toString ( )
	{
		return "Herramienta{" + "nombre='" + nombre + '\'' + ", danio=" + danio + ", durabilidad=" + durabilidad + ", durabilidadReparada=" + durabilidadReparada + ", tipo=" + tipo + '}';
	}

	public String getNombre ( ) {return nombre;}

	public void setNombre (String nombre) {this.nombre = nombre;}

	public Integer getDanio ( ) {return danio;}

	public void setDanio (Integer danio) {this.danio = danio;}

	public Integer getDurabilidad ( ) {return durabilidad;}

	public void setDurabilidad (Integer durabilidad) {this.durabilidad = durabilidad;}

	public Integer getDurabilidadReparada ( ) {return durabilidadReparada;}

	public TiposHerramientas getTipo ( ) {return tipo;}

	public void setTipo (TiposHerramientas tipo) {this.tipo = tipo;}
}
