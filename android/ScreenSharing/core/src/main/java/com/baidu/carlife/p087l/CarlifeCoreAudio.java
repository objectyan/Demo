package com.baidu.carlife.p087l;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.audio.AudioUtil;
import com.baidu.carlife.core.audio.ArbitrationModule;
import com.baidu.carlife.core.audio.AudioSourceManagerBase;
import com.baidu.carlife.core.audio.EncodedMediaManager;
import com.baidu.carlife.core.audio.NaviAudioManager;
import com.baidu.carlife.core.audio.PCMMediaManager;
import com.baidu.carlife.core.audio.PCMPackageHead;
import com.baidu.carlife.core.audio.VRAudioManager;

import java.util.ArrayList;

/* compiled from: CarlifeCoreAudio */
/* renamed from: com.baidu.carlife.l.b */
public class CarlifeCoreAudio {
    /* renamed from: a */
    private static final String f5126a = (AudioUtil.AUDIO + com.baidu.carlife.p087l.CarlifeCoreAudio.class.getSimpleName());
    /* renamed from: b */
    private static final int f5127b = 1;
    /* renamed from: c */
    private static final int f5128c = 2;
    /* renamed from: d */
    private static final int f5129d = 3;
    /* renamed from: e */
    private static final int f5130e = 4;
    /* renamed from: f */
    private static final int f5131f = 5;
    /* renamed from: g */
    private static final int f5132g = 6;
    /* renamed from: h */
    private static final int f5133h = 7;
    /* renamed from: i */
    private static com.baidu.carlife.p087l.CarlifeCoreAudio sCarlifeCoreAudio = null;
    /* renamed from: q */
    private static final String AUDIO_CALL_HANDLER_THREAD_NAME = "AUDIO_CALL_HANDLER_THREAD_NAME";
    /* renamed from: j */
    private AudioSourceManagerBase mEncodedMediaManager = new EncodedMediaManager();
    /* renamed from: k */
    private AudioSourceManagerBase mPCMMediaManager = new PCMMediaManager();
    /* renamed from: l */
    private AudioSourceManagerBase mNaviAudioManager = new NaviAudioManager();
    /* renamed from: m */
    private AudioSourceManagerBase mVRAudioManager = new VRAudioManager();
    /* renamed from: n */
    private ArbitrationModule mArbitrationModule = ArbitrationModule.newInstance();
    /* renamed from: o */
    private CarlifeCoreAudioHandler mCarlifeCoreAudioHandler = null;
    /* renamed from: p */
    private HandlerThread mHandlerThread = null;
    /* renamed from: r */
    private boolean f5143r = false;
    /* renamed from: s */
    private boolean f5144s = false;
    /* renamed from: t */
    private Context mApplicationContext = AppContext.getAppContext().getApplicationContext();

    /* compiled from: CarlifeCoreAudio */
    /* renamed from: com.baidu.carlife.l.b$a */
    private class CarlifeCoreAudioHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ com.baidu.carlife.p087l.CarlifeCoreAudio mCarlifeCoreAudio;

        public CarlifeCoreAudioHandler(com.baidu.carlife.p087l.CarlifeCoreAudio carlifeCoreAudio, Looper looper) {
            super(looper);
            this.mCarlifeCoreAudio = carlifeCoreAudio;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.init(msg.getData().getString("filePath"), msg.getData().getStringArrayList("fileList"));
                    return;
                case 2:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.pause();
                    return;
                case 3:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.play();
                    return;
                case 4:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.send();
                    return;
                case 5:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.setMiddleVolume();
                    return;
                case 6:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.setMinVolume();
                    return;
                case 7:
                    this.mCarlifeCoreAudio.mEncodedMediaManager.setMaxVolume();
                    return;
                default:
                    return;
            }
        }
    }

    private CarlifeCoreAudio() {
        this.mArbitrationModule.initContext(this.mApplicationContext);
    }

    /* renamed from: a */
    public static com.baidu.carlife.p087l.CarlifeCoreAudio newInstance() {
        if (sCarlifeCoreAudio == null) {
            sCarlifeCoreAudio = new com.baidu.carlife.p087l.CarlifeCoreAudio();
        }
        return sCarlifeCoreAudio;
    }

    /* renamed from: b */
    public boolean initCarlifeCoreAudioHandler() {
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread(AUDIO_CALL_HANDLER_THREAD_NAME);
            this.mHandlerThread.start();
        }
        this.mCarlifeCoreAudioHandler = new CarlifeCoreAudioHandler(this, this.mHandlerThread.getLooper());
        return true;
    }

    /* renamed from: c */
    public boolean quitCarlifeCoreAudioHandler() {
        sendMessage4();
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        return true;
    }

    /* renamed from: a */
    public void sendMessage1(String filePath, ArrayList<String> fileList) {
        Message msg = new Message();
        msg.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("filePath", filePath);
        bundle.putStringArrayList("fileList", fileList);
        msg.setData(bundle);
        this.mCarlifeCoreAudioHandler.removeMessages(1);
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: d */
    public void sendMessage2() {
        Message msg = new Message();
        msg.what = 2;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: e */
    public void sendMessage3() {
        Message msg = new Message();
        msg.what = 3;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: f */
    public void sendMessage4() {
        Message msg = new Message();
        msg.what = 4;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: a */
    public void m6064a(long pos) {
    }

    /* renamed from: a */
    public void m6063a(int sampleRate, int channels, int bitsPerSample) {
        this.mPCMMediaManager.send(sampleRate, channels, bitsPerSample);
    }

    /* renamed from: g */
    public void m6079g() {
        this.mPCMMediaManager.send();
    }

    /* renamed from: h */
    public void m6080h() {
        this.mPCMMediaManager.play();
    }

    /* renamed from: i */
    public void m6081i() {
        this.mPCMMediaManager.pause();
    }

    /* renamed from: a */
    public void m6067a(byte[] buffer, int size) {
        this.mPCMMediaManager.send(buffer, size);
    }

    /* renamed from: b */
    public void m6070b(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5143r = true;
        if (AudioUtil.getIs()) {
            this.mNaviAudioManager.send(sampleRate, channelConfig, sampleFormat);
        }
        LogUtil.d(f5126a, "receive TTS init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }

    /* renamed from: j */
    public void m6082j() {
        this.f5143r = false;
        if (AudioUtil.getIs()) {
            this.mNaviAudioManager.send();
        }
        LogUtil.d(f5126a, "receive TTS stop command");
    }

    /* renamed from: k */
    public boolean m6083k() {
        return this.f5143r;
    }

    /* renamed from: b */
    public void m6071b(byte[] ttsPCMData, int dataLen) {
        this.mNaviAudioManager.send(ttsPCMData, dataLen);
    }

    /* renamed from: c */
    public void m6073c(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5144s = true;
        if (AudioUtil.getIs()) {
            this.mVRAudioManager.send(sampleRate, channelConfig, sampleFormat);
        }
        LogUtil.d(f5126a, "receive VR init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }

    /* renamed from: l */
    public void m6084l() {
        this.f5144s = false;
        if (AudioUtil.getIs()) {
            this.mVRAudioManager.send();
        }
        LogUtil.d(f5126a, "receive VR stop command");
    }

    /* renamed from: m */
    public boolean m6085m() {
        return this.f5144s;
    }

    /* renamed from: c */
    public void m6074c(byte[] ttsPCMData, int dataLen) {
        this.mVRAudioManager.send(ttsPCMData, dataLen);
    }

    /* renamed from: n */
    public void m6086n() {
        LogUtil.d(f5126a, "send command: MSG_CMD_GET_AUDIO_FOCUS");
    }

    /* renamed from: o */
    public void m6087o() {
        Message msg = new Message();
        msg.what = 5;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: p */
    public void m6088p() {
    }

    /* renamed from: q */
    public void m6089q() {
        Message msg = new Message();
        msg.what = 7;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }

    /* renamed from: a */
    public void setMI3MediaVolume(Context context) {
        if (Build.MODEL.equals("MI 3")) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            int vol = audioManager.getStreamVolume(3);
            LogUtil.d(f5126a, "current media volume: " + vol);
            if (vol <= 2) {
                audioManager.setStreamVolume(3, 2, 0);
            }
            LogUtil.d(f5126a, "set media volume: " + audioManager.getStreamVolume(3));
        }
    }

    /* renamed from: r */
    public void setStatus() {
        this.mArbitrationModule.setStatus(true);
    }

    /* renamed from: s */
    public boolean isBlueToothMode() {
        return AudioUtil.newInstance().isBlueToothMode();
    }

    /* renamed from: a */
    public void setMode(int mode) {
        AudioUtil.newInstance().setMode(mode);
    }

    /* renamed from: t */
    public boolean isSR() {
        return AudioUtil.newInstance().isSR();
    }

    /* renamed from: b */
    public void setSR(int sr) {
        AudioUtil.newInstance().setSR(sr);
    }

    /* renamed from: a */
    public byte[] m6068a(int type, int dataLen) {
        PCMPackageHead ttsPackage = new PCMPackageHead();
        ttsPackage.m4053c(type);
        ttsPackage.m4047a(dataLen);
        return ttsPackage.m4048a();
    }
}
