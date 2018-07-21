package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SDCardListener
  extends BroadcastReceiver
{
  public static final int MSG_SDCARD_BAD_REMOVAL = 3;
  public static final int MSG_SDCARD_EJECT = 4;
  public static final int MSG_SDCARD_MOUNTED = 1;
  public static final int MSG_SDCARD_REMOVED = 5;
  public static final int MSG_SDCARD_UNMOUNTED = 2;
  public static final int MSG_TYPE_SDCARD_CHANGE = 5565;
  private static final String TAG = "Common";
  private static final List<Handler> outboxHandlers = new ArrayList();
  
  private static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("Common", "dispatchMessage arg1=" + paramInt2 + "arg2=" + paramInt3);
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
    outboxHandlers.add(paramHandler);
  }
  
  public static void unRegisterMessageHandler(Handler paramHandler)
  {
    outboxHandlers.remove(paramHandler);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"android.intent.action.MEDIA_MOUNTED".equals(paramContext)) {
        break label19;
      }
    }
    label19:
    do
    {
      return;
      if ("android.intent.action.MEDIA_UNMOUNTED".equals(paramContext)) {
        return;
      }
      if ("android.intent.action.MEDIA_BAD_REMOVAL".equals(paramContext)) {
        return;
      }
      if ("android.intent.action.MEDIA_EJECT".equals(paramContext)) {
        return;
      }
    } while (!"android.intent.action.MEDIA_REMOVED".equals(paramContext));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/SDCardListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */