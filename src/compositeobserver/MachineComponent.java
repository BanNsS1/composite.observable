package compositeobserver;

import java.util.Observable;

public abstract class MachineComponent extends Observable{   
    protected int id;
    
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
    
    public abstract void setBroken();
    public abstract void repair();
    public abstract boolean isBroken();
    public abstract void displayTree(int level);
}