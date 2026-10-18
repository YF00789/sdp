package as4;
public class ReagentDispenser{
    private int reagentLevel = 100;
    public void dispenseReagents(){
        if (reagentLevel<10){throw new IllegalStateException("Insufficient reagents.");}
        reagentLevel-=10;
        System.out.println("Reagents dispensed into sequencing tray.");
    }
    public void flushReagents(){System.out.println("Reagent lines flushed and sanitized.");}
}