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
    /**
     * Test of setBroken method, of class MachineComposite.
     */
    @Test
    public void testSetBroken() {
        MachineComposite m1 = new MachineComposite(1);
        boolean initial_status = m1.isBroken();
        m1.setBroken();
        boolean finale_status = m1.isBroken();
        assertFalse(initial_status);
        assertTrue(finale_status);
    }
    /**
     * Test of isBroken method, of class MachineComposite.
     */
    @Test
    public void testIsBroken() {
        MachineComposite m1 = new MachineComposite(1);
        assertFalse(m1.isBroken());
        m1.setBroken();
        assertTrue(m1.isBroken());
    }

    /**
     * Test of addComponent method, of class MachineComposite.
     */
    @Test
    public void testAddComponent() {
        //Broken component
        MachineComposite m1 = new MachineComposite(1);
        m1.setBroken();
        //Working component
        MachineComposite m2 = new MachineComposite(2);
        
        //Test the addition of a broken component.
        MachineComposite m3 = new MachineComposite(3);
        assertFalse(m3.isBroken());
        m3.addComponent(m1);
        assertTrue(m3.isBroken());
        
        //Test the adition of a working component.
        MachineComposite m4 = new MachineComposite(4);
        assertFalse(m4.isBroken());
        m4.addComponent(m2);
        assertFalse(m4.isBroken());        
    }

    /**
     * Test of repair method, of class MachineComposite.
     */
    @Test
    public void testRepair() {
        //Simple case
        MachineComposite m1 = new MachineComposite(1);
        m1.setBroken();
        assertTrue(m1.isBroken());
        m1.repair();
        assertFalse(m1.isBroken());
        
        //Complex case
        MachineComposite m2 = new MachineComposite(2);
        MachineComposite m3 = new MachineComposite(3);
        MachineComposite m4 = new MachineComposite(4);
        MachineComposite m5 = new MachineComposite(5);
        MachineComposite m6 = new MachineComposite(6);
        
        // Tree: (Top) m6 - m5 - m4 - m3 - m2 (Bottom)
        m3.addComponent(m2);
        m4.addComponent(m3);
        m5.addComponent(m4);
        m6.addComponent(m5);
        
        //Breaking m2 (The last element of the tree)
        m2.setBroken();
        
        //All the elements should be broken at this point
        assertTrue(m6.isBroken());
        assertTrue(m5.isBroken());
        assertTrue(m4.isBroken());
        assertTrue(m3.isBroken());
        assertTrue(m2.isBroken());
        
        //Lets repair on m5
        m5.repair();
        
        //All the elements should have been repaired
        assertFalse(m6.isBroken());
        assertFalse(m5.isBroken());
        assertFalse(m4.isBroken());
        assertFalse(m3.isBroken());
        assertFalse(m2.isBroken());
    }

    /**
     * Test of update method, of class MachineComposite.
     */
    @Test
    public void testUpdate() {
        MachineComposite m1 = new MachineComposite(1);
        m1.setBroken();
        MachineComposite m2 = new MachineComposite(2);
        m2.addComponent(m1);
        
        //M2 should be broken since its child m1 is.
        assertTrue(m2.isBroken());
        
        //Repairing M1 should update M2
        m1.repair();
        assertFalse(m2.isBroken());
        
        
        
        MachineComposite m3 = new MachineComposite(3);
        MachineComposite m4 = new MachineComposite(4);
        m4.addComponent(m3);
        
        //M4 shouldn't be broken
        assertFalse(m4.isBroken());
        
        //Breaking M3 should update M4
        m3.setBroken();
        assertTrue(m4.isBroken());
        
    }    
}
