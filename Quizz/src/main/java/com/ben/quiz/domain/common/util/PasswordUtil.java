package com.ben.quiz.domain.common.util;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    /**
     * @param value is password-SHA256
     * @return password base String
     * @throws RuntimeException
     */
    public static String passwordHashString(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            Logger.getLogger(PasswordUtil.class).error(ex);
            throw new RuntimeException(ex);
        }

    }

    /**
     * @param password is password-String
     * @return password base SHA-256
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     */
    public static String genSHAForPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8")); // Change this to "UTF-16" if needed

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            Logger.getLogger(PasswordUtil.class).error(e);
        }
        byte[] digest = md != null ? md.digest() : new byte[0];
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

}
