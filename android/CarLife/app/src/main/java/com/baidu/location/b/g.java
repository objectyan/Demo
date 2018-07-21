package com.baidu.location.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.baidu.location.a.e;
import com.baidu.location.a.m;
import com.baidu.location.c.b;
import com.baidu.location.e.d;
import com.baidu.location.indoor.a;

public class g
{
  private static g b = null;
  final Handler a = new Handler();
  private a c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private b i = new b(null);
  
  public static g a()
  {
    try
    {
      if (b == null) {
        b = new g();
      }
      g localg = b;
      return localg;
    }
    finally {}
  }
  
  private void f()
  {
    Object localObject = NetworkInfo.State.UNKNOWN;
    try
    {
      NetworkInfo.State localState = ((ConnectivityManager)com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
      localObject = localState;
    }
    catch (Exception localException)
    {
      for (;;) {}
      this.d = true;
      this.a.postDelayed(this.i, com.baidu.location.h.g.P);
      this.f = true;
      return;
    }
    if (NetworkInfo.State.CONNECTED == localObject) {
      if (this.d) {
        return;
      }
    }
    this.d = false;
  }
  
  private void g()
  {
    d.a().n();
    d.a().j();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 124	com/baidu/location/f:isServing	Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 44	com/baidu/location/b/g:h	Z
    //   17: istore_1
    //   18: iload_1
    //   19: ifne -9 -> 10
    //   22: aload_0
    //   23: new 8	com/baidu/location/b/g$a
    //   26: dup
    //   27: aload_0
    //   28: aconst_null
    //   29: invokespecial 125	com/baidu/location/b/g$a:<init>	(Lcom/baidu/location/b/g;Lcom/baidu/location/b/g$1;)V
    //   32: putfield 34	com/baidu/location/b/g:c	Lcom/baidu/location/b/g$a;
    //   35: new 127	android/content/IntentFilter
    //   38: dup
    //   39: invokespecial 128	android/content/IntentFilter:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc -126
    //   46: invokevirtual 134	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   49: invokestatic 77	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 34	com/baidu/location/b/g:c	Lcom/baidu/location/b/g$a;
    //   56: aload_2
    //   57: invokevirtual 138	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   60: pop
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield 38	com/baidu/location/b/g:e	Z
    //   66: aload_0
    //   67: invokespecial 63	com/baidu/location/b/g:f	()V
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 42	com/baidu/location/b/g:g	Z
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 44	com/baidu/location/b/g:h	Z
    //   80: goto -70 -> 10
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    //   88: astore_2
    //   89: goto -19 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	g
    //   5	14	1	bool	boolean
    //   42	15	2	localIntentFilter	android.content.IntentFilter
    //   83	4	2	localObject	Object
    //   88	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	6	83	finally
    //   13	18	83	finally
    //   22	70	83	finally
    //   70	80	83	finally
    //   22	70	88	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/baidu/location/b/g:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 77	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 34	com/baidu/location/b/g:c	Lcom/baidu/location/b/g$a;
    //   21: invokevirtual 142	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 42	com/baidu/location/b/g:g	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 44	com/baidu/location/b/g:h	Z
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 40	com/baidu/location/b/g:f	Z
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 34	com/baidu/location/b/g:c	Lcom/baidu/location/b/g$a;
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: astore_2
    //   53: goto -29 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	g
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    //   52	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	24	47	finally
    //   24	44	47	finally
    //   14	24	52	java/lang/Exception
  }
  
  public void d()
  {
    if (!this.h) {}
    do
    {
      return;
      this.g = true;
    } while ((this.f) || (!this.g));
    this.a.postDelayed(this.i, com.baidu.location.h.g.P);
    this.f = true;
  }
  
  public void e()
  {
    this.g = false;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramContext == null) || (g.this.a == null)) {
        return;
      }
      g.d(g.this);
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      int i = e.a().d();
      if ((g.a(g.this)) && (c.a().e()) && (d.a().d()) && (i != 1)) {
        g.b(g.this);
      }
      if ((g.a(g.this)) && (c.a().e())) {
        f.a().c();
      }
      if ((g.a(g.this)) && (c.a().e()) && (i != 1))
      {
        com.baidu.location.d.g.a().f();
        new a(com.baidu.location.f.getServiceContext()).d();
      }
      if ((g.a(g.this)) && (g.c(g.this)))
      {
        if (i != 1)
        {
          m.a().e();
          m.a().c();
          b.a().b();
        }
        g.this.a.postDelayed(this, com.baidu.location.h.g.P);
        g.a(g.this, true);
        return;
      }
      g.a(g.this, false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */