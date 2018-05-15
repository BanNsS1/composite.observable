/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositeobserver;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author BanNsS1
 */
public class UI implements Observer{
    public static void main(String[] args) {
        Machine m1 = new Machine(1);
        Machine m2 = new Machine(2);
        Machine m3 = new Machine(3);
        Machine m4 = new Machine(4);
        
        MachineComposite m5 = new MachineComposite(5);
        m5.addComponent(m1);
        m5.addComponent(m2);
        
        MachineComposite m6 = new MachineComposite(6);
        m6.addComponent(m3);
        m6.addComponent(m4);
        
        
        MachineComposite m7 = new MachineComposite(7);
        m7.addComponent(m5);
        m7.addComponent(m6);
        
        m7.addObserver(new UI());
        
        m1.setBroken();
        m1.repair();
        m6.setBroken();
        m7.repair();
    }

    @Override
    public void update(Observable o, Object arg) {
        MachineComponent mc = (MachineComponent) arg;
        if(mc.isBroken()){
            System.out.println("Our machine has just broke :(");
        }else{
            System.out.println("Our machine has been repaired!");
        }
        mc.displayTree(0);
        System.out.println("");
    }
}
