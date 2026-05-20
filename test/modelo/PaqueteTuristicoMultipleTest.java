package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase PaqueteTuristicoMultiple
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class PaqueteTuristicoMultipleTest {

    private PaqueteTuristicoMultiple crearPaquete(int tarifaDia, int dias1, int dias2, int unidades) {
        LinkedList<String> atr1 = new LinkedList<>(); atr1.add("Torre Eiffel");
        LinkedList<String> atr2 = new LinkedList<>(); atr2.add("Big Ben");
        Destino d1 = new Destino("Paris", dias1, atr1, true);
        Destino d2 = new Destino("Londres", dias2, atr2, false);
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(d1);
        destinos.add(d2);
        return new PaqueteTuristicoMultiple(
                "PKG002", "Europa Clasica Paris-Londres", "Recreacion",
                "Descripcion de prueba del paquete multiple turistico.",
                "Bogota", destinos, true, true, false, true, true,
                tarifaDia, unidades, "Kit de viaje");
    }

    @Test
    public void testCalcularValorUnidad() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        int resEsperado = 8424000;
        int resObtenido = p.calcularValorUnidad();
        System.out.println("Test #1 -> testCalcularValorUnidad");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularValorTotal() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        int resEsperado = 8424000;
        int resObtenido = p.calcularValorTotal();
        System.out.println("Test #2 -> testCalcularValorTotal");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testCalcularDuracionTotalDias() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        int resEsperado = 7;
        int resObtenido = p.calcularDuracionTotalDias();
        System.out.println("Test #3 -> testCalcularDuracionTotalDias");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testObtenerDestinoInicial() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        String resEsperado = "Paris";
        String resObtenido = p.obtenerDestinoInicial().getNombreLugar();
        System.out.println("Test #4 -> testObtenerDestinoInicial");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testObtenerDestinoFinal() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        String resEsperado = "Londres";
        String resObtenido = p.obtenerDestinoFinal().getNombreLugar();
        System.out.println("Test #5 -> testObtenerDestinoFinal");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testObsequioAsignado() {
        PaqueteTuristicoMultiple p = crearPaquete(1200000, 4, 3, 1);
        String resEsperado = "Kit de viaje";
        String resObtenido = p.getObsequio();
        System.out.println("Test #6 -> testObsequioAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

}// fin class PaqueteTuristicoMultipleTest