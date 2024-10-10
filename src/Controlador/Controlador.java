package Controlador;

import Modelo.Producto;
import Modelo.Usuario;
import Modelo.gestionProductos;
import Vista.Vista;

public class Controlador {
    private gestionProductos modelo;
    private Vista vista;

    public Controlador(gestionProductos modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void ejecutarMenu() {
        while (true) {
            String tipoUsuario = vista.obtenerTipoUsuario();
            String contraseña = vista.obtenerContraseñaUsuario();

            Usuario usuario = modelo.buscarUsuarioPorRolYContraseña(tipoUsuario, contraseña);
            if (usuario == null) {
                vista.mostrarMensaje("Tipo de usuario o contraseña incorrecta");
                continue;
            }

            vista.mostrarMensaje("¡Bienvenido, " + tipoUsuario + "!");
            int opcion;
            do {
                opcion = vista.mostrarMenu(tipoUsuario);
                manejarOpcionMenu(tipoUsuario, opcion);
            } while (opcion != 5);
        }
    }


    public void manejarOpcionMenu(String tipoUsuario, int opcion) {
        switch (tipoUsuario) {
            case "jefe":
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        vista.mostrarMensaje("Saliendo del menú");
                        break;
                    default:
                        vista.mostrarMensaje("Opción no válida");
                        break;
                }
                break;
            case "administrador":
            case "empleado":
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        vista.mostrarMensaje("Saliendo del menú");
                        break;
                    default:
                        vista.mostrarMensaje("Opción no válida");
                        break;
                }
                break;
            default:
                vista.mostrarMensaje("Tipo de usuario no reconocido");
                break;
        }
    }

    private void insertarProducto() {
        String ref = this.vista.pedirReferencia();
        String nombre = this.vista.pedirNombre();
        float precio = this.vista.pedirPrecio();
        int categoria = this.vista.pedirCategoria();
        Producto p = new Producto(ref, nombre, precio, categoria);
        if (this.modelo.insertarProducto(p)) {
            this.vista.mostrarMensaje("Producto insertado correctamente");
        } else {
            this.vista.mostrarMensaje("Error al insertar el producto o ya existe");
        }

    }

    private void buscarProducto() {
        String ref = this.vista.pedirReferencia();
        Producto producto = this.modelo.BuscarReferencia(ref);
        if (producto != null) {
            this.vista.mostrarProducto(producto.toString());
        } else {
            this.vista.mostrarMensaje("Producto no encontrado");
        }

    }

    private void actualizarProducto() {
        String ref = this.vista.pedirReferencia();
        Producto producto = this.modelo.BuscarReferencia(ref);
        if (producto != null) {
            producto.setNombre(this.vista.pedirNombre());
            producto.setPrecio(this.vista.pedirPrecio());
            producto.setCategoria(this.vista.pedirCategoria());
            if (this.modelo.actualizarProducto(producto)) {
                this.vista.mostrarMensaje("Producto actualizado correctamente");
            } else {
                this.vista.mostrarMensaje("Error al actualizar el producto");
            }
        } else {
            this.vista.mostrarMensaje("Producto no encontrado");
        }

    }

    private void eliminarProducto() {
        String ref = this.vista.pedirReferencia();
        if (this.modelo.eliminarProducto(ref)) {
            this.vista.mostrarMensaje("Producto eliminado correctamente");
        } else {
            this.vista.mostrarMensaje("Error al eliminar el producto");
        }

    }
}
