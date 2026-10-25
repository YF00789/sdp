package as5;
public class ExpressiveStorytellerStrategy implements IVoiceSynthesisStrategy{
    @Override
    public void synthesize(String text){
        System.out.println("Synthesizing with expressive emotion and pauses: "+text);
    }
}