package com.facebook.imagepipeline.l;

import android.os.Build.VERSION;
import com.facebook.common.h.a;
import com.facebook.common.internal.m;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.memory.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class y
  implements ai<d>
{
  private final Executor a;
  private final z b;
  private final boolean c;
  
  protected y(Executor paramExecutor, z paramz, boolean paramBoolean)
  {
    this.a = paramExecutor;
    this.b = paramz;
    if ((paramBoolean) && (Build.VERSION.SDK_INT == 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.c = paramBoolean;
      return;
    }
  }
  
  protected abstract d a(com.facebook.imagepipeline.m.c paramc)
    throws IOException;
  
  protected d a(final File paramFile, int paramInt)
    throws IOException
  {
    new d(new m()
    {
      public FileInputStream a()
      {
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          return localFileInputStream;
        }
        catch (IOException localIOException)
        {
          throw new RuntimeException(localIOException);
        }
      }
    }, paramInt);
  }
  
  protected d a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    localObject2 = null;
    if (paramInt <= 0) {}
    for (;;)
    {
      try
      {
        locala = a.a(this.b.b(paramInputStream));
        localObject2 = locala;
        d locald = new d(locala);
        com.facebook.common.internal.c.a(paramInputStream);
        a.c(locala);
        return locald;
      }
      finally
      {
        a locala;
        com.facebook.common.internal.c.a(paramInputStream);
        a.c((a)localObject2);
      }
      locala = a.a(this.b.b(paramInputStream, paramInt));
    }
  }
  
  protected abstract String a();
  
  public void a(final j<d> paramj, aj paramaj)
  {
    al localal = paramaj.c();
    String str = paramaj.b();
    final com.facebook.imagepipeline.m.c localc = paramaj.a();
    paramj = new ap(paramj, localal, a(), str)
    {
      protected void a(d paramAnonymousd)
      {
        d.d(paramAnonymousd);
      }
      
      protected d d()
        throws Exception
      {
        d locald = y.this.a(localc);
        if (locald == null) {
          return null;
        }
        locald.k();
        return locald;
      }
    };
    paramaj.a(new e()
    {
      public void a()
      {
        paramj.a();
      }
    });
    this.a.execute(paramj);
  }
  
  protected d b(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = localRuntime.maxMemory();
    long l2 = Math.min(l1 - (localRuntime.totalMemory() - localRuntime.freeMemory()), 8388608L);
    if ((this.c) && ((paramInputStream instanceof FileInputStream)) && (l1 >= 64L * l2)) {
      return a(new File(paramInputStream.toString()), paramInt);
    }
    return a(paramInputStream, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */