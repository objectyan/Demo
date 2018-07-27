package me.objectyan.screensharing.core.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;

import java.util.Timer;
import java.util.TimerTask;


public class ArbitrationModule {

    private static final String Tag = (AudioUtil.AUDIO + ArbitrationModule.class.getSimpleName());

    private static ArbitrationModule sArbitrationModule;

    private AudioManager mAudioManager;

    private Timer mTimer;

    private TimerTask mTimerTask;

    private boolean mStatus = false;

    private Context mContext;

    private OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioFocusChangeListener(this);


    class AudioFocusChangeListener implements OnAudioFocusChangeListener {

        final ArbitrationModule mArbitrationModule;

        AudioFocusChangeListener(ArbitrationModule this$0) {
            this.mArbitrationModule = this$0;
        }

        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case -3:
                    Log.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    MsgHandlerCenter.dispatchMessage(270, -3);
                    return;
                case -2:
                    Log.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS_TRANSIENT");
                    MsgHandlerCenter.dispatchMessage(270, -2);
                    return;
                case -1:
                    if (AudioUtil.getIs()) {
                        Log.d(ArbitrationModule.Tag, "AUDIOFOCUS_LOSS is triggered");
                        this.mArbitrationModule.startTimer();
                        return;
                    }
                    Log.d(ArbitrationModule.Tag, "music AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.dispatchMessage(270, -1);
                    return;
                case 1:
                    Log.d(ArbitrationModule.Tag, "music AUDIOFOCUS_GAIN");
                    MsgHandlerCenter.dispatchMessage(270, 1);
                    return;
                default:
                    return;
            }
        }
    }


    class ArbitrationModuleTask extends TimerTask {

        final ArbitrationModule mArbitrationModule;

        ArbitrationModuleTask(ArbitrationModule this$0) {
            this.mArbitrationModule = this$0;
        }

        public void run() {
            if (this.mArbitrationModule.mTimer != null) {
                if (this.mArbitrationModule.getStatus()) {
                    this.mArbitrationModule.musicAudioFocus();
                    this.mArbitrationModule.setStatus(false);
                } else {
                    Log.d(ArbitrationModule.Tag, "delay to send AUDIOFOCUS_LOSS");
                    MsgHandlerCenter.dispatchMessage(270, -1);
                    this.mArbitrationModule.setStatus(false);
                }
                this.mArbitrationModule.stopTimer();
            }
        }
    }

    private ArbitrationModule() {
    }


    public static ArbitrationModule newInstance() {
        if (sArbitrationModule == null) {
            sArbitrationModule = new ArbitrationModule();
        }
        return sArbitrationModule;
    }


    public void initContext(Context context) {
        this.mContext = context;
    }


    public int musicAudioFocus() {
        Log.d(Tag, "music request Audio Focus");
        if (this.mContext == null) {
            Log.e(Tag, "mContext is not initialized!");
            return 1;
        }
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(Context.AUDIO_SERVICE);
        if (this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1) == 1) {
            return 0;
        }
        return -1;
    }


    public int m3908c() {
        return 0;
    }


    private void startTimer() {
        try {
            Log.e(Tag, "Timer Start");
            this.mTimer = new Timer();
            this.mTimerTask = new ArbitrationModuleTask(this);
            this.mTimer.schedule(this.mTimerTask, 100);
        } catch (Exception ex) {
            Log.d(Tag, "startTimer get exception");
            ex.printStackTrace();
        }
    }


    private void stopTimer() {
        Log.e(Tag, "Timer Stop");
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }


    public void setStatus(boolean status) {
        this.mStatus = status;
    }


    private boolean getStatus() {
        return this.mStatus;
    }
}
