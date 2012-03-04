/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingServer;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermani
 */
public class Sha256 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String password = "mauro";
     
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
     
            byte byteData[] = md.digest();
     
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
             sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
     
            System.out.println("Hex format : " + sb.toString().length());
     
            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
                for (int i=0;i<byteData.length;i++) {
                        String hex=Integer.toHexString(0xff & byteData[i]);
                            if(hex.length()==1) hexString.append('0');
                            hexString.append(hex);
                }
                System.out.println("Hex format : " + hexString.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha256.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
