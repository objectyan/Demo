package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.common.internal.o;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ad
  implements com.facebook.common.g.b
{
  @VisibleForTesting
  final int a;
  @VisibleForTesting
  final int b;
  @VisibleForTesting
  final com.facebook.common.h.b<byte[]> c;
  @VisibleForTesting
  final Semaphore d;
  private final com.facebook.common.h.c<byte[]> e;
  
  public ad(com.facebook.common.g.c paramc, v paramv)
  {
    k.a(paramc);
    if (paramv.e > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      k.a(bool1);
      bool1 = bool2;
      if (paramv.f >= paramv.e) {
        bool1 = true;
      }
      k.a(bool1);
      this.b = paramv.f;
      this.a = paramv.e;
      this.c = new com.facebook.common.h.b();
      this.d = new Semaphore(1);
      this.e = new com.facebook.common.h.c()
      {
        public void a(byte[] paramAnonymousArrayOfByte)
        {
          ad.this.d.release();
        }
      };
      paramc.a(this);
      return;
    }
  }
  
  private byte[] c(int paramInt)
  {
    paramInt = b(paramInt);
    byte[] arrayOfByte2 = (byte[])this.c.a();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length >= paramInt) {}
    }
    else
    {
      arrayOfByte1 = d(paramInt);
    }
    return arrayOfByte1;
  }
  
  private byte[] d(int paramInt)
  {
    try
    {
      this.c.b();
      byte[] arrayOfByte = new byte[paramInt];
      this.c.a(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public com.facebook.common.h.a<byte[]> a(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt > 0)
    {
      bool1 = true;
      k.a(bool1, "Size must be greater than zero");
      if (paramInt > this.b) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1, "Requested size is too big");
      this.d.acquireUninterruptibly();
      try
      {
        com.facebook.common.h.a locala = com.facebook.common.h.a.a(c(paramInt), this.e);
        return locala;
      }
      catch (Throwable localThrowable)
      {
        this.d.release();
        throw o.b(localThrowable);
      }
      bool1 = false;
      break;
    }
  }
  
  public void a(com.facebook.common.g.a parama)
  {
    if (!this.d.tryAcquire()) {
      return;
    }
    try
    {
      this.c.b();
      return;
    }
    finally
    {
      this.d.release();
    }
  }
  
  @VisibleForTesting
  int b(int paramInt)
  {
    return Integer.highestOneBit(Math.max(paramInt, this.a) - 1) * 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */