package com.baidu.mapframework.tts;

import android.os.Handler;
import com.baidu.baidunavis.control.NavTTSController;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.platform.comapi.C2907c;

/* compiled from: BdTTSPlayerImpl */
/* renamed from: com.baidu.mapframework.tts.a */
public class C3570a implements ITTSPlayer {
    public int init() {
        C3574c.m15234a(C2907c.f());
        return 0;
    }

    public int getState() {
        return BaseTTSPlayer.getInstance().getTTSState();
    }

    public int getInitState() {
        return BaseTTSPlayer.getInstance().getInitState();
    }

    public int playText(String speech, boolean bPreempt) {
        return BaseTTSPlayer.getInstance().playTTSText(speech, bPreempt);
    }

    public int xdPlayText(String speech, boolean bPreempt) {
        return 0;
    }

    public void stop() {
        BaseTTSPlayer.getInstance().stopTTS();
    }

    public void release() {
        BaseTTSPlayer.getInstance().releaseTTSPlayer();
    }

    public void changeTTSPlayerVolume(boolean isMax) {
        BaseTTSPlayer.getInstance().changeTTSPlayerVolume(isMax);
    }

    public void setPlayModeAsync() {
        BaseTTSPlayer.getInstance().setPlayModeAsync();
    }

    public void setPlayModeSync() {
        BaseTTSPlayer.getInstance().setPlayModeSync();
    }

    public void setOnTTSPlayCompleteListener(final OnTTSPlayCompleteListener listener) {
        BaseTTSPlayer.getInstance().setOnTTSStateChangedListener(new OnTTSStateChangedListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3570a f19275b;

            public void onPlayEnd() {
                listener.onPlayComplete();
            }

            public void onPlayStart() {
            }

            public void onPlayError(int code, String message) {
            }
        });
    }

    public void setOnTTSPlayStartListener(OnTTSPlayStartListener listener) {
    }

    public int pause() {
        return BaseTTSPlayer.getInstance().pauseTTS();
    }

    public int resume() {
        return BaseTTSPlayer.getInstance().resumeTTS();
    }

    public void setOnTTSPlayErrorListener(OnTTSPlayErrorListener listener) {
    }

    public int setTTSPlaySpeed(int speed) {
        return BaseTTSPlayer.getInstance().setPlaySpeed(speed);
    }

    public int getCurrentProgress() {
        return BaseTTSPlayer.getInstance().getCurrentProgress();
    }

    public String getVoicePath(String ttsId) {
        return NavTTSController.getInstant().getVoicePath(ttsId);
    }

    public boolean startDownload(String ttsId) {
        return NavTTSController.getInstant().startDownload(ttsId);
    }

    public boolean pauseDownload(String ttsId) {
        return NavTTSController.getInstant().pauseDownload(ttsId);
    }

    public boolean pauseAllDownload() {
        return NavTTSController.getInstant().pauseAllDownload();
    }

    public boolean switchVoice(String voicePath, String textPath) {
        return NavTTSController.getInstant().switchVoice(voicePath, textPath);
    }

    public boolean recoveryToNavVoice() {
        return NavTTSController.getInstant().recoveryToNavVoice();
    }

    public void registCallbackHandler(Handler handler) {
        NavTTSController.getInstant().registCallbackHandler(handler);
    }

    public void unregistCallbackHandler(Handler handler) {
        NavTTSController.getInstant().unregistCallbackHandler(handler);
    }

    public void addOnTTSStateChangeListener(OnTTSStateChangedListener listener) {
        BaseTTSPlayer.getInstance().addOnTTSStateChangedListener(listener);
    }

    public void removeOnTTSStateChangeListener(OnTTSStateChangedListener listener) {
        BaseTTSPlayer.getInstance().removeOnTTSStateChangedListener(listener);
    }
}
