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
import com.baidu.carlife.core.audio.AudioUtil.EnumAudioState;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.carlife.p087l.CarlifeCoreAudio;

import java.util.ArrayList;

/* compiled from: EncodedMediaManager */
/* renamed from: com.baidu.carlife.core.audio.h */
public class EncodedMediaManager extends AudioSourceManagerBase {
    /* renamed from: C */
    private static final int f3048C = 48000;
    /* renamed from: D */
    private static final int f3049D = 3;
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + EncodedMediaManager.class.getSimpleName());
    /* renamed from: y */
    private static final int f3051y = 102400;
    /* renamed from: z */
    private static final int f3052z = 20480;
    /* renamed from: A */
    private byte[] f3053A = new byte[20480];
    /* renamed from: B */
    private byte[] f3054B = new byte[20480];
    /* renamed from: E */
    private AESManager mAESManager = new AESManager();
    /* renamed from: F */
    private ArrayAdd mArrayAdd = new ArrayAdd();
    /* renamed from: G */
    private Pair mPair = new Pair();
    /* renamed from: H */
    private HandlerThread mMusicController = new HandlerThread("MusicController");
    /* renamed from: b */
    private int f3059b;
    /* renamed from: c */
    private int f3060c;
    /* renamed from: d */
    private int f3061d;
    /* renamed from: e */
    private AudioTrack mAudioTrack;
    /* renamed from: f */
    private Thread mThread;
    /* renamed from: g */
    private boolean f3064g;
    /* renamed from: h */
    private int f3065h = 0;
    /* renamed from: i */
    private PCMPackageHead mPCMPackageHeadOne = new PCMPackageHead();
    /* renamed from: j */
    private PCMPackageHead mPCMPackageHeadTwo = new PCMPackageHead();
    /* renamed from: k */
    private byte[] f3068k = new byte[120];
    /* renamed from: l */
    private int f3069l;
    /* renamed from: m */
    private boolean f3070m = true;
    /* renamed from: n */
    private EncodedMediaManagerHandler mEncodedMediaManagerHandler;
    /* renamed from: o */
    private AudioDecoderInterface mAudioDecoderInterfaceOne;
    /* renamed from: p */
    private AudioDecoderInterface mAudioDecoderInterfaceTwo;
    /* renamed from: q */
    private AudioDecoderInterface mAudioDecoderInterfaceThree;
    /* renamed from: r */
    private final int f3075r = 3;
    /* renamed from: s */
    private int f3076s;
    /* renamed from: t */
    private Pair mPair1 = new Pair();
    /* renamed from: u */
    private final Object mObject = new Object();
    /* renamed from: v */
    private byte[] f3079v;
    /* renamed from: w */
    private int f3080w;
    /* renamed from: x */
    private CarLifeSRC mCarLifeSRC = new CarLifeSRC();

    /* compiled from: EncodedMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.h$a */
    private class EncodedMediaManagerHandler extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ EncodedMediaManager mEncodedMediaManager;

        public EncodedMediaManagerHandler(EncodedMediaManager encodedMediaManager, Looper looper) {
            super(looper);
            this.mEncodedMediaManager = encodedMediaManager;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 425:
                    LogUtil.d(EncodedMediaManager.Tag, "output format changed, init audio track again");
                    this.mEncodedMediaManager.send();
                    this.mEncodedMediaManager.playMusic();
                    return;
                case 426:
                    this.mEncodedMediaManager.notifyToAwake();
                    return;
                case 1002:
                    this.mEncodedMediaManager.f3070m = true;
                    return;
                case 1004:
                    CarlifeCoreAudio.newInstance().setMI3MediaVolume(AppContext.getAppContext());
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
    private class EncodedMediaManagerThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ EncodedMediaManager mEncodedMediaManager;

        private EncodedMediaManagerThread(EncodedMediaManager encodedMediaManager) {
            this.mEncodedMediaManager = encodedMediaManager;
        }

        public void run() {
            this.mEncodedMediaManager.f3064g = true;
            while (this.mEncodedMediaManager.f3064g) {
                this.mEncodedMediaManager.m3972p();
                if (this.mEncodedMediaManager.mAudioDecoderInterfaceOne != null) {
                    this.mEncodedMediaManager.f3065h = this.mEncodedMediaManager.mAudioDecoderInterfaceOne.changeOutput(this.mEncodedMediaManager.mPair1, this.mEncodedMediaManager.f3076s);
                }
                if (this.mEncodedMediaManager.f3065h > 102400) {
                    this.mEncodedMediaManager.f3065h = 102400;
                    this.mEncodedMediaManager.mPair1.setSize(102400);
                }
                if (-1 == this.mEncodedMediaManager.f3065h) {
                    try {
                        synchronized (this.mEncodedMediaManager.mObject) {
                            this.mEncodedMediaManager.mObject.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LogUtil.d(EncodedMediaManager.Tag, "MediaCodec Error happen!");
                } else {
                    if (AudioUtil.getIs() && ConnectClient.newInstance().getIS()) {
                        if (this.mEncodedMediaManager.f3070m) {
                            if (CarlifeCoreAudio.newInstance().isSR()) {
                                this.mEncodedMediaManager.m3951b(EncodedMediaManager.f3048C, this.mEncodedMediaManager.f3060c, this.mEncodedMediaManager.f3061d);
                            } else {
                                this.mEncodedMediaManager.m3951b(this.mEncodedMediaManager.f3059b, this.mEncodedMediaManager.f3060c, this.mEncodedMediaManager.f3061d);
                            }
                            this.mEncodedMediaManager.f3070m = false;
                        }
                        this.mEncodedMediaManager.encrypt(this.mEncodedMediaManager.mPair1.getData(), this.mEncodedMediaManager.mPair1.getSize());
                    }
                    this.mEncodedMediaManager.m3971o();
                }
            }
        }
    }

    public EncodedMediaManager() {
        this.mMusicController.start();
        this.mEncodedMediaManagerHandler = new EncodedMediaManagerHandler(this, this.mMusicController.getLooper());
        this.mAudioDecoderInterfaceTwo = new M3u8Decoder();
        this.mAudioDecoderInterfaceThree = new MediaCodecDecoder();
        AudioUtil.newInstance();
        this.f3076s = 12;
        MsgHandlerCenter.registerMessageHandler(this.mEncodedMediaManagerHandler);
        startThread();
    }

    /* renamed from: k */
    private void startThread() {
        this.mThread = new EncodedMediaManagerThread(this);
        this.mThread.start();
    }

    /* renamed from: a */
    public void init(String filePath, ArrayList<String> fileList) {
        synchronized (this.mObject) {
            int ret;
            LogUtil.d(Tag, "init() is called");
            send();
            if (fileList == null) {
                this.mAudioDecoderInterfaceOne = this.mAudioDecoderInterfaceThree;
                ret = this.mAudioDecoderInterfaceOne.decodeAudio(filePath);
            } else {
                this.mAudioDecoderInterfaceOne = this.mAudioDecoderInterfaceTwo;
                ret = this.mAudioDecoderInterfaceOne.initialization(filePath, (ArrayList) fileList);
            }
            if (ret == -1) {
                Log.i(Tag, "MediaCodec initialization is failed!");
            } else {
                playMusic();
            }
        }
    }

    /* renamed from: l */
    private void playMusic() {
        if (createAudioTrack()) {
            ArbitrationModule.newInstance().musicAudioFocus();
            triggeredPlay();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void send() {
        /*
        r6 = this;
        r2 = r6.mObject;
        monitor-enter(r2);
        r1 = Tag;	 Catch:{ all -> 0x0050 }
        r3 = "stop() is called";
        com.baidu.carlife.core.LogUtil.d(r1, r3);	 Catch:{ all -> 0x0050 }
        r1 = r6.mAudioTrack;	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r6.mAudioTrack;	 Catch:{ IllegalStateException -> 0x0053 }
        r1.stop();	 Catch:{ IllegalStateException -> 0x0053 }
    L_0x0016:
        r1 = r6.mAudioTrack;	 Catch:{ all -> 0x0050 }
        r1.release();	 Catch:{ all -> 0x0050 }
        r1 = 0;
        r6.mAudioTrack = r1;	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.ArbitrationModule.newInstance();	 Catch:{ all -> 0x0050 }
        r1.m3908c();	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.AudioUtil.getIs();	 Catch:{ all -> 0x0050 }
        if (r1 == 0) goto L_0x004e;
    L_0x002b:
        r1 = r6.mPCMPackageHeadOne;	 Catch:{ all -> 0x0050 }
        r3 = 196610; // 0x30002 float:2.75509E-40 double:9.7138E-319;
        r1.m4053c(r3);	 Catch:{ all -> 0x0050 }
        r1 = r6.mPCMPackageHeadOne;	 Catch:{ all -> 0x0050 }
        r3 = 0;
        r1.m4047a(r3);	 Catch:{ all -> 0x0050 }
        r1 = com.baidu.carlife.core.audio.MediaChannelSend.newInstance();	 Catch:{ all -> 0x0050 }
        r3 = r6.mPCMPackageHeadOne;	 Catch:{ all -> 0x0050 }
        r3 = r3.m4048a();	 Catch:{ all -> 0x0050 }
        r4 = r6.mPCMPackageHeadOne;	 Catch:{ all -> 0x0050 }
        r4 = r4.m4049b();	 Catch:{ all -> 0x0050 }
        r5 = com.baidu.carlife.core.audio.AudioUtil.EnumAudioState.STOP;	 Catch:{ all -> 0x0050 }
        r1.send(r3, r4, r5);	 Catch:{ all -> 0x0050 }
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
        com.baidu.carlife.core.MsgHandlerCenter.dispatchMessage(r1);	 Catch:{ all -> 0x0050 }
        r0.printStackTrace();	 Catch:{ all -> 0x0050 }
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.audio.h.a():void");
    }

    /* renamed from: b */
    public void pause() {
        synchronized (this.mObject) {
            LogUtil.d(Tag, "pause() is called");
            if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() != 3) {
                LogUtil.d(Tag, "pause music has been triggered");
            } else {
                try {
                    this.mAudioTrack.pause();
                } catch (IllegalStateException e) {
                    MsgHandlerCenter.dispatchMessage(415);
                    e.printStackTrace();
                }
                ArbitrationModule.newInstance().m3908c();
                if (AudioUtil.getIs()) {
                    this.mPCMPackageHeadOne.m4053c(196611);
                    this.mPCMPackageHeadOne.m4047a(0);
                    MediaChannelSend.newInstance().send(this.mPCMPackageHeadOne.m4048a(),
                            this.mPCMPackageHeadOne.m4049b(), EnumAudioState.PAUSE);
                }
            }
        }
    }

    /* renamed from: c */
    public void play() {
        synchronized (this.mObject) {
            ArbitrationModule.newInstance().musicAudioFocus();
            LogUtil.d(Tag, "play() is called");
            if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() == 3) {
                LogUtil.d(Tag, "play music has been triggered");
            } else {
                triggeredPlay();
                if (AudioUtil.getIs() && !this.f3070m) {
                    this.mPCMPackageHeadOne.m4053c(196612);
                    this.mPCMPackageHeadOne.m4047a(0);
                    MediaChannelSend.newInstance().send(this.mPCMPackageHeadOne.m4048a(),
                            this.mPCMPackageHeadOne.m4049b(), EnumAudioState.RESUME);
                }
            }
        }
    }

    /* renamed from: d */
    public void seek() {
        synchronized (this.mObject) {
            LogUtil.d(Tag, "seek() is called");
            if (this.mAudioTrack == null) {
                return;
            }
            try {
                this.mAudioTrack.pause();
            } catch (IllegalStateException e) {
                MsgHandlerCenter.dispatchMessage(415);
                e.printStackTrace();
            }
            if (AudioUtil.getIs()) {
                this.mPCMPackageHeadOne.m4053c(196613);
                this.mPCMPackageHeadOne.m4047a(0);
                MediaChannelSend.newInstance().send(this.mPCMPackageHeadOne.m4048a(),
                        this.mPCMPackageHeadOne.m4049b(), EnumAudioState.SEEK);
            }
            triggeredPlay();
        }
    }

    /* renamed from: f */
    public void setMinVolume() {
        synchronized (this.mObject) {
            if (this.mAudioTrack != null) {
                if (Build.MODEL.equals("MI 3")) {
                    setVolume(0.001f);
                } else {
                    AudioTrack audioTrack = this.mAudioTrack;
                    setVolume(AudioTrack.getMinVolume());
                }
            }
        }
    }

    /* renamed from: e */
    public void setMiddleVolume() {
        synchronized (this.mObject) {
            if (this.mAudioTrack != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                setVolume(AudioTrack.getMaxVolume() / 3.0f);
            }
        }
    }

    /* renamed from: g */
    public void setMaxVolume() {
        synchronized (this.mObject) {
            if (this.mAudioTrack != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                setVolume(AudioTrack.getMaxVolume());
            }
        }
    }

    /* renamed from: a */
    private void setVolume(float vol) {
        if (VERSION.SDK_INT >= 21) {
            this.mAudioTrack.setVolume(vol);
        } else {
            this.mAudioTrack.setStereoVolume(vol, vol);
        }
    }

    /* renamed from: m */
    private boolean createAudioTrack() {
        int channelConfig;
        this.f3059b = this.mAudioDecoderInterfaceOne.getSampleRate();
        this.f3060c = this.mAudioDecoderInterfaceOne.getChannelConfig();
        this.f3061d = this.mAudioDecoderInterfaceOne.getReSampleRate();
        this.mCarLifeSRC.initSampleRate(this.f3059b, (int) f3048C, this.f3060c, 3);
        if (this.mAudioTrack != null) {
            this.mAudioTrack.flush();
        }
        LogUtil.d(Tag, "audio track channel config is " + this.f3060c);
        if (this.f3060c == 1) {
            channelConfig = 4;
        } else {
            channelConfig = 12;
        }
        LogUtil.d(Tag, "audio track  sample rate = " + this.f3059b);
        if (this.f3059b < 4000 || this.f3059b > f3048C) {
            this.mAudioTrack = null;
            LogUtil.d(Tag, "4000>sample rate || sample rate>48000: " + this.f3059b);
            return false;
        }
        int audioMinBufSizeLocal = AudioTrack.getMinBufferSize(this.f3059b, channelConfig, 2);
        LogUtil.d(Tag, "audio track audioMinBufSizeLocal= " + audioMinBufSizeLocal);
        try {
            this.mAudioTrack = new AudioTrack(3, this.f3059b, channelConfig, 2, audioMinBufSizeLocal * 2, 1);
            if (CarlifeCoreAudio.newInstance().isSR()) {
                m3951b(f3048C, this.f3060c, this.f3061d);
            } else {
                m3951b(this.f3059b, this.f3060c, this.f3061d);
            }
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.mAudioTrack = null;
            LogUtil.d(Tag, "IllegalArgumentException: mAudioTrack =new AudioTrack");
            return false;
        }
    }

    /* renamed from: n */
    private void triggeredPlay() {
        if (this.mAudioTrack != null) {
            if (this.mAudioTrack.getPlayState() != 3) {
                try {
                    this.mAudioTrack.play();
                } catch (IllegalStateException e) {
                    MsgHandlerCenter.dispatchMessage(415);
                    e.printStackTrace();
                }
                synchronized (this.mObject) {
                    this.mObject.notify();
                }
                return;
            }
            LogUtil.d(Tag, "triggeredPlay music has been triggered");
        }
    }

    /* renamed from: b */
    private void encrypt(byte[] data, int size) {
        if (AudioUtil.getIs() && size > 0) {
            byte[] sendData = data;
            int sendSize = size;
            if (!EncryptSetupManager.newInstance().getFlag() || size <= 0) {
                if (CarlifeCoreAudio.newInstance().isSR()) {
                    int byteDataSize = this.mCarLifeSRC.m3879a(data, size, this.f3053A, this.f3076s);
                    for (int i = 0; i < byteDataSize; i++) {
                        this.f3054B[this.f3076s + i] = this.f3053A[i];
                    }
                    sendData = this.f3054B;
                    sendSize = byteDataSize;
                }
                this.mPCMPackageHeadTwo.m4053c(196614);
                this.mPCMPackageHeadTwo.m4047a(sendSize);
                this.mPCMPackageHeadTwo.m4052c();
                System.arraycopy(this.mPCMPackageHeadTwo.m4048a(), 0, sendData, 0, this.f3076s);
                MediaChannelSend.newInstance().send(sendData, this.f3076s + sendSize, EnumAudioState.NORMAL);
                return;
            }
            byte[] rawData = new byte[size];
            System.arraycopy(sendData, this.f3076s, rawData, 0, sendSize);
            sendData = this.mAESManager.encrypt(rawData, size);
            if (sendData == null) {
                LogUtil.e(Tag, "encrypt failed!");
                return;
            }
            sendSize = sendData.length;
            this.mPCMPackageHeadTwo.m4053c(CommonParams.bu);
            this.mPCMPackageHeadTwo.m4047a(sendSize);
            this.mPCMPackageHeadTwo.m4052c();
            this.mArrayAdd.merge(this.mPCMPackageHeadTwo.m4048a(), this.f3076s, sendData, sendSize, this.mPair);
            MediaChannelSend.newInstance().send(this.mPair.getData(), this.mPair.getSize(), EnumAudioState.NORMAL);
        }
    }

    /* renamed from: o */
    private void m3971o() {
        int size = this.mPair1.getSize();
        if (size > 0) {
            synchronized (this.mObject) {
                if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
                    if (this.f3080w < size) {
                        this.f3080w = size;
                        this.f3079v = new byte[this.f3080w];
                    }
                    if (!AudioUtil.getIs() || AudioUtil.newInstance().isBlueToothMode()) {
                        this.mAudioTrack.write(this.mPair1.getData(), this.f3076s, size);
                    } else {
                        this.mAudioTrack.write(this.f3079v, 0, size);
                    }
                }
            }
        }
    }

    /* renamed from: p */
    private void m3972p() {
        synchronized (this.mObject) {
            if (this.mAudioTrack == null || this.mAudioTrack.getPlayState() != 3) {
                try {
                    this.mObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private void m3951b(int sampleRate, int channelConfig, int formatConfig) {
        if (AudioUtil.getIs()) {
            this.mPCMPackageHeadOne.m4053c(CommonParams.bp);
            this.f3069l = this.mPCMPackageHeadOne.encryptMusicLength(sampleRate, channelConfig, formatConfig, this.f3068k);
            this.mPCMPackageHeadOne.m4047a(this.f3069l);
            System.arraycopy(this.mPCMPackageHeadOne.m4048a(), 0, this.f3068k, 0, this.f3076s);
            MediaChannelSend.newInstance().send(this.f3068k, this.f3069l + this.f3076s, EnumAudioState.INIT);
        }
    }

    /* renamed from: h */
    protected void notifyToAwake() {
        synchronized (this.mObject) {
            LogUtil.e(Tag, "notify to awake");
            this.mObject.notify();
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
