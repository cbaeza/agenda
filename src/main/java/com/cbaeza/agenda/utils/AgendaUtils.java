package com.cbaeza.agenda.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: cbaeza
 * Since: 10.12.13
 */
public class AgendaUtils {

    protected static final Log LOG = LogFactory.getLog(AgendaUtils.class);

    /**
     * Generate a SHA-256 based on toEncrypt param
     *
     * @param toEncrypt
     * @return a SHA-256 finger print of toEncrypt
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getMessageDigestSHA256(String toEncrypt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(toEncrypt.getBytes("UTF-8")).toString();
    }

    /**
     * Encrypt a string using AES.
     *
     * @param toEncrypter a string
     * @return a encrypter toEncrypter
     * @throws Exception
     * @see AESEncrypter
     */
    public static String encrypter(final String toEncrypter) {
        try {
            return AESEncrypter.getInstance().encrypt(toEncrypter).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting: " + toEncrypter, e);
        }
    }

    /**
     * Decrypt a string using AES.
     *
     * @param toDecrypter
     * @return a readable string
     * @throws Exception
     */
    public static String decrypter(final String toDecrypter){
        try {
            return AESEncrypter.getInstance().decrypt(toDecrypter).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting: " + toDecrypter, e);
        }
    }
}
