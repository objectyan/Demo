package com.baidu.carlife.core.screen.b;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.carlife.core.screen.o;

public class e
{
  private static final float a = 1.0F;
  private static final int b = 0;
  private static final float c = 1.0F;
  private static final float d = 1.0F;
  private static final int e = 0;
  private static final int f = 0;
  private o g;
  
  private static final float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramLong, paramLong, paramInt2, paramFloat1, paramFloat2, paramFloat3, 1.0F, 0, 1.0F, 1.0F, 0, 0);
    localMotionEvent.setSource(paramInt1);
    if (this.g != null) {
      this.g.a(localMotionEvent, true);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    long l2 = SystemClock.uptimeMillis();
    a(4098, 0, l2, paramFloat1, paramFloat2, 1.0F);
    long l3 = 'ʼ';
    long l1 = l2;
    for (;;)
    {
      if (l1 < l2 + l3)
      {
        float f1 = (float)(l1 - l2) / 'ʼ';
        a(4098, 2, l1, a(paramFloat1, paramFloat1, f1), a(paramFloat2, paramFloat2, f1), 1.0F);
        try
        {
          Thread.sleep(50L);
          l1 = SystemClock.uptimeMillis();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    a(4098, 1, l1, paramFloat1, paramFloat2, 0.0F);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 4)
    {
      a(new KeyEvent(0, paramInt), true);
      a(new KeyEvent(1, paramInt), true);
      return;
    }
    a(new KeyEvent(0, paramInt), false);
    a(new KeyEvent(1, paramInt), false);
  }
  
  public void a(KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    long l3 = paramKeyEvent.getDownTime();
    long l2 = paramKeyEvent.getEventTime();
    int k = paramKeyEvent.getAction();
    int m = paramKeyEvent.getKeyCode();
    int n = paramKeyEvent.getRepeatCount();
    int i1 = paramKeyEvent.getMetaState();
    int i2 = paramKeyEvent.getDeviceId();
    int i3 = paramKeyEvent.getScanCode();
    int j = paramKeyEvent.getSource();
    int i4 = paramKeyEvent.getFlags();
    int i = j;
    if (j == 0) {
      i = 257;
    }
    long l1 = l2;
    if (l2 == 0L) {
      l1 = SystemClock.uptimeMillis();
    }
    l2 = l3;
    if (l3 == 0L) {
      l2 = l1;
    }
    paramKeyEvent = new KeyEvent(l2, l1, k, m, n, i1, i2, i3, i4 | 0x8, i);
    if (this.g != null) {
      this.g.a(paramKeyEvent, paramBoolean);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) == 0) {
      paramMotionEvent.setSource(4098);
    }
    if (this.g != null) {
      this.g.a(paramMotionEvent, true);
    }
  }
  
  public void a(o paramo)
  {
    this.g = paramo;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */