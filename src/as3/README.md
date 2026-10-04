# Encrypted Messaging System
This project implements the Bridge structural design pattern to simulate sending messages using encryption algorithms - AES, RSA.

## Clean Code Principles

### 1. Dependency Inversion/Loose Coupling
The `Message` doesn't know of `AESEncryption` or `RSAEncryption`. It accepts the `IEncryptionAlgorithm` via constructor injection.

* **Before:**
  ```java
  public abstract class Message{
      // Hardcoded dependency to a specific concrete class
      protected AESEncryption encryptionAlgorithm = new AESEncryption();
  }
  ```
* **After:**
  ```java
  public abstract class Message{
      // Strictly works through the interface
      protected IEncryptionAlgorithm encryptionAlgorithm;
      public Message(IEncryptionAlgorithm encryptionAlgorithm){
          this.encryptionAlgorithm = encryptionAlgorithm;
      }
  }
  ```

### 2. Meaningful, Intention-Revealing Names
Naming the interface `IEncryptionAlgorithm` and the concrete implementors `AESEncryption` and `RSAEncryption` makes it easy to understand each function's role.

* **Before:**
  ```java
  class Msg{
      Algo a;
      public void doSend(String c){ ... }
  }
  ```
* **After:**
  ```java
  public abstract class Message{
      protected IEncryptionAlgorithm encryptionAlgorithm;
      public abstract void send(String content);
  }
  ```

### 3. Single Responsibility
`TextMessage` doesn't contain any logic for AES or RSA.

* **Before:**
  ```java
  public void send(String content, String type){
      if (type.equals("AES")){
          // 50 lines of complex AES encryption logic here
      }
      System.out.println("Sending: "+encryptedContent);
  }
  ```
* **After:**
  ```java
  @Override
  public void send(String content){
      // Strictly delegates encryption, then focuses on sending
      String encryptedContent = encryptionAlgorithm.encrypt(content);
      System.out.println("Sending Text Message: "+encryptedContent);
  }
  ```

### 4. No Duplicated Logic
Refined abstractions - `TextMessage` and `FileAttachment` only provide their unique implementation of `send()` from a shared abstract class `Message`.

* **Before:**
  ```java
  public class TextMessage{
      EncryptionAlgorithm algo;
      public void setAlgo(EncryptionAlgorithm algo){this.algo=algo;}
  }
  public class FileAttachment{
      EncryptionAlgorithm algo; // Duplicated state
      public void setAlgo(EncryptionAlgorithm algo){this.algo=algo;} // Duplicated setter
  }
  ```
* **After:**
  ```java
  public abstract class Message{
      protected EncryptionAlgorithm encryptionAlgorithm;
      // Implemented once, inherited by all refined abstractions
      public void setEncryptionAlgorithm(IEncryptionAlgorithm encryptionAlgorithm){
          this.encryptionAlgorithm = encryptionAlgorithm;
      }
  }
  ```

### 5. Open/Closed Principle
You can add new encryption methods like`BlowfishEncryption` without making changes to the existing `Message`, `TextMessage`, or `FileAttachment` classes.

* **Before:**
  ```java
  public String encryptContent(String content, String algo){
      switch(algo){
          case "AES": return "[AES] " + content;
          case "RSA": return "[RSA] " + content;
          // Must modify this block every time a new algorithm is added
      }
  }
  ```
* **After:**
  ```java
  // Adding a new algorithm requires no changes to existing classes.
  // The client passes the new behavior into the abstraction:
  EncryptionAlgorithm rsa = new RSAEncryption();
  myText.setEncryptionAlgorithm(rsa);
  myText.send("secret text");
  ```