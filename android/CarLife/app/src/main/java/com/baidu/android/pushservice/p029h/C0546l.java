package com.baidu.android.pushservice.p029h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.p033a.C0612l;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.h.l */
public class C0546l {
    /* renamed from: a */
    private static void m2331a(Context context, C0437f c0437f, C0545k c0545k, C0544j c0544j) {
        if (c0437f != null) {
            c0544j.m2269b(c0437f.m1867c());
            c0544j = C0578p.m2517a(c0544j, context, c0437f.m1867c());
            c0545k.j = c0437f.m1867c();
        }
        try {
            C0553q.m2356a(context, c0545k);
            C0553q.m2355a(context, c0544j);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2332a(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        C0545k c0545k = new C0545k();
        c0545k.d = "010101";
        c0545k.f1803a = str2;
        c0545k.e = System.currentTimeMillis();
        c0545k.f = C0532b.m2255b(context);
        c0545k.f1804b = new String(bArr).length();
        c0545k.g = i2;
        c0545k.f1805c = i;
        c0545k.h = str;
        C0544j c0544j = new C0544j(str);
        C0437f d = C0432b.m1870a(context).m1886d(str);
        if (d != null) {
            c0544j.m2269b(d.m1867c());
            if (!C0578p.m2499D(context, d.m1867c())) {
                c0544j.m2328c(C0544j.f1798b);
            } else if (C0578p.m2556c()) {
                c0544j.m2328c(C0544j.f1799c);
            } else if (C0578p.m2531a()) {
                c0544j.m2328c(C0544j.f1800d);
            } else if (C0578p.m2547b()) {
                c0544j.m2328c(C0544j.f1801e);
            } else {
                c0544j.m2328c(C0544j.f1798b);
            }
        } else {
            c0544j.m2269b("NP");
            c0544j.m2328c(i3);
        }
        C0546l.m2331a(context, d, c0545k, c0544j);
    }

    /* renamed from: a */
    public static void m2333a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                C0545k c0545k = new C0545k();
                String str4 = null;
                if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str3)) {
                    str4 = "010601";
                } else if ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str3)) {
                    str4 = "010602";
                } else if ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str3)) {
                    str4 = "010603";
                }
                c0545k.d = str4;
                c0545k.f1803a = str;
                c0545k.e = System.currentTimeMillis();
                c0545k.f = C0532b.m2255b(context);
                c0545k.f1805c = C0612l.MSG_TYPE_PRIVATE_MESSAGE.m2706a();
                c0545k.h = str2;
                C0437f d = C0432b.m1870a(context).m1886d(str2);
                if (d != null) {
                    C0546l.m2331a(context, d, c0545k, new C0544j(str2));
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public static void m2334b(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        C0545k c0545k = new C0545k();
        c0545k.d = "019901";
        c0545k.f1803a = str2;
        c0545k.e = System.currentTimeMillis();
        c0545k.f = C0532b.m2255b(context);
        c0545k.f1804b = new String(bArr).length();
        c0545k.g = i2;
        c0545k.f1805c = i;
        c0545k.h = str;
        C0544j c0544j = new C0544j(str);
        C0437f d = C0432b.m1870a(context).m1886d(str);
        if (d != null) {
            c0544j.m2269b(d.m1867c());
            if (!C0578p.m2499D(context, d.m1867c())) {
                c0544j.m2328c(C0544j.f1798b);
            } else if (C0578p.m2556c()) {
                c0544j.m2328c(C0544j.f1799c);
            } else if (C0578p.m2531a()) {
                c0544j.m2328c(C0544j.f1800d);
            } else if (C0578p.m2547b()) {
                c0544j.m2328c(C0544j.f1801e);
            } else {
                c0544j.m2328c(C0544j.f1798b);
            }
        } else {
            c0544j.m2269b("NP");
            c0544j.m2328c(i3);
        }
        C0546l.m2331a(context, d, c0545k, c0544j);
    }
}
