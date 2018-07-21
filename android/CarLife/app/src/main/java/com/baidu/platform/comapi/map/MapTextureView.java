package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapTextureView
  extends GLTextureView
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderModeChangeListener, MapRenderer.ResourceRecycler, MapViewInterface
{
  private List<Overlay> innerOverlayList = new ArrayList();
  int mHeight;
  MapController mMapController = null;
  InternalProjection mProjection = null;
  int mWidth;
  MapRenderer mapRenderer = null;
  OverlayMapCallBack overlayMapCallBack = null;
  private RenderMessageListener renderMessageListener;
  
  public MapTextureView(Context paramContext)
  {
    super(paramContext);
    setEGLContextClientVersion(2);
  }
  
  public MapTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
  }
  
  public MapTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setEGLContextClientVersion(2);
  }
  
  private void clearInnerOverlays()
  {
    if (this.mMapController == null) {}
    while ((this.mMapController.getBaseMap() == null) || (this.overlayMapCallBack == null)) {
      return;
    }
    this.innerOverlayList.clear();
    this.overlayMapCallBack.clear();
  }
  
  private void initInnerOverlays()
  {
    if (this.mMapController == null) {}
    AppBaseMap localAppBaseMap;
    do
    {
      return;
      localAppBaseMap = this.mMapController.getBaseMap();
    } while (localAppBaseMap == null);
    clearInnerOverlays();
    addOverlay(new BusLineOverlay(localAppBaseMap));
    addOverlay(new RouteOverlay(localAppBaseMap));
    addOverlay(new ITSRouteOverlay(localAppBaseMap));
    addOverlay(new ITSRouteOverlay(localAppBaseMap));
    addOverlay(new ITSRouteOverlay(localAppBaseMap));
    addOverlay(new PoiOverlay(localAppBaseMap));
    addOverlay(new PoiDynamicMapOverlay(localAppBaseMap));
  }
  
  public boolean addOverlay(Overlay paramOverlay)
  {
    if ((paramOverlay == null) || (this.mMapController == null)) {
      return false;
    }
    AppBaseMap localAppBaseMap = this.mMapController.getBaseMap();
    if (localAppBaseMap == null) {
      return false;
    }
    if ((paramOverlay instanceof StreetPopupOverlay)) {
      return ((InnerOverlay)paramOverlay).addedToMapView();
    }
    if ((paramOverlay instanceof InnerOverlay))
    {
      if (((InnerOverlay)paramOverlay).mBaseMap == null) {
        ((InnerOverlay)paramOverlay).mBaseMap = getController().getBaseMap();
      }
      if (((InnerOverlay)paramOverlay).addedToMapView())
      {
        this.innerOverlayList.add(paramOverlay);
        this.overlayMapCallBack.addOverlay((InnerOverlay)paramOverlay);
        return true;
      }
      return false;
    }
    if ((paramOverlay instanceof ItemizedOverlay))
    {
      paramOverlay.mLayerID = localAppBaseMap.AddLayer(((ItemizedOverlay)paramOverlay).getUpdateType(), 0, "item");
      if (paramOverlay.mLayerID == 0) {
        return false;
      }
      this.innerOverlayList.add(paramOverlay);
      ((ItemizedOverlay)paramOverlay).reAddAll();
      localAppBaseMap.SetLayersClickable(paramOverlay.mLayerID, true);
      localAppBaseMap.ShowLayers(paramOverlay.mLayerID, true);
      localAppBaseMap.UpdateLayers(paramOverlay.mLayerID);
      return true;
    }
    if ((paramOverlay instanceof RtPopupOverlay))
    {
      ((RtPopupOverlay)paramOverlay).initLayer();
      if (paramOverlay.mLayerID == 0) {
        return false;
      }
      this.innerOverlayList.add(paramOverlay);
      ((RtPopupOverlay)paramOverlay).reAddAll();
      localAppBaseMap.SetLayersClickable(paramOverlay.mLayerID, false);
      localAppBaseMap.ShowLayers(paramOverlay.mLayerID, true);
    }
    return false;
  }
  
  public void animateTo(MapStatus paramMapStatus, int paramInt)
  {
    if (this.mMapController != null) {
      this.mMapController.setMapStatusWithAnimation(paramMapStatus, paramInt);
    }
  }
  
  public void attachBaseMapController(MapController paramMapController)
  {
    this.mapRenderer = new MapRenderer(this, this);
    this.mMapController = paramMapController;
    this.mapRenderer.setBaseMapId(paramMapController.getMapId());
    setRenderer(this.mapRenderer);
    setRenderMode(0);
    this.mapRenderer.setMapResInitOk(true);
    this.overlayMapCallBack = new OverlayMapCallBack(this.mMapController.getBaseMap());
    this.mMapController.setOverlayMapCallBack(this.overlayMapCallBack);
    this.mMapController.setMapViewInterface(this);
    initInnerOverlays();
    this.mMapController.setMapRenderModeChangeListener(this);
    this.mProjection = new InternalProjection(this.mMapController);
  }
  
  public boolean enable3D()
  {
    return false;
  }
  
  public MapController getController()
  {
    return this.mMapController;
  }
  
  public MapStatus.GeoBound getGeoRound()
  {
    if (this.mMapController == null) {
      return null;
    }
    return this.mMapController.getMapStatus().geoRound;
  }
  
  public List<ITSRouteOverlay> getITSRouteOverlays()
  {
    ArrayList localArrayList;
    for (;;)
    {
      Iterator localIterator;
      Overlay localOverlay;
      try
      {
        localIterator = this.innerOverlayList.iterator();
        localArrayList = null;
      }
      finally {}
      try
      {
        if (!localIterator.hasNext()) {
          continue;
        }
        localOverlay = (Overlay)localIterator.next();
        if (localOverlay.getClass() != ITSRouteOverlay.class) {
          break label84;
        }
        if (localArrayList != null) {
          break label81;
        }
        localArrayList = new ArrayList();
      }
      finally
      {
        continue;
        continue;
        continue;
      }
      localArrayList.add((ITSRouteOverlay)localOverlay);
    }
    return localArrayList;
  }
  
  public int getLatitudeSpan()
  {
    Object localObject = (InternalProjection)getProjection();
    GeoPoint localGeoPoint = ((InternalProjection)localObject).fromPixels(0, 0);
    localObject = ((InternalProjection)localObject).fromPixels(this.mWidth - 1, this.mHeight - 1);
    return (int)Math.abs(localGeoPoint.getLatitude() - ((GeoPoint)localObject).getLatitude());
  }
  
  public int getLongitudeSpan()
  {
    InternalProjection localInternalProjection = (InternalProjection)getProjection();
    GeoPoint localGeoPoint = localInternalProjection.fromPixels(0, 0);
    return (int)Math.abs(localInternalProjection.fromPixels(this.mWidth - 1, this.mHeight - 1).getLongitude() - localGeoPoint.getLongitude());
  }
  
  public GeoPoint getMapCenter()
  {
    if (this.mMapController == null) {
      return null;
    }
    MapStatus localMapStatus = this.mMapController.getMapStatus();
    return new GeoPoint(localMapStatus.centerPtY, localMapStatus.centerPtX);
  }
  
  public int getMapRotation()
  {
    if (this.mMapController == null) {
      return 0;
    }
    return this.mMapController.getMapStatus().rotation;
  }
  
  public MapStatus getMapStatus()
  {
    if (this.mMapController != null) {
      return this.mMapController.getMapStatus();
    }
    return null;
  }
  
  /* Error */
  public Overlay getOverlay(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/baidu/platform/comapi/map/MapTextureView:innerOverlayList	Ljava/util/List;
    //   6: invokeinterface 230 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 235 1 0
    //   20: ifeq +28 -> 48
    //   23: aload 4
    //   25: invokeinterface 239 1 0
    //   30: checkcast 141	com/baidu/platform/comapi/map/Overlay
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 297	com/baidu/platform/comapi/map/Overlay:mType	I
    //   38: istore_2
    //   39: iload_2
    //   40: iload_1
    //   41: if_icmpne -28 -> 13
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: areturn
    //   48: aconst_null
    //   49: astore_3
    //   50: goto -6 -> 44
    //   53: astore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	MapTextureView
    //   0	58	1	paramInt	int
    //   38	4	2	i	int
    //   33	17	3	localOverlay	Overlay
    //   53	4	3	localObject	Object
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	53	finally
    //   13	39	53	finally
  }
  
  /* Error */
  public Overlay getOverlay(Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/baidu/platform/comapi/map/MapTextureView:innerOverlayList	Ljava/util/List;
    //   6: invokeinterface 230 1 0
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface 235 1 0
    //   18: ifeq +31 -> 49
    //   21: aload_3
    //   22: invokeinterface 239 1 0
    //   27: checkcast 141	com/baidu/platform/comapi/map/Overlay
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 245	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: astore 4
    //   37: aload 4
    //   39: aload_1
    //   40: if_acmpne -28 -> 12
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -6 -> 45
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	MapTextureView
    //   0	59	1	paramClass	Class<?>
    //   30	14	2	localOverlay	Overlay
    //   11	11	3	localIterator	Iterator
    //   35	3	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	12	54	finally
    //   12	37	54	finally
  }
  
  public List<Overlay> getOverlays()
  {
    return this.innerOverlayList;
  }
  
  public int getOverlooking()
  {
    if (this.mMapController == null) {
      return 0;
    }
    return this.mMapController.getMapStatus().overlooking;
  }
  
  public Overlay getPopupOverlay()
  {
    return null;
  }
  
  public Projection getProjection()
  {
    return this.mProjection;
  }
  
  public MapStatus.WinRound getWinRound()
  {
    if (this.mMapController == null) {
      return null;
    }
    return this.mMapController.getMapStatus().winRound;
  }
  
  public float getZoomLevel()
  {
    if (this.mMapController != null) {
      return this.mMapController.getZoomLevel();
    }
    return 0.0F;
  }
  
  public float getZoomToBound(MapBound paramMapBound)
  {
    return getZoomToBound(paramMapBound, this.mWidth, this.mHeight);
  }
  
  public float getZoomToBound(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.mMapController == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.mMapController.getZoomToBound(localBundle, paramInt1, paramInt2);
  }
  
  public float getZoomToBoundF(MapBound paramMapBound)
  {
    return getZoomToBoundF(paramMapBound, this.mWidth, this.mHeight);
  }
  
  public float getZoomToBoundF(MapBound paramMapBound, int paramInt1, int paramInt2)
  {
    if (this.mMapController == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramMapBound.leftBottomPt.getIntX());
    localBundle.putInt("bottom", paramMapBound.leftBottomPt.getIntY());
    localBundle.putInt("right", paramMapBound.rightTopPt.getIntX());
    localBundle.putInt("top", paramMapBound.rightTopPt.getIntY());
    return this.mMapController.getZoomToBoundF(localBundle);
  }
  
  public boolean isSatellite()
  {
    return false;
  }
  
  public boolean isStreetRoad()
  {
    return false;
  }
  
  public boolean isTraffic()
  {
    return false;
  }
  
  public void listenMapRenderMessage(RenderMessageListener paramRenderMessageListener)
  {
    this.renderMessageListener = paramRenderMessageListener;
  }
  
  public void onDestroy()
  {
    this.mMapController.unInit();
    this.mMapController = null;
    this.overlayMapCallBack.clear();
    this.overlayMapCallBack = null;
    this.mProjection = null;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMapRenderModeChange(int paramInt)
  {
    if (this.renderMessageListener != null) {
      this.renderMessageListener.onMessage(paramInt);
    }
    if (paramInt == 1) {
      requestRender();
    }
    while ((paramInt != 0) || (getRenderMode() == 0)) {
      return;
    }
    setRenderMode(0);
  }
  
  public void onPause()
  {
    if (this.mMapController != null) {
      this.mMapController.getBaseMap().OnPause();
    }
    super.onPause();
  }
  
  public void onRecycle()
  {
    if ((this.mMapController != null) && (this.mMapController.getBaseMap() != null)) {
      this.mMapController.getBaseMap().ResetImageRes();
    }
  }
  
  public void onRequestRender() {}
  
  public void onResume()
  {
    if (this.mMapController != null) {
      this.mMapController.getBaseMap().OnResume();
    }
    super.onResume();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mapRenderer.w_old = paramInt1;
    this.mapRenderer.h_old = paramInt2;
    this.mapRenderer.resize_tries = 0;
    if (this.mMapController != null)
    {
      paramSurfaceTexture = getMapStatus();
      paramSurfaceTexture.winRound.left = 0;
      paramSurfaceTexture.winRound.top = 0;
      paramSurfaceTexture.winRound.bottom = paramInt2;
      paramSurfaceTexture.winRound.right = paramInt1;
      setMapStatus(paramSurfaceTexture);
      this.mMapController.setScreenSize(this.mWidth, this.mHeight);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureUpdated(paramSurfaceTexture);
  }
  
  public void refresh(Overlay paramOverlay)
  {
    if ((paramOverlay == null) || (this.mMapController == null)) {
      return;
    }
    if (((paramOverlay instanceof ItemizedOverlay)) && (((ItemizedOverlay)paramOverlay).getUpdateInfo()))
    {
      if (((ItemizedOverlay)paramOverlay).getAllItem().size() > 0) {
        break label125;
      }
      this.mMapController.getBaseMap().ClearLayer(paramOverlay.mLayerID);
      this.mMapController.getBaseMap().ShowLayers(paramOverlay.mLayerID, false);
      this.mMapController.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
    }
    for (;;)
    {
      ((ItemizedOverlay)paramOverlay).setUpdateInfo(false);
      if ((this.mMapController == null) || (this.mMapController.getBaseMap() == null)) {
        break;
      }
      this.mMapController.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
      return;
      label125:
      this.mMapController.getBaseMap().ShowLayers(paramOverlay.mLayerID, true);
      this.mMapController.getBaseMap().UpdateLayers(paramOverlay.mLayerID);
    }
  }
  
  public boolean removeOverlay(Overlay paramOverlay)
  {
    if ((paramOverlay == null) || (this.mMapController == null)) {}
    AppBaseMap localAppBaseMap;
    do
    {
      return false;
      localAppBaseMap = this.mMapController.getBaseMap();
    } while (localAppBaseMap == null);
    localAppBaseMap.ClearLayer(paramOverlay.mLayerID);
    localAppBaseMap.ShowLayers(paramOverlay.mLayerID, false);
    localAppBaseMap.UpdateLayers(paramOverlay.mLayerID);
    localAppBaseMap.RemoveLayer(paramOverlay.mLayerID);
    if ((paramOverlay instanceof ItemizedOverlay)) {
      this.innerOverlayList.remove(paramOverlay);
    }
    for (;;)
    {
      paramOverlay.mLayerID = 0;
      return true;
      if ((paramOverlay instanceof InnerOverlay))
      {
        this.innerOverlayList.remove(paramOverlay);
        this.overlayMapCallBack.remove(paramOverlay);
      }
    }
  }
  
  public void saveScreenToLocal(String paramString) {}
  
  public void setGeoRound(MapStatus.GeoBound paramGeoBound) {}
  
  public void setMapCenter(GeoPoint paramGeoPoint)
  {
    if (this.mMapController != null)
    {
      MapStatus localMapStatus = this.mMapController.getMapStatus();
      localMapStatus.centerPtX = paramGeoPoint.getLongitude();
      localMapStatus.centerPtY = paramGeoPoint.getLatitude();
      this.mMapController.setMapStatus(localMapStatus);
    }
  }
  
  public void setMapStatus(MapStatus paramMapStatus)
  {
    if (this.mMapController != null) {
      this.mMapController.setMapStatus(paramMapStatus);
    }
  }
  
  public void setMapTo2D(boolean paramBoolean) {}
  
  public void setOverlooking(int paramInt)
  {
    if (this.mMapController != null)
    {
      MapStatus localMapStatus = this.mMapController.getMapStatus();
      localMapStatus.overlooking = paramInt;
      this.mMapController.setMapStatus(localMapStatus);
    }
  }
  
  public void setRotation(int paramInt)
  {
    if (this.mMapController != null)
    {
      MapStatus localMapStatus = this.mMapController.getMapStatus();
      localMapStatus.rotation = paramInt;
      this.mMapController.setMapStatus(localMapStatus);
    }
  }
  
  public void setSatellite(boolean paramBoolean) {}
  
  public void setStreetRoad(boolean paramBoolean) {}
  
  public void setTraffic(boolean paramBoolean)
  {
    if (this.mMapController != null)
    {
      AppBaseMap localAppBaseMap = this.mMapController.getBaseMap();
      if (localAppBaseMap != null) {
        localAppBaseMap.ShowTrafficMap(paramBoolean);
      }
    }
  }
  
  public void setWinRound(MapStatus.WinRound paramWinRound)
  {
    if (this.mMapController != null)
    {
      MapStatus localMapStatus = this.mMapController.getMapStatus();
      localMapStatus.winRound = paramWinRound;
      this.mMapController.setMapStatus(localMapStatus);
    }
  }
  
  public void setZoomLevel(float paramFloat)
  {
    if (this.mMapController == null) {
      return;
    }
    float f = paramFloat;
    int i = 21;
    if (getController().getFocusedBaseIndoorMapInfo() != null) {
      i = 22;
    }
    if (f < 4.0F) {
      paramFloat = 4.0F;
    }
    for (;;)
    {
      MapStatus localMapStatus = getMapStatus();
      if (localMapStatus == null) {
        break;
      }
      localMapStatus.level = paramFloat;
      animateTo(localMapStatus, 300);
      return;
      paramFloat = f;
      if (f > i) {
        paramFloat = 21.0F;
      }
    }
  }
  
  public void setZoomLevel(int paramInt)
  {
    setZoomLevel(paramInt);
  }
  
  public void unListenMapRenderMessage()
  {
    this.renderMessageListener = null;
  }
  
  public static abstract interface RenderMessageListener
  {
    public abstract void onMessage(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */