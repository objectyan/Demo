package com.indooratlas.android.sdk._internal;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.HashMap;

public final class cq
{
  public HashMap<Long, ff.f> a;
  public HashMap<Long, ff.f> b;
  public cr c;
  public long d;
  public long e;
  
  public cq(cr paramcr)
  {
    this.c = paramcr;
    this.b = new HashMap();
    this.a = new HashMap();
  }
  
  public static ff.g a(HashMap<Long, ff.f> paramHashMap)
  {
    paramHashMap = paramHashMap.values();
    paramHashMap = (ff.f[])paramHashMap.toArray(new ff.f[paramHashMap.size()]);
    ff.g localg = new ff.g();
    localg.b = paramHashMap;
    return localg;
  }
  
  public final boolean a(@NonNull HashMap<Long, ff.f> paramHashMap, @NonNull dx paramdx)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    long l2;
    for (long l1 = paramdx.j;; l1 = SystemClock.elapsedRealtime() * 1000L)
    {
      l2 = cv.a(paramdx.a);
      if (l2 != -1L) {
        break;
      }
      paramHashMap = paramdx.a;
      return false;
    }
    int i = Math.abs(paramdx.h);
    l1 -= this.e * 1000L;
    l1 /= 1000L;
    int j = (int)l1;
    paramdx = (ff.f)paramHashMap.get(Long.valueOf(l2));
    if (paramdx == null)
    {
      paramdx = new ff.f();
      paramdx.b = l2;
      paramdx.e = new int[] { i };
      paramdx.d = new int[] { j };
      paramHashMap.put(Long.valueOf(l2), paramdx);
    }
    for (;;)
    {
      return true;
      paramdx.e = ec.a(paramdx.e, i);
      paramdx.d = ec.a(paramdx.d, j);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */