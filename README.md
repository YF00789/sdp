# Custom Aquarium Builder

## Product
Aquarium - a highly configurable, complex object that needs step-by-step construction. It consists of multiple attributes like volume, water type, lighting, substrate, plants, and fish. 

Using the Builder pattern prevents a constructor with 7+ parameters and allows a `Director` to easily create specific, reusable aquarium setups like a Tropical Reef or a Coldwater Goldfish tank without duplicating configuration logic.

## Clean Code Principles

### 1. Meaningful, Intention-Revealing Names
Instead of using vague names like `buildConfig1` or `setupTank`, the Director class uses descriptive method names. This makes it instantly obvious to the Client what kind of object is being produced.

**Excerpt:**
```java
// BEFORE:
public void buildSetupA(AquariumBuilder builder) { ... }

// AFTER:
public void buildPlantedDiscusTank(AquariumBuilder builder) { 
    
}
```

### 2. Small Methods, Each Doing One Thing
The builder class implements a Fluent API. Every setter method inside the `AquariumBuilder` is small and does exactly one thing: it assigns a single instance variable and returns the builder itself.

**Excerpt:**
```java
// Doing one thing: assigning the lighting variable. 
// No complex logic or side effects are hidden in this method.
public AquariumBuilder withLighting(Lighting lighting) {
    this.lighting = lighting;
    return this; // Returns itself for method chaining
}
```

### 3. Consistent Formatting (Fluent API)
By placing each `.withX(...)` call on a new line and aligning them, the code reads almost like natural language, making the complex object's attributes easy to scan.

**Excerpt:**
```java
builder.withVolume(120)
       .withWaterType(WaterType.SALTWATER)
       .withFiltrationRating("High Capacity Protein Skimmer")
       .withLighting(Lighting.REEF_SPECIFIC)
       .withFauna(Fish.CLOWNFISH, Fish.BLUE_TANG);
```

### 4. Validated Construction
The `Aquarium` object should never exist in an invalid state. To ensure this, the `build()` method validates the data before calling the constructor. If the user tries to mix Saltwater fish into a Freshwater tank, it throws an exception.

**Excerpt:**
```java
public Aquarium build() {
    // Fails fast if the volume is invalid
    if (volume <= 0) {
        throw new IllegalStateException("Volume must be greater than zero.");
    }
    
    // Validates logical compatibility between fish and water type
    for (Fish fish : fauna) {
        if (fish.getRequiredWater() != waterType) {
            throw new IllegalStateException("Cannot mix " + fish.getRequiredWater() + 
                                            " fish into a " + waterType + " tank.");
        }
    }
    return new Aquarium(this);
}
```

### 5. No Magic Numbers/Strings
Arbitrary raw strings like `"Saltwater"` or `"Low Light"` are easy to mistype and make the code hard to maintain. To fix this, strict `Enums` were made for `WaterType`, `Lighting`, `Substrate`, and `Fish`.

**Excerpt:**
```java
// BEFORE:
builder.withWaterType("Saltwater");
builder.withFauna("Clownfish");

// AFTER:
builder.withWaterType(WaterType.SALTWATER);
builder.withFauna(Fish.CLOWNFISH);
```