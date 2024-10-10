package Modelo;

public class Producto {
    private String Referencia;
    private String Nombre;
    private float Precio;
    private int Categoria;

    public Producto() {
    }

    public Producto(String Referencia, String Nombre,float Precio, int Categoria) {
        this.Referencia = Referencia;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Categoria = Categoria;

    }


    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Referencia='" + Referencia + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Precio=" + Precio +
                ", Categoria=" + Categoria +
                '}';
    }
}
