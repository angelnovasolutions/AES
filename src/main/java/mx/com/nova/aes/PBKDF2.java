package mx.com.nova.aes;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class PBKDF2 {

	/**
	 * 
	 * @param Example AML 2.
	 */
    public static void main(String[] args) {
    	
        try {
            String EncryptionKey = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
            String clearText="Hola Mundo";
            byte[] clearBytes = clearText.getBytes(StandardCharsets.UTF_16LE);
            byte[] bytes2 = EncryptionKey.getBytes(StandardCharsets.US_ASCII);
            Rfc2898DeriveBytes pdb = new Rfc2898DeriveBytes(EncryptionKey, bytes2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(pdb.getBytes(32), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(pdb.getBytes(16));
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,iv);
            java.io.ByteArrayOutputStream memoryStream = new java.io.ByteArrayOutputStream();
            CipherOutputStream cryptoStream = new CipherOutputStream(memoryStream, cipher);
            cryptoStream.write(clearBytes);
            cryptoStream.close();
            String base64 = Base64.getEncoder().encodeToString( memoryStream.toByteArray() );
            System.out.println(base64);
            
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

}