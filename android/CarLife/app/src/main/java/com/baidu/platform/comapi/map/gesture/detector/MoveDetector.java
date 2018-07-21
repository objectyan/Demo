package com.baidu.platform.comapi.map.gesture.detector;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.gesture.Base.Line;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.Tracker;

public class MoveDetector
{
  public Base.Line currentPosition;
  public MotionEvent event;
  public Base.Line initialPosition;
  public Base.Line lastPosition;
  private Listener listener;
  private boolean running = false;
  public Tracker tracker = new Tracker();
  
  public MoveDetector(Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  private void handleMoving(MotionEvent paramMotionEvent)
  {
    this.tracker.addMovement(paramMotionEvent);
    Pair localPair = this.tracker.velocity();
    if ((paramMotionEvent.getPointerCount() == 2) && ((Math.abs(((Base.Vector)localPair.first).x) > 0.0D) || (Math.abs(((Base.Vector)localPair.first).y) > 0.0D) || (Math.abs(((Base.Vector)localPair.second).x) > 0.0D) || (Math.abs(((Base.Vector)localPair.second).y) > 0.0D)))
    {
      updatePosition(paramMotionEvent);
      this.listener.onMove(this);
    }
  }
  
  private void start()
  {
    this.tracker.init();
    this.initialPosition = null;
    this.lastPosition = null;
    this.currentPosition = null;
    this.running = true;
    this.listener.onMoveBegin(this);
  }
  
  private void stop()
  {
    this.tracker.finish();
    this.running = false;
    this.listener.onMoveEnd(this);
  }
  
  private void updatePosition(MotionEvent paramMotionEvent)
  {
    Base.Line localLine = Base.Line.make(paramMotionEvent);
    if (this.currentPosition != null) {}
    for (paramMotionEvent = this.currentPosition;; paramMotionEvent = localLine)
    {
      this.lastPosition = paramMotionEvent;
      this.currentPosition = localLine;
      if (this.initialPosition == null) {
        this.initialPosition = localLine;
      }
      return;
    }
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.event = paramMotionEvent;
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.running);
        start();
        return;
      } while (!this.running);
      stop();
      return;
      if (this.running)
      {
        handleMoving(paramMotionEvent);
        return;
      }
    } while (paramMotionEvent.getPointerCount() != 2);
    start();
  }
  
  public static abstract interface Listener
  {
    public abstract boolean onMove(MoveDetector paramMoveDetector);
    
    public abstract boolean onMoveBegin(MoveDetector paramMoveDetector);
    
    public abstract boolean onMoveEnd(MoveDetector paramMoveDetector);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/gesture/detector/MoveDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */