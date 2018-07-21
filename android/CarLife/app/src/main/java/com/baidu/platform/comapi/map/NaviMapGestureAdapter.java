package com.baidu.platform.comapi.map;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class NaviMapGestureAdapter
  extends GestureDetector.SimpleOnGestureListener
{
  private MapController mMapController;
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.mMapController.isNaviMode()) && (this.mMapController.naviMapViewListener != null))
    {
      this.mMapController.naviMapViewListener.onAction(520, paramMotionEvent);
      return false;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.mMapController.isNaviMode()) && (this.mMapController.naviMapViewListener != null))
    {
      this.mMapController.naviMapViewListener.onAction(515, paramMotionEvent);
      return false;
    }
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.mMapController.isNaviMode()) && (this.mMapController.naviMapViewListener != null)) {
      this.mMapController.naviMapViewListener.onAction(516, null);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.mMapController.isNaviMode()) && (this.mMapController.naviMapViewListener != null) && (!this.mMapController.isEnableDMoveZoom())) {
      this.mMapController.naviMapViewListener.onAction(517, paramMotionEvent);
    }
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.mMapController.isNaviMode()) && (this.mMapController.naviMapViewListener != null)) {
      this.mMapController.naviMapViewListener.onAction(518, null);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void setMapController(MapController paramMapController)
  {
    this.mMapController = paramMapController;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/NaviMapGestureAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */