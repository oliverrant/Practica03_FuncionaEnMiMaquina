/**
 * Implementación de Colección para aspirantes utilizando una tabla hash.
 * Almacena los aspirantes en una tabla hash con direccionamiento cerrado.
 * 
 */
public class RegistroAspirantes implements Coleccion<Aspirante>{
    private Aspirante[] tabla[];
    private int tamanio;

    /**
     * Constructor de la clase RegistroAspirantes.
     * 
     * @param tamanio Tamaño de la tabla hash
     */

    public RegistroAspirantes(int tamanio) {
        this.tamanio = tamanio;
        this.tabla = new Aspirante[tamanio][];
    }

    /**
     * Calcula el hash para un nombre dado.
     * 
     * @param nombre Nombre del aspirante
     * @return Índice hash calculado
     */
     private int hash(String nombre) {
         int suma = 0;
    for (int i = 0; i < nombre.length(); i++) {
        suma += nombre.charAt(i) * (i + 1);
    }
    return suma % tamanio;
    }

    /**
     * Agrega un aspirante al registro utilizando su nombre como clave de hash.
     * 
     * @param aspirante Aspirante a agregar
     */
    public void agregar(Aspirante aspirante){
        int indice = hash(aspirante.getNombre());
        if (tabla[indice] == null) {
            tabla[indice] = new Aspirante[10];
        }
        
        for (int i = 0; i < tabla[indice].length; i++) {
            if (tabla[indice][i] == null) {
                tabla[indice][i] = aspirante;
                break;
            }
        }
    }

    /**
     * Obtiene un iterador para recorrer los aspirantes.
     * 
     * @return Iterador para la tabla hash
     */

    public Iterator<Aspirante> getIterator(){
        return new IteratorHashTable();
    }

    /**
     * Clase interna que implementa el iterador para la tabla hash.
     */
    private class IteratorHashTable implements Iterator<Aspirante>{
        private int fila = 0; // indice i
        private int columna = 0; // indice j

        /**
         * Verifica si hay más aspirantes en la iteración.
         * 
         * @return true si hay más aspirantes, false en caso contrario
         */
        public boolean hasNext(){
        while (fila < tamanio) {
            if (tabla[fila] != null && columna < tabla[fila].length && tabla[fila][columna] != null) {
                return true;
            }
            columna++;
            if (tabla[fila] == null || columna >= tabla[fila].length) {
                fila++;
                columna = 0;
            }
        }
        return false;
    }

        /**
         * Obtiene el siguiente aspirante en la iteración.
         * 
         * @return Siguiente aspirante
         */
        public Aspirante next(){
            Aspirante aspirante = tabla[fila][columna];
            columna++;
            if (columna >= tabla[fila].length) {
                fila++;
                columna = 0;
            }
            return aspirante;
        }
    }
}
