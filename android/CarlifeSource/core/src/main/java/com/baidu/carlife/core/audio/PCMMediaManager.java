package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Message;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.audio.AudioUtil.EnumAudioState;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

/* compiled from: PCMMediaManager */
/* renamed from: com.baidu.carlife.core.audio.n */
public class PCMMediaManager extends AudioSourceManagerBase {
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + PCMMediaManager.class.getSimpleName());
    /* renamed from: b */
    private PCMPackageHead mPCMPackageHead = new PCMPackageHead();
    /* renamed from: c */
    private byte[] mByteData = new byte[120];
    /* renamed from: d */
    private int mEncryptDataLength;
    /* renamed from: e */
    private boolean f3127e = true;
    /* renamed from: f */
    private AudioTrack mAudioTrack;
    /* renamed from: g */
    private int mSampleRate;
    /* renamed from: h */
    private int mChannel;
    /* renamed from: i */
    private int mFormat;
    /* renamed from: j */
    private PCMMediaManagerHandler mManagerHandler = new PCMMediaManagerHandler(this);
    /* renamed from: k */
    private int f3133k;
    /* renamed from: l */
    private Pair mPair = new Pair();
    /* renamed from: m */
    private ArrayAdd mArrayAdd = new ArrayAdd();
    /* renamed from: n */
    private byte[] mEncryptData;
    /* renamed from: o */
    private AESManager mAESManager = new AESManager();

    /* compiled from: PCMMediaManager */
    /* renamed from: com.baidu.carlife.core.audio.n$a */
    private class PCMMediaManagerHandler extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ PCMMediaManager mPCMMediaManager;

        public PCMMediaManagerHandler(PCMMediaManager PCMMediaManager) {
            this.mPCMMediaManager = PCMMediaManager;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    AudioUtil.newInstance().initSR();
                    AudioUtil.newInstance().setMode();
                    this.mPCMMediaManager.f3127e = true;
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
        AudioUtil.newInstance();
        this.f3133k = 12;
        MsgHandlerCenter.registerMessageHandler(this.mManagerHandler);
    }

    /* renamed from: a */
    public synchronized void send(int sampleRate, int channelConfig, int format) {
        stopTrack();
        this.mSampleRate = sampleRate;
        if (channelConfig == 1) {
            this.mChannel = 4;
        } else {
            this.mChannel = 12;
        }
        if (format == 8) {
            this.mFormat = 3;
        } else {
            this.mFormat = 2;
        }
        try {
            this.mAudioTrack = new AudioTrack(3, this.mSampleRate, channelConfig,
                    2, AudioTrack.getMinBufferSize(this.mSampleRate, this.mChannel,
                    this.mFormat), 1);
            if (this.mAudioTrack != null) {
                this.mAudioTrack.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mAudioTrack = null;
        }
        sendPCM(sampleRate, channelConfig, format);
    }

    /* renamed from: h */
    private void stopTrack() {
        if (this.mAudioTrack != null) {
            this.mAudioTrack.stop();
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    /* renamed from: c */
    public synchronized void play() {
        ArbitrationModule.newInstance().musicAudioFocus();
        LogUtil.d(Tag, "PCMMedia play() is called");
        this.mPCMPackageHead.m4053c(CommonParams.bs);
        this.mPCMPackageHead.m4047a(0);
        MediaChannelSend.newInstance().send(this.mPCMPackageHead.m4048a(), this.mPCMPackageHead.m4049b(), EnumAudioState.RESUME);
    }

    /* renamed from: a */
    public synchronized void send() {
        LogUtil.d(Tag, "stop() is called");
        this.mPCMPackageHead.m4053c(CommonParams.bq);
        this.mPCMPackageHead.m4047a(0);
        MediaChannelSend.newInstance().send(this.mPCMPackageHead.m4048a(), this.mPCMPackageHead.m4049b(), EnumAudioState.STOP);
    }

    /* renamed from: b */
    public synchronized void pause() {
        LogUtil.d(Tag, "pause() is called");
        this.mPCMPackageHead.m4053c(CommonParams.br);
        this.mPCMPackageHead.m4047a(0);
        MediaChannelSend.newInstance().send(this.mPCMPackageHead.m4048a(), this.mPCMPackageHead.m4049b(), EnumAudioState.PAUSE);
    }

    /* renamed from: a */
    public synchronized void send(byte[] buffer, int size) {
        byte[] playBuf;
        if (this.mEncryptData == null) {
            this.mEncryptData = new byte[size];
        }
        if (this.mEncryptData.length < size) {
            this.mEncryptData = new byte[size];
        }
        if (AudioUtil.newInstance().isBlueToothMode() || !AudioUtil.getIs()) {
            playBuf = buffer;
        } else {
            playBuf = this.mEncryptData;
        }
        if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
            this.mAudioTrack.write(playBuf, 0, size);
        }
        if (AudioUtil.getIs() && this.f3127e) {
            sendPCM(this.mSampleRate, this.mChannel, this.mFormat);
            this.f3127e = false;
        }
        byte[] sendData = buffer;
        int sendDataLen = size;
        if (EncryptSetupManager.newInstance().getFlag() && size > 0) {
            sendData = this.mAESManager.encrypt(buffer, size);
            if (sendData == null) {
                LogUtil.e(Tag, "encrypt failed!");
            } else {
                sendDataLen = sendData.length;
            }
        }
        this.mPCMPackageHead.m4053c(CommonParams.bu);
        this.mPCMPackageHead.m4047a(sendDataLen);
        this.mPCMPackageHead.m4052c();
        this.mArrayAdd.merge(this.mPCMPackageHead.m4048a(), this.f3133k, sendData, sendDataLen, this.mPair);
        MediaChannelSend.newInstance().send(this.mPair.getData(), this.mPair.getSize(), EnumAudioState.NORMAL);
    }

    /* renamed from: b */
    private void sendPCM(int sampleRate, int channelConfig, int format) {
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
        this.mPCMPackageHead.m4053c(CommonParams.bp);
        this.mEncryptDataLength = this.mPCMPackageHead.encryptMusicLength(revisedSampleRate, revisedChannelConfig, revisedFormat, this.mByteData);
        this.mPCMPackageHead.m4047a(this.mEncryptDataLength);
        System.arraycopy(this.mPCMPackageHead.m4048a(), 0, this.mByteData, 0, this.f3133k);
        MediaChannelSend.newInstance().send(this.mByteData, this.f3133k + this.mEncryptDataLength, EnumAudioState.INIT);
    }
}
