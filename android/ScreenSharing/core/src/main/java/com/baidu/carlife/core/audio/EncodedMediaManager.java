package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.audio.AudioUtil.C1161d;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.carlife.protobuf.p087l.C1665b;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import java.util.ArrayList;

/* compiled from: EncodedMediaManager */
/* renamed from: com.baidu.carlife.core.audio.h */
public class EncodedMediaManager extends AudioSourceManagerBase {
    /* renamed from: C */
    private static final int f3048C = 48000;
    /* renamed from: D */
    private static final int f3049D = 3;
    /* renamed from: a */
    private static final String f3050a = (AudioUtil.f3010n + EncodedMediaManager.class.getSimpleName());
    /* renamed from: y */
    private static final int f3051y = 102400;
    /* renamed from: z */
    private static final int f3052z = 20480;
    /* renamed from: A */
    private byte[] f3053A = new byte[20480];
    /* renamed from: B */
    private byte[] f3054B = new byte[20480];
    /* renamed from: E */
    private AESManager f3055E = new AESManager();
    /* renamed from: F */
    private ArrayAdd f3056F = new ArrayAdd();
    /* renamed from: G */
    private Pair f3057G = new Pair();
    /* renamed from: H */
    private HandlerThread f3058H = new HandlerThread("MusicController");
    /* renamed from: b */
    private int f3059b;
    /* renamed from: c */
    private int f3060c;
    /* renamed from: d */
    private int f3061d;
    /* renamed from: e */
    private AudioTrack f3062e;
    /* renamed from: f */
    private Thread f3063f;
    /* renamed from: g */
    private boolean f3064g;
    /* renamed from: h */
    private int f3065h = 0;
    /* renamed from: i */
    private PCMPackageHead f3066i = new PCMPackageHead();
    /* renamed from: j */
    private PCMPackageHead f3067j = new PCMPackageHead();
    /* renamed from: k */
    private byte[] f3068k = new byte[120];
    /* renamed from: l */
    private int f3069l;
    /* renamed from: m */
    private boolean f3070m = true;
    /* renamed from: n */
    private C1175a f3071n;
    /* renamed from: o */
    private AudioDecoderInterface f3072o;
    /* renamed from: p */
    private AudioDecoderInterface f3073p;
    /* renamed from: q */
    private AudioDecoderInterface f3074q;
    /* renamed from: r */
    private final int f3075r = 3;
    /* renamed from: s */
    private int f3076s;
    /* renamed from: t */
    private Pair f3077t = new Pair();
    /* renamed from: u */
    private final Object f3078u = new Object();
    /* renamed from: v */
    private byte[] f3079v;
    /* renamed from: w */
    private int f3080w;
    /* renamed from: x */
    private CarLifeSRC f3081x = new CarLifeSRC();

    /* compiled from: EncodedMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.h$a */
    private class C1175a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ EncodedMediaManager f3046a;

        public C1175a(EncodedMediaManager encodedMediaManager, Looper looper) {
            this.f3046a = encodedMediaManager;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.ev /*425*/:
                    LogUtil.d(EncodedMediaManager.f3050a, "output format changed, init audio track again");
                    this.f3046a.mo1434a();
                    this.f3046a.m3966l();
                    return;
                case CommonParams.ew /*426*/:
                    this.f3046a.m3981h();
                    return;
                case 1002:
                    this.f3046a.f3070m = true;
                    return;
                case 1004:
                    C1665b.m6061a().m6065a(AppContext.m3876a());
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(1002);
            addMsg(1004);
            addMsg(CommonParams.ev);
            addMsg(CommonParams.ew);
        }
    }

    /* compiled from: EncodedMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.h$b */
    private class C1176b extends Thread {
        /* renamed from: a */
        final /* synthetic */ EncodedMediaManager f3047a;

        private C1176b(EncodedMediaManager encodedMediaManager) {
            this.f3047a = encodedMediaManager;
        }

        public void run() {
            this.f3047a.f3064g = true;
            while (this.f3047a.f3064g) {
                this.f3047a.m3972p();
                if (this.f3047a.f3072o != null) {
                    this.f3047a.f3065h = this.f3047a.f3072o.mo1443a(this.f3047a.f3077t, this.f3047a.f3076s);
                }
                if (this.f3047a.f3065h > 102400) {
                    this.f3047a.f3065h = 102400;
                    this.f3047a.f3077t.m4055a(102400);
                }
                if (-1 == this.f3047a.f3065h) {
                    try {
                        synchronized (this.f3047a.f3078u) {
                            this.f3047a.f3078u.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LogUtil.d(EncodedMediaManager.f3050a, "MediaCodec Error happen!");
                } else {
                    if (AudioUtil.m3883h() && ConnectClient.m4207a().m4225c()) {
                        if (this.f3047a.f3070m) {
                            if (C1665b.m6061a().m6092t()) {
                                this.f3047a.m3951b(EncodedMediaManager.f3048C, this.f3047a.f3060c, this.f3047a.f3061d);
                            } else {
                                this.f3047a.m3951b(this.f3047a.f3059b, this.f3047a.f3060c, this.f3047a.f3061d);
                            }
                            this.f3047a.f3070m = false;
                        }
                        this.f3047a.m3953b(this.f3047a.f3077t.m4057a(), this.f3047a.f3077t.m4058b());
                    }
                    this.f3047a.m3971o();
                }
            }
        }
    }

    public EncodedMediaManager() {
        this.f3058H.start();
        this.f3071n = new C1175a(this, this.f3058H.getLooper());
        this.f3073p = new M3u8Decoder();
        this.f3074q = new MediaCodecDecoder();
        AudioUtil.m3882a();
        this.f3076s = 12;
        MsgHandlerCenter.m4460a(this.f3071n);
        m3965k();
    }

    /* renamed from: k */
    private void m3965k() {
        this.f3063f = new C1176b();
        this.f3063f.start();
    }

    /* renamed from: a */
    public void mo1435a(String filePath, ArrayList<String> fileList) {
        synchronized (this.f3078u) {
            int ret;
            LogUtil.d(f3050a, "init() is called");
            mo1434a();
            if (fileList == null) {
                this.f3072o = this.f3074q;
                ret = this.f3072o.mo1444a(filePath);
            } else {
                this.f3072o = this.f3073p;
                ret = this.f3072o.mo1445a(filePath, (ArrayList) fileList);
            }
            if (ret == -1) {
                Log.i(f3050a, "MediaCodec initialization is failed!");
            } else {
                m3966l();
            }
        }
    }

    /* renamed from: l */
    private void m3966l() {
        if (m3969m()) {
            ArbitrationModule.m3896a().m3907b();
            m3970n();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo1434a() {
        /*
        r6 = this;
        r2 = r6.f3078u;
        monitor-enter(r2);
        r1 = f3050a;	 Catch:{ all -> 0x0050 }
        r3 = "stop() is called";
        com.baidu.carlife.core.LogUtil.d(r1, r3);	 Catch:{ all -> 0x0050 }
        r1 = r6.f3062e;	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r6.f3062e;	 Catch:{ IllegalStateException -> 0x0053 }
        r1.stop();	 Catch:{ IllegalStateException -> 0x0053 }
    L_0x0016:
        r1 = r6.f3062e;	 Catch:{ all -> 0x0050 }
        r1.release();	 Catch:{ all -> 0x0050 }
        r1 = 0;
        r6.f3062e = r1;	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.ArbitrationModule.m3896a();	 Catch:{ all -> 0x0050 }
        r1.m3908c();	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.AudioUtil.m3883h();	 Catch:{ all -> 0x0050 }
        if (r1 == 0) goto L_0x004e;
    L_0x002b:
        r1 = r6.f3066i;	 Catch:{ all -> 0x0050 }
        r3 = 196610; // 0x30002 float:2.75509E-40 double:9.7138E-319;
        r1.m4053c(r3);	 Catch:{ all -> 0x0050 }
        r1 = r6.f3066i;	 Catch:{ all -> 0x0050 }
        r3 = 0;
        r1.m4047a(r3);	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.MediaChannelSend.m4030a();	 Catch:{ all -> 0x0050 }
        r3 = r6.f3066i;	 Catch:{ all -> 0x0050 }
        r3 = r3.m4048a();	 Catch:{ all -> 0x0050 }
        r4 = r6.f3066i;	 Catch:{ all -> 0x0050 }
        r4 = r4.m4049b();	 Catch:{ all -> 0x0050 }
        r5 = com.baidu.carlife.core.audio.AudioUtil.C1161d.STOP;	 Catch:{ all -> 0x0050 }
        r1.m4033a(r3, r4, r5);	 Catch:{ all -> 0x0050 }
    L_0x004e:
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
        goto L_0x0010;
    L_0x0050:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
        throw r1;
    L_0x0053:
        r0 = move-exception;
        r1 = 415; // 0x19f float:5.82E-43 double:2.05E-321;
        com.baidu.carlife.core.MsgHandlerCenter.m4461b(r1);	 Catch:{ all -> 0x0050 }
        r0.printStackTrace();	 Catch:{ all -> 0x0050 }
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.audio.h.a():void");
    }

    /* renamed from: b */
    public void mo1436b() {
        synchronized (this.f3078u) {
            LogUtil.d(f3050a, "pause() is called");
            if (this.f3062e == null || this.f3062e.getPlayState() != 3) {
                LogUtil.d(f3050a, "pause music has been triggered");
            } else {
                try {
                    this.f3062e.pause();
                } catch (IllegalStateException e) {
                    MsgHandlerCenter.m4461b(415);
                    e.printStackTrace();
                }
                ArbitrationModule.m3896a().m3908c();
                if (AudioUtil.m3883h()) {
                    this.f3066i.m4053c(CommonParams.br);
                    this.f3066i.m4047a(0);
                    MediaChannelSend.m4030a().m4033a(this.f3066i.m4048a(), this.f3066i.m4049b(), C1161d.PAUSE);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo1437c() {
        synchronized (this.f3078u) {
            ArbitrationModule.m3896a().m3907b();
            LogUtil.d(f3050a, "play() is called");
            if (this.f3062e == null || this.f3062e.getPlayState() == 3) {
                LogUtil.d(f3050a, "play music has been triggered");
            } else {
                m3970n();
                if (AudioUtil.m3883h() && !this.f3070m) {
                    this.f3066i.m4053c(CommonParams.bs);
                    this.f3066i.m4047a(0);
                    MediaChannelSend.m4030a().m4033a(this.f3066i.m4048a(), this.f3066i.m4049b(), C1161d.RESUME);
                }
            }
        }
    }

    /* renamed from: d */
    public void mo1438d() {
        synchronized (this.f3078u) {
            LogUtil.d(f3050a, "seek() is called");
            if (this.f3062e == null) {
                return;
            }
            try {
                this.f3062e.pause();
            } catch (IllegalStateException e) {
                MsgHandlerCenter.m4461b(415);
                e.printStackTrace();
            }
            if (AudioUtil.m3883h()) {
                this.f3066i.m4053c(CommonParams.bt);
                this.f3066i.m4047a(0);
                MediaChannelSend.m4030a().m4033a(this.f3066i.m4048a(), this.f3066i.m4049b(), C1161d.SEEK);
            }
            m3970n();
        }
    }

    /* renamed from: f */
    public void mo1440f() {
        synchronized (this.f3078u) {
            if (this.f3062e != null) {
                if (Build.MODEL.equals("MI 3")) {
                    m3946a(0.001f);
                } else {
                    AudioTrack audioTrack = this.f3062e;
                    m3946a(AudioTrack.getMinVolume());
                }
            }
        }
    }

    /* renamed from: e */
    public void mo1439e() {
        synchronized (this.f3078u) {
            if (this.f3062e != null) {
                AudioTrack audioTrack = this.f3062e;
                m3946a(AudioTrack.getMaxVolume() / 3.0f);
            }
        }
    }

    /* renamed from: g */
    public void mo1441g() {
        synchronized (this.f3078u) {
            if (this.f3062e != null) {
                AudioTrack audioTrack = this.f3062e;
                m3946a(AudioTrack.getMaxVolume());
            }
        }
    }

    /* renamed from: a */
    private void m3946a(float vol) {
        if (VERSION.SDK_INT >= 21) {
            this.f3062e.setVolume(vol);
        } else {
            this.f3062e.setStereoVolume(vol, vol);
        }
    }

    /* renamed from: m */
    private boolean m3969m() {
        int channelConfig;
        this.f3059b = this.f3072o.mo1442a();
        this.f3060c = this.f3072o.mo1446b();
        this.f3061d = this.f3072o.mo1447c();
        this.f3081x.m3878a(this.f3059b, (int) f3048C, this.f3060c, 3);
        if (this.f3062e != null) {
            this.f3062e.flush();
        }
        LogUtil.d(f3050a, "audio track channel config is " + this.f3060c);
        if (this.f3060c == 1) {
            channelConfig = 4;
        } else {
            channelConfig = 12;
        }
        LogUtil.d(f3050a, "audio track  sample rate = " + this.f3059b);
        if (this.f3059b < m_AppUI.MSG_APP_SAVESCREEN || this.f3059b > f3048C) {
            this.f3062e = null;
            LogUtil.d(f3050a, "4000>sample rate || sample rate>48000: " + this.f3059b);
            return false;
        }
        int audioMinBufSizeLocal = AudioTrack.getMinBufferSize(this.f3059b, channelConfig, 2);
        LogUtil.d(f3050a, "audio track audioMinBufSizeLocal= " + audioMinBufSizeLocal);
        try {
            this.f3062e = new AudioTrack(3, this.f3059b, channelConfig, 2, audioMinBufSizeLocal * 2, 1);
            if (C1665b.m6061a().m6092t()) {
                m3951b(f3048C, this.f3060c, this.f3061d);
            } else {
                m3951b(this.f3059b, this.f3060c, this.f3061d);
            }
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.f3062e = null;
            LogUtil.d(f3050a, "IllegalArgumentException: mAudioTrack =new AudioTrack");
            return false;
        }
    }

    /* renamed from: n */
    private void m3970n() {
        if (this.f3062e != null) {
            if (this.f3062e.getPlayState() != 3) {
                try {
                    this.f3062e.play();
                } catch (IllegalStateException e) {
                    MsgHandlerCenter.m4461b(415);
                    e.printStackTrace();
                }
                synchronized (this.f3078u) {
                    this.f3078u.notify();
                }
                return;
            }
            LogUtil.d(f3050a, "play music has been triggered");
        }
    }

    /* renamed from: b */
    private void m3953b(byte[] data, int size) {
        if (AudioUtil.m3883h() && size > 0) {
            byte[] sendData = data;
            int sendSize = size;
            if (!EncryptSetupManager.m4120a().m4135c() || size <= 0) {
                if (C1665b.m6061a().m6092t()) {
                    int byteDataSize = this.f3081x.m3879a(data, size, this.f3053A, this.f3076s);
                    for (int i = 0; i < byteDataSize; i++) {
                        this.f3054B[this.f3076s + i] = this.f3053A[i];
                    }
                    sendData = this.f3054B;
                    sendSize = byteDataSize;
                }
                this.f3067j.m4053c(CommonParams.bu);
                this.f3067j.m4047a(sendSize);
                this.f3067j.m4052c();
                System.arraycopy(this.f3067j.m4048a(), 0, sendData, 0, this.f3076s);
                MediaChannelSend.m4030a().m4033a(sendData, this.f3076s + sendSize, C1161d.NORMAL);
                return;
            }
            byte[] rawData = new byte[size];
            System.arraycopy(sendData, this.f3076s, rawData, 0, sendSize);
            sendData = this.f3055E.m4112a(rawData, size);
            if (sendData == null) {
                LogUtil.m4445e(f3050a, "encrypt failed!");
                return;
            }
            sendSize = sendData.length;
            this.f3067j.m4053c(CommonParams.bu);
            this.f3067j.m4047a(sendSize);
            this.f3067j.m4052c();
            this.f3056F.m3909a(this.f3067j.m4048a(), this.f3076s, sendData, sendSize, this.f3057G);
            MediaChannelSend.m4030a().m4033a(this.f3057G.m4057a(), this.f3057G.m4058b(), C1161d.NORMAL);
        }
    }

    /* renamed from: o */
    private void m3971o() {
        int size = this.f3077t.m4058b();
        if (size > 0) {
            synchronized (this.f3078u) {
                if (this.f3062e != null && this.f3062e.getPlayState() == 3) {
                    if (this.f3080w < size) {
                        this.f3080w = size;
                        this.f3079v = new byte[this.f3080w];
                    }
                    if (!AudioUtil.m3883h() || AudioUtil.m3882a().m3895g()) {
                        this.f3062e.write(this.f3077t.m4057a(), this.f3076s, size);
                    } else {
                        this.f3062e.write(this.f3079v, 0, size);
                    }
                }
            }
        }
    }

    /* renamed from: p */
    private void m3972p() {
        synchronized (this.f3078u) {
            if (this.f3062e == null || this.f3062e.getPlayState() != 3) {
                try {
                    this.f3078u.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private void m3951b(int sampleRate, int channelConfig, int formatConfig) {
        if (AudioUtil.m3883h()) {
            this.f3066i.m4053c(CommonParams.bp);
            this.f3069l = this.f3066i.m4046a(sampleRate, channelConfig, formatConfig, this.f3068k);
            this.f3066i.m4047a(this.f3069l);
            System.arraycopy(this.f3066i.m4048a(), 0, this.f3068k, 0, this.f3076s);
            MediaChannelSend.m4030a().m4033a(this.f3068k, this.f3069l + this.f3076s, C1161d.INIT);
        }
    }

    /* renamed from: h */
    protected void m3981h() {
        synchronized (this.f3078u) {
            LogUtil.m4445e(f3050a, "notify to awake");
            this.f3078u.notify();
        }
    }

    /* renamed from: i */
    boolean m3982i() {
        if (("" + CommonParams.sVehicleChannel.getChannel()).equals(EnumVehicleChannel.VEHICLE_CHANNEL_AUDI_DUAL_AUDIO)) {
            return true;
        }
        return false;
    }
}
