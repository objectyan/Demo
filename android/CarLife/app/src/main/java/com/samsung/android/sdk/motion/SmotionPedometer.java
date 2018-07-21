package com.samsung.android.sdk.motion;

import android.content.Context;
import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextManager;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;

public class SmotionPedometer
{
  private static boolean f;
  private static Smotion l = null;
  private static final Object n = new Object();
  private Info a;
  private a b;
  private ChangeListener c = null;
  private SContextListener d = null;
  private PowerManager e;
  private boolean g = false;
  private Timer h = null;
  private boolean i = false;
  private boolean j = false;
  private long k = 3000L;
  private boolean m = false;
  private Display o;
  
  public SmotionPedometer(Looper arg1, Smotion paramSmotion)
  {
    if (??? == null) {
      throw new NullPointerException("SmotionPedometer : Looper is null. ");
    }
    if (paramSmotion == null) {
      throw new NullPointerException("SmotionPedometer : Smotion is null. ");
    }
    if (paramSmotion.d == null) {
      throw new IllegalArgumentException("SmotionPedometer : Smotion.initialize() is not called. ");
    }
    if (!paramSmotion.a) {
      throw new IllegalStateException("SmotionPedometer : Smotion.initialize() is not successful. ");
    }
    this.b = new a(???);
    boolean bool;
    synchronized (n)
    {
      l = paramSmotion;
      bool = l.isFeatureEnabled(1);
    }
    synchronized (n)
    {
      f = bool;
      this.e = ((PowerManager)paramSmotion.d.getSystemService("power"));
      this.o = ((WindowManager)paramSmotion.d.getSystemService("window")).getDefaultDisplay();
      if (!f)
      {
        throw new IllegalStateException("SmotionPedometer : This device is not supported. ");
        paramSmotion = finally;
        throw paramSmotion;
      }
    }
  }
  
  private boolean c()
  {
    if (Build.VERSION.SDK_INT > 19)
    {
      if (this.o.getState() == 2) {
        return true;
      }
      if (this.o.getState() == 1) {
        return false;
      }
    }
    else
    {
      return this.e.isScreenOn();
    }
    return false;
  }
  
  private void d()
  {
    this.g = false;
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
  }
  
  public Info getInfo()
  {
    if (this.c == null) {
      throw new IllegalStateException("SmotionPedometer : start() is not called. ");
    }
    if (!c())
    {
      this.i = false;
      updateInfo();
      if (this.h == null)
      {
        this.h = new Timer();
        this.h.schedule(new b((byte)0), this.k);
      }
      if (!this.i) {
        break label96;
      }
    }
    for (;;)
    {
      this.i = false;
      d();
      if (this.j) {
        break label114;
      }
      return null;
      label96:
      if (!this.g) {
        break;
      }
      Log.d("SmotionPedometer", "SmotionPedometer : getInfo() Time out !!");
    }
    label114:
    return this.a;
  }
  
  public void start(ChangeListener paramChangeListener)
  {
    if (paramChangeListener == null) {
      throw new IllegalArgumentException("SmotionPedometer : Listener is null. ");
    }
    if (!f) {
      throw new IllegalStateException("SmotionPedometer : This device is not supported. ");
    }
    if (this.c == null)
    {
      this.c = paramChangeListener;
      this.a = new Info();
      if (paramChangeListener != null) {
        break label111;
      }
    }
    label111:
    for (paramChangeListener = null;; paramChangeListener = new d(this, paramChangeListener))
    {
      this.d = paramChangeListener;
      this.b.registerListener(this.d, 2);
      this.m = true;
      updateInfo();
      try
      {
        l.a(l.d, "SmotionPedometer.start()");
        return;
      }
      catch (SecurityException paramChangeListener)
      {
        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
      }
      throw new IllegalStateException("SmotionPedometer : ChangeListener is already registered. ");
    }
  }
  
  public void stop()
  {
    if (this.c == null) {
      throw new IllegalStateException("SmotionPedometer : start() is not called. ");
    }
    if (this.b != null) {
      this.b.unregisterListener(this.d, 2);
    }
    d();
    this.c = null;
    this.a = null;
    this.d = null;
  }
  
  public void updateInfo()
  {
    if (this.d == null) {
      throw new IllegalStateException("SmotionPedometer : start() is not called. ");
    }
    if (c())
    {
      if (this.m)
      {
        this.b.requestToUpdate(this.d, 2);
        this.m = false;
      }
      while (this.a == null) {
        return;
      }
      this.c.onChanged(this.a);
      return;
    }
    this.b.requestToUpdate(this.d, 2);
  }
  
  public static abstract interface ChangeListener
  {
    public abstract void onChanged(SmotionPedometer.Info paramInfo);
  }
  
  public static class Info
  {
    public static final int COUNT_RUN_DOWN = 5;
    public static final int COUNT_RUN_FLAT = 6;
    public static final int COUNT_RUN_UP = 4;
    public static final int COUNT_TOTAL = 0;
    public static final int COUNT_WALK_DOWN = 2;
    public static final int COUNT_WALK_FLAT = 3;
    public static final int COUNT_WALK_UP = 1;
    public static final int STATUS_RUN_DOWN = 5;
    public static final int STATUS_RUN_FLAT = 6;
    public static final int STATUS_RUN_UP = 4;
    public static final int STATUS_STOP = 0;
    public static final int STATUS_UNKNOWN = -1;
    public static final int STATUS_WALK_DOWN = 2;
    public static final int STATUS_WALK_FLAT = 3;
    public static final int STATUS_WALK_UP = 1;
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private double h;
    private double i;
    private double j;
    private int k;
    private long l;
    
    public Info()
    {
      if (SmotionPedometer.a() == null) {
        throw new IllegalStateException("SmotionPedometer.Info : SmotionPedometer is not created. ");
      }
      if (!SmotionPedometer.b()) {
        throw new IllegalStateException("SmotionPedometer.Info : This device is not supported. ");
      }
    }
    
    public double getCalorie()
    {
      return this.j;
    }
    
    public long getCount(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 6)) {
        throw new IllegalArgumentException("SmotionPedometer : type value is wrong. ");
      }
      switch (paramInt)
      {
      default: 
        return 0L;
      case 0: 
        return this.a;
      case 1: 
        return this.b;
      case 2: 
        return this.c;
      case 3: 
        return this.d;
      case 4: 
        return this.e;
      case 5: 
        return this.f;
      }
      return this.g;
    }
    
    public double getDistance()
    {
      return this.i;
    }
    
    public double getSpeed()
    {
      return this.h;
    }
    
    public int getStatus()
    {
      return this.k;
    }
    
    public long getTimeStamp()
    {
      return this.l;
    }
  }
  
  private static final class a
    extends SContextManager
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final boolean registerListener(SContextListener paramSContextListener, int paramInt)
    {
      return super.registerListener(paramSContextListener, paramInt);
    }
    
    public final void unregisterListener(SContextListener paramSContextListener)
    {
      super.unregisterListener(paramSContextListener);
    }
    
    public final void unregisterListener(SContextListener paramSContextListener, int paramInt)
    {
      super.unregisterListener(paramSContextListener, paramInt);
    }
  }
  
  private final class b
    extends TimerTask
  {
    private b() {}
    
    public final void run()
    {
      SmotionPedometer.a(SmotionPedometer.this, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/SmotionPedometer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */