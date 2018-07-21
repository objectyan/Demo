package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.base.BNObserver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class NMapControlProxy
{
  private static volatile NMapControlProxy mInstance;
  
  public static void destory()
  {
    if (mInstance != null) {}
    try
    {
      if (mInstance != null) {
        mInstance.dispose();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  private void dispose() {}
  
  public static NMapControlProxy getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new NMapControlProxy();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static int getScaleDis(int paramInt)
  {
    return MapController.getScaleDis(paramInt);
  }
  
  public boolean UpdataBaseLayers()
  {
    return BNMapController.getInstance().UpdataBaseLayers();
  }
  
  public void addMapObserver(BNObserver paramBNObserver)
  {
    BNMapController.getInstance().addObserver(paramBNObserver);
  }
  
  public void deleteAllObserver()
  {
    BNMapController.getInstance().deleteAllObserver();
  }
  
  public void deleteMapObserver(BNObserver paramBNObserver)
  {
    BNMapController.getInstance().deleteObserver(paramBNObserver);
  }
  
  public void enableTouchEventLookover(boolean paramBoolean)
  {
    BNMapController.getInstance().enableTouchEventLookover(paramBoolean);
  }
  
  public GeoPoint getGeoPosByScreenPos(int paramInt1, int paramInt2)
  {
    return BNMapController.getInstance().getGeoPosByScreenPos(paramInt1, paramInt2);
  }
  
  public int getLayerMode()
  {
    return BNMapController.getInstance().getLayerMode();
  }
  
  public MapStatus getMapStatus()
  {
    return BNMapController.getInstance().getMapStatus();
  }
  
  public Point getScreenPosByGeoPos(GeoPoint paramGeoPoint)
  {
    return BNMapController.getInstance().getScreenPosByGeoPos(paramGeoPoint);
  }
  
  public int getScreenWidth()
  {
    return BNMapController.getInstance().getScreenWidth();
  }
  
  public int getZoomLevel()
  {
    return BNMapController.getInstance().getZoomLevel();
  }
  
  public double getZoomUnitsInMeter()
  {
    return BNMapController.getInstance().getZoomUnitsInMeter();
  }
  
  public void setDrawHouse(boolean paramBoolean1, boolean paramBoolean2)
  {
    BNMapController.getInstance().setDrawHouse(paramBoolean1, paramBoolean2);
  }
  
  public void setLayerMode(int paramInt)
  {
    BNMapController.getInstance().setLayerMode(paramInt);
  }
  
  public void setLevel(float paramFloat)
  {
    BNMapController.getInstance().setLevel(paramFloat);
  }
  
  public void setMapStatus(MapStatus paramMapStatus, MapController.AnimationType paramAnimationType)
  {
    BNMapController.getInstance().setMapStatus(paramMapStatus, paramAnimationType);
  }
  
  public void setMapStatus(MapStatus paramMapStatus, MapController.AnimationType paramAnimationType, int paramInt)
  {
    BNMapController.getInstance().setMapStatus(paramMapStatus, paramAnimationType, paramInt);
  }
  
  public void setNaviCarPos()
  {
    MapController localMapController = BNMapController.getInstance().getMapController();
    if (localMapController != null) {
      localMapController.setNaviCarPos();
    }
  }
  
  public boolean showLayer(int paramInt, boolean paramBoolean)
  {
    return BNMapController.getInstance().showLayer(paramInt, paramBoolean);
  }
  
  public void showTrafficMap(boolean paramBoolean)
  {
    BNMapController.getInstance().showTrafficMap(paramBoolean);
  }
  
  public void switchITSMode(boolean paramBoolean)
  {
    BNMapController.getInstance().switchITSMode(paramBoolean);
  }
  
  public boolean updateLayer(int paramInt)
  {
    return BNMapController.getInstance().updateLayer(paramInt);
  }
  
  public boolean zoomIn()
  {
    return BNMapController.getInstance().zoomIn();
  }
  
  public boolean zoomOut()
  {
    return BNMapController.getInstance().zoomOut();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/NMapControlProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */