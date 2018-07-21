package com.baidu.navisdk.util.listener;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlueToothListener
  extends BroadcastReceiver
{
  public static final int MSG_TYPE_BT_CHANGE = 10601;
  public static final int MSG_TYPE_BT_SWITCH_CHANGE = 10602;
  private static final String TAG = "BlueToothListener";
  private static BluetoothAdapter ba;
  public static String deviceName = "";
  public static boolean isBTConnect;
  private static final List<Handler> outboxHandlers;
  private static BlueToothListener sInstance = new BlueToothListener();
  public static boolean sIsOpenBTChannel;
  
  static
  {
    outboxHandlers = new ArrayList();
    isBTConnect = false;
    sIsOpenBTChannel = false;
  }
  
  public BlueToothListener()
  {
    ba = BluetoothAdapter.getDefaultAdapter();
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
  
  public static boolean isBlueConnect(Context paramContext)
  {
    try
    {
      if (ba == null) {
        isBTConnect = false;
      }
      for (;;)
      {
        return isBTConnect;
        if (ba.isEnabled())
        {
          i = ba.getProfileConnectionState(2);
          m = ba.getProfileConnectionState(1);
          k = ba.getProfileConnectionState(3);
          j = -1;
          n = 2;
          if (i != 2) {
            break;
          }
          j = i;
          i = 2;
          if (j != -1)
          {
            isBTConnect = true;
            ba.getProfileProxy(paramContext, new BluetoothProfile.ServiceListener()
            {
              public void onServiceConnected(int paramAnonymousInt, BluetoothProfile paramAnonymousBluetoothProfile)
              {
                LogUtil.e("BlueToothListener", "onServiceConnected");
                paramAnonymousBluetoothProfile = paramAnonymousBluetoothProfile.getConnectedDevices();
                if ((paramAnonymousBluetoothProfile != null) && (paramAnonymousBluetoothProfile.size() > 0))
                {
                  LogUtil.e("BlueToothListener", "connected devices not null");
                  paramAnonymousBluetoothProfile = paramAnonymousBluetoothProfile.iterator();
                  while (paramAnonymousBluetoothProfile.hasNext())
                  {
                    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramAnonymousBluetoothProfile.next();
                    if (localBluetoothDevice != null) {
                      BlueToothListener.deviceName = localBluetoothDevice.getName();
                    }
                  }
                  BlueToothListener.dispatchMessage(10601, 1, 2);
                  UserOPController.getInstance().add("3.r.1", BlueToothListener.deviceName, null, null);
                }
              }
              
              public void onServiceDisconnected(int paramAnonymousInt)
              {
                LogUtil.e("BlueToothListener", "onServiceDisconnected");
              }
            }, i);
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i;
        int m;
        int k;
        int j;
        int n;
        continue;
        if (m == 2)
        {
          j = m;
          i = 1;
        }
        else
        {
          i = n;
          if (k == 2)
          {
            j = k;
            i = 3;
          }
        }
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
      isBTConnect = false;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
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
      isBTConnect = false;
      paramContext.unregisterReceiver(sInstance);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    LogUtil.e("BlueToothListener", "onReceive action = " + paramContext);
    BluetoothDevice localBluetoothDevice;
    int i;
    if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramContext))
    {
      localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
      paramContext = "";
      if (localBluetoothDevice != null) {
        paramContext = localBluetoothDevice.getAddress();
      }
      LogUtil.e("BlueToothListener", "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED: remote addr = " + paramContext + "state = " + i);
      switch (i)
      {
      }
    }
    do
    {
      do
      {
        return;
        LogUtil.e("BlueToothListener", "BluetoothProfile is STATE_CONNECTED");
        if (localBluetoothDevice != null) {
          deviceName = localBluetoothDevice.getName();
        }
        UserOPController.getInstance().add("3.r.1", deviceName, null, null);
        isBTConnect = true;
        dispatchMessage(10601, 1, 0);
        return;
        LogUtil.e("BlueToothListener", "BluetoothProfile is STATE_CONNECTING");
        return;
        LogUtil.e("BlueToothListener", "BluetoothProfile is STATE_DISCONNECTED");
        isBTConnect = false;
        dispatchMessage(10601, 0, 0);
        RGMapModeViewController.getInstance().resetAudio();
        return;
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramContext))
        {
          i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
          LogUtil.e("BlueToothListener", "BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED: remote state = " + i);
          switch (i)
          {
          default: 
            return;
          case 0: 
            LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_DISCONNECTED");
            isBTConnect = false;
            return;
          case 2: 
            LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_CONNECTED");
            isBTConnect = true;
            return;
          }
          LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_CONNECTING");
          return;
        }
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext))
        {
          switch (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10))
          {
          default: 
            return;
          case 10: 
            LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_OFF");
            isBTConnect = false;
            dispatchMessage(10601, 0, 0);
            RGMapModeViewController.getInstance().resetAudio();
            return;
          case 12: 
            LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_ON");
            return;
          case 11: 
            LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_TURNING_ON");
            return;
          }
          LogUtil.e("BlueToothListener", "BluetoothAdapter is STATE_TURNING_OFF");
          return;
        }
      } while (!"android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramContext));
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
      LogUtil.e("BlueToothListener", "BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED BluetoothProfile.EXTRA_STATE state = " + i);
      switch (i)
      {
      default: 
        return;
      case 10: 
        LogUtil.e("BlueToothListener", "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_DISCONNECTED");
      }
    } while (AudioUtils.sIsPhoneUsing);
    dispatchMessage(10601, 2, 1);
    return;
    LogUtil.e("BlueToothListener", "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTED");
    return;
    LogUtil.e("BlueToothListener", "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTING");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/BlueToothListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */