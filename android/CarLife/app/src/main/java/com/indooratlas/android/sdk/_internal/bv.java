package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.SystemClock;
import java.net.URI;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

abstract class bv
  extends jn
{
  private long a;
  long b;
  int c;
  Handler d = new a(this);
  
  bv(URI paramURI, jo paramjo)
  {
    super(paramURI, paramjo);
  }
  
  public void a()
  {
    this.a = SystemClock.elapsedRealtime();
  }
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.d.removeCallbacksAndMessages(null);
  }
  
  public final void a(jj paramjj, int paramInt, String paramString, boolean paramBoolean)
  {
    this.d.removeCallbacksAndMessages(null);
    super.a(paramjj, paramInt, paramString, paramBoolean);
  }
  
  public final void a(jj paramjj, kd paramkd)
  {
    this.a = SystemClock.elapsedRealtime();
    super.a(paramjj, paramkd);
  }
  
  public final void a(kd paramkd)
  {
    this.a = SystemClock.elapsedRealtime();
    super.a(paramkd);
  }
  
  public void a(km paramkm)
  {
    this.a = SystemClock.elapsedRealtime();
    b();
  }
  
  final void b()
  {
    long l = this.b;
    this.d.sendEmptyMessageDelayed(0, this.b + 500L);
  }
  
  public final void b(jj paramjj, kd paramkd)
  {
    this.a = SystemClock.elapsedRealtime();
    this.d.removeMessages(1);
    ByteBuffer localByteBuffer = paramkd.c();
    if (localByteBuffer != null) {}
    try
    {
      localByteBuffer.getLong(0);
      SystemClock.elapsedRealtime();
      super.b(paramjj, paramkd);
      return;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      for (;;)
      {
        a(localBufferUnderflowException);
      }
    }
  }
  
  static final class a
    extends ek<bv>
  {
    protected a(bv parambv)
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */