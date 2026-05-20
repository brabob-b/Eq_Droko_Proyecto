package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias - Clase Cliente
 * @author Brandon Bonilla Buitrago
 * @version 1.0 - Mayo 2026
 */
public class ClienteTest {

    @Test
    public void testDescuentoMaximo() {
        Cliente c = new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", 85.0);
        double resEsperado = 70.0;
        double resObtenido = c.getPorcentajeDescuento();
        System.out.println("Test #1 -> testDescuentoMaximo");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido, 0.01);
    }

    @Test
    public void testDescuentoMinimo() {
        Cliente c = new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", -5.0);
        double resEsperado = 0.0;
        double resObtenido = c.getPorcentajeDescuento();
        System.out.println("Test #2 -> testDescuentoMinimo");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido, 0.01);
    }

    @Test
    public void testDescuentoValido() {
        Cliente c = new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", 10.0);
        double resEsperado = 10.0;
        double resObtenido = c.getPorcentajeDescuento();
        System.out.println("Test #3 -> testDescuentoValido");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido, 0.01);
    }

    @Test
    public void testTipoIdentificacionCedula() {
        Cliente c = new Cliente('C', "1234567890", false, "Carlos Martinez",
                "carlos@email.com", "3001234567", "Carlos Martinez", 10.0);
        char resEsperado = 'C';
        char resObtenido = c.getTipoIdentificacion();
        System.out.println("Test #4 -> testTipoIdentificacionCedula");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testNombreAsignado() {
        Cliente c = new Cliente('N', "900123456", true, "Viajes Express SAS",
                "info@viajes.com", "6014567890", "Ana Gomez", 20.0);
        String resEsperado = "Viajes Express SAS";
        String resObtenido = c.getNombre();
        System.out.println("Test #5 -> testNombreAsignado");
        System.out.println("Resultado Esperado=" + resEsperado);
        System.out.println("Resultado Obtenido=" + resObtenido);
        assertEquals(resEsperado, resObtenido);
    }

}// fin class ClienteTest