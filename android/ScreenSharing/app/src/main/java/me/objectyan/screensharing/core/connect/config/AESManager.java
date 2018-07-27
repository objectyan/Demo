package me.objectyan.screensharing.core.connect.config;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESManager {

    private Cipher mCipherEncrypt;

    private Cipher mCipherDecrypt;

    public AESManager() {
        init();
    }


    private void init() {
        SecretKey sk = new SecretKeySpec(EncryptConfig.newInstance().getAecSeed().getBytes(), "AES");
        try {
            this.mCipherEncrypt = Cipher.getInstance("AES");
            this.mCipherDecrypt = Cipher.getInstance("AES");
            this.mCipherEncrypt.init(1, sk);
            this.mCipherDecrypt.init(2, sk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public byte[] encrypt(byte[] rawData, int len) {
        if (this.mCipherEncrypt == null) {
            return null;
        }
        byte[] encryptData = null;
        try {
            return this.mCipherEncrypt.doFinal(rawData, 0, len);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return encryptData;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return encryptData;
        }
    }


    public byte[] decrypt(byte[] encryptData, int len) {
        if (this.mCipherDecrypt == null) {
            return null;
        }
        byte[] decryptData = null;
        try {
            return this.mCipherDecrypt.doFinal(encryptData, 0, len);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return decryptData;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return decryptData;
        }
    }
}
