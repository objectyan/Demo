package com.baidu.baidunavis.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class SoundUtils {
    private static final int MSG_TYPE_RELOAD_SOUND_RES = 1;
    private static final String TAG = SoundUtils.class.getSimpleName();
    private boolean loadSuccess;
    private Context mContext;
    private Handler mHandler;
    private int soundID;
    private SoundPool sp;

    /* renamed from: com.baidu.baidunavis.tts.SoundUtils$2 */
    class C08832 implements OnLoadCompleteListener {
        C08832() {
        }

        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            SoundUtils.this.loadSuccess = status == 0;
        }
    }

    /* renamed from: com.baidu.baidunavis.tts.SoundUtils$3 */
    class C08843 implements OnLoadCompleteListener {
        C08843() {
        }

        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            boolean z = true;
            if (SoundUtils.this.mHandler != null) {
                SoundUtils.this.mHandler.removeMessages(1);
            }
            SoundUtils soundUtils = SoundUtils.this;
            if (status != 0) {
                z = false;
            }
            soundUtils.loadSuccess = z;
        }
    }

    public SoundUtils(int soundRawResId) {
        this.mContext = null;
        this.sp = null;
        this.soundID = -1;
        this.loadSuccess = false;
        this.mHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData()) {

            /* renamed from: com.baidu.baidunavis.tts.SoundUtils$1$1 */
            class C08811 implements OnLoadCompleteListener {
                C08811() {
                }

                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    NavLogUtils.m3003e(SoundUtils.TAG, "handleMessage onLoadComplete soundPool = " + soundPool + ", status = " + status + ", sampleId = " + sampleId);
                    SoundUtils.this.loadSuccess = status == 0;
                }
            }

            public void onMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        NavLogUtils.m3003e(SoundUtils.TAG, "handleMessage loadSuccess = " + SoundUtils.this.loadSuccess + ", sp = " + SoundUtils.this.sp);
                        if (!SoundUtils.this.loadSuccess && SoundUtils.this.sp != null) {
                            try {
                                if (VERSION.SDK_INT >= 8) {
                                    SoundUtils.this.sp.setOnLoadCompleteListener(new C08811());
                                } else {
                                    SoundUtils.this.loadSuccess = true;
                                }
                                SoundUtils.this.soundID = SoundUtils.this.sp.load(msg.obj, msg.arg1, 1);
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.loadSuccess = false;
        initSoundPool(soundRawResId);
    }

    public SoundUtils(Context context, int soundRawResId) {
        this.mContext = null;
        this.sp = null;
        this.soundID = -1;
        this.loadSuccess = false;
        this.mHandler = /* anonymous class already generated */;
        this.loadSuccess = false;
        this.mContext = context;
        initSoundPool(context, soundRawResId);
    }

    private void initSoundPool(Context context, int soundRawResId) {
        if (context == null || soundRawResId <= 0) {
            this.loadSuccess = false;
            return;
        }
        try {
            this.sp = new SoundPool(3, 4, 0);
        } catch (Exception e) {
        }
        if (this.sp != null) {
            if (VERSION.SDK_INT >= 8) {
                this.sp.setOnLoadCompleteListener(new C08832());
            } else {
                this.loadSuccess = true;
            }
            this.soundID = this.sp.load(context, soundRawResId, 1);
        }
    }

    private void initSoundPool(int soundRawResId) {
        Context context = NavMapAdapter.getInstance().getJNIInitializerContext();
        if (context == null || soundRawResId <= 0) {
            this.loadSuccess = false;
            return;
        }
        try {
            this.sp = new SoundPool(3, 3, 0);
        } catch (Exception e) {
        }
        if (this.sp != null) {
            if (VERSION.SDK_INT >= 8) {
                this.sp.setOnLoadCompleteListener(new C08843());
            } else {
                this.loadSuccess = true;
            }
            this.soundID = this.sp.load(context, soundRawResId, 1);
            if (this.mHandler != null && !this.loadSuccess) {
                Message msg = this.mHandler.obtainMessage(1);
                msg.obj = context;
                msg.arg1 = soundRawResId;
                this.mHandler.sendMessageDelayed(msg, 3000);
            }
        }
    }

    public boolean play() {
        if (BNSettingManager.getVoiceMode() == 2) {
            NavLogUtils.m3003e("SoundUtils", "voice mode is Quite, return");
            return false;
        } else if (BdTTSPlayer.isCalling(BNaviModuleManager.getContext())) {
            return false;
        } else {
            AudioManager am = null;
            if (this.mContext == null) {
                Context context = NavMapAdapter.getInstance().getJNIInitializerContext();
                if (context != null) {
                    am = (AudioManager) context.getSystemService("audio");
                }
            } else {
                am = (AudioManager) this.mContext.getSystemService("audio");
            }
            NavLogUtils.m3003e(TAG, "play loadSuccess = " + this.loadSuccess + ", sp = " + this.sp + ", am = " + am);
            if (!this.loadSuccess || this.sp == null || am == null) {
                return false;
            }
            float volumnRatio = ((float) am.getStreamVolume(3)) / ((float) am.getStreamMaxVolume(3));
            this.sp.play(this.soundID, volumnRatio, volumnRatio, 1, 0, 1.0f);
            return true;
        }
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
}
