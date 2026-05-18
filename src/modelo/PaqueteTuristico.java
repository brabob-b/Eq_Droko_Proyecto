package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class PaqueteTuristico implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String codigo;
    protected String nombre;           // mínimo 10 caracteres
    protected String tipologiaTurismo;
    protected String descripcion;      // máximo 500 caracteres
    protected String origen;
    protected ArrayList<Destino> susDestinos;
    protected boolean hotel;           // por defecto true
    protected boolean alimentacion;    // por defecto true
    protected boolean alimentacionTodo;
    protected boolean vuelo;           // por defecto true
    protected boolean asistencia;      // por defecto false
    protected int tarifaDia;           // mayor que cero
    protected int cantidadUnidades;    // mínimo 1

    public PaqueteTuristico(String codigo, String nombre, String tipologiaTurismo,
                             String descripcion, String origen, ArrayList<Destino> susDestinos,
                             boolean hotel, boolean alimentacion, boolean alimentacionTodo,
                             boolean vuelo, boolean asistencia, int tarifaDia, int cantidadUnidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipologiaTurismo = tipologiaTurismo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.susDestinos = susDestinos;
        this.hotel = hotel;
        this.alimentacion = alimentacion;
        this.alimentacionTodo = alimentacionTodo;
        this.vuelo = vuelo;
        this.asistencia = asistencia;
        this.tarifaDia = tarifaDia;
        this.cantidadUnidades = (cantidadUnidades >= 1) ? cantidadUnidades : 1;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTipologiaTurismo() { return tipologiaTurismo; }
    public String getDescripcion() { return descripcion; }
    public String getOrigen() { return origen; }
    public ArrayList<Destino> getSusDestinos() { return susDestinos; }
    public boolean isHotel() { return hotel; }
    public boolean isAlimentacion() { return alimentacion; }
    public boolean isAlimentacionTodo() { return alimentacionTodo; }
    public boolean isVuelo() { return vuelo; }
    public boolean isAsistencia() { return asistencia; }
    public int getTarifaDia() { return tarifaDia; }
    public int getCantidadUnidades() { return cantidadUnidades; }

    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipologiaTurismo(String tipologiaTurismo) { this.tipologiaTurismo = tipologiaTurismo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setOrigen(String origen) { this.origen = origen; }
    public void setSusDestinos(ArrayList<Destino> susDestinos) { this.susDestinos = susDestinos; }
    public void setHotel(boolean hotel) { this.hotel = hotel; }
    public void setAlimentacion(boolean alimentacion) { this.alimentacion = alimentacion; }
    public void setAlimentacionTodo(boolean alimentacionTodo) { this.alimentacionTodo = alimentacionTodo; }
    public void setVuelo(boolean vuelo) { this.vuelo = vuelo; }
    public void setAsistencia(boolean asistencia) { this.asistencia = asistencia; }
    public void setTarifaDia(int tarifaDia) { this.tarifaDia = tarifaDia; }
    public void setCantidadUnidades(int cantidadUnidades) { this.cantidadUnidades = (cantidadUnidades >= 1) ? cantidadUnidades : 1; }

    public int calcularDuracionTotalDias() {
        int total = 0;
        for (Destino d : susDestinos) {
            total += d.getDiasPermanencia();
        }
        return total;
    }

    public abstract int calcularValorUnidad();

    public int calcularValorTotal() {
        return calcularValorUnidad() * cantidadUnidades;
    }

    public String getCategoria() {
        if (this instanceof PaqueteTuristicoUnico) return "Único";
        if (this instanceof PaqueteTuristicoMultiple) return "Múltiple";
        return "Desconocido";
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipologia='" + tipologiaTurismo + '\'' +
                ", origen='" + origen + '\'' +
                ", hotel=" + hotel +
                ", alimentacion=" + alimentacion +
                ", vuelo=" + vuelo +
                ", asistencia=" + asistencia +
                ", tarifaDia=" + tarifaDia +
                ", cantidadUnidades=" + cantidadUnidades +
                '}';
    }
}