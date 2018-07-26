package com.baidu.navisdk.lightnavi.viewhelp;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.vi.VDeviceAPI;

public class LightNaviScreenHelper {
    private static volatile LightNaviScreenHelper mInstance;
    private boolean isAlwaysLight = false;
    private boolean isLight = false;
    private Context mContext;
    private KeyguardManager mKeyguardManager;
    private PowerManager mPowerManager;
    private WakeLock mWakeLock;

    private LightNaviScreenHelper(Context mContext) {
        this.mPowerManager = (PowerManager) mContext.getSystemService("power");
        this.mWakeLock = this.mPowerManager.newWakeLock(268435466, "lock");
        this.mKeyguardManager = (KeyguardManager) mContext.getSystemService("keyguard");
    }

    public static LightNaviScreenHelper getInstance(Context mContext) {
        if (mInstance == null) {
            mInstance = new LightNaviScreenHelper(mContext);
        }
        return mInstance;
    }

    public void lightScreen() {
        if (this.mWakeLock != null && !this.isLight) {
            this.mWakeLock.acquire();
            this.isLight = true;
            this.mKeyguardManager.newKeyguardLock("unLock").disableKeyguard();
            LogUtil.m15791e("wangyang", "mWakeLock lightScreen");
        }
    }

    public void releaseScreen() {
        if (this.mWakeLock != null && this.mWakeLock.isHeld() && this.isLight) {
            this.mWakeLock.release();
            this.isLight = false;
            LogUtil.m15791e("wangyang", "mWakeLock releaseScreen");
        }
    }

    public void initScreenAlwaysOn() {
        boolean bSceenAlwaysOn = BNSettingManager.isAlwaysBright();
        if (bSceenAlwaysOn && !this.isAlwaysLight) {
            VDeviceAPI.setScreenAlwaysOn(bSceenAlwaysOn);
            this.isAlwaysLight = true;
            LogUtil.m15791e("wangyang", "LightNaviUp initScreenAlwaysOn");
        }
    }

    public void restoreScreenAlwaysOn() {
        VDeviceAPI.setScreenAlwaysOn(false);
        this.isAlwaysLight = false;
        LogUtil.m15791e("wangyang", "LightNaviUp restoreScreenAlwaysOn");
    }

    public void unInit() {
        releaseScreen();
        mInstance = null;
        this.mPowerManager = null;
        this.mWakeLock = null;
        this.mKeyguardManager = null;
    }
}
