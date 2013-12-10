package com.cbaeza.agenda.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;

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
    private final Cipher ecipher;
    private final Cipher dcipher;
    private static final String PASSWORD = "SECRET";

    private static AESEncrypter instance;

    /**
     * Singleton
     *
     * @return
     */
    public static AESEncrypter getInstance() {
        if (instance == null) {
            try {
                instance = new AESEncrypter(PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

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

    public static void main(String[] args) throws Exception {

        final String message = "MESSAGE";
        final String password = "SECRET";

        final AESEncrypter encrypter = new AESEncrypter(password);
        final String encrypted = encrypter.encrypt(message);
        final String decrypted = encrypter.decrypt(encrypted);

        System.out.println("Encrypt(\"" + message + "\", \"" + password + "\") = \"" + encrypted + "\"");
        System.out.println("Decrypt(\"" + encrypted + "\", \"" + password + "\") = \"" + decrypted + "\"");
    }
}
