package com.baidu.tts.p218b.p219a.p223b;

import com.baidu.tts.p225m.C5141b;
import com.baidu.tts.p233f.C5092j;

/* compiled from: MixStrategy */
/* renamed from: com.baidu.tts.b.a.b.c */
public class C4998c {
    /* renamed from: a */
    private C5141b f20711a;
    /* renamed from: b */
    private C5092j f20712b;

    /* renamed from: a */
    public void m16746a(C5141b c5141b) {
        this.f20711a = c5141b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m16747a() {
        /*
        r7 = this;
        r6 = 9;
        r2 = 1;
        r1 = 0;
        r0 = com.baidu.tts.p236h.p238b.C5107b.m17306a();	 Catch:{ Exception -> 0x006d }
        r0 = r0.m17316h();	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x0061;
    L_0x000e:
        r3 = r7.m16744b();	 Catch:{ Exception -> 0x006d }
        if (r3 == 0) goto L_0x0037;
    L_0x0014:
        r3 = r7.f20711a;	 Catch:{ Exception -> 0x006d }
        r3 = r3.m17396a();	 Catch:{ Exception -> 0x006d }
        r4 = r7.f20712b;	 Catch:{ Exception -> 0x006d }
        r5 = com.baidu.tts.p233f.C5092j.HIGH_SPEED_SYNTHESIZE;	 Catch:{ Exception -> 0x006d }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x006d }
        if (r4 != 0) goto L_0x002e;
    L_0x0024:
        r4 = r7.f20712b;	 Catch:{ Exception -> 0x006d }
        r5 = com.baidu.tts.p233f.C5092j.HIGH_SPEED_SYNTHESIZE_WIFI;	 Catch:{ Exception -> 0x006d }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x006d }
        if (r4 == 0) goto L_0x0063;
    L_0x002e:
        r4 = com.baidu.tts.p233f.C5094l.FAST_SWITCH;	 Catch:{ Exception -> 0x006d }
        r4 = r4.m17280b();	 Catch:{ Exception -> 0x006d }
        r3.m16825c(r4);	 Catch:{ Exception -> 0x006d }
    L_0x0037:
        r3 = "connectivity";
        r0 = r0.getSystemService(r3);	 Catch:{ Exception -> 0x006d }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x006d }
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x0061;
    L_0x0046:
        r3 = r0.isConnected();	 Catch:{ Exception -> 0x006d }
        if (r3 == 0) goto L_0x0061;
    L_0x004c:
        r3 = r0.getType();	 Catch:{ Exception -> 0x006d }
        r0 = r0.getSubtype();	 Catch:{ Exception -> 0x006d }
        r4 = com.baidu.tts.p218b.p219a.p223b.C4998c.C49971.f20710a;	 Catch:{ Exception -> 0x006d }
        r5 = r7.f20712b;	 Catch:{ Exception -> 0x006d }
        r5 = r5.ordinal();	 Catch:{ Exception -> 0x006d }
        r4 = r4[r5];	 Catch:{ Exception -> 0x006d }
        switch(r4) {
            case 1: goto L_0x0079;
            case 2: goto L_0x0079;
            case 3: goto L_0x0083;
            case 4: goto L_0x0083;
            default: goto L_0x0061;
        };	 Catch:{ Exception -> 0x006d }
    L_0x0061:
        r0 = r1;
    L_0x0062:
        return r0;
    L_0x0063:
        r4 = com.baidu.tts.p233f.C5094l.MIX_ONLINE_REQUEST_TIMEOUT;	 Catch:{ Exception -> 0x006d }
        r4 = r4.m17280b();	 Catch:{ Exception -> 0x006d }
        r3.m16825c(r4);	 Catch:{ Exception -> 0x006d }
        goto L_0x0037;
    L_0x006d:
        r0 = move-exception;
        r2 = "MixStrategy";
        r0 = r0.toString();
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.m17001d(r2, r0);
        goto L_0x0061;
    L_0x0079:
        r0 = r7.m16745c(r3);	 Catch:{ Exception -> 0x006d }
        if (r0 != 0) goto L_0x0081;
    L_0x007f:
        if (r3 != r6) goto L_0x0061;
    L_0x0081:
        r0 = r2;
        goto L_0x0062;
    L_0x0083:
        r4 = r7.m16745c(r3);	 Catch:{ Exception -> 0x006d }
        if (r4 != 0) goto L_0x0091;
    L_0x0089:
        if (r3 == r6) goto L_0x0091;
    L_0x008b:
        r0 = r7.m16742a(r0);	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x0061;
    L_0x0091:
        r0 = r2;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.b.a.b.c.a():boolean");
    }

    /* renamed from: b */
    private boolean m16744b() {
        C5092j c5092j = null;
        try {
            c5092j = this.f20711a.m17401c();
        } catch (Exception e) {
        }
        if (this.f20712b == null) {
            if (c5092j == null) {
                this.f20712b = C5092j.DEFAULT;
                return true;
            }
            this.f20712b = c5092j;
            return true;
        } else if (c5092j == null) {
            return false;
        } else {
            if (this.f20712b.equals(c5092j)) {
                return false;
            }
            this.f20712b = c5092j;
            return true;
        }
    }

    /* renamed from: a */
    private boolean m16742a(int i) {
        return m16743b(i) >= 2;
    }

    /* renamed from: b */
    private int m16743b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    private boolean m16745c(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}
