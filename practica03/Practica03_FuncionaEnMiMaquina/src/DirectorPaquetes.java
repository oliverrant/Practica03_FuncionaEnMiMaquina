/**
 * Director que orquesta la construcción de paquetes de herramientas.
 * Utiliza el patrón Builder para crear paquetes predefinidos.
 * 
 */
public class DirectorPaquetes {
    private PaqueteBuilder builder;

    /**
     * Constructor del DirectorPaquetes.
     * 
     * @param builder Builder específico a utilizar para la construcción
     */

    public DirectorPaquetes(PaqueteBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye un paquete básico de herramientas.
     * Incluye: 1 Kunai, 1 Shuriken, 1 Botiquín.
     * 
     * @return PaqueteHerramientas configurado como básico
     */
    public PaqueteHerramientas construirBasico() {
        return builder.agregarKunai(1)
                      .agregarShuriken(1)
                      .agregarBotiquin(1)
                      .build();
    }

    /**
     * Construye un paquete avanzado de herramientas.
     * Incluye: 2 Shurikens, 3 Papeles Bomba, 2 Bombas de Humo, 2 Botiquines.
     * 
     * @return PaqueteHerramientas configurado como avanzado
     */
    public PaqueteHerramientas construirAvanzado() {
        return builder.agregarShuriken(2)
                      .agregarPapelBomba(3)
                      .agregarBombaHumo(2)
                      .agregarBotiquin(2)
                      .build();
    }

    /**
     * Construye un paquete táctico de herramientas.
     * Incluye: 3 Kunais, 2 Shurikens, 4 Papeles Bomba, 2 Bombas de Humo.
     * 
     * @return PaqueteHerramientas configurado como táctico
     */
    public PaqueteHerramientas construirTactico() {
        return builder.agregarKunai(3)
                      .agregarShuriken(2)
                      .agregarPapelBomba(4)
                      .agregarBombaHumo(2)
                      .build();
    }
}
