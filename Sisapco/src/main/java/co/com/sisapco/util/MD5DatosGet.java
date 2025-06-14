package co.com.sisapco.util;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.util.DigestUtils;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

public class MD5DatosGet {
	
	     // private static Cipher cipher = null; 
	
	
	    private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private KeySpec ks;
	    private SecretKeyFactory skf;
	    private Cipher cipher;
	    byte[] arrayBytes;
	    private String myEncryptionKey;
	    private String myEncryptionScheme;
	    SecretKey key;
	
	
	 public MD5DatosGet() throws Exception {
	        myEncryptionKey = "ThisIsSpartaThisIsSparta";
	        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
	        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
	        ks = new DESedeKeySpec(arrayBytes);
	        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
	        cipher = Cipher.getInstance(myEncryptionScheme);
	        key = skf.generateSecret(ks);
	    }
	 
	 
	 public String encrypt(String unencryptedString) {
	        String encryptedString = null;
	        try {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
	            byte[] encryptedText = cipher.doFinal(plainText);
	            encryptedString = new String(Base64.encodeBase64(encryptedText));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return encryptedString;
	    }


	    public String decrypt(String encryptedString) {
	        String decryptedText=null;
	        try {
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] encryptedText = Base64.decodeBase64(encryptedString);
	            byte[] plainText = cipher.doFinal(encryptedText);
	            decryptedText= new String(plainText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }
	    
	    public static String encrypted(String target) throws Exception
	    {
	    	MD5DatosGet td= new MD5DatosGet();
	        String encrypted=td.encrypt(target);
	        return encrypted;

	    }
	    public static String decrypted(String encrypted) throws Exception
	    {
	    	MD5DatosGet td= new MD5DatosGet();
	        String decrypted=td.decrypt(encrypted);
	        return decrypted;

	    }
	    
	    
	   /* public static void main(String args []) throws Exception
	    {


	        String target="hola mundo";
	        String encrypted=encrypted(target);
	        String decrypted=decrypted(encrypted);

	        System.out.println("String To Encrypt: "+ target);
	        System.out.println("Encrypted String:" + encrypted);
	        System.out.println("Decrypted String:" + decrypted);

	    }
	 
	 
         */


}
