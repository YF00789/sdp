package as3;
public class FileAttachment extends Message{
    public FileAttachment(IEncryptionAlgorithm encryptionAlgorithm){super(encryptionAlgorithm);}
    @Override
    public void send(String content){
        String encryptedContent = encryptionAlgorithm.encrypt(content);
        System.out.println("Uploading File Attachment stream: " + encryptedContent);
    }
}
