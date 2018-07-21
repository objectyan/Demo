package com.baidu.navisdk.util.listener;

import android.content.Context;
import android.os.PowerManager;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Method;

public class ScreenObserver
{
  private static final String TAG = "ScreenObserver";
  private PowerManager mPowerManager;
  private Method mReflectScreenState;
  
  public ScreenObserver(Context paramContext)
  {
    try
    {
      this.mReflectScreenState = PowerManager.class.getMethod("isScreenOn", new Class[0]);
      this.mPowerManager = ((PowerManager)paramContext.getSystemService("power"));
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
      LogUtil.e("ScreenObserver", "No such method " + paramContext);
    }
  }
  
  public boolean isScreenOn()
  {
    if (this.mReflectScreenState == null) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)this.mReflectScreenState.invoke(this.mPowerManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/ScreenObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */