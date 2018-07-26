package com.baidu.location.p194f;

/* renamed from: com.baidu.location.f.c */
public final class C3365c {
    /* renamed from: a */
    public static String m14283a(int i) {
        if (C3376f.m14363j()) {
            return "WIFI";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "unknown";
        }
    }
}
