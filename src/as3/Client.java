package as3;
public class Client{
    public static void main(String[] args){
        IEncryptionAlgorithm aes = new AESEncryption();
        IEncryptionAlgorithm rsa = new RSAEncryption();
        System.out.println("Testing Text Message");
        Message myText = new TextMessage(aes);
        myText.send("secret text");
        System.out.println("\nRSA");
        myText.setEncryptionAlgorithm(rsa);
        myText.send("secret text");
        System.out.println("\nTesting File Attachment");
        Message myFile = new FileAttachment(rsa);
        myFile.send("report.pdf");
    }
}
