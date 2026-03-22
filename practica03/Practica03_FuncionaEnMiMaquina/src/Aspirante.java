/**
 * Representa a un aspirante a ninja que busca ser asignado a un grupo de entrenamiento.
 * Los aspirantes tienen nivel de habilidad entre 1 y 3.
 * 
 */
public class Aspirante {
    private String nombre;
    private int edad;
    private Clan clan;
    private int nivel;
    
    /**
     * Constructor de la clase Aspirante.
     * 
     * @param nombre Nombre del aspirante
     * @param edad Edad del aspirante
     * @param clan Clan al que pertenece el aspirante
     * @param nivel Nivel de habilidad del aspirante (1-3)
     * @throws IllegalArgumentException Si el nivel no está entre 1 y 3
     */
    public Aspirante(String nombre, int edad, Clan clan, int nivel){
        if (nivel < 1 || nivel > 3) {
            throw new IllegalArgumentException("El nivel de habilidad del aspirante debe ser entre 1 y 3");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivel = nivel;
    }

    /**
     * Obtiene el nombre del aspirante.
     * 
     * @return Nombre del aspirante
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene la edad del aspirante.
     * 
     * @return Edad del aspirante
     */
    public int getEdad(){
        return this.edad;
    }

    /**
     * Obtiene el clan del aspirante.
     * 
     * @return Clan del aspirante
     */
    public Clan getClan(){
        return this.clan;
    }

    /**
     * Obtiene el nivel de habilidad del aspirante.
     * 
     * @return Nivel del aspirante (1-3)
     */
    public int getNivel(){
        return this.nivel;
    }

    /**
     * Devuelve una representación en cadena del aspirante.
     * 
     * @return Cadena con la información del aspirante
     */
    @Override
    public String toString() {
        return nombre + " (Clan: " + clan + ", Edad: " + edad + ", Nivel: " + nivel + ")";
    }

}
