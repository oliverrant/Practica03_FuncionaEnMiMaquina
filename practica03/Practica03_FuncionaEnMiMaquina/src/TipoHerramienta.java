/**
 * Enumeración que representa los diferentes tipos de herramientas disponibles.
 * Cada tipo de herramienta tiene un peso específico.
 * 
 */

public enum TipoHerramienta {
    /** Kunai: herramienta arrojadiza de metal con peso de 0.7 kg */
    KUNAI(0.7),
    /** Shuriken: estrella ninja con peso de 0.2 kg */
    SHURIKEN(0.2), 
    /** Papel Bomba: artefacto explosivo con peso de 0.3 kg */
    PAPEL_BOMBA(0.3), 
    /** Bomba de Humo: artefacto para crear humo con peso de 0.1 kg */
    BOMBA_HUMO(0.1), 
    /** Botiquín: kit de primeros auxilios con peso de 0.9 kg */
    BOTIQUIN(0.9);

    private double peso;

    /**
     * Constructor del enumerado TipoHerramienta.
     * 
     * @param peso Peso en kilogramos de la herramienta
     */
    TipoHerramienta(double peso) {
        this.peso = peso;
    }

     /**
     * Obtiene el peso de la herramienta.
     * 
     * @return Peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }
}
