/**
 * Interfaz genérica que define un iterador para recorrer colecciones.
 * 
 * @param <T> Tipo de elementos que itera
 */
public interface Iterator<T> {

    /**
     * Verifica si hay más elementos en la iteración.
     * 
     * @return true si hay más elementos, false en caso contrario
     */
    boolean hasNext();

    /**
     * Obtiene el siguiente elemento de la iteración.
     * 
     * @return Siguiente elemento
     */
    T next();
}
