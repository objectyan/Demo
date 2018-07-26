package com.baidu.navisdk.module.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;

public class BusinessActivityPlayerManager {
    public static final int AUDIO_PLAY_TIMEOUT = 15000;
    private static final int MSG_FORCE_RESET_PLAY_AUDIO = 102;
    private static final int MSG_PLAY_AUDIO = 101;
    private static final int MSG_PLAY_TEXT = 100;
    private static final String TAG = BusinessActivityPlayerManager.class.getSimpleName();
    private static Object mSyncObj = new Object();
    private static BusinessActivityPlayerManager sInstance = null;
    private Handler mHD = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (100 == msg.what && msg.obj != null && (msg.obj instanceof String)) {
                if (msg.arg1 != 2 || BNaviModuleManager.isAppForeground()) {
                    BusinessActivityPlayerManager.this.playText((String) msg.obj);
                } else {
                    LogUtil.m15791e(BusinessActivityPlayerManager.TAG, "handleMessage()1 return for background.");
                }
            } else if (101 == msg.what && msg.obj != null && (msg.obj instanceof String)) {
                if (msg.arg1 != 2 || BNaviModuleManager.isAppForeground()) {
                    BusinessActivityPlayerManager.this.playAudio((String) msg.obj, msg.arg1);
                } else {
                    LogUtil.m15791e(BusinessActivityPlayerManager.TAG, "handleMessage()2 return for background.");
                }
            } else if (102 == msg.what) {
                BusinessActivityPlayerManager.this.mIsAudioPlaying = false;
                BusinessActivityPlayerManager.this.cancelPlayAudio();
            }
        }
    };
    private boolean mIsAudioPlaying = false;

    /* renamed from: com.baidu.navisdk.module.business.BusinessActivityPlayerManager$1 */
    class C41571 implements AudioPlayerListener {
        C41571() {
        }

        public void playCompletion() {
            BusinessActivityPlayerManager.this.cancelPlayAudio();
        }
    }

    private BusinessActivityPlayerManager() {
    }

    public static BusinessActivityPlayerManager getInstance() {
        if (sInstance == null) {
            synchronized (mSyncObj) {
                if (sInstance == null) {
                    sInstance = new BusinessActivityPlayerManager();
                }
            }
        }
        return sInstance;
    }

    public void playNaviStartContent() {
        Message msg;
        if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceLinkOnStartNavi) && !TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voicePathOnStartNavi)) {
            msg = this.mHD.obtainMessage(101);
            msg.arg1 = 1;
            msg.obj = BusinessActivityManager.getInstance().getModel().voicePathOnStartNavi;
            this.mHD.sendMessageDelayed(msg, 1200);
            LogUtil.m15791e(TAG, "playNaviStartContent() play audio");
        } else if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceTextOnStartNavi)) {
            msg = this.mHD.obtainMessage(100);
            msg.obj = BusinessActivityManager.getInstance().getModel().voiceTextOnStartNavi;
            this.mHD.sendMessageDelayed(msg, 1200);
            LogUtil.m15791e(TAG, "playNaviStartContent() play text");
        }
    }

    public void playHolidayRedGift() {
        if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().envelopeSoundEffectLink) && !TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().envelopeSoundEffectPath)) {
            Message msg = this.mHD.obtainMessage(101);
            msg.arg1 = 1;
            msg.obj = BusinessActivityManager.getInstance().getModel().envelopeSoundEffectPath;
            this.mHD.sendMessage(msg);
            LogUtil.m15791e(TAG, "playHolidayRedGift() play audio");
        }
    }

    public void playNaviEndContent() {
        if (!BNaviModuleManager.isAppForeground()) {
            LogUtil.m15791e(TAG, "playNaviEndContent() return for background.");
        } else if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceLinkOnEndNavi) && !TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voicePathOnEndNavi)) {
            msg = this.mHD.obtainMessage(101);
            msg.arg1 = 2;
            msg.obj = BusinessActivityManager.getInstance().getModel().voicePathOnEndNavi;
            this.mHD.sendMessageDelayed(msg, 1200);
            LogUtil.m15791e(TAG, "playNaviEndContent() play audio");
        } else if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().voiceTextOnEndNavi)) {
            msg = this.mHD.obtainMessage(100);
            msg.obj = BusinessActivityManager.getInstance().getModel().voiceTextOnEndNavi;
            this.mHD.sendMessageDelayed(msg, 1200);
            LogUtil.m15791e(TAG, "playNaviEndContent() play text");
        }
    }

    public void playContentWhenShowActivity() {
        if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoiceLink) && !TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoicePath)) {
            playAudio(BusinessActivityManager.getInstance().getModel().showVoicePath, 3);
            LogUtil.m15791e(TAG, "playContentWhenShowActivity() play audio");
        } else if (!TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().showVoiceText)) {
            playText(BusinessActivityManager.getInstance().getModel().showVoiceText);
            LogUtil.m15791e(TAG, "playContentWhenShowActivity() play text");
        }
    }

    public boolean isAudioPlaying() {
        return this.mIsAudioPlaying;
    }

    private void playAudio(String audioPath, int what) {
        cancelPlayAudio();
        if (TTSPlayerControl.getTTSState() == 1) {
            this.mIsAudioPlaying = true;
            LogUtil.m15791e(TAG, "playAudio() audio play true 1");
            try {
                TTSPlayerControl.stopVoiceTTSOutput();
                TTSPlayerControl.playAudio(audioPath, new C41571());
                this.mIsAudioPlaying = true;
                LogUtil.m15791e(TAG, "playAudio() audio play true 2");
                if (this.mHD.hasMessages(102)) {
                    this.mHD.removeMessages(102);
                }
                this.mHD.sendEmptyMessageDelayed(102, 15000);
                return;
            } catch (Exception e) {
                this.mIsAudioPlaying = false;
                return;
            }
        }
        this.mIsAudioPlaying = false;
        Message msg = this.mHD.obtainMessage(101);
        msg.arg1 = what;
        msg.obj = audioPath;
        this.mHD.sendMessageDelayed(msg, 1000);
    }

    public void cancelPlayAudio() {
        LogUtil.m15791e(TAG, "cancelPlayAudio");
        if (this.mHD.hasMessages(102)) {
            this.mHD.removeMessages(102);
        }
        TTSPlayerControl.cancelAudio();
        this.mIsAudioPlaying = false;
    }

    public void cancelPlayAudioAndPlayMsg() {
        if (this.mHD.hasMessages(101)) {
            this.mHD.removeMessages(101);
        }
        if (this.mHD.hasMessages(100)) {
            this.mHD.removeMessages(100);
        }
        cancelPlayAudio();
    }

    private void playText(String text) {
        if (TTSPlayerControl.getTTSState() == 1) {
            TTSPlayerControl.playTTS(text, 0);
            return;
        }
        Message msg = this.mHD.obtainMessage(100);
        msg.obj = text;
        this.mHD.sendMessageDelayed(msg, 1000);
    }
}
