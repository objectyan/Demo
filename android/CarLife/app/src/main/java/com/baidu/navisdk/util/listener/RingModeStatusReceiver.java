package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class RingModeStatusReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "RingModeStatusReceiver";
  private static boolean hasRegistered = false;
  private static ContentObserver mMuteChangeObserver = new ContentObserver(new Handler(Looper.getMainLooper()))
  {
    public boolean deliverSelfNotifications()
    {
      LogUtil.e("RingModeStatusReceiver", "deliverSelfNotifications");
      return super.deliverSelfNotifications();
    }
    
    public void onChange(boolean paramAnonymousBoolean)
    {
      super.onChange(paramAnonymousBoolean);
      LogUtil.e("RingModeStatusReceiver", "onChange selfChange:" + paramAnonymousBoolean);
    }
    
    public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
    {
      super.onChange(paramAnonymousBoolean, paramAnonymousUri);
      LogUtil.e("RingModeStatusReceiver", "onChange selfChange:" + paramAnonymousBoolean + ", Uri:" + paramAnonymousUri.toString());
      if (AudioUtils.getCurrentVolume(BNaviModuleManager.getContext()) > 0)
      {
        RGViewController.getInstance().updateLowVolumeView(false);
        return;
      }
      RGViewController.getInstance().updateLowVolumeView(true);
    }
  };
  private static RingModeStatusReceiver sInstance = new RingModeStatusReceiver();
  
  public static void initRingModeStatusReceiver(Context paramContext)
  {
    LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver");
    IntentFilter localIntentFilter;
    if ((paramContext != null) && (!hasRegistered))
    {
      localIntentFilter = new IntentFilter("android.media.RINGER_MODE_CHANGED");
      localIntentFilter.setPriority(Integer.MAX_VALUE);
    }
    try
    {
      paramContext.registerReceiver(sInstance, localIntentFilter);
      hasRegistered = true;
      if (PackageUtil.isSmartisanPhone()) {
        paramContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("volume_panel_mute_enable"), true, mMuteChangeObserver);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver cause :" + localException.getCause());
        LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver crash :" + localException.getMessage());
      }
    }
  }
  
  public static void uninitRingModeStatusReceiver(Context paramContext)
  {
    LogUtil.e("RingModeStatusReceiver", "uninitRingModeStatusReceiver");
    if ((paramContext != null) && (hasRegistered)) {
      hasRegistered = false;
    }
    try
    {
      paramContext.unregisterReceiver(sInstance);
      if (PackageUtil.isSmartisanPhone()) {
        paramContext.getContentResolver().unregisterContentObserver(mMuteChangeObserver);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("RingModeStatusReceiver", "uninitRingModeStatusReceiver crash :" + localException.getMessage());
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    LogUtil.e("RingModeStatusReceiver", "action:" + paramIntent);
    if (!"android.media.RINGER_MODE_CHANGED".equals(paramIntent)) {
      return;
    }
    if (AudioUtils.getCurrentVolume(paramContext) > 0)
    {
      RGViewController.getInstance().updateLowVolumeView(false);
      return;
    }
    RGViewController.getInstance().updateLowVolumeView(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/RingModeStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */