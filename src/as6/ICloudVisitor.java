package as6;
public interface ICloudVisitor{
    void visit(VirtualMachine virtualMachine);
    void visit(DatabaseCluster databaseCluster);
    void visit(LoadBalancer loadBalancer);
}