package com.baidu.navisdk.ui.voice.controller;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.controller.AudioPlayer.OnVoicePlayCompletedListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.util.ArrayList;

public class VoicePlayController {
    private AudioPlayer mAudioPlayer;
    private PlayAllAudioEndListener mPlayAllEndListener;
    private PlayHandler mPlayHandler;

    private static class LazyHolder {
        public static final VoicePlayController sInstance = new VoicePlayController();

        private LazyHolder() {
        }
    }

    public interface PlayAllAudioEndListener {
        void onPlayAllEnd();
    }

    class PlayHandler extends Handler {
        private static final int MSG_END_PALY_AUDIO = 2;
        private static final int MSG_NEXT_PALY_AUDIO = 1;
        private static final int MSG_STOP_PLAY_AUDIO = 0;
        private AudioPlayer audioPlayer = new AudioPlayer();
        private ArrayList<String> auidoPaths = new ArrayList();
        private long delayMillis = 500;
        private boolean init = false;
        private Object mutex = new Object();
        private int playPos = 0;
        private int playSize = 0;
        private boolean start = false;
        private boolean stop = false;

        /* renamed from: com.baidu.navisdk.ui.voice.controller.VoicePlayController$PlayHandler$1 */
        class C45301 implements OnVoicePlayCompletedListener {
            C45301() {
            }

            public void onPlaycompleted() {
                PlayHandler.this.handleNextPlay();
            }
        }

        PlayHandler() {
        }

        public void init() {
            if (!this.init) {
                this.init = this.audioPlayer.init();
            }
        }

        public void destory() {
            if (this.start) {
                sendEmptyMessage(0);
            }
            if (this.init) {
                this.audioPlayer.release();
                this.init = false;
            }
        }

        private void handleNextPlay() {
            if (!this.stop) {
                synchronized (this.mutex) {
                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "playHandler play end " + this.playPos);
                    this.playPos++;
                    if (this.playPos < this.playSize) {
                        sendEmptyMessageDelayed(1, this.delayMillis);
                    } else {
                        sendEmptyMessage(2);
                    }
                }
            }
        }

        public void start(ArrayList<String> paths) {
            if (!this.start) {
                this.auidoPaths.clear();
                this.auidoPaths.addAll(paths);
                this.playPos = 0;
                this.playSize = this.auidoPaths.size();
                this.audioPlayer.setPlayCompletedListener(new C45301());
                sendEmptyMessage(1);
                this.start = true;
                this.stop = false;
            }
        }

        public void stop() {
            if (this.start) {
                sendEmptyMessage(0);
                this.stop = true;
                this.start = false;
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "handle msg stop play all voice");
                    removeMessages(1);
                    this.audioPlayer.stop();
                    return;
                case 1:
                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "handle msg next play all voice");
                    if (!this.stop) {
                        String path = null;
                        synchronized (this.mutex) {
                            if (this.auidoPaths.size() > this.playPos) {
                                path = (String) this.auidoPaths.get(this.playPos);
                            }
                        }
                        if (!this.audioPlayer.start(path)) {
                            handleNextPlay();
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "handle msg end play all voice");
                    this.start = false;
                    this.stop = true;
                    if (VoicePlayController.this.mPlayAllEndListener != null) {
                        VoicePlayController.this.mPlayAllEndListener.onPlayAllEnd();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static VoicePlayController getInstance() {
        return LazyHolder.sInstance;
    }

    private VoicePlayController() {
        this.mAudioPlayer = new AudioPlayer();
        this.mPlayHandler = null;
        this.mPlayAllEndListener = null;
    }

    public void setAudioPlayCompleteListener(OnVoicePlayCompletedListener listener) {
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setPlayCompletedListener(listener);
        }
    }

    public boolean initPlayer() {
        return this.mAudioPlayer.init();
    }

    public void releasePlayer() {
        this.mAudioPlayer.stop();
        this.mAudioPlayer.release();
    }

    public void playVoice(String taskId) {
        stopPlayVoice();
        String filePath = VoiceHelper.getInstance().getVoiceSetPath(taskId);
        if (!StringUtils.isEmpty(filePath)) {
            play(filePath);
        }
    }

    public void playVoice(String taskId, String orgWord) {
        stopPlayVoice();
        String filePath = VoiceHelper.getInstance().getVoiceItemPath(taskId, orgWord);
        if (!StringUtils.isEmpty(filePath)) {
            play(filePath);
        }
    }

    public void stopPlayVoice() {
        this.mAudioPlayer.stop();
    }

    private boolean play(String filePath) {
        this.mAudioPlayer.stop();
        return this.mAudioPlayer.start(filePath);
    }

    public void setPlayAllAudioEndListener(PlayAllAudioEndListener listener) {
        this.mPlayAllEndListener = listener;
    }

    public void initPlayAllVoice() {
        this.mPlayHandler = new PlayHandler();
        this.mPlayHandler.init();
    }

    public void releasePlayAllVoice() {
        if (this.mPlayHandler != null) {
            this.mPlayHandler.destory();
        }
    }

    public void playAllVoice(ArrayList<String> paths) {
        if (this.mPlayHandler != null) {
            this.mPlayHandler.start(paths);
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "start play all voice");
        }
    }

    public void stopAllVoice() {
        if (this.mPlayHandler != null) {
            this.mPlayHandler.stop();
            LogUtil.m15791e(BNVoiceParams.MODULE_TAG, "stop play all voice");
        }
    }
}
