package com.facebook.common.j;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.o;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class a
{
  private static a a;
  private static final long b = TimeUnit.MINUTES.toMillis(2L);
  private volatile StatFs c = null;
  private volatile File d;
  private volatile StatFs e = null;
  private volatile File f;
  @GuardedBy("lock")
  private long g;
  private final Lock h = new ReentrantLock();
  private volatile boolean i = false;
  
  private StatFs a(@Nullable StatFs paramStatFs, @Nullable File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    if (paramStatFs == null) {}
    try
    {
      paramStatFs = a(paramFile.getAbsolutePath());
    }
    catch (IllegalArgumentException paramStatFs)
    {
      paramStatFs = null;
    }
    catch (Throwable paramStatFs)
    {
      throw o.b(paramStatFs);
    }
    paramStatFs.restat(paramFile.getAbsolutePath());
    return paramStatFs;
  }
  
  protected static StatFs a(String paramString)
  {
    return new StatFs(paramString);
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private void c()
  {
    if (!this.i) {
      this.h.lock();
    }
    try
    {
      if (!this.i)
      {
        this.d = Environment.getDataDirectory();
        this.f = Environment.getExternalStorageDirectory();
        e();
        this.i = true;
      }
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  private void d()
  {
    if (this.h.tryLock()) {}
    try
    {
      if (SystemClock.uptimeMillis() - this.g > b) {
        e();
      }
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  @GuardedBy("lock")
  private void e()
  {
    this.c = a(this.c, this.d);
    this.e = a(this.e, this.f);
    this.g = SystemClock.uptimeMillis();
  }
  
  @SuppressLint({"DeprecatedMethod"})
  public long a(a parama)
  {
    c();
    d();
    long l2;
    if (parama == a.a)
    {
      parama = this.c;
      if (parama == null) {
        break label72;
      }
      if (Build.VERSION.SDK_INT < 18) {
        break label56;
      }
      l2 = parama.getBlockSizeLong();
    }
    for (long l1 = parama.getAvailableBlocksLong();; l1 = parama.getAvailableBlocks())
    {
      return l2 * l1;
      parama = this.e;
      break;
      label56:
      l2 = parama.getBlockSize();
    }
    label72:
    return 0L;
  }
  
  public boolean a(a parama, long paramLong)
  {
    c();
    long l = a(parama);
    return (l <= 0L) || (l < paramLong);
  }
  
  public void b()
  {
    if (this.h.tryLock()) {}
    try
    {
      c();
      e();
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */