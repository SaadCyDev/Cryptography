import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class DES_algorithm {

    public static void main(String[] argv){
        try{
            System.out.println("Message Encryption Using DES algorithm\n-----");
            KeyGenerator keygen= KeyGenerator.getInstance("DES");
            SecretKey mykey= keygen.generateKey();
            Cipher desCipher; 

            desCipher= Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, mykey);
            byte[] text="saad cybersecurity".getBytes();
            System.out.println("Message[Byte Format]:"+text);
            System.out.println("Message : "+ new String(text));
            byte[] textEncrypted= desCipher.doFinal(text);
            System.out.println("Encrypted Message:"+textEncrypted);
            desCipher.init(Cipher.DECRYPT_MODE, mykey);
            byte[] textDecrypted= desCipher.doFinal(textEncrypted);
            System.out.println("Decrypted Message "+ new String(textDecrypted));
        }catch(NoSuchAlgorithmException e){
              e.printStackTrace();
        }catch(NoSuchPaddingException e){
            e.printStackTrace();
            }catch(InvalidKeyException e){
            e.printStackTrace();
            }catch(IllegalBlockSizeException e){
            e.printStackTrace();
            }catch(BadPaddingException e){
            e.printStackTrace();
            }
    }
     
}
