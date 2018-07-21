package com.baidu.mapframework.common.mapview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.mapframework.common.beans.map.MapAnimationFinishEvent;
import com.baidu.mapframework.common.beans.map.NetworkStatusEvent;
import com.baidu.mapframework.util.acd.Stateful;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.map.EngineMsgListener;
import com.baidu.platform.comapi.map.IndoorMapInfo;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.ItsMapObj;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.OnLongPressListener;
import com.baidu.platform.comapi.map.Overlay;
import com.baidu.platform.comapi.util.BMEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMapViewListener
  implements BaiduMapItemizedOverlay.OnTapListener, Stateful, EngineMsgListener, MapViewListener, OnLongPressListener
{
  protected boolean isCreated;
  protected boolean isDestroyed;
  protected Context mContext = c.f();
  protected MapController mMapController;
  protected MapGLSurfaceView mMapView;
  
  protected BaseMapViewListener() {}
  
  protected BaseMapViewListener(Context paramContext)
  {
    this();
  }
  
  public void onClickStreetArrow(MapObj paramMapObj) {}
  
  public void onClickStreetSurface(MapObj paramMapObj) {}
  
  public void onClickedBackground(int paramInt1, int paramInt2) {}
  
  public void onClickedItem(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3)
  {
    if (this.mMapView == null) {
      this.mMapView = MapViewFactory.getInstance().getMapView();
    }
    Object localObject = new ArrayList(this.mMapView.getOverlays());
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Overlay localOverlay = (Overlay)((Iterator)localObject).next();
        if ((localOverlay.mType == 27) && (paramGeoPoint != null) && ((localOverlay instanceof ItemizedOverlay)) && (!((ItemizedOverlay)localOverlay).onTap(paramGeoPoint, this.mMapView)) && (paramInt1 != -1) && (paramInt2 != -1) && (paramInt3 == localOverlay.mLayerID)) {
          ((ItemizedOverlay)localOverlay).onTap(paramInt1, paramInt2, paramGeoPoint);
        }
      }
    }
  }
  
  public void onClickedItem(int paramInt1, GeoPoint paramGeoPoint, int paramInt2)
  {
    if (this.mMapView == null) {
      this.mMapView = MapViewFactory.getInstance().getMapView();
    }
    Object localObject = new ArrayList(this.mMapView.getOverlays());
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Overlay localOverlay = (Overlay)((Iterator)localObject).next();
        if ((localOverlay.mType == 27) && (paramGeoPoint != null) && ((localOverlay instanceof ItemizedOverlay)) && (!((ItemizedOverlay)localOverlay).onTap(paramGeoPoint, this.mMapView)) && (paramInt1 != -1) && (paramInt2 == localOverlay.mLayerID)) {
          ((ItemizedOverlay)localOverlay).onTap(paramInt1);
        }
      }
    }
  }
  
  public void onClickedItsMapObj(List<ItsMapObj> paramList) {}
  
  public final void onClickedMapObj(List<MapObj> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    MapObj localMapObj;
    do
    {
      return;
      localMapObj = (MapObj)paramList.get(0);
      Log.d("BaseMapViewListener", "onClickedMapObj " + paramList.toString());
    } while ((localMapObj.nType == 17) && (TextUtils.isEmpty(localMapObj.strText)));
    switch (localMapObj.nType)
    {
    default: 
      onPoiMarkerClick(localMapObj);
      return;
    case 18: 
      onLocationPointClick(localMapObj);
      return;
    case 19: 
      onCompassClick(localMapObj);
      return;
    }
    onFavouritePoiClick(localMapObj);
  }
  
  public void onClickedOPPoiEventMapObj(MapObj paramMapObj) {}
  
  public void onClickedParticleEventMapObj(List<MapObj> paramList) {}
  
  public void onClickedPoiObj(List<MapObj> paramList) {}
  
  public void onClickedPopup(int paramInt) {}
  
  public void onClickedRouteLabelObj(List<MapObj> paramList) {}
  
  public void onClickedRouteObj(List<MapObj> paramList) {}
  
  public void onClickedStreetIndoorPoi(MapObj paramMapObj) {}
  
  public void onClickedStreetPopup(String paramString) {}
  
  public void onClickedTrafficUgcEventMapObj(MapObj paramMapObj, boolean paramBoolean) {}
  
  protected abstract void onCompassClick(MapObj paramMapObj);
  
  public void onEnterIndoorMapMode(IndoorMapInfo paramIndoorMapInfo) {}
  
  public void onExitIndoorMapMode() {}
  
  protected abstract void onFavouritePoiClick(MapObj paramMapObj);
  
  protected abstract void onLocationPointClick(MapObj paramMapObj);
  
  public void onLongLinkConnect()
  {
    BMEventBus.getInstance().post(new NetworkStatusEvent());
  }
  
  public void onLongLinkDisConnect()
  {
    BMEventBus.getInstance().post(new NetworkStatusEvent());
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMapAnimationFinish()
  {
    BMEventBus.getInstance().post(new MapAnimationFinishEvent());
  }
  
  protected abstract void onPoiMarkerClick(MapObj paramMapObj);
  
  public void onStateCreate()
  {
    if (!this.isCreated)
    {
      this.isCreated = true;
      this.isDestroyed = false;
      this.mMapView = MapViewFactory.getInstance().getMapView();
      if ((this.mMapController == null) && (this.mMapView != null)) {
        this.mMapController = this.mMapView.getController();
      }
      if (this.mMapController != null) {}
    }
    else
    {
      return;
    }
    this.mMapController.setMapViewListener(this);
    this.mMapController.setEngineMsgListener(this);
    this.mMapController.setDoubleClickZoom(true);
    this.mMapController.setMapClickEnable(true);
    this.mMapView.setOnLongPressListener(this);
  }
  
  public void onStateDestroy()
  {
    if ((this.isCreated) && (!this.isDestroyed))
    {
      this.isCreated = false;
      this.isDestroyed = true;
      if ((this.mMapController != null) && (this.mMapController.getMapViewListener() == this)) {
        this.mMapController.setMapViewListener(null);
      }
      if (this.mMapView.getOnLongPressListener() == this) {
        this.mMapView.setOnLongPressListener(null);
      }
    }
  }
  
  public boolean onTap(int paramInt)
  {
    return false;
  }
  
  public boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapGLSurfaceView paramMapGLSurfaceView)
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/mapview/BaseMapViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */