package as6;
public class Main{
    public static void main(String[] args){
        CloudInfrastructure infrastructure = new CloudInfrastructure();
        infrastructure.addResource(new VirtualMachine("VM-AppServer-01", 4, 16));
        infrastructure.addResource(new DatabaseCluster("DB-Prod-Main", 5.5, false));
        infrastructure.addResource(new LoadBalancer("lb.prod.internal", 15000));
        MonthlyCostEstimator costEstimator = new MonthlyCostEstimator();
        infrastructure.accept(costEstimator);
        System.out.println("Total Monthly Cost: $"+costEstimator.getTotalCost());
        System.out.println();
        SecurityVulnerabilityScanner securityScanner = new SecurityVulnerabilityScanner();
        infrastructure.accept(securityScanner);
    }
}