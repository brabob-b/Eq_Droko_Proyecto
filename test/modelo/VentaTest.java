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

    private PaqueteTuristicoUnico crearPaqueteUnico(int tarifaDia, int dias, int unidades) {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Atractivo");
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Cartagena", dias, atr, true));
        return new PaqueteTuristicoUnico(
                "PKG001", "Escapada Caribena Cartagena", "Recreacion",
                "Descripcion de prueba del paquete para test de venta.",
                "Cali", destinos, true, true, true, true, false,
                tarifaDia, unidades, "Hotel Test", "Buffet");
    }

    private Venta crearVenta(int numero, double descuento, int tarifaDia, int dias, int unidades) {
        Cliente c = new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", descuento);
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(crearPaqueteUnico(tarifaDia, dias, unidades));
        return new Venta(numero, c, paquetes);
    }

    @Test
    public void testEstadoInicialActivo() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        char resEsperado = 'A';
        char resObtenido = v.getEstado();
        System.out.println("Test #1 -> testEstadoInicialActivo");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testNumeroAsignado() {
        Venta v = crearVenta(5, 10.0, 350000, 5, 2);
        int resEsperado = 5;
        int resObtenido = v.getNumero();
        System.out.println("Test #2 -> testNumeroAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testFechaGeneracionNoNula() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        System.out.println("Test #3 -> testFechaGeneracionNoNula");
        System.out.println("Resultado Esperado=not null");
        System.out.println("Resultado Obtenido=" + v.getFechaHoraGeneracion());
        assertNotNull(v.getFechaHoraGeneracion());
    }

    @Test
    public void testCalcularValorTotalPaquetes() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        int resEsperado = 3500000;
        int resObtenido = v.calcularValorTotalPaquetes();
        System.out.println("Test #4 -> testCalcularValorTotalPaquetes");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularValorDescuento() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        int resEsperado = 350000;
        int resObtenido = v.calcularValorDescuento();
        System.out.println("Test #5 -> testCalcularValorDescuento");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularValorTotalPagar() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        int resEsperado = 3150000;
        int resObtenido = v.calcularValorTotalPagar();
        System.out.println("Test #6 -> testCalcularValorTotalPagar");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularCantidadTotalUnidades() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 2);
        int resEsperado = 2;
        int resObtenido = v.calcularCantidadTotalUnidadesPaquetes();
        System.out.println("Test #7 -> testCalcularCantidadTotalUnidades");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testActualizarEstadoCancelado() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 1);
        v.setEstado('C');
        char resEsperado = 'C';
        char resObtenido = v.getEstado();
        System.out.println("Test #8 -> testActualizarEstadoCancelado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testActualizarEstadoPagado() {
        Venta v = crearVenta(1, 10.0, 350000, 5, 1);
        v.setEstado('P');
        char resEsperado = 'P';
        char resObtenido = v.getEstado();
        System.out.println("Test #9 -> testActualizarEstadoPagado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testDescuentoCeroTotalPagarIgualTotal() {
        Venta v = crearVenta(1, 0.0, 200000, 3, 1);
        int resEsperado = v.calcularValorTotalPaquetes();
        int resObtenido = v.calcularValorTotalPagar();
        System.out.println("Test #10 -> testDescuentoCeroTotalPagarIgualTotal");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

}// fin class VentaTest