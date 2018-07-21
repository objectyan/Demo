package com.baidu.mapframework.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.location.f;
import com.baidu.mapframework.common.config.GlobalConfig;

public class LocationStartListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (GlobalConfig.getInstance().isReceivePush())
    {
      paramIntent = new Intent(paramContext, f.class);
      paramContext.getApplicationContext().startService(paramIntent);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/location/LocationStartListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */