# DNA Sequencing System

This project simulates the management of a complex automated DNA analysis machine involving reagents, thermal cycling, and optical scanning.

## Clean Code Principles

### 1. Meaningful, Intention-Revealing Names

The method names read like high-level operator commands - `runStandardAnalysis`, while subsystem methods are more technical `startCycling`.

Before:
```java
class Machine {
    public String doProcess(String id) {
        tc.run(30, 95); 
        os.scan();
        // Vague method names make the sequence hard to follow
    }
}

```
After:
```java
public class DnaSequencerFacade {
    public String runStandardAnalysis(String sampleId) {
        cycler.startCycling(30, 95);
        scanner.scanPlate();
    }
}

```



### 2. Single Responsibility

The `DnaSequencerFacade` coordinates only the order of operations.

Before:
```java
public class DnaSequencerFacade {
    private int reagentLevel = 100;

    public void runStandardAnalysis() {
        // Facade incorrectly manages subsystem state directly
        if (reagentLevel < 10) throw new Error();
        reagentLevel -= 10; 
    }
}

```
After:
```java
public class DnaSequencerFacade {
    // Facade delegates entirely to the specialized subsystem
    public String runStandardAnalysis(String sampleId) {
        dispenser.dispenseReagents(); 
    }
}

```



### 3. No Leaking of Subsystem Details

The Client only uses Facade's API. It doesn't import or instantiate subsystem classes.

Before:
```java
public class Client {
    public static void main(String[] args) {
        // Client is heavily coupled to subsystem details and order
        ThermalCycler cycler = new ThermalCycler();
        OpticalScanner scanner = new OpticalScanner();
        cycler.startCycling(30, 95);
        scanner.scanPlate();
    }
}

```
After:
```java
public class Client {
    public static void main(String[] args) {
        // Client only interacts with the Facade
        DnaSequencerFacade sequencer = new DnaSequencerFacade();
        String result = sequencer.runStandardAnalysis("SMPL-2049");
    }
}

```



### 4. Small, Focused Subsystem Classes

Hardware interfaces are split into small, focused classes - `ThermalCycler`, `OpticalScanner` that only manage their own domain.

Before:
```java
public class HardwareController{
    public void heatUp(){ ... }
    public void turnOnCamera(){ ... }
    public void clearDataCache(){ ... }
}

```
After:
```java
// Separated into cohesive, independent subsystems
public class ThermalCycler{
    public void startCycling(int cycles, int targetTemperature){ ... }
}
public class OpticalScanner{
    public void scanPlate(){ ... }
}

```



### 5. Graceful Degradation

On fail, subsystem throws a domain-specific `SequencingException` so that raw Java errors don't leak and the program is safely stopped.

Before:
```java
public String runStandardAnalysis(String sampleId){
    dispenser.dispenseReagents();
    // If startCycling throws an error, the scanner is left running indefinitely
    cycler.startCycling(30, 95); 
    scanner.scanPlate();
}

```
After:
```java
public String runStandardAnalysis(String sampleId) throws SequencingException{
    try{
        dispenser.dispenseReagents();
        cycler.startCycling(30, 95);
    }catch (Exception e){
        // Hardware is safely halted before bubbling the error up
        abortAndHaltSystem(); 
        throw new SequencingException("Standard analysis failed");
    }
}

```