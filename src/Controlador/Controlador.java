package Controlador;

import Modelo.ArchivoRegistro;
import Modelo.GestorInstrumentos;
import Modelo.Instrumento;
import Vista.Vista;

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
        int opcion=vista.mostrarMenu();
        ejecutarOpcion(opcion);
    }

    public void ejecutarOpcion(int opcion){
        do {
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del instrumento:");
                    Scanner scanNombre = new Scanner(System.in);
                    String newnombre = scanNombre.next();

                    System.out.println("Ingresa el tipo de instrumento (identificar/manejar):");
                    Scanner scanTipo = new Scanner(System.in);
                    String newtipo = scanTipo.next();

                    System.out.println("Ingresa la forma del instrumento (Ej. test):");
                    Scanner scanForma = new Scanner(System.in);
                    String newforma = scanForma.next();

                    System.out.println("Ingresa la condicion que mide el instrumento:");
                    Scanner scanCondicion = new Scanner(System.in);
                    String newcondicion = scanCondicion.next();

                    System.out.println("Ingresa el autor del instrumento:");
                    Scanner scanAutor = new Scanner(System.in);
                    String newautor = scanAutor.next();

                    boolean newvalido;
                    System.out.println("¿El instrumento es valido?\n1)Si\n2)No");
                    Scanner scanValidez = new Scanner(System.in);
                    int newvalidez = scanValidez.nextInt();
                    if (newvalidez == 1) {
                        newvalido = true;
                    } else {
                        newvalido = false;
                    }

                    boolean newconfiable;
                    System.out.println("¿El instrumento es confiable?\n1)Si\n2)No");
                    Scanner scanConfiabilidad = new Scanner(System.in);
                    int newconfiabilidad = scanConfiabilidad.nextInt();
                    if (newconfiabilidad == 1) {
                        newconfiable = true;
                    } else {
                        newconfiable = false;
                    }

                    System.out.println("Ingresa la cita del instrumento:");
                    Scanner scanCita = new Scanner(System.in);
                    String newcita = scanCita.next();

                    System.out.println("Ingresa la clave del instrumento:");
                    Scanner scanClave = new Scanner(System.in);
                    int newclave = scanClave.nextInt();

                    Instrumento newInstrument = new Instrumento(newnombre, newclave, newtipo, newcondicion, newautor,
                            newvalido, newconfiable, newcita);
                    gestor.agregarInstrumento(newInstrument);
                    iniciar();
                    break;

                case 2:
                    vista.pedirCadena("Ingrese la clave del instrumento a eliminar: ");
                    Scanner scanclave = new Scanner(System.in);
                    int Clave = scanclave.nextInt();
                    gestor.eliminarPorClave(Clave);
                    iniciar();
                    break;

                case 3:
                    String autor = vista.pedirCadena("Ingrese el/la autor@: ");
                    vista.mostrarInstrumentos(gestor.buscarPorAutor(autor));
                    iniciar();
                    break;

                case 4:
                    String tipo = vista.pedirCadena("Ingrese el tipo del instrumento: ");
                    vista.mostrarInstrumentos(gestor.buscarPorTipo(tipo));
                    iniciar();
                    break;

                case 5:
                    String forma = vista.pedirCadena("Ingrese la forma del instrumento: ");
                    vista.mostrarInstrumentos(gestor.buscarPorForma(forma));
                    iniciar();
                    break;

                case 6:
                    String condicion = vista.pedirCadena("Ingrese la condicion: ");
                    vista.mostrarInstrumentos(gestor.buscarPorCondicion(condicion));
                    iniciar();
                    break;

                case 7:
                    boolean Validity;
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
                    }

                    vista.mostrarInstrumentos(gestor.buscarPorEvaluacion(evaluado));
                    iniciar();
                    break;

                case 8:
                    boolean Valido;
                    boolean Confiable;
                    boolean evaluated;

                    String condition = vista.pedirCadena("Ingrese la condicion: ");

                    System.out.println("¿El instrumento es valido?\n1)Si\n2)No");
                    Scanner scanvalido = new Scanner(System.in);
                    int valido = scanvalido.nextInt();
                    if (valido == 1) {
                        Valido = true;
                    } else {
                        Valido = false;
                    }

                    System.out.println("¿El instrumento es confiable?\n1)Si\n2)No");
                    Scanner scanconfiable = new Scanner(System.in);
                    int confiable = scanconfiable.nextInt();
                    if (confiable == 1) {
                        Confiable = true;
                    } else {
                        Confiable = false;
                    }

                    if (Valido && Confiable) {
                        evaluated = true;
                    } else {
                        evaluated = false;
                    }

                    vista.mostrarInstrumentos(gestor.buscarPorCondicionYEvaluacion(condition, evaluated));
                    iniciar();
                    break;

                case 9:
                    vista.mostrarInstrumentos(gestor.obtenerTodosOrdenadosPorClave());
                    iniciar();
                    break;

                case 10:
                    vista.mostrarInstrumentos(gestor.obtenerTodosOrdenadosPorAutor());
                    iniciar();
                    break;

                case 11:
                    guardarEnArchivo();
                    iniciar();
                    break;

                case 12:
                    cargarDesdeArchivo();
                    iniciar();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.\n");
                    iniciar();
                    break;
            }
        }while(opcion!=0);
    }

    public void cargarDesdeArchivo(){
        archivo.cargarDatos(gestor.getInventario());
    }

    public void guardarEnArchivo(){
        archivo.guardarDatos(gestor.getInventario());
    }
}
