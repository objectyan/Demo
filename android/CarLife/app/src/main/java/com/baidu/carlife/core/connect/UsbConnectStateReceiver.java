package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;

public class UsbConnectStateReceiver
  extends BroadcastReceiver
{
  private static final String a = "UsbConnectStateReceiver";
  private static final String b = "android.hardware.usb.action.USB_STATE";
  private Context c = null;
  private Handler d = null;
  private boolean e = false;
  
  public UsbConnectStateReceiver(Context paramContext, Handler paramHandler)
  {
    this.c = paramContext;
    this.d = paramHandler;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.hardware.usb.action.USB_STATE");
    this.c.registerReceiver(this, localIntentFilter);
  }
  
  public void b()
  {
    this.c.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.d == null) {
      i.e("UsbConnectStateReceiver", "mHandler is null");
    }
    Message localMessage;
    do
    {
      return;
      paramContext = paramIntent.getAction();
      localMessage = new Message();
      localMessage.what = 1031;
    } while (!paramContext.equals("android.hardware.usb.action.USB_STATE"));
    if (paramIntent.getExtras().getBoolean("connected")) {
      i.b("UsbConnectStateReceiver", "usb connect is changed: connected");
    }
    for (localMessage.arg1 = 1032;; localMessage.arg1 = 1033)
    {
      this.d.sendMessage(localMessage);
      return;
      i.b("UsbConnectStateReceiver", "usb connect is changed: disconnected");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/UsbConnectStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */