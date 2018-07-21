package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;

public class ConnectServiceReceiver
  extends BroadcastReceiver
{
  private static final String a = "ConnectServiceReceiver";
  private static final String b = "com.baidu.carlife.connect.ConnectServiceStart";
  private static final String c = "com.baidu.carlife.connect.ConnectServiceStop";
  private Context d = null;
  private Handler e = null;
  
  public ConnectServiceReceiver(Context paramContext, Handler paramHandler)
  {
    this.d = paramContext;
    this.e = paramHandler;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.baidu.carlife.connect.ConnectServiceStart");
    localIntentFilter.addAction("com.baidu.carlife.connect.ConnectServiceStop");
    this.d.registerReceiver(this, localIntentFilter);
  }
  
  public void b()
  {
    this.d.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.e == null)
    {
      i.e("ConnectServiceReceiver", "mHandler is null");
      return;
    }
    paramContext = paramIntent.getAction();
    paramIntent = new Message();
    paramIntent.what = 1034;
    if (paramContext.equals("com.baidu.carlife.connect.ConnectServiceStart"))
    {
      i.b("ConnectServiceReceiver", "start connect service");
      paramIntent.arg1 = 1035;
    }
    for (;;)
    {
      this.e.sendMessage(paramIntent);
      return;
      if (paramContext.equals("com.baidu.carlife.connect.ConnectServiceStop"))
      {
        i.b("ConnectServiceReceiver", "stop connect service");
        paramIntent.arg1 = 1036;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/ConnectServiceReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */