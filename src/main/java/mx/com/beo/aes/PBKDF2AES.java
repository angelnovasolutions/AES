package mx.com.beo.aes;

import java.nio.charset.StandardCharsets;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;


/*
 * Copyright (c)  2017 Nova Solution Systems S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF NOVA SOLUTION SYSTEMS.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
public class PBKDF2AES {

	 /**
     * Encrypt the string with the Advanced Encryption Standard (AES)
     * @param clearText is the string that will be encrypt in Advanced Encryption Standard (AES)
     * 
     * @return the string encrypted and converted to Base64
     * @throws if the encrypted is failed 
     */
	public String encrypt(String clearText) throws Exception{
		
		// LLave secreta para encryptar
		String EncryptionKey = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
        
		// Se obtiene los arreglos de bytes de la cadena original y la palabra clave
		byte[] clearBytes = clearText.getBytes(StandardCharsets.UTF_16LE);
        byte[] bytes2 = EncryptionKey.getBytes(StandardCharsets.US_ASCII);
        
        // Se obtiene la instancia de la clase Rfc2898DeriveBytes para obtener 
        // los arreglos de bytes 16 y 32 del la palabra secreta 
        Rfc2898DeriveBytesAES pdb = new Rfc2898DeriveBytesAES(EncryptionKey, bytes2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(pdb.getBytes(32), "AES");
        
        // Se obtiene la intancia de un cifrado del estandar AES
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(pdb.getBytes(16));
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,iv);
        
        // Se genera la salida del algoritmo AES
        ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
        CipherOutputStream cryptoStream = new CipherOutputStream(memoryStream, cipher);
        cryptoStream.write(clearBytes);
        cryptoStream.close();
        
        // Se retorna el texto encriptado convertido a Base64
        return Base64.getEncoder().encodeToString( memoryStream.toByteArray() );

    }

}