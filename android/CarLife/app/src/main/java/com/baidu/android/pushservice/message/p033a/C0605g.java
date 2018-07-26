package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.p023b.C0433c;
import com.baidu.android.pushservice.p023b.C0434d;
import com.baidu.android.pushservice.p023b.C0439h;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.g */
public class C0605g extends C0596c {
    public C0605g(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int a;
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        int i = c0626k.m2770i();
        byte[] j = c0626k.m2771j();
        String f = c0626k.m2767f();
        String str = new String(bArr);
        C0434d a2 = C0434d.m1889a(this.a, e);
        if (TextUtils.isEmpty(f) || !C0578p.m2558c(this.a, f)) {
            f = a2.m1890a() == C0433c.PUSH_CLIENT ? a2.f1368a.m1867c() : a2.m1890a() == C0433c.SDK_CLIENT ? a2.f1369b.m1867c() : null;
        }
        byte[] a3;
        switch (a2.m1890a()) {
            case PUSH_CLIENT:
                a3 = C0578p.m2542a(this.a, h, bArr, j, f);
                try {
                    this.a.getPackageManager().getPackageInfo(f, 128);
                    Intent intent = new Intent();
                    if (C0430a.m1857b() > 0) {
                        intent.putExtra("bd.message.rate.GET", System.currentTimeMillis());
                        intent.putExtra("bd.message.rate.MH", true);
                    }
                    intent.putExtra("app_id", e);
                    intent.putExtra("msg_id", h);
                    intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", h);
                    intent.putExtra("baidu_message_type", i);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", a3);
                    if (C0430a.m1857b() > 0) {
                        intent.putExtra("bd.message.rate.REDIRECTION", System.currentTimeMillis());
                    }
                    a = C0578p.m2514a(this.a, intent, PushConstants.ACTION_MESSAGE, f);
                    C0578p.m2546b(">>> Deliver message to client: " + a2.f1368a.m1867c() + " result: " + a, this.a);
                    break;
                } catch (NameNotFoundException e2) {
                    f = ">>> NOT deliver to app: " + a2.f1368a.m1867c() + ", package has been uninstalled.";
                    C0603f.m2694a(this.a, e);
                    C0578p.m2546b(f, this.a);
                    a = 7;
                    break;
                }
            case SDK_CLIENT:
                try {
                    a3 = C0578p.m2542a(this.a, h, bArr, j, f);
                    this.a.getPackageManager().getPackageInfo(f, 128);
                    Intent intent2 = new Intent();
                    intent2.setPackage(f);
                    intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                    intent2.putExtra("message_string", str);
                    intent2.putExtra("baidu_message_type", i);
                    intent2.putExtra("baidu_message_body", bArr);
                    intent2.putExtra("baidu_message_secur_info", a3);
                    intent2.putExtra("message_id", h);
                    C0578p.m2545b(this.a, intent2, "com.baidu.android.pushservice.action.SDK_MESSAGE", f);
                    a = 0;
                    break;
                } catch (NameNotFoundException e3) {
                    C0439h.m1902a(this.a).m1893a(a2.f1369b, false);
                    a = 8;
                    break;
                }
            default:
                if (VERSION.SDK_INT < 24) {
                    C0603f.m2694a(this.a, e);
                }
                C0578p.m2546b(">>> Don't found app  in OldPrivateMessage " + str, this.a);
                a = 7;
                break;
        }
        C0621g c0621g = new C0621g();
        c0621g.m2740a(a);
        return c0621g;
    }
}
