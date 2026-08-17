import Controlador.Controlador;
import Vista.Vista;
import Modelo.*;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        ArchivoRegistro archivo = new ArchivoRegistro();
        GestorInstrumentos gestor = new GestorInstrumentos();
        Controlador controlador = new Controlador(vista, archivo, gestor);
        controlador.iniciar();
    }

}