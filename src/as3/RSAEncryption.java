package as3;
public class RSAEncryption implements IEncryptionAlgorithm{
    @Override
    public String encrypt(String data){
        return "encrypted -> " + data;
    }
}
