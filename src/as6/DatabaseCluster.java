package as6;
public class DatabaseCluster implements ICloudResource{
    private String clusterName;
    private double storageTb;
    private boolean isEncrypted;
    public DatabaseCluster(String clusterName, double storageTb, boolean isEncrypted){
        this.clusterName = clusterName;
        this.storageTb = storageTb;
        this.isEncrypted = isEncrypted;
    }
    public String getClusterName() {return clusterName;}
    public double getStorageTb() {return storageTb;}
    public boolean isEncrypted() {return isEncrypted;}
    @Override
    public void accept(ICloudVisitor visitor){
        visitor.visit(this);
    }
}