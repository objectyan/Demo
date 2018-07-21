package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.carlife.CarlifeActivity;

public class StartActivityBroadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (TextUtils.equals("com.baidu.carlife.Action.StartActivityBroadReceiver", paramIntent))
    {
      paramIntent = new Intent("com.baidu.carlife.Action.CarlifePlatform");
      paramIntent.setFlags(268435456);
      paramContext.startActivity(paramIntent);
      return;
    }
    Intent localIntent = new Intent(paramContext, CarlifeActivity.class);
    localIntent.setFlags(268435456);
    localIntent.setAction(paramIntent);
    paramContext.startActivity(localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/broadcast/StartActivityBroadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */