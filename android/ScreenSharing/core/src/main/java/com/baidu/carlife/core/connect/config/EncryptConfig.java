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
    public static final String f3244d = "RSA/ECB/PKCS1Padding";
    /* renamed from: e */
    public static boolean f3245e = false;
    /* renamed from: g */
    private static EncryptConfig f3246g;
    /* renamed from: f */
    private String f3247f = UUID.randomUUID().toString();

    private EncryptConfig() {
    }

    /* renamed from: a */
    public static EncryptConfig m4118a() {
        if (f3246g == null) {
            f3246g = new EncryptConfig();
        }
        return f3246g;
    }

    /* renamed from: b */
    public String m4119b() {
        String strAecSeed = "";
        if (this.f3247f.length() >= 16) {
            return this.f3247f.substring(0, 16);
        }
        return strAecSeed;
    }
}
