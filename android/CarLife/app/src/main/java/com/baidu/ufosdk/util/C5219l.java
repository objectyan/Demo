package com.baidu.ufosdk.util;

import android.os.Build.VERSION;

/* compiled from: Compatibility */
/* renamed from: com.baidu.ufosdk.util.l */
public final class C5219l {
    /* renamed from: a */
    public static int m17768a() {
        try {
            return VERSION.class.getField("SDK_INT").getInt(null);
        } catch (SecurityException e) {
            return Integer.parseInt(VERSION.SDK);
        } catch (NoSuchFieldException e2) {
            return Integer.parseInt(VERSION.SDK);
        } catch (IllegalArgumentException e3) {
            return Integer.parseInt(VERSION.SDK);
        } catch (IllegalAccessException e4) {
            return Integer.parseInt(VERSION.SDK);
        }
    }
}
