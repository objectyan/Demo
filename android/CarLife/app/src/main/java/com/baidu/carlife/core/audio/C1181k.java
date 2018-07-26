package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.audio.C1163a.C1161d;
import com.baidu.carlife.core.connect.C1218e;

/* compiled from: MediaChannelSend */
/* renamed from: com.baidu.carlife.core.audio.k */
public class C1181k {
    /* renamed from: a */
    private static C1181k f3112a;
    /* renamed from: b */
    private boolean f3113b = false;

    private C1181k() {
    }

    /* renamed from: a */
    public static C1181k m4030a() {
        if (f3112a == null) {
            f3112a = new C1181k();
        }
        return f3112a;
    }

    /* renamed from: a */
    public synchronized int m4033a(byte[] data, int len, C1161d type) {
        int i = -1;
        synchronized (this) {
            if (!C1163a.m3882a().m3895g()) {
                if (type == C1161d.INIT || type == C1161d.RESUME) {
                    m4031a(true);
                } else if (type == C1161d.PAUSE || type == C1161d.STOP) {
                    m4031a(false);
                }
                if ((type != C1161d.NORMAL || m4032b()) && C1163a.m3883h() && len >= 0) {
                    i = C1218e.m4228a().m4243c(data, len);
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m4031a(boolean status) {
        this.f3113b = status;
    }

    /* renamed from: b */
    private boolean m4032b() {
        return this.f3113b;
    }
}
