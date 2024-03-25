import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner; 

public class Digital_Signature_Standard {
    
    // 1. create a KeyPairGenerator object 
    // 2. initialize the KeyPairGenerator object 
    // 3. generate the KeyPairGenerator 
    // 4. get the private key from the pair 
    // 5. create a signature object 
    // 6. initialize the signature object. 
    // 7. add data to the signature object 
    // 8. calculate the signature 

    public static void main(String args[]) throws Exception{
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter some text");
        String msg= sc.nextLine();

        KeyPairGenerator keyPairGen= KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair(); 

        PrivateKey privKey=pair.getPrivate();
        Signature sign= Signature.getInstance("SHA256withDSA");

        sign.initSign(privKey);
        byte[] bytes="msg".getBytes();
        
        sign.update(bytes);
        byte[] signature=sign.sign();

        System.out.println("Digital signture for given text: "+ new String(signature,"UTF8"));

    }

}
