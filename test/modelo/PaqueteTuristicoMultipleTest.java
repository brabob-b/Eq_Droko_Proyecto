/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brandonbonilla
 */
public class PaqueteTuristicoMultipleTest {
    
    public PaqueteTuristicoMultipleTest() {
    }

    /**
     * Test of getObsequio method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testGetObsequio() {
        System.out.println("getObsequio");
        PaqueteTuristicoMultiple instance = null;
        String expResult = "";
        String result = instance.getObsequio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObsequio method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testSetObsequio() {
        System.out.println("setObsequio");
        String obsequio = "";
        PaqueteTuristicoMultiple instance = null;
        instance.setObsequio(obsequio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("calcularValorUnidad");
        PaqueteTuristicoMultiple instance = null;
        int expResult = 0;
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDestinoInicial method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoInicial() {
        System.out.println("obtenerDestinoInicial");
        PaqueteTuristicoMultiple instance = null;
        Destino expResult = null;
        Destino result = instance.obtenerDestinoInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDestinoFinal method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoFinal() {
        System.out.println("obtenerDestinoFinal");
        PaqueteTuristicoMultiple instance = null;
        Destino expResult = null;
        Destino result = instance.obtenerDestinoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PaqueteTuristicoMultiple instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
