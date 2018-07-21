package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NetworkListener
  extends BroadcastReceiver
{
  public static final int MSG_TYPE_NET_WORK_CHANGE = 5555;
  private static final String TAG = "NetworkListener";
  private static Object mListenerLock = new Object();
  private static final List<Handler> outboxHandlers = new ArrayList();
  private boolean mIsCareMobileNetworkChange = false;
  
  public NetworkListener()
  {
    this.mIsCareMobileNetworkChange = false;
  }
  
  public NetworkListener(boolean paramBoolean)
  {
    this.mIsCareMobileNetworkChange = paramBoolean;
  }
  
  private static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("NetworkListener", "dispatchMessage arg1=" + paramInt2 + "arg2=" + paramInt3);
    synchronized (mListenerLock)
    {
      Object localObject2 = new ArrayList(outboxHandlers);
      if (!((List)localObject2).isEmpty())
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Handler)((Iterator)???).next();
          if (localObject2 != null)
          {
            localObject2 = Message.obtain((Handler)localObject2, paramInt1, paramInt2, paramInt3, null);
            if (localObject2 != null) {
              ((Message)localObject2).sendToTarget();
            }
          }
        }
      }
    }
  }
  
  public static void registerMessageHandler(Handler paramHandler)
  {
    Object localObject = mListenerLock;
    if (paramHandler != null) {}
    try
    {
      if (!outboxHandlers.contains(paramHandler)) {
        outboxHandlers.add(paramHandler);
      }
      return;
    }
    finally {}
  }
  
  public static void unRegisterMessageHandler(Handler paramHandler)
  {
    Object localObject = mListenerLock;
    if (paramHandler != null) {}
    try
    {
      if (outboxHandlers.contains(paramHandler)) {
        outboxHandlers.remove(paramHandler);
      }
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = null;
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      paramIntent = (Intent)localObject;
    }
    catch (Exception localException)
    {
      int i;
      boolean bool;
      int j;
      for (;;) {}
    }
    if (paramIntent != null)
    {
      i = paramIntent.getType();
      bool = paramIntent.isConnected();
      switch (i)
      {
      default: 
        i = 0;
        if (bool == true) {
          j = 1;
        }
        break;
      }
    }
    for (;;)
    {
      if ((i != NetworkUtils.mWifiState) || (this.mIsCareMobileNetworkChange)) {
        break label134;
      }
      NetworkUtils.mConnectState = j;
      return;
      i = 0;
      break;
      if (bool == true) {}
      for (i = 1;; i = 0) {
        break;
      }
      j = 0;
      continue;
      i = 0;
      j = 0;
    }
    label134:
    if ((i != NetworkUtils.mWifiState) || (j != NetworkUtils.mConnectState))
    {
      LogUtil.e("NetworkListener", "network TYPE=" + i + "CONNECT=" + NetworkUtils.mConnectState);
      NetworkUtils.mWifiState = i;
      NetworkUtils.mConnectState = j;
      dispatchMessage(5555, i, NetworkUtils.mConnectState);
    }
    NetworkUtils.mWifiState = i;
    NetworkUtils.mConnectState = j;
    if (-1 != NetworkUtils.mWifiState)
    {
      NetworkUtils.ChangeGprsConnect(paramContext);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/NetworkListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */