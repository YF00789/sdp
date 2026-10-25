package as5;
public class NaturalHumanVoiceStrategy implements IVoiceSynthesisStrategy{
    @Override
    public void synthesize(String text){
        System.out.println("Synthesizing with a natural human voice: "+text);
    }
}