package as6;
public class VirtualMachine implements ICloudResource{
    private String instanceId;
    private double cpuCores;
    private double ramGb;
    public VirtualMachine(String instanceId, double cpuCores, double ramGb){
        this.instanceId = instanceId;
        this.cpuCores = cpuCores;
        this.ramGb = ramGb;
    }
    public String getInstanceId() {return instanceId;}
    public double getCpuCores() {return cpuCores;}
    public double getRamGb() {return ramGb;}
    @Override
    public void accept(ICloudVisitor visitor){
        visitor.visit(this);
    }
}