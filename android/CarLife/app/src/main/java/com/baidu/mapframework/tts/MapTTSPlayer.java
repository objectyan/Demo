package com.baidu.mapframework.tts;

import android.os.Handler;

public class MapTTSPlayer {
    /* renamed from: a */
    private ITTSPlayer f19273a;

    /* renamed from: com.baidu.mapframework.tts.MapTTSPlayer$a */
    private static final class C3566a {
        /* renamed from: a */
        private static final MapTTSPlayer f19264a = new MapTTSPlayer();

        private C3566a() {
        }
    }

    /* renamed from: com.baidu.mapframework.tts.MapTTSPlayer$b */
    public static class C3567b {
        /* renamed from: a */
        public static final int f19265a = 0;
        /* renamed from: b */
        public static final int f19266b = 1;
        /* renamed from: c */
        public static final int f19267c = 2;
    }

    /* renamed from: com.baidu.mapframework.tts.MapTTSPlayer$c */
    public static class C3568c {
        /* renamed from: a */
        public static final int f19268a = 0;
        /* renamed from: b */
        public static final int f19269b = 1;
        /* renamed from: c */
        public static final int f19270c = 2;
        /* renamed from: d */
        public static final int f19271d = 3;
        /* renamed from: e */
        public static final int f19272e = 4;
    }

    private MapTTSPlayer() {
        this.f19273a = null;
    }

    public static MapTTSPlayer getInstance() {
        return C3566a.f19264a;
    }

    public void initPlayer() {
        if (this.f19273a == null) {
            this.f19273a = new C3570a();
        }
    }

    public int getInitState() {
        return this.f19273a.getInitState();
    }

    public int getTTSState() {
        if (this.f19273a != null) {
            return this.f19273a.getState();
        }
        return 0;
    }

    public int playTTSText(String speech, boolean bPreempt) {
        if (this.f19273a != null) {
            return this.f19273a.playText(speech, bPreempt);
        }
        return 0;
    }

    public int xdPlayTTSText(String speech, boolean bPreempt) {
        if (this.f19273a != null) {
            return this.f19273a.xdPlayText(speech, bPreempt);
        }
        return 0;
    }

    public void setPlayModeAsync() {
        if (this.f19273a != null) {
            this.f19273a.setPlayModeAsync();
        }
    }

    public void setPlayModeSync() {
        if (this.f19273a != null) {
            this.f19273a.setPlayModeSync();
        }
    }

    public void stopTTS() {
        if (this.f19273a != null) {
            this.f19273a.stop();
        }
    }

    public int pauseTTS() {
        if (this.f19273a != null) {
            return this.f19273a.pause();
        }
        return -1;
    }

    public int resumeTTS() {
        if (this.f19273a != null) {
            return this.f19273a.resume();
        }
        return -1;
    }

    public void releaseTTSPlayer() {
        if (this.f19273a != null) {
            this.f19273a.release();
        }
    }

    public void addOnTTSPlayerStateListener(OnTTSStateChangedListener listener) {
        if (this.f19273a != null) {
            this.f19273a.addOnTTSStateChangeListener(listener);
        }
    }

    public void removeOnTTSPlayerStateListener(OnTTSStateChangedListener listener) {
        if (this.f19273a != null) {
            this.f19273a.removeOnTTSStateChangeListener(listener);
        }
    }

    public void setOnTTSPlayStartListener(OnTTSPlayStartListener listener) {
        if (listener != null) {
            this.f19273a.setOnTTSPlayStartListener(listener);
        }
    }

    public void setOnTTSPlayCompleteListener(OnTTSPlayCompleteListener listener) {
        if (listener != null) {
            this.f19273a.setOnTTSPlayCompleteListener(listener);
        }
    }

    public int setTTSPlaySpeed(int speedParam) {
        if (this.f19273a != null) {
            return this.f19273a.setTTSPlaySpeed(speedParam);
        }
        return -1;
    }

    public int getCurrentProgress() {
        if (this.f19273a != null) {
            return this.f19273a.getCurrentProgress();
        }
        return -1;
    }

    public String getVoicePath(String ttsId) {
        if (this.f19273a != null) {
            return this.f19273a.getVoicePath(ttsId);
        }
        return "";
    }

    public boolean startDownload(String ttsId) {
        if (this.f19273a != null) {
            return this.f19273a.startDownload(ttsId);
        }
        return false;
    }

    public boolean pauseDownload(String ttsId) {
        if (this.f19273a != null) {
            return this.f19273a.pauseDownload(ttsId);
        }
        return false;
    }

    public boolean pauseAllDownload() {
        if (this.f19273a != null) {
            return this.f19273a.pauseAllDownload();
        }
        return false;
    }

    public boolean switchVoice(String voicePath, String textPath) {
        if (this.f19273a != null) {
            return this.f19273a.switchVoice(voicePath, textPath);
        }
        return false;
    }

    public boolean recoveryToNavVoice() {
        if (this.f19273a != null) {
            return this.f19273a.recoveryToNavVoice();
        }
        return false;
    }

    public void registCallbackHandler(Handler handler) {
        if (this.f19273a != null) {
            this.f19273a.registCallbackHandler(handler);
        }
    }

    public void unregistCallbackHandler(Handler handler) {
        if (this.f19273a != null) {
            this.f19273a.unregistCallbackHandler(handler);
        }
    }
}
