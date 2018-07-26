package com.facebook.imagepipeline.p153l;

import com.facebook.common.p257e.C5320a;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: BaseConsumer */
/* renamed from: com.facebook.imagepipeline.l.b */
public abstract class C5518b<T> implements C5517j<T> {
    /* renamed from: a */
    private boolean f22426a = false;

    /* renamed from: a */
    protected abstract void mo4089a();

    /* renamed from: a */
    protected abstract void mo4091a(T t, boolean z);

    /* renamed from: a */
    protected abstract void mo4092a(Throwable th);

    /* renamed from: b */
    public synchronized void mo4087b(@Nullable T newResult, boolean isLast) {
        if (!this.f22426a) {
            this.f22426a = isLast;
            try {
                mo4091a(newResult, isLast);
            } catch (Exception e) {
                m18996a(e);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo4088b(Throwable t) {
        if (!this.f22426a) {
            this.f22426a = true;
            try {
                mo4092a(t);
            } catch (Exception e) {
                m18996a(e);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo4085b() {
        if (!this.f22426a) {
            this.f22426a = true;
            try {
                mo4089a();
            } catch (Exception e) {
                m18996a(e);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo4086b(float progress) {
        if (!this.f22426a) {
            try {
                mo4090a(progress);
            } catch (Exception e) {
                m18996a(e);
            }
        }
    }

    /* renamed from: a */
    protected void mo4090a(float progress) {
    }

    /* renamed from: a */
    protected void m18996a(Exception e) {
        C5320a.m18189f(getClass(), "unhandled exception", (Throwable) e);
    }
}
