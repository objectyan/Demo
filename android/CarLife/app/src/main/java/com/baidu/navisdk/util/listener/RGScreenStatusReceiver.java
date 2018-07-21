package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGScreenStatusReceiver
  extends BroadcastReceiver
{
  private static final String TAG = RGScreenStatusReceiver.class.getSimpleName();
  private static Context sContext;
  private static RGScreenStatusReceiver sInstance = new RGScreenStatusReceiver();
  private static boolean sLockScreenReceiverRegisted = false;
  
  public static void initScreenStatusReceiver(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    sContext = paramContext;
    paramContext = new IntentFilter("android.intent.action.SCREEN_ON");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    paramContext.addAction("android.intent.action.USER_PRESENT");
    paramContext.setPriority(Integer.MAX_VALUE);
    try
    {
      sContext.registerReceiver(sInstance, paramContext);
      sLockScreenReceiverRegisted = true;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void uninitScreenStatusReceiver()
  {
    try
    {
      if ((sContext != null) && (sLockScreenReceiverRegisted))
      {
        sLockScreenReceiverRegisted = false;
        sContext.unregisterReceiver(sInstance);
      }
      sContext = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      LogUtil.e(TAG, "onReceive ACTION_SCREEN_ON");
      UserOPController.getInstance().add("3.w.2", "1", null, null);
    }
    do
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        LogUtil.e(TAG, "onReceive ACTION_SCREEN_OFF");
        UserOPController.getInstance().add("3.w.2", "2", null, null);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.USER_PRESENT"));
    LogUtil.e(TAG, "onReceive ACTION_USER_PRESENT");
    UserOPController.getInstance().add("3.w.2", "3", null, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/RGScreenStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */