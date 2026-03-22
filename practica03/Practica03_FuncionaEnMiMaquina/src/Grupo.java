import java.util.ArrayList;
import java.util.List;

/**
 * Representa un grupo de entrenamiento formado por un ninja líder y varios aspirantes.
 * Cada grupo tiene asignado un paquete de herramientas y un campo de entrenamiento.
 * 
 */
public class Grupo {
    private Ninja lider;
    private List<Aspirante> grupoAspirantes;
    private PaqueteHerramientas paquete;
    private CampoEntrenamiento campo;

    /**
     * Constructor de la clase Grupo.
     * 
     * @param lider Ninja que liderará el grupo
     */
    public Grupo(Ninja lider) {
        this.lider = lider;
        this.grupoAspirantes = new ArrayList<>();
    }

    /**
     * Agrega un aspirante al grupo.
     * 
     * @param aspirante Aspirante a agregar al grupo
     */
    public void agregarAlGrupo(Aspirante aspirante) {
        grupoAspirantes.add(aspirante);
    }

     /**
     * Calcula el nivel total del grupo sumando el nivel del líder
     * y los niveles de todos los aspirantes.
     * 
     * @return Suma de todos los niveles del grupo
     */
    public int getNivelTotal(){
        int total = lider.getNivel();
        for(Aspirante a : grupoAspirantes){
            total += a.getNivel();
        }
        return total;
    }

     /**
     * Asigna un paquete de herramientas al grupo.
     * 
     * @param paquete Paquete de herramientas a asignar
     */
    public void setPaquete(PaqueteHerramientas paquete){
        this.paquete = paquete;
    }

    /**
     * Asigna un campo de entrenamiento al grupo.
     * 
     * @param campo Campo de entrenamiento a asignar
     */

    public void setCampo(CampoEntrenamiento campo){
        this.campo = campo;
    }

    /**
     * Obtiene el líder del grupo.
     * 
     * @return Ninja líder del grupo
     */
    public Ninja getLider() { 
        return lider; 
    }
   
    /**
     * Obtiene la lista de aspirantes del grupo.
     * 
     * @return Lista de aspirantes
     */

    public List<Aspirante> getAspirantes() { 
        return grupoAspirantes; 
    }

    /**
     * Devuelve una representación en cadena del grupo.
     * 
     * @return Cadena con toda la información del grupo
     */
    @Override
    public String toString(){
        return "LIDER: " + lider.getNombre() + 
            " con rango " + lider.getRango()
        + "\n"
        + "ASPIRANTES: " + aspirantesToString() 
        + "\n" 
        + "PAQUETE: " + paquete.toString()
        + "\n"
        + "LUGAR: " + campo
        + "\n"
        + "NIVEL TOTAL DEL GRUPO: " + this.getNivelTotal()
        + "\n --------------------------------------------";
    }

     /**
     * Genera una representación en cadena de los aspirantes del grupo.
     * 
     * @return Cadena con los nombres y niveles de los aspirantes
     */
    public String aspirantesToString(){
        String aspirantes = "";
        for(Aspirante a : grupoAspirantes){
            aspirantes += "- " + a.getNombre() + " con nivel " + a.getNivel() + "\n";
        }
        return aspirantes;
    }
}