/**
 * Interfaz genérica que define las operaciones básicas para una colección.
 * 
 * @param <T> Tipo de elementos que almacena la colección
 */
public interface Coleccion<T> {
    /**
     * Agrega un elemento a la colección.
     * 
     * @param elemento Elemento a agregar
     */
    void agregar(T elemento);

    /**
     * Obtiene un iterador para recorrer los elementos de la colección.
     * 
     * @return Iterador para recorrer la colección
     */

    Iterator<T> getIterator();
}
