/**
 * Clase abstracta que representa un campo de entrenamiento.
 * Sirve como base para los diferentes tipos de campos disponibles.
 * 
 */
public abstract class CampoEntrenamiento {
    protected String nombre;
    protected String descripcion;

    /**
     * Constructor de la clase CampoEntrenamiento.
     * 
     * @param nombre Nombre del campo de entrenamiento
     * @param descripcion Descripción del campo de entrenamiento
     */
    public CampoEntrenamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
   
    /**
     * Obtiene el nombre del campo de entrenamiento.
     * 
     * @return Nombre del campo
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene la descripción del campo de entrenamiento.
     * 
     * @return Descripción del campo
     */
    public String getDescripcion(){
        return descripcion;
    }

     /**
     * Devuelve una representación en cadena del campo de entrenamiento.
     * 
     * @return Cadena con nombre y descripción del campo
     */
    @Override
    public String toString() {
        return nombre + ": " + descripcion;
    }
}
