import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {

    public static void main(String[] args) {
        //String txt = "jakis tekst";
        System.out.println(Integer.toHexString(-94) + " " + Integer.toHexString(-2));
        String txt = "Javarmi123";
        byte[] bytesOfMessage = txt.getBytes(Charset.forName("UTF-8"));
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");    //SHA-256
            byte[] hash = md.digest(bytesOfMessage);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                System.out.println(hash[i] + " " + Integer.toHexString(hash[i]) + " " + Integer.toHexString(0xff));
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0"+ Integer.toHexString((0xff & hash[i])));
                } else hexString.append(Integer.toHexString(0xff & hash[i]));
            }
            System.out.println(hexString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
