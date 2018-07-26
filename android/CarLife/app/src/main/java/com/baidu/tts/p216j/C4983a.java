package com.baidu.tts.p216j;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ASafeLife */
/* renamed from: com.baidu.tts.j.a */
public abstract class C4983a implements C4958b {
    /* renamed from: d */
    protected final Lock f20694d = new ReentrantLock();
    /* renamed from: e */
    protected final Condition f20695e = this.f20694d.newCondition();

    /* compiled from: ASafeLife */
    /* renamed from: com.baidu.tts.j.a$a */
    public interface C5110a {
        /* renamed from: a */
        void m17336a();
    }

    /* renamed from: g */
    protected abstract TtsError mo3832g();

    /* renamed from: h */
    protected abstract void mo3833h();

    /* renamed from: i */
    protected abstract void mo3834i();

    /* renamed from: j */
    protected abstract void mo3835j();

    /* renamed from: k */
    protected abstract void mo3836k();

    /* renamed from: l */
    protected abstract void mo3837l();

    /* renamed from: m */
    public abstract boolean mo3838m();

    /* renamed from: n */
    public abstract boolean mo3839n();

    /* renamed from: b */
    public synchronized TtsError mo3782b() {
        return mo3832g();
    }

    /* renamed from: A */
    public synchronized void m16611A() {
        mo3833h();
    }

    /* renamed from: c */
    public synchronized void mo3784c() {
        mo3834i();
        try {
            this.f20694d.lock();
            this.f20695e.signalAll();
            this.f20694d.unlock();
        } catch (Exception e) {
            e.printStackTrace();
            this.f20694d.unlock();
        } catch (Throwable th) {
            this.f20694d.unlock();
        }
    }

    /* renamed from: d */
    public synchronized void mo3785d() {
        mo3835j();
    }

    /* renamed from: e */
    public synchronized void mo3786e() {
        mo3836k();
    }

    /* renamed from: f */
    public synchronized void mo3787f() {
        mo3837l();
    }

    /* renamed from: a */
    public void m16614a(C5110a c5110a) throws InterruptedException {
        while (mo3838m()) {
            m16616b(c5110a);
        }
    }

    /* renamed from: b */
    public void m16616b(C5110a c5110a) throws InterruptedException {
        try {
            this.f20694d.lock();
            if (c5110a != null) {
                c5110a.m17336a();
            }
            LoggerProxy.m17001d("ASafeLife", "before await");
            this.f20695e.await();
            LoggerProxy.m17001d("ASafeLife", "after await");
        } finally {
            this.f20694d.unlock();
        }
    }

    /* renamed from: B */
    public void m16612B() {
        Thread.currentThread().interrupt();
    }

    /* renamed from: C */
    public boolean m16613C() {
        try {
            m16614a(null);
        } catch (InterruptedException e) {
            m16612B();
        }
        if (mo3839n()) {
            return false;
        }
        return true;
    }
}
