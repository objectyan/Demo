package com.samsung.android.sdk.motion;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.motion.MRListener;
import android.hardware.scontext.SContextManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;
import java.lang.reflect.Method;

public class Smotion
  implements SsdkInterface
{
  public static final int TYPE_ACTIVITY = 3;
  public static final int TYPE_ACTIVITY_NOTIFICATION = 4;
  public static final int TYPE_CALL = 0;
  public static final int TYPE_PEDOMETER = 1;
  public static final int TYPE_PEDOMETER_WITH_UPDOWN_STEP = 2;
  static boolean b = false;
  static boolean c = false;
  boolean a = false;
  Context d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  private static boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.samsung.android.feature.FloatingFeature");
      Object localObject = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      boolean bool = ((Boolean)localClass.getMethod("getEnableStatus", new Class[] { String.class }).invoke(localObject, new Object[] { "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE" })).booleanValue();
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  final void a(Context paramContext, String paramString)
  {
    if (a())
    {
      try
      {
        if (paramContext.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
          throw new SecurityException();
        }
      }
      catch (NullPointerException paramContext)
      {
        throw new IllegalArgumentException("Smotion : Context is wrong. ");
      }
      ContentValues localContentValues = new ContentValues();
      String str1 = getClass().getPackage().getName();
      String str2 = paramContext.getPackageName() + "#" + getVersionCode();
      localContentValues.put("app_id", str1);
      localContentValues.put("feature", str2);
      if (!paramString.equals("initialize()")) {
        localContentValues.put("extra", paramString);
      }
      paramString = new Intent();
      paramString.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
      paramString.putExtra("data", localContentValues);
      paramString.setPackage("com.samsung.android.providers.context");
      paramContext.sendBroadcast(paramString);
    }
  }
  
  public int getVersionCode()
  {
    return 9;
  }
  
  public String getVersionName()
  {
    return "2.2.1";
  }
  
  public void initialize(Context paramContext)
    throws SsdkUnsupportedException
  {
    if (this.a) {
      throw new IllegalStateException("Smotion : initialize() is already called. ");
    }
    this.a = false;
    if (paramContext == null) {
      throw new IllegalArgumentException("Smotion : Context is null. ");
    }
    try
    {
      a(paramContext, "initialize()");
      if (!SsdkVendorCheck.isSamsungDevice()) {
        throw new SsdkUnsupportedException(Build.BRAND + " is not supported.", 0);
      }
    }
    catch (SecurityException paramContext)
    {
      throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
    }
    this.d = paramContext;
    try
    {
      if (this.d == null) {
        throw new NullPointerException("Smotion : Context is null. ");
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      boolean bool1;
      do
      {
        this.a = true;
        if ((isFeatureEnabled(0)) || (isFeatureEnabled(1)) || (isFeatureEnabled(3)) || (isFeatureEnabled(4))) {
          break;
        }
        this.a = false;
        throw new SsdkUnsupportedException("Smotion : This Device is not supported.", 1);
        bool1 = this.e;
      } while (bool1);
      for (;;)
      {
        try
        {
          paramContext = this.d.getPackageManager();
          if (paramContext == null) {
            break;
          }
        }
        catch (NullPointerException paramContext)
        {
          boolean bool2;
          boolean bool3;
          throw new IllegalArgumentException("Smotion : Context is wrong. ");
        }
        try
        {
          if ((Class.forName("android.hardware.scontext.SContextManager").getMethod("getFeatureLevel", new Class[] { Integer.TYPE }) != null) && ((paramContext.hasSystemFeature("com.sec.feature.sensorhub")) || (paramContext.hasSystemFeature("com.sec.feature.scontext_lite"))))
          {
            SContextManager localSContextManager = (SContextManager)this.d.getSystemService("scontext");
            if (localSContextManager != null)
            {
              if (localSContextManager.getFeatureLevel(2) > 0)
              {
                this.f = true;
                if (paramContext.hasSystemFeature("android.hardware.sensor.barometer")) {
                  this.g = true;
                }
              }
              if (localSContextManager.getFeatureLevel(25) > 0)
              {
                this.i = true;
                if (localSContextManager.isAvailableService(26))
                {
                  if (((paramContext.getSystemFeatureLevel("com.sec.feature.sensorhub") != 7) && (paramContext.getSystemFeatureLevel("com.sec.feature.sensorhub") != 9)) || (Build.VERSION.SDK_INT > 19)) {
                    break label490;
                  }
                  b = false;
                }
              }
              if (localSContextManager.getFeatureLevel(27) > 0) {
                this.j = true;
              }
              if ((this.i) && (this.j)) {
                c = true;
              }
            }
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          continue;
        }
        try
        {
          if (Class.forName("android.hardware.motion.MotionRecognitionManager").getMethod("registerListenerEvent", new Class[] { MRListener.class, Integer.TYPE, Integer.TYPE, Handler.class }) == null) {
            break;
          }
          bool1 = paramContext.hasSystemFeature("android.hardware.sensor.accelerometer");
          bool2 = paramContext.hasSystemFeature("android.hardware.sensor.gyroscope");
          bool3 = paramContext.hasSystemFeature("android.hardware.sensor.proximity");
          if ((bool1) && (bool2) && (bool3)) {
            this.h = true;
          }
          this.e = true;
        }
        catch (ClassNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
        break;
        label490:
        b = true;
      }
    }
  }
  
  public boolean isFeatureEnabled(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("Smotion : Type value is wrong. ");
    }
    if (this.d == null) {
      throw new IllegalStateException("Smotion : initialize() is not called. ");
    }
    if (!this.a) {
      throw new IllegalStateException("Smotion : initialize() is not successful. ");
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.h;
    case 1: 
      return this.f;
    case 2: 
      return this.g;
    case 3: 
      return this.i;
    }
    return this.j;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/samsung/android/sdk/motion/Smotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */