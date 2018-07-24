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
import com.baidu.navi.protocol.model.VoiceRecogniseDataStruct;
import java.util.ArrayList;

/* compiled from: CarlifeCoreAudio */
/* renamed from: com.baidu.carlife.l.b */
public class C1665b {
    /* renamed from: a */
    private static final String f5126a = (AudioUtil.f3010n + C1665b.class.getSimpleName());
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
    private static C1665b f5134i = null;
    /* renamed from: q */
    private static final String f5135q = "AUDIO_CALL_HANDLER_THREAD_NAME";
    /* renamed from: j */
    private AudioSourceManagerBase f5136j = new EncodedMediaManager();
    /* renamed from: k */
    private AudioSourceManagerBase f5137k = new PCMMediaManager();
    /* renamed from: l */
    private AudioSourceManagerBase f5138l = new NaviAudioManager();
    /* renamed from: m */
    private AudioSourceManagerBase f5139m = new VRAudioManager();
    /* renamed from: n */
    private ArbitrationModule f5140n = ArbitrationModule.m3896a();
    /* renamed from: o */
    private C1664a f5141o = null;
    /* renamed from: p */
    private HandlerThread f5142p = null;
    /* renamed from: r */
    private boolean f5143r = false;
    /* renamed from: s */
    private boolean f5144s = false;
    /* renamed from: t */
    private Context f5145t = AppContext.m3876a().getApplicationContext();

    /* compiled from: CarlifeCoreAudio */
    /* renamed from: com.baidu.carlife.l.b$a */
    private class C1664a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C1665b f5125a;

        public C1664a(C1665b c1665b, Looper looper) {
            this.f5125a = c1665b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f5125a.f5136j.mo1435a(msg.getData().getString(VoiceRecogniseDataStruct.KEY_FILE_PATH), msg.getData().getStringArrayList("fileList"));
                    return;
                case 2:
                    this.f5125a.f5136j.mo1436b();
                    return;
                case 3:
                    this.f5125a.f5136j.mo1437c();
                    return;
                case 4:
                    this.f5125a.f5136j.mo1434a();
                    return;
                case 5:
                    this.f5125a.f5136j.mo1439e();
                    return;
                case 6:
                    this.f5125a.f5136j.mo1440f();
                    return;
                case 7:
                    this.f5125a.f5136j.mo1441g();
                    return;
                default:
                    return;
            }
        }
    }

    private C1665b() {
        this.f5140n.m3905a(this.f5145t);
    }

    /* renamed from: a */
    public static C1665b m6061a() {
        if (f5134i == null) {
            f5134i = new C1665b();
        }
        return f5134i;
    }

    /* renamed from: b */
    public boolean m6072b() {
        if (this.f5142p == null) {
            this.f5142p = new HandlerThread(f5135q);
            this.f5142p.start();
        }
        this.f5141o = new C1664a(this, this.f5142p.getLooper());
        return true;
    }

    /* renamed from: c */
    public boolean m6075c() {
        m6078f();
        if (this.f5142p != null) {
            this.f5142p.quit();
            this.f5142p = null;
        }
        return true;
    }

    /* renamed from: a */
    public void m6066a(String filePath, ArrayList<String> fileList) {
        Message msg = new Message();
        msg.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString(VoiceRecogniseDataStruct.KEY_FILE_PATH, filePath);
        bundle.putStringArrayList("fileList", fileList);
        msg.setData(bundle);
        this.f5141o.removeMessages(1);
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: d */
    public void m6076d() {
        Message msg = new Message();
        msg.what = 2;
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: e */
    public void m6077e() {
        Message msg = new Message();
        msg.what = 3;
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: f */
    public void m6078f() {
        Message msg = new Message();
        msg.what = 4;
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: a */
    public void m6064a(long pos) {
    }

    /* renamed from: a */
    public void m6063a(int sampleRate, int channels, int bitsPerSample) {
        this.f5137k.mo1448a(sampleRate, channels, bitsPerSample);
    }

    /* renamed from: g */
    public void m6079g() {
        this.f5137k.mo1434a();
    }

    /* renamed from: h */
    public void m6080h() {
        this.f5137k.mo1437c();
    }

    /* renamed from: i */
    public void m6081i() {
        this.f5137k.mo1436b();
    }

    /* renamed from: a */
    public void m6067a(byte[] buffer, int size) {
        this.f5137k.mo1449a(buffer, size);
    }

    /* renamed from: b */
    public void m6070b(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5143r = true;
        if (AudioUtil.m3883h()) {
            this.f5138l.mo1448a(sampleRate, channelConfig, sampleFormat);
        }
        LogUtil.d(f5126a, "receive TTS init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }

    /* renamed from: j */
    public void m6082j() {
        this.f5143r = false;
        if (AudioUtil.m3883h()) {
            this.f5138l.mo1434a();
        }
        LogUtil.d(f5126a, "receive TTS stop command");
    }

    /* renamed from: k */
    public boolean m6083k() {
        return this.f5143r;
    }

    /* renamed from: b */
    public void m6071b(byte[] ttsPCMData, int dataLen) {
        this.f5138l.mo1449a(ttsPCMData, dataLen);
    }

    /* renamed from: c */
    public void m6073c(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5144s = true;
        if (AudioUtil.m3883h()) {
            this.f5139m.mo1448a(sampleRate, channelConfig, sampleFormat);
        }
        LogUtil.d(f5126a, "receive VR init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }

    /* renamed from: l */
    public void m6084l() {
        this.f5144s = false;
        if (AudioUtil.m3883h()) {
            this.f5139m.mo1434a();
        }
        LogUtil.d(f5126a, "receive VR stop command");
    }

    /* renamed from: m */
    public boolean m6085m() {
        return this.f5144s;
    }

    /* renamed from: c */
    public void m6074c(byte[] ttsPCMData, int dataLen) {
        this.f5139m.mo1449a(ttsPCMData, dataLen);
    }

    /* renamed from: n */
    public void m6086n() {
        LogUtil.d(f5126a, "send command: MSG_CMD_GET_AUDIO_FOCUS");
    }

    /* renamed from: o */
    public void m6087o() {
        Message msg = new Message();
        msg.what = 5;
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: p */
    public void m6088p() {
    }

    /* renamed from: q */
    public void m6089q() {
        Message msg = new Message();
        msg.what = 7;
        this.f5141o.sendMessage(msg);
    }

    /* renamed from: a */
    public void m6065a(Context context) {
        if (Build.MODEL.equals("MI 3")) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int vol = audioManager.getStreamVolume(3);
            LogUtil.d(f5126a, "current media volume: " + vol);
            if (vol <= 2) {
                audioManager.setStreamVolume(3, 2, 0);
            }
            LogUtil.d(f5126a, "set media volume: " + audioManager.getStreamVolume(3));
        }
    }

    /* renamed from: r */
    public void m6090r() {
        this.f5140n.m3906a(true);
    }

    /* renamed from: s */
    public boolean m6091s() {
        return AudioUtil.m3882a().m3895g();
    }

    /* renamed from: a */
    public void m6062a(int mode) {
        AudioUtil.m3882a().m3890b(mode);
    }

    /* renamed from: t */
    public boolean m6092t() {
        return AudioUtil.m3882a().m3892d();
    }

    /* renamed from: b */
    public void m6069b(int sr) {
        AudioUtil.m3882a().m3884a(sr);
    }

    /* renamed from: a */
    public byte[] m6068a(int type, int dataLen) {
        PCMPackageHead ttsPackage = new PCMPackageHead();
        ttsPackage.m4053c(type);
        ttsPackage.m4047a(dataLen);
        return ttsPackage.m4048a();
    }
}
