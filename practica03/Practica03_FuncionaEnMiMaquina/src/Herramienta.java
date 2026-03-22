/**
 * Representa una herramienta utilizada por los grupos de entrenamiento.
 * Cada herramienta tiene un tipo que determina su peso y características.
 * 
 */
public class Herramienta {
    private TipoHerramienta tipo;


    /**
     * Constructor de la clase Herramienta.
     * 
     * @param tipo Tipo de herramienta a crear
     */
    public Herramienta(TipoHerramienta tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo de la herramienta.
     * 
     * @return TipoHerramienta de la herramienta
     */
    public TipoHerramienta getTipo() { 
        return tipo; 
    }

    /**
     * Obtiene el peso de la herramienta.
     * 
     * @return Peso en kilogramos
     */
    public double getPeso() { 
        return tipo.getPeso(); 
    
    }

    /**
     * Devuelve una representación en cadena de la herramienta.
     * 
     * @return Cadena con el nombre y peso de la herramienta
     */
    public String toString() { 
        return tipo.name() + " (" + tipo.getPeso() + " kg)"; 
    }
}
