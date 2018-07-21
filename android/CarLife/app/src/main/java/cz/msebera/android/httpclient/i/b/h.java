package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@ThreadSafe
public class h
  implements cz.msebera.android.httpclient.b.h, Serializable
{
  private static final long a = -7581093305228232025L;
  @GuardedBy("this")
  private final TreeSet<b> b = new TreeSet(new d());
  
  public void a(b[] paramArrayOfb)
  {
    if (paramArrayOfb != null) {}
    try
    {
      int j = paramArrayOfb.length;
      int i = 0;
      while (i < j)
      {
        addCookie(paramArrayOfb[i]);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void addCookie(b paramb)
  {
    if (paramb != null) {}
    try
    {
      this.b.remove(paramb);
      if (!paramb.a(new Date())) {
        this.b.add(paramb);
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void clear()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean clearExpired(Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +9 -> 12
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_0
    //   9: monitorexit
    //   10: iload_3
    //   11: ireturn
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 33	cz/msebera/android/httpclient/i/b/h:b	Ljava/util/TreeSet;
    //   18: invokevirtual 62	java/util/TreeSet:iterator	()Ljava/util/Iterator;
    //   21: astore 4
    //   23: iload_2
    //   24: istore_3
    //   25: aload 4
    //   27: invokeinterface 68 1 0
    //   32: ifeq -24 -> 8
    //   35: aload 4
    //   37: invokeinterface 72 1 0
    //   42: checkcast 48	cz/msebera/android/httpclient/f/b
    //   45: aload_1
    //   46: invokeinterface 51 2 0
    //   51: ifeq -28 -> 23
    //   54: aload 4
    //   56: invokeinterface 74 1 0
    //   61: iconst_1
    //   62: istore_2
    //   63: goto -40 -> 23
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	h
    //   0	71	1	paramDate	Date
    //   13	50	2	bool1	boolean
    //   7	18	3	bool2	boolean
    //   21	34	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   14	23	66	finally
    //   25	61	66	finally
  }
  
  public List<b> getCookies()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    try
    {
      String str = this.b.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */