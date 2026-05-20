package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase Venta
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class VentaTest {

    private Destino crearDestino(String lugar, int dias) {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Atractivo");
        return new Destino(lugar, dias, atr, true);
    }

    private PaqueteTuristicoUnico crearPaqueteUnico(int tarifaDia, int dias, int unidades) {
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(crearDestino("Cartagena", dias));
        return new PaqueteTuristicoUnico(
                "PKG001", "Escapada Caribena Cartagena", "Recreacion",
                "Descripcion de prueba del paquete para test de venta.",
                "Cali", destinos, true, true, true, true, false,
                tarifaDia, unidades, "Hotel Test", "Buffet");
    }

    private Cliente crearCliente(double descuento) {
        return new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", descuento);
    }

    private Venta crearVenta(int numero, double descuento, int tarifaDia, int dias, int unidades) {
        Cliente c = crearCliente(descuento);
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(crearPaqueteUnico(tarifaDia, dias, unidades));
        return new Venta(numero, c, paquetes);
    }

    @Test
    public void testEstadoInicialActivo() {
        // CP-001: al crear una venta el estado debe ser 'A'
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertEquals('A', v.getEstado());
    }

    @Test
    public void testNumeroAsignado() {
        Venta v = crearVenta(5, 10.0, 350000, 5, 2);
        assertEquals(5, v.getNumero());
    }

    @Test
    public void testFechaGeneracionNoNula() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertNotNull(v.getFechaHoraGeneracion());
    }

    @Test
    public void testCalcularValorTotalPaquetes() {
        // tarifaDia=350000, 5 dias, 2 unidades => 350000*5*2 = 3500000
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertEquals(3500000, v.calcularValorTotalPaquetes());
    }

    @Test
    public void testCalcularValorDescuento() {
        // CP-013: valorTotal=3500000, descuento=10% => 350000
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertEquals(350000, v.calcularValorDescuento());
    }

    @Test
    public void testCalcularValorTotalPagar() {
        // 3500000 - 350000 = 3150000
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertEquals(3150000, v.calcularValorTotalPagar());
    }

    @Test
    public void testCalcularCantidadTotalUnidades() {
        // 1 paquete con 2 unidades => total = 2
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        assertEquals(2, v.calcularCantidadTotalUnidadesPaquetes());
    }

    @Test
    public void testActualizarEstadoCancelado() {
        // CP-009: estado pasa a 'C'
        Venta v = crearVenta(1, 10.0, 350000, 5, 1);
        v.setEstado('C');
        assertEquals('C', v.getEstado());
    }

    @Test
    public void testActualizarEstadoPagado() {
        // CP-010: estado pasa a 'P'
        Venta v = crearVenta(1, 10.0, 350000, 5, 1);
        v.setEstado('P');
        assertEquals('P', v.getEstado());
    }

    @Test
    public void testDescuentoCeroTotalPagarIgualTotalPaquetes() {
        // con 0% descuento, totalPagar == valorTotalPaquetes
        Venta v = crearVenta(1, 0.0, 200000, 3, 1);
        assertEquals(v.calcularValorTotalPaquetes(), v.calcularValorTotalPagar());
    }

}// fin class VentaTest