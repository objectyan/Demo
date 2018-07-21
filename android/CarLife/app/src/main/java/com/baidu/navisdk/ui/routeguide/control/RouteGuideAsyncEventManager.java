package com.baidu.navisdk.ui.routeguide.control;

import android.content.Context;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.statistic.CpuStat;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviMergeStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;

public class RouteGuideAsyncEventManager
  extends CommonHandlerThread.Callback
{
  private static RouteGuideAsyncEventManager sInstance = null;
  
  public static void init()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new RouteGuideAsyncEventManager();
        }
        CommonHandlerThread.getInstance().registerCallback(sInstance);
        return;
      }
      finally {}
    }
  }
  
  public static void uninit()
  {
    if (sInstance != null) {
      CommonHandlerThread.getInstance().unregisterCallback(sInstance);
    }
    sInstance = null;
  }
  
  public void careAbouts()
  {
    careAbout(100);
    careAbout(101);
    careAbout(200);
    careAbout(201);
    careAbout(30);
    careAbout(31);
    careAbout(250);
    careAbout(302);
  }
  
  public void execute(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 30: 
      CpuStat.getInstance().startProfile();
      return;
    case 31: 
      CpuStat.getInstance().endProfile();
      return;
    case 100: 
      NaviStatItem.getInstance().startStat();
      return;
    case 101: 
      NaviStatItem.getInstance().onEvent();
      return;
    case 200: 
      NaviIPOStatItem.getInstance().startStat();
      return;
    case 201: 
      NaviIPOStatItem.getInstance().onEvent();
      return;
    case 250: 
      NaviMergeStatItem.getInstance().onEvent();
      return;
    }
    BNRecoverNaviHelper.getInstance().setKilledTime(BNaviModuleManager.getContext().getApplicationContext(), System.currentTimeMillis() / 1000L);
    CommonHandlerThread.getInstance().sendMessage(302, 0, 0, null, 60000L);
  }
  
  public String getName()
  {
    return "RouteGuideAsyncEventManager";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RouteGuideAsyncEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */