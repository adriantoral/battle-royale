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

    public void atacar (Personaje personaje)
    {
        // Turno de ataque de los personajes
        if (this.herramienta.getDurabilidad( ) > 0)
        {
            // Danio base de todas las herramientas basado en la armadura, danio y penetracion del personaje al que atacas
            Integer danio = this.herramienta.getDanio( ) - ((this.herramienta.getDanio( ) + this.getPenetracionArmadura( )) * (this.armadura / (100 + this.armadura)));
            personaje.setSalud(personaje.getSalud( ) - danio);

            // Depuracion y registro
            System.out.println("\u001B[31m[AA] " + this.getNombre( ) + " ha hecho " + danio + " de danio a " + personaje.nombre + " (" + personaje.getSalud( ) + ")");

            // Reducir la durabilidad de la herramienta
            this.herramienta.setDurabilidad(this.herramienta.getDurabilidad( ) - 1);

            // Pasiva de los personajes
            this.pasiva(personaje);

            // Pasiva de las herramientas
            this.herramienta.pasiva(personaje, this);

            // Recargar el mana
            this.mana += 3;
        }
    }

    public abstract void pasiva (Personaje personaje);

    @Override
    public String toString ( )
    {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", salud=" + salud +
                ", mana=" + mana +
                ", armadura=" + armadura +
                ", penetracionArmadura=" + penetracionArmadura +
                ", tipo=" + tipo +
                ", habilidad1=" + habilidad1 +
                ", habilidad2=" + habilidad2 +
                ", herramienta=" + herramienta +
                '}';
    }

    public Integer getSalud ( )
    {
        return salud;
    }

    public void setSalud (Integer salud)
    {
        this.salud = salud;
    }

    public Habilidad getHabilidad1 ( )
    {
        return habilidad1;
    }

    public void setHabilidad1 (Habilidad habilidad1)
    {
        this.habilidad1 = habilidad1;
    }

    public Habilidad getHabilidad2 ( )
    {
        return habilidad2;
    }

    public void setHabilidad2 (Habilidad habilidad2)
    {
        this.habilidad2 = habilidad2;
    }

    public Herramienta getHerramienta ( )
    {
        return herramienta;
    }

    public void setHerramienta (Herramienta herramienta)
    {
        this.herramienta = herramienta;
    }

    public Integer getArmadura ( )
    {
        return armadura;
    }

    public void setArmadura (Integer armadura)
    {
        this.armadura = armadura;
    }

    public Integer getPenetracionArmadura ( )
    {
        return penetracionArmadura;
    }

    public void setPenetracionArmadura (Integer penetracionArmadura)
    {
        this.penetracionArmadura = penetracionArmadura;
    }

    public TiposPersonajes getTipo ( )
    {
        return tipo;
    }

    public void setTipo (TiposPersonajes tipo)
    {
        this.tipo = tipo;
    }

    public String getNombre ( )
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public Integer getMana ( )
    {
        return mana;
    }

    public void setMana (Integer mana)
    {
        this.mana = mana;
    }
}
