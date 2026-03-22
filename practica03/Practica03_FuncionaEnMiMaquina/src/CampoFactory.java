/**
 * Fábrica abstracta para la creación de campos de entrenamiento.
 * Proporciona un método estático para crear el campo apropiado según el nivel total del grupo.
 * 
 */
public abstract class CampoFactory {

    /**
     * Crea un campo de entrenamiento basado en el nivel total del grupo.
     * 
     * @param nivelTotal Nivel total acumulado del grupo (líder + aspirantes)
     * @return CampoEntrenamiento correspondiente según el nivel:
     *         - Nivel ≤ 7: Valle del Dragón
     *         - Nivel ≤ 11: Bosque Sombrío
     *         - Nivel > 11: Montaña Espiritual
     */
    public static CampoEntrenamiento crearCampo(int nivelTotal) {
        if (nivelTotal <= 7) {
            return new ValleDragon();
        } else if (nivelTotal <= 11) {
            return new BosqueSombrio();
        } else {
            return new MontanaEspiritual();
        }
    }
}
