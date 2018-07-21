package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.baidu.carlife.core.i;
import java.io.ByteArrayOutputStream;

class b
  extends a
{
  private static final String h = "Recorder";
  private static e i = ;
  private long j = e.e;
  private long k = 0L;
  
  public b()
  {
    f = i.f;
  }
  
  private void c()
  {
    i.b("Recorder", "ReceiverAndConverter50Thread  stopThreadInner");
    this.a = false;
    i.v();
    i.C();
  }
  
  private void d()
  {
    e();
    synchronized (f)
    {
      f.compress(Bitmap.CompressFormat.JPEG, 70, this.g);
      int m = this.g.size();
      if (i.a(this.g.toByteArray(), m) == -1) {
        c();
      }
      this.g.reset();
      return;
    }
  }
  
  private void e()
  {
    long l = System.currentTimeMillis();
    if (l - this.k < this.j) {}
    try
    {
      Thread.sleep(this.j - l + this.k);
      this.k = System.currentTimeMillis();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.a = false;
    i.v();
  }
  
  public void a(int paramInt)
  {
    this.j = (1000 / paramInt);
  }
  
  public void run()
  {
    if (!i.j()) {}
    for (;;)
    {
      return;
      this.j = e.e;
      try
      {
        i.g(true);
        i.b("Recorder", "ReceiverAndConverter50Thread isRunning=" + this.a);
        if (i.j()) {
          while (this.a) {
            d();
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        i.b("Recorder", "ReceiverAndConverter50Thread  run finished.");
        c();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */