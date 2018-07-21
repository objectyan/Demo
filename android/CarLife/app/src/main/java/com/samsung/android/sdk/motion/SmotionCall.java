package com.samsung.android.sdk.motion;

import android.hardware.motion.MRListener;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Looper;

public class SmotionCall
{
  public static final int POSITION_LEFT = 0;
  public static final int POSITION_RIGHT = 1;
  private static final Object d = new Object();
  private static boolean e;
  private static Smotion f = null;
  private a a;
  private ChangeListener b = null;
  private MRListener c = null;
  
  public SmotionCall(Looper arg1, Smotion paramSmotion)
    throws NullPointerException, IllegalArgumentException
  {
    if (??? == null) {
      throw new NullPointerException("SmotionCall : Looper is null. ");
    }
    if (paramSmotion == null) {
      throw new NullPointerException("SmotionCall : Smotion is null. ");
    }
    if (paramSmotion.d == null) {
      throw new IllegalArgumentException("SmotionCall : Smotion.initialize() is not called. ");
    }
    if (!paramSmotion.a) {
      throw new IllegalStateException("SmotionCall : Smotion.initialize() is not successful. ");
    }
    this.a = new a(???);
    boolean bool;
    synchronized (d)
    {
      f = paramSmotion;
      bool = f.isFeatureEnabled(0);
    }
    synchronized (d)
    {
      e = bool;
      if (!e)
      {
        throw new IllegalStateException("SmotionCall : This device is not supported. ");
        paramSmotion = finally;
        throw paramSmotion;
      }
    }
  }
  
  public void start(ChangeListener paramChangeListener)
  {
    if (paramChangeListener == null) {
      throw new IllegalArgumentException("SmotionCall : ChangeListener is null. ");
    }
    if (!e) {
      throw new IllegalStateException("SmotionCall : This device is not supported. ");
    }
    if (this.b == null)
    {
      this.b = paramChangeListener;
      paramChangeListener = this.b;
      if (paramChangeListener != null) {
        break label100;
      }
    }
    label100:
    for (paramChangeListener = null;; paramChangeListener = new c(this, paramChangeListener))
    {
      this.c = paramChangeListener;
      this.a.registerListenerEvent(this.c, 1073741824, 1024, null);
      try
      {
        f.a(f.d, "SmotionCall.start()");
        return;
      }
      catch (SecurityException paramChangeListener)
      {
        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
      }
      throw new IllegalStateException("SmotionCall : ChangeListener is already registered.");
    }
  }
  
  public void stop()
  {
    if (this.b == null) {
      throw new IllegalStateException("SmotionCall : start() is not called. ");
    }
    if (this.a != null) {
      this.a.unregisterListener(this.c, 1024);
    }
    this.c = null;
    this.b = null;
  }
  
  public static abstract interface ChangeListener
  {
    public abstract void onChanged(SmotionCall.Info paramInfo);
  }
  
  public static class Info
  {
    private int a;
    private long b;
    
    public Info()
    {
      if (SmotionCall.a() == null) {
        throw new IllegalStateException("SmotionCall.Info : SmotionCall is not created. ");
      }
      if (!SmotionCall.b()) {
        throw new IllegalStateException("SmotionCall.Info : This device is not supported. ");
      }
    }
    
    final void a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getCallPosition()
    {
      return this.a;
    }
    
    public long getTimeStamp()
    {
      return this.b;
    }
  }
  
  private static final class a
    extends MotionRecognitionManager
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void unregisterListener(MRListener paramMRListener)
    {
      super.unregisterListener(paramMRListener);
    }
    
    public final void unregisterListener(MRListener paramMRListener, int paramInt)
    {
      super.unregisterListener(paramMRListener, paramInt);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/SmotionCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */