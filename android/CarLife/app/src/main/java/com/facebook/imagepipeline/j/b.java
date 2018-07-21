package com.facebook.imagepipeline.j;

import com.facebook.common.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class b
  implements c
{
  private static final String a = "ForwardingRequestListener";
  private final List<c> b;
  
  public b(Set<c> paramSet)
  {
    this.b = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      c localc = (c)paramSet.next();
      this.b.add(localc);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    a.e("ForwardingRequestListener", paramString, paramThrowable);
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, Object paramObject, String paramString, boolean paramBoolean)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramc, paramObject, paramString, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onRequestStart", localException);
          }
        }
      }
    }
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramc, paramString, paramThrowable, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onRequestFailure", localException);
          }
        }
      }
    }
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc, String paramString, boolean paramBoolean)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramc, paramString, paramBoolean);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onRequestSuccess", localException);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramString);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onRequestCancellation", localException);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramString1, paramString2);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onProducerStart", localException);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramString1, paramString2, paramString3);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onIntermediateChunkStart", localException);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramString1, paramString2, paramThrowable, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onProducerFinishWithFailure", localException);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.a(paramString1, paramString2, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onProducerFinishWithSuccess", localException);
          }
        }
      }
    }
  }
  
  public void b(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)this.b.get(i);
        try
        {
          localc.b(paramString1, paramString2, paramMap);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a("InternalListener exception in onProducerFinishWithCancellation", localException);
          }
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      if (((c)this.b.get(i)).b(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */