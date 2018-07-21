package com.baidu.platform.comapi.map;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SimpleGestureAdapter
  extends GestureDetector.SimpleOnGestureListener
{
  private Object lock = new Object();
  private MapController mMapController;
  private OnLongPressListener mOnLongPressListener;
  private volatile Set<GestureDetector.SimpleOnGestureListener> mUserListeners = new CopyOnWriteArraySet();
  
  public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    synchronized (this.lock)
    {
      this.mUserListeners.add(paramSimpleOnGestureListener);
      return;
    }
  }
  
  OnLongPressListener getOnLongPressListener()
  {
    return this.mOnLongPressListener;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDoubleTap(paramMotionEvent);
        }
      }
    }
    if (this.mMapController != null) {
      this.mMapController.handleDoubleDownClick(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDoubleTapEvent(paramMotionEvent);
        }
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.mMapController != null)) {
      this.mMapController.handleDoubleTouch(paramMotionEvent);
    }
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onDown(paramMotionEvent);
        }
      }
    }
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.mMapController == null) {
      return false;
    }
    if (this.mMapController.getMapControlMode() == MapController.MapControlMode.STREET) {
      this.mMapController.handleTouchUp(paramMotionEvent2);
    }
    return this.mMapController.handleFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onLongPress(paramMotionEvent);
        }
      }
    }
    if ((this.mMapController != null) && (!this.mMapController.isEnableDMoveZoom()) && (!this.mMapController.isNaviMode()) && (this.mOnLongPressListener != null)) {
      this.mOnLongPressListener.onLongPress(paramMotionEvent);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
      }
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onShowPress(paramMotionEvent);
        }
      }
    }
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onSingleTapConfirmed(paramMotionEvent);
        }
      }
    }
    return (this.mMapController != null) && (this.mMapController.handleTouchSingleClick(paramMotionEvent));
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.mUserListeners;
      if (localObject2 != null)
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((GestureDetector.SimpleOnGestureListener)((Iterator)localObject2).next()).onSingleTapUp(paramMotionEvent);
        }
      }
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
  
  public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    synchronized (this.lock)
    {
      this.mUserListeners.remove(paramSimpleOnGestureListener);
      return;
    }
  }
  
  public void setMapController(MapController paramMapController)
  {
    this.mMapController = paramMapController;
  }
  
  void setOnLongPressListener(OnLongPressListener paramOnLongPressListener)
  {
    this.mOnLongPressListener = paramOnLongPressListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/SimpleGestureAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */