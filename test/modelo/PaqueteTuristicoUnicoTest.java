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
public class PaqueteTuristicoUnicoTest {
    
    public PaqueteTuristicoUnicoTest() {
    }

    /**
     * Test of getNombreHotel method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testGetNombreHotel() {
        System.out.println("getNombreHotel");
        PaqueteTuristicoUnico instance = null;
        String expResult = "";
        String result = instance.getNombreHotel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoDesayuno method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testGetTipoDesayuno() {
        System.out.println("getTipoDesayuno");
        PaqueteTuristicoUnico instance = null;
        String expResult = "";
        String result = instance.getTipoDesayuno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreHotel method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testSetNombreHotel() {
        System.out.println("setNombreHotel");
        String nombreHotel = "";
        PaqueteTuristicoUnico instance = null;
        instance.setNombreHotel(nombreHotel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoDesayuno method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testSetTipoDesayuno() {
        System.out.println("setTipoDesayuno");
        String tipoDesayuno = "";
        PaqueteTuristicoUnico instance = null;
        instance.setTipoDesayuno(tipoDesayuno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("calcularValorUnidad");
        PaqueteTuristicoUnico instance = null;
        int expResult = 0;
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PaqueteTuristicoUnico instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
