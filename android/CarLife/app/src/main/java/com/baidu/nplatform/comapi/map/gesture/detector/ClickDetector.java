package com.baidu.nplatform.comapi.map.gesture.detector;

import android.view.MotionEvent;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;

public class ClickDetector
{
  public static final int MIN_FINGER_RANGE = 20;
  public static final int MIN_TOUCH_TIME = 200;
  private long beginTime = 0L;
  private Base.Line last;
  private Listener listener;
  private boolean twoPoint = false;
  
  public ClickDetector(Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  private void check(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getPointerCount() != 2) || (this.last == null)) {}
    label143:
    label146:
    for (;;)
    {
      return;
      Base.Line localLine = Base.Line.make(paramMotionEvent);
      paramMotionEvent = new Base.Line(this.last.a, localLine.a);
      localLine = new Base.Line(this.last.b, localLine.b);
      int i;
      if ((Math.abs(paramMotionEvent.length()) < 20.0D) && (Math.abs(localLine.length()) < 20.0D))
      {
        i = 1;
        if (System.currentTimeMillis() - this.beginTime >= 200L) {
          break label143;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0) || (!this.twoPoint)) {
          break label146;
        }
        this.listener.onTwoTouchClick(this);
        return;
        i = 0;
        break;
      }
    }
  }
  
  private void start(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() != 2) {
      return;
    }
    this.last = Base.Line.make(paramMotionEvent);
    this.twoPoint = true;
  }
  
  private void stop()
  {
    this.twoPoint = false;
    this.last = null;
    this.beginTime = 0L;
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      this.beginTime = System.currentTimeMillis();
      return;
    case 5: 
    case 261: 
      start(paramMotionEvent);
      return;
    }
    check(paramMotionEvent);
    stop();
  }
  
  public static abstract interface Listener
  {
    public abstract boolean onTwoTouchClick(ClickDetector paramClickDetector);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/detector/ClickDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */