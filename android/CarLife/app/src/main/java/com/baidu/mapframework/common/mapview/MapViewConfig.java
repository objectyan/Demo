package com.baidu.mapframework.common.mapview;

import android.text.TextUtils;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.config.Preferences;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONObject;

public final class MapViewConfig
{
  private static boolean b = false;
  private Preferences a = Preferences.build(c.f(), "mapview_conf");
  private PositionStatus c;
  private String d = "";
  
  public static MapViewConfig getInstance()
  {
    return Holder.a;
  }
  
  public int getCenterPtX()
  {
    return this.a.getInt("map_centerptx", 12958162);
  }
  
  public int getCenterPtY()
  {
    return this.a.getInt("map_centerpty", 4825907);
  }
  
  public int getCenterPtZ()
  {
    return this.a.getInt("map_centerptz", 0);
  }
  
  public int getGestureIntervalTime()
  {
    return this.a.getInt("gesture_interval_time", 0);
  }
  
  public long getGestureStartTime()
  {
    return this.a.getLong("gesture_start_time", 0L).longValue();
  }
  
  public boolean getIndoorSharePre(String paramString)
  {
    return this.a.getBoolean(paramString, false);
  }
  
  public float getLevel()
  {
    return this.a.getFloat("map_level", 12.0F);
  }
  
  public MapMode getMapMode()
  {
    return MapMode.valueOf(this.a.getString("map_mode", MapMode._2D.name()));
  }
  
  public float getOverlook()
  {
    return this.a.getFloat("map_overlook", 0.0F);
  }
  
  public PositionStatus getPositionStatus()
  {
    if ((!b) || (this.c == null))
    {
      setPositionStatus(PositionStatus.NORMAL);
      return PositionStatus.NORMAL;
    }
    return this.c;
  }
  
  public boolean getPredictTrafficGuideOpen()
  {
    return this.a.getBoolean("predict_traffic_guide_open", false);
  }
  
  public boolean getPredictTrafficTipOpen()
  {
    return this.a.getBoolean("predict_traffic_tip_open", false);
  }
  
  public boolean getPredictTrafficUserOpen()
  {
    return this.a.getBoolean("predict_traffic_user_open", false);
  }
  
  public int getPredictType()
  {
    return this.a.getInt("predict_type", 0);
  }
  
  public float getRotation()
  {
    return this.a.getFloat("map_rotation", 0.0F);
  }
  
  public boolean getTrafficOpenWhenForeground()
  {
    return this.a.getBoolean("is_traffic_fgd", false);
  }
  
  public void initTraffic(int paramInt)
  {
    String str;
    if ((!this.a.contains("is_traffic")) || (shouldTurnOnTraffic()))
    {
      setShouldTurnOnTraffic(false);
      str = MapViewFactory.getInstance().getMapView().getController().getBaseMap().GetCityInfoByID(paramInt);
    }
    try
    {
      if (new JSONObject(str).getInt("its") == 1) {
        setTraffic(true);
      }
      return;
    }
    catch (Exception localException)
    {
      f.a(getClass().getName(), localException.getMessage(), localException);
    }
  }
  
  public boolean isPredictCity(String paramString)
  {
    Object localObject = this.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return false;
      localObject = ((String)localObject).split(",");
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean isSupportPredict()
  {
    return isPredictCity(String.valueOf(GlobalConfig.getInstance().getLastLocationCityCode()));
  }
  
  public boolean isTraffic()
  {
    return this.a.getBoolean("is_traffic", false);
  }
  
  public void saveGestureIntervalTime(int paramInt)
  {
    this.a.putInt("gesture_interval_time", paramInt);
  }
  
  public void saveGestureStartTime(long paramLong)
  {
    this.a.putLong("gesture_start_time", paramLong);
  }
  
  public void saveMapStatus(MapStatus paramMapStatus)
  {
    if (paramMapStatus != null)
    {
      this.a.putFloat("map_level", paramMapStatus.level);
      this.a.putFloat("map_rotation", paramMapStatus.rotation);
      this.a.putFloat("map_overlook", paramMapStatus.overlooking);
      this.a.putInt("map_centerptx", (int)paramMapStatus.centerPtX);
      this.a.putInt("map_centerpty", (int)paramMapStatus.centerPtY);
      this.a.putInt("map_centerptz", (int)paramMapStatus.centerPtZ);
    }
  }
  
  public void setCenterPtX(int paramInt)
  {
    this.a.putInt("map_centerptx", paramInt);
  }
  
  public void setCenterPtY(int paramInt)
  {
    this.a.putInt("map_centerpty", paramInt);
  }
  
  public void setCenterPtZ(int paramInt)
  {
    this.a.putInt("map_centerptz", paramInt);
  }
  
  public void setIndoorSharePre(String paramString, boolean paramBoolean)
  {
    this.a.putBoolean(paramString, paramBoolean);
  }
  
  public void setLevel(float paramFloat)
  {
    this.a.putFloat("map_level", paramFloat);
  }
  
  public void setMapMode(MapMode paramMapMode)
  {
    this.a.putString("map_mode", paramMapMode.name());
  }
  
  public void setOverlook(float paramFloat)
  {
    this.a.putFloat("map_overlook", paramFloat);
  }
  
  public void setPositionStatus(PositionStatus paramPositionStatus)
  {
    boolean bool = true;
    b = true;
    if (paramPositionStatus == PositionStatus.COMPASS) {}
    for (;;)
    {
      MapController.isCompass = bool;
      this.c = paramPositionStatus;
      return;
      bool = false;
    }
  }
  
  public void setPredictCitys(String paramString)
  {
    this.d = paramString;
  }
  
  public void setPredictTrafficGuideOpen(boolean paramBoolean)
  {
    this.a.putBoolean("predict_traffic_guide_open", paramBoolean);
  }
  
  public void setPredictTrafficTipOpen(boolean paramBoolean)
  {
    this.a.putBoolean("predict_traffic_tip_open", paramBoolean);
  }
  
  public void setPredictTrafficUserOpen(boolean paramBoolean)
  {
    this.a.putBoolean("predict_traffic_user_open", paramBoolean);
  }
  
  public void setPredictType(int paramInt)
  {
    this.a.putInt("predict_type", paramInt);
  }
  
  public void setRotation(float paramFloat)
  {
    this.a.putFloat("map_rotation", paramFloat);
  }
  
  public void setShouldTurnOnTraffic(boolean paramBoolean)
  {
    this.a.putBoolean("should_open_traffic", paramBoolean);
  }
  
  public void setTraffic(boolean paramBoolean)
  {
    this.a.putBoolean("is_traffic", paramBoolean);
  }
  
  public void setTrafficOpenWhenForeground(boolean paramBoolean)
  {
    this.a.putBoolean("is_traffic_fgd", paramBoolean);
  }
  
  public boolean shouldTurnOnTraffic()
  {
    return this.a.getBoolean("should_open_traffic", false);
  }
  
  private static class Holder
  {
    static final MapViewConfig a = new MapViewConfig(null);
  }
  
  public static enum MapMode
  {
    private MapMode() {}
  }
  
  public static enum PositionStatus
  {
    static
    {
      FOLLOWING = new PositionStatus("FOLLOWING", 1);
    }
    
    private PositionStatus() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/mapview/MapViewConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */