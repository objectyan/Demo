package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.util.Log;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

/* compiled from: CustomAudioDecoder */
/* renamed from: com.baidu.carlife.core.audio.g */
public class C1173g {
    /* renamed from: a */
    private static final String f3035a = (C1163a.f3010n + C1173g.class.getSimpleName());
    /* renamed from: b */
    private int f3036b;
    /* renamed from: c */
    private int f3037c;
    /* renamed from: d */
    private int f3038d;
    /* renamed from: e */
    private AudioTrack f3039e;
    /* renamed from: f */
    private int f3040f = 0;
    /* renamed from: g */
    private C1168d f3041g = new C1179l();
    /* renamed from: h */
    private C1187p f3042h = new C1187p();
    /* renamed from: i */
    private C1187p f3043i = new C1187p();
    /* renamed from: j */
    private byte[] f3044j = null;
    /* renamed from: k */
    private Object f3045k = new Object();

    /* renamed from: a */
    public boolean m3938a(String filePath) {
        synchronized (this.f3045k) {
            C1260i.m4435b(f3035a, "init() is called");
            if (this.f3041g.mo1445a(filePath, null) == -1) {
                Log.i(f3035a, "MediaCodec initialization is failed!");
            } else {
                Log.i(f3035a, "wechat initialization is successed!");
            }
        }
        if (8000 != this.f3041g.mo1442a()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m3939a() {
        int nCount = 0;
        this.f3044j = null;
        while (nCount < 5) {
            this.f3040f = this.f3041g.mo1443a(this.f3042h, 0);
            C1260i.m4435b(f3035a, "Get WeChat Vol:" + this.f3040f);
            if (this.f3040f > 0) {
                break;
            } else if (-1 == this.f3040f) {
                try {
                    synchronized (this.f3045k) {
                        this.f3045k.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nCount++;
                C1260i.m4435b(f3035a, "MediaCodec Error happen!");
            } else if (this.f3040f == 0) {
                nCount++;
            }
        }
        if (this.f3042h.m4058b() != this.f3040f) {
            C1260i.m4445e(f3035a, "Get Audio size Error =" + this.f3042h.m4058b() + "  Return=" + this.f3040f);
        }
        if (this.f3040f <= 0) {
            return null;
        }
        this.f3044j = new byte[(this.f3042h.m4058b() * 2)];
        byte[] dataIn = this.f3042h.m4057a();
        C1260i.m4435b(f3035a, "decoder out :" + this.f3040f);
        for (int i = 0; i < this.f3040f; i += 2) {
            this.f3044j[i * 2] = dataIn[i];
            this.f3044j[(i * 2) + 1] = dataIn[i + 1];
            this.f3044j[(i * 2) + 2] = dataIn[i];
            this.f3044j[(i * 2) + 3] = dataIn[i + 1];
        }
        return this.f3044j;
    }

    /* renamed from: b */
    public void m3940b() {
        if (m3934g()) {
            C1166b.m3896a().m3907b();
            m3935h();
            return;
        }
        C1260i.m4435b(f3035a, "audio Track Init Error!!!");
    }

    /* renamed from: c */
    public void m3941c() {
        int nCount = 0;
        while (nCount < 8) {
            long lstarttime = System.currentTimeMillis();
            this.f3040f = this.f3041g.mo1443a(this.f3042h, 0);
            C1260i.m4435b(f3035a, "Get WeChat Vol:" + this.f3040f);
            if (-1 == this.f3040f) {
                try {
                    synchronized (this.f3045k) {
                        this.f3045k.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nCount++;
                C1260i.m4435b(f3035a, "MediaCodec Error happen!");
            } else if (this.f3040f == 0) {
                nCount++;
            } else {
                if (this.f3042h.m4058b() != this.f3040f) {
                    C1260i.m4445e(f3035a, "Get Audio size Error =" + this.f3042h.m4058b() + "  Return=" + this.f3040f);
                }
                nCount = 0;
                this.f3044j = new byte[(this.f3042h.m4058b() * 2)];
                this.f3043i.m4055a(this.f3042h.m4058b() * 2);
                this.f3043i.m4056a(this.f3044j);
                byte[] dataIn = this.f3042h.m4057a();
                for (int i = 0; i < this.f3040f; i += 2) {
                    this.f3044j[i * 2] = dataIn[i];
                    this.f3044j[(i * 2) + 1] = dataIn[i + 1];
                    this.f3044j[(i * 2) + 2] = dataIn[i];
                    this.f3044j[(i * 2) + 3] = dataIn[i + 1];
                }
                C1260i.m4435b(f3035a, "Use Time :" + (System.currentTimeMillis() - lstarttime));
                m3944f();
            }
        }
    }

    /* renamed from: d */
    public void m3942d() {
        synchronized (this.f3045k) {
            C1260i.m4435b(f3035a, "stop() is called");
            if (this.f3039e == null) {
                return;
            }
            try {
                this.f3039e.stop();
            } catch (IllegalStateException e) {
                C1261k.m4461b(415);
                e.printStackTrace();
            }
            this.f3039e.release();
            this.f3039e = null;
        }
    }

    /* renamed from: e */
    public void m3943e() {
        synchronized (this.f3045k) {
            C1166b.m3896a().m3907b();
            C1260i.m4435b(f3035a, "play() is called");
            if (this.f3039e == null || this.f3039e.getPlayState() == 3) {
                C1260i.m4435b(f3035a, "play music has been triggered");
            } else {
                m3935h();
            }
        }
    }

    /* renamed from: g */
    private boolean m3934g() {
        int channelConfig;
        this.f3036b = this.f3041g.mo1442a();
        if (this.f3036b == 8000) {
            this.f3036b *= 2;
        }
        this.f3037c = this.f3041g.mo1446b();
        this.f3038d = this.f3041g.mo1447c();
        if (this.f3039e != null) {
            this.f3039e.flush();
        }
        if (this.f3037c == 1) {
            channelConfig = 4;
        } else {
            channelConfig = 12;
        }
        C1260i.m4435b(f3035a, "samplerate = " + this.f3036b);
        if (this.f3036b < m_AppUI.MSG_APP_SAVESCREEN || this.f3036b > 48000) {
            this.f3039e = null;
            C1260i.m4435b(f3035a, "4000>sample rate || sample rate>48000: " + this.f3036b);
            return false;
        }
        int audioMinBufSizeLocal = AudioTrack.getMinBufferSize(this.f3036b, channelConfig, 2);
        C1260i.m4435b(f3035a, "audioMinBufSizeLocal= " + audioMinBufSizeLocal);
        try {
            this.f3039e = new AudioTrack(3, this.f3036b, channelConfig, 2, audioMinBufSizeLocal * 2, 1);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.f3039e = null;
            C1260i.m4435b(f3035a, "IllegalArgumentException: mAudioTrack =new AudioTrack");
            return false;
        }
    }

    /* renamed from: h */
    private void m3935h() {
        if (this.f3039e != null) {
            if (this.f3039e.getPlayState() != 3) {
                try {
                    C1260i.m4435b(f3035a, "Play WeChat voice!");
                    this.f3039e.play();
                } catch (IllegalStateException e) {
                    C1261k.m4461b(415);
                    e.printStackTrace();
                }
                synchronized (this.f3045k) {
                    this.f3045k.notify();
                }
                return;
            }
            C1260i.m4435b(f3035a, "play music has been triggered");
        }
    }

    /* renamed from: a */
    public void m3937a(byte[] pData) {
        int size = pData.length;
        if (size <= 0) {
            C1260i.m4445e(f3035a, "Data size 0!!!");
            return;
        }
        synchronized (this.f3045k) {
            if (this.f3039e != null && this.f3039e.getPlayState() == 3) {
                C1260i.m4445e(f3035a, "Trace size:  " + size);
                this.f3039e.write(pData, 0, size);
            }
        }
    }

    /* renamed from: f */
    public void m3944f() {
        int size = this.f3043i.m4058b();
        if (size <= 0) {
            C1260i.m4445e(f3035a, "Out size 0!!!");
            return;
        }
        synchronized (this.f3045k) {
            if (this.f3039e != null && this.f3039e.getPlayState() == 3) {
                C1260i.m4445e(f3035a, "size  " + size);
                this.f3039e.write(this.f3043i.m4057a(), 0, size);
            }
        }
    }

    /* renamed from: i */
    private void m3936i() {
        synchronized (this.f3045k) {
            if (this.f3039e == null || this.f3039e.getPlayState() != 3) {
                try {
                    this.f3045k.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
