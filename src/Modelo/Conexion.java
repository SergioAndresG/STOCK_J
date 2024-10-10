package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String db = "STOCK_J";
    private String url;
    private String user;
    private String pass;
    Connection conec;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/" + this.db;
        this.user = "root";
        this.pass = "123456";
        this.conec = null;
    }

    public Connection Conecta() {
        try {
            this.conec = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conexion ok");
        } catch (Exception var2) {
            Exception e = var2;
            System.out.println("Error en la conexion" + String.valueOf(e));
        }

        return this.conec;
    }
}
