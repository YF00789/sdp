package as6;
public class MonthlyCostEstimator implements ICloudVisitor{
    private double totalCost=0.0;
    @Override
    public void visit(VirtualMachine virtualMachine){
        totalCost += (virtualMachine.getCpuCores()*15.0)+(virtualMachine.getRamGb()*5.0);
    }
    @Override
    public void visit(DatabaseCluster databaseCluster){
        totalCost += databaseCluster.getStorageTb()*100.0;
    }
    @Override
    public void visit(LoadBalancer loadBalancer){
        totalCost += 20.0+(loadBalancer.getActiveConnections()*0.01);
    }
    public double getTotalCost(){
        return totalCost;
    }
}