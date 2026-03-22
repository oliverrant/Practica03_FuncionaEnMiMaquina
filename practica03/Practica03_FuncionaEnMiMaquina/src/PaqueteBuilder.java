/**
 * Interfaz que define el patrón Builder para la creación de paquetes de herramientas.
 * Permite agregar diferentes tipos de herramientas en cantidades específicas.
 * 
 */
public interface PaqueteBuilder {
    
    /**
     * Agrega una cantidad específica de Kunais al paquete.
     * 
     * @param cantidad Número de Kunais a agregar
     * @return El mismo builder para encadenar operaciones
     */
    PaqueteBuilder agregarKunai(int cantidad);
    
    /**
     * Agrega una cantidad específica de Shurikens al paquete.
     * 
     * @param cantidad Número de Shurikens a agregar
     * @return El mismo builder para encadenar operaciones
     */
    PaqueteBuilder agregarShuriken(int cantidad);
    
    /**
     * Agrega una cantidad específica de Papeles Bomba al paquete.
     * 
     * @param cantidad Número de Papeles Bomba a agregar
     * @return El mismo builder para encadenar operaciones
     */
    PaqueteBuilder agregarPapelBomba(int cantidad);
    
    /**
     * Agrega una cantidad específica de Bombas de Humo al paquete.
     * 
     * @param cantidad Número de Bombas de Humo a agregar
     * @return El mismo builder para encadenar operaciones
     */
    PaqueteBuilder agregarBombaHumo(int cantidad);
    
    /**
     * Agrega una cantidad específica de Botiquines al paquete.
     * 
     * @param cantidad Número de Botiquines a agregar
     * @return El mismo builder para encadenar operaciones
     */
    PaqueteBuilder agregarBotiquin(int cantidad);
    
    /**
     * Construye y devuelve el paquete de herramientas final.
     * 
     * @return PaqueteHerramientas construido con todas las herramientas agregadas
     */
    PaqueteHerramientas build();

}
