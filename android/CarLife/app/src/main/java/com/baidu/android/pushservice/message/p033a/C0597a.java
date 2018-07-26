package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import com.baidu.android.pushservice.message.C0621g;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.a */
public class C0597a extends C0596c {
    public C0597a(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C0621g mo1294a(C0626k c0626k, byte[] bArr) {
        long b = c0626k.m2759b();
        long c = c0626k.m2762c();
        long d = c0626k.m2764d();
        C0612l a = C0612l.m2705a(c0626k.m2770i());
        String h = c0626k.m2769h();
        String e = c0626k.m2766e();
        c -= b;
        b = d - b;
        PublicMsg publicMsg = new PublicMsg();
        C0621g c0621g = new C0621g();
        if (!c0626k.m2758a() || (c <= 0 && b > 0)) {
            C0621g c0621g2;
            if (a.equals(C0612l.MSG_TYPE_ALARM_NOTIFICATION)) {
                a = C0612l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
            } else if (a.equals(C0612l.MSG_TYPE_ALARM_MESSAGE)) {
                a = C0612l.MSG_TYPE_PRIVATE_MESSAGE;
            }
            C0596c a2 = new C0611k(this.a).m2704a(a);
            if (a2 != null) {
                c0621g = a2.mo1294a(c0626k, bArr);
                C0463a.m2011d(this.a, c0626k.m2769h());
                if (a.equals(C0612l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION)) {
                    publicMsg.handleAlarmMessage(this.a, "010701", h, e);
                    c0621g2 = c0621g;
                } else {
                    if (a.equals(C0612l.MSG_TYPE_PRIVATE_MESSAGE)) {
                        publicMsg.handleAlarmMessage(this.a, "010702", h, e);
                    }
                    c0621g2 = c0621g;
                }
            } else {
                c0621g2 = c0621g;
            }
            return c0621g2;
        } else if (b <= 0) {
            publicMsg.handleAlarmMessage(this.a, "010704", h, e);
            C0463a.m2011d(this.a, c0626k.m2769h());
            return c0621g;
        } else {
            c0626k.m2760b((c * 1000) + System.currentTimeMillis());
            c0626k.m2763c((b * 1000) + System.currentTimeMillis());
            C0578p.m2525a(this.a, c0626k, bArr);
            c0621g.m2740a(1);
            return c0621g;
        }
    }
}
