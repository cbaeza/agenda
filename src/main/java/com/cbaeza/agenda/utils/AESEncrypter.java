package com.cbaeza.agenda.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.spec.KeySpec;
import java.util.Properties;

/**
 * User: cbaeza
 * Since: 10.12.13
 */
public class AESEncrypter {

    private static final byte[] SALT = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 256;
    private static AESEncrypter instance;
    private final Cipher ecipher;
    private final Cipher dcipher;

    private AESEncrypter(String passPhrase) throws Exception {
        final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
        final SecretKey tmp = factory.generateSecret(spec);
        final SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ecipher.init(Cipher.ENCRYPT_MODE, secret);

        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        final byte[] iv = ecipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        dcipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    }

    /**
     * Singleton
     *
     * @return a unique instance of AESEncrypter
     */
    public static AESEncrypter getInstance() {
        if (instance == null) {
            try {
                instance = new AESEncrypter(getSecret());
            } catch (Exception e) {
                throw new RuntimeException("Can't initialize AESEncrypter", e);
            }
        }
        return instance;
    }

    /**
     * Get secret password to en/decrypt
     *
     * @return a secret
     */
    private static String getSecret() {
        final Properties properties = new Properties();
        try {
            properties.load(AESEncrypter.class.getResourceAsStream("/config.properties"));
            for (String key : properties.stringPropertyNames()) {
                if (key.equals("secret"))
                    return properties.getProperty(key);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't load property file", e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        final String message = "MESSAGE";
        final String password = "SECRET";

        final AESEncrypter encrypter = AESEncrypter.getInstance();//new AESEncrypter(password);
        final String encrypted = encrypter.encrypt(message);
        final String decrypted = encrypter.decrypt(encrypted);

        System.out.println("Encrypt(\"" + message + "\", \"" + password + "\") = \"" + encrypted + "\"");
        System.out.println("Decrypt(\"" + encrypted + "\", \"" + password + "\") = \"" + decrypted + "\"");
    }

    public String encrypt(String encrypt) throws Exception {
        final byte[] bytes = encrypt.getBytes("UTF8");
        final byte[] encrypted = encrypt(bytes);
        return new BASE64Encoder().encode(encrypted);
    }

    public byte[] encrypt(byte[] plain) throws Exception {
        return ecipher.doFinal(plain);
    }

    public String decrypt(String encrypt) throws Exception {
        final byte[] bytes = new BASE64Decoder().decodeBuffer(encrypt);
        final byte[] decrypted = decrypt(bytes);
        return new String(decrypted, "UTF8");
    }

    public byte[] decrypt(byte[] encrypt) throws Exception {
        return dcipher.doFinal(encrypt);
    }
}
