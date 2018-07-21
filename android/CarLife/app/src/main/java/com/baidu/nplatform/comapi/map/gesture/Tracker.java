package com.baidu.nplatform.comapi.map.gesture;

import android.os.Build.VERSION;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.navisdk.BNaviModuleManager;

public class Tracker
{
  public final int MAX_FLING_VELOCITY;
  public final int MIN_FLING_VELOCITY;
  private VelocityTracker velocityTracker;
  
  public Tracker()
  {
    ViewConfiguration localViewConfiguration = null;
    if (BNaviModuleManager.getContext() != null) {}
    try
    {
      localViewConfiguration = ViewConfiguration.get(BNaviModuleManager.getContext());
      if (localViewConfiguration == null)
      {
        this.MIN_FLING_VELOCITY = ViewConfiguration.getMinimumFlingVelocity();
        this.MAX_FLING_VELOCITY = ViewConfiguration.getMaximumFlingVelocity();
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      this.MIN_FLING_VELOCITY = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
      this.MAX_FLING_VELOCITY = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    }
  }
  
  public void addMovement(MotionEvent paramMotionEvent)
  {
    if (this.velocityTracker == null)
    {
      this.velocityTracker = VelocityTracker.obtain();
      return;
    }
    this.velocityTracker.addMovement(paramMotionEvent);
  }
  
  public void finish()
  {
    if (this.velocityTracker != null)
    {
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
  
  public Base.Vector getVelocity()
  {
    if (this.velocityTracker == null) {
      return new Base.Vector(0.0D, 0.0D);
    }
    this.velocityTracker.computeCurrentVelocity(1000, this.MAX_FLING_VELOCITY);
    return new Base.Vector(this.velocityTracker.getXVelocity(), this.velocityTracker.getYVelocity());
  }
  
  public void init()
  {
    this.velocityTracker = VelocityTracker.obtain();
  }
  
  public Pair<Base.Vector, Base.Vector> velocity()
  {
    if (this.velocityTracker == null) {
      return new Pair(new Base.Vector(0.0D, 0.0D), new Base.Vector(0.0D, 0.0D));
    }
    this.velocityTracker.computeCurrentVelocity(1000, this.MAX_FLING_VELOCITY);
    float f1;
    float f3;
    float f2;
    if (Build.VERSION.SDK_INT < 8)
    {
      f1 = this.velocityTracker.getXVelocity();
      f3 = this.velocityTracker.getYVelocity();
      f2 = this.velocityTracker.getXVelocity();
    }
    for (float f4 = this.velocityTracker.getYVelocity();; f4 = this.velocityTracker.getYVelocity(1))
    {
      return new Pair(new Base.Vector(f1, f3), new Base.Vector(f2, f4));
      f1 = this.velocityTracker.getXVelocity(0);
      f3 = this.velocityTracker.getYVelocity(0);
      f2 = this.velocityTracker.getXVelocity(1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */