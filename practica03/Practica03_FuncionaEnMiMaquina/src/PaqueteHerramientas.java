import java.util.List;

/**
 * Representa un paquete que contiene un conjunto de herramientas.
 * Permite calcular el peso total de todas las herramientas incluidas.
 * 
 */
public class PaqueteHerramientas {

    private List<Herramienta> herramientas;


    /**
     * Constructor de la clase PaqueteHerramientas.
     * 
     * @param herramientas Lista de herramientas que componen el paquete
     */
    public PaqueteHerramientas(List<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }

    /**
     * Calcula el peso total del paquete sumando los pesos de todas las herramientas.
     * 
     * @return Peso total en kilogramos
     */
    public double getPesoTotal() { 
        double sumaPesos = 0;
        for(Herramienta h : herramientas){
            sumaPesos += h.getPeso();
        }
        return sumaPesos;
    }
    
    /**
     * Obtiene la lista de herramientas del paquete.
     * 
     * @return Lista de herramientas
     */
    public List<Herramienta> getHerramientas() {
        return herramientas;
     }

    /**
     * Devuelve una representación en cadena del paquete.
     * 
     * @return Cadena con las herramientas y el peso total
     */
    public String toString() { 
        return "Contiene: " + herramientas + " ; Tiene un peso total de: "
        + getPesoTotal() + " kg"; 
    }
}
