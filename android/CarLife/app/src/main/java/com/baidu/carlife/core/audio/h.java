package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.carlife.core.connect.a.e;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import java.util.ArrayList;

public class h
  extends f
{
  private static final int C = 48000;
  private static final int D = 3;
  private static final String a = "Audio-" + h.class.getSimpleName();
  private static final int y = 102400;
  private static final int z = 20480;
  private byte[] A = new byte['倀'];
  private byte[] B = new byte['倀'];
  private com.baidu.carlife.core.connect.a.b E = new com.baidu.carlife.core.connect.a.b();
  private c F = new c();
  private p G = new p();
  private HandlerThread H = new HandlerThread("MusicController");
  private int b;
  private int c;
  private int d;
  private AudioTrack e;
  private Thread f;
  private boolean g;
  private int h = 0;
  private o i = new o();
  private o j = new o();
  private byte[] k = new byte[120];
  private int l;
  private boolean m = true;
  private a n;
  private d o;
  private d p;
  private d q;
  private final int r = 3;
  private int s;
  private p t = new p();
  private final Object u = new Object();
  private byte[] v;
  private int w;
  private CarLifeSRC x = new CarLifeSRC();
  
  public h()
  {
    this.H.start();
    this.n = new a(this.H.getLooper());
    this.p = new j();
    this.q = new l();
    a.a();
    this.s = 12;
    com.baidu.carlife.core.k.a(this.n);
    k();
  }
  
  private void a(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.e.setVolume(paramFloat);
      return;
    }
    this.e.setStereoVolume(paramFloat, paramFloat);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a.h()) {
      return;
    }
    this.i.c(196609);
    this.l = this.i.a(paramInt1, paramInt2, paramInt3, this.k);
    this.i.a(this.l);
    System.arraycopy(this.i.a(), 0, this.k, 0, this.s);
    k.a().a(this.k, this.l + this.s, a.d.a);
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (!a.h()) {}
    while (paramInt <= 0) {
      return;
    }
    byte[] arrayOfByte = paramArrayOfByte;
    int i1 = paramInt;
    if ((e.a().c()) && (paramInt > 0))
    {
      paramArrayOfByte = new byte[paramInt];
      System.arraycopy(arrayOfByte, this.s, paramArrayOfByte, 0, i1);
      paramArrayOfByte = this.E.a(paramArrayOfByte, paramInt);
      if (paramArrayOfByte == null)
      {
        i.e(a, "encrypt failed!");
        return;
      }
      paramInt = paramArrayOfByte.length;
      this.j.c(196614);
      this.j.a(paramInt);
      this.j.c();
      this.F.a(this.j.a(), this.s, paramArrayOfByte, paramInt, this.G);
      k.a().a(this.G.a(), this.G.b(), a.d.f);
      return;
    }
    if (com.baidu.carlife.l.b.a().t())
    {
      i1 = this.x.a(paramArrayOfByte, paramInt, this.A, this.s);
      paramInt = 0;
      while (paramInt < i1)
      {
        this.B[(this.s + paramInt)] = this.A[paramInt];
        paramInt += 1;
      }
      arrayOfByte = this.B;
    }
    this.j.c(196614);
    this.j.a(i1);
    this.j.c();
    System.arraycopy(this.j.a(), 0, arrayOfByte, 0, this.s);
    k.a().a(arrayOfByte, this.s + i1, a.d.f);
  }
  
  private void k()
  {
    this.f = new b(null);
    this.f.start();
  }
  
  private void l()
  {
    if (!m()) {
      return;
    }
    b.a().b();
    n();
  }
  
  private boolean m()
  {
    this.b = this.o.a();
    this.c = this.o.b();
    this.d = this.o.c();
    this.x.a(this.b, 48000, this.c, 3);
    if (this.e != null) {
      this.e.flush();
    }
    i.b(a, "audio track channel config is " + this.c);
    if (this.c == 1) {}
    for (int i1 = 4;; i1 = 12)
    {
      i.b(a, "audio track  sample rate = " + this.b);
      if ((this.b >= 4000) && (this.b <= 48000)) {
        break;
      }
      this.e = null;
      i.b(a, "4000>sample rate || sample rate>48000: " + this.b);
      return false;
    }
    int i2 = AudioTrack.getMinBufferSize(this.b, i1, 2);
    i.b(a, "audio track audioMinBufSizeLocal= " + i2);
    for (;;)
    {
      try
      {
        this.e = new AudioTrack(3, this.b, i1, 2, i2 * 2, 1);
        if (com.baidu.carlife.l.b.a().t())
        {
          b(48000, this.c, this.d);
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        this.e = null;
        i.b(a, "IllegalArgumentException: mAudioTrack =new AudioTrack");
        return false;
      }
      b(this.b, this.c, this.d);
    }
  }
  
  private void n()
  {
    if (this.e == null) {
      return;
    }
    if (this.e.getPlayState() != 3) {
      try
      {
        this.e.play();
        synchronized (this.u)
        {
          this.u.notify();
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          com.baidu.carlife.core.k.b(415);
          localIllegalStateException.printStackTrace();
        }
      }
    }
    i.b(a, "play music has been triggered");
  }
  
  private void o()
  {
    int i1 = this.t.b();
    if (i1 <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (this.u)
      {
        if ((this.e != null) && (this.e.getPlayState() == 3))
        {
          if (this.w < i1)
          {
            this.w = i1;
            this.v = new byte[this.w];
          }
          if ((!a.h()) || (a.a().g())) {
            this.e.write(this.t.a(), this.s, i1);
          }
        }
        else
        {
          return;
        }
      }
      this.e.write(this.v, 0, i1);
    }
  }
  
  private void p()
  {
    synchronized (this.u)
    {
      if (this.e != null)
      {
        int i1 = this.e.getPlayState();
        if (i1 == 3) {
          break label34;
        }
      }
      try
      {
        this.u.wait();
        label34:
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
  }
  
  public void a()
  {
    synchronized (this.u)
    {
      i.b(a, "stop() is called");
      if (this.e == null) {
        return;
      }
    }
    try
    {
      this.e.stop();
      this.e.release();
      this.e = null;
      b.a().c();
      if (a.h())
      {
        this.i.c(196610);
        this.i.a(0);
        k.a().a(this.i.a(), this.i.b(), a.d.b);
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        com.baidu.carlife.core.k.b(415);
        localIllegalStateException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    synchronized (this.u)
    {
      i.b(a, "init() is called");
      a();
      if (paramArrayList == null) {
        this.o = this.q;
      }
      for (int i1 = this.o.a(paramString); i1 == -1; i1 = this.o.a(paramString, paramArrayList))
      {
        Log.i(a, "MediaCodec initialization is failed!");
        return;
        this.o = this.p;
      }
      l();
    }
  }
  
  public void b()
  {
    for (;;)
    {
      synchronized (this.u)
      {
        i.b(a, "pause() is called");
        if (this.e != null)
        {
          int i1 = this.e.getPlayState();
          if (i1 == 3) {
            try
            {
              this.e.pause();
              b.a().c();
              if (a.h())
              {
                this.i.c(196611);
                this.i.a(0);
                k.a().a(this.i.a(), this.i.b(), a.d.c);
              }
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              com.baidu.carlife.core.k.b(415);
              localIllegalStateException.printStackTrace();
              continue;
            }
          }
        }
      }
      i.b(a, "pause music has been triggered");
    }
  }
  
  public void c()
  {
    synchronized (this.u)
    {
      b.a().b();
      i.b(a, "play() is called");
      if ((this.e != null) && (this.e.getPlayState() != 3))
      {
        n();
        if ((a.h()) && (!this.m))
        {
          this.i.c(196612);
          this.i.a(0);
          k.a().a(this.i.a(), this.i.b(), a.d.d);
        }
        return;
      }
      i.b(a, "play music has been triggered");
    }
  }
  
  public void d()
  {
    synchronized (this.u)
    {
      i.b(a, "seek() is called");
      if (this.e == null) {
        return;
      }
    }
    try
    {
      this.e.pause();
      if (a.h())
      {
        this.i.c(196613);
        this.i.a(0);
        k.a().a(this.i.a(), this.i.b(), a.d.e);
      }
      n();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        com.baidu.carlife.core.k.b(415);
        localIllegalStateException.printStackTrace();
      }
    }
  }
  
  public void e()
  {
    synchronized (this.u)
    {
      if (this.e != null)
      {
        AudioTrack localAudioTrack = this.e;
        a(AudioTrack.getMaxVolume() / 3.0F);
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.u)
    {
      if (this.e != null)
      {
        if (Build.MODEL.equals("MI 3")) {
          a(0.001F);
        }
      }
      else {
        return;
      }
      AudioTrack localAudioTrack = this.e;
      a(AudioTrack.getMinVolume());
    }
  }
  
  public void g()
  {
    synchronized (this.u)
    {
      if (this.e != null)
      {
        AudioTrack localAudioTrack = this.e;
        a(AudioTrack.getMaxVolume());
      }
      return;
    }
  }
  
  protected void h()
  {
    synchronized (this.u)
    {
      i.e(a, "notify to awake");
      this.u.notify();
      return;
    }
  }
  
  boolean i()
  {
    return ("" + com.baidu.carlife.core.f.jx.a()).equals(f.a.l);
  }
  
  private class a
    extends com.baidu.carlife.core.j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(1002);
      addMsg(1004);
      addMsg(425);
      addMsg(426);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1002: 
        h.b(h.this, true);
        return;
      case 1004: 
        com.baidu.carlife.l.b.a().a(com.baidu.carlife.core.a.a());
        return;
      case 425: 
        i.b(h.j(), "output format changed, init audio track again");
        h.this.a();
        h.m(h.this);
        return;
      }
      h.this.h();
    }
  }
  
  private class b
    extends Thread
  {
    private b() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   4: iconst_1
      //   5: invokestatic 26	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;Z)Z
      //   8: pop
      //   9: aload_0
      //   10: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   13: invokestatic 29	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;)Z
      //   16: iconst_1
      //   17: if_icmpne +279 -> 296
      //   20: aload_0
      //   21: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   24: invokestatic 31	com/baidu/carlife/core/audio/h:b	(Lcom/baidu/carlife/core/audio/h;)V
      //   27: aload_0
      //   28: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   31: invokestatic 35	com/baidu/carlife/core/audio/h:c	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/d;
      //   34: ifnull +37 -> 71
      //   37: aload_0
      //   38: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   41: aload_0
      //   42: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   45: invokestatic 35	com/baidu/carlife/core/audio/h:c	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/d;
      //   48: aload_0
      //   49: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   52: invokestatic 39	com/baidu/carlife/core/audio/h:d	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/p;
      //   55: aload_0
      //   56: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   59: invokestatic 43	com/baidu/carlife/core/audio/h:e	(Lcom/baidu/carlife/core/audio/h;)I
      //   62: invokeinterface 48 3 0
      //   67: invokestatic 51	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;I)I
      //   70: pop
      //   71: aload_0
      //   72: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   75: invokestatic 54	com/baidu/carlife/core/audio/h:f	(Lcom/baidu/carlife/core/audio/h;)I
      //   78: ldc 55
      //   80: if_icmple +25 -> 105
      //   83: aload_0
      //   84: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   87: ldc 55
      //   89: invokestatic 51	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;I)I
      //   92: pop
      //   93: aload_0
      //   94: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   97: invokestatic 39	com/baidu/carlife/core/audio/h:d	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/p;
      //   100: ldc 55
      //   102: invokevirtual 60	com/baidu/carlife/core/audio/p:a	(I)V
      //   105: iconst_m1
      //   106: aload_0
      //   107: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   110: invokestatic 54	com/baidu/carlife/core/audio/h:f	(Lcom/baidu/carlife/core/audio/h;)I
      //   113: if_icmpne +49 -> 162
      //   116: aload_0
      //   117: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   120: invokestatic 64	com/baidu/carlife/core/audio/h:g	(Lcom/baidu/carlife/core/audio/h;)Ljava/lang/Object;
      //   123: astore_1
      //   124: aload_1
      //   125: monitorenter
      //   126: aload_0
      //   127: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   130: invokestatic 64	com/baidu/carlife/core/audio/h:g	(Lcom/baidu/carlife/core/audio/h;)Ljava/lang/Object;
      //   133: invokevirtual 69	java/lang/Object:wait	()V
      //   136: aload_1
      //   137: monitorexit
      //   138: invokestatic 73	com/baidu/carlife/core/audio/h:j	()Ljava/lang/String;
      //   141: ldc 75
      //   143: invokestatic 80	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   146: goto -137 -> 9
      //   149: astore_2
      //   150: aload_1
      //   151: monitorexit
      //   152: aload_2
      //   153: athrow
      //   154: astore_1
      //   155: aload_1
      //   156: invokevirtual 83	java/lang/InterruptedException:printStackTrace	()V
      //   159: goto -21 -> 138
      //   162: invokestatic 89	com/baidu/carlife/core/audio/a:h	()Z
      //   165: ifeq +90 -> 255
      //   168: invokestatic 94	com/baidu/carlife/core/connect/d:a	()Lcom/baidu/carlife/core/connect/d;
      //   171: invokevirtual 96	com/baidu/carlife/core/connect/d:c	()Z
      //   174: ifeq +81 -> 255
      //   177: aload_0
      //   178: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   181: invokestatic 98	com/baidu/carlife/core/audio/h:h	(Lcom/baidu/carlife/core/audio/h;)Z
      //   184: ifeq +44 -> 228
      //   187: invokestatic 103	com/baidu/carlife/l/b:a	()Lcom/baidu/carlife/l/b;
      //   190: invokevirtual 106	com/baidu/carlife/l/b:t	()Z
      //   193: ifeq +72 -> 265
      //   196: aload_0
      //   197: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   200: ldc 107
      //   202: aload_0
      //   203: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   206: invokestatic 110	com/baidu/carlife/core/audio/h:i	(Lcom/baidu/carlife/core/audio/h;)I
      //   209: aload_0
      //   210: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   213: invokestatic 112	com/baidu/carlife/core/audio/h:j	(Lcom/baidu/carlife/core/audio/h;)I
      //   216: invokestatic 115	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;III)V
      //   219: aload_0
      //   220: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   223: iconst_0
      //   224: invokestatic 117	com/baidu/carlife/core/audio/h:b	(Lcom/baidu/carlife/core/audio/h;Z)Z
      //   227: pop
      //   228: aload_0
      //   229: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   232: aload_0
      //   233: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   236: invokestatic 39	com/baidu/carlife/core/audio/h:d	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/p;
      //   239: invokevirtual 120	com/baidu/carlife/core/audio/p:a	()[B
      //   242: aload_0
      //   243: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   246: invokestatic 39	com/baidu/carlife/core/audio/h:d	(Lcom/baidu/carlife/core/audio/h;)Lcom/baidu/carlife/core/audio/p;
      //   249: invokevirtual 123	com/baidu/carlife/core/audio/p:b	()I
      //   252: invokestatic 126	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;[BI)V
      //   255: aload_0
      //   256: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   259: invokestatic 129	com/baidu/carlife/core/audio/h:l	(Lcom/baidu/carlife/core/audio/h;)V
      //   262: goto -253 -> 9
      //   265: aload_0
      //   266: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   269: aload_0
      //   270: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   273: invokestatic 132	com/baidu/carlife/core/audio/h:k	(Lcom/baidu/carlife/core/audio/h;)I
      //   276: aload_0
      //   277: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   280: invokestatic 110	com/baidu/carlife/core/audio/h:i	(Lcom/baidu/carlife/core/audio/h;)I
      //   283: aload_0
      //   284: getfield 13	com/baidu/carlife/core/audio/h$b:a	Lcom/baidu/carlife/core/audio/h;
      //   287: invokestatic 112	com/baidu/carlife/core/audio/h:j	(Lcom/baidu/carlife/core/audio/h;)I
      //   290: invokestatic 115	com/baidu/carlife/core/audio/h:a	(Lcom/baidu/carlife/core/audio/h;III)V
      //   293: goto -74 -> 219
      //   296: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	297	0	this	b
      //   154	2	1	localInterruptedException	InterruptedException
      //   149	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   126	138	149	finally
      //   150	152	149	finally
      //   116	126	154	java/lang/InterruptedException
      //   152	154	154	java/lang/InterruptedException
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */