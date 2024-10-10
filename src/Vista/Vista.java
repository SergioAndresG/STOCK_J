package Vista;

import javax.swing.JOptionPane;
//vista

public class Vista {

    public String mostrarMenu() {
        String menu = "1. Insertar Producto\n" +
                "2. Buscar Producto por ID\n" +
                "3. Mostrar Todos los Productos\n" +
                "4. Salir\n" +
                "Elige una opción:";
        return JOptionPane.showInputDialog(menu);  // Mostrar el menú y capturar la opción elegida
    }

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Introduce el nombre del producto:");
    }

    public float pedirPrecio() {
        return Float.parseFloat(JOptionPane.showInputDialog("Introduce el precio del producto:"));
    }

    public int pedirCantidad() {
        return Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad del producto:"));
    }

    public int pedirId() {
        return Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del producto:"));
    }

    public int pedirIdUsuario() {
        return Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del usuario que gestiona el producto:"));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarProducto(String producto) {
        JOptionPane.showMessageDialog(null, "Producto encontrado:\n" + producto);
    }
}
