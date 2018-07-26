package com.baidu.carlife.logic;

import android.app.KeyguardManager;
import android.content.Context;
import com.baidu.carlife.core.C1260i;

/* compiled from: PhonePowerManager */
/* renamed from: com.baidu.carlife.logic.r */
public class C1869r {
    /* renamed from: a */
    public static String f5792a = C1869r.class.getSimpleName();
    /* renamed from: b */
    private static final Object f5793b = new Object();
    /* renamed from: c */
    private static C1869r f5794c;
    /* renamed from: d */
    private Context f5795d;
    /* renamed from: e */
    private KeyguardManager f5796e;

    /* renamed from: a */
    public void m7129a(Context context) {
        this.f5795d = context;
    }

    /* renamed from: a */
    public static C1869r m7128a() {
        if (f5794c == null) {
            synchronized (f5793b) {
                if (f5794c == null) {
                    f5794c = new C1869r();
                }
            }
        }
        return f5794c;
    }

    /* renamed from: b */
    public boolean m7130b() {
        this.f5796e = (KeyguardManager) this.f5795d.getSystemService("keyguard");
        if (!this.f5796e.inKeyguardRestrictedInputMode()) {
            return false;
        }
        C1260i.m4435b(f5792a, "getKeyGuardState:keyguard on !");
        return true;
    }
}
