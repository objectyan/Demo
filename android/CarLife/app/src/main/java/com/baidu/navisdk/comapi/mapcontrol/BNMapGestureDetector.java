package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.baidu.navisdk.util.common.LogUtil;

public class BNMapGestureDetector
  extends GestureDetector
{
  private boolean hasLongPressEvent = false;
  private boolean hasTriggerDoubleTapEvent = false;
  private GestureDetector.OnGestureListener mListener = null;
  
  public BNMapGestureDetector(GestureDetector.OnGestureListener paramOnGestureListener)
  {
    super(paramOnGestureListener, new Handler(Looper.getMainLooper()));
    this.mListener = paramOnGestureListener;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LogUtil.e("BNMapGestureDetector", "onTouchEvent()");
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    LogUtil.e("BNMapGestureDetector", (i & 0xFF) + "" + this.hasTriggerDoubleTapEvent + this.hasLongPressEvent + (this.mListener instanceof GestureDetector.OnDoubleTapListener));
    boolean bool1;
    if ((i & 0xFF) == 2)
    {
      bool1 = bool2;
      if (this.hasTriggerDoubleTapEvent)
      {
        bool1 = bool2;
        if (this.hasLongPressEvent)
        {
          LogUtil.e("BNMapGestureDetector", "onDoubleTapEvent()");
          bool1 = bool2;
          if (this.mListener != null)
          {
            bool1 = bool2;
            if ((this.mListener instanceof GestureDetector.OnDoubleTapListener)) {
              bool1 = ((GestureDetector.OnDoubleTapListener)this.mListener).onDoubleTapEvent(paramMotionEvent);
            }
          }
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while ((i & 0xFF) != 1);
    this.hasTriggerDoubleTapEvent = false;
    this.hasLongPressEvent = false;
    return bool2;
  }
  
  public void setHasLongPressEvent(boolean paramBoolean)
  {
    this.hasLongPressEvent = paramBoolean;
  }
  
  public void setHasTriggerDoubleTapEvent(boolean paramBoolean)
  {
    this.hasTriggerDoubleTapEvent = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/mapcontrol/BNMapGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */