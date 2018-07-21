package com.facebook.imagepipeline.l;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.memory.ab;
import com.facebook.imagepipeline.memory.f;
import com.facebook.imagepipeline.memory.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class ad
  implements ai<d>
{
  @VisibleForTesting
  static final String a = "NetworkFetchProducer";
  public static final String b = "intermediate_result";
  @VisibleForTesting
  static final long c = 100L;
  private static final int d = 16384;
  private final z e;
  private final f f;
  private final ae g;
  
  public ad(z paramz, f paramf, ae paramae)
  {
    this.e = paramz;
    this.f = paramf;
    this.g = paramae;
  }
  
  private static float a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      return paramInt1 / paramInt2;
    }
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }
  
  @Nullable
  private Map<String, String> a(r paramr, int paramInt)
  {
    if (!paramr.d().b(paramr.c())) {
      return null;
    }
    return this.g.a(paramr, paramInt);
  }
  
  private void a(r paramr)
  {
    paramr.d().b(paramr.c(), "NetworkFetchProducer", null);
    paramr.a().b();
  }
  
  private void a(r paramr, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ab localab;
    if (paramInt > 0) {
      localab = this.e.c(paramInt);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = (byte[])this.f.a(16384);
      try
      {
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i < 0) {
            break;
          }
          if (i > 0)
          {
            localab.write(arrayOfByte, 0, i);
            a(localab, paramr);
            float f1 = a(localab.b(), paramInt);
            paramr.a().b(f1);
          }
        }
        localab = this.e.b();
      }
      finally
      {
        this.f.a(arrayOfByte);
        localab.close();
      }
    }
    this.g.b(paramr, localab.b());
    b(localab, paramr);
    this.f.a(arrayOfByte);
    localab.close();
  }
  
  private void a(r paramr, Throwable paramThrowable)
  {
    paramr.d().a(paramr.c(), "NetworkFetchProducer", paramThrowable, null);
    paramr.a().b(paramThrowable);
  }
  
  private void a(ab paramab, r paramr)
  {
    long l = SystemClock.uptimeMillis();
    if ((b(paramr)) && (l - paramr.f() >= 100L))
    {
      paramr.a(l);
      paramr.d().a(paramr.c(), "NetworkFetchProducer", "intermediate_result");
      a(paramab, false, paramr.a());
    }
  }
  
  /* Error */
  private void a(ab paramab, boolean paramBoolean, j<d> paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 174	com/facebook/imagepipeline/memory/ab:c	()Lcom/facebook/imagepipeline/memory/y;
    //   4: invokestatic 179	com/facebook/common/h/a:a	(Ljava/io/Closeable;)Lcom/facebook/common/h/a;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: new 181	com/facebook/imagepipeline/i/d
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 184	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 187	com/facebook/imagepipeline/i/d:k	()V
    //   27: aload_3
    //   28: aload 4
    //   30: iload_2
    //   31: invokeinterface 190 3 0
    //   36: aload 4
    //   38: invokestatic 193	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   41: aload 5
    //   43: invokestatic 195	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   46: return
    //   47: astore_3
    //   48: aload_1
    //   49: invokestatic 193	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   52: aload 5
    //   54: invokestatic 195	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   57: aload_3
    //   58: athrow
    //   59: astore_3
    //   60: aload 4
    //   62: astore_1
    //   63: goto -15 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ad
    //   0	66	1	paramab	ab
    //   0	66	2	paramBoolean	boolean
    //   0	66	3	paramj	j<d>
    //   20	41	4	locald	d
    //   7	46	5	locala	com.facebook.common.h.a
    // Exception table:
    //   from	to	target	type
    //   11	22	47	finally
    //   22	36	59	finally
  }
  
  private void b(ab paramab, r paramr)
  {
    Map localMap = a(paramr, paramab.b());
    paramr.d().a(paramr.c(), "NetworkFetchProducer", localMap);
    a(paramab, true, paramr.a());
  }
  
  private boolean b(r paramr)
  {
    if (!paramr.b().a().h()) {
      return false;
    }
    return this.g.a(paramr);
  }
  
  public void a(j<d> paramj, aj paramaj)
  {
    paramaj.c().a(paramaj.b(), "NetworkFetchProducer");
    paramj = this.g.b(paramj, paramaj);
    this.g.a(paramj, new ad.1(this, paramj));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/l/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */