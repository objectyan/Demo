package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.PackageUtil;

public class XDUtils
{
  public static boolean isAsrCanWork()
  {
    try
    {
      boolean bool = BNSettingManager.isShowNaviAsr();
      if (BNavigator.getInstance().getContext() != null)
      {
        int i = BNavigator.getInstance().getContext().getPackageManager().checkPermission("android.permission.RECORD_AUDIO", PackageUtil.getPackageName());
        if (i == 0) {}
        for (i = 1; (bool) && (i != 0); i = 0) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public static boolean isInOnLineMode()
  {
    return (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 1) || (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 3);
  }
  
  public static void makeParkingSpeak(String paramString)
  {
    if (BNavigator.getInstance().isNaviBegin()) {
      TTSPlayerControl.playTTS(paramString, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/asr/xdvoice/XDUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */