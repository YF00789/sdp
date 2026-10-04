package as3;
public class TextMessage extends Message{
    public TextMessage(IEncryptionAlgorithm encryptionAlgorithm){super(encryptionAlgorithm);}
    @Override
    public void send(String content){
        String encryptedContent = encryptionAlgorithm.encrypt(content);
        System.out.println("Sending Text Message: "+encryptedContent);
    }
}
