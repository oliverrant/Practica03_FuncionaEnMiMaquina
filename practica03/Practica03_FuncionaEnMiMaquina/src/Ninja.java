/**
 * Representa a un ninja voluntario que puede liderar grupos de entrenamiento.
 * Los ninjas tienen nivel de habilidad entre 4 y 6 y poseen un rango específico.
 * 
 * @author Sistema de Gestión de Grupos
 * @version 1.0
 */

public class Ninja {
    private String nombre;
    private int edad;
    private Clan clan;
    private Rango rango;
    private int nivel;


    /**
     * Constructor de la clase Ninja.
     * 
     * @param nombre Nombre del ninja
     * @param edad Edad del ninja
     * @param clan Clan al que pertenece el ninja
     * @param rango Rango del ninja (GENIN, CHUNIN, JONIN)
     * @param nivel Nivel de habilidad del ninja (4-6)
     * @throws IllegalArgumentException Si el nivel no está entre 4 y 6
     */
    public Ninja(String nombre, int edad, Clan clan, Rango rango, int nivel){
        if (nivel < 4 || nivel > 6) {
        throw new IllegalArgumentException("El nivel de habilidad del ninja debe ser entre 4 y 6");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.rango = rango;
        this.nivel = nivel;
    }

    /**
     * Obtiene el nombre del ninja.
     * 
     * @return Nombre del ninja
     */

    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene la edad del ninja.
     * 
     * @return Edad del ninja
     */
    public int getEdad(){
        return this.edad;
    }

    /**
     * Obtiene el clan del ninja.
     * 
     * @return Clan del ninja
     */
    public Clan getClan(){
        return this.clan;
    }

    /**
     * Obtiene el rango del ninja.
     * 
     * @return Rango del ninja
     */
     public Rango getRango(){
        return this.rango;
    }

    /**
     * Obtiene el nivel de habilidad del ninja.
     * 
     * @return Nivel del ninja (4-6)
     */
    public int getNivel(){
        return this.nivel;
    }

     /**
     * Devuelve una representación en cadena del ninja.
     * 
     * @return Cadena con la información del ninja
     */
    @Override
    public String toString() {
        return nombre + " (Clan: " + clan + ", Rango: " + rango + ", Edad: " + edad + ", Nivel: " + nivel + ")";
    }

}
