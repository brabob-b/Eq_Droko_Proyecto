package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");

    private int numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado; // A: activa, P: pagada, C: cancelada

    public Venta(int numero, Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.numero = numero;
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        this.fechaHoraGeneracion = LocalDateTime.now();
        this.fechaHoraActualizacion = this.fechaHoraGeneracion;
        this.estado = 'A';
    }

    // Getters
    public int getNumero() { return numero; }
    public LocalDateTime getFechaHoraGeneracion() { return fechaHoraGeneracion; }
    public LocalDateTime getFechaHoraActualizacion() { return fechaHoraActualizacion; }
    public Cliente getSuCliente() { return suCliente; }
    public ArrayList<PaqueteTuristico> getSusPaquetesTuristicos() { return susPaquetesTuristicos; }
    public char getEstado() { return estado; }

    public String getFechaHoraGeneracionStr() { return fechaHoraGeneracion.format(FMT); }
    public String getFechaHoraActualizacionStr() { return fechaHoraActualizacion.format(FMT); }

    // Setters
    public void setNumero(int numero) { this.numero = numero; }
    public void setFechaHoraGeneracion(LocalDateTime f) { this.fechaHoraGeneracion = f; }
    public void setFechaHoraActualizacion(LocalDateTime f) { this.fechaHoraActualizacion = f; }
    public void setSuCliente(Cliente suCliente) { this.suCliente = suCliente; }
    public void setSusPaquetesTuristicos(ArrayList<PaqueteTuristico> p) { this.susPaquetesTuristicos = p; }
    public void setEstado(char estado) { this.estado = estado; }

    public int calcularCantidadTotalUnidadesPaquetes() {
        int total = 0;
        for (PaqueteTuristico p : susPaquetesTuristicos) {
            total += p.getCantidadUnidades();
        }
        return total;
    }

    public int calcularValorTotalPaquetes() {
        int total = 0;
        for (PaqueteTuristico p : susPaquetesTuristicos) {
            total += p.calcularValorTotal();
        }
        return total;
    }

    public int calcularValorDescuento() {
        return (int)(calcularValorTotalPaquetes() * suCliente.getPorcentajeDescuento() / 100.0);
    }

    public int calcularValorTotalPagar() {
        return calcularValorTotalPaquetes() - calcularValorDescuento();
    }

    public String getEstadoTexto() {
        switch (estado) {
            case 'A': return "Activa";
            case 'P': return "Pagada";
            case 'C': return "Cancelada/Anulada";
            default: return "Desconocido";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== VENTA #").append(numero).append(" ===\n");
        sb.append("Generación: ").append(getFechaHoraGeneracionStr()).append("\n");
        sb.append("Actualización: ").append(getFechaHoraActualizacionStr()).append("\n");
        sb.append("Estado: ").append(getEstadoTexto()).append("\n");
        sb.append("Cliente: ").append(suCliente.toString()).append("\n");
        sb.append("Cantidad de paquetes: ").append(susPaquetesTuristicos.size()).append("\n");
        sb.append("Total unidades: ").append(calcularCantidadTotalUnidadesPaquetes()).append("\n");
        sb.append("Valor total paquetes: $").append(String.format("%,d", calcularValorTotalPaquetes())).append("\n");
        sb.append("Descuento (").append(suCliente.getPorcentajeDescuento()).append("%): $")
          .append(String.format("%,d", calcularValorDescuento())).append("\n");
        sb.append("Valor total a pagar: $").append(String.format("%,d", calcularValorTotalPagar())).append("\n");
        sb.append("--- Paquetes ---\n");
        for (PaqueteTuristico p : susPaquetesTuristicos) {
            sb.append("  Categoría: ").append(p.getCategoria()).append("\n");
            sb.append("  Nombre: ").append(p.getNombre()).append("\n");
            sb.append("  Origen: ").append(p.getOrigen()).append("\n");
            sb.append("  Tipología: ").append(p.getTipologiaTurismo()).append("\n");
            sb.append("  Hotel: ").append(p.isHotel() ? "Sí" : "No").append("\n");
            sb.append("  Alimentación: ").append(p.isAlimentacion() ? "Sí" : "No").append("\n");
            sb.append("  Vuelo: ").append(p.isVuelo() ? "Sí" : "No").append("\n");
            sb.append("  Asistencia: ").append(p.isAsistencia() ? "Sí" : "No").append("\n");
            if (p instanceof PaqueteTuristicoUnico) {
                PaqueteTuristicoUnico pu = (PaqueteTuristicoUnico) p;
                sb.append("  Hotel: ").append(pu.getNombreHotel()).append("\n");
                if (pu.getTipoDesayuno() != null)
                    sb.append("  Desayuno: ").append(pu.getTipoDesayuno()).append("\n");
            }
            if (p instanceof PaqueteTuristicoMultiple) {
                PaqueteTuristicoMultiple pm = (PaqueteTuristicoMultiple) p;
                Destino ini = pm.obtenerDestinoInicial();
                Destino fin = pm.obtenerDestinoFinal();
                sb.append("  Destino inicial: ").append(ini != null ? ini.getNombreLugar() : "N/A").append("\n");
                sb.append("  Destino final: ").append(fin != null ? fin.getNombreLugar() : "N/A").append("\n");
                sb.append("  Obsequio: ").append(pm.getObsequio()).append("\n");
            }
            sb.append("  Valor por unidad: $").append(String.format("%,d", p.calcularValorUnidad())).append("\n");
            sb.append("  Valor total: $").append(String.format("%,d", p.calcularValorTotal())).append("\n");
            sb.append("  Destinos:\n");
            for (Destino d : p.getSusDestinos()) {
                sb.append("    - ").append(d.getNombreLugar())
                  .append(" (").append(d.getDiasPermanencia()).append(" días)")
                  .append(" | Atractivos incluidos: ").append(d.isAtractivosIncluidos() ? "Sí" : "No").append("\n");
            }
        }
        return sb.toString();
    }
}
