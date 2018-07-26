package com.baidu.che.codriver.p123i;

import android.text.TextUtils;
import com.baidu.che.codriver.p115a.C2505a;
import com.baidu.che.codriver.util.C2725h;

/* compiled from: CarLifeVrUtil */
/* renamed from: com.baidu.che.codriver.i.a */
public class C2544a {
    /* renamed from: a */
    private static final String f8401a = "CarLifeVrUtil";
    /* renamed from: b */
    private static String f8402b;
    /* renamed from: c */
    private static String f8403c;

    /* renamed from: a */
    public static String m9642a() {
        if (TextUtils.isEmpty(f8402b)) {
            f8402b = C2505a.m9511a();
        }
        C2725h.m10207b(f8401a, "mChannel = " + f8402b);
        return f8402b;
    }

    /* renamed from: a */
    public static void m9643a(String channel) {
        f8402b = channel;
    }

    /* renamed from: b */
    public static String m9644b() {
        if (TextUtils.isEmpty(f8403c)) {
            f8403c = C2505a.m9512b();
        }
        C2725h.m10207b(f8401a, "mAk = " + f8403c);
        return f8403c;
    }

    /* renamed from: b */
    public static void m9645b(String ak) {
        f8403c = ak;
    }
}
