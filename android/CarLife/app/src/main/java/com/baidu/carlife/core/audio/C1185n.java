package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Message;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.audio.C1163a.C1161d;
import com.baidu.carlife.core.connect.p070a.C1200b;
import com.baidu.carlife.core.connect.p070a.C1208e;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

/* compiled from: PCMMediaManager */
/* renamed from: com.baidu.carlife.core.audio.n */
public class C1185n extends C1172f {
    /* renamed from: a */
    private static final String f3123a = (C1163a.f3010n + C1185n.class.getSimpleName());
    /* renamed from: b */
    private C1186o f3124b = new C1186o();
    /* renamed from: c */
    private byte[] f3125c = new byte[120];
    /* renamed from: d */
    private int f3126d;
    /* renamed from: e */
    private boolean f3127e = true;
    /* renamed from: f */
    private AudioTrack f3128f;
    /* renamed from: g */
    private int f3129g;
    /* renamed from: h */
    private int f3130h;
    /* renamed from: i */
    private int f3131i;
    /* renamed from: j */
    private C1184a f3132j = new C1184a();
    /* renamed from: k */
    private int f3133k;
    /* renamed from: l */
    private C1187p f3134l = new C1187p();
    /* renamed from: m */
    private C1167c f3135m = new C1167c();
    /* renamed from: n */
    private byte[] f3136n;
    /* renamed from: o */
    private C1200b f3137o = new C1200b();

    /* compiled from: PCMMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.n$a */
    private class C1184a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1185n f3122a;

        private C1184a(C1185n c1185n) {
            this.f3122a = c1185n;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    C1163a.m3882a().m3889b();
                    C1163a.m3882a().m3893e();
                    this.f3122a.f3127e = true;
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(1002);
            addMsg(1004);
        }
    }

    public C1185n() {
        C1163a.m3882a();
        this.f3133k = 12;
        C1261k.m4460a(this.f3132j);
    }

    /* renamed from: a */
    public synchronized void mo1448a(int sampleRate, int channelConfig, int format) {
        m4040h();
        this.f3129g = sampleRate;
        if (channelConfig == 1) {
            this.f3130h = 4;
        } else {
            this.f3130h = 12;
        }
        if (format == 8) {
            this.f3131i = 3;
        } else {
            this.f3131i = 2;
        }
        try {
            this.f3128f = new AudioTrack(3, this.f3129g, channelConfig, 2, AudioTrack.getMinBufferSize(this.f3129g, this.f3130h, this.f3131i), 1);
            if (this.f3128f != null) {
                this.f3128f.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f3128f = null;
        }
        m4039b(sampleRate, channelConfig, format);
    }

    /* renamed from: h */
    private void m4040h() {
        if (this.f3128f != null) {
            this.f3128f.stop();
            this.f3128f.release();
            this.f3128f = null;
        }
    }

    /* renamed from: c */
    public synchronized void mo1437c() {
        C1166b.m3896a().m3907b();
        C1260i.m4435b(f3123a, "PCMMedia play() is called");
        this.f3124b.m4053c(C1253f.bs);
        this.f3124b.m4047a(0);
        C1181k.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.RESUME);
    }

    /* renamed from: a */
    public synchronized void mo1434a() {
        C1260i.m4435b(f3123a, "stop() is called");
        this.f3124b.m4053c(C1253f.bq);
        this.f3124b.m4047a(0);
        C1181k.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.STOP);
    }

    /* renamed from: b */
    public synchronized void mo1436b() {
        C1260i.m4435b(f3123a, "pause() is called");
        this.f3124b.m4053c(C1253f.br);
        this.f3124b.m4047a(0);
        C1181k.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.PAUSE);
    }

    /* renamed from: a */
    public synchronized void mo1449a(byte[] buffer, int size) {
        byte[] playBuf;
        if (this.f3136n == null) {
            this.f3136n = new byte[size];
        }
        if (this.f3136n.length < size) {
            this.f3136n = new byte[size];
        }
        if (C1163a.m3882a().m3895g() || !C1163a.m3883h()) {
            playBuf = buffer;
        } else {
            playBuf = this.f3136n;
        }
        if (this.f3128f != null && this.f3128f.getPlayState() == 3) {
            this.f3128f.write(playBuf, 0, size);
        }
        if (C1163a.m3883h() && this.f3127e) {
            m4039b(this.f3129g, this.f3130h, this.f3131i);
            this.f3127e = false;
        }
        byte[] sendData = buffer;
        int sendDataLen = size;
        if (C1208e.m4120a().m4135c() && size > 0) {
            sendData = this.f3137o.m4112a(buffer, size);
            if (sendData == null) {
                C1260i.m4445e(f3123a, "encrypt failed!");
            } else {
                sendDataLen = sendData.length;
            }
        }
        this.f3124b.m4053c(C1253f.bu);
        this.f3124b.m4047a(sendDataLen);
        this.f3124b.m4052c();
        this.f3135m.m3909a(this.f3124b.m4048a(), this.f3133k, sendData, sendDataLen, this.f3134l);
        C1181k.m4030a().m4033a(this.f3134l.m4057a(), this.f3134l.m4058b(), C1161d.NORMAL);
    }

    /* renamed from: b */
    private void m4039b(int sampleRate, int channelConfig, int format) {
        int revisedSampleRate;
        int revisedChannelConfig;
        int revisedFormat;
        if (sampleRate < m_AppUI.MSG_APP_SAVESCREEN || sampleRate > 48000) {
            revisedSampleRate = 44100;
        } else {
            revisedSampleRate = sampleRate;
        }
        if (channelConfig == 1 && channelConfig == 2) {
            revisedChannelConfig = channelConfig;
        } else {
            revisedChannelConfig = 2;
        }
        if (format == 8 && format == 16) {
            revisedFormat = format;
        } else {
            revisedFormat = 16;
        }
        this.f3124b.m4053c(C1253f.bp);
        this.f3126d = this.f3124b.m4046a(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3125c);
        this.f3124b.m4047a(this.f3126d);
        System.arraycopy(this.f3124b.m4048a(), 0, this.f3125c, 0, this.f3133k);
        C1181k.m4030a().m4033a(this.f3125c, this.f3133k + this.f3126d, C1161d.INIT);
    }
}
