package com.baidu.baidunavis;

import com.baidu.baidumaps.common.a.b;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.platform.comapi.util.NetworkUtil;
import de.greenrobot.event.EventBus;

public class NavNetworkListener
{
  public static final int NetStatusInvalid = 0;
  public static final int NetStatusNoNet = 1;
  public static final int NetStatusWIFINet = 2;
  public static final int NetStatusWWANNet = 3;
  private static NavNetworkListener mInstance = null;
  
  public static NavNetworkListener getInstance()
  {
    if (mInstance == null) {
      mInstance = new NavNetworkListener();
    }
    return mInstance;
  }
  
  private void onEventMainThread(b paramb)
  {
    performNetworkTypeChange(paramb.a, paramb.b);
  }
  
  private void performNetworkTypeChange(final int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean == true) {
      i = 1;
    }
    NetworkUtils.mConnectState = i;
    LogUtil.e("Map", "NetworkUtils.mConnectState=" + NetworkUtils.mConnectState);
    i = 1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      try
      {
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("performNetworkTypeChange", null)new BNWorkerConfig
        {
          protected String execute()
          {
            if (BaiduNaviManager.sIsBaseEngineInitialized) {}
            try
            {
              BNaviEngineManager.getInstance().changeNaviStatisticsNetworkStatus(paramInt);
              return null;
            }
            catch (Throwable localThrowable)
            {
              for (;;) {}
            }
          }
        }, new BNWorkerConfig(100, 0));
        return;
      }
      catch (Throwable localThrowable)
      {
        LogUtil.e("NavNetworkListener", "error!");
      }
      paramInt = 2;
      NetworkUtils.mWifiState = 1;
    }
  }
  
  public void registNetworkTypeChangeEvent()
  {
    int i = 1;
    EventBus.getDefault().register(this);
    try
    {
      if (NetworkUtil.isNetworkAvailable(NavMapAdapter.getInstance().getBaiduMapApplicationInstance()) == true) {}
      for (;;)
      {
        NetworkUtils.mConnectState = i;
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void unregistNetworkTypeChangeEvent()
  {
    EventBus.getDefault().unregister(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/NavNetworkListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */