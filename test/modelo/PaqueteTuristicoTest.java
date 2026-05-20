package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase PaqueteTuristico (probada via PaqueteTuristicoUnico)
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class PaqueteTuristicoTest {

    private PaqueteTuristicoUnico crearPaquete(int tarifaDia, int dias, int unidades) {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Atractivo");
        Destino d = new Destino("Cartagena", dias, atr, true);
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(d);
        return new PaqueteTuristicoUnico(
                "PKG001", "Escapada Caribena Cartagena", "Recreacion",
                "Descripcion de prueba del paquete turistico abstracto.",
                "Cali", destinos, true, true, true, true, false,
                tarifaDia, unidades, "Hotel Test", "Buffet");
    }

    @Test
    public void testCodigoAsignado() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        String resEsperado = "PKG001";
        String resObtenido = p.getCodigo();
        System.out.println("Test #1 -> testCodigoAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testNombreAsignado() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        String resEsperado = "Escapada Caribena Cartagena";
        String resObtenido = p.getNombre();
        System.out.println("Test #2 -> testNombreAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testOrigenAsignado() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        String resEsperado = "Cali";
        String resObtenido = p.getOrigen();
        System.out.println("Test #3 -> testOrigenAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testTarifaDiaAsignada() {
        PaqueteTuristicoUnico p = crearPaquete(300000, 3, 1);
        int resEsperado = 300000;
        int resObtenido = p.getTarifaDia();
        System.out.println("Test #4 -> testTarifaDiaAsignada");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testHotelIncluidoPorDefecto() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        boolean resEsperado = true;
        boolean resObtenido = p.isHotel();
        System.out.println("Test #5 -> testHotelIncluidoPorDefecto");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertTrue(resObtenido);
    }

    @Test
    public void testVueloIncluidoPorDefecto() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        boolean resEsperado = true;
        boolean resObtenido = p.isVuelo();
        System.out.println("Test #6 -> testVueloIncluidoPorDefecto");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertTrue(resObtenido);
    }

    @Test
    public void testCalcularDuracionTotalDias() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 4, 1);
        int resEsperado = 4;
        int resObtenido = p.calcularDuracionTotalDias();
        System.out.println("Test #7 -> testCalcularDuracionTotalDias");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularValorTotal() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 2);
        int resEsperado = 1200000;
        int resObtenido = p.calcularValorTotal();
        System.out.println("Test #8 -> testCalcularValorTotal");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

}// fin class PaqueteTuristicoTest