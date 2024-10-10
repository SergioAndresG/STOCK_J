package Vista;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Vista {
    public Vista() {
    }

    public String pedirReferencia() {
        return JOptionPane.showInputDialog("Ingrese la referencia del producto:");
    }

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre del producto:");
    }

    public float pedirPrecio() {
        return Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
    }

    public int pedirCategoria() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoría del producto (número):"));
    }

    public String obtenerTipoUsuario() {
        return JOptionPane.showInputDialog("Inserta el tipo de usuario que eres:");
    }

    public String obtenerContraseñaUsuario() {
        return JOptionPane.showInputDialog("Ingresa la contraseña:");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog((Component)null, mensaje);
    }

    public void mostrarProducto(String producto) {
        JOptionPane.showMessageDialog((Component)null, producto);
    }

    public int mostrarMenu(String tipoUsuario) {
        String[] opciones = tipoUsuario.equals("jefe") ?
                new String[]{"Agregar Usuario", "Actualizar Usuario", "Eliminar Usuario", "Mostrar Usuarios", "Salir del menu"} :
                new String[]{"Buscar Usuario", "Actualizar Usuario", "Mostrar Usuarios", "Salir del menu"};

        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return opcion != null ? java.util.Arrays.asList(opciones).indexOf(opcion) + 1 : 5;
    }
}