# Text-to-Speech Voice Synthesis System

This project simulates an accessibility reader capable of dynamically switching between different text-to-speech algorithms at runtime.

## Clean Code Principles

### 1. Elimination of Conditional Logic

The `AccessibilityReader` uses polymorphism to execute the behavior without using `switch` or `if/else` to determine the voice type.

Before:

```java
public class AccessibilityReader {
    public void readAloud(String text, String voiceType) {
        // Hardcoded branching makes the code rigid and hard to maintain
        if (voiceType.equals("HUMAN")) {
            System.out.println("Natural voice: " + text);
        } else if (voiceType.equals("ROBOTIC")) {
            System.out.println("Fast robotic voice: " + text);
        }
    }
}
```

After:

```java
public class AccessibilityReader{
    private IVoiceSynthesisStrategy strategy;
    public void readAloud(String text){
        // Context dynamically delegates execution to the polymorphic interface
        this.strategy.synthesize(text);
    }
}
```

### 2. Meaningful, Intention-Revealing Names

Concrete strategy classes are named descriptively.

Before:

```java
public class VoiceType1 implements IVoiceSynthesisStrategy {
    public void synthesize(String text) {
        // Vague class name doesn't explain the algorithm's purpose
        System.out.println("Synthesizing: " + text);
    }
}
```

After:

```java
public class FastSkimmingRoboticStrategy implements IVoiceSynthesisStrategy{
    public void synthesize(String text){
        // Name clearly defines speed, use-case, and voice tone
        System.out.println("Synthesizing rapidly at 2.0x speed with a robotic voice: "+text);
    }
}
```

### 3. Single Responsibility

Each strategy class provides one voice synthesis algorithm.

Before:

```java
public class AccessibilityReader {
    // Context is handling both state management AND multiple algorithms
    public void synthesizeHumanVoice(String text) { ... }
    public void synthesizeRoboticVoice(String text) { ... }
    public void synthesizeStorytellerVoice(String text) { ... }
}
```

After:

```java
public class ExpressiveStorytellerStrategy implements IVoiceSynthesisStrategy{
    // This class has only one responsibility: storyteller voice generation
    @Override
    public void synthesize(String text){
        System.out.println("Synthesizing with expressive emotion: "+text);
    }
}
```

### 4. Open/Closed Principle

Possible to add infinite new voice algorithms without touching the `AccessibilityReader` or existing strategies.

Before:

```java
public class AccessibilityReader {
    public void readAloud(String text, String voiceType) {
        // To add a new voice, we must modify existing, working code
        if (voiceType.equals("HUMAN")) { ... }
        else if (voiceType.equals("ROBOTIC")) { ... }
        else if (voiceType.equals("STORYTELLER")) { ... } // newly added line
    }
}
```

After:

```java
// We simply create a new class implementing the interface. 
// Zero modifications are made to AccessibilityReader.java.
public class WhisperVoiceStrategy implements IVoiceSynthesisStrategy{
    @Override
    public void synthesize(String text){
        System.out.println("Synthesizing in a quiet whisper: "+text);
    }
}
```

### 5. Algorithm-Agnostic Context

The `AccessibilityReader` is decoupled from the implementation of speech generation.

Before:

```java
public class AccessibilityReader {
    public void readAloud(String text) {
        // Context is tightly coupled to internal algorithm configurations
        int pitch = 80;
        int speed = 150;
        AudioEngine.processAudio(text, pitch, speed);
    }
}
```

After:

```java
public class AccessibilityReader{
    private IVoiceSynthesisStrategy strategy;
    public void readAloud(String text){
        // Context knows nothing about pitch, speed, or audio engines. 
        // It only knows that the strategy can "synthesize".
        this.strategy.synthesize(text);
    }
}
```