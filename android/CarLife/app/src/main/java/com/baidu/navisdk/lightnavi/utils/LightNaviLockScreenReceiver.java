package com.baidu.navisdk.lightnavi.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Window;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.Iterator;
import java.util.List;

public class LightNaviLockScreenReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "LightNaviLockScreenReceiver";
  private static Activity mActivity;
  private static Context mContext;
  public static boolean mIsLock = false;
  private static LightNaviLockScreenReceiver sInstance = new LightNaviLockScreenReceiver();
  private static boolean sLockScreenReceiverRegisted = false;
  
  private String getCurrentPackagename(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.importance == 100) {
          return localRunningAppProcessInfo.processName;
        }
      }
    }
    return "com.baidu.BaiduMap";
  }
  
  public static void initLockScreenReceiver(Context paramContext, Activity paramActivity)
  {
    if (paramContext == null) {
      return;
    }
    mContext = paramContext;
    mActivity = paramActivity;
    paramContext = new IntentFilter("android.intent.action.SCREEN_ON");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    paramContext.setPriority(Integer.MAX_VALUE);
    try
    {
      mContext.registerReceiver(sInstance, paramContext);
      sLockScreenReceiverRegisted = true;
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("wy", "[LightNaviLockScreenReceiver]initLockScreenReceiver->" + paramContext.toString());
    }
  }
  
  public static void uninitLockScreenReceiver()
  {
    try
    {
      if ((mContext != null) && (sLockScreenReceiverRegisted))
      {
        sLockScreenReceiverRegisted = false;
        mContext.unregisterReceiver(sInstance);
      }
      mActivity = null;
      mContext = null;
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("wy", "[LightNaviLockScreenReceiver]uninitLockScreenReceiver->" + localException.toString());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      UserOPController.getInstance().add("4.6", "", null, null);
      localObject = getCurrentPackagename(paramContext);
      BNLightNaviManager.getInstance().setPackageName((String)localObject);
      LogUtil.e("wangyang", "LightNaviLockScreenReceiver " + (String)localObject);
      BNLightNaviManager.getInstance().setType(1);
      localObject = new Intent("android.intent.baidunavi.slight.lock");
      ((Intent)localObject).addFlags(268435456);
    }
    try
    {
      paramContext.startActivity((Intent)localObject);
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        UserOPController.getInstance().add("4.e");
        BNLightNaviManager.getInstance().setType(1);
      }
      if (mIsLock) {}
    }
    catch (Exception paramContext)
    {
      try
      {
        if (mActivity != null) {
          mActivity.getWindow().addFlags(525312);
        }
        mIsLock = true;
        return;
        paramContext = paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/utils/LightNaviLockScreenReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */