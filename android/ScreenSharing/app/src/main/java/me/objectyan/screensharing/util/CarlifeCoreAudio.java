package me.objectyan.screensharing.util;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.audio.ArbitrationModule;
import me.objectyan.screensharing.core.audio.AudioSourceManagerBase;
import me.objectyan.screensharing.core.audio.AudioUtil;
import me.objectyan.screensharing.core.audio.EncodedMediaManager;
import me.objectyan.screensharing.core.audio.NaviAudioManager;
import me.objectyan.screensharing.core.audio.PCMMediaManager;
import me.objectyan.screensharing.core.audio.PCMPackageHead;
import me.objectyan.screensharing.core.audio.VRAudioManager;

import java.util.ArrayList;


public class CarlifeCoreAudio {

    private static final String f5126a = (AudioUtil.AUDIO + me.objectyan.screensharing.util.CarlifeCoreAudio.class.getSimpleName());

    private static final int f5127b = 1;

    private static final int f5128c = 2;

    private static final int f5129d = 3;

    private static final int f5130e = 4;

    private static final int f5131f = 5;

    private static final int f5132g = 6;

    private static final int f5133h = 7;

    private static me.objectyan.screensharing.util.CarlifeCoreAudio sCarlifeCoreAudio = null;

    private static final String AUDIO_CALL_HANDLER_THREAD_NAME = "AUDIO_CALL_HANDLER_THREAD_NAME";

    private AudioSourceManagerBase mEncodedMediaManager = new EncodedMediaManager();

    private AudioSourceManagerBase mPCMMediaManager = new PCMMediaManager();

    private AudioSourceManagerBase mNaviAudioManager = new NaviAudioManager();

    private AudioSourceManagerBase mVRAudioManager = new VRAudioManager();

    private ArbitrationModule mArbitrationModule = ArbitrationModule.newInstance();

    private CarlifeCoreAudioHandler mCarlifeCoreAudioHandler = null;

    private HandlerThread mHandlerThread = null;

    private boolean f5143r = false;

    private boolean f5144s = false;

    private Context mApplicationContext = AppContext.getAppContext().getApplicationContext();


    private class CarlifeCoreAudioHandler extends Handler {

        final me.objectyan.screensharing.util.CarlifeCoreAudio mCarlifeCoreAudio;

        public CarlifeCoreAudioHandler(me.objectyan.screensharing.util.CarlifeCoreAudio carlifeCoreAudio, Looper looper) {
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
                    this.mCarlifeCoreAudio.mEncodedMediaManager.stop();
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


    public static me.objectyan.screensharing.util.CarlifeCoreAudio newInstance() {
        if (sCarlifeCoreAudio == null) {
            sCarlifeCoreAudio = new me.objectyan.screensharing.util.CarlifeCoreAudio();
        }
        return sCarlifeCoreAudio;
    }


    public boolean initCarlifeCoreAudioHandler() {
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread(AUDIO_CALL_HANDLER_THREAD_NAME);
            this.mHandlerThread.start();
        }
        this.mCarlifeCoreAudioHandler = new CarlifeCoreAudioHandler(this, this.mHandlerThread.getLooper());
        return true;
    }


    public boolean quitCarlifeCoreAudioHandler() {
        sendMessage4();
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        return true;
    }


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


    public void sendMessage2() {
        Message msg = new Message();
        msg.what = 2;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }


    public void sendMessage3() {
        Message msg = new Message();
        msg.what = 3;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }


    public void sendMessage4() {
        Message msg = new Message();
        msg.what = 4;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }


    public void m6064a(long pos) {
    }


    public void send(int sampleRate, int channels, int bitsPerSample) {
        this.mPCMMediaManager.send(sampleRate, channels, bitsPerSample);
    }


    public void stop() {
        this.mPCMMediaManager.stop();
    }


    public void m6080h() {
        this.mPCMMediaManager.play();
    }


    public void m6081i() {
        this.mPCMMediaManager.pause();
    }


    public void m6067a(byte[] buffer, int size) {
        this.mPCMMediaManager.send(buffer, size);
    }


    public void m6070b(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5143r = true;
        if (AudioUtil.getIs()) {
            this.mNaviAudioManager.send(sampleRate, channelConfig, sampleFormat);
        }
        Log.d(f5126a, "receive TTS init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }


    public void m6082j() {
        this.f5143r = false;
        if (AudioUtil.getIs()) {
            this.mNaviAudioManager.stop();
        }
        Log.d(f5126a, "receive TTS stop command");
    }


    public boolean m6083k() {
        return this.f5143r;
    }


    public void m6071b(byte[] ttsPCMData, int dataLen) {
        this.mNaviAudioManager.send(ttsPCMData, dataLen);
    }


    public void m6073c(int sampleRate, int channelConfig, int sampleFormat) {
        this.f5144s = true;
        if (AudioUtil.getIs()) {
            this.mVRAudioManager.send(sampleRate, channelConfig, sampleFormat);
        }
        Log.d(f5126a, "receive VR init command sampleRate:" + sampleRate + " channelConfig:" + channelConfig + " sampleFormat:" + sampleFormat);
    }


    public void m6084l() {
        this.f5144s = false;
        if (AudioUtil.getIs()) {
            this.mVRAudioManager.stop();
        }
        Log.d(f5126a, "receive VR stop command");
    }


    public boolean m6085m() {
        return this.f5144s;
    }


    public void m6074c(byte[] ttsPCMData, int dataLen) {
        this.mVRAudioManager.send(ttsPCMData, dataLen);
    }


    public void m6086n() {
        Log.d(f5126a, "send command: MSG_CMD_GET_AUDIO_FOCUS");
    }


    public void m6087o() {
        Message msg = new Message();
        msg.what = 5;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }


    public void m6088p() {
    }


    public void m6089q() {
        Message msg = new Message();
        msg.what = 7;
        this.mCarlifeCoreAudioHandler.sendMessage(msg);
    }


    public void setMI3MediaVolume(Context context) {
        if (Build.MODEL.equals("MI 3")) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            int vol = audioManager.getStreamVolume(3);
            Log.d(f5126a, "current media volume: " + vol);
            if (vol <= 2) {
                audioManager.setStreamVolume(3, 2, 0);
            }
            Log.d(f5126a, "set media volume: " + audioManager.getStreamVolume(3));
        }
    }


    public void setStatus() {
        this.mArbitrationModule.setStatus(true);
    }


    public boolean isBlueToothMode() {
        return AudioUtil.newInstance().isBlueToothMode();
    }


    public void setMode(int mode) {
        AudioUtil.newInstance().setMode(mode);
    }


    public boolean isSR() {
        return AudioUtil.newInstance().isSR();
    }


    public void setSR(int sr) {
        AudioUtil.newInstance().setSR(sr);
    }


    public byte[] m6068a(int type, int dataLen) {
        PCMPackageHead ttsPackage = new PCMPackageHead();
        ttsPackage.m4053c(type);
        ttsPackage.m4047a(dataLen);
        return ttsPackage.m4048a();
    }
}
