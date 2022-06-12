package lk.ijse.pos.util;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class security {
    public static void setKey(final String importedKey){
        MessageDigest sha=null;
        try{
            key = importedKey.getBytes("UTF-8");
            sha =MessageDigest.getInstance("SHA-1");
            key =sha.digest(key);
            key = Arrays.copyOf(key,16);
            secretKey= new SecretKeySpec(key,"AES");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
