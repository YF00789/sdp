package as6;
import java.util.ArrayList;
import java.util.List;
public class CloudInfrastructure{
    private List<ICloudResource> resources = new ArrayList<>();
    public void addResource(ICloudResource resource){
        resources.add(resource);
    }
    public void accept(ICloudVisitor visitor){
        for (ICloudResource resource : resources){
            resource.accept(visitor);
        }
    }
}