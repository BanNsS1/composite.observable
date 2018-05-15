package compositeobserver;

public class Machine extends MachineComponent {
    protected boolean broken = false;
    
    public Machine(int id){
        super(id);
    }
    
    @Override
    public void setBroken(){
        if(!broken){
            broken = true;
            setChanged();
            notifyObservers(this);
        }
    }
       
    @Override
    public void repair(){
        if(broken){
            broken = false;
            setChanged();
            notifyObservers(this);
        }
    }
    
    @Override
    public boolean isBroken(){
        return broken;
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
    }
}
