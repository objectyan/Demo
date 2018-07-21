package com.baidu.navisdk.lightnavi.viewhelp;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.vi.VDeviceAPI;

public class LightNaviScreenHelper
{
  private static volatile LightNaviScreenHelper mInstance;
  private boolean isAlwaysLight = false;
  private boolean isLight = false;
  private Context mContext;
  private KeyguardManager mKeyguardManager;
  private PowerManager mPowerManager;
  private PowerManager.WakeLock mWakeLock;
  
  private LightNaviScreenHelper(Context paramContext)
  {
    this.mPowerManager = ((PowerManager)paramContext.getSystemService("power"));
    this.mWakeLock = this.mPowerManager.newWakeLock(268435466, "lock");
    this.mKeyguardManager = ((KeyguardManager)paramContext.getSystemService("keyguard"));
  }
  
  public static LightNaviScreenHelper getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new LightNaviScreenHelper(paramContext);
    }
    return mInstance;
  }
  
  public void initScreenAlwaysOn()
  {
    boolean bool = BNSettingManager.isAlwaysBright();
    if ((bool) && (!this.isAlwaysLight))
    {
      VDeviceAPI.setScreenAlwaysOn(bool);
      this.isAlwaysLight = true;
      LogUtil.e("wangyang", "LightNaviUp initScreenAlwaysOn");
    }
  }
  
  public void lightScreen()
  {
    if ((this.mWakeLock != null) && (!this.isLight))
    {
      this.mWakeLock.acquire();
      this.isLight = true;
      this.mKeyguardManager.newKeyguardLock("unLock").disableKeyguard();
      LogUtil.e("wangyang", "mWakeLock lightScreen");
    }
  }
  
  public void releaseScreen()
  {
    if ((this.mWakeLock != null) && (this.mWakeLock.isHeld()) && (this.isLight))
    {
      this.mWakeLock.release();
      this.isLight = false;
      LogUtil.e("wangyang", "mWakeLock releaseScreen");
    }
  }
  
  public void restoreScreenAlwaysOn()
  {
    VDeviceAPI.setScreenAlwaysOn(false);
    this.isAlwaysLight = false;
    LogUtil.e("wangyang", "LightNaviUp restoreScreenAlwaysOn");
  }
  
  public void unInit()
  {
    releaseScreen();
    mInstance = null;
    this.mPowerManager = null;
    this.mWakeLock = null;
    this.mKeyguardManager = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/viewhelp/LightNaviScreenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */