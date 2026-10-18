package as4;
public class DnaSequencerFacade{
    private final ReagentDispenser dispenser;
    private final ThermalCycler cycler;
    private final OpticalScanner scanner;
    private final DataProcessor processor;
    public DnaSequencerFacade(){
        this.dispenser = new ReagentDispenser();
        this.cycler = new ThermalCycler();
        this.scanner = new OpticalScanner();
        this.processor = new DataProcessor();
    }
    public String runStandardAnalysis(String sampleId) throws SequencingException{
        try{
            dispenser.dispenseReagents();
            cycler.startCycling(30, 95);
            scanner.scanPlate();
            return processor.analyzeData(sampleId);
        }catch (Exception e){
            abortAndHaltSystem();
            throw new SequencingException("Standard analysis failed: "+e.getMessage());
        }
    }
    public void flushAndCleanSystem(){
        dispenser.flushReagents();
        cycler.stopAndCool();
        scanner.turnOffScanner();
        processor.clearCache();
        System.out.println("System fully cleaned and ready for next sequence.");
    }
    private void abortAndHaltSystem(){
        cycler.stopAndCool();
        scanner.turnOffScanner();
        System.out.println("System safely halted due to operational error.");
    }
}