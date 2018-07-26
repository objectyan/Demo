package com.baidu.ufosdk.p247a;

import android.content.Context;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;
import com.baidu.ufosdk.util.C5210c;

/* compiled from: GetChatThread */
/* renamed from: com.baidu.ufosdk.a.a */
public final class C5165a extends Thread {
    /* renamed from: a */
    private Context f21317a;
    /* renamed from: b */
    private String f21318b;
    /* renamed from: c */
    private boolean f21319c = false;
    /* renamed from: d */
    private boolean f21320d = false;
    /* renamed from: e */
    private boolean f21321e = false;
    /* renamed from: f */
    private final long f21322f = 300;

    public C5165a(Context context, String str) {
        this.f21317a = context;
        this.f21318b = str;
    }

    /* renamed from: a */
    public final void m17550a() {
        this.f21319c = true;
    }

    /* renamed from: b */
    public final void m17552b() {
        this.f21319c = false;
    }

    /* renamed from: a */
    public final void m17551a(String str) {
        this.f21318b = str;
    }

    public final void run() {
        if (UfoSDK.clientid.length() != 0) {
            while (!this.f21319c) {
                C5210c.m17734b("###################");
                try {
                    Thread.sleep(300);
                } catch (Throwable e) {
                    C5210c.m17733a("Interrupted!", e);
                }
                if (!this.f21320d) {
                    Context context = this.f21317a;
                    String str = UfoSDK.clientid;
                    C5180a.m17576d(context, this.f21318b);
                }
                try {
                    if (!this.f21321e) {
                        Thread.sleep((long) (C5167a.an * 1000));
                    }
                } catch (InterruptedException e2) {
                    C5210c.m17736d("GetChatThread Interrupted! Maybe it's time to wakeup.");
                }
            }
        }
    }
}
