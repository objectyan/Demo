package com.baidu.carlife.core.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ArbitrationModule */
/* renamed from: com.baidu.carlife.core.audio.b */
public class ArbitrationModule {
    /* renamed from: a */
    private static final String Tag = (AudioUtil.AUDIO + ArbitrationModule.class.getSimpleName());
    /* renamed from: b */
    private static ArbitrationModule sArbitrationModule;
    /* renamed from: e */
    private AudioManager mAudioManager;
    /* renamed from: f */
    private Timer mTimer;
    /* renamed from: g */
    private TimerTask mTimerTask;
    /* renamed from: h */
    private boolean mStatus = false;
    /* renamed from: i */
    private Context mContext;
    /* renamed from: j */
    private OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioFocusChangeListener(this);

    /* compiled from: ArbitrationModule */
    /* renamed from: com.baidu.carlife.core.audio.b$1 */
    class AudioFocusChangeListener implements OnAudioFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ ArbitrationModule mArbitrationModule;

        AudioFocusChangeListener(ArbitrationModule this$0) {
            this.mArbitrationModule = this$0;
        }

        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case -3:
                    LogUtil.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    MsgHandlerCenter.dispatchMessage(270, -3);
                    return;
                case -2:
                    LogUtil.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS_TRANSIENT");
                    MsgHandlerCenter.dispatchMessage(270, -2);
                    return;
                case -1:
                    if (AudioUtil.getIs()) {
                        LogUtil.d(ArbitrationModule.Tag, "AUDIOFOCUS_LOSS is triggered");
                        this.mArbitrationModule.startTimer();
                        return;
                    }
                    LogUtil.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.dispatchMessage(270, -1);
                    return;
                case 1:
                    LogUtil.d(ArbitrationModule.Tag, "music AUDIOFOCUS_GAIN");
                    MsgHandlerCenter.dispatchMessage(270, 1);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ArbitrationModule */
    /* renamed from: com.baidu.carlife.core.audio.b$2 */
    class ArbitrationModuleTask extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ ArbitrationModule mArbitrationModule;

        ArbitrationModuleTask(ArbitrationModule this$0) {
            this.mArbitrationModule = this$0;
        }

        public void run() {
            if (this.mArbitrationModule.mTimer != null) {
                if (this.mArbitrationModule.getStatus()) {
                    this.mArbitrationModule.musicAudioFocus();
                    this.mArbitrationModule.setStatus(false);
                } else {
                    LogUtil.d(ArbitrationModule.Tag, "delay to send AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.dispatchMessage(270, -1);
                    this.mArbitrationModule.setStatus(false);
                }
                this.mArbitrationModule.stopTimer();
            }
        }
    }

    private ArbitrationModule() {
    }

    /* renamed from: a */
    public static ArbitrationModule newInstance() {
        if (sArbitrationModule == null) {
            sArbitrationModule = new ArbitrationModule();
        }
        return sArbitrationModule;
    }

    /* renamed from: a */
    public void initContext(Context context) {
        this.mContext = context;
    }

    /* renamed from: b */
    public int musicAudioFocus() {
        LogUtil.d(Tag, "music request Audio Focus");
        if (this.mContext == null) {
            LogUtil.e(Tag, "mContext is not initialized!");
            return 1;
        }
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(Context.AUDIO_SERVICE);
        if (this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1) == 1) {
            return 0;
        }
        return -1;
    }

    /* renamed from: c */
    public int m3908c() {
        return 0;
    }

    /* renamed from: e */
    private void startTimer() {
        try {
            LogUtil.e(Tag, "Timer Start");
            this.mTimer = new Timer();
            this.mTimerTask = new ArbitrationModuleTask(this);
            this.mTimer.schedule(this.mTimerTask, 100);
        } catch (Exception ex) {
            LogUtil.d(Tag, "startTimer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: f */
    private void stopTimer() {
        LogUtil.e(Tag, "Timer Stop");
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    /* renamed from: a */
    public void setStatus(boolean status) {
        this.mStatus = status;
    }

    /* renamed from: g */
    private boolean getStatus() {
        return this.mStatus;
    }
}
