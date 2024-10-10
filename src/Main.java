import Controlador.Controlador;
import Modelo.gestionProductos;
import Vista.Vista;

public class Main {
    public Main(){

    }
    public static void main(String[] args) {
        gestionProductos Modelo = new gestionProductos();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(Modelo, vista);
        controlador.mostrarMenu();
    }
}
