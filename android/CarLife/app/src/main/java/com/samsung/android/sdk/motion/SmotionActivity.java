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

public class SmotionActivity
{
  private static boolean i;
  private static Smotion o = null;
  private static final Object q = new Object();
  private Info a;
  private int b;
  private long c;
  private ChangeListener d = null;
  private a e = null;
  private SContextListener f = null;
  private PowerManager g;
  private Display h;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private Timer m = null;
  private long n = 3000L;
  private boolean p = false;
  
  public SmotionActivity(Looper arg1, Smotion paramSmotion)
  {
    if (??? == null) {
      throw new NullPointerException("SmotionActivity : Looper is null. ");
    }
    if (paramSmotion == null) {
      throw new NullPointerException("SmotionActivity : Smotion is null. ");
    }
    if (paramSmotion.d == null) {
      throw new IllegalArgumentException("SmotionActivity : Smotion.initialize() is not called. ");
    }
    if (!paramSmotion.a) {
      throw new IllegalStateException("SmotionActivity : Smotion.initialize() is not successful. ");
    }
    this.e = new a(???);
    boolean bool;
    synchronized (q)
    {
      o = paramSmotion;
      bool = o.isFeatureEnabled(3);
    }
    synchronized (q)
    {
      i = bool;
      this.g = ((PowerManager)paramSmotion.d.getSystemService("power"));
      this.h = ((WindowManager)paramSmotion.d.getSystemService("window")).getDefaultDisplay();
      if (!i)
      {
        throw new IllegalStateException("SmotionActivity : This device is not supported. ");
        paramSmotion = finally;
        throw paramSmotion;
      }
    }
  }
  
  private void c()
  {
    this.l = false;
    if (this.m != null)
    {
      this.m.cancel();
      this.m = null;
    }
  }
  
  private boolean d()
  {
    if (Build.VERSION.SDK_INT > 19)
    {
      if (this.h.getState() == 2) {
        return true;
      }
      if (this.h.getState() == 1) {
        return false;
      }
    }
    else
    {
      return this.g.isScreenOn();
    }
    return false;
  }
  
  public Info getInfo()
  {
    if (this.d == null) {
      throw new IllegalStateException("SmotionActivity : start() is not called. ");
    }
    if ((this.b == 2) || (!this.j)) {
      return null;
    }
    if (!d())
    {
      this.k = false;
      updateInfo();
      if (this.m == null)
      {
        this.m = new Timer();
        this.m.schedule(new b((byte)0), this.n);
      }
      if (!this.k) {
        break label109;
      }
    }
    for (;;)
    {
      this.k = false;
      c();
      return this.a;
      label109:
      if (!this.l) {
        break;
      }
      Log.d("SmotionActivity", "SmotionActivity : getInfo() Time out !!");
    }
  }
  
  public boolean isActivitySupported(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("SmotionActivity : activity value is wrong!!");
    }
    switch (paramInt)
    {
    default: 
      return false;
    }
    return Smotion.c;
  }
  
  public boolean isUpdateInfoBatchModeSupport()
  {
    return Smotion.b;
  }
  
  public void start(int paramInt, ChangeListener paramChangeListener)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("SmotionActivity : Mode value is wrong. ");
    }
    this.b = paramInt;
    if (paramChangeListener == null) {
      throw new IllegalArgumentException("SmotionActivity : ChangeListener is null. ");
    }
    if (!i) {
      throw new IllegalStateException("SmotionActivity : This device is not supported. ");
    }
    if (this.d == null)
    {
      this.d = paramChangeListener;
      this.a = new Info();
      if (paramChangeListener != null) {
        break label144;
      }
      paramChangeListener = null;
      this.f = paramChangeListener;
      if (this.b != 1) {
        break label157;
      }
      this.e.registerListener(this.f, 25);
      this.p = true;
      updateInfo();
    }
    for (;;)
    {
      try
      {
        o.a(o.d, "SmotionActivity.start()");
        return;
      }
      catch (SecurityException paramChangeListener)
      {
        label144:
        label157:
        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
      }
      throw new IllegalStateException("SmotionActivity : ChangeListener is already registered. ");
      paramChangeListener = new a(this, paramChangeListener);
      break;
      if (this.b == 2)
      {
        this.e.registerListener(this.f, 26);
        this.c = System.currentTimeMillis();
      }
      else if (this.b == 0)
      {
        this.e.registerListener(this.f, 25);
        this.p = true;
        updateInfo();
        this.e.registerListener(this.f, 26);
      }
    }
  }
  
  public void stop()
  {
    if (this.d == null) {
      throw new IllegalStateException("SmotionActivity : start() is not called. ");
    }
    if (this.e != null)
    {
      if (this.b != 1) {
        break label75;
      }
      this.e.unregisterListener(this.f, 25);
    }
    for (;;)
    {
      c();
      this.b = -1;
      this.d = null;
      this.a = null;
      this.f = null;
      this.p = false;
      return;
      label75:
      if (this.b == 2)
      {
        this.e.unregisterListener(this.f, 26);
      }
      else if (this.b == 0)
      {
        this.e.unregisterListener(this.f, 25);
        this.e.unregisterListener(this.f, 26);
      }
    }
  }
  
  public void updateInfo()
  {
    if (this.f == null) {
      throw new IllegalStateException("SmotionActivity : start() is not called. ");
    }
    if (this.b == 1) {
      if (d()) {
        if (this.p)
        {
          this.e.requestToUpdate(this.f, 25);
          this.p = false;
          break label57;
        }
      }
    }
    for (;;)
    {
      label57:
      return;
      if (this.a != null)
      {
        Info localInfo = this.a;
        this.d.onChanged(this.b, new Info[] { localInfo });
        return;
        this.e.requestToUpdate(this.f, 25);
        return;
        if (this.b == 2)
        {
          if (!isUpdateInfoBatchModeSupport()) {
            break;
          }
          this.e.requestToUpdate(this.f, 26);
          return;
        }
        if (this.b != 0) {
          break;
        }
        if (d())
        {
          if (this.p)
          {
            this.e.requestToUpdate(this.f, 25);
            this.p = false;
            return;
          }
          if (this.a != null)
          {
            localInfo = this.a;
            this.d.onChanged(1, new Info[] { localInfo });
          }
        }
        while (isUpdateInfoBatchModeSupport())
        {
          this.e.requestToUpdate(this.f, 26);
          return;
          this.e.requestToUpdate(this.f, 25);
        }
      }
    }
  }
  
  public static abstract interface ChangeListener
  {
    public abstract void onChanged(int paramInt, SmotionActivity.Info[] paramArrayOfInfo);
  }
  
  public static class Info
  {
    public static final int ACCURACY_HIGH = 2;
    public static final int ACCURACY_LOW = 0;
    public static final int ACCURACY_MID = 1;
    public static final int MODE_ALL = 0;
    public static final int MODE_BATCH = 2;
    public static final int MODE_REALTIME = 1;
    public static final int STATUS_RUN = 3;
    public static final int STATUS_STATIONARY = 1;
    public static final int STATUS_UNKNOWN = 0;
    public static final int STATUS_VEHICLE = 4;
    public static final int STATUS_WALK = 2;
    private int a;
    private int b;
    private long c;
    
    public Info()
    {
      if (SmotionActivity.a() == null) {
        throw new IllegalStateException("SmotionActivity.Info : SmotionActivity is not created. ");
      }
      if (!SmotionActivity.b()) {
        throw new IllegalStateException("SmotionActivity.Info : This device is not supported. ");
      }
    }
    
    public int getAccuracy()
    {
      return this.b;
    }
    
    public int getStatus()
    {
      return this.a;
    }
    
    public long getTimeStamp()
    {
      return this.c;
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
      SmotionActivity.a(SmotionActivity.this, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/SmotionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */