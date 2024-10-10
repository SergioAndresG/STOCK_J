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
