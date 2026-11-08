# Cloud Infrastructure Management System

This project uses a Visitor pattern to manage a structure of cloud resources, allowing new operations to be added without modifying the underlying element classes.

## Clean Code Principles

### 1. No instanceof/Type-Checking Chains

Using double dispatch to resolve the methods at runtime, avoiding `instanceof` conditional chains.

Before:

```java
public class CostEstimator {
    public void calculateCost(ICloudResource resource) {
        // Hardcoded type-checking chains break easily and are hard to read
        if (resource instanceof VirtualMachine) {
            VirtualMachine vm = (VirtualMachine) resource;
            System.out.println("Cost: " + (vm.getCpuCores() * 15.0));
        } else if (resource instanceof DatabaseCluster) {
            DatabaseCluster db = (DatabaseCluster) resource;
            System.out.println("Cost: " + (db.getStorageTb() * 100.0));
        }
    }
}

```

After:

```java
public class MonthlyCostEstimator implements ICloudVisitor{
    // The Java compiler handles routing automatically via double dispatch
    @Override
    public void visit(VirtualMachine virtualMachine){
        totalCost += (virtualMachine.getCpuCores()*15.0)+(virtualMachine.getRamGb()*5.0);
    }
    @Override
    public void visit(DatabaseCluster databaseCluster){
        totalCost += databaseCluster.getStorageTb()*100.0;
    }
}

```

### 2. Meaningful, Intention-Revealing Names

Class names distinguish between Elements and Visitors while describing their exact purpose.

Before:

```java
public class Action1 implements IVisitor {
    public void process(Node n) {
        // Vague class and method names hide the algorithm's actual intent
        System.out.println("Processing node.");
    }
}

```

After:

```java
public class SecurityVulnerabilityScanner implements ICloudVisitor{
    @Override
    public void visit(DatabaseCluster databaseCluster){
        // Class name clearly defines the specific operation being applied
        System.out.println("Checking DB "+databaseCluster.getClusterName()+" encryption");
    }
}

```

### 3. Single Responsibility

Each concrete class is responsible for either holding Elements or executing exactly one operational algorithm across the system.

Before:

```java
public class VirtualMachine {
    private double cpuCores;
    
    // The Element is bloated with unrelated operational logic
    public double calculateMonthlyCost() { ... }
    public void scanForVulnerabilities() { ... }
    public void generateBackupPolicy() { ... }
}

```

After:

```java
public class MonthlyCostEstimator implements ICloudVisitor{
    // This class has ONLY one responsibility: calculating costs across all resources
    private double totalCost=0.0;
    @Override
    public void visit(VirtualMachine virtualMachine) { ... }
    @Override
    public void visit(DatabaseCluster databaseCluster) { ... }
}

```

### 4. Minimal, Well-Justified Encapsulation Trade-offs

Visitors require access to Element state to perform their algorithms. This is handled by getter methods, protecting the Element from external modification.

Before:

```java
public class VirtualMachine implements ICloudResource {
    // Public fields expose the internal state to dangerous arbitrary modification
    public double cpuCores;
    public double ramGb;
}

```

After:

```java
public class VirtualMachine implements ICloudResource{
    // State is strictly private. Getters expose only what Visitors need to read.
    private double cpuCores;
    private double ramGb;
    public double getCpuCores() {return cpuCores;}
    public double getRamGb() {return ramGb;}
}

```

### 5. Open/Closed Principle

Adding a new operation requires no changes to the `ICloudResource` or the existing infrastructure components.

Before:

```java
public interface ICloudResource {
    void acceptCostEstimator(CostEstimator estimator);
    void acceptSecurityScanner(SecurityScanner scanner);
    // Adding a new operation forces us to break and modify the base interface
    void acceptBackupGenerator(BackupGenerator generator); 
}

```

After:

```java
// We simply create a new Visitor class. 
// Zero modifications are made to VirtualMachine, DatabaseCluster, or LoadBalancer.
public class BackupPolicyGenerator implements ICloudVisitor{
    @Override
    public void visit(VirtualMachine virtualMachine){
        System.out.println("Generating snapshot schedule for VM.");
    }
    @Override
    public void visit(DatabaseCluster databaseCluster){
        System.out.println("Generating transaction log backup policy for DB.");
    }
    @Override
    public void visit(LoadBalancer loadBalancer){
        System.out.println("Skipping backup for stateless Load Balancer.");
    }
}

```