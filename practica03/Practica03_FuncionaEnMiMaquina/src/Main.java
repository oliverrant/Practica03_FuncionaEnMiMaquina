/**
 * Clase principal que ejecuta la aplicación de gestión de grupos de entrenamiento.
 * Crea un organizador, carga los datos, forma los grupos y muestra el resumen.
 * 
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
    OrganizadorGrupos organizador = new OrganizadorGrupos();
    organizador.cargarDatos();
    organizador.formarGrupos();
    organizador.mostrarResumen();
}
}
