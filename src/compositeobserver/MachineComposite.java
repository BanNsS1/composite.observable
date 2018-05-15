
package compositeobserver;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer{
    private final List<MachineComponent> components = new ArrayList<>();
    private final List<MachineComponent> brokenComponents = new ArrayList<>();
    
    public MachineComposite(int id){
        super(id);
    }
    
    public void addComponent(MachineComponent mc){
        boolean initial_status = isBroken();
        
        if(mc.isBroken()){
            brokenComponents.add(mc);
        }else{
            components.add(mc);
        }
        mc.addObserver(this);
        
                
        if(initial_status != isBroken()){
            notifyChanges();
        }
    }
    
    @Override
    public void repair(){
        if(isBroken()){
            this.broken = false;
            if(!isBroken())
                notifyChanges();
        }
        //Repairing its components (no need to notify changes here).
        MachineComponent mc;
        while(!brokenComponents.isEmpty()){
            brokenComponents.get(0).repair();
        }
        
    }
    
    @Override
    public boolean isBroken(){
        return (!brokenComponents.isEmpty() || this.broken);
    }

    @Override
    public void update(Observable o, Object arg) {
        boolean initial_status = isBroken();
        
        MachineComponent mc = (MachineComponent) arg;
        
        if(mc.isBroken() && components.contains(mc))
            onComponentBreak(mc);
        else if(!mc.isBroken() && brokenComponents.contains(mc))
            onComponentFix(mc);
        
        if(initial_status != isBroken()){
            notifyChanges();
        }
    }
    
    private void onComponentFix(MachineComponent mc){
        brokenComponents.remove(mc);
        components.add(mc);
    }
    
    private void onComponentBreak(MachineComponent mc){
        components.remove(mc);
        brokenComponents.add(mc);
    }
    
    @Override
    public void displayTree(int level){
        String str_status, tabs = "";
        if(isBroken())
            str_status = "broken";
        else
            str_status = "working";
        
        for(int i = 0; i < level; i++)
            tabs += "\t";
        
        System.out.println(tabs + "Machine "+getId()+": "+str_status);
        for(MachineComponent mc: components){
            mc.displayTree(level+1);
        }
        for(MachineComponent mc: brokenComponents){
            mc.displayTree(level+1);
        }
    }
}
