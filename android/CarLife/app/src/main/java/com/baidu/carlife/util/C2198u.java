package com.baidu.carlife.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.tts.IBNTTSPlayerPCMListener;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.p087l.C1663a;

/* compiled from: TTSPCMUtil */
/* renamed from: com.baidu.carlife.util.u */
public class C2198u {
    /* renamed from: b */
    private static final int f7036b = 110;
    /* renamed from: c */
    private static final int f7037c = 111;
    /* renamed from: d */
    private static final int f7038d = 2000;
    /* renamed from: e */
    private static C2198u f7039e = null;
    /* renamed from: a */
    IBNTTSPlayerPCMListener f7040a = new C21961(this);
    /* renamed from: f */
    private C1663a f7041f = C1663a.m5979a();
    /* renamed from: g */
    private boolean f7042g = false;
    /* renamed from: h */
    private boolean f7043h = false;
    /* renamed from: i */
    private Handler f7044i;
    /* renamed from: j */
    private HandlerThread f7045j = new HandlerThread("TTSPCMUtil");
    /* renamed from: k */
    private int f7046k = 0;

    /* compiled from: TTSPCMUtil */
    /* renamed from: com.baidu.carlife.util.u$1 */
    class C21961 implements IBNTTSPlayerPCMListener {
        /* renamed from: a */
        final /* synthetic */ C2198u f7034a;

        C21961(C2198u this$0) {
            this.f7034a = this$0;
        }

        public void handlePCMStream(byte[] arg0, boolean arg1) {
            if (this.f7034a.f7043h) {
                this.f7034a.f7041f.m6029c(arg0, arg0.length);
            } else if (this.f7034a.f7042g) {
                this.f7034a.f7041f.m6024b(arg0, arg0.length);
            }
        }

        public void notifyTTSStart() {
            C1261k.m4461b(508);
            C1260i.m4435b("jason2", "==============notifyTTSStart");
            if (C1915a.m7321a().m7336f()) {
                if (this.f7034a.f7042g) {
                    this.f7034a.f7042g = false;
                    this.f7034a.f7044i.removeMessages(111);
                    if (this.f7034a.f7041f.m5982C()) {
                        this.f7034a.f7046k = 0;
                        this.f7034a.f7041f.m5981B();
                    }
                }
                if (this.f7034a.f7043h) {
                    this.f7034a.f7044i.removeMessages(110);
                    if (this.f7034a.f7041f.m5983D()) {
                        this.f7034a.f7041f.m5984E();
                    }
                } else {
                    this.f7034a.f7043h = true;
                }
                this.f7034a.f7041f.m6027c(16000, 1, 16);
            } else if (!C1915a.m7321a().m7336f()) {
                if (this.f7034a.f7043h) {
                    this.f7034a.f7043h = false;
                    this.f7034a.f7044i.removeMessages(110);
                    if (this.f7034a.f7041f.m5983D()) {
                        this.f7034a.f7041f.m5984E();
                    }
                }
                if (this.f7034a.f7042g) {
                    this.f7034a.f7044i.removeMessages(111);
                    if (!this.f7034a.f7041f.m5982C()) {
                        this.f7034a.f7041f.m6021b(16000, 1, 16);
                    }
                } else {
                    this.f7034a.f7042g = true;
                    this.f7034a.f7041f.m6021b(16000, 1, 16);
                }
                this.f7034a.f7046k = this.f7034a.f7046k + 1;
            }
        }

        public void notifyTTSEnd() {
            C1261k.m4461b(509);
            C1260i.m4435b("jason2", "===============notifyTTSEnd");
            if (this.f7034a.f7043h) {
                this.f7034a.f7044i.sendEmptyMessageDelayed(110, 2000);
            } else if (this.f7034a.f7042g) {
                this.f7034a.f7046k = this.f7034a.f7046k - 1;
                this.f7034a.f7044i.sendEmptyMessageDelayed(111, 2000);
            }
        }
    }

    /* compiled from: TTSPCMUtil */
    /* renamed from: com.baidu.carlife.util.u$a */
    private class C2197a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C2198u f7035a;

        public C2197a(C2198u c2198u, Looper looper) {
            this.f7035a = c2198u;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 110) {
                if (this.f7035a.f7043h) {
                    this.f7035a.f7043h = false;
                    this.f7035a.f7041f.m5984E();
                }
            } else if (msg.what == 111 && this.f7035a.f7042g && this.f7035a.f7046k <= 0) {
                this.f7035a.f7046k = 0;
                this.f7035a.f7042g = false;
                this.f7035a.f7041f.m5981B();
            }
        }
    }

    /* renamed from: a */
    public static C2198u m8354a() {
        if (f7039e == null) {
            f7039e = new C2198u();
        }
        return f7039e;
    }

    private C2198u() {
        this.f7045j.start();
        this.f7044i = new C2197a(this, this.f7045j.getLooper());
    }

    /* renamed from: b */
    public IBNTTSPlayerPCMListener m8364b() {
        return this.f7040a;
    }

    /* renamed from: c */
    public void m8365c() {
        if (this.f7042g && this.f7041f != null) {
            this.f7042g = false;
            this.f7046k = 0;
            this.f7041f.m5981B();
        }
    }

    /* renamed from: d */
    public void m8366d() {
        if (this.f7043h && this.f7041f != null) {
            this.f7043h = false;
            this.f7041f.m5984E();
        }
    }

    /* renamed from: e */
    public void m8367e() {
        if (this.f7041f == null) {
            return;
        }
        if (C1912n.m7270a().m7313l()) {
            this.f7041f.m5984E();
        } else {
            this.f7041f.m5981B();
        }
    }
}
