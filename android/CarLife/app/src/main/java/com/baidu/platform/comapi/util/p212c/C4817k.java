package com.baidu.platform.comapi.util.p212c;

import java.lang.reflect.Field;

/* compiled from: PatchInfo */
/* renamed from: com.baidu.platform.comapi.util.c.k */
public class C4817k {
    /* renamed from: a */
    public static String m15988a() {
        String needleVersion = C4817k.m15989a("com.baidu.needle.confirm.Confirm", "NEEDLE_VERSION");
        if (needleVersion == null) {
            return "";
        }
        return needleVersion;
    }

    /* renamed from: a */
    private static String m15989a(String className, String fieldName) {
        try {
            Field field = Class.forName(className).getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
