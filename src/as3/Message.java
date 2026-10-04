package as3;
public abstract class Message{
    protected IEncryptionAlgorithm encryptionAlgorithm;
    public Message(IEncryptionAlgorithm encryptionAlgorithm){this.encryptionAlgorithm = encryptionAlgorithm;}
    public void setEncryptionAlgorithm(IEncryptionAlgorithm encryptionAlgorithm){this.encryptionAlgorithm = encryptionAlgorithm;}
    public abstract void send(String content);
}
