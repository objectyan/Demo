package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.baidu.lbsapi.auth.h */
class C3168h extends Thread {
    /* renamed from: a */
    Handler f17238a = null;
    /* renamed from: b */
    private Object f17239b = new Object();
    /* renamed from: c */
    private boolean f17240c = false;

    C3168h() {
    }

    C3168h(String str) {
        super(str);
    }

    /* renamed from: a */
    public void m13247a() {
        if (C3152a.f17205a) {
            C3152a.m13186a("Looper thread quit()");
        }
        this.f17238a.getLooper().quit();
    }

    /* renamed from: b */
    public void m13248b() {
        synchronized (this.f17239b) {
            try {
                if (!this.f17240c) {
                    this.f17239b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void m13249c() {
        synchronized (this.f17239b) {
            this.f17240c = true;
            this.f17239b.notifyAll();
        }
    }

    public void run() {
        Looper.prepare();
        this.f17238a = new Handler();
        if (C3152a.f17205a) {
            C3152a.m13186a("new Handler() finish!!");
        }
        Looper.loop();
        if (C3152a.f17205a) {
            C3152a.m13186a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
