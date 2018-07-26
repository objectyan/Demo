package com.baidu.carlife;

import android.content.Intent;
import android.content.res.Configuration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CarlifeLifeCycleManager */
/* renamed from: com.baidu.carlife.b */
public class C1030b {
    /* renamed from: c */
    private static C1030b f2635c = new C1030b();
    /* renamed from: a */
    private boolean f2636a;
    /* renamed from: b */
    private List<C1080c> f2637b = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static C1030b m3276a() {
        return f2635c;
    }

    private C1030b() {
    }

    /* renamed from: a */
    public void m3279a(C1080c listener) {
        if (listener != null && !this.f2637b.contains(listener)) {
            this.f2637b.add(listener);
        }
    }

    /* renamed from: b */
    public void m3281b(C1080c listener) {
        if (this.f2637b.contains(listener)) {
            this.f2637b.remove(listener);
        }
    }

    /* renamed from: b */
    public void m3280b() {
        for (C1080c listener : this.f2637b) {
            listener.mo1405e();
        }
    }

    /* renamed from: c */
    public void m3282c() {
        for (C1080c listener : this.f2637b) {
            listener.mo1400a();
        }
    }

    /* renamed from: d */
    public void m3283d() {
        for (C1080c listener : this.f2637b) {
            listener.mo1404d();
        }
    }

    /* renamed from: e */
    public void m3284e() {
        for (C1080c listener : this.f2637b) {
            listener.mo1403c();
        }
    }

    /* renamed from: f */
    public void m3285f() {
        for (C1080c listener : this.f2637b) {
            listener.mo1402b();
        }
    }

    /* renamed from: g */
    public void m3286g() {
        for (C1080c listener : this.f2637b) {
            listener.mo1406f();
        }
    }

    /* renamed from: a */
    public void m3277a(Intent intent) {
        for (C1080c listener : this.f2637b) {
            listener.mo1401a(intent);
        }
    }

    /* renamed from: a */
    public void m3278a(Configuration newConfig) {
        for (C1080c listener : this.f2637b) {
            listener.onConfigurationChanged(newConfig);
        }
    }
}
