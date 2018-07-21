package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.navisdk.util.common.EglConfigUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.MapStatus.GeoBound;
import com.baidu.nplatform.comapi.basestruct.MapStatus.WinRound;
import java.lang.ref.WeakReference;

public class MapGLSurfaceView
  extends GLSurfaceView
  implements MapViewInterface
{
  private static final String TAG = "Map";
  private MapController mMapController = null;
  MapViewListener mMapViewListener = null;
  public MapRenderer mRenderer;
  
  public MapGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    LogUtil.e("Map", "MapGLSurfaceView constructor");
    try
    {
      if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 0))
      {
        setEGLConfigChooser(8, 8, 8, 8, 24, 0);
        return;
      }
      if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 16, 0))
      {
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        return;
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      LogUtil.e("mapglsurfaceview", "no such eglconfigure");
      return;
    }
    if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 8, 0))
    {
      setEGLConfigChooser(8, 8, 8, 8, 8, 0);
      return;
    }
    if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 0, 0))
    {
      setEGLConfigChooser(5, 6, 5, 0, 0, 0);
      return;
    }
    if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 24, 0))
    {
      setEGLConfigChooser(5, 6, 5, 0, 24, 0);
      return;
    }
    if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 16, 0))
    {
      setEGLConfigChooser(5, 6, 5, 0, 16, 0);
      return;
    }
    if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 8, 0))
    {
      setEGLConfigChooser(5, 6, 5, 0, 8, 0);
      return;
    }
    setEGLConfigChooser(8, 8, 8, 0, 0, 0);
  }
  
  private void InitOverlays() {}
  
  public void Init(Context paramContext, Bundle paramBundle)
  {
    LogUtil.e("Map", "MapGLSurfaceView Init");
    if (this.mMapController == null)
    {
      this.mMapController = new MapController(paramContext, this);
      this.mMapController.initBaseMap(paramBundle);
      InitOverlays();
    }
    if (this.mMapController != null)
    {
      this.mRenderer = new MapRenderer(new WeakReference(this));
      setRenderer(this.mRenderer);
      setRenderMode(0);
    }
    setLongClickable(true);
  }
  
  public boolean enable3D()
  {
    return false;
  }
  
  public MapController getController()
  {
    if (this.mMapController == null) {
      this.mMapController = new MapController(getContext(), this);
    }
    return this.mMapController;
  }
  
  public MapStatus.GeoBound getGeoRound()
  {
    return null;
  }
  
  public int getLatitudeSpan()
  {
    return 0;
  }
  
  public int getLongitudeSpan()
  {
    return 0;
  }
  
  public GeoPoint getMapCenter()
  {
    return null;
  }
  
  public int getMapRotation()
  {
    return 0;
  }
  
  public MapStatus getMapStatus()
  {
    return null;
  }
  
  public MapViewListener getMapViewListener()
  {
    return this.mMapViewListener;
  }
  
  public int getOverlooking()
  {
    return 0;
  }
  
  public MapStatus.WinRound getWinRound()
  {
    return null;
  }
  
  public float getZoomLevel()
  {
    return 0.0F;
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onPause()
  {
    LogUtil.e("Map", "surface onPause");
    if (this.mMapController != null) {
      this.mMapController.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    LogUtil.e("Map", "surface onResume");
    if (this.mMapController != null) {
      this.mMapController.onResume();
    }
    setRenderMode(1);
    try
    {
      super.onResume();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.mMapController != null) {
      return this.mMapController.handleTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void saveScreenToLocal(String paramString) {}
  
  public void setGeoRound(MapStatus.GeoBound paramGeoBound) {}
  
  public void setMapCenter(GeoPoint paramGeoPoint) {}
  
  public void setMapStatus(MapStatus paramMapStatus) {}
  
  public void setMapTo2D(boolean paramBoolean) {}
  
  public void setMapViewListener(MapViewListener paramMapViewListener)
  {
    this.mMapViewListener = paramMapViewListener;
  }
  
  public void setOverlooking(int paramInt) {}
  
  public void setRotation(int paramInt) {}
  
  public void setSatellite(boolean paramBoolean) {}
  
  public void setStreetRoad(boolean paramBoolean) {}
  
  public void setTraffic(boolean paramBoolean) {}
  
  public void setWinRound(MapStatus.WinRound paramWinRound) {}
  
  public void setZoomLevel(int paramInt) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("Map", "surfaceChanged w:" + paramInt2 + " h:" + paramInt3);
    MapRenderer.w_old = paramInt2;
    MapRenderer.h_old = paramInt3;
    MapRenderer.resize_tries = 0;
    this.mMapController.resizeSecreen(paramInt2, paramInt3);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    LogUtil.e("Map", "surfaceCreated ");
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    LogUtil.e("Map", "surfaceDestroyed");
  }
  
  public void unInit()
  {
    this.mMapController.unInit();
    this.mMapController = null;
    this.mRenderer = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */