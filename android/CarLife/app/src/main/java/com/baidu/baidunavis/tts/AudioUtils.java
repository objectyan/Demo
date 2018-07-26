package com.baidu.baidunavis.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class AudioUtils {
    public static final int STREAM_NAVI_TTS = 3;
    private static final String TAG = AudioUtils.class.getSimpleName();
    public static boolean sIsPaused;
    public static OnAudioFocusChangeListener sOnAudioFocusChange = new C08681();
    public static int sVolumeBeforePause = 0;

    /* renamed from: com.baidu.baidunavis.tts.AudioUtils$1 */
    static class C08681 implements OnAudioFocusChangeListener {
        C08681() {
        }

        public void onAudioFocusChange(int focusChange) {
            NavLogUtils.m3003e(AudioUtils.TAG, "baidunavis onAudioFocusChange focusChange = " + focusChange);
            switch (focusChange) {
                case -2:
                    BaseTTSPlayer.getInstance().stopTTS();
                    AudioUtils.releaseAudioFocus(NavMapAdapter.getInstance().getContainerActivity());
                    return;
                default:
                    return;
            }
        }
    }

    public static int getStreamType() {
        try {
            getAudioManager(NavMapAdapter.getInstance().getContainerActivity()).getStreamVolume(3);
            return 3;
        } catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
    }

    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public static int getCurrentVolume(Context context) {
        int i = 11;
        if (context != null) {
            try {
                i = getAudioManager(context).getStreamVolume(getStreamType());
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static void setVolume(Context context, int volume) {
        if (context != null) {
            try {
                getAudioManager(context).setStreamVolume(getStreamType(), volume, 0);
            } catch (Exception e) {
            }
        }
    }

    public static boolean requestAudioFocus(Context context) {
        NavLogUtils.m3003e(TAG, "baidunavis requestAudioFocus");
        if (context == null) {
            NavLogUtils.m3003e(TAG, "baidunavis requestAudioFocus context is null");
            return false;
        }
        try {
            AudioManager am = getAudioManager(context);
            if (am == null || am.requestAudioFocus(sOnAudioFocusChange, getStreamType(), 3) != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean requestAudioFocusToStopMusic(Context context) {
        NavLogUtils.m3003e(TAG, "baidunavis requestAudioFocus");
        if (context == null) {
            NavLogUtils.m3003e(TAG, "baidunavis requestAudioFocus context is null");
            return false;
        }
        try {
            AudioManager am = getAudioManager(context);
            if (am == null || am.requestAudioFocus(sOnAudioFocusChange, getStreamType(), 2) != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean releaseAudioFocus(Context context) {
        NavLogUtils.m3003e(TAG, "baidunavis releaseAudioFocus");
        if (context == null) {
            NavLogUtils.m3003e(TAG, "baidunavis releaseAudioFocus context is null");
            return false;
        }
        getAudioManager(context).abandonAudioFocus(sOnAudioFocusChange);
        return true;
    }

    public static void volumeUp(Context context) {
        if (context != null) {
            try {
                AudioManager am = getAudioManager(context);
                int maxVolume = am.getStreamMaxVolume(getStreamType());
                int curVolume = am.getStreamVolume(getStreamType());
                if (curVolume < maxVolume) {
                    setVolume(context, curVolume + 1);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void volumeDown(Context context) {
        if (context != null) {
            try {
                int curVolume = getCurrentVolume(context);
                if (curVolume > 0) {
                    setVolume(context, curVolume - 1);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void pauseTTS(Context context) {
        int curVolume = getCurrentVolume(context);
        if (curVolume != 0) {
            sVolumeBeforePause = curVolume;
            sIsPaused = true;
            setVolume(context, 0);
        }
    }

    public static void resumeTTS(final Context context) {
        if (sIsPaused) {
            sIsPaused = false;
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("AudioUtils.resumeTTS", null) {
                protected String execute() {
                    AudioUtils.setVolume(context, AudioUtils.sVolumeBeforePause);
                    return null;
                }
            }, new BNWorkerConfig(100, 0), 2000);
        }
    }
}
