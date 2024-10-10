package Vista;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Vista {
    public Vista() {
    }

    public String mostrarMenu() {
        String menu = "Seleccione una opción:\n1. Insertar producto\n2. Buscar producto\n3. Actualizar producto\n4. Eliminar producto\n5. Salir\n";
        return JOptionPane.showInputDialog(menu);
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

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog((Component)null, mensaje);
    }

    public void mostrarProducto(String producto) {
        JOptionPane.showMessageDialog((Component)null, producto);
    }
}