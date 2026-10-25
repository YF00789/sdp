package as5;
public class FastSkimmingRoboticStrategy implements IVoiceSynthesisStrategy{
    @Override
    public void synthesize(String text){
        System.out.println("Synthesizing rapidly at 2.0x speed with a robotic voice: "+text);
    }
}