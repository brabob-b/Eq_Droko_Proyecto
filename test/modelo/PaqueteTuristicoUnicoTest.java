package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase PaqueteTuristicoUnico
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class PaqueteTuristicoUnicoTest {

    private PaqueteTuristicoUnico crearPaquete(int tarifaDia, int dias, int unidades) {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Playa Blanca");
        Destino d = new Destino("Cartagena", dias, atr, true);
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(d);
        return new PaqueteTuristicoUnico(
                "PKG001", "Escapada Caribena Cartagena", "Recreacion",
                "Descripcion de prueba del paquete unico turistico.",
                "Cali", destinos, true, true, true, true, false,
                tarifaDia, unidades, "Hotel Test", "Buffet");
    }

    @Test
    public void testCalcularValorUnidad() {
        PaqueteTuristicoUnico p = crearPaquete(350000, 5, 2);
        int resEsperado = 1750000;
        int resObtenido = p.calcularValorUnidad();
        System.out.println("Test #1 -> testCalcularValorUnidad");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularValorTotal() {
        PaqueteTuristicoUnico p = crearPaquete(350000, 5, 2);
        int resEsperado = 3500000;
        int resObtenido = p.calcularValorTotal();
        System.out.println("Test #2 -> testCalcularValorTotal");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularDuracionTotalDias() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 5, 1);
        int resEsperado = 5;
        int resObtenido = p.calcularDuracionTotalDias();
        System.out.println("Test #3 -> testCalcularDuracionTotalDias");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCantidadUnidadesMinimaUno() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 0);
        int resEsperado = 1;
        int resObtenido = p.getCantidadUnidades();
        System.out.println("Test #4 -> testCantidadUnidadesMinimaUno");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testNombreHotelAsignado() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        String resEsperado = "Hotel Test";
        String resObtenido = p.getNombreHotel();
        System.out.println("Test #5 -> testNombreHotelAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testTipoDesayunoAsignado() {
        PaqueteTuristicoUnico p = crearPaquete(200000, 3, 1);
        String resEsperado = "Buffet";
        String resObtenido = p.getTipoDesayuno();
        System.out.println("Test #6 -> testTipoDesayunoAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

}// fin class PaqueteTuristicoUnicoTest