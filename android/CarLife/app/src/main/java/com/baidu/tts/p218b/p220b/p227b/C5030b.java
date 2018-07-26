package com.baidu.tts.p218b.p220b.p227b;

import android.media.AudioTrack;
import com.baidu.mobstat.Config;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p220b.C4962a;
import com.baidu.tts.p225m.C5028c;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p233f.C5087e;
import com.baidu.tts.p233f.C5093k;
import com.baidu.tts.p239i.p240a.C5108a;
import com.baidu.tts.p239i.p240a.C5109b;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AudioTrackPlayer */
/* renamed from: com.baidu.tts.b.b.b.b */
public class C5030b extends C5027a {
    /* renamed from: b */
    protected final Lock f20806b = new ReentrantLock();
    /* renamed from: c */
    protected final Condition f20807c = this.f20806b.newCondition();
    /* renamed from: d */
    private volatile AudioTrack f20808d;
    /* renamed from: e */
    private C5029a f20809e;
    /* renamed from: f */
    private C5109b f20810f = new C5109b();
    /* renamed from: g */
    private boolean f20811g = false;
    /* renamed from: h */
    private int f20812h;

    /* compiled from: AudioTrackPlayer */
    /* renamed from: com.baidu.tts.b.b.b.b$a */
    public static class C5029a extends C5028c<C5029a> {
        /* renamed from: a */
        private C5093k f20800a = C5093k.HZ16K;
        /* renamed from: b */
        private int f20801b = 4;
        /* renamed from: c */
        private int f20802c = 2;
        /* renamed from: d */
        private int f20803d = 1;
        /* renamed from: e */
        private float f20804e = 1.0f;
        /* renamed from: f */
        private float f20805f = 1.0f;

        /* renamed from: a */
        public int m16968a() {
            return this.f20800a.m17278a();
        }

        /* renamed from: b */
        public int m16970b() {
            return this.f20801b;
        }

        /* renamed from: c */
        public int m16972c() {
            return this.f20802c;
        }

        /* renamed from: d */
        public int m16973d() {
            return this.f20803d;
        }

        /* renamed from: e */
        public float m16974e() {
            return this.f20804e;
        }

        /* renamed from: a */
        public void m16969a(float f) {
            this.f20804e = f;
        }

        /* renamed from: f */
        public float m16975f() {
            return this.f20805f;
        }

        /* renamed from: b */
        public void m16971b(float f) {
            this.f20805f = f;
        }
    }

    /* renamed from: a */
    public void mo3863a(C4962a c4962a) {
        this.a = c4962a;
    }

    /* renamed from: a */
    public <AudioTrackPlayerParams> void mo3864a(AudioTrackPlayerParams audioTrackPlayerParams) {
        this.f20809e = (C5029a) audioTrackPlayerParams;
    }

    /* renamed from: a */
    public TtsError mo3861a() {
        int a = this.f20809e.m16968a();
        int b = this.f20809e.m16970b();
        int c = this.f20809e.m16972c();
        this.f20808d = new AudioTrack(this.f20809e.m16966g(), a, b, c, m16976a(a, b, c), this.f20809e.m16973d());
        this.f20808d.setStereoVolume(this.f20809e.m16974e(), this.f20809e.m16975f());
        return null;
    }

    /* renamed from: a */
    private int m16976a(int i, int i2, int i3) {
        int i4;
        int i5 = 2;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3) * 2;
        switch (i2) {
            case 1:
            case 2:
            case 4:
                i4 = 1;
                break;
            case 3:
            case 12:
                i4 = 2;
                break;
            default:
                i4 = Integer.bitCount(i2);
                break;
        }
        if (i3 == 3) {
            i5 = 1;
        }
        if (minBufferSize % (i5 * i4) != 0 || minBufferSize < 1) {
            return Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        }
        return minBufferSize;
    }

    /* renamed from: a */
    public int mo3871a(int i) {
        if (i != this.f20809e.m16966g()) {
            int a = this.f20809e.m16968a();
            int b = this.f20809e.m16970b();
            int c = this.f20809e.m16972c();
            int i2 = i;
            this.f20808d = new AudioTrack(i2, a, b, c, m16976a(a, b, c), this.f20809e.m16973d());
            this.f20809e.m16964a(i);
            this.f20808d.setStereoVolume(this.f20809e.m16974e(), this.f20809e.m16975f());
            this.f20808d.play();
        }
        return 0;
    }

    /* renamed from: b */
    public void mo3865b() {
        if (this.f20808d != null) {
            this.f20808d.play();
        }
    }

    /* renamed from: c */
    public void mo3866c() {
        this.f20811g = true;
        if (this.f20808d != null) {
            this.f20808d.pause();
        }
    }

    /* renamed from: d */
    public void mo3867d() {
        this.f20811g = false;
        if (this.f20808d != null) {
            this.f20808d.play();
        }
        m16983g();
    }

    /* renamed from: g */
    private void m16983g() {
        try {
            this.f20806b.lock();
            this.f20807c.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f20806b.unlock();
        }
    }

    /* renamed from: e */
    public void mo3868e() {
        if (this.f20811g) {
            this.f20811g = false;
            m16983g();
        }
        if (this.f20808d != null) {
            this.f20808d.pause();
            this.f20808d.flush();
            this.f20808d.stop();
        }
    }

    /* renamed from: f */
    public TtsError mo3869f() {
        mo3868e();
        if (this.f20808d != null) {
            this.f20808d.release();
        }
        this.f20808d = null;
        return null;
    }

    /* renamed from: a */
    public int mo3870a(float f, float f2) {
        int stereoVolume = this.f20808d.setStereoVolume(f, f2);
        this.f20809e.m16969a(f);
        this.f20809e.m16971b(f2);
        return stereoVolume;
    }

    /* renamed from: a */
    public TtsError mo3862a(C5145h c5145h) {
        LoggerProxy.m17001d("AudioTrackPlayer", "enter put");
        if (c5145h != null) {
            C5145h c5145h2;
            C5087e g = c5145h.m17434g();
            if (g == C5087e.SYN_START) {
                m16978b(c5145h);
            }
            if (g == C5087e.SYN_DATA) {
                this.f20810f.m17334c(c5145h.m17427c());
            }
            byte[] d = c5145h.m17430d();
            if (d != null) {
                this.f20810f.m17332b(d.length);
            }
            loop3:
            while (this.f20810f.hasNext()) {
                C5108a c = this.f20810f.m17333c();
                int i = 0;
                int a = c.m17319a();
                int b = c.m17323b();
                while (i < b && this.f20808d.getPlayState() != 1) {
                    int i2 = b - i;
                    LoggerProxy.m17001d("AudioTrackPlayer", "before write");
                    i2 = this.f20808d.write(d, i + a, i2);
                    LoggerProxy.m17001d("AudioTrackPlayer", "writtenbytes=" + i2 + "--offset=" + i + "--dataLength=" + b);
                    if (i2 >= 0) {
                        i += i2;
                    }
                    while (this.f20811g) {
                        try {
                            this.f20806b.lock();
                            LoggerProxy.m17001d("AudioTrackPlayer", "await before" + System.currentTimeMillis());
                            this.f20807c.await();
                            LoggerProxy.m17001d("AudioTrackPlayer", "await after" + System.currentTimeMillis());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            this.f20806b.unlock();
                        }
                    }
                }
                if (this.f20808d.getPlayState() == 1) {
                    break loop3;
                } else if (c.m17325c()) {
                    i = c5145h.m17427c();
                    float d2 = c.m17326d();
                    i = Math.round(((float) i) * d2);
                    int b2 = m16977b(i);
                    LoggerProxy.m17001d("AudioTrackPlayer", "percent=" + d2 + "--currentProgress=" + i + "--progress=" + b2);
                    c5145h2 = (C5145h) c5145h.m16770B();
                    c5145h2.m17429d(b2);
                    m16981e(c5145h2);
                }
            }
            if (g == C5087e.SYN_FINISH) {
                c5145h2 = (C5145h) c5145h.m16770B();
                c5145h2.m17429d(this.f20810f.m17335d());
                m16981e(c5145h2);
                m16979c(c5145h);
            }
            LoggerProxy.m17001d("AudioTrackPlayer", "end put");
        } else {
            LoggerProxy.m17001d("AudioTrackPlayer", "put responseBag=null");
            LoggerProxy.m17001d("AudioTrackPlayer", "end put");
        }
        return null;
    }

    /* renamed from: h */
    private int m16984h() {
        return (this.f20809e.m16968a() * 2) / this.f20809e.m16967h();
    }

    /* renamed from: b */
    private void m16978b(C5145h c5145h) {
        this.f20810f.m17330a(m16984h());
        this.f20810f.m17329a();
        this.f20812h = 0;
        m16980d(c5145h);
    }

    /* renamed from: c */
    private void m16979c(C5145h c5145h) {
        this.f20810f.m17331b();
        m16982f(c5145h);
    }

    /* renamed from: b */
    private int m16977b(int i) {
        if (i > this.f20812h) {
            this.f20812h = i;
        }
        return this.f20812h;
    }

    /* renamed from: d */
    private void m16980d(C5145h c5145h) {
        if (this.a != null) {
            this.a.mo3771a(c5145h);
        }
    }

    /* renamed from: e */
    private void m16981e(C5145h c5145h) {
        if (this.a != null) {
            this.a.mo3772b(c5145h);
        }
    }

    /* renamed from: f */
    private void m16982f(C5145h c5145h) {
        if (this.a != null) {
            this.a.mo3773c(c5145h);
        }
    }
}
