package com.baidu.carlife;

import android.app.Application;
import android.content.Context;
import android.support.multidex.b;
import com.baidu.carlife.core.a;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.common.util.StorageSettings;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.engine.NAEngine;

public class DemoApp
  extends Application
{
  private static Application a = null;
  
  public static Application a()
  {
    return a;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    b.a(this);
    f.a(true);
    c.b(this);
    c.a(this);
  }
  
  public void onCreate()
  {
    super.onCreate();
    a = this;
    a.a(this);
    c.c();
    StorageSettings.getInstance().initialize(this);
    c.d();
    NAEngine.startSocketProc();
    BNSettingManager.init(this);
    BNSettingManager.setShowJavaLog(true);
    BNSettingManager.setShowNativeLog(true);
    MapViewFactory.getInstance().preCreateMapViewInstance();
    BNSysLocationManager.getInstance().init(this);
    BNSysLocationManager.getInstance().startNaviLocate(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/DemoApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */