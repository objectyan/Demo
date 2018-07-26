package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.i */
public class C0608i extends C0596c {
    public C0608i(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        int i;
        String e = c0626k.m2766e();
        String h = c0626k.m2769h();
        PublicMsg a = C0609j.m2702a(this.a, h, e, bArr);
        if (a == null || TextUtils.isEmpty(a.mTitle) || TextUtils.isEmpty(a.mDescription) || TextUtils.isEmpty(a.mUrl)) {
            C0578p.m2546b(">>> pMsg JSON parsing error!", this.a);
            i = 2;
        } else if (C0603f.m2697a(this.a, a) && C0578p.m2568e(this.a, this.a.getPackageName())) {
            C0578p.m2546b(">>> Show pMsg Notification!", this.a);
            C0603f.m2692a(this.a, a, h);
            i = 1;
        } else {
            C0578p.m2546b(">>> Don't Show pMsg Notification! --- IsBaiduApp = " + C0578p.m2568e(this.a, this.a.getPackageName()), this.a);
            i = 0;
        }
        C0621g c0621g = new C0621g();
        c0621g.m2740a(i);
        return c0621g;
    }
}
