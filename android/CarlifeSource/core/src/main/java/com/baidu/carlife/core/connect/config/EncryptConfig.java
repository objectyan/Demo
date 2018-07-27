package com.baidu.carlife.core.connect.config;

import java.util.UUID;

/* compiled from: EncryptConfig */
/* renamed from: com.baidu.carlife.core.connect.a.d */
public class EncryptConfig {
    /* renamed from: a */
    public static final boolean f3241a = true;
    /* renamed from: b */
    public static final boolean f3242b = false;
    /* renamed from: c */
    public static int f3243c = 20000;
    /* renamed from: d */
    public static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    /* renamed from: e */
    public static boolean f3245e = false;
    /* renamed from: g */
    private static EncryptConfig sEncryptConfig;
    /* renamed from: f */
    private String mRandomUUID = UUID.randomUUID().toString();

    private EncryptConfig() {
    }

    /* renamed from: a */
    public static EncryptConfig newInstance() {
        if (sEncryptConfig == null) {
            sEncryptConfig = new EncryptConfig();
        }
        return sEncryptConfig;
    }

    /* renamed from: b */
    public String getAecSeed() {
        String strAecSeed = "";
        if (this.mRandomUUID.length() >= 16) {
            return this.mRandomUUID.substring(0, 16);
        }
        return strAecSeed;
    }
}
