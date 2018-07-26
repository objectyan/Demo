package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p023b.C0433c;
import com.baidu.android.pushservice.p023b.C0434d;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.e */
public class C0602e extends C0596c {
    public C0602e(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static PublicMsg m2690a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        if (!C0578p.m2538a(context, bArr, str, str2, bArr2)) {
            return null;
        }
        PublicMsg a = C0609j.m2702a(context, str2, str, bArr2);
        a.mPkgName = context.getPackageName();
        if (!TextUtils.isEmpty(a.mTitle)) {
            return a;
        }
        a.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        return a;
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int i;
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        int i2 = c0626k.m2770i();
        byte[] j = c0626k.m2771j();
        String f = c0626k.m2767f();
        PublicMsg a = C0609j.m2702a(this.a, h, e, bArr);
        if (a != null && !TextUtils.isEmpty(a.mDescription)) {
            C0434d a2 = C0434d.m1889a(this.a, e);
            if (!TextUtils.isEmpty(f) && C0578p.m2558c(this.a, f)) {
                a.mPkgName = f;
            } else if (a2.m1890a() == C0433c.PUSH_CLIENT) {
                a.mPkgName = a2.f1368a.m1867c();
            } else if (a2.m1890a() == C0433c.SDK_CLIENT) {
                a.mPkgName = a2.f1369b.m1867c();
            }
            C0578p.m2535a(this.a, a);
            switch (a2.m1890a()) {
                case PUSH_CLIENT:
                case SDK_CLIENT:
                    byte[] a3 = C0578p.m2542a(this.a, h, bArr, j, a.mPkgName);
                    PackageManager packageManager = this.a.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                        if (TextUtils.isEmpty(a.mTitle)) {
                            a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                        }
                        if (!e.equals("8965186")) {
                            C0603f.m2693a(this.a, a, h, e, i2, a3, bArr);
                        }
                        i = 1;
                        C0578p.m2546b(">>> Show pMsg private Notification!", this.a);
                        break;
                    } catch (NameNotFoundException e2) {
                        if (a2.m1890a() == C0433c.PUSH_CLIENT) {
                            C0603f.m2694a(this.a, e);
                        } else if (a2.m1890a() == C0433c.SDK_CLIENT) {
                            C0439h.m1902a(this.a).m1893a(a2.f1369b, false);
                        }
                        i = 8;
                        break;
                    }
                default:
                    if (VERSION.SDK_INT < 24) {
                        C0603f.m2694a(this.a, e);
                    }
                    C0578p.m2546b("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.a);
                    i = 7;
                    break;
            }
        }
        C0578p.m2546b("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.a);
        i = 2;
        C0621g c0621g = new C0621g();
        c0621g.m2740a(i);
        return c0621g;
    }
}
