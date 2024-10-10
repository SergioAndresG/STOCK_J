package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class gestionProductos {
    Conexion cnn = new Conexion();
    Connection conexion;
    Statement st;
    ResultSet res;
    PreparedStatement ps;
    HashMap<String, Producto> datos;

    public gestionProductos() {
        this.conexion = this.cnn.Conecta();
        this.st = null;
        this.res = null;
        this.ps = null;
        this.datos = new HashMap();
    }

    public boolean insertarProducto(Producto p) {
        boolean resultado = false;

        try {
                String sql = "INSERT INTO productos (nombreProducto, cantidad, precio, gestionado_por) VALUES (?, ?, ?, ?)";
                this.ps.setString(1, p.getNombreProducto());
                this.ps.setInt(2, p.getCantidad());
                this.ps.setFloat(3, p.getPrecio());
                this.ps.setInt(4, p.getGestionadoPor());
                resultado = this.ps.executeUpdate() > 0;
                if (resultado) {
                    this.datos.put(String.valueOf(p.getId()), p);
                }

        } catch (SQLException var5) {
            SQLException ex = var5;
            System.out.println("error al insertar: " + String.valueOf(ex));
        }

        return resultado;
    }

    public Producto BuscarPorId(String id) {
        Producto p = null;

        try {
            String sql = "select * from productos where id=?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, id);
            this.res = this.ps.executeQuery();

            if (this.res.next()) {
                p = new Producto(
                        this.res.getInt("id"),
                        this.res.getString("nombreProducto"),
                        this.res.getInt("cantidad"),
                        this.res.getFloat("precio"),
                        this.res.getInt("gestionado_por")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar referencia: " + ex.getMessage());
        }

        return p;
    }

    public boolean actualizarProducto(Producto p) {
        boolean resultado = false;

        try {
                String sql = "UPDATE productos SET nombreProducto=?, cantidad=?, precio=?, gestionado_por=? WHERE id=?";
                this.conexion.prepareStatement(sql);
                PreparedStatement ps = this.conexion.prepareStatement(sql);
                ps.setString(1, p.getNombreProducto());
                ps.setInt(2, p.getCantidad());
                ps.setFloat(3, p.getPrecio());
                ps.setInt(4, p.getGestionadoPor());
                resultado = ps.executeUpdate() > 0;
                if (resultado) {
                    this.datos.put(String.valueOf(p.getId()), p);
                }
        } catch (SQLException var6) {
            SQLException ex = var6;
            System.out.println("Error al actualizar: " + String.valueOf(ex));
        }

        return resultado;
    }

    public boolean eliminarProducto(String id) {
        boolean resultado = false;

        try {
            String sql = "DELETE FROM productos WHERE id=?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, id);
            resultado = this.ps.executeUpdate() > 0;
            if (resultado) {
                this.datos.remove(id);
                System.out.println("El producto se ha eliminado ");
            }
        } catch (SQLException var4) {
            SQLException ex = var4;
            System.out.println("Error al eliminar: " + String.valueOf(ex));
        }

        return resultado;
    }
}
