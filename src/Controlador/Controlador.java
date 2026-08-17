package Controlador;

import Modelo.ArchivoRegistro;
import Modelo.GestorInstrumentos;
import Modelo.Instrumento;
import Vista.Vista;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    private Vista vista;
    private ArchivoRegistro archivo;
    private GestorInstrumentos gestor;

    public Controlador(Vista vista, ArchivoRegistro archivo, GestorInstrumentos gestor) {
        this.vista = vista;
        this.archivo = archivo;
        this.gestor = gestor;
    }

    public void iniciar(){
        int opcion;

        do {
            opcion = vista.mostrarMenu();
            ejecutarOpcion(opcion);
        }while(opcion!=0);
    }

    public void ejecutarOpcion(int opcion){
            switch (opcion) {
                case 1:
                    HashMap<String, Object> datos = vista.pedirDatosInstrumento();

                    String newnombre = (String) datos.get("nombre");
                    int newclave = Integer.parseInt((String) datos.get("clave"));
                    String newtipo = (String) datos.get("tipo");
                    String newcondicion = (String) datos.get("condicion");
                    String newautor = (String) datos.get("autor");
                    boolean newvalido = (boolean) datos.get("validez");
                    boolean newconfiable = (boolean) datos.get("confiabilidad");
                    String newcita = (String) datos.get("cita");
                    String newforma = (String) datos.get("forma");

                    Instrumento newInstrument = new Instrumento(newnombre, newclave, newtipo, newcondicion, newautor,
                            newvalido, newconfiable, newcita, newforma);
                    gestor.agregarInstrumento(newInstrument);
                    break;

                case 2:
                    vista.pedirCadena("Ingrese la clave del instrumento a eliminar: ");
                    Scanner scanclave = new Scanner(System.in);
                    int Clave = scanclave.nextInt();
                    gestor.eliminarPorClave(Clave);
                    guardarEnArchivo();

                    break;

                case 3:
                    String autor = vista.pedirCadena("Ingrese el/la autor@: ");
                    vista.mostrarInstrumentos(gestor.buscarPorAutor(autor));

                    break;

                case 4:
                    String tipo = vista.pedirCadena("Ingrese el tipo del instrumento: ");
                    vista.mostrarInstrumentos(gestor.buscarPorTipo(tipo));

                    break;

                case 5:
                    String forma = vista.pedirCadena("Ingrese la forma del instrumento: ");
                    vista.mostrarInstrumentos(gestor.buscarPorForma(forma));

                    break;

                case 6:
                    String condicion = vista.pedirCadena("Ingrese la condicion: ");
                    vista.mostrarInstrumentos(gestor.buscarPorCondicion(condicion));

                    break;

                case 7:
                   /** boolean Validity;
                    boolean Confiability;
                    boolean evaluado;

                    System.out.println("¿El instrumento es valido?\n1)Si\n2)No");
                    Scanner scanvalidez = new Scanner(System.in);
                    int validity = scanvalidez.nextInt();
                    if (validity == 1) {
                        Validity = true;
                    } else {
                        Validity = false;
                    }

                    System.out.println("¿El instrumento es confiable?\n1)Si\n2)No");
                    Scanner scanconfiabilidad = new Scanner(System.in);
                    int confiability = scanconfiabilidad.nextInt();
                    if (confiability == 1) {
                        Confiability = true;
                    } else {
                        Confiability = false;
                    }

                    if (Validity && Confiability) {
                        evaluado = true;
                    } else {
                        evaluado = false;
                    }*/

                   HashMap<String,Boolean> evaluacion = vista.buscarPorEvaluacion();
                   if (evaluacion.containsKey("validez")) {
                       vista.mostrarInstrumentos(gestor.buscarPorEvaluacionValidez(evaluacion.get("validez")));
                   }

                   else if (evaluacion.containsKey("confiabilidad")) {
                       vista.mostrarInstrumentos(gestor.buscarPorEvaluacionConfiabilidad(evaluacion.get("confiabilidad")));
                   }
                   else{
                       vista.mostrarMensaje("Esa evaluación no existe");
                   }


                    break;

                case 8:
//                    boolean Valido;
//                    boolean Confiable;
//                    boolean evaluated;
//
//                    String condition = vista.pedirCadena("Ingrese la condicion: ");
//
//                    System.out.println("¿El instrumento es valido?\n1)Si\n2)No");
//                    Scanner scanvalido = new Scanner(System.in);
//                    int valido = scanvalido.nextInt();
//                    if (valido == 1) {
//                        Valido = true;
//                    } else {
//                        Valido = false;
//                    }
//
//                    System.out.println("¿El instrumento es confiable?\n1)Si\n2)No");
//                    Scanner scanconfiable = new Scanner(System.in);
//                    int confiable = scanconfiable.nextInt();
//                    if (confiable == 1) {
//                        Confiable = true;
//                    } else {
//                        Confiable = false;
//                    }
//
//                    if (Valido && Confiable) {
//                        evaluated = true;
//                    } else {
//                        evaluated = false;
//                    }
                    HashMap<String,Boolean> condicionYEvaluacion = vista.buscarPorEvaluacion();
                    String cadena = vista.pedirCadena("Ingresa la condición: ");
                    if (condicionYEvaluacion.containsKey("validez")) {
                        vista.mostrarInstrumentos(gestor.buscarPorCondicionYEvaluacionValidez(cadena,condicionYEvaluacion.get("validez")));
                    }

                    else if (condicionYEvaluacion.containsKey("confiabilidad")) {
                        vista.mostrarInstrumentos(gestor.buscarPorCondicionYEvaluacionConfiabilidad(cadena,condicionYEvaluacion.get("confiabilidad")));
                    }
                    else{
                        vista.mostrarMensaje("Esa evaluación o condición no existen");
                    }


                    break;

                case 9:
                    vista.mostrarInstrumentos(gestor.ordenarPorClave());

                    break;

                case 10:
                    guardarEnArchivo();

                    break;

                case 11:
                    cargarDesdeArchivo();
                    vista.mostrarInstrumentos(gestor.getInventario());

                    break;

                case 0:
                    System.out.println("Saliendo del sistema\n");
                    break;

                default:
                    System.out.println("Opcion invalida.\n");

                    break;
            }

    }

    public void cargarDesdeArchivo(){
        archivo.cargarDatos(gestor.getInventario());
    }

    public void guardarEnArchivo(){
        archivo.guardarDatos(gestor.getInventario());
    }
}
