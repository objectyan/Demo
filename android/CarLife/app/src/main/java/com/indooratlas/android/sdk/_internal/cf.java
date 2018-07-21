package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import com.indooratlas.algorithm.ClientProcessingManager;

public final class cf
  extends ds
{
  private ClientProcessingManager a;
  private long b;
  private long d;
  private long e;
  private cr f;
  private long g = -1L;
  
  public cf(ClientProcessingManager paramClientProcessingManager, cr paramcr)
  {
    this.a = paramClientProcessingManager;
    this.f = paramcr;
  }
  
  @TargetApi(22)
  public final void a(cx paramcx, dd paramdd)
  {
    int i = paramcx.a.a();
    Object localObject;
    float[] arrayOfFloat;
    long l1;
    switch (i)
    {
    default: 
      localObject = cz.a;
      i = -1;
      if (i != -1)
      {
        localObject = (do)paramcx.c;
        arrayOfFloat = ((do)localObject).d;
        l1 = System.nanoTime();
        if (paramcx.a.a() == 1)
        {
          long l2 = this.f.a();
          if ((this.g < 0L) || (l2 - this.g > 1000L) || (l2 < this.g))
          {
            this.a.setTime(this.f.a(), ((do)localObject).c);
            this.g = l2;
          }
        }
        switch (i)
        {
        default: 
          this.a.addSampleIMU(i, paramcx.b, arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
        }
      }
      break;
    }
    for (;;)
    {
      double d1;
      if (paramcx.a.a() == 14)
      {
        this.b += 1L;
        if ((this.b % 5L == 0L) && (arrayOfFloat.length == 6))
        {
          d1 = arrayOfFloat[3];
          double d2 = arrayOfFloat[4];
          double d3 = arrayOfFloat[5];
          i = ((do)localObject).a;
          int j = ((do)localObject).a;
          i = j;
          if (j != 0)
          {
            i = j;
            if (j != 1)
            {
              i = j;
              if (j != 2)
              {
                i = j;
                if (j != 3) {
                  i = 0;
                }
              }
            }
          }
          this.a.setDeviceBias(d1, d2, d3, i);
        }
      }
      l1 = System.nanoTime() - l1;
      if (l1 > this.d)
      {
        this.d = l1;
        if (cs.a) {
          d1 = l1 / 1000000.0D;
        }
      }
      this.e = paramcx.b;
      super.a(paramcx, paramdd);
      return;
      i = 3;
      break;
      i = 2;
      break;
      i = 0;
      break;
      i = 1;
      break;
      i = 5;
      break;
      this.a.addSampleIMU(i, paramcx.b, arrayOfFloat[0], 0.0D, 0.0D);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */