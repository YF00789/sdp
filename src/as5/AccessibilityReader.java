package as5;
public class AccessibilityReader{
    private IVoiceSynthesisStrategy strategy;
    public AccessibilityReader(IVoiceSynthesisStrategy strategy){
        this.strategy = strategy;
    }
    public void setStrategy(IVoiceSynthesisStrategy strategy){
        this.strategy = strategy;
    }
    public void readAloud(String text){
        this.strategy.synthesize(text);
    }
}