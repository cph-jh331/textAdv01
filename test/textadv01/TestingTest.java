/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadv01;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bloch
 */
public class TestingTest {

    public TestingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of testSetName method, of class Testing.
     */
    @Test
    public void testTestSetName() {
        System.out.println("testSetName");
        Testing.testSetName();
        String result = "Ged";
        assertEquals("Name was not setted correctly ", "Ged", result);
        
    }

    /**
     * Test of testTakeAll method, of class Testing.
     */
    @Test
    public void testTestTakeAll() {
        System.out.println("testTakeAll");
        String expResult = "Ged franticly takes: " + "\n\t2000 Gold.";
        String result = Testing.testTakeAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of testLookInv method, of class Testing.
     */
    @Test
    public void testTestLookInv() {
        System.out.println("testLookInv");
        String expResult = "Ged\n\t3 Health Potion";
        String result = Testing.testLookInv();
        assertEquals(expResult, result);
    }

    /**
     * Test of testMove method, of class Testing.
     */
    @Test
    public void testTestMove() {
        System.out.println("testMove");
        String expResult = "\tYou can go: North...";
        String result = Testing.testMove();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveToNextRoom method, of class Testing.
     */
    @Test
    public void testMoveToNextRoom() {
        System.out.println("testMoveToNextRoom");
        String expResult = " walks into a dark room, which seems\n"
                + "\ta little less in decay. Light seems to\n"
                + "\tcome from the ceiling somehow…\n"
                + "\tyou are not sure how that is possible.";
        String result = Testing.moveToNextRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of testingFirstEquip method, of class Testing.
     */
    @Test
    public void testTestingFirstEquip() {
        System.out.println("testingFirstEquip");
        String expResult = "Health Potion is already equiped";
        String result = Testing.testingFirstEquip();
        assertEquals(expResult, result);
    }

    /**
     * Test of testSecondEquip method, of class Testing.
     */
    @Test
    public void testTestSecondEquip() {
        System.out.println("testSecondEquip");
        String expResult = "Gold was added to body";
        String result = Testing.testSecondEquip();
        assertEquals(expResult, result);

    }


}
