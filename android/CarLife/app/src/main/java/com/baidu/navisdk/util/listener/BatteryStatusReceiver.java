package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

public class BatteryStatusReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "BatteryStatusReceiver";
  private static boolean isBatteryReceiverRegisted = false;
  public static boolean isCharging = false;
  public static int mBatteryLevel = 0;
  private static BatteryStatusReceiver sInstance = new BatteryStatusReceiver();
  
  public static void initBatteryStatusReceiver(Context paramContext)
  {
    IntentFilter localIntentFilter;
    if ((paramContext != null) && (!isBatteryReceiverRegisted))
    {
      localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.setPriority(Integer.MAX_VALUE);
    }
    try
    {
      paramContext.registerReceiver(sInstance, localIntentFilter);
      isBatteryReceiverRegisted = true;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void uninitBatteryStatusReceiver(Context paramContext)
  {
    if ((paramContext != null) && (isBatteryReceiverRegisted)) {
      isBatteryReceiverRegisted = false;
    }
    try
    {
      paramContext.unregisterReceiver(sInstance);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramContext = paramIntent.getAction();
    int i;
    int j;
    if ("android.intent.action.BATTERY_CHANGED".equals(paramContext))
    {
      i = paramIntent.getExtras().getInt("level");
      j = paramIntent.getExtras().getInt("scale", 100);
      if ((100 != j) && (j != 0)) {
        break label108;
      }
      mBatteryLevel = i;
      i = paramIntent.getIntExtra("status", 1);
      if (2 != i) {
        break label121;
      }
    }
    for (;;)
    {
      isCharging = bool;
      LogUtil.e("BatteryStatusReceiver", "battery action:" + paramContext + "status = " + i);
      return;
      label108:
      mBatteryLevel = i * 100 / j;
      break;
      label121:
      bool = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/BatteryStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */