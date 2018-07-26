package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;

public class SoundUtils {
    private AssetFileDescriptor afd;
    private boolean loadSuccess;
    private int soundID;
    private SoundPool sp;

    /* renamed from: com.baidu.navisdk.util.common.SoundUtils$1 */
    class C46291 implements OnLoadCompleteListener {
        C46291() {
        }

        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            if (status == 0) {
                SoundUtils.this.loadSuccess = true;
                try {
                    if (SoundUtils.this.afd != null) {
                        SoundUtils.this.afd.close();
                        return;
                    }
                    return;
                } catch (IOException e) {
                    LogUtil.m15791e("initSoundPool", "close afd failed, " + e);
                    return;
                }
            }
            SoundUtils.this.loadSuccess = false;
        }
    }

    public SoundUtils(int soundRawResId) {
        this.sp = null;
        this.soundID = -1;
        this.loadSuccess = false;
        this.afd = null;
        this.loadSuccess = false;
        initSoundPool(soundRawResId);
    }

    private void initSoundPool(int soundRawResId) {
        if (soundRawResId <= 0) {
            this.loadSuccess = false;
            return;
        }
        try {
            this.afd = JarUtils.getResources().openRawResourceFd(soundRawResId);
        } catch (Exception e) {
            this.afd = null;
        }
        if (this.afd == null) {
            this.loadSuccess = false;
            return;
        }
        try {
            this.sp = new SoundPool(3, 3, 0);
            if (VERSION.SDK_INT >= 8) {
                this.sp.setOnLoadCompleteListener(new C46291());
            } else {
                this.loadSuccess = true;
            }
            this.soundID = this.sp.load(this.afd, 1);
            if (VERSION.SDK_INT < 8 && this.afd != null) {
                try {
                    this.afd.close();
                } catch (Exception e2) {
                    LogUtil.m15791e("initSoundPool", "close afd failed, " + e2);
                }
            }
        } catch (Exception e22) {
            LogUtil.m15791e("initSoundPool", "new SoundPool err, " + e22);
            this.loadSuccess = false;
        }
    }

    public boolean play() {
        if (BNSettingManager.getVoiceMode() == 2) {
            LogUtil.m15791e("SoundUtils", "voice mode is Quite, return");
            return false;
        }
        Context context = BNaviModuleManager.getContext();
        if (isCalling(context) || context == null || !this.loadSuccess || this.sp == null) {
            return false;
        }
        AudioManager am = (AudioManager) context.getSystemService("audio");
        float volumnRatio = ((float) am.getStreamVolume(3)) / ((float) am.getStreamMaxVolume(3));
        this.sp.play(this.soundID, volumnRatio, volumnRatio, 1, 0, 1.0f);
        return true;
    }

    public void stop() {
        if (this.sp != null) {
            this.sp.stop(3);
        }
    }

    public void release() {
        if (this.sp != null) {
            if (this.loadSuccess) {
                this.sp.unload(this.soundID);
            }
            this.sp.release();
            this.sp = null;
        }
    }

    public static boolean isCalling(Context context) {
        if (context == null) {
            return false;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getCallState()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }
}
