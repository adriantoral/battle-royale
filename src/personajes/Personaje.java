package personajes;

import habilidades.Habilidad;
import herramientas.Herramienta;

public abstract class Personaje
{
	private String nombre;

	private Integer salud, mana, armadura, penetracionArmadura;

	private TiposPersonajes tipo;

	private Habilidad habilidad1, habilidad2;

	private Herramienta herramienta;

	public String atacar (Personaje personaje)
	{
		String returnString = "\n";

		// Turno de ataque de los personajes
		if (this.herramienta.getDurabilidad( ) > 0)
		{
			// Danio base de todas las herramientas basado en la armadura, danio y penetracion del personaje al que atacas
			Integer danio = this.herramienta.getDanio( ) - ((this.herramienta.getDanio( ) + this.getPenetracionArmadura( )) * (this.armadura / (100 + this.armadura)));
			personaje.setSalud(personaje.getSalud( ) - danio);

			// Depuracion y registro
			System.out.println("\u001B[31m[AUTOATAQUE " + this.getNombre( ) + "] Ha hecho " + danio + " de danio a " + personaje.nombre + " (" + personaje.getSalud( ) + ")\u001B[37m");

			// Reducir la durabilidad de la herramienta
			this.herramienta.setDurabilidad(this.herramienta.getDurabilidad( ) - 1);

			// Pasiva de los personajes
			returnString += this.pasiva(personaje) + "\n";

			// Pasiva de las herramientas
			returnString += this.herramienta.pasiva(personaje, this);

			// Recargar el mana
			this.mana += 3;

			return "[AUTOATAQUE " + this.getNombre( ) + "] Ha hecho " + danio + " de danio a " + personaje.nombre + " (" + personaje.getSalud( ) + ")" + returnString;
		}

		return "[AUTOATAQUE " + this.getNombre( ) + "] No tiene durabilidad en la herramienta " + " (" + personaje.getHerramienta( ).getDurabilidad( ) + ")" + returnString;
	}

	public abstract String pasiva (Personaje personaje);

	@Override
	public String toString ( )
	{
		return "Personaje{" + "nombre='" + nombre + '\'' + ", salud=" + salud + ", mana=" + mana + ", armadura=" + armadura + ", penetracionArmadura=" + penetracionArmadura + ", tipo=" + tipo + ", habilidad1=" + habilidad1 + ", habilidad2=" + habilidad2 + ", herramienta=" + herramienta + '}';
	}

	public String getNombre ( ) {return nombre;}

	public void setNombre (String nombre) {this.nombre = nombre;}

	public Integer getSalud ( ) {return salud;}

	public void setSalud (Integer salud) {this.salud = salud;}

	public Integer getMana ( ) {return mana;}

	public void setMana (Integer mana) {this.mana = mana;}

	public Integer getArmadura ( ) {return armadura;}

	public void setArmadura (Integer armadura) {this.armadura = armadura;}

	public Integer getPenetracionArmadura ( ) {return penetracionArmadura;}

	public void setPenetracionArmadura (Integer penetracionArmadura) {this.penetracionArmadura = penetracionArmadura;}

	public TiposPersonajes getTipo ( ) {return tipo;}

	public void setTipo (TiposPersonajes tipo) {this.tipo = tipo;}

	public Habilidad getHabilidad1 ( ) {return habilidad1;}

	public void setHabilidad1 (Habilidad habilidad1) {this.habilidad1 = habilidad1;}

	public Habilidad getHabilidad2 ( ) {return habilidad2;}

	public void setHabilidad2 (Habilidad habilidad2) {this.habilidad2 = habilidad2;}

	public Herramienta getHerramienta ( ) {return herramienta;}

	public void setHerramienta (Herramienta herramienta) {this.herramienta = herramienta;}
}
