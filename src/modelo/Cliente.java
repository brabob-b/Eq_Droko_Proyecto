package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private char tipoIdentificacion; // C: cédula, N: Nit
    private String numeroIdentificacion;
    private boolean empresa;
    private String nombre;
    private String email;
    private String telefono;
    private String nombreContacto;
    private double porcentajeDescuento; // 0.0 - 70.0
   

    public Cliente(char tipoIdentificacion, String numeroIdentificacion, boolean empresa,
                   String nombre, String email, String telefono,
                   String nombreContacto, double porcentajeDescuento) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.empresa = empresa;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.porcentajeDescuento = Math.min(70.0, Math.max(0.0, porcentajeDescuento));
    }

    // Getters
    public char getTipoIdentificacion() { return tipoIdentificacion; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public boolean isEmpresa() { return empresa; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getNombreContacto() { return nombreContacto; }
    public double getPorcentajeDescuento() { return porcentajeDescuento; }

    // Setters
    public void setTipoIdentificacion(char tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }
    public void setEmpresa(boolean empresa) { this.empresa = empresa; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setNombreContacto(String nombreContacto) { this.nombreContacto = nombreContacto; }
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = Math.min(70.0, Math.max(0.0, porcentajeDescuento));
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipo=" + tipoIdentificacion +
                ", id='" + numeroIdentificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contacto='" + nombreContacto + '\'' +
                ", descuento=" + porcentajeDescuento + "%" +
                '}';
    }
}