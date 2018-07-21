package com.facebook.drawee.c;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class e<INFO>
  implements d<INFO>
{
  private static final String a = "FdingControllerListener";
  private final List<d<? super INFO>> b = new ArrayList(2);
  
  public static <INFO> e<INFO> a()
  {
    return new e();
  }
  
  public static <INFO> e<INFO> a(d<? super INFO> paramd)
  {
    e locale = a();
    locale.b(paramd);
    return locale;
  }
  
  public static <INFO> e<INFO> b(d<? super INFO> paramd1, d<? super INFO> paramd2)
  {
    e locale = a();
    locale.b(paramd1);
    locale.b(paramd2);
    return locale;
  }
  
  private void c(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          d locald = (d)this.b.get(i);
          try
          {
            locald.a(paramString);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              c("InternalListener exception in onRelease", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a(String paramString, Object paramObject)
  {
    try
    {
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          d locald = (d)this.b.get(i);
          try
          {
            locald.a(paramString, paramObject);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              c("InternalListener exception in onSubmit", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a(String paramString, @Nullable INFO paramINFO, @Nullable Animatable paramAnimatable)
  {
    try
    {
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          d locald = (d)this.b.get(i);
          try
          {
            locald.a(paramString, paramINFO, paramAnimatable);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              c("InternalListener exception in onFinalImageSet", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        d locald = (d)this.b.get(i);
        try
        {
          locald.a(paramString, paramThrowable);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c("InternalListener exception in onIntermediateImageFailed", localException);
          }
        }
      }
    }
  }
  
  public void b()
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
  
  public void b(d<? super INFO> paramd)
  {
    try
    {
      this.b.add(paramd);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void b(String paramString, @Nullable INFO paramINFO)
  {
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        d locald = (d)this.b.get(i);
        try
        {
          locald.b(paramString, paramINFO);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c("InternalListener exception in onIntermediateImageSet", localException);
          }
        }
      }
    }
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    try
    {
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          d locald = (d)this.b.get(i);
          try
          {
            locald.b(paramString, paramThrowable);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              c("InternalListener exception in onFailure", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void c(d<? super INFO> paramd)
  {
    try
    {
      this.b.remove(paramd);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */