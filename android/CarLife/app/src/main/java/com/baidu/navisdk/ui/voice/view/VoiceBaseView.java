package com.baidu.navisdk.ui.voice.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice$OnVoicePageJumpListener;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceUserAction;

public abstract class VoiceBaseView {
    public static final String ACTION_PARAM = "actionParam";
    public static final String URL_CHECK = "bdnavi://check";
    public static final String URL_NET_LOSS = "bdnavi://getdataerr";
    public static final String URL_PASS_TOPIC_INFO = "bdnavi://passTopicInfo";
    public static final String URL_PAUSE = "bdnavi://pause";
    public static final String URL_PREFIX = "bdnavi://";
    public static final String URL_START = "bdnavi://start";
    public static final String YPID = "ypid";
    public boolean hasPaused = false;
    protected Activity mActivity = null;
    protected Handler mHandler = null;
    protected BNVoice$OnVoicePageJumpListener mJumpListener;

    public abstract void initValues(Bundle bundle);

    protected abstract View onInitView(Bundle bundle);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onUpdateStyle(boolean z);

    public Handler getHandler() {
        return this.mHandler;
    }

    public View initView(Activity activity, BNVoice$OnVoicePageJumpListener listener, Bundle configBundle) {
        this.mActivity = activity;
        this.mJumpListener = listener;
        this.mHandler = new Handler(activity.getMainLooper()) {
            public void handleMessage(Message msg) {
                BNVoice.getInstance().handleVoiceMessage(msg.what, msg.arg1, msg.obj);
            }
        };
        if (listener != null) {
            listener.onVoiceUserBehaviour(BNVoice$VoiceUserAction.voice_access);
        }
        View view = onInitView(configBundle);
        initValues(configBundle);
        return view;
    }

    public void onDestory() {
    }

    public boolean onBackPressed() {
        return true;
    }

    public void onUpdateOrientation(int orientation) {
    }
}
