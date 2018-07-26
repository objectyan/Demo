package com.facebook.drawee.p267f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: GestureDetector */
/* renamed from: com.facebook.drawee.f.a */
public class C5421a {
    @VisibleForTesting
    /* renamed from: a */
    C5420a f22155a;
    @VisibleForTesting
    /* renamed from: b */
    final float f22156b;
    @VisibleForTesting
    /* renamed from: c */
    boolean f22157c;
    @VisibleForTesting
    /* renamed from: d */
    boolean f22158d;
    @VisibleForTesting
    /* renamed from: e */
    long f22159e;
    @VisibleForTesting
    /* renamed from: f */
    float f22160f;
    @VisibleForTesting
    /* renamed from: g */
    float f22161g;

    /* compiled from: GestureDetector */
    /* renamed from: com.facebook.drawee.f.a$a */
    public interface C5420a {
        /* renamed from: r */
        boolean m18630r();
    }

    public C5421a(Context context) {
        this.f22156b = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        m18632a();
    }

    /* renamed from: a */
    public static C5421a m18631a(Context context) {
        return new C5421a(context);
    }

    /* renamed from: a */
    public void m18632a() {
        this.f22155a = null;
        m18635b();
    }

    /* renamed from: b */
    public void m18635b() {
        this.f22157c = false;
        this.f22158d = false;
    }

    /* renamed from: a */
    public void m18633a(C5420a clickListener) {
        this.f22155a = clickListener;
    }

    /* renamed from: c */
    public boolean m18636c() {
        return this.f22157c;
    }

    /* renamed from: a */
    public boolean m18634a(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.f22157c = true;
                this.f22158d = true;
                this.f22159e = event.getEventTime();
                this.f22160f = event.getX();
                this.f22161g = event.getY();
                break;
            case 1:
                this.f22157c = false;
                if (Math.abs(event.getX() - this.f22160f) > this.f22156b || Math.abs(event.getY() - this.f22161g) > this.f22156b) {
                    this.f22158d = false;
                }
                if (this.f22158d && event.getEventTime() - this.f22159e <= ((long) ViewConfiguration.getLongPressTimeout()) && this.f22155a != null) {
                    this.f22155a.m18630r();
                }
                this.f22158d = false;
                break;
            case 2:
                if (Math.abs(event.getX() - this.f22160f) > this.f22156b || Math.abs(event.getY() - this.f22161g) > this.f22156b) {
                    this.f22158d = false;
                    break;
                }
            case 3:
                this.f22157c = false;
                this.f22158d = false;
                break;
        }
        return true;
    }
}
