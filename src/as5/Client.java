package as5;
public class Client{
    public static void main(String[] args){
        String text = "The quick brown fox jumps over the lazy dog.";
        AccessibilityReader reader = new AccessibilityReader(new NaturalHumanVoiceStrategy());
        reader.readAloud(text);
        reader.setStrategy(new ExpressiveStorytellerStrategy());
        reader.readAloud(text);
        reader.setStrategy(new FastSkimmingRoboticStrategy());
        reader.readAloud(text);
    }
}