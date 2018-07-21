package com.baidu.carlife;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.support.multidex.b;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.i;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.commonlib.utils.ProcessUtil;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.AssetsDexInjectHelper;
import com.baidu.navi.ForegroundService;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comjni.engine.NAEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class BaiduNaviApplication
  extends Application
  implements Thread.UncaughtExceptionHandler
{
  private static final String TAG = "BaiduNaviApplication";
  private static BaiduNaviApplication mInstance = null;
  
  public static BaiduNaviApplication getInstance()
  {
    return mInstance;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    b.a(this);
    c.b(this);
    c.a(this);
  }
  
  public void exitApp(boolean paramBoolean)
  {
    if (!paramBoolean) {
      killProccess();
    }
    for (;;)
    {
      mInstance = null;
      DBManager.destroy();
      FavoritePois.destroyPoiFav();
      return;
      relaseBeforeExit();
      killProccess();
    }
  }
  
  public void killProccess()
  {
    i.b("jason", "killProcess");
    VDeviceAPI.setScreenAlwaysOn(false);
    Process.killProcess(Process.myPid());
  }
  
  public void onCreate()
  {
    super.onCreate();
    i.b("BaiduNaviApplication", "onCreate");
    mInstance = this;
    com.baidu.carlife.core.a.a(this);
    c.c();
    StorageSettings.getInstance().initialize(this);
    c.d();
    NAEngine.startSocketProc();
    BNSettingManager.init(this);
    if (ProcessUtil.isMainProcess(this)) {
      MapViewFactory.getInstance().preCreateMapViewInstance();
    }
    Thread.setDefaultUncaughtExceptionHandler(this);
    com.baidu.carlife.util.s.l = System.currentTimeMillis();
    com.baidu.carlife.wechat.a.a(this);
    GlobalConfig.getInstance().setmOpen3D(Boolean.valueOf(false));
    GlobalConfig.getInstance().setOpenOverlook(Boolean.valueOf(false));
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
  }
  
  public void onTerminate()
  {
    super.onTerminate();
  }
  
  public void relaseBeforeExit()
  {
    i.b("jason", "releaseBeforeExit after engine init success");
    if (AssetsDexInjectHelper.getInstance().isNaviInjectSuccess()) {
      NavMapAdapter.destroy();
    }
    c.e();
    AudioUtils.unInit();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    i.b(paramThrowable);
    paramThread = ActivityStack.getActivityStack().iterator();
    while (paramThread.hasNext())
    {
      paramThrowable = (Activity)((WeakReference)paramThread.next()).get();
      if (paramThrowable != null) {
        paramThrowable.moveTaskToBack(true);
      }
    }
    ForegroundService.stop(getApplicationContext());
    exitApp(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/BaiduNaviApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */