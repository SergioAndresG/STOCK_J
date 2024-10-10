package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        this.conexion = (new Conexion()).Conecta();
    }

    public boolean insertarProducto(Producto p) {
        boolean resultado = false;
        Producto pb = this.BuscarReferencia(p.getReferencia());

        try {
            if (pb == null) {
                String sql = "insert into productos value(?,?,?,?)";
                this.ps = this.conexion.prepareStatement(sql);
                this.ps.setString(1, p.getReferencia());
                this.ps.setString(2, p.getNombre());
                this.ps.setFloat(3, p.getPrecio());
                this.ps.setInt(4, p.getCategoria());
                resultado = this.ps.executeUpdate() > 0;
                if (resultado) {
                    this.datos.put(p.getReferencia(), p);
                }
            } else {
                System.out.println("El producto ya esta registrado");
            }
        } catch (SQLException var5) {
            SQLException ex = var5;
            System.out.println("error al insertar: " + String.valueOf(ex));
        }

        return resultado;
    }

    public Producto BuscarReferencia(String ref) {
        Producto p = null;

        try {
            String sql = "select * from productos where Referencia=?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, ref);

            for(this.res = this.ps.executeQuery(); this.res.next(); p = new Producto(this.res.getString(1), this.res.getString(2), this.res.getFloat(3), this.res.getInt(4))) {
            }
        } catch (SQLException var4) {
        }

        return p;
    }

    public boolean actualizarProducto(Producto p) {
        boolean resultado = false;

        try {
            Producto pb = this.BuscarReferencia(p.getReferencia());
            if (pb == null) {
                String sql = "UPDATE productos SET Nombre=?, Precio=?, Categoria=? WHERE Referencia=?";
                this.conexion.prepareStatement(sql);
                PreparedStatement ps = this.conexion.prepareStatement(sql);
                ps.setString(1, p.getNombre());
                ps.setFloat(2, p.getPrecio());
                ps.setInt(3, p.getCategoria());
                ps.setString(4, p.getReferencia());
                resultado = ps.executeUpdate() > 0;
                if (resultado) {
                    this.datos.put(p.getReferencia(), p);
                }
            } else {
                System.out.println("El producto ya se ha actualizado");
            }
        } catch (SQLException var6) {
            SQLException ex = var6;
            System.out.println("Error al actualizar: " + String.valueOf(ex));
        }

        return resultado;
    }

    public boolean eliminarProducto(String ref) {
        boolean resultado = false;

        try {
            String sql = "DELETE FROM productos WHERE Referencia=?";
            this.ps = this.conexion.prepareStatement(sql);
            this.ps.setString(1, ref);
            resultado = this.ps.executeUpdate() > 0;
            if (resultado) {
                this.datos.remove(ref);
                System.out.println("El producto se ha eliminado ");
            }
        } catch (SQLException var4) {
            SQLException ex = var4;
            System.out.println("Error al eliminar: " + String.valueOf(ex));
        }

        return resultado;
    }
}
