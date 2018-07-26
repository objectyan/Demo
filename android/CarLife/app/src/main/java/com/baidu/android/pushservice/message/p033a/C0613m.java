package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.m */
public class C0613m extends C0596c {
    public C0613m(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int i;
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        int i2 = c0626k.m2770i();
        byte[] j = c0626k.m2771j();
        String f = c0626k.m2767f();
        C0621g c0621g = new C0621g();
        PublicMsg a = C0609j.m2702a(this.a, h, e, bArr);
        if (a == null || TextUtils.isEmpty(a.mUrl)) {
            C0578p.m2546b(">>> Don't Show rich media Notification! url is null", this.a);
            i = 2;
        } else {
            if (TextUtils.isEmpty(f) || !C0578p.m2558c(this.a, f)) {
                C0437f d = C0432b.m1870a(this.a).m1886d(e);
                if (d == null || d.m1867c() == null) {
                    c0621g.m2740a(7);
                    return c0621g;
                }
                a.mPkgName = d.m1867c();
            } else {
                a.mPkgName = f;
            }
            byte[] a2 = C0578p.m2542a(this.a, h, bArr, j, a.mPkgName);
            try {
                this.a.getPackageManager().getPackageInfo(a.mPkgName, 128);
                C0603f.m2695a(this.a, e, a, h, i2, a2, bArr);
                i = 1;
                C0578p.m2546b(">>> Show rich media Notification!", this.a);
            } catch (NameNotFoundException e2) {
                i = 8;
                String str = ">>> NOT deliver to app: " + a.mPkgName + ", package has been uninstalled.";
                C0603f.m2694a(this.a, e);
                C0578p.m2546b(str, this.a);
            }
        }
        c0621g.m2740a(i);
        return c0621g;
    }
}
