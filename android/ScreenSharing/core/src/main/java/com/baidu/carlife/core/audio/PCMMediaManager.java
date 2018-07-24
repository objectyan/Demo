package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Message;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.audio.AudioUtil.C1161d;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

/* compiled from: PCMMediaManager */
/* renamed from: com.baidu.carlife.core.audio.n */
public class PCMMediaManager extends AudioSourceManagerBase {
    /* renamed from: a */
    private static final String f3123a = (AudioUtil.f3010n + PCMMediaManager.class.getSimpleName());
    /* renamed from: b */
    private PCMPackageHead f3124b = new PCMPackageHead();
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
    private Pair f3134l = new Pair();
    /* renamed from: m */
    private ArrayAdd f3135m = new ArrayAdd();
    /* renamed from: n */
    private byte[] f3136n;
    /* renamed from: o */
    private AESManager f3137o = new AESManager();

    /* compiled from: PCMMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.n$a */
    private class C1184a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ PCMMediaManager f3122a;

        public C1184a(PCMMediaManager PCMMediaManager) {
            this.f3122a = PCMMediaManager;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    AudioUtil.m3882a().m3889b();
                    AudioUtil.m3882a().m3893e();
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

    public PCMMediaManager() {
        AudioUtil.m3882a();
        this.f3133k = 12;
        MsgHandlerCenter.m4460a(this.f3132j);
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
        ArbitrationModule.m3896a().m3907b();
        LogUtil.d(f3123a, "PCMMedia play() is called");
        this.f3124b.m4053c(CommonParams.bs);
        this.f3124b.m4047a(0);
        MediaChannelSend.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.RESUME);
    }

    /* renamed from: a */
    public synchronized void mo1434a() {
        LogUtil.d(f3123a, "stop() is called");
        this.f3124b.m4053c(CommonParams.bq);
        this.f3124b.m4047a(0);
        MediaChannelSend.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.STOP);
    }

    /* renamed from: b */
    public synchronized void mo1436b() {
        LogUtil.d(f3123a, "pause() is called");
        this.f3124b.m4053c(CommonParams.br);
        this.f3124b.m4047a(0);
        MediaChannelSend.m4030a().m4033a(this.f3124b.m4048a(), this.f3124b.m4049b(), C1161d.PAUSE);
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
        if (AudioUtil.m3882a().m3895g() || !AudioUtil.m3883h()) {
            playBuf = buffer;
        } else {
            playBuf = this.f3136n;
        }
        if (this.f3128f != null && this.f3128f.getPlayState() == 3) {
            this.f3128f.write(playBuf, 0, size);
        }
        if (AudioUtil.m3883h() && this.f3127e) {
            m4039b(this.f3129g, this.f3130h, this.f3131i);
            this.f3127e = false;
        }
        byte[] sendData = buffer;
        int sendDataLen = size;
        if (EncryptSetupManager.m4120a().m4135c() && size > 0) {
            sendData = this.f3137o.m4112a(buffer, size);
            if (sendData == null) {
                LogUtil.m4445e(f3123a, "encrypt failed!");
            } else {
                sendDataLen = sendData.length;
            }
        }
        this.f3124b.m4053c(CommonParams.bu);
        this.f3124b.m4047a(sendDataLen);
        this.f3124b.m4052c();
        this.f3135m.m3909a(this.f3124b.m4048a(), this.f3133k, sendData, sendDataLen, this.f3134l);
        MediaChannelSend.m4030a().m4033a(this.f3134l.m4057a(), this.f3134l.m4058b(), C1161d.NORMAL);
    }

    /* renamed from: b */
    private void m4039b(int sampleRate, int channelConfig, int format) {
        int revisedSampleRate;
        int revisedChannelConfig;
        int revisedFormat;
        if (sampleRate < 4000 || sampleRate > 48000) {
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
        this.f3124b.m4053c(CommonParams.bp);
        this.f3126d = this.f3124b.m4046a(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3125c);
        this.f3124b.m4047a(this.f3126d);
        System.arraycopy(this.f3124b.m4048a(), 0, this.f3125c, 0, this.f3133k);
        MediaChannelSend.m4030a().m4033a(this.f3125c, this.f3133k + this.f3126d, C1161d.INIT);
    }
}
