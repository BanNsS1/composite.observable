package compositeobserver;

import java.util.Observable;

public abstract class MachineComponent extends Observable{   
    protected int id;
    protected boolean broken = false;
    
    public MachineComponent(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    protected void notifyChanges(){
        setChanged();
        notifyObservers(this);
    }
    
    public void setBroken(){
        if(!broken){
            broken = true;
            notifyChanges();
        }
    }
    
    public void repair(){
        if(broken){
            broken = false;
            notifyChanges();
        }
    }
    
    public abstract boolean isBroken();
    public abstract void displayTree(int level);
}