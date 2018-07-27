package com.baidu.carlife.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BluetoothPhoneUtil */
/* renamed from: com.baidu.carlife.util.b */
public class C2171b {
    /* renamed from: a */
    private static List<String> f6919a = new ArrayList();
    /* renamed from: b */
    private static List<String> f6920b = new ArrayList();
    /* renamed from: c */
    private static List<String> f6921c = new ArrayList();

    static {
        f6919a.add("");
        f6920b.add("SM-N9106W");
        f6920b.add("SM-G9008V");
        f6920b.add("SM-A8000");
        f6921c.add("SM-G9200");
        f6921c.add("MI NOTE PRO");
        f6921c.add("E6653");
        f6921c.add("NXT-CL00");
    }

    /* renamed from: a */
    public static boolean m8218a() {
        String model = Build.MODEL;
        if (TextUtils.isEmpty(model) || !f6919a.contains(model.toUpperCase())) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m8219b() {
        String model = Build.MODEL;
        if (TextUtils.isEmpty(model) || !f6920b.contains(model.toUpperCase())) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m8220c() {
        String model = Build.MODEL;
        if (TextUtils.isEmpty(model) || !f6921c.contains(model.toUpperCase())) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m8221d() {
        if (!C2204x.m8382b() || VERSION.SDK_INT < 21) {
            return false;
        }
        return true;
    }
}
