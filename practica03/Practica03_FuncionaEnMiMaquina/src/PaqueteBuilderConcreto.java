import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta del builder para paquetes de herramientas.
 * Permite construir paquetes agregando herramientas individualmente.
 * 
 */
public class PaqueteBuilderConcreto implements PaqueteBuilder{
    
private List<Herramienta> paquete = new ArrayList<>();
    
    /**
     * Agrega Kunais al paquete.
     * 
     * @param cantidad Número de Kunais a agregar
     * @return El mismo builder para encadenar operaciones
     */
    public PaqueteBuilder agregarKunai(int cantidad){
        for (int i = 0; i < cantidad; i++)
            paquete.add(new Herramienta(TipoHerramienta.KUNAI));
        return this;
    }

    /**
     * Agrega Shurikens al paquete.
     * 
     * @param cantidad Número de Shurikens a agregar
     * @return El mismo builder para encadenar operaciones
     */
    public PaqueteBuilder agregarShuriken(int cantidad){
        for (int i = 0; i < cantidad; i++)
            paquete.add(new Herramienta(TipoHerramienta.SHURIKEN));
        return this;
    }

    /**
     * Agrega Papeles Bomba al paquete.
     * 
     * @param cantidad Número de Papeles Bomba a agregar
     * @return El mismo builder para encadenar operaciones
     */
    public PaqueteBuilder agregarPapelBomba(int cantidad){
        for (int i = 0; i < cantidad; i++)
            paquete.add(new Herramienta(TipoHerramienta.PAPEL_BOMBA));
        return this;
    }

    /**
     * Agrega Bombas de Humo al paquete.
     * 
     * @param cantidad Número de Bombas de Humo a agregar
     * @return El mismo builder para encadenar operaciones
     */
    public PaqueteBuilder agregarBombaHumo(int cantidad){
        for (int i = 0; i < cantidad; i++)
            paquete.add(new Herramienta(TipoHerramienta.BOMBA_HUMO));
        return this;
    }

    /**
     * Agrega Botiquines al paquete.
     * 
     * @param cantidad Número de Botiquines a agregar
     * @return El mismo builder para encadenar operaciones
     */
    public PaqueteBuilder agregarBotiquin(int cantidad){
        for (int i = 0; i < cantidad; i++)
            paquete.add(new Herramienta(TipoHerramienta.BOTIQUIN));
        return this;
    }

    /**
     * Construye y devuelve el paquete de herramientas.
     * 
     * @return PaqueteHerramientas con todas las herramientas agregadas
     */
    public PaqueteHerramientas build(){
        return new PaqueteHerramientas(paquete);
    }
}
