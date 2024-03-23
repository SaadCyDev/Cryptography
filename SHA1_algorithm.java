import java.security.*;
public class SHA1_algorithm {
    //  1. append padding bits 
    // 2. append length - 64 bits are appended to the ed 
    // 3. prepare processing functions 
    // 4. prepare processing constants 
    // 5. initialize buffers
    // 6. processing Message in 512-bit blocks (L blocks in total message) 


    public static void main(String[] a){
        try{
            MessageDigest md=MessageDigest.getInstance("SHA1");
            System.out.println("Message digest object info :\n--------");
            System.out.println("Algorithm= "+md.getAlgorithm());
            System.out.println("Provider="+md.getProvider());
            System.out.println("ToString="+md.toString());
            String input="";
            md.update(input.getBytes());
            byte[] output= md.digest();
            System.out.println();
            System.out.println("SHA1(\"" + input + "\")=" + bytesToHex(output));
            input = "saad";
            md.update(input.getBytes());
            output = md.digest();
            System.out.println();
            System.out.println("SHA1(\"" + input + "\")=" + bytesToHex(output));

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static String bytesToHex(byte[] b){
        char hexDigit[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf= new StringBuffer();

        for(byte aB:b){
            buf.append(hexDigit[(aB>>4) & 0x0f]);
            buf.append(hexDigit[aB&0x0f]);
        }
        return buf.toString();
    }


}
