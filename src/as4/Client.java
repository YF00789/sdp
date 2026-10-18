package as4;
public class Client{
    public static void main(String[] args){
        DnaSequencerFacade sequencer = new DnaSequencerFacade();
        try{
            System.out.println("Starting Sequence Phase");
            String result = sequencer.runStandardAnalysis("SMPL-2049");
            System.out.println("Final Output: "+result);
        }catch (SequencingException e){
            System.out.println("System Alert: "+e.getMessage());
        }
        System.out.println("\nStarting Maintenance Phase");
        sequencer.flushAndCleanSystem();
    }
}