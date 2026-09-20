# Furniture Manufacturing
This project implements Factory Method and Abstract Factory design patterns to simulate the manufacturing of Modern and Victorian styles of furniture.

## Clean Code Principles

### 1. Validated Construction
By enforcing validation the code fails fast with a custom exception - `InvalidFurnitureStateException` or `IllegalArgumentException`.

* **Before:**
  ```java
  public void assemble(Material material){
      this.material = material; // Danger: could be null or incompatible
  }
  ```
* **After:**
  ```java
  public void assemble(Material material){
      if (material==null){throw new InvalidFurnitureStateException("Material cannot be null");}
      if (material==Material.PLASTIC){throw new InvalidFurnitureStateException("Victorian furniture cannot be plastic");}
      this.material = material;
  }
  ```

### 2. No Magic Strings or Numbers
By using the `Material` Enum, the code guarantees that only valid, predefined types can be passed into the products.

* **Before:**
  ```java
  chair.assemble("Wood"); // Prone to typos
  ```
* **After:**
  ```java
  chair.assemble(Material.WOOD); // Compiler-enforced safety
  ```

### 3. Meaningful, Intention-Revealing Names
Naming the client `FurnitureStore` and the interfaces `IFurnitureFactory` or `IChairMaker` makes the system architecture instantly understandable without needing comments.

* **Before:**
  ```java
  class Factory1 implements Fact{
      public ProductA getA(){ ... }
  }
  ```
* **After:**
  ```java
  class ModernFurnitureFactory implements IFurnitureFactory{
      public Chair createChair(){ ... }
  }
  ```

### 4. Small Methods, Each Doing One Thing
The `FurnitureStore` client's `displayRoom()` method doesn't handle creation or configuration logic, it strictly delegates to the pre-created objects. Factory methods only instantiate and initialize.

* **Before:**
  ```java
  public void setupAndDisplayRoom(String style){
      // Logic instantiating chairs and tables using if/else
      // followed by displaying them
  }
  ```
* **After:**
  ```java
  public void displayRoom(){
      chair.sitOn();
      table.placeItems();
  }
  ```

### 5. Dependency Inversion
The `FurnitureStore` client has zero knowledge of concrete classes like `ModernChair` or `VictorianFurnitureFactory`. It accepts an interface via constructor injection. This prevents coupling and makes adding a new style like `IndustrialFurnitureFactory` require zero changes to the client code.

* **Before (Coupled):**
  ```java
  public FurnitureStore(){
      this.chair = new ModernChair(); 
      this.table = new ModernTable();
  }
  ```
* **After (Decoupled):**
  ```java
  public FurnitureStore(IFurnitureFactory factory){
      // Client strictly works through the Abstract Factory interface
      this.chair = factory.createChair(); 
      this.table = factory.createTable();
  }
  ```