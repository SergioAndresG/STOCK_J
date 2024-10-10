package Controlador;

import Modelo.Producto;
import Modelo.gestionProductos;
import Vista.Vista;

public class Controlador {
    private gestionProductos modelo;
    private Vista vista;

    public Controlador(gestionProductos modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mostrarMenu() {
        boolean salir = false;

        while(!salir) {
            switch (this.vista.mostrarMenu()) {
                case "1":
                    this.insertarProducto();
                    break;
                case "2":
                    this.buscarProducto();
                    break;
                case "3":
                    this.actualizarProducto();
                    break;
                case "4":
                    this.eliminarProducto();
                    break;
                case "5":
                    salir = true;
                    this.vista.mostrarMensaje("Gracias por usar el sistema");
                    break;
                default:
                    this.vista.mostrarMensaje("Opción no válida, intente de nuevo");
            }
        }

    }

    private void insertarProducto() {
        String nombre = this.vista.pedirNombre();
        int cantidad = this.vista.pedirCantidad();
        float precio = this.vista.pedirPrecio();
        int gestionadoPor = this.vista.pedirGestionadoPor();

        Producto p = new Producto(nombre, cantidad, precio, gestionadoPor);
        if (this.modelo.insertarProducto(p)) {
            this.vista.mostrarMensaje("Producto insertado correctamente");
        } else {
            this.vista.mostrarMensaje("Error al insertar el producto o ya existe");
        }

    }

    private void buscarProducto() {
        int id = this.vista.pedirId();
        Producto producto = this.modelo.BuscarPorId(id);
        if (producto != null) {
            this.vista.mostrarProducto(producto.toString());
        } else {
            this.vista.mostrarMensaje("Producto no encontrado");
        }

    }

    private void actualizarProducto() {
        int id = this.vista.pedirId();
        Producto producto = this.modelo.BuscarPorId(String.valueOf(id));
        if (producto != null) {
            producto.setNombreProducto(this.vista.pedirNombre());
            producto.setCantidad(this.vista.pedirCantidad());
            producto.setPrecio(this.vista.pedirPrecio());
            producto.setGestionadoPor(this.vista.pedirGestionadoPor());

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
        int id = this.vista.pedirId();
        if (this.modelo.eliminarProducto(String.valueOf(id)){
            this.vista.mostrarMensaje("Producto eliminado correctamente");
        } else {
            this.vista.mostrarMensaje("Error al eliminar el producto");
        }

    }
}
