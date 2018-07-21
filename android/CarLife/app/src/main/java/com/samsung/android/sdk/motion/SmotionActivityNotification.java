package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextManager;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;

public class SmotionActivityNotification
{
  private static boolean d;
  private static Smotion e = null;
  private static final Object f = new Object();
  private ChangeListener a = null;
  private a b = null;
  private SContextListener c = null;
  
  public SmotionActivityNotification(Looper arg1, Smotion paramSmotion)
  {
    if (??? == null) {
      throw new NullPointerException("SmotionActivityNotification : Looper is null. ");
    }
    if (paramSmotion == null) {
      throw new NullPointerException("SmotionActivityNotification : Smotion is null. ");
    }
    if (paramSmotion.d == null) {
      throw new IllegalArgumentException("SmotionActivityNotification : Smotion.initialize() is not called. ");
    }
    if (!paramSmotion.a) {
      throw new IllegalStateException("SmotionActivityNotification : Smotion.initialize() is not successful.");
    }
    this.b = new a(???);
    boolean bool;
    synchronized (f)
    {
      e = paramSmotion;
      bool = e.isFeatureEnabled(4);
    }
    synchronized (f)
    {
      d = bool;
      if (!d)
      {
        throw new IllegalStateException("SmotionActivityNotification : This device is not supported. ");
        paramSmotion = finally;
        throw paramSmotion;
      }
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
  
  public void start(InfoFilter paramInfoFilter, ChangeListener paramChangeListener)
  {
    if (paramInfoFilter == null) {
      throw new IllegalArgumentException("SmotionActivityNotification : InfoFilter is null.");
    }
    if (InfoFilter.a(paramInfoFilter).isEmpty()) {
      throw new IllegalArgumentException("SmotionActivityNotification : InfoFilter is empty.");
    }
    if (paramChangeListener == null) {
      throw new IllegalArgumentException("SmotionActivityNotification : ChangeListener is null.");
    }
    int[] arrayOfInt = new int[InfoFilter.a(paramInfoFilter).size()];
    if (this.a == null)
    {
      this.a = paramChangeListener;
      if (!d) {
        throw new IllegalStateException("SmotionActivityNotification : This device is not supported.");
      }
    }
    else
    {
      throw new IllegalStateException("SmotionActivityNotification : ChangeListener is already registered.");
    }
    int i = 0;
    if (i >= InfoFilter.a(paramInfoFilter).size()) {
      if (paramChangeListener != null) {
        break label177;
      }
    }
    label177:
    for (paramInfoFilter = null;; paramInfoFilter = new b(this, paramChangeListener))
    {
      this.c = paramInfoFilter;
      this.b.registerListener(this.c, 27, arrayOfInt);
      try
      {
        e.a(e.d, "SmotionActivityNotification.start()");
        return;
      }
      catch (SecurityException paramInfoFilter)
      {
        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
      }
      arrayOfInt[i] = ((Integer)InfoFilter.a(paramInfoFilter).get(i)).intValue();
      i += 1;
      break;
    }
  }
  
  public void stop()
  {
    if (this.a == null) {
      throw new IllegalStateException("SmotionActivityNotification : start() is not called");
    }
    if (this.b != null) {
      this.b.unregisterListener(this.c, 27);
    }
    this.a = null;
    this.c = null;
  }
  
  public static abstract interface ChangeListener
  {
    public abstract void onChanged(SmotionActivityNotification.Info paramInfo);
  }
  
  public static class Info
  {
    public static final int ACCURACY_HIGH = 2;
    public static final int ACCURACY_LOW = 0;
    public static final int ACCURACY_MID = 1;
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
      if (SmotionActivityNotification.a() == null) {
        throw new IllegalStateException("SmotionActivityNotification.Info : SmotionActivityNotification is not created. ");
      }
      if (!SmotionActivityNotification.b()) {
        throw new IllegalStateException("SmotionActivityNotification.Info : This device is not supported. ");
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
  
  public static class InfoFilter
  {
    private ArrayList a = null;
    
    public InfoFilter()
    {
      if (SmotionActivityNotification.a() == null) {
        throw new IllegalStateException("SmotionActivityNotification.InfoFilter : SmotionActivityNotification is not created. ");
      }
      if (!SmotionActivityNotification.b()) {
        throw new IllegalStateException("SmotionActivityNotification.InfoFilter : This device is not supported. ");
      }
      this.a = new ArrayList();
    }
    
    public void addActivity(int paramInt)
    {
      if (this.a == null) {
        throw new IllegalStateException("SmotionActivityNotification.InfoFilter : InfoFilter is not created.");
      }
      if ((paramInt > 4) || (paramInt <= 0))
      {
        Log.e("SmotionActivityNotification", "This activity type is not supported.");
        throw new IllegalArgumentException("SmotionActivityNotification.InfoFilter : This activity type is invalid.");
      }
      int i = 0;
      for (;;)
      {
        if (i >= this.a.size())
        {
          this.a.add(Integer.valueOf(paramInt));
          return;
        }
        if (((Integer)this.a.get(i)).intValue() == paramInt)
        {
          Log.e("SmotionActivityNotification", "This activity type is duplicated.");
          return;
        }
        i += 1;
      }
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/SmotionActivityNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */