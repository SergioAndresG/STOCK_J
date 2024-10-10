package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gestionProductos {
    Conexion cnn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet res;

    public gestionProductos() {
        this.conexion = this.cnn.Conecta();
    }

    public boolean insertarProducto(Producto p) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO productos (nombreProducto, cantidad, precio, gestionado_por) VALUES (?, ?, ?, ?)";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, p.getNombre());
            this.ps.setInt(2, p.getCantidad()); // Cantidad
            this.ps.setFloat(3, p.getPrecio()); // Precio
            this.ps.setInt(4, p.getGestionadoPor()); // ID del usuario que gestiona el producto
            resultado = this.ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e);
        }
        return resultado;
    }

    public Producto buscarProductoPorId(int id) {
        Producto p = null;
        try {
            String sql = "SELECT * FROM productos WHERE id = ?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setInt(1, id);
            this.res = this.ps.executeQuery();

            if (res.next()) {
                p = new Producto(res.getInt("id"), res.getString("nombreProducto"),
                        res.getFloat("precio"), res.getInt("cantidad"), res.getInt("gestionado_por"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e);
        }
        return p;
    }

    public boolean actualizarProducto(Producto p) {
        boolean resultado = false;
        try {
            String sql = "UPDATE productos SET nombreProducto = ?, cantidad = ?, precio = ?, gestionado_por = ? WHERE id = ?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, p.getNombre());
            this.ps.setInt(2, p.getCantidad());
            this.ps.setFloat(3, p.getPrecio());
            this.ps.setInt(4, p.getGestionadoPor());
            this.ps.setInt(5, p.getId());
            resultado = this.ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e);
        }
        return resultado;
    }

    public boolean eliminarProducto(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM productos WHERE id = ?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setInt(1, id);
            resultado = this.ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e);
        }
        return resultado;
    }

    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos";
            this.ps = this.conexion.prepareStatement(sql);
            this.res = this.ps.executeQuery();

            while (res.next()) {
                Producto p = new Producto(res.getInt("id"), res.getString("nombreProducto"),
                        res.getFloat("precio"), res.getInt("cantidad"), res.getInt("gestionado_por"));
                productos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e);
        }
        return productos;
    }
}
