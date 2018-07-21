package com.facebook.imagepipeline.j;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.e.a;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class d
  implements c
{
  private static final String a = "RequestLoggingListener";
  @GuardedBy("this")
  private final Map<Pair<String, String>, Long> b = new HashMap();
  @GuardedBy("this")
  private final Map<String, Long> c = new HashMap();
  
  private static long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  private static long a(@Nullable Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      return paramLong1 - paramLong.longValue();
    }
    return -1L;
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      if (a.a(2))
      {
        a.a("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(a()), paramString, paramObject, Boolean.valueOf(paramBoolean));
        this.c.put(paramString, Long.valueOf(a()));
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    try
    {
      if (a.a(5))
      {
        paramc = (Long)this.c.remove(paramString);
        long l = a();
        a.d("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[] { Long.valueOf(l), paramString, Long.valueOf(a(paramc, l)), paramThrowable.toString() });
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, String paramString, boolean paramBoolean)
  {
    try
    {
      if (a.a(2))
      {
        paramc = (Long)this.c.remove(paramString);
        long l = a();
        a.a("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(a(paramc, l)));
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (a.a(2))
      {
        Long localLong = (Long)this.c.remove(paramString);
        long l = a();
        a.a("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(a(localLong, l)));
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (a.a(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        long l = a();
        this.b.put(localPair, Long.valueOf(l));
        a.a("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(l), paramString1, paramString2);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (a.a(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)this.b.get(localObject);
        long l = a();
        a.a("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", new Object[] { Long.valueOf(a()), paramString1, paramString2, paramString3, Long.valueOf(a((Long)localObject, l)) });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (a.a(5))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)this.b.remove(localObject);
        long l = a();
        a.d("RequestLoggingListener", "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(a((Long)localObject, l)), paramMap, paramThrowable.toString() });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (a.a(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)this.b.remove(localObject);
        long l = a();
        a.a("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(a((Long)localObject, l)), paramMap });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void b(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (a.a(2))
      {
        Object localObject = Pair.create(paramString1, paramString2);
        localObject = (Long)this.b.remove(localObject);
        long l = a();
        a.a("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", new Object[] { Long.valueOf(l), paramString1, paramString2, Long.valueOf(a((Long)localObject, l)), paramMap });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean b(String paramString)
  {
    return a.a(2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */