package modelo;

import java.util.ArrayList;

public final class PaqueteTuristicoUnico extends PaqueteTuristico {
    private static final long serialVersionUID = 1L;

    private String nombreHotel;
    private String tipoDesayuno; // opcional

    public PaqueteTuristicoUnico(String codigo, String nombre, String tipologiaTurismo,
                                  String descripcion, String origen, ArrayList<Destino> susDestinos,
                                  boolean hotel, boolean alimentacion, boolean alimentacionTodo,
                                  boolean vuelo, boolean asistencia, int tarifaDia,
                                  int cantidadUnidades, String nombreHotel, String tipoDesayuno) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos,
              hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        this.nombreHotel = nombreHotel;
        this.tipoDesayuno = tipoDesayuno;
    }

    // Constructor sin tipoDesayuno
    public PaqueteTuristicoUnico(String codigo, String nombre, String tipologiaTurismo,
                                  String descripcion, String origen, ArrayList<Destino> susDestinos,
                                  boolean hotel, boolean alimentacion, boolean alimentacionTodo,
                                  boolean vuelo, boolean asistencia, int tarifaDia,
                                  int cantidadUnidades, String nombreHotel) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos,
              hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        this.nombreHotel = nombreHotel;
        this.tipoDesayuno = null;
    }

    // Getters
    public String getNombreHotel() { return nombreHotel; }
    public String getTipoDesayuno() { return tipoDesayuno; }

    // Setters
    public void setNombreHotel(String nombreHotel) { this.nombreHotel = nombreHotel; }
    public void setTipoDesayuno(String tipoDesayuno) { this.tipoDesayuno = tipoDesayuno; }

    @Override
    public int calcularValorUnidad() {
        return tarifaDia * calcularDuracionTotalDias();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", nombreHotel='" + nombreHotel + '\'' +
                ", tipoDesayuno='" + (tipoDesayuno != null ? tipoDesayuno : "No incluido") + '\'';
    }
}