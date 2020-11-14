package com.ithillel.persistence.entity;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.AttributeConverter;

public class CryptoConverterAES implements AttributeConverter<String, String> {
    private static Cipher cipher;
    private SecretKey secretKey;

    public CryptoConverterAES() throws Exception {
        /*
         create key
         If we need to generate a new key use a KeyGenerator
         If we have existing plaintext key use a SecretKeyFactory
        */
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey = keyGenerator.generateKey();
        /*
          Cipher Info
          Algorithm : for the encryption of electronic data
          mode of operation : to avoid repeated blocks encrypt to the same values.
          padding: ensuring messages are the proper length necessary for certain ciphers
          mode/padding are not used with stream cyphers.
         */
        cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)
    }

    @Override
    public String convertToDatabaseColumn(String plainText) {
        try {
            byte[] plainTextByte = plainText.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            Base64.Encoder encoder = Base64.getEncoder();
            String encryptedText = encoder.encodeToString(encryptedByte);
            return encryptedText;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String convertToEntityAttribute(String encryptedText) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            String decryptedText = new String(decryptedByte);
            return decryptedText;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}