package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class LocalMapManager
{
  private static volatile LocalMapManager instance;
  private AppBaseMap baseMap = null;
  private LocalMapHandler handler = null;
  
  public static LocalMapManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new LocalMapManager();
      }
      return instance;
    }
    finally {}
  }
  
  private List<LocalMapResource> toResources(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).optJSONArray("dataset");
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          localArrayList.add(LocalMapResource.fromJson(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public int autoDownloadRoadNetworkViaWifi(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return 0;
    }
    return this.baseMap.OnWifiRecordAdd(paramInt);
  }
  
  public boolean delete(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return false;
    }
    return this.baseMap.OnRecordRemove(paramInt, false);
  }
  
  public boolean deleteAll()
  {
    if (this.baseMap == null) {
      return false;
    }
    return this.baseMap.OnRecordRemove(0, true);
  }
  
  public void destroy()
  {
    if (this.handler != null)
    {
      MessageProxy.unRegisterMessageHandler(65289, this.handler);
      this.handler = null;
    }
  }
  
  public List<LocalMapResource> getAllCities()
  {
    if (this.baseMap == null) {
      return null;
    }
    return toResources(this.baseMap.OnSchcityGet(""));
  }
  
  public List<LocalMapResource> getCitiesByName(String paramString)
  {
    if ((this.baseMap == null) || (paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return toResources(this.baseMap.OnSchcityGet(paramString));
  }
  
  public LocalMapResource getCityById(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return null;
    }
    return LocalMapResource.fromJson(this.baseMap.OnRecordGetAt(paramInt));
  }
  
  public List<LocalMapResource> getHotCities()
  {
    if (this.baseMap == null) {
      return null;
    }
    return toResources(this.baseMap.OnHotcityGet());
  }
  
  public List<LocalMapResource> getUserResources()
  {
    if (this.baseMap == null) {
      return null;
    }
    return toResources(this.baseMap.OnRecordGetAll());
  }
  
  public boolean importMap(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.baseMap == null) {
      return false;
    }
    return this.baseMap.OnRecordImport(paramBoolean1, paramBoolean2);
  }
  
  public boolean init(MapController paramMapController)
  {
    if (paramMapController == null) {}
    do
    {
      return false;
      if (this.handler == null)
      {
        this.handler = new LocalMapHandler();
        MessageProxy.registerMessageHandler(65289, this.handler);
      }
      this.baseMap = paramMapController.getBaseMap();
    } while (this.baseMap == null);
    this.baseMap.OnUsrcityMsgInterval(1500);
    return true;
  }
  
  public boolean pause(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return false;
    }
    return this.baseMap.OnRecordSuspend(paramInt, false, 0);
  }
  
  public boolean pauseAll(int paramInt)
  {
    if (this.baseMap == null) {
      return false;
    }
    return this.baseMap.OnRecordSuspend(0, true, paramInt);
  }
  
  public void registerListener(LocalMapListener paramLocalMapListener)
  {
    if (this.handler != null) {
      this.handler.registListener(paramLocalMapListener);
    }
  }
  
  public void removeListener(LocalMapListener paramLocalMapListener)
  {
    if (this.handler != null) {
      this.handler.removeListener(paramLocalMapListener);
    }
  }
  
  public boolean resume(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return false;
    }
    return this.baseMap.OnRecordStart(paramInt, false, 0);
  }
  
  public boolean resumeAll(int paramInt)
  {
    if (this.baseMap == null) {
      return false;
    }
    return this.baseMap.OnRecordStart(0, true, paramInt);
  }
  
  public boolean start(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return false;
    }
    return this.baseMap.OnRecordAdd(paramInt);
  }
  
  public boolean update(int paramInt)
  {
    if ((this.baseMap == null) || (paramInt < 0)) {
      return false;
    }
    return this.baseMap.OnRecordReload(paramInt, false);
  }
  
  public boolean updateAll()
  {
    if (this.baseMap == null) {
      return false;
    }
    return this.baseMap.OnRecordReload(0, true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/LocalMapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */