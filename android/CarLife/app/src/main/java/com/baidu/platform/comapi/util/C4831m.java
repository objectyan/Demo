package com.baidu.platform.comapi.util;

import com.baidu.che.codriver.vr.C2848p;

/* compiled from: SystemProperties */
/* renamed from: com.baidu.platform.comapi.util.m */
public class C4831m {
    /* renamed from: a */
    private static final Class<?> f19991a = C4831m.m16028a();

    private C4831m() {
        throw new AssertionError();
    }

    /* renamed from: a */
    public static String m16029a(String key) {
        try {
            return (String) f19991a.getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{key});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m16030a(String key, String def) {
        try {
            return (String) f19991a.getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{key, def});
        } catch (Exception e) {
            return def;
        }
    }

    /* renamed from: a */
    public static boolean m16031a(String key, boolean def) {
        try {
            def = ((Boolean) f19991a.getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(null, new Object[]{key, Boolean.valueOf(def)})).booleanValue();
        } catch (Exception e) {
        }
        return def;
    }

    /* renamed from: a */
    public static int m16026a(String key, int def) {
        try {
            def = ((Integer) f19991a.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{key, Integer.valueOf(def)})).intValue();
        } catch (Exception e) {
        }
        return def;
    }

    /* renamed from: a */
    public static long m16027a(String key, long def) {
        try {
            def = ((Long) f19991a.getMethod("getLong", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{key, Long.valueOf(def)})).longValue();
        } catch (Exception e) {
        }
        return def;
    }

    /* renamed from: b */
    public static void m16032b(String key, String val) {
        try {
            f19991a.getMethod(C2848p.af, new Class[]{String.class, String.class}).invoke(null, new Object[]{key, val});
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Class<?> m16028a() {
        try {
            return Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
