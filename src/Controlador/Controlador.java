package Controlador;

import Modelo.Producto;
import Modelo.gestionProductos;
import Vista.Vista;

import java.util.List;
//controlador

public class Controlador {
    private gestionProductos modelo;
    private Vista vista;

    public Controlador(gestionProductos modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            switch (this.vista.mostrarMenu()) {
                case "1":
                    this.insertarProducto();
                    break;
                case "2":
                    this.buscarProductoPorId();
                    break;
                case "3":
                    this.mostrarProductos();
                    break;
                case "4":
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
        int gestionadoPor = this.vista.pedirIdUsuario(); // aqui va a pedir el id del usuario que gestiona el producto
        Producto p = new Producto(0, nombre, precio, cantidad, gestionadoPor);
        if (this.modelo.insertarProducto(p)) {
            this.vista.mostrarMensaje("Producto insertado correctamente");
        } else {
            this.vista.mostrarMensaje("Error al insertar el producto o ya existe");
        }
    }

    private void buscarProductoPorId() {
        int id = this.vista.pedirId();
        Producto producto = this.modelo.buscarProductoPorId(id);
        if (producto != null) {
            this.vista.mostrarProducto(producto.toString());
        } else {
            this.vista.mostrarMensaje("Producto no encontrado");
        }
    }


    private void mostrarProductos() {
        List<Producto> productos = this.modelo.obtenerTodosLosProductos();
        if (!productos.isEmpty()) {
            for (Producto producto : productos) {
                this.vista.mostrarProducto(producto.toString());
            }
        } else {
            this.vista.mostrarMensaje("No hay productos en la base de datos");
        }
    }
}
