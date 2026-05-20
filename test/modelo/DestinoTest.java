package modelo;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase Destino
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class DestinoTest {

    @Test
    public void testDiasPermanenciaMinimoUno() {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Playa");
        Destino d = new Destino("Medellin", 0, atr, true);
        int resEsperado = 1;
        int resObtenido = d.getDiasPermanencia();
        System.out.println("Test #1 -> testDiasPermanenciaMinimoUno");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testNombreLugarAsignado() {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Centro historico");
        Destino d = new Destino("Cartagena", 3, atr, true);
        String resEsperado = "Cartagena";
        String resObtenido = d.getNombreLugar();
        System.out.println("Test #2 -> testNombreLugarAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testAtractivosIncluidosVerdadero() {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Museo");
        Destino d = new Destino("Bogota", 2, atr, true);
        boolean resEsperado = true;
        boolean resObtenido = d.isAtractivosIncluidos();
        System.out.println("Test #3 -> testAtractivosIncluidosVerdadero");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertTrue(resObtenido);
    }

    @Test
    public void testAtractivosIncluidosFalso() {
        LinkedList<String> atr = new LinkedList<>();
        atr.add("Parque");
        Destino d = new Destino("Cali", 2, atr, false);
        boolean resEsperado = false;
        boolean resObtenido = d.isAtractivosIncluidos();
        System.out.println("Test #4 -> testAtractivosIncluidosFalso");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertFalse(resObtenido);
    }

}// fin class DestinoTest