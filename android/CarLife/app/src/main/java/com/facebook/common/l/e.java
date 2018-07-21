package com.facebook.common.l;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class e
  implements d
{
  private static final e a = new e();
  
  @DoNotStrip
  public static e a()
  {
    return a;
  }
  
  public long b()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/l/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */