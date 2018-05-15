/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositeobserver;

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
public class MachineTest {
    /**
     * Test of setBroken method, of class Machine.
     */
    @Test
    public void testSetBroken() {
        Machine machine = new Machine(1);
        machine.setBroken();
        assertEquals(true, machine.isBroken());
    }

    /**
     * Test of repair method, of class Machine.
     */
    @Test
    public void testRepair() {
        Machine machine = new Machine(1);
        machine.setBroken();
        
        //If we cant break our machine we can't test the repair.
        boolean before = machine.isBroken();
        assertEquals(true, before);
        
        //Machine is broken. Lets now test the repair.
        machine.repair();
        assertEquals(false, machine.isBroken());
    }

    /**
     * Test of isBroken method, of class Machine.
     */
    @Test
    public void testIsBroken() {
        Machine machine = new Machine(1);
        boolean default_status = machine.isBroken();
        
        machine.setBroken();
        boolean broken_status = machine.isBroken();
        
        machine.repair();
        boolean repaired_status = machine.isBroken();
        
        assertEquals(false, default_status);
        assertEquals(true, broken_status);
        assertEquals(false, repaired_status);
    }
}
