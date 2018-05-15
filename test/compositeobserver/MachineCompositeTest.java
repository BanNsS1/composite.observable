/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositeobserver;

import java.util.Observable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BanNsS1
 */
public class MachineCompositeTest {
    
    public MachineCompositeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addComponent method, of class MachineComposite.
     */
    @Test
    public void testAddComponent() {
        System.out.println("addComponent");
        MachineComponent mc = null;
        MachineComposite instance = null;
        instance.addComponent(mc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBroken method, of class MachineComposite.
     */
    @Test
    public void testSetBroken() {
        System.out.println("setBroken");
        MachineComposite instance = null;
        instance.setBroken();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repair method, of class MachineComposite.
     */
    @Test
    public void testRepair() {
        System.out.println("repair");
        MachineComposite instance = null;
        instance.repair();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBroken method, of class MachineComposite.
     */
    @Test
    public void testIsBroken() {
        System.out.println("isBroken");
        MachineComposite instance = null;
        boolean expResult = false;
        boolean result = instance.isBroken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MachineComposite.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        MachineComposite instance = null;
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTree method, of class MachineComposite.
     */
    @Test
    public void testDisplayTree() {
        System.out.println("displayTree");
        int level = 0;
        MachineComposite instance = null;
        instance.displayTree(level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
