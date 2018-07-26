package com.baidu.ufosdk.p247a;

import android.content.Context;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;
import com.baidu.ufosdk.util.C5210c;

/* compiled from: GetHistoryListThread */
/* renamed from: com.baidu.ufosdk.a.b */
public final class C5166b extends Thread {
    /* renamed from: a */
    private Context f21323a;
    /* renamed from: b */
    private boolean f21324b = false;
    /* renamed from: c */
    private boolean f21325c = false;
    /* renamed from: d */
    private boolean f21326d = false;
    /* renamed from: e */
    private final long f21327e = 300;
    /* renamed from: f */
    private String f21328f = "";

    public C5166b(Context context) {
        this.f21323a = context;
    }

    /* renamed from: a */
    public final void m17553a() {
        this.f21324b = true;
    }

    /* renamed from: b */
    public final void m17554b() {
        this.f21324b = false;
    }

    public final void run() {
        this.f21328f = UfoSDK.clientid;
        if (this.f21328f.length() != 0) {
            while (!this.f21324b) {
                try {
                    Thread.sleep(300);
                } catch (Throwable e) {
                    C5210c.m17733a("Interrupted!", e);
                }
                if (!this.f21325c) {
                    C5180a.m17574c(this.f21323a);
                }
                try {
                    if (!this.f21326d) {
                        Thread.sleep((long) (C5167a.ao * 1000));
                    }
                } catch (InterruptedException e2) {
                    C5210c.m17736d("GetChatThread Interrupted! Maybe it's time to wakeup.");
                }
            }
        }
    }
}
