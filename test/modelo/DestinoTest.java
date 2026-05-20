/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brandonbonilla
 */
public class DestinoTest {
    
    public DestinoTest() {
    }

    /**
     * Test of getNombreLugar method, of class Destino.
     */
    @Test
    public void testGetNombreLugar() {
        System.out.println("getNombreLugar");
        Destino instance = null;
        String expResult = "";
        String result = instance.getNombreLugar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiasPermanencia method, of class Destino.
     */
    @Test
    public void testGetDiasPermanencia() {
        System.out.println("getDiasPermanencia");
        Destino instance = null;
        int expResult = 0;
        int result = instance.getDiasPermanencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtractivos method, of class Destino.
     */
    @Test
    public void testGetAtractivos() {
        System.out.println("getAtractivos");
        Destino instance = null;
        LinkedList<String> expResult = null;
        LinkedList<String> result = instance.getAtractivos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAtractivosIncluidos method, of class Destino.
     */
    @Test
    public void testIsAtractivosIncluidos() {
        System.out.println("isAtractivosIncluidos");
        Destino instance = null;
        boolean expResult = false;
        boolean result = instance.isAtractivosIncluidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreLugar method, of class Destino.
     */
    @Test
    public void testSetNombreLugar() {
        System.out.println("setNombreLugar");
        String nombreLugar = "";
        Destino instance = null;
        instance.setNombreLugar(nombreLugar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiasPermanencia method, of class Destino.
     */
    @Test
    public void testSetDiasPermanencia() {
        System.out.println("setDiasPermanencia");
        int diasPermanencia = 0;
        Destino instance = null;
        instance.setDiasPermanencia(diasPermanencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtractivos method, of class Destino.
     */
    @Test
    public void testSetAtractivos() {
        System.out.println("setAtractivos");
        LinkedList<String> atractivos = null;
        Destino instance = null;
        instance.setAtractivos(atractivos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtractivosIncluidos method, of class Destino.
     */
    @Test
    public void testSetAtractivosIncluidos() {
        System.out.println("setAtractivosIncluidos");
        boolean atractivosIncluidos = false;
        Destino instance = null;
        instance.setAtractivosIncluidos(atractivosIncluidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Destino.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Destino instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
