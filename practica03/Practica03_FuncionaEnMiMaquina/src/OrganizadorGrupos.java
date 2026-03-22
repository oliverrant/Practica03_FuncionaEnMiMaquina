import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que organiza la formación de grupos de entrenamiento.
 * Gestiona el registro de aspirantes y voluntarios, la asignación de paquetes
 * y campos de entrenamiento, y la formación de grupos según las reglas establecidas.
 * 
 */
public class OrganizadorGrupos {
    private RegistroAspirantes aspirantes;
    private RegistroVoluntarios voluntarios;
    private List<Grupo> grupos;
    private DirectorPaquetes director;


     /**
     * Constructor de la clase OrganizadorGrupos.
     * Inicializa los registros con capacidad para 10 elementos cada uno,
     * una lista vacía de grupos y un director de paquetes.
     */
    public OrganizadorGrupos() {
        aspirantes = new RegistroAspirantes(10);
        voluntarios = new RegistroVoluntarios(10);
        grupos = new ArrayList<>();
        director = new DirectorPaquetes(new PaqueteBuilderConcreto());
    }

    /**
     * Carga los datos iniciales de voluntarios y aspirantes.
     * Se añaden 5 ninjas voluntarios y 10 aspirantes con diferentes características.
     */
    public void cargarDatos() {
        //Voluntarios
        voluntarios.agregar(new Ninja("Kakashi", 26, Clan.NACA, Rango.JONIN, 6));
        voluntarios.agregar(new Ninja("D.B. Cooper", 24, Clan.MORTALIKA, Rango.CHUNIN, 5));
        voluntarios.agregar(new Ninja("Mango", 15, Clan.FUCHIHA, Rango.JONIN, 6));
        voluntarios.agregar(new Ninja("Melón", 17, Clan.OSOMAKI, Rango.CHUNIN, 4));
        voluntarios.agregar(new Ninja("Paco el de las tortas", 16, Clan.OSOMAKI, Rango.GENIN, 4));
        voluntarios.agregar(new Ninja("Juan Mecanico", 24, Clan.FUCHIHA, Rango.JONIN, 6));
        voluntarios.agregar(new Ninja("Bobby Fisher", 22, Clan.AKIPICHI, Rango.CHUNIN, 5));
        
        //Aspirantes
        aspirantes.agregar(new Aspirante("Raruto", 12, Clan.OSOMAKI, 2));
        aspirantes.agregar(new Aspirante("Potential Man", 12, Clan.FUCHIHA, 3));
        aspirantes.agregar(new Aspirante("Mi gallo Itadori", 12, Clan.MORTALIKA, 1));
        aspirantes.agregar(new Aspirante("Fresa", 12, Clan.OSOMAKI, 1));
        aspirantes.agregar(new Aspirante("Guayaba", 12, Clan.FUCHIHA, 3));
        aspirantes.agregar(new Aspirante("Sandía", 12, Clan.MORTALIKA, 2));
        aspirantes.agregar(new Aspirante("Ringo Starr", 12, Clan.NACA, 2));
        aspirantes.agregar(new Aspirante("Regresa Valeria por favor", 12, Clan.AKIPICHI, 3));
        aspirantes.agregar(new Aspirante("Taylor Swift", 12, Clan.MORTALIKA, 1));
        aspirantes.agregar(new Aspirante("Canserbero", 12, Clan.FUCHIHA, 2));
        aspirantes.agregar(new Aspirante("Nabucodonosor", 12, Clan.NACA, 3));
        aspirantes.agregar(new Aspirante("Dijkstra y sus dijks", 12, Clan.AKIPICHI, 2));
        aspirantes.agregar(new Aspirante("Patricio Estrella", 12, Clan.OSOMAKI, 1));
    }

    /**
     * Forma los grupos asignando líderes, aspirantes, paquetes y campos.
     * El número de aspirantes por grupo depende del rango del líder:
     * - GENIN: 1 aspirante
     * - CHUNIN: 2 aspirantes
     * - JONIN: 3 aspirantes
     * Permite al usuario elegir entre paquete personalizado o automático.
     */
    public void formarGrupos() {
        Iterator<Ninja> itNinjas = voluntarios.getIterator();
        Iterator<Aspirante> itAspirantes = aspirantes.getIterator();
        Scanner scanner = new Scanner(System.in);

        while (itNinjas.hasNext() && itAspirantes.hasNext()) {
            // asignar líder y aspirantes
            Ninja lider = itNinjas.next();
            Grupo grupo = new Grupo(lider);

            int max = lider.getRango() == Rango.GENIN ? 1 : 
                    lider.getRango() == Rango.CHUNIN ? 2 : 3;

            for (int i = 0; i < max && itAspirantes.hasNext(); i++) {
                grupo.agregarAlGrupo(itAspirantes.next());
            }

            // el usuario elige el paquete
            PaqueteHerramientas paquete = elegirPaquete(scanner, grupo);
            grupo.setPaquete(paquete);

            //asignar campo automáticamente
            grupo.setCampo(asignarCampo(grupo));

            //mostrar resumen del grupo inmediatamente
            System.out.println(grupo);

            grupos.add(grupo);
        }

        // disculparse con aspirantes sobrantes
        while (itAspirantes.hasNext()) {
            Aspirante sobrante = itAspirantes.next();
            System.out.println("Lo sentimos, " + sobrante.getNombre() + ", no hay más ninjas disponibles.");
        }

        // resumen general al final
         mostrarResumen();
    
        scanner.close();
        
    }

    /**
     * Permite al usuario elegir el tipo de paquete para el grupo.
     * 
     * @param scanner Scanner para entrada del usuario
     * @param grupo Grupo para el cual se asignará el paquete
     * @return PaqueteHerramientas seleccionado
     */
    private PaqueteHerramientas elegirPaquete(Scanner scanner, Grupo grupo) {
        String opcion;
        do {
            System.out.println("¿Desea asignar un paquete personalizado al grupo de "
                + grupo.getLider().getNombre() + "? (s/n)");
            opcion = scanner.next();
            if (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                System.out.println("Opción inválida, ingrese s o n.");
            }
        } while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n"));

        if (opcion.equalsIgnoreCase("s")) {
            return crearPaquetePersonalizado(scanner);
        } else {
            int nivelTotal = grupo.getNivelTotal();
            if (nivelTotal <= 7) {
                System.out.println("Se asignó automáticamente el Paquete Básico.");
                return director.construirBasico();
            } else if (nivelTotal <= 11) {
                System.out.println("Se asignó automáticamente el Paquete Avanzado.");
                return director.construirAvanzado();
            } else {
                System.out.println("Se asignó automáticamente el Paquete Táctico.");
                return director.construirTactico();
            }
        }        
    }

    /**
     * Crea un paquete personalizado solicitando al usuario las cantidades.
     * 
     * @param scanner Scanner para entrada del usuario
     * @return PaqueteHerramientas personalizado
     */
    private PaqueteHerramientas crearPaquetePersonalizado(Scanner scanner) {
        PaqueteBuilderConcreto builder = new PaqueteBuilderConcreto();
        builder.agregarKunai(pedirCantidad(scanner, "Kunais"));
        builder.agregarShuriken(pedirCantidad(scanner, "Shurikens"));
        builder.agregarPapelBomba(pedirCantidad(scanner, "Papeles Bomba"));
        builder.agregarBombaHumo(pedirCantidad(scanner, "Bombas de Humo"));
        builder.agregarBotiquin(pedirCantidad(scanner, "Botiquines"));
        return builder.build();
    }

    /**
     * Solicita al usuario una cantidad positiva para una herramienta.
     * 
     * @param scanner Scanner para entrada del usuario
     * @param herramienta Nombre de la herramienta para mostrar al usuario
     * @return Cantidad ingresada por el usuario (no negativa)
     */
    private int pedirCantidad(Scanner scanner, String herramienta) {
        int cantidad = -1;
        do {
            System.out.println("¿Cuántos " + herramienta + "?");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                if (cantidad < 0) {
                    System.out.println("Ingrese un número positivo.");
                }
            } else {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
        } while (cantidad < 0);
        return cantidad;
    }

    /**
     * Asigna un campo de entrenamiento basado en el nivel total del grupo.
     * 
     * @param grupo Grupo para el cual se asignará el campo
     * @return CampoEntrenamiento correspondiente
     */

    private CampoEntrenamiento asignarCampo(Grupo grupo) {
        return CampoFactory.crearCampo(grupo.getNivelTotal());
    }

    /**
     * Muestra un resumen general de todos los grupos formados.
     * Incluye la información detallada de cada grupo.
     */
    public void mostrarResumen() {
        System.out.println("========== RESUMEN GENERAL ==========");
        for (Grupo g : grupos) {
            System.out.println("-------------------------------------");
            System.out.println(g);
        }
        System.out.println("=====================================");
    }
}
