package com.baidu.carlife.core.screen.video;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Surface;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.j;
import com.baidu.carlife.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException;
import com.baidu.carlife.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException.Builder;
import java.nio.ByteBuffer;
import java.util.Locale;

public class e
{
  static final String a = "Recorder";
  static int b = 832;
  static int c = 480;
  static int d = 30;
  public static int e = 1000 / d;
  private static final String i = "needRectifyColor";
  private static final int j = 832;
  private static final int k = 480;
  private static final int l = 800;
  private static final int m = 832;
  private static final int n = 768;
  private static final int o = 448;
  private static final int p = 1024;
  private static final long q = 50000L;
  private static final int r = 15;
  private static final int s = 66;
  private static final int t = 1;
  private static e u;
  private static final int[] w = { 6, 7, 15, 21, 16, 19 };
  private long A = 0L;
  private MediaCodec B;
  private a C;
  private g D;
  private byte[] E = new byte[12];
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = true;
  private boolean J = true;
  private boolean K = false;
  private boolean L = false;
  private boolean M = false;
  private boolean N = true;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private final Object S = new Object();
  private final Object T = new Object();
  private final Object U = new Object();
  private long V = 0L;
  private f W;
  private SharedPreferences X = null;
  private SharedPreferences.Editor Y = null;
  private com.baidu.carlife.core.connect.a.b Z = new com.baidu.carlife.core.connect.a.b();
  private Handler aa = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      e.a(e.this);
    }
  };
  private int ab;
  private int ac = b;
  private int ad = c;
  private int ae = b;
  private int af = c;
  private boolean ag;
  private boolean ah = false;
  private boolean ai = false;
  private MediaProjectionManager aj;
  private MediaProjection ak;
  private VirtualDisplay al;
  private Surface am;
  public Bitmap f;
  byte[] g;
  ByteBuffer h;
  private j v;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  private e()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      this.ag = bool;
      this.W = new f();
      if (!this.ag)
      {
        this.X = com.baidu.carlife.core.a.a().getSharedPreferences("CarLife_Temp", 0);
        this.Y = this.X.edit();
      }
      switch (this.X.getInt("needRectifyColor", -1))
      {
      default: 
        this.H = false;
        this.G = false;
        V();
        return;
      }
    }
    this.H = false;
    this.G = true;
    return;
    this.H = true;
    this.G = true;
  }
  
  private void S()
  {
    if ((!this.M) && (!this.L)) {
      this.K = false;
    }
  }
  
  private void T()
  {
    if (d < 15) {}
    for (;;)
    {
      return;
      try
      {
        if ((!com.baidu.carlife.core.b.a.a()) && (this.C != null))
        {
          this.C.a(15);
          return;
        }
      }
      catch (NullPointerException localNullPointerException) {}
    }
  }
  
  private void U()
  {
    i.b("Recorder", "Recorder  ==============================> begin stopThread()");
    if (((!com.baidu.carlife.core.b.a.a()) && (!this.ag)) || (this.P)) {
      if (this.C != null) {
        this.C.a();
      }
    }
    for (;;)
    {
      if (this.D != null) {
        this.D.a();
      }
      i.b("Recorder", "Recorder  ==============================> end stopThread()");
      return;
      if (com.baidu.carlife.core.b.a.a())
      {
        if (this.D != null) {
          this.D.a();
        }
      }
      else
      {
        aa();
        if (this.am != null) {
          this.am.release();
        }
      }
    }
  }
  
  private void V()
  {
    if (this.Y == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("samsung")) {
            break;
          }
          if ((Build.DEVICE.contains("t03g")) || (Build.DEVICE.contains("m0")))
          {
            this.G = true;
            this.H = false;
            this.Y.putInt("needRectifyColor", 0);
            this.Y.commit();
          }
        } while ((!Build.DEVICE.equals("t03gchn")) && (!Build.DEVICE.equals("m0")) && (!Build.DEVICE.equals("t03gcmcc")));
        JniMethod.prepare(this.y, b, c, true);
        this.H = true;
        this.Y.putInt("needRectifyColor", 1);
        this.Y.commit();
        return;
      } while (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("huawei"));
      if ((Build.DEVICE.contains("hwp6")) || (Build.DEVICE.contains("hwmt1")))
      {
        this.G = true;
        this.H = false;
        this.Y.putInt("needRectifyColor", 0);
        this.Y.commit();
      }
    } while ((!Build.DEVICE.equals("hwmt1-u06")) && (!Build.DEVICE.equals("hwp6-u06")) && (!Build.DEVICE.equals("hwp6-t00")) && (!Build.DEVICE.equals("hwp6s-u06")) && (!Build.DEVICE.equals("hwp6s-t00")));
    JniMethod.prepare(this.y, b, c, true);
    this.H = true;
    this.Y.putInt("needRectifyColor", 1);
    this.Y.commit();
  }
  
  private boolean W()
  {
    H();
    int i1 = 3;
    for (;;)
    {
      if (i1 > 0) {
        try
        {
          Thread.sleep(300L);
          i1 -= 1;
          if (!this.M) {
            break label55;
          }
          M();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.O) {
      this.B = null;
    }
    label55:
    do
    {
      do
      {
        return false;
        L();
        break;
      } while (com.baidu.carlife.core.b.a.a());
      b(b, c, 0);
    } while (this.B == null);
    return G();
  }
  
  private void X()
  {
    if (this.D == null)
    {
      this.D = new g();
      this.D.start();
    }
  }
  
  private void Y()
  {
    if (this.al != null)
    {
      this.al.release();
      this.al = null;
    }
  }
  
  private VirtualDisplay Z()
  {
    return this.ak.createVirtualDisplay("ScreenSharingDemo", this.ac, this.ad, this.ab, 25, this.am, null, null);
  }
  
  private void aa()
  {
    if (this.ak != null)
    {
      this.ak.stop();
      this.ak = null;
    }
  }
  
  public static e b()
  {
    if (u == null) {}
    try
    {
      if (u == null) {
        u = new e();
      }
      return u;
    }
    finally {}
  }
  
  public static int c()
  {
    return b;
  }
  
  public static int d()
  {
    return c;
  }
  
  void A()
  {
    if (this.D == null)
    {
      this.D = new g();
      this.D.start();
    }
  }
  
  void B()
  {
    if (this.C != null) {
      this.C.a();
    }
  }
  
  void C()
  {
    if (this.D != null) {
      this.D.a();
    }
  }
  
  boolean D()
  {
    return this.J;
  }
  
  boolean E()
  {
    return this.F;
  }
  
  void F() {}
  
  boolean G()
  {
    if (this.B == null) {
      return false;
    }
    int i1;
    switch (this.y)
    {
    default: 
      return false;
    case 6: 
    case 7: 
      i1 = b * c * 2;
    }
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer = this.B.getInputBuffers();
        if ((arrayOfByteBuffer.length != 0) && (arrayOfByteBuffer[0].capacity() >= i1)) {
          break;
        }
        this.Q = true;
        boolean bool = W();
        return bool;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        return W();
      }
      i1 = b * c * 4;
      continue;
      i1 = b * c * 3 / 2;
    }
    return true;
  }
  
  boolean H()
  {
    if ((this.B == null) || (this.O)) {
      return false;
    }
    i.b("Recorder", "Recorder releaseVideoEncoder");
    this.O = true;
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   4: invokestatic 28	com/baidu/carlife/core/screen/video/e:b	(Lcom/baidu/carlife/core/screen/video/e;)Ljava/lang/Object;
        //   7: astore_1
        //   8: aload_1
        //   9: monitorenter
        //   10: aload_0
        //   11: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   14: invokestatic 31	com/baidu/carlife/core/screen/video/e:c	(Lcom/baidu/carlife/core/screen/video/e;)Ljava/lang/Object;
        //   17: astore_2
        //   18: aload_2
        //   19: monitorenter
        //   20: aload_0
        //   21: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   24: invokestatic 35	com/baidu/carlife/core/screen/video/e:d	(Lcom/baidu/carlife/core/screen/video/e;)Landroid/media/MediaCodec;
        //   27: invokevirtual 40	android/media/MediaCodec:stop	()V
        //   30: ldc 42
        //   32: ldc 44
        //   34: invokestatic 49	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   37: aload_0
        //   38: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   41: invokestatic 35	com/baidu/carlife/core/screen/video/e:d	(Lcom/baidu/carlife/core/screen/video/e;)Landroid/media/MediaCodec;
        //   44: invokevirtual 52	android/media/MediaCodec:release	()V
        //   47: ldc 42
        //   49: ldc 54
        //   51: invokestatic 49	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   54: aload_0
        //   55: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   58: aconst_null
        //   59: invokestatic 57	com/baidu/carlife/core/screen/video/e:a	(Lcom/baidu/carlife/core/screen/video/e;Landroid/media/MediaCodec;)Landroid/media/MediaCodec;
        //   62: pop
        //   63: aload_0
        //   64: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   67: iconst_0
        //   68: invokestatic 60	com/baidu/carlife/core/screen/video/e:a	(Lcom/baidu/carlife/core/screen/video/e;Z)Z
        //   71: pop
        //   72: aload_0
        //   73: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   76: invokestatic 64	com/baidu/carlife/core/screen/video/e:e	(Lcom/baidu/carlife/core/screen/video/e;)Landroid/view/Surface;
        //   79: ifnull +29 -> 108
        //   82: aload_0
        //   83: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   86: invokestatic 64	com/baidu/carlife/core/screen/video/e:e	(Lcom/baidu/carlife/core/screen/video/e;)Landroid/view/Surface;
        //   89: invokevirtual 67	android/view/Surface:release	()V
        //   92: aload_0
        //   93: getfield 15	com/baidu/carlife/core/screen/video/e$3:a	Lcom/baidu/carlife/core/screen/video/e;
        //   96: aconst_null
        //   97: invokestatic 70	com/baidu/carlife/core/screen/video/e:a	(Lcom/baidu/carlife/core/screen/video/e;Landroid/view/Surface;)Landroid/view/Surface;
        //   100: pop
        //   101: ldc 42
        //   103: ldc 72
        //   105: invokestatic 49	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   108: aload_2
        //   109: monitorexit
        //   110: aload_1
        //   111: monitorexit
        //   112: return
        //   113: astore_3
        //   114: aload_3
        //   115: invokevirtual 75	java/lang/IllegalStateException:printStackTrace	()V
        //   118: goto -81 -> 37
        //   121: astore_3
        //   122: aload_3
        //   123: invokevirtual 76	java/lang/Exception:printStackTrace	()V
        //   126: goto -18 -> 108
        //   129: astore_3
        //   130: aload_2
        //   131: monitorexit
        //   132: aload_3
        //   133: athrow
        //   134: astore_2
        //   135: aload_1
        //   136: monitorexit
        //   137: aload_2
        //   138: athrow
        //   139: astore_3
        //   140: aload_3
        //   141: invokevirtual 75	java/lang/IllegalStateException:printStackTrace	()V
        //   144: goto -90 -> 54
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	147	0	this	3
        //   7	129	1	localObject1	Object
        //   17	114	2	localObject2	Object
        //   134	4	2	localObject3	Object
        //   113	2	3	localIllegalStateException1	IllegalStateException
        //   121	2	3	localException	Exception
        //   129	4	3	localObject4	Object
        //   139	2	3	localIllegalStateException2	IllegalStateException
        // Exception table:
        //   from	to	target	type
        //   20	37	113	java/lang/IllegalStateException
        //   20	37	121	java/lang/Exception
        //   37	54	121	java/lang/Exception
        //   54	108	121	java/lang/Exception
        //   114	118	121	java/lang/Exception
        //   140	144	121	java/lang/Exception
        //   20	37	129	finally
        //   37	54	129	finally
        //   54	108	129	finally
        //   108	110	129	finally
        //   114	118	129	finally
        //   122	126	129	finally
        //   130	132	129	finally
        //   140	144	129	finally
        //   10	20	134	finally
        //   110	112	134	finally
        //   132	134	134	finally
        //   135	137	134	finally
        //   37	54	139	java/lang/IllegalStateException
      }
    }.start();
    return true;
  }
  
  /* Error */
  boolean I()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 159	com/baidu/carlife/core/screen/video/e:O	Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 159	com/baidu/carlife/core/screen/video/e:O	Z
    //   21: aload_0
    //   22: getfield 167	com/baidu/carlife/core/screen/video/e:S	Ljava/lang/Object;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 169	com/baidu/carlife/core/screen/video/e:T	Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_2
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   39: invokevirtual 432	android/media/MediaCodec:stop	()V
    //   42: aload_0
    //   43: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   46: invokevirtual 433	android/media/MediaCodec:release	()V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 159	com/baidu/carlife/core/screen/video/e:O	Z
    //   59: aload_0
    //   60: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   63: ifnull +15 -> 78
    //   66: aload_0
    //   67: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   70: invokevirtual 273	android/view/Surface:release	()V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   78: invokestatic 241	com/baidu/carlife/core/b/a:a	()Z
    //   81: ifeq +54 -> 135
    //   84: aload_0
    //   85: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   88: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   91: invokevirtual 436	com/baidu/carlife/core/screen/video/e:a	(II)Z
    //   94: pop
    //   95: aload_2
    //   96: monitorexit
    //   97: aload_1
    //   98: monitorexit
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_2
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 425	java/lang/IllegalStateException:printStackTrace	()V
    //   111: goto -69 -> 42
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   119: goto -24 -> 95
    //   122: astore_3
    //   123: aload_2
    //   124: monitorexit
    //   125: aload_3
    //   126: athrow
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 425	java/lang/IllegalStateException:printStackTrace	()V
    //   132: goto -83 -> 49
    //   135: aload_0
    //   136: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   139: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   142: iconst_0
    //   143: invokevirtual 367	com/baidu/carlife/core/screen/video/e:b	(III)Z
    //   146: pop
    //   147: goto -52 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	e
    //   25	78	1	localObject1	Object
    //   32	64	2	localObject2	Object
    //   101	23	2	localObject3	Object
    //   106	2	3	localIllegalStateException1	IllegalStateException
    //   114	2	3	localException	Exception
    //   122	4	3	localObject4	Object
    //   127	2	3	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   28	35	101	finally
    //   97	99	101	finally
    //   102	104	101	finally
    //   125	127	101	finally
    //   35	42	106	java/lang/IllegalStateException
    //   35	42	114	java/lang/Exception
    //   42	49	114	java/lang/Exception
    //   49	78	114	java/lang/Exception
    //   78	95	114	java/lang/Exception
    //   107	111	114	java/lang/Exception
    //   128	132	114	java/lang/Exception
    //   135	147	114	java/lang/Exception
    //   35	42	122	finally
    //   42	49	122	finally
    //   49	78	122	finally
    //   78	95	122	finally
    //   95	97	122	finally
    //   107	111	122	finally
    //   115	119	122	finally
    //   123	125	122	finally
    //   128	132	122	finally
    //   135	147	122	finally
    //   42	49	127	java/lang/IllegalStateException
  }
  
  boolean J()
  {
    return this.O;
  }
  
  int K()
  {
    c(true);
    c(false);
    if (this.P)
    {
      if (this.C == null)
      {
        if (!com.baidu.carlife.core.b.a.a()) {}
        for (this.C = new c();; this.C = new b())
        {
          this.C.start();
          return 0;
        }
      }
      i.e("Recorder", "The RecordThread didnt close last time");
      return -1;
    }
    if (com.baidu.carlife.core.b.a.a())
    {
      i.b("Recorder", "startThread internal screen capture.");
      X();
      return 0;
    }
    if (this.ag)
    {
      X();
      return 0;
    }
    i.b("Recorder", "startThread full screen capture.");
    if (this.C == null)
    {
      this.C = new c();
      this.C.start();
      return 0;
    }
    return -1;
  }
  
  int L()
  {
    synchronized (this.U)
    {
      this.E[0] = 0;
      this.E[1] = 0;
      this.E[2] = 0;
      this.E[3] = 0;
      long l1 = System.currentTimeMillis();
      this.E[4] = ((byte)(int)((0x7F000000 & l1) >> 24));
      this.E[5] = ((byte)(int)((0xFF0000 & l1) >> 16));
      this.E[6] = ((byte)(int)((0xFF00 & l1) >> 8));
      this.E[7] = ((byte)(int)(0xFF & l1));
      this.E[8] = 0;
      this.E[9] = 2;
      this.E[10] = 0;
      this.E[11] = 1;
      int i1 = com.baidu.carlife.core.connect.e.a().a(this.E, 12);
      return i1;
    }
  }
  
  int M()
  {
    synchronized (this.U)
    {
      this.E[0] = 0;
      this.E[1] = 0;
      this.E[2] = 0;
      this.E[3] = 0;
      long l1 = System.currentTimeMillis();
      this.E[4] = ((byte)(int)((0x7F000000 & l1) >> 24));
      this.E[5] = ((byte)(int)((0xFF0000 & l1) >> 16));
      this.E[6] = ((byte)(int)((0xFF00 & l1) >> 8));
      this.E[7] = ((byte)(int)(0xFF & l1));
      this.E[8] = 0;
      this.E[9] = 2;
      this.E[10] = 0;
      this.E[11] = 2;
      int i1 = com.baidu.carlife.core.connect.e.a().a(this.E, 12);
      return i1;
    }
  }
  
  boolean N()
  {
    return this.ag;
  }
  
  public boolean O()
  {
    return this.R;
  }
  
  public void P()
  {
    this.R = false;
    if (this.aj == null)
    {
      com.baidu.carlife.core.a locala = com.baidu.carlife.core.a.a();
      this.ab = com.baidu.carlife.core.d.a().g();
      this.aj = ((MediaProjectionManager)locala.getSystemService("media_projection"));
    }
    if (this.ak == null)
    {
      this.v.a(this.aj.createScreenCaptureIntent(), 4353);
      this.ah = true;
    }
  }
  
  boolean Q()
  {
    return this.ai;
  }
  
  void R()
  {
    if ((this.ak != null) && (this.al == null)) {
      this.al = Z();
    }
  }
  
  int a(byte[] paramArrayOfByte)
  {
    synchronized (this.S)
    {
      if (this.B == null)
      {
        i.e("Recorder", "还没完成初始化, 或已经被释放");
        return -2;
      }
      try
      {
        Object localObject2 = this.B.getInputBuffers();
        int i1 = this.B.dequeueInputBuffer(50000L);
        if (i1 < 0) {
          break label102;
        }
        localObject2 = localObject2[i1];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        this.V += 300000L;
        this.B.queueInputBuffer(i1, 0, paramArrayOfByte.length, this.V, 0);
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      return 0;
      label102:
      i.d("Recorder", "input2Encoder -1;sendEmptyPacket");
      L();
      return -1;
    }
  }
  
  int a(byte[] arg1, int paramInt)
  {
    byte[] arrayOfByte2 = ???;
    int i1 = paramInt;
    byte[] arrayOfByte1 = arrayOfByte2;
    int i2 = i1;
    if (com.baidu.carlife.core.connect.a.e.a().c())
    {
      arrayOfByte1 = arrayOfByte2;
      i2 = i1;
      if (paramInt > 0)
      {
        arrayOfByte1 = this.Z.a(???, paramInt);
        if (arrayOfByte1 == null)
        {
          i.e("Recorder", "encrypt failed!");
          return -1;
        }
        i2 = arrayOfByte1.length;
      }
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.A > 980L) {
      this.A = l1;
    }
    for (this.z = 1;; this.z += 1) {
      synchronized (this.U)
      {
        this.E[0] = ((byte)((0xFF000000 & i2) >> 24));
        this.E[1] = ((byte)((0xFF0000 & i2) >> 16));
        this.E[2] = ((byte)((0xFF00 & i2) >> 8));
        this.E[3] = ((byte)(i2 & 0xFF));
        l1 = System.currentTimeMillis();
        this.E[4] = ((byte)(int)((0xFFFFFFFFFF000000 & l1) >> 24));
        this.E[5] = ((byte)(int)((0xFF0000 & l1) >> 16));
        this.E[6] = ((byte)(int)((0xFF00 & l1) >> 8));
        this.E[7] = ((byte)(int)(0xFF & l1));
        this.E[8] = 0;
        this.E[9] = 2;
        this.E[10] = 0;
        this.E[11] = 1;
        com.baidu.carlife.core.connect.e.a().a(this.E, 12);
        paramInt = com.baidu.carlife.core.connect.e.a().a(arrayOfByte1, i2);
        return paramInt;
      }
    }
  }
  
  public Surface a()
  {
    return this.am;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject1).c(65591);
    Object localObject2 = CarlifeConnectExceptionProto.CarlifeConnectException.newBuilder();
    ((CarlifeConnectExceptionProto.CarlifeConnectException.Builder)localObject2).setExceptionType(paramInt);
    localObject2 = ((CarlifeConnectExceptionProto.CarlifeConnectException.Builder)localObject2).build();
    ((com.baidu.carlife.core.connect.c)localObject1).b(((CarlifeConnectExceptionProto.CarlifeConnectException)localObject2).toByteArray());
    ((com.baidu.carlife.core.connect.c)localObject1).d(((CarlifeConnectExceptionProto.CarlifeConnectException)localObject2).getSerializedSize());
    localObject1 = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject1).d(), 1001, 0, localObject1);
    com.baidu.carlife.core.connect.d.a().a((Message)localObject1);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 4353) {}
    do
    {
      return;
      e(false);
      if (paramInt2 != -1)
      {
        a(2);
        return;
      }
    } while (this.aj == null);
    if (this.ak == null)
    {
      this.ak = this.aj.getMediaProjection(paramInt2, paramIntent);
      this.ak.registerCallback(new a(null), null);
      this.al = Z();
    }
    this.ai = true;
  }
  
  public void a(j paramj)
  {
    this.v = paramj;
    this.W.a(paramj);
  }
  
  void a(Object paramObject)
  {
    this.D = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  /* Error */
  boolean a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 481	com/baidu/carlife/core/screen/video/e:aj	Landroid/media/projection/MediaProjectionManager;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: invokevirtual 635	com/baidu/carlife/core/screen/video/e:C	()V
    //   13: aload_0
    //   14: getfield 167	com/baidu/carlife/core/screen/video/e:S	Ljava/lang/Object;
    //   17: astore_3
    //   18: aload_3
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 169	com/baidu/carlife/core/screen/video/e:T	Ljava/lang/Object;
    //   24: astore 4
    //   26: aload 4
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   33: ifnull +52 -> 85
    //   36: aload_0
    //   37: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +41 -> 85
    //   47: aload_0
    //   48: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   51: invokevirtual 432	android/media/MediaCodec:stop	()V
    //   54: aload_0
    //   55: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   58: invokevirtual 433	android/media/MediaCodec:release	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   66: aload_0
    //   67: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   70: ifnull +15 -> 85
    //   73: aload_0
    //   74: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   77: invokevirtual 273	android/view/Surface:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   85: aload_0
    //   86: ldc_w 637
    //   89: invokestatic 641	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   92: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   95: invokestatic 486	com/baidu/carlife/core/d:a	()Lcom/baidu/carlife/core/d;
    //   98: astore 5
    //   100: iload_1
    //   101: sipush 800
    //   104: if_icmpge +574 -> 678
    //   107: aload 5
    //   109: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   112: sipush 768
    //   115: if_icmplt +563 -> 678
    //   118: aload_0
    //   119: sipush 768
    //   122: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   125: aload_0
    //   126: sipush 448
    //   129: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   132: invokestatic 645	com/baidu/carlife/core/d:m	()Z
    //   135: ifeq +25 -> 160
    //   138: aload_0
    //   139: sipush 1024
    //   142: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   145: aload_0
    //   146: sipush 384
    //   149: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   152: ldc 16
    //   154: ldc_w 647
    //   157: invokestatic 255	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc 16
    //   162: new 649	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 652
    //   172: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   179: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 661
    //   185: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_0
    //   189: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   192: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 663
    //   198: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 255	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   210: aload_0
    //   211: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   214: if_icmpne +13 -> 227
    //   217: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   220: aload_0
    //   221: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   224: if_icmpeq +58 -> 282
    //   227: ldc 16
    //   229: new 649	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 669
    //   239: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   246: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 661
    //   252: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   259: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 663
    //   265: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 255	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: iconst_1
    //   276: invokevirtual 671	com/baidu/carlife/core/screen/video/e:f	(Z)V
    //   279: invokestatic 673	com/baidu/carlife/core/screen/video/g:c	()V
    //   282: aload_0
    //   283: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   286: putstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   289: aload_0
    //   290: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   293: putstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   296: aload 5
    //   298: invokevirtual 675	com/baidu/carlife/core/d:k	()I
    //   301: aload 5
    //   303: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   306: if_icmpne +484 -> 790
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   314: putfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   322: putfield 191	com/baidu/carlife/core/screen/video/e:ad	I
    //   325: iconst_1
    //   326: istore_1
    //   327: ldc_w 637
    //   330: aload_0
    //   331: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   334: aload_0
    //   335: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   338: invokestatic 681	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   341: astore 5
    //   343: aload 5
    //   345: ldc_w 683
    //   348: ldc_w 684
    //   351: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   354: aload 5
    //   356: ldc_w 690
    //   359: bipush 10
    //   361: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   364: aload 5
    //   366: ldc_w 692
    //   369: iconst_1
    //   370: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   373: aload 5
    //   375: ldc_w 694
    //   378: bipush 10
    //   380: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   383: aload 5
    //   385: ldc_w 696
    //   388: ldc2_w 697
    //   391: invokevirtual 702	android/media/MediaFormat:setLong	(Ljava/lang/String;J)V
    //   394: aload 5
    //   396: ldc_w 704
    //   399: ldc2_w 697
    //   402: invokevirtual 702	android/media/MediaFormat:setLong	(Ljava/lang/String;J)V
    //   405: aload_0
    //   406: ldc_w 705
    //   409: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   412: aload 5
    //   414: ldc_w 707
    //   417: aload_0
    //   418: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   421: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   424: aload 5
    //   426: ldc_w 709
    //   429: iconst_1
    //   430: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   433: aload 5
    //   435: ldc_w 711
    //   438: sipush 256
    //   441: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   444: aload_0
    //   445: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   448: aload 5
    //   450: aconst_null
    //   451: aconst_null
    //   452: iconst_1
    //   453: invokevirtual 715	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   456: iload_1
    //   457: ifne +112 -> 569
    //   460: ldc_w 637
    //   463: aload_0
    //   464: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   467: aload_0
    //   468: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   471: invokestatic 681	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   474: astore 5
    //   476: aload 5
    //   478: ldc_w 683
    //   481: ldc_w 684
    //   484: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   487: aload 5
    //   489: ldc_w 690
    //   492: bipush 10
    //   494: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   497: aload 5
    //   499: ldc_w 692
    //   502: iconst_1
    //   503: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   506: aload 5
    //   508: ldc_w 694
    //   511: bipush 10
    //   513: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   516: aload 5
    //   518: ldc_w 696
    //   521: ldc2_w 697
    //   524: invokevirtual 702	android/media/MediaFormat:setLong	(Ljava/lang/String;J)V
    //   527: aload 5
    //   529: ldc_w 704
    //   532: ldc2_w 697
    //   535: invokevirtual 702	android/media/MediaFormat:setLong	(Ljava/lang/String;J)V
    //   538: aload_0
    //   539: ldc_w 705
    //   542: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   545: aload 5
    //   547: ldc_w 707
    //   550: aload_0
    //   551: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   554: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   557: aload_0
    //   558: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   561: aload 5
    //   563: aconst_null
    //   564: aconst_null
    //   565: iconst_1
    //   566: invokevirtual 715	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   569: aload_0
    //   570: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   573: ifnull +10 -> 583
    //   576: aload_0
    //   577: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   580: invokevirtual 273	android/view/Surface:release	()V
    //   583: aload_0
    //   584: aload_0
    //   585: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   588: invokevirtual 718	android/media/MediaCodec:createInputSurface	()Landroid/view/Surface;
    //   591: putfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   594: aload_0
    //   595: getfield 268	com/baidu/carlife/core/screen/video/e:am	Landroid/view/Surface;
    //   598: invokestatic 723	com/baidu/carlife/core/screen/presentation/a/j:a	(Landroid/view/Surface;)V
    //   601: aload_0
    //   602: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   605: invokevirtual 724	android/media/MediaCodec:start	()V
    //   608: aload 4
    //   610: monitorexit
    //   611: aload_3
    //   612: monitorexit
    //   613: iconst_1
    //   614: ireturn
    //   615: astore 5
    //   617: aload 5
    //   619: invokevirtual 425	java/lang/IllegalStateException:printStackTrace	()V
    //   622: goto -568 -> 54
    //   625: astore 5
    //   627: aload 4
    //   629: monitorexit
    //   630: aload 5
    //   632: athrow
    //   633: astore 4
    //   635: aload_3
    //   636: monitorexit
    //   637: aload 4
    //   639: athrow
    //   640: astore 5
    //   642: aload 5
    //   644: invokevirtual 425	java/lang/IllegalStateException:printStackTrace	()V
    //   647: goto -581 -> 66
    //   650: astore 5
    //   652: aload 5
    //   654: invokevirtual 725	java/io/IOException:printStackTrace	()V
    //   657: aload 4
    //   659: monitorexit
    //   660: aload_3
    //   661: monitorexit
    //   662: iconst_0
    //   663: ireturn
    //   664: astore 5
    //   666: aload 5
    //   668: invokevirtual 726	java/lang/IllegalArgumentException:printStackTrace	()V
    //   671: aload 4
    //   673: monitorexit
    //   674: aload_3
    //   675: monitorexit
    //   676: iconst_0
    //   677: ireturn
    //   678: iload_1
    //   679: sipush 800
    //   682: if_icmplt +31 -> 713
    //   685: aload 5
    //   687: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   690: sipush 832
    //   693: if_icmplt +20 -> 713
    //   696: aload_0
    //   697: sipush 832
    //   700: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   703: aload_0
    //   704: sipush 480
    //   707: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   710: goto -578 -> 132
    //   713: aload_0
    //   714: aload 5
    //   716: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   719: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   722: aload_0
    //   723: aload 5
    //   725: invokevirtual 728	com/baidu/carlife/core/d:i	()I
    //   728: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   731: aload_0
    //   732: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   735: bipush 64
    //   737: irem
    //   738: ifeq +21 -> 759
    //   741: aload_0
    //   742: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   745: istore_1
    //   746: aload_0
    //   747: aload_0
    //   748: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   751: iload_1
    //   752: bipush 64
    //   754: irem
    //   755: isub
    //   756: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   759: aload_0
    //   760: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   763: bipush 32
    //   765: irem
    //   766: ifeq -634 -> 132
    //   769: aload_0
    //   770: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   773: istore_1
    //   774: aload_0
    //   775: aload_0
    //   776: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   779: iload_1
    //   780: bipush 32
    //   782: irem
    //   783: isub
    //   784: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   787: goto -655 -> 132
    //   790: aload 5
    //   792: invokevirtual 675	com/baidu/carlife/core/d:k	()I
    //   795: ifle +75 -> 870
    //   798: aload_0
    //   799: aload_0
    //   800: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   803: aload 5
    //   805: invokevirtual 675	com/baidu/carlife/core/d:k	()I
    //   808: imul
    //   809: aload 5
    //   811: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   814: idiv
    //   815: putfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   823: iconst_1
    //   824: iadd
    //   825: putfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   828: aload_0
    //   829: aload_0
    //   830: getfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   833: aload 5
    //   835: invokevirtual 730	com/baidu/carlife/core/d:l	()I
    //   838: imul
    //   839: aload 5
    //   841: invokevirtual 675	com/baidu/carlife/core/d:k	()I
    //   844: idiv
    //   845: putfield 191	com/baidu/carlife/core/screen/video/e:ad	I
    //   848: aload_0
    //   849: getfield 191	com/baidu/carlife/core/screen/video/e:ad	I
    //   852: aload_0
    //   853: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   856: if_icmple -531 -> 325
    //   859: aload_0
    //   860: aload_0
    //   861: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   864: putfield 191	com/baidu/carlife/core/screen/video/e:ad	I
    //   867: goto -542 -> 325
    //   870: aload_0
    //   871: aload_0
    //   872: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   875: putfield 189	com/baidu/carlife/core/screen/video/e:ac	I
    //   878: aload_0
    //   879: aload_0
    //   880: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   883: putfield 191	com/baidu/carlife/core/screen/video/e:ad	I
    //   886: goto -561 -> 325
    //   889: astore 5
    //   891: aload 5
    //   893: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   896: iconst_0
    //   897: istore_1
    //   898: goto -442 -> 456
    //   901: astore 5
    //   903: aload 5
    //   905: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   908: aload 4
    //   910: monitorexit
    //   911: aload_3
    //   912: monitorexit
    //   913: iconst_0
    //   914: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	this	e
    //   0	915	1	paramInt1	int
    //   0	915	2	paramInt2	int
    //   17	895	3	localObject1	Object
    //   24	604	4	localObject2	Object
    //   633	276	4	localObject3	Object
    //   40	522	5	localObject4	Object
    //   615	3	5	localIllegalStateException1	IllegalStateException
    //   625	6	5	localObject5	Object
    //   640	3	5	localIllegalStateException2	IllegalStateException
    //   650	3	5	localIOException	java.io.IOException
    //   664	176	5	localIllegalArgumentException	IllegalArgumentException
    //   889	3	5	localException1	Exception
    //   901	3	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   47	54	615	java/lang/IllegalStateException
    //   29	42	625	finally
    //   47	54	625	finally
    //   54	66	625	finally
    //   66	85	625	finally
    //   85	95	625	finally
    //   95	100	625	finally
    //   107	132	625	finally
    //   132	160	625	finally
    //   160	227	625	finally
    //   227	282	625	finally
    //   282	325	625	finally
    //   327	412	625	finally
    //   412	456	625	finally
    //   460	545	625	finally
    //   545	569	625	finally
    //   569	583	625	finally
    //   583	611	625	finally
    //   617	622	625	finally
    //   627	630	625	finally
    //   642	647	625	finally
    //   652	660	625	finally
    //   666	674	625	finally
    //   685	710	625	finally
    //   713	759	625	finally
    //   759	787	625	finally
    //   790	867	625	finally
    //   870	886	625	finally
    //   891	896	625	finally
    //   903	911	625	finally
    //   20	29	633	finally
    //   611	613	633	finally
    //   630	633	633	finally
    //   635	637	633	finally
    //   660	662	633	finally
    //   674	676	633	finally
    //   911	913	633	finally
    //   54	66	640	java/lang/IllegalStateException
    //   85	95	650	java/io/IOException
    //   85	95	664	java/lang/IllegalArgumentException
    //   412	456	889	java/lang/Exception
    //   545	569	901	java/lang/Exception
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt1 > 0)
    {
      i1 = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    else
    {
      i1 = 832;
      paramInt1 = c;
    }
    com.baidu.carlife.core.d locald = com.baidu.carlife.core.d.a();
    paramInt2 = locald.h();
    int i2 = locald.i();
    if (paramInt2 > i1)
    {
      this.ae = i1;
      if (i2 > paramInt1) {
        this.af = paramInt1;
      }
    }
    for (;;)
    {
      b = this.ae;
      c = this.af;
      paramInt1 = paramInt3;
      if (paramInt3 >= 15) {
        paramInt1 = 10;
      }
      if (paramInt1 > 2)
      {
        d = paramInt1;
        e = 1000 / paramInt1;
      }
      return true;
      this.af = i2;
      continue;
      this.ae = paramInt2;
      this.af = i2;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      c(true);
      return false;
    }
    c(false);
    return false;
  }
  
  void b(int paramInt)
  {
    if ((paramInt < 3) || (paramInt > 30)) {}
    for (;;)
    {
      return;
      d = paramInt;
      e = 1000 / paramInt;
      if (d <= 15) {
        try
        {
          if (!com.baidu.carlife.core.b.a.a())
          {
            if (this.C != null) {
              this.C.a(d);
            }
          }
          else if (this.D != null)
          {
            this.D.a(e / 2);
            return;
          }
        }
        catch (NullPointerException localNullPointerException) {}
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  /* Error */
  boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: iload_1
    //   10: ifle +7 -> 17
    //   13: iload_2
    //   14: ifgt +11 -> 25
    //   17: sipush 832
    //   20: istore_1
    //   21: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   24: istore_2
    //   25: iload_1
    //   26: sipush 800
    //   29: if_icmpge +25 -> 54
    //   32: iload_1
    //   33: bipush 64
    //   35: irem
    //   36: istore_2
    //   37: iload_2
    //   38: bipush 32
    //   40: if_icmplt +479 -> 519
    //   43: iload_1
    //   44: bipush 64
    //   46: iadd
    //   47: iload_2
    //   48: isub
    //   49: istore_1
    //   50: iload_1
    //   51: putstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   54: invokestatic 486	com/baidu/carlife/core/d:a	()Lcom/baidu/carlife/core/d;
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 643	com/baidu/carlife/core/d:h	()I
    //   64: istore_2
    //   65: aload 4
    //   67: invokevirtual 728	com/baidu/carlife/core/d:i	()I
    //   70: istore_1
    //   71: iload_2
    //   72: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   75: if_icmple +451 -> 526
    //   78: aload_0
    //   79: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   82: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   90: iload_1
    //   91: imul
    //   92: iload_2
    //   93: idiv
    //   94: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   97: aload_0
    //   98: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   101: istore_1
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   107: iload_1
    //   108: bipush 32
    //   110: irem
    //   111: isub
    //   112: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   115: aload_0
    //   116: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   119: putstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   122: aload_0
    //   123: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   126: putstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   129: iload_3
    //   130: iconst_2
    //   131: if_icmple +15 -> 146
    //   134: iload_3
    //   135: putstatic 121	com/baidu/carlife/core/screen/video/e:d	I
    //   138: sipush 1000
    //   141: iload_3
    //   142: idiv
    //   143: putstatic 123	com/baidu/carlife/core/screen/video/e:e	I
    //   146: ldc 16
    //   148: new 649	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 739
    //   158: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   164: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 741
    //   170: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   176: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 451	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_0
    //   186: ldc_w 637
    //   189: invokestatic 641	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   192: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   195: ldc_w 637
    //   198: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   201: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   204: invokestatic 681	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   207: astore 4
    //   209: aload 4
    //   211: ldc_w 683
    //   214: ldc_w 684
    //   217: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   220: aload 4
    //   222: ldc_w 690
    //   225: bipush 15
    //   227: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   230: aload 4
    //   232: ldc_w 692
    //   235: iconst_1
    //   236: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   239: aload_0
    //   240: getfield 163	com/baidu/carlife/core/screen/video/e:Q	Z
    //   243: ifeq +13 -> 256
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   251: iconst_1
    //   252: iadd
    //   253: putfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   256: aload_0
    //   257: iconst_0
    //   258: putfield 163	com/baidu/carlife/core/screen/video/e:Q	Z
    //   261: aload 4
    //   263: astore 5
    //   265: aload_0
    //   266: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   269: getstatic 125	com/baidu/carlife/core/screen/video/e:w	[I
    //   272: arraylength
    //   273: if_icmpge +97 -> 370
    //   276: aload_0
    //   277: getstatic 125	com/baidu/carlife/core/screen/video/e:w	[I
    //   280: aload_0
    //   281: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   284: iaload
    //   285: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   288: iconst_1
    //   289: istore_1
    //   290: aload 4
    //   292: ldc_w 707
    //   295: aload_0
    //   296: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   299: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   302: aload 4
    //   304: ldc_w 709
    //   307: iconst_1
    //   308: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   311: aload 4
    //   313: ldc_w 711
    //   316: sipush 256
    //   319: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   322: aload_0
    //   323: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   326: aload 4
    //   328: aconst_null
    //   329: aconst_null
    //   330: iconst_1
    //   331: invokevirtual 715	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   334: iload_1
    //   335: ifeq +281 -> 616
    //   338: ldc 16
    //   340: new 649	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 743
    //   350: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   357: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 451	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 4
    //   368: astore 5
    //   370: aload_0
    //   371: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   374: getstatic 125	com/baidu/carlife/core/screen/video/e:w	[I
    //   377: arraylength
    //   378: if_icmplt +377 -> 755
    //   381: iconst_1
    //   382: istore_1
    //   383: iload_1
    //   384: ifeq +13 -> 397
    //   387: aload_0
    //   388: iconst_0
    //   389: putfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   392: aload_0
    //   393: iconst_0
    //   394: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   397: iload_1
    //   398: ifeq +68 -> 466
    //   401: aload_0
    //   402: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   405: tableswitch	default:+27->432, 43:+355->760, 44:+365->770, 45:+375->780
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   437: iconst_1
    //   438: iadd
    //   439: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   442: aload 5
    //   444: ldc_w 707
    //   447: aload_0
    //   448: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   451: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   454: aload_0
    //   455: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   458: aload 5
    //   460: aconst_null
    //   461: aconst_null
    //   462: iconst_1
    //   463: invokevirtual 715	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   466: aload_0
    //   467: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   470: bipush 45
    //   472: if_icmpeq +12 -> 484
    //   475: aload_0
    //   476: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   479: bipush 46
    //   481: if_icmpne +338 -> 819
    //   484: ldc 16
    //   486: new 649	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 745
    //   496: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   503: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 451	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: aconst_null
    //   514: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   517: iconst_0
    //   518: ireturn
    //   519: iload_1
    //   520: iload_2
    //   521: isub
    //   522: istore_1
    //   523: goto -473 -> 50
    //   526: aload_0
    //   527: iload_2
    //   528: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   531: aload_0
    //   532: iload_1
    //   533: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   536: aload_0
    //   537: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   540: istore_2
    //   541: aload_0
    //   542: aload_0
    //   543: getfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   546: iload_2
    //   547: bipush 64
    //   549: irem
    //   550: isub
    //   551: putfield 193	com/baidu/carlife/core/screen/video/e:ae	I
    //   554: aload_0
    //   555: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   558: istore_2
    //   559: aload_0
    //   560: aload_0
    //   561: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   564: iload_2
    //   565: bipush 32
    //   567: irem
    //   568: isub
    //   569: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   572: aload_0
    //   573: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   576: iload_1
    //   577: if_icmple -462 -> 115
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   585: bipush 32
    //   587: isub
    //   588: putfield 195	com/baidu/carlife/core/screen/video/e:af	I
    //   591: goto -476 -> 115
    //   594: astore 4
    //   596: aload 4
    //   598: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   601: goto -406 -> 195
    //   604: astore 5
    //   606: iconst_0
    //   607: istore_1
    //   608: aload 5
    //   610: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   613: goto -279 -> 334
    //   616: ldc_w 637
    //   619: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   622: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   625: invokestatic 681	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   628: astore 5
    //   630: aload 5
    //   632: astore 4
    //   634: aload 5
    //   636: ldc_w 683
    //   639: ldc_w 684
    //   642: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   645: aload 5
    //   647: astore 4
    //   649: aload 5
    //   651: ldc_w 690
    //   654: bipush 15
    //   656: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   659: aload 5
    //   661: astore 4
    //   663: aload 5
    //   665: ldc_w 692
    //   668: iconst_1
    //   669: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   672: aload 5
    //   674: astore 4
    //   676: aload 5
    //   678: ldc_w 707
    //   681: aload_0
    //   682: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   685: invokevirtual 688	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   688: aload 5
    //   690: astore 4
    //   692: aload_0
    //   693: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   696: aload 5
    //   698: aconst_null
    //   699: aconst_null
    //   700: iconst_1
    //   701: invokevirtual 715	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   704: ldc 16
    //   706: new 649	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 747
    //   716: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_0
    //   720: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   723: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 451	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: goto -362 -> 370
    //   735: astore 5
    //   737: aload 5
    //   739: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   742: aload_0
    //   743: aload_0
    //   744: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   747: iconst_1
    //   748: iadd
    //   749: putfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   752: goto -491 -> 261
    //   755: iconst_0
    //   756: istore_1
    //   757: goto -374 -> 383
    //   760: aload_0
    //   761: ldc_w 748
    //   764: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   767: goto -325 -> 442
    //   770: aload_0
    //   771: ldc_w 749
    //   774: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   777: goto -335 -> 442
    //   780: aload_0
    //   781: ldc_w 705
    //   784: putfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   787: goto -345 -> 442
    //   790: astore 4
    //   792: aload 4
    //   794: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   797: aload_0
    //   798: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   801: bipush 46
    //   803: if_icmpge -337 -> 466
    //   806: aload_0
    //   807: aload_0
    //   808: getfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   811: iconst_1
    //   812: iadd
    //   813: putfield 131	com/baidu/carlife/core/screen/video/e:x	I
    //   816: goto -419 -> 397
    //   819: aload_0
    //   820: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   823: invokevirtual 724	android/media/MediaCodec:start	()V
    //   826: aload_0
    //   827: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   830: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   833: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   836: iconst_0
    //   837: invokestatic 326	com/baidu/carlife/core/screen/video/JniMethod:prepare	(IIIZ)V
    //   840: aload_0
    //   841: getfield 143	com/baidu/carlife/core/screen/video/e:G	Z
    //   844: ifeq +20 -> 864
    //   847: aload_0
    //   848: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   851: getstatic 117	com/baidu/carlife/core/screen/video/e:b	I
    //   854: getstatic 119	com/baidu/carlife/core/screen/video/e:c	I
    //   857: aload_0
    //   858: getfield 145	com/baidu/carlife/core/screen/video/e:H	Z
    //   861: invokestatic 326	com/baidu/carlife/core/screen/video/JniMethod:prepare	(IIIZ)V
    //   864: ldc 16
    //   866: new 649	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 650	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 751
    //   876: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_0
    //   880: getfield 133	com/baidu/carlife/core/screen/video/e:y	I
    //   883: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   886: invokevirtual 667	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 255	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: invokestatic 241	com/baidu/carlife/core/b/a:a	()Z
    //   895: ifeq +3 -> 898
    //   898: iconst_1
    //   899: ireturn
    //   900: astore 4
    //   902: aload_0
    //   903: getfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   906: invokevirtual 433	android/media/MediaCodec:release	()V
    //   909: aload_0
    //   910: aconst_null
    //   911: putfield 362	com/baidu/carlife/core/screen/video/e:B	Landroid/media/MediaCodec;
    //   914: iconst_0
    //   915: ireturn
    //   916: astore 4
    //   918: aload 4
    //   920: invokevirtual 425	java/lang/IllegalStateException:printStackTrace	()V
    //   923: goto -14 -> 909
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	e
    //   0	926	1	paramInt1	int
    //   0	926	2	paramInt2	int
    //   0	926	3	paramInt3	int
    //   57	310	4	localObject1	Object
    //   594	3	4	localException1	Exception
    //   632	59	4	localObject2	Object
    //   790	3	4	localException2	Exception
    //   900	1	4	localIllegalStateException1	IllegalStateException
    //   916	3	4	localIllegalStateException2	IllegalStateException
    //   263	196	5	localObject3	Object
    //   604	5	5	localException3	Exception
    //   628	69	5	localMediaFormat	android.media.MediaFormat
    //   735	3	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   185	195	594	java/lang/Exception
    //   290	334	604	java/lang/Exception
    //   616	630	735	java/lang/Exception
    //   634	645	735	java/lang/Exception
    //   649	659	735	java/lang/Exception
    //   663	672	735	java/lang/Exception
    //   676	688	735	java/lang/Exception
    //   692	704	735	java/lang/Exception
    //   442	466	790	java/lang/Exception
    //   819	826	900	java/lang/IllegalStateException
    //   902	909	916	java/lang/IllegalStateException
  }
  
  public void c(boolean paramBoolean)
  {
    if ((d < 15) || (this.P)) {}
    do
    {
      for (;;)
      {
        return;
        if (paramBoolean) {
          this.aa.removeMessages(1);
        }
        try
        {
          if (!com.baidu.carlife.core.b.a.a())
          {
            if (this.C != null) {
              this.C.a(d);
            }
          }
          else if (this.D != null)
          {
            this.D.a(e / 2);
            return;
          }
        }
        catch (NullPointerException localNullPointerException) {}
      }
    } while (this.aa == null);
    this.aa.sendEmptyMessageDelayed(1, 2000L);
    return;
  }
  
  boolean c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f != null)
    {
      i.e("Recorder", "重复调用了initMediaCodec50TextureView");
      return true;
    }
    a(paramInt1, paramInt2, paramInt3);
    this.f = Bitmap.createBitmap(b, c, Bitmap.Config.ARGB_8888);
    return true;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.H == paramBoolean) || (this.Y == null)) {}
    for (;;)
    {
      return;
      this.H = paramBoolean;
      if (paramBoolean)
      {
        this.Y.putInt("needRectifyColor", 1);
        this.Y.commit();
      }
      while (this.y != 0)
      {
        JniMethod.prepare(this.y, b, c, paramBoolean);
        return;
        this.Y.putInt("needRectifyColor", 0);
        this.Y.commit();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.ah = paramBoolean;
  }
  
  public boolean e()
  {
    return this.K;
  }
  
  void f()
  {
    this.L = true;
    this.K = true;
  }
  
  void f(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  void g()
  {
    this.L = false;
    if (this.D != null) {
      this.D.a(true);
    }
    S();
  }
  
  void g(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void h()
  {
    this.M = true;
    this.K = true;
  }
  
  void h(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void i()
  {
    if (this.R) {
      P();
    }
    this.M = false;
    if (this.D != null) {
      this.D.a(true);
    }
    S();
  }
  
  void i(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public boolean j()
  {
    return this.P;
  }
  
  public boolean k()
  {
    if (this.P) {}
    while (!com.baidu.carlife.core.connect.d.a().c()) {
      return false;
    }
    return this.G;
  }
  
  public boolean l()
  {
    return this.H;
  }
  
  public void m()
  {
    if (com.baidu.carlife.core.b.a.a()) {
      i.b("Recorder", " onActivityPause internal screen capture ");
    }
    for (;;)
    {
      if ((o()) && (this.aa != null)) {
        this.aa.postDelayed(new Runnable()
        {
          public void run()
          {
            if (e.this.o()) {
              e.this.a(3);
            }
          }
        }, 300L);
      }
      return;
      i.b("Recorder", " onActivityPause fullscreen capture, Invoke's Recorder pauseFromMobile() ");
      c(false);
      h();
    }
  }
  
  public boolean n()
  {
    return (com.baidu.carlife.core.b.a.a()) || (!this.ag) || (this.ak != null) || (j());
  }
  
  public boolean o()
  {
    return this.ah;
  }
  
  public void p()
  {
    U();
    H();
  }
  
  int q()
  {
    return this.y;
  }
  
  boolean r()
  {
    return this.I;
  }
  
  boolean s()
  {
    return this.N;
  }
  
  int t()
  {
    return this.z;
  }
  
  long u()
  {
    return this.A;
  }
  
  void v()
  {
    i.b("Recorder", "setInputThreadNull...");
    this.C = null;
  }
  
  MediaCodec w()
  {
    return this.B;
  }
  
  Object x()
  {
    return this.S;
  }
  
  Object y()
  {
    return this.T;
  }
  
  long z()
  {
    this.V += 300000L;
    return this.V;
  }
  
  private class a
    extends MediaProjection.Callback
  {
    private a() {}
    
    public void onStop()
    {
      e.a(e.this, null);
      e.f(e.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */