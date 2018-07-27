package me.objectyan.screensharing.core.connect.config;

import java.util.UUID;


public class EncryptConfig {

    public static final boolean f3241a = true;

    public static final boolean f3242b = false;

    public static int f3243c = 20000;

    public static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";

    public static boolean f3245e = false;

    private static EncryptConfig sEncryptConfig;

    private String mRandomUUID = UUID.randomUUID().toString();

    private EncryptConfig() {
    }


    public static EncryptConfig newInstance() {
        if (sEncryptConfig == null) {
            sEncryptConfig = new EncryptConfig();
        }
        return sEncryptConfig;
    }


    public String getAecSeed() {
        String strAecSeed = "";
        if (this.mRandomUUID.length() >= 16) {
            return this.mRandomUUID.substring(0, 16);
        }
        return strAecSeed;
    }
}
