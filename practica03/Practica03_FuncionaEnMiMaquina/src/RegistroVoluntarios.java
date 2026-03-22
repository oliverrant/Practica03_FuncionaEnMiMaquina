/**
 * Implementación de Colección para ninjas voluntarios utilizando un array simple.
 * Almacena los ninjas en orden de inserción.
 * 
 */

public class RegistroVoluntarios implements Coleccion<Ninja>{
    private Ninja[] datos;
    private int tamanio;
    private int contador;

    /**
     * Constructor de la clase RegistroVoluntarios.
     * 
     * @param tamanio Capacidad máxima del registro
     */
    public RegistroVoluntarios(int tamanio) {
        this.tamanio = tamanio;
        this.datos = new Ninja[tamanio];
        this.contador = 0;
    }

    /**
     * Agrega un ninja al registro.
     * 
     * @param ninja Ninja a agregar
     */

    public void agregar(Ninja ninja){
        if (contador < tamanio)
            datos[contador++] = ninja;
    }

    /**
     * Obtiene un iterador para recorrer los ninjas.
     * 
     * @return Iterador para el array
     */
    public Iterator<Ninja> getIterator(){
        return new IteratorArray();
    }

    /**
     * Clase interna que implementa el iterador para el array.
     */
    public class IteratorArray implements Iterator<Ninja>{
        
        private int indice = 0;

        /**
         * Verifica si hay más ninjas en la iteración.
         * 
         * @return true si hay más ninjas, false en caso contrario
         */
        public boolean hasNext() {
            return indice < contador;
         }

        /**
         * Obtiene el siguiente ninja en la iteración.
         * 
         * @return Siguiente ninja
         */
        public Ninja next() {
            return datos[indice++];
        }
    }
}
