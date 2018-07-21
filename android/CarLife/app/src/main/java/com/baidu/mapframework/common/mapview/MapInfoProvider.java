package com.baidu.mapframework.common.mapview;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapStatus.GeoBound;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapInfoProvider
  implements MapInfo
{
  private static final MapInfo a = new MapInfoProvider();
  
  public static MapInfo getMapInfo()
  {
    return a;
  }
  
  public MapBound getMapBound()
  {
    MapBound localMapBound = new MapBound();
    if (getMapStatus() != null)
    {
      localMapBound.setLeftBottomPt((int)getMapStatus().geoRound.left, (int)getMapStatus().geoRound.bottom);
      localMapBound.setRightTopPt((int)getMapStatus().geoRound.right, (int)getMapStatus().geoRound.top);
    }
    return localMapBound;
  }
  
  public GeoPoint getMapCenter()
  {
    return MapViewFactory.getInstance().getMapView().getMapCenter();
  }
  
  public int getMapCenterCity()
  {
    int i = GlobalConfig.getInstance().getRoamCityId();
    if (i > 0) {
      return i;
    }
    Object localObject = MapViewFactory.getInstance();
    if (localObject == null) {
      return 1;
    }
    localObject = ((MapViewFactory)localObject).getMapView();
    if (localObject == null) {
      return 1;
    }
    localObject = ((MapGLSurfaceView)localObject).getController();
    if (localObject == null) {
      return 1;
    }
    localObject = ((MapController)localObject).getBaseMap();
    if (localObject != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("querytype", "map");
      ((AppBaseMap)localObject).GetVMPMapCityInfo(localBundle);
      return localBundle.getInt("code");
    }
    return 1;
  }
  
  public String getMapCenterCityName()
  {
    return GlobalConfig.getInstance().getRoamCityName();
  }
  
  public int getMapCenterCityType()
  {
    return GlobalConfig.getInstance().getRoamCityType();
  }
  
  public float getMapLevel()
  {
    return getMapStatus().level;
  }
  
  public MapStatus getMapStatus()
  {
    return MapViewFactory.getInstance().getMapView().getMapStatus();
  }
  
  public int[] getPoiCitys(double paramDouble1, double paramDouble2)
  {
    Object localObject1 = MapViewFactory.getInstance();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return (int[])localObject1;
      localObject1 = ((MapViewFactory)localObject1).getMapView();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((MapGLSurfaceView)localObject1).getController();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((MapController)localObject1).getBaseMap();
      if (localObject1 != null)
      {
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("querytype", "map");
        ((Bundle)localObject2).putDouble("x", paramDouble1);
        ((Bundle)localObject2).putDouble("y", paramDouble2);
        ((AppBaseMap)localObject1).GetVMPMapCityInfo((Bundle)localObject2);
        localObject1 = ((Bundle)localObject2).getString("cities");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        try
        {
          JSONArray localJSONArray = new JSONObject((String)localObject1).getJSONArray("cities");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localObject2 = new int[localJSONArray.length()];
            int i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= localJSONArray.length()) {
                break;
              }
              if (localJSONArray.getJSONObject(i) != null) {
                localObject2[i] = localJSONArray.getJSONObject(i).optInt("code");
              }
              i += 1;
            }
            return null;
          }
        }
        catch (JSONException localJSONException)
        {
          return null;
        }
      }
    }
    return null;
  }
  
  public float getZoomToBound(MapBound paramMapBound)
  {
    return MapViewFactory.getInstance().getMapView().getZoomToBound(paramMapBound);
  }
  
  public float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    return MapViewFactory.getInstance().getMapView().getZoomToBound(paramMapBound, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/mapview/MapInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */