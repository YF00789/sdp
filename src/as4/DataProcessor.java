package as4;
public class DataProcessor{
    public String analyzeData(String sampleId){
        System.out.println("Processing genetic data for sample: "+sampleId);
        return "ATCG-GCTA-TTAA-CGGC";
    }
    public void clearCache(){
        System.out.println("Processor memory and cache cleared.");
    }
}