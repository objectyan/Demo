package com.baidu.carlife.util;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1262l;

/* compiled from: ToastUtil */
/* renamed from: com.baidu.carlife.util.w */
public class C2201w {
    /* renamed from: b */
    private static C2201w f7050b = new C2201w();
    /* renamed from: a */
    private TextView f7051a;

    /* renamed from: a */
    public static C2201w m8369a() {
        return f7050b;
    }

    private C2201w() {
    }

    /* renamed from: a */
    public void m8377a(TextView textView) {
        this.f7051a = textView;
    }

    /* renamed from: c */
    private void m8376c() {
        this.f7051a = null;
    }

    /* renamed from: b */
    private void m8375b(final String content, final int time) {
        C1262l.m4465a().post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2201w f7049c;

            public void run() {
                if (this.f7049c.f7051a != null) {
                    this.f7049c.f7051a.setText(content);
                    long duration = 2500;
                    if (time == 1) {
                        duration = 3500;
                    }
                    ObjectAnimator animator = ObjectAnimator.ofFloat(this.f7049c.f7051a, "alpha", new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f}).setDuration(duration);
                    if (VERSION.SDK_INT >= 18) {
                        animator.setAutoCancel(true);
                    }
                    animator.start();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m8370a(int rId) {
        C2201w.m8372a(C1157a.m3876a().getString(rId));
    }

    /* renamed from: a */
    public static void m8372a(String content) {
        C2201w.m8373a(content, 0);
    }

    /* renamed from: a */
    public static void m8371a(int rId, int time) {
        C2201w.m8373a(C1157a.m3876a().getString(rId), time);
    }

    /* renamed from: a */
    public static void m8373a(String content, int time) {
        C2201w.m8369a().m8375b(content, time);
    }

    /* renamed from: b */
    public static void m8374b() {
        C2201w.m8369a().m8376c();
    }
}
