package as6;
public class LoadBalancer implements ICloudResource{
    private String endpoint;
    private double activeConnections;
    public LoadBalancer(String endpoint, double activeConnections){
        this.endpoint = endpoint;
        this.activeConnections = activeConnections;
    }
    public String getEndpoint() {return endpoint;}
    public double getActiveConnections() {return activeConnections;}
    @Override
    public void accept(ICloudVisitor visitor){
        visitor.visit(this);
    }
}