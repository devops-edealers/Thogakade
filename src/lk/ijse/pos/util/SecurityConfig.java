package lk.ijse.pos.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class SecurityConfig {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public final static String holdingSecretKey="abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(final String plainPassword,
                                 final String secret){
        try{
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(plainPassword.getBytes("UTF-8")));

        } catch (NoSuchPaddingException | BadPaddingException | UnsupportedEncodingException |
                 IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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
