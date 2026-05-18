package modelo;

import java.util.ArrayList;

public final class PaqueteTuristicoMultiple extends PaqueteTuristico {
    private static final long serialVersionUID = 1L;

    private String obsequio;

    public PaqueteTuristicoMultiple(String codigo, String nombre, String tipologiaTurismo,
                                     String descripcion, String origen, ArrayList<Destino> susDestinos,
                                     boolean hotel, boolean alimentacion, boolean alimentacionTodo,
                                     boolean vuelo, boolean asistencia, int tarifaDia,
                                     int cantidadUnidades, String obsequio) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos,
              hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        this.obsequio = obsequio;
    }

    public String getObsequio() { return obsequio; }
    public void setObsequio(String obsequio) { this.obsequio = obsequio; }

    @Override
    public int calcularValorUnidad() {
        int cantidadDestinos = susDestinos.size();
        int duracion = calcularDuracionTotalDias();
        int incremento = (int)(0.01 * tarifaDia * cantidadDestinos);
        return tarifaDia * duracion + incremento;
    }

    public Destino obtenerDestinoInicial() {
        if (susDestinos != null && !susDestinos.isEmpty()) return susDestinos.get(0);
        return null;
    }

    public Destino obtenerDestinoFinal() {
        if (susDestinos != null && !susDestinos.isEmpty()) return susDestinos.get(susDestinos.size() - 1);
        return null;
    }

    @Override
    public String toString() {
        String inicial = obtenerDestinoInicial() != null ? obtenerDestinoInicial().getNombreLugar() : "N/A";
        String finalD = obtenerDestinoFinal() != null ? obtenerDestinoFinal().getNombreLugar() : "N/A";
        return super.toString() +
                ", obsequio='" + obsequio + '\'' +
                ", destinoInicial='" + inicial + '\'' +
                ", destinoFinal='" + finalD + '\'';
    }
}