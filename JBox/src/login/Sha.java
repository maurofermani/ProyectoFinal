package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
public class Sha {

    public static String sha256(String str) {

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}
