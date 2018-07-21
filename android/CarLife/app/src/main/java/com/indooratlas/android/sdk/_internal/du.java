package com.indooratlas.android.sdk._internal;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class du
  extends ds
{
  dt a;
  private boolean b;
  private int[] d;
  private SparseArray<b> e;
  private int f;
  private int g;
  
  public du(cw[] paramArrayOfcw)
  {
    this.d = new int[paramArrayOfcw.length];
    int i = 0;
    while (i < paramArrayOfcw.length)
    {
      this.d[i] = paramArrayOfcw[i].a();
      i += 1;
    }
    this.g = this.d.length;
    this.e = new SparseArray(this.g);
  }
  
  private static void a(ArrayList<a> paramArrayList, b paramb)
  {
    Object localObject = paramArrayList.iterator();
    a locala;
    while (((Iterator)localObject).hasNext())
    {
      locala = (a)((Iterator)localObject).next();
      long l1 = locala.b;
      long l2 = locala.a;
      if ((paramb.b >= l1 - 2000000000L) && (paramb.b <= l2 + 2000000000L))
      {
        locala.a = Math.min(locala.a, paramb.b);
        locala.b = Math.max(locala.b, paramb.b);
      }
    }
    for (;;)
    {
      localObject = locala;
      if (locala == null)
      {
        localObject = new a();
        ((a)localObject).a = paramb.b;
        ((a)localObject).b = paramb.b;
        paramArrayList.add(localObject);
      }
      ((a)localObject).c.add(paramb);
      return;
      locala = null;
    }
  }
  
  public final void a(cx paramcx, dd paramdd)
  {
    eg.a(paramcx, "event must not be null", new Object[0]);
    int k = paramcx.a.a();
    Object localObject1 = this.d;
    int j;
    if (localObject1 != null)
    {
      j = localObject1.length;
      if (j <= 0) {
        break label84;
      }
      i = 0;
      label45:
      if (i >= j) {
        break label84;
      }
      if (localObject1[i] != k) {
        break label77;
      }
      label60:
      if (i != -1) {
        break label89;
      }
      paramdd.b(paramcx);
    }
    label77:
    label84:
    label89:
    Object localObject2;
    for (;;)
    {
      return;
      j = -1;
      break;
      i += 1;
      break label45;
      i = -1;
      break label60;
      if (this.b) {
        break label260;
      }
      localObject1 = (b)this.e.get(k);
      if (localObject1 == null)
      {
        this.e.put(k, new b(k, paramcx.b));
        this.f += 1;
      }
      while (this.f == this.g)
      {
        this.b = true;
        localObject1 = this.e;
        localObject2 = new ArrayList();
        j = ((SparseArray)localObject1).size();
        i = 0;
        while (i < j)
        {
          a((ArrayList)localObject2, (b)((SparseArray)localObject1).valueAt(i));
          i += 1;
        }
        ((b)localObject1).d = ej.a();
        ((b)localObject1).c = paramcx.b;
      }
    }
    int i = ((ArrayList)localObject2).size();
    localObject1 = cz.a;
    if (i == 1)
    {
      localObject1 = cz.a;
      this.c = false;
    }
    for (;;)
    {
      label260:
      if ((this.b) && (this.a != null)) {
        paramcx.b = this.a.a(k, paramcx.b);
      }
      super.a(paramcx, paramdd);
      return;
      if (i == 2)
      {
        localObject1 = (a)((ArrayList)localObject2).get(0);
        a locala = (a)((ArrayList)localObject2).get(1);
        i = ((a)localObject1).c.size();
        j = locala.c.size();
        if ((i > 1) && (j > 1))
        {
          localObject1 = cz.a;
          this.a = new dt.a();
        }
        else
        {
          Object localObject3 = localObject1;
          localObject2 = locala;
          if (i < j)
          {
            localObject2 = localObject1;
            localObject3 = locala;
          }
          localObject1 = (b)((a)localObject3).c.iterator().next();
          localObject2 = (b)((a)localObject2).c.iterator().next();
          this.a = new dt.c(((b)localObject1).a, ((b)localObject2).a, ((b)localObject1).c, ((b)localObject1).d);
          localObject1 = cz.a;
        }
      }
      else
      {
        this.a = new dt.a();
        localObject1 = cz.a;
      }
    }
  }
  
  static final class a
  {
    long a;
    long b;
    HashSet<du.b> c = new HashSet();
    
    public final String toString()
    {
      return "MatchGroup{minTimestamp=" + this.a + ", maxTimestamp=" + this.b + ", samples=" + this.c + '}';
    }
  }
  
  static final class b
  {
    int a;
    long b;
    long c;
    long d;
    
    b(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
      this.d = ej.a();
    }
    
    public final String toString()
    {
      return "TimestampSample{sensorType=" + this.a + ", firstTimestamp=" + this.b + ", lastTimestamp=" + this.c + ", lastSeen=" + this.d + '}';
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */