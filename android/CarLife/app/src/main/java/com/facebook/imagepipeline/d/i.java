package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.m;

public class i
  implements m<q>
{
  private static final int a = 256;
  private static final int b = Integer.MAX_VALUE;
  private static final int c = Integer.MAX_VALUE;
  private static final int d = Integer.MAX_VALUE;
  private final ActivityManager e;
  
  public i(ActivityManager paramActivityManager)
  {
    this.e = paramActivityManager;
  }
  
  private int c()
  {
    int i = Math.min(this.e.getMemoryClass() * 1048576, Integer.MAX_VALUE);
    if (i < 33554432) {
      return 4194304;
    }
    if (i < 67108864) {
      return 6291456;
    }
    if (Build.VERSION.SDK_INT < 11) {
      return 8388608;
    }
    return i / 4;
  }
  
  public q a()
  {
    return new q(c(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */