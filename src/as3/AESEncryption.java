package as3;
public class AESEncryption implements IEncryptionAlgorithm{
    @Override
    public String encrypt(String data){
        return "encrypted -> " + data;
    }
}
