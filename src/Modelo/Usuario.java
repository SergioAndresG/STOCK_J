package Modelo;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String documento;
    private String correoElectronico;
    private String contraseña;
    private int rolId;
    private String nombreEmprendimiento;

    // Constructor vacío
    public Usuario() {}

    // Constructor con todos los campos
    public Usuario(int id, String nombreUsuario, String documento, String correoElectronico, String contraseña, int rolId, String nombreEmprendimiento) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.documento = documento;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rolId = rolId;
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    // Método toString() opcional para depuración
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", documento='" + documento + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", rolId=" + rolId +
                ", nombreEmprendimiento='" + nombreEmprendimiento + '\'' +
                '}';
    }
}

