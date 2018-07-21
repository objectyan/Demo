package com.baidu.carlife.core.screen.video;

import com.baidu.carlife.core.i;

public class d
  extends a
{
  private static final String h = "Recorder";
  private static final String i = "--QA-TEST--";
  private static byte[] j;
  private static e k = ;
  private long l = e.e;
  private long m = 0L;
  
  public d()
  {
    d = k.g;
    e = k.h;
    f = k.f;
  }
  
  private void a(boolean paramBoolean)
  {
    f();
    if (paramBoolean) {
      JniMethod.convert(d, j, e.b, e.c);
    }
  }
  
  private void c()
  {
    i.b("Recorder", "ReceiverAndConverterThreadInternal  stopThreadInner");
    this.a = false;
    k.v();
    k.C();
  }
  
  private void d()
  {
    if (k.e())
    {
      if (k.M() == -1) {
        c();
      }
      try
      {
        Thread.sleep(50L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
    }
    f();
    JniMethod.convert(d, j, e.b, e.c);
    int n = k.a(j);
    if ((n == -2) && (!k.J())) {
      c();
    }
    i.c("Recorder", "input2Encoder success flag= " + n);
  }
  
  private void e()
  {
    if (k.e())
    {
      if (k.M() == -1) {
        c();
      }
      try
      {
        Thread.sleep(50L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
    }
    long l1 = System.currentTimeMillis();
    f();
    i.c("--QA-TEST--", "JAVA got frame time = " + (System.currentTimeMillis() - l1));
    l1 = System.currentTimeMillis();
    if ((k.a(d) == -2) && (!k.J())) {
      c();
    }
    i.c("--QA-TEST--", "JAVA encode time = " + (System.currentTimeMillis() - l1));
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: lload_1
    //   5: aload_0
    //   6: getfield 40	com/baidu/carlife/core/screen/video/d:m	J
    //   9: lsub
    //   10: aload_0
    //   11: getfield 38	com/baidu/carlife/core/screen/video/d:l	J
    //   14: lcmp
    //   15: ifge +17 -> 32
    //   18: aload_0
    //   19: getfield 38	com/baidu/carlife/core/screen/video/d:l	J
    //   22: lload_1
    //   23: lsub
    //   24: aload_0
    //   25: getfield 40	com/baidu/carlife/core/screen/video/d:m	J
    //   28: ladd
    //   29: invokestatic 108	java/lang/Thread:sleep	(J)V
    //   32: aload_0
    //   33: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   36: putfield 40	com/baidu/carlife/core/screen/video/d:m	J
    //   39: getstatic 56	com/baidu/carlife/core/screen/video/d:f	Landroid/graphics/Bitmap;
    //   42: astore_3
    //   43: aload_3
    //   44: monitorenter
    //   45: getstatic 51	com/baidu/carlife/core/screen/video/d:e	Ljava/nio/ByteBuffer;
    //   48: invokevirtual 153	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   51: pop
    //   52: getstatic 56	com/baidu/carlife/core/screen/video/d:f	Landroid/graphics/Bitmap;
    //   55: getstatic 51	com/baidu/carlife/core/screen/video/d:e	Ljava/nio/ByteBuffer;
    //   58: invokevirtual 159	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   61: aload_3
    //   62: monitorexit
    //   63: return
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 111	java/lang/InterruptedException:printStackTrace	()V
    //   69: goto -37 -> 32
    //   72: astore 4
    //   74: aload_3
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	d
    //   3	20	1	l1	long
    //   64	11	3	localInterruptedException	InterruptedException
    //   72	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	32	64	java/lang/InterruptedException
    //   45	63	72	finally
    //   74	76	72	finally
  }
  
  public void a()
  {
    this.a = false;
    k.v();
  }
  
  public void a(int paramInt)
  {
    this.l = (1000 / paramInt);
  }
  
  public void run()
  {
    if ((!k.j()) && (!k.G()))
    {
      c();
      return;
    }
    this.l = e.e;
    int n;
    for (;;)
    {
      try
      {
        k.g(true);
        i.b("Recorder", "ReceiverAndConverterThreadInternal isRunning=" + this.a);
        n = k.q();
        i.b("Recorder", "isJPEGMode=" + k.j() + ", mColorFormat=" + n);
        if (k.j()) {
          break;
        }
        if ((n != 15) && (n != 16)) {
          break label208;
        }
        if ((!k.D()) && (!g.b())) {
          break label193;
        }
        k.h(false);
        k.A();
        if (this.a)
        {
          e();
          continue;
        }
        i.b("Recorder", "ReceiverAndConverterThreadInternal  run finished.");
      }
      catch (NullPointerException localNullPointerException)
      {
        i.c("Recorder", "Output Thread closeLocalSocket lead to");
      }
      c();
      return;
      label193:
      a(false);
      g.a(d);
    }
    label208:
    if ((!k.D()) || (j != null)) {
      if (g.b()) {
        break label348;
      }
    }
    for (;;)
    {
      j = new byte[e.b * e.c * 2];
      label246:
      k.h(false);
      i.c("Recorder", "run mColorFormat == 6 || mColorFormat == 7");
      label260:
      k.A();
      while (this.a)
      {
        i.c("Recorder", "enter  readAndConvert, isRunning=" + this.a);
        d();
      }
      break;
      label348:
      do
      {
        j = new byte[e.b * e.c * 3 / 2];
        break label246;
        a(true);
        g.a(j);
        i.c("Recorder", "VideoOutputThread.firstSendEncodeFrame(mDestFormatBuf);");
        break label260;
        if (n == 6) {
          break;
        }
      } while (n != 7);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */