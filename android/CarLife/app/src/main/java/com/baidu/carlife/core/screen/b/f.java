package com.baidu.carlife.core.screen.b;

import android.app.Instrumentation;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.o;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode;
import com.baidu.carlife.protobuf.CarlifeTouchActionProto.CarlifeTouchAction;
import com.baidu.carlife.protobuf.CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class f
{
  private static final long B = 50L;
  public static final int a = 300;
  public static final int b = 301;
  public static final int c = 302;
  public static final int d = 303;
  public static final int e = 304;
  public static final int f = 305;
  private static final String g = "CarlifeTouchManager";
  private static final String h = "TouchManagerHandlerThread";
  private static final String i = "127.0.0.1";
  private static final int j = 8270;
  private static final int k = 10000;
  private static f l = null;
  private long A = 0L;
  private boolean C = true;
  private boolean D = false;
  private c E;
  private j m;
  private e n;
  private Instrumentation o = null;
  private Socket p = null;
  private InetAddress q = null;
  private DataInputStream r = null;
  private DataOutputStream s = null;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y;
  private long z = 0L;
  
  public static f a()
  {
    if (l == null) {}
    try
    {
      if (l == null) {
        l = new f();
      }
      return l;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      i.b("CarlifeTouchManager", "Write to LocalSocket");
      this.s.writeInt(paramInt1);
      this.s.writeInt(paramInt2);
      this.s.writeInt(paramInt3);
      return;
    }
    catch (Exception localException1)
    {
      i.e("CarlifeTouchManager", "Write to LocalSocket Failed");
      localException1.printStackTrace();
      try
      {
        if (this.t % 20 == 0)
        {
          i.e("CarlifeTouchManager", "cntShowToast: " + this.t);
          k.b(1039);
        }
        this.t += 1;
        return;
      }
      catch (Exception localException2)
      {
        i.e("CarlifeTouchManager", "Write to LocalSocket Failed 1");
        localException2.printStackTrace();
      }
    }
  }
  
  private boolean x()
  {
    if ((this.u <= 0) || (this.u > 10000)) {}
    while ((this.v <= 0) || (this.v > 10000) || (this.w <= 0) || (this.w > 10000) || (this.x <= 0) || (this.x > 10000)) {
      return false;
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(localMotionEvent);
        return;
      }
      this.o.sendPointerSync(localMotionEvent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      a(paramInt1, paramInt2);
    }
    do
    {
      return;
      if (paramInt3 == 2)
      {
        c(paramInt1, paramInt2);
        return;
      }
    } while (paramInt3 != 1);
    b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, c paramc)
  {
    if (this.D)
    {
      this.w = d.a().h();
      this.x = d.a().i();
      return;
    }
    this.D = true;
    this.E = paramc;
    this.y = paramInt;
    paramc = new HandlerThread("TouchManagerHandlerThread");
    paramc.start();
    this.m = new a(paramc.getLooper());
    k.a(this.m);
    this.w = d.a().h();
    this.x = d.a().i();
    this.o = new Instrumentation();
    this.n = new e();
  }
  
  public void a(c paramc)
  {
    this.E = paramc;
  }
  
  public void a(o paramo)
  {
    this.n.a(paramo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void b()
  {
    i.b("CarlifeTouchManager", "iniLocalSocket");
    try
    {
      new Thread()
      {
        public void run()
        {
          try
          {
            f.a(f.this, InetAddress.getByName("127.0.0.1"));
            f.a(f.this, new Socket(f.a(f.this), 8270));
            f.a(f.this, new DataInputStream(f.b(f.this).getInputStream()));
            f.a(f.this, new DataOutputStream(f.b(f.this).getOutputStream()));
            return;
          }
          catch (Exception localException)
          {
            i.e("CarlifeTouchManager", "initLocalSocket fail in thread");
            f.a(f.this, null);
            localException.printStackTrace();
          }
        }
      }.start();
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeTouchManager", "initLocalSocket fail");
      this.p = null;
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 1, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(localMotionEvent);
        return;
      }
      this.o.sendPointerSync(localMotionEvent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 1);
    }
  }
  
  public void b(c paramc)
  {
    a(0, paramc);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc 29
    //   2: ldc_w 257
    //   5: invokestatic 123	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 84	com/baidu/carlife/core/screen/b/f:r	Ljava/io/DataInputStream;
    //   12: invokevirtual 262	java/io/DataInputStream:close	()V
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield 84	com/baidu/carlife/core/screen/b/f:r	Ljava/io/DataInputStream;
    //   20: aload_0
    //   21: getfield 86	com/baidu/carlife/core/screen/b/f:s	Ljava/io/DataOutputStream;
    //   24: invokevirtual 263	java/io/DataOutputStream:close	()V
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 86	com/baidu/carlife/core/screen/b/f:s	Ljava/io/DataOutputStream;
    //   32: aload_0
    //   33: getfield 80	com/baidu/carlife/core/screen/b/f:p	Ljava/net/Socket;
    //   36: invokevirtual 266	java/net/Socket:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 80	com/baidu/carlife/core/screen/b/f:p	Ljava/net/Socket;
    //   44: return
    //   45: astore_1
    //   46: ldc 29
    //   48: ldc_w 268
    //   51: invokestatic 133	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 84	com/baidu/carlife/core/screen/b/f:r	Ljava/io/DataInputStream;
    //   63: goto -43 -> 20
    //   66: astore_1
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 84	com/baidu/carlife/core/screen/b/f:r	Ljava/io/DataInputStream;
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: ldc 29
    //   77: ldc_w 270
    //   80: invokestatic 133	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 86	com/baidu/carlife/core/screen/b/f:s	Ljava/io/DataOutputStream;
    //   92: goto -60 -> 32
    //   95: astore_1
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 86	com/baidu/carlife/core/screen/b/f:s	Ljava/io/DataOutputStream;
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: ldc 29
    //   106: ldc_w 272
    //   109: invokestatic 133	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 80	com/baidu/carlife/core/screen/b/f:p	Ljava/net/Socket;
    //   121: return
    //   122: astore_1
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 80	com/baidu/carlife/core/screen/b/f:p	Ljava/net/Socket;
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	f
    //   45	10	1	localException1	Exception
    //   66	7	1	localObject1	Object
    //   74	10	1	localException2	Exception
    //   95	7	1	localObject2	Object
    //   103	10	1	localException3	Exception
    //   122	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	45	java/lang/Exception
    //   8	15	66	finally
    //   46	58	66	finally
    //   20	27	74	java/lang/Exception
    //   20	27	95	finally
    //   75	87	95	finally
    //   32	39	103	java/lang/Exception
    //   32	39	122	finally
    //   104	116	122	finally
  }
  
  public void c(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 2, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(localMotionEvent);
        return;
      }
      this.o.sendPointerSync(localMotionEvent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 2);
    }
  }
  
  public int d()
  {
    return this.u;
  }
  
  public void d(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent1 = MotionEvent.obtain(l1, l1, 0, paramInt1, paramInt2, 0);
      l1 += 10L;
      MotionEvent localMotionEvent2 = MotionEvent.obtain(l1, l1, 1, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        localMotionEvent1.setSource(4098);
        localMotionEvent2.setSource(4098);
        this.n.a(localMotionEvent1);
        this.n.a(localMotionEvent2);
        return;
      }
      this.o.sendPointerSync(localMotionEvent1);
      this.o.sendPointerSync(localMotionEvent2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 0);
      b(paramInt1, paramInt2, 1);
    }
  }
  
  public int e()
  {
    return this.v;
  }
  
  public void e(int paramInt)
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(paramInt + 7);
        return;
      }
      this.o.sendKeyDownUpSync(paramInt + 7);
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeTouchManager", "onKeyDelete get execption:" + localException.toString());
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent1 = MotionEvent.obtain(l1, l1, 0, paramInt1, paramInt2, 0);
      l1 += 10L;
      MotionEvent localMotionEvent2 = MotionEvent.obtain(l1, l1, 1, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        localMotionEvent1.setSource(4098);
        localMotionEvent2.setSource(4098);
        this.n.a(localMotionEvent1);
        this.n.a(localMotionEvent2);
        return;
      }
      this.o.sendPointerSync(localMotionEvent1);
      this.o.sendPointerSync(localMotionEvent2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int f()
  {
    return this.w;
  }
  
  public void f(int paramInt)
  {
    i.b("CarlifeTouchManager", "keycode is " + paramInt);
    try
    {
      if ((this.E == null) || (!this.E.a(paramInt))) {
        break label164;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onHardKeyCodeEvent get exception!");
      return;
    }
    k.a(2026, 0, 0, null);
    return;
    i();
    return;
    s();
    return;
    j();
    return;
    t();
    return;
    k();
    return;
    l();
    return;
    q();
    return;
    r();
    return;
    n();
    return;
    o();
    return;
    p();
    return;
    m();
    return;
    v();
    return;
    u();
    return;
    e(paramInt - 35);
    return;
    w();
    return;
    k.a(2027, 0, 0, null);
    return;
    label164:
    switch (paramInt)
    {
    }
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent1 = MotionEvent.obtain(l1, l1, 0, paramInt1, paramInt2, 0);
      l1 += 30L;
      MotionEvent localMotionEvent2 = MotionEvent.obtain(l1, l1, 1, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        localMotionEvent1.setSource(4098);
        localMotionEvent2.setSource(4098);
        this.n.a(localMotionEvent1);
        this.n.a(localMotionEvent2);
        return;
      }
      this.o.sendPointerSync(localMotionEvent1);
      this.o.sendPointerSync(localMotionEvent2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 0);
      b(paramInt1, paramInt2, 1);
    }
  }
  
  public int g()
  {
    return this.x;
  }
  
  public void g(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent1 = MotionEvent.obtain(l1, l1, 0, paramInt1, paramInt2, 0);
      long l2 = l1 + 100L;
      MotionEvent localMotionEvent2 = MotionEvent.obtain(l2, l2, 2, paramInt1, paramInt2, 0);
      l2 = l1 + 300L;
      MotionEvent localMotionEvent3 = MotionEvent.obtain(l2, l2, 2, paramInt1, paramInt2, 0);
      l2 = l1 + 500L;
      MotionEvent localMotionEvent4 = MotionEvent.obtain(l2, l2, 2, paramInt1, paramInt2, 0);
      l1 += 700L;
      MotionEvent localMotionEvent5 = MotionEvent.obtain(l1, l1, 2, paramInt1, paramInt2, 0);
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(paramInt1, paramInt2);
        return;
      }
      this.o.sendPointerSync(localMotionEvent1);
      this.o.sendPointerSync(localMotionEvent2);
      this.o.sendPointerSync(localMotionEvent3);
      this.o.sendPointerSync(localMotionEvent4);
      this.o.sendPointerSync(localMotionEvent5);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "Please Enter into Carlife App!");
      b(paramInt1, paramInt2, 0);
      b(paramInt1, paramInt2, 2);
      b(paramInt1, paramInt2, 2);
      b(paramInt1, paramInt2, 2);
      b(paramInt1, paramInt2, 2);
    }
  }
  
  public boolean h()
  {
    return this.C;
  }
  
  public void i()
  {
    try
    {
      i.e("CarlifeTouchManager", "onKeyBackEvent keycode=4");
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(4);
        return;
      }
      this.o.sendKeyDownUpSync(4);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeyBackEvent get execption!");
    }
  }
  
  public void j()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(22);
        return;
      }
      this.o.sendKeyDownUpSync(22);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightEvent get execption!");
    }
  }
  
  public void k()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(21);
        return;
      }
      this.o.sendKeyDownUpSync(21);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightEvent get execption!");
    }
  }
  
  public void l()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(19);
        return;
      }
      this.o.sendKeyDownUpSync(19);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorUpEvent get execption!");
    }
  }
  
  public void m()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(305);
        return;
      }
      this.o.sendKeyDownUpSync(305);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightDownEvent get execption!");
    }
  }
  
  public void n()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(303);
        return;
      }
      this.o.sendKeyDownUpSync(303);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorLeftDownEvent get execption!");
    }
  }
  
  public void o()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(304);
        return;
      }
      this.o.sendKeyDownUpSync(304);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightUpEvent get execption!");
    }
  }
  
  public void p()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(302);
        return;
      }
      this.o.sendKeyDownUpSync(302);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorLeftUpEvent get execption!");
    }
  }
  
  public void q()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(20);
        return;
      }
      this.o.sendKeyDownUpSync(20);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorDownEvent get execption!");
    }
  }
  
  public void r()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(23);
        return;
      }
      this.o.sendKeyDownUpSync(23);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeyOkEvent get execption!");
    }
  }
  
  public void s()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(300);
        return;
      }
      this.o.sendKeyDownUpSync(300);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightEvent get execption!");
    }
  }
  
  public void t()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(301);
        return;
      }
      this.o.sendKeyDownUpSync(301);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i.e("CarlifeTouchManager", "onKeySelectorRightEvent get execption!");
    }
  }
  
  public void u()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(28);
        return;
      }
      this.o.sendKeyDownUpSync(28);
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeTouchManager", "onKeyClear get execption:" + localException.toString());
    }
  }
  
  public void v()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(67);
        return;
      }
      this.o.sendKeyDownUpSync(67);
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeTouchManager", "onKeyDelete get execption:" + localException.toString());
    }
  }
  
  public void w()
  {
    try
    {
      if (com.baidu.carlife.core.b.a.a())
      {
        this.n.a(157);
        return;
      }
      this.o.sendKeyDownUpSync(157);
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeTouchManager", "onKeyDelete get execption:" + localException.toString());
    }
  }
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(425985);
      addMsg(425986);
      addMsg(425987);
      addMsg(425988);
      addMsg(425989);
      addMsg(425990);
      addMsg(425991);
      addMsg(425992);
    }
    
    public void handleMessage(Message paramMessage)
    {
      com.baidu.carlife.core.screen.a.a.b().i();
      if (!f.c(f.this)) {}
      for (;;)
      {
        return;
        int i;
        int j;
        switch (paramMessage.what)
        {
        case 425993: 
        default: 
          return;
        case 425985: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null)
          {
            try
            {
              paramMessage = CarlifeTouchActionProto.CarlifeTouchAction.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              String str = "x = " + i + ", y = " + j + ", action = " + paramMessage.getAction();
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION: " + str);
              if (paramMessage.getAction() != 2) {
                break label328;
              }
              f.a(f.this, SystemClock.elapsedRealtime());
              i.b("CarlifeTouchManager", "preTimeMove = " + f.h(f.this) + ", curTimeMove = " + f.i(f.this));
              if (f.i(f.this) - f.h(f.this) < 50L)
              {
                i.b("CarlifeTouchManager", "move event is too much, ignore");
                return;
              }
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION Error");
              paramMessage.printStackTrace();
              return;
            }
            f.b(f.this, f.i(f.this));
            f.this.a(i, j, paramMessage.getAction());
            return;
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION CarlifeCmdMessage is null");
          return;
        case 425986: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_DOWN: " + paramMessage);
              f.this.a(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_DOWN Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_DOWN CarlifeCmdMessage is null");
          return;
        case 425987: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_UP: " + paramMessage);
              f.this.b(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_UP Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_UP CarlifeCmdMessage is null");
          return;
        case 425988: 
          f.a(f.this, SystemClock.elapsedRealtime());
          i.b("CarlifeTouchManager", "preTimeMove = " + f.h(f.this) + ", curTimeMove = " + f.i(f.this));
          if (f.i(f.this) - f.h(f.this) < 50L)
          {
            i.b("CarlifeTouchManager", "move event is too much, ignore");
            return;
          }
          f.b(f.this, f.i(f.this));
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_MOVE: " + paramMessage);
              f.this.c(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_MOVE Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_ACTION_MOVE CarlifeCmdMessage is null");
          return;
        case 425989: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_SINGLE_CLICK: " + paramMessage);
              f.this.d(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_SINGLE_CLICK Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_SINGLE_CLICK CarlifeCmdMessage is null");
          return;
        case 425990: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_DOUBLE_CLICK: " + paramMessage);
              f.this.f(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_DOUBLE_CLICK Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_DOUBLE_CLICK CarlifeCmdMessage is null");
          return;
        case 425991: 
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_CMD_TOUCH_LONG_PRESS: " + paramMessage);
              f.this.g(i, j);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_LONG_PRESS Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_CMD_TOUCH_LONG_PRESS CarlifeCmdMessage is null");
          return;
        case 425992: 
          label328:
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.parseFrom(paramMessage.f());
              i = paramMessage.getKeycode();
              paramMessage = "keycode = " + i;
              i.b("CarlifeTouchManager", "MSG_TOUCH_CAR_HARD_KEY_CODE: " + paramMessage);
              f.this.f(i);
              return;
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_TOUCH_CAR_HARD_KEY_CODE Error");
              paramMessage.printStackTrace();
              return;
            }
          }
          i.e("CarlifeTouchManager", "MSG_TOUCH_CAR_HARD_KEY_CODE CarlifeCmdMessage is null");
          return;
        }
        if (f.j(f.this))
        {
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          if (paramMessage != null) {
            try
            {
              paramMessage = CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.parseFrom(paramMessage.f());
              i = paramMessage.getX() * f.d(f.this) / f.e(f.this);
              j = paramMessage.getY() * f.f(f.this) / f.g(f.this);
              paramMessage = "x = " + i + ", y = " + j;
              i.b("CarlifeTouchManager", "MSG_TOUCH_UI_ACTION_BEGIN: " + paramMessage);
              i.c("CarlifeTouchManager", "ty = " + j + ", phoneHeight = " + d.a().l() + ", avaibleHeight = " + (d.a().l() - f.k(f.this)));
              if (j > d.a().l() - f.k(f.this))
              {
                f.this.e(i, j);
                return;
              }
            }
            catch (InvalidProtocolBufferException paramMessage)
            {
              i.e("CarlifeTouchManager", "MSG_TOUCH_UI_ACTION_BEGIN Error");
              paramMessage.printStackTrace();
              return;
            }
          }
        }
      }
      i.e("CarlifeTouchManager", "MSG_TOUCH_UI_ACTION_BEGIN CarlifeCmdMessage is null");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */