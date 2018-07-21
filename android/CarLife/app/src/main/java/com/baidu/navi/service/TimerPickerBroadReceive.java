package com.baidu.navi.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class TimerPickerBroadReceive
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.baidu.navi.alarm".equals(str))
    {
      int i = paramIntent.getIntExtra("id", -1);
      paramIntent = new Intent(paramContext, TimerPickerService.class);
      paramIntent.putExtra("action", str);
      paramIntent.putExtra("id", i);
      paramContext.startService(paramIntent);
    }
    do
    {
      return;
      if ("android.intent.action.BOOT_COMPLETED".equals(str))
      {
        paramIntent = new Intent(paramContext, TimerPickerService.class);
        paramIntent.putExtra("action", str);
        paramContext.startService(paramIntent);
        return;
      }
    } while ((!"com.baidu.navi.GPSHostStart.alarm".equals(str)) || (!BNSettingManager.getGPSHotStart()));
    paramIntent = new Intent(paramContext, TimerPickerService.class);
    paramIntent.putExtra("action", "com.baidu.navi.service.GPSAlarmService");
    paramContext.startService(paramIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/service/TimerPickerBroadReceive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */