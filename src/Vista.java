import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Vista {

    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }


    public int mostrarMenu(){
        System.out.println("--Menu Principal--");
        System.out.println("1. Agregar Instrumento");
        System.out.println("2. Eliminar por Clave");
        System.out.println("3. Buscar por Autor");
        System.out.println("4. Buscar por Tipo");
        System.out.println("5. Buscar por Forma");
        System.out.println("6. Buscar por Condicion");
        System.out.println("7. Buscar por Evaluacion");
        System.out.println("8. Buscar por Condicion y Evaluacion");
        System.out.println("9. Ordenados por Clave");
        System.out.println("10. Ordenados por Autor");
        System.out.println("11. Guardar en archivo");
        System.out.println("12. Cargar en archivo");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public HashMap<String,Object>pedirDatosInstrumento(){
        HashMap<String,Object>datos = new HashMap<>();

        System.out.println("Ingrese nuevo Instrumento");
        datos.put("nombre", pedirCadena("Nombre: "));
        datos.put("clave", pedirCadena("Clave: "));
        datos.put("tipo", pedirCadena("Tipo : "));
        datos.put("condicion", pedirCadena("Condición: "));
        datos.put("autor", pedirCadena("Autor: "));
        datos.put("validez", pedirCadena("¿Tiene validez? (si/no): ").equalsIgnoreCase("si"));
        datos.put("confiabilidad", pedirCadena("¿Tiene confiabilidad? (si/no): ").equalsIgnoreCase("si"));
        datos.put("cita", pedirCadena("Cita: "));

        return datos;
    }

    public String pedirCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarInstrumentos(List<Instrumento>lista){
        System.out.println("Mostrar Instrumentos");
        if (lista == null || lista.isEmpty()){
            System.out.println("No se encontro nada");
        } else {
            for(Instrumento inst:lista){
                System.out.println("->"+ inst);
            }
            System.out.println("Total encontrados:"+ lista.size());
        }

    }

    public void mostrarMensaje(String mensaje){
        System.out.println("Informacion:"+ mensaje);
    }

}
