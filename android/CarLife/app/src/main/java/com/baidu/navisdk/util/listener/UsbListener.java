package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsbListener
  extends BroadcastReceiver
{
  public static final int MSG_TYPE_USB_CHANGE = 10501;
  private static final String TAG = "UsbListener";
  private static final String USB_STATE_ACTION = "android.hardware.usb.action.USB_STATE";
  public static boolean isUSBConnect = false;
  private static final List<Handler> outboxHandlers;
  private static UsbListener sInstance = new UsbListener();
  
  static
  {
    outboxHandlers = new ArrayList();
  }
  
  private static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!outboxHandlers.isEmpty())
    {
      Iterator localIterator = outboxHandlers.iterator();
      while (localIterator.hasNext()) {
        Message.obtain((Handler)localIterator.next(), paramInt1, paramInt2, paramInt3, null).sendToTarget();
      }
    }
  }
  
  public static void registerMessageHandler(Handler paramHandler)
  {
    if ((paramHandler != null) && (!outboxHandlers.contains(paramHandler))) {
      outboxHandlers.add(paramHandler);
    }
  }
  
  public static void registerReceiver(Context paramContext)
  {
    try
    {
      isUSBConnect = false;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.hardware.usb.action.USB_STATE");
      paramContext.registerReceiver(sInstance, localIntentFilter);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void unRegisterMessageHandler(Handler paramHandler)
  {
    if ((paramHandler != null) && (outboxHandlers.contains(paramHandler))) {
      outboxHandlers.remove(paramHandler);
    }
  }
  
  public static void unregisterReceiver(Context paramContext)
  {
    try
    {
      isUSBConnect = false;
      paramContext.unregisterReceiver(sInstance);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent.getAction().equals("android.hardware.usb.action.USB_STATE"))
    {
      if (!paramIntent.getExtras().getBoolean("connected")) {
        break label71;
      }
      UserOPController.getInstance().add("3.r.2");
      isUSBConnect = true;
      i = 1;
      dispatchMessage(10501, 1, 0);
    }
    for (;;)
    {
      LogUtil.e("UsbListener", "usb connect is changed arg1 " + i);
      return;
      label71:
      isUSBConnect = false;
      i = 0;
      dispatchMessage(10501, 0, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/UsbListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */