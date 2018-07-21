package com.facebook.drawee.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;

public class a
{
  @VisibleForTesting
  a a;
  @VisibleForTesting
  final float b;
  @VisibleForTesting
  boolean c;
  @VisibleForTesting
  boolean d;
  @VisibleForTesting
  long e;
  @VisibleForTesting
  float f;
  @VisibleForTesting
  float g;
  
  public a(Context paramContext)
  {
    this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    a();
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public void a()
  {
    this.a = null;
    b();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.c = true;
        this.d = true;
        this.e = paramMotionEvent.getEventTime();
        this.f = paramMotionEvent.getX();
        this.g = paramMotionEvent.getY();
        return true;
      } while ((Math.abs(paramMotionEvent.getX() - this.f) <= this.b) && (Math.abs(paramMotionEvent.getY() - this.g) <= this.b));
      this.d = false;
      return true;
    case 3: 
      this.c = false;
      this.d = false;
      return true;
    }
    this.c = false;
    if ((Math.abs(paramMotionEvent.getX() - this.f) > this.b) || (Math.abs(paramMotionEvent.getY() - this.g) > this.b)) {
      this.d = false;
    }
    if ((this.d) && (paramMotionEvent.getEventTime() - this.e <= ViewConfiguration.getLongPressTimeout()) && (this.a != null)) {
      this.a.r();
    }
    this.d = false;
    return true;
  }
  
  public void b()
  {
    this.c = false;
    this.d = false;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public static abstract interface a
  {
    public abstract boolean r();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */