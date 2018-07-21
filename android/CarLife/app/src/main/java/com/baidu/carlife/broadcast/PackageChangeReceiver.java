package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;

public class PackageChangeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
    {
      paramContext = paramIntent.getDataString().substring(8);
      i.b("ouyang", "-----PACKAGE_ADDED----------" + paramContext);
      k.a(4014, 43990, paramContext);
    }
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
    {
      paramContext = paramIntent.getDataString().substring(8);
      i.b("ouyang", "-----PACKAGE_REMOVED----------" + paramContext);
      k.a(4014, 43991, paramContext);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/broadcast/PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */