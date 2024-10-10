package Modelo;

public class Producto {
    private int id; // Este campo representa el id auto-incremental
    private String nombreProducto;
    private int cantidad; // Este campo refleja el stock del producto
    private float precio;
    private int gestionadoPor; // Campo que refleja quién gestiona el producto

    public Producto() {
    }

    public Producto(int id, String nombreProducto, int cantidad, float precio, int gestionadoPor) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.gestionadoPor = gestionadoPor;
    }

    public Producto(String nombre, int cantidad, float precio, int gestionadoPor) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getGestionadoPor() {
        return gestionadoPor;
    }

    public void setGestionadoPor(int gestionadoPor) {
        this.gestionadoPor = gestionadoPor;
    }


}
