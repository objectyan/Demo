package com.baidu.platform.comapi.dataengine;

import android.os.Bundle;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.dataengine.NADataEngine;

public class MapDataEngine
{
  private static MapDataEngine b = null;
  private static MainLooperHandler d = null;
  private NADataEngine a = null;
  private a c = null;
  
  public static void destroy()
  {
    if (b != null)
    {
      if (b.a != null)
      {
        b.a.release();
        b.a = null;
        MessageProxy.unRegisterMessageHandler(65289, d);
        d = null;
        b.c = null;
      }
      b = null;
    }
  }
  
  public static MapDataEngine getInstance()
  {
    if (b == null)
    {
      b = new MapDataEngine();
      if (!b.a())
      {
        b = null;
        return null;
      }
    }
    return b;
  }
  
  boolean a()
  {
    if (this.a == null)
    {
      this.a = new NADataEngine();
      if (this.a.create() == 0)
      {
        this.a = null;
        return false;
      }
      this.c = new a();
      d = new MapDataEngine.1(this, Module.MAP_ENGINE, ScheduleConfig.forData());
      MessageProxy.registerMessageHandler(65289, d);
    }
    return true;
  }
  
  public void cancelThumbImageRequest()
  {
    this.a.cancelThumbImageRequest();
  }
  
  public String getCurrentStreetId()
  {
    return this.a.getCurrentStreetId();
  }
  
  public String getCurrentStreetInfo(Bundle paramBundle)
  {
    return this.a.getCurrentStreetInfo(paramBundle);
  }
  
  public boolean getHotMapCityInfo()
  {
    Bundle localBundle = new Bundle();
    return this.a.getHotMapCityInfo(localBundle);
  }
  
  public boolean getStreetCityInfo()
  {
    Bundle localBundle = new Bundle();
    return this.a.getStreetCityInfo(localBundle);
  }
  
  public boolean queryThumbImage(String paramString)
  {
    return this.a.queryThumbImage(paramString);
  }
  
  public void registDataEngineListener(MapDataEngineListener paramMapDataEngineListener)
  {
    this.c.a(paramMapDataEngineListener);
  }
  
  public void removeDataEngineListener(MapDataEngineListener paramMapDataEngineListener)
  {
    this.c.b(paramMapDataEngineListener);
  }
  
  public void setStreetPOIUID(String paramString)
  {
    this.a.setStreetPOIUID(paramString);
  }
  
  public boolean setStreetSwitchByUID(String paramString1, String paramString2)
  {
    return this.a.streetSwitchByUID(paramString1, paramString2);
  }
  
  public boolean setStreetSwitchToIID(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.a.streetSwitchToIID(paramString1, paramString2, paramBoolean);
  }
  
  public boolean setStreetSwitchToId(String paramString, int paramInt)
  {
    return this.a.streetSwitchToId(paramString, paramInt);
  }
  
  public boolean setStreetSwitchToId(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    return this.a.streetSwitchToId(paramString1, paramString2, paramLong1, paramLong2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/dataengine/MapDataEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */