package Modelo;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int cantidad;
    private int gestionadoPor;  // Campo nuevo para el ID del usuario que gestiona el producto

    public Producto(int id, String nombre, float precio, int cantidad, int gestionadoPor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.gestionadoPor = gestionadoPor;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getGestionadoPor() {
        return gestionadoPor;
    }

    public void setGestionadoPor(int gestionadoPor) {
        this.gestionadoPor = gestionadoPor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", gestionadoPor=" + gestionadoPor +
                '}';
    }
}
