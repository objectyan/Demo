package com.baidu.navisdk.util.listener;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.navisdk.util.common.LogUtil;

public class MediaFocuseChangeListener {
    private static final String TAG = MediaFocuseChangeListener.class.getSimpleName();
    public static OnAudioFocusChangeListener sOnAudioFocusChange = new C47071();

    /* renamed from: com.baidu.navisdk.util.listener.MediaFocuseChangeListener$1 */
    static class C47071 implements OnAudioFocusChangeListener {
        C47071() {
        }

        public void onAudioFocusChange(int focusChange) {
            LogUtil.m15791e(MediaFocuseChangeListener.TAG, "sdk onAudioFocusChange focusChange = " + focusChange);
            if (focusChange != 1 && focusChange != -2 && focusChange == -1) {
            }
        }
    }

    public static boolean requestAudioFocus(Context context) {
        LogUtil.m15791e(TAG, "sdk requestAudioFocus");
        if (context == null) {
            LogUtil.m15791e(TAG, "sdk requestAudioFocus context is null");
            return false;
        }
        AudioManager am = getAudioManager(context);
        if (am == null || am.requestAudioFocus(sOnAudioFocusChange, 3, 2) != 1) {
            return false;
        }
        return true;
    }

    public static boolean releaseAudioFocus(Context context) {
        LogUtil.m15791e(TAG, "sdk releaseAudioFocus");
        if (context == null) {
            LogUtil.m15791e(TAG, "sdk releaseAudioFocus context is null");
            return false;
        }
        AudioManager am = getAudioManager(context);
        if (am == null) {
            return false;
        }
        am.abandonAudioFocus(sOnAudioFocusChange);
        return true;
    }

    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }
}
