package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class a
{
  public static final int a = 5;
  static final String b = "LOGIN_SHARE_MODEL";
  static final String c = "RELOGIN_CREDENTIALS";
  static final String d = "RUNTIME_ENVIRONMENT";
  static final String e = "baidu.intent.action.account.SHARE_SERVICE";
  private static SapiConfiguration f = SapiAccountManager.getInstance().getSapiConfiguration();
  private static com.baidu.sapi2.b g = com.baidu.sapi2.b.a(f.context);
  private static final a h = new a();
  
  static Parcel a(ShareModel paramShareModel)
  {
    Parcel localParcel = Parcel.obtain();
    Bundle localBundle = new Bundle();
    c.b(f.context, f.loginShareStrategy(), paramShareModel);
    localBundle.putParcelable("LOGIN_SHARE_MODEL", paramShareModel);
    if (g.o() != null) {
      localBundle.putString("RELOGIN_CREDENTIALS", b.a(f.context, g.o().toString()));
    }
    localBundle.putSerializable("RUNTIME_ENVIRONMENT", f.environment);
    localParcel.writeBundle(localBundle);
    return localParcel;
  }
  
  public static a a()
  {
    return h;
  }
  
  public static void b()
  {
    if (g.g()) {
      if (f.loginShareStrategy() != LoginShareStrategy.DISABLED) {
        f();
      }
    }
    while ((g.h()) || (f.loginShareStrategy() != LoginShareStrategy.SILENT)) {
      return;
    }
    f();
  }
  
  private static void b(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    try
    {
      paramParcel = paramParcel.readBundle(ShareModel.class.getClassLoader());
      ShareModel localShareModel = (ShareModel)paramParcel.getParcelable("LOGIN_SHARE_MODEL");
      c.c(f.context, paramParcel.getString("RELOGIN_CREDENTIALS"));
      c.a(f.context, f.loginShareStrategy(), localShareModel);
      return;
    }
    catch (Throwable paramParcel)
    {
      L.e(paramParcel);
    }
  }
  
  static boolean c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.baidu.input_huawei");
    return localArrayList.contains(f.context.getPackageName());
  }
  
  private static void f()
  {
    if (c()) {
      return;
    }
    final HandlerThread localHandlerThread = new HandlerThread("SyncThread");
    localHandlerThread.start();
    final Handler localHandler = new Handler(localHandlerThread.getLooper());
    localHandler.post(new Runnable()
    {
      public void run()
      {
        if (!this.a.isEmpty()) {}
        try
        {
          a.d().context.bindService((Intent)this.a.get(0), new ServiceConnection()
          {
            public void onServiceConnected(ComponentName paramAnonymous2ComponentName, final IBinder paramAnonymous2IBinder)
            {
              a.3.this.b.post(new Runnable()
              {
                public void run()
                {
                  for (;;)
                  {
                    try
                    {
                      Parcel localParcel1 = a.a(new ShareModel(ShareEvent.SYNC_REQ));
                      Parcel localParcel2 = Parcel.obtain();
                      if (paramAnonymous2IBinder.transact(0, localParcel1, localParcel2, 0)) {
                        a.a(localParcel2);
                      }
                    }
                    catch (Throwable localThrowable2)
                    {
                      L.e(localThrowable2);
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                      }
                      catch (Throwable localThrowable3)
                      {
                        L.e(localThrowable3);
                      }
                      continue;
                    }
                    finally
                    {
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                        throw ((Throwable)localObject);
                      }
                      catch (Throwable localThrowable4)
                      {
                        L.e(localThrowable4);
                        continue;
                      }
                      a.3.this.c.quit();
                    }
                    try
                    {
                      a.d().context.unbindService(jdField_this);
                      a.3.this.a.remove(0);
                      if ((!a.3.this.a.isEmpty()) && (a.e().e().size() < 5))
                      {
                        a.3.this.b.post(a.3.1.this.a);
                        return;
                      }
                    }
                    catch (Throwable localThrowable1)
                    {
                      L.e(localThrowable1);
                    }
                  }
                }
              });
            }
            
            public void onServiceDisconnected(ComponentName paramAnonymous2ComponentName) {}
          }, 1);
          return;
        }
        catch (Throwable localThrowable)
        {
          L.e(localThrowable);
        }
      }
    });
  }
  
  public void a(final SapiAccount paramSapiAccount)
  {
    if (!SapiUtils.isValidAccount(paramSapiAccount)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramSapiAccount.app)) {
        paramSapiAccount.app = SapiUtils.getAppName(f.context);
      }
      g.a(paramSapiAccount);
      g.c(paramSapiAccount);
      g.d(paramSapiAccount);
    } while ((f.loginShareStrategy() == LoginShareStrategy.DISABLED) || (c()));
    final HandlerThread localHandlerThread = new HandlerThread("ValidateThread");
    localHandlerThread.start();
    final Handler localHandler = new Handler(localHandlerThread.getLooper());
    localHandler.post(new Runnable()
    {
      public void run()
      {
        if (!this.a.isEmpty()) {}
        try
        {
          a.d().context.bindService((Intent)this.a.get(0), new ServiceConnection()
          {
            public void onServiceConnected(ComponentName paramAnonymous2ComponentName, final IBinder paramAnonymous2IBinder)
            {
              a.1.this.b.post(new Runnable()
              {
                public void run()
                {
                  for (;;)
                  {
                    try
                    {
                      Parcel localParcel1 = a.a(new ShareModel(ShareEvent.VALIDATE, a.1.this.c, Collections.singletonList(a.1.this.c)));
                      Parcel localParcel2 = Parcel.obtain();
                      paramAnonymous2IBinder.transact(0, localParcel1, localParcel2, 0);
                    }
                    catch (Throwable localThrowable2)
                    {
                      L.e(localThrowable2);
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                      }
                      catch (Throwable localThrowable3)
                      {
                        L.e(localThrowable3);
                      }
                      continue;
                    }
                    finally
                    {
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                        throw ((Throwable)localObject);
                      }
                      catch (Throwable localThrowable4)
                      {
                        L.e(localThrowable4);
                        continue;
                      }
                      a.1.this.d.quit();
                    }
                    try
                    {
                      a.d().context.unbindService(jdField_this);
                      a.1.this.a.remove(0);
                      if (!a.1.this.a.isEmpty())
                      {
                        a.1.this.b.post(a.1.1.this.a);
                        return;
                      }
                    }
                    catch (Throwable localThrowable1)
                    {
                      L.e(localThrowable1);
                    }
                  }
                }
              });
            }
            
            public void onServiceDisconnected(ComponentName paramAnonymous2ComponentName) {}
          }, 1);
          return;
        }
        catch (Throwable localThrowable)
        {
          L.e(localThrowable);
        }
      }
    });
  }
  
  public void b(final SapiAccount paramSapiAccount)
  {
    if ((paramSapiAccount == null) || (f.loginShareStrategy() == LoginShareStrategy.DISABLED)) {}
    do
    {
      return;
      g.d(paramSapiAccount);
    } while (c());
    final HandlerThread localHandlerThread = new HandlerThread("InvalidateThread");
    localHandlerThread.start();
    final Handler localHandler = new Handler(localHandlerThread.getLooper());
    localHandler.post(new Runnable()
    {
      public void run()
      {
        if (!this.a.isEmpty()) {}
        try
        {
          a.d().context.bindService((Intent)this.a.get(0), new ServiceConnection()
          {
            public void onServiceConnected(ComponentName paramAnonymous2ComponentName, final IBinder paramAnonymous2IBinder)
            {
              a.2.this.b.post(new Runnable()
              {
                public void run()
                {
                  for (;;)
                  {
                    try
                    {
                      Parcel localParcel1 = a.a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(a.2.this.c)));
                      Parcel localParcel2 = Parcel.obtain();
                      paramAnonymous2IBinder.transact(0, localParcel1, localParcel2, 0);
                    }
                    catch (Throwable localThrowable2)
                    {
                      L.e(localThrowable2);
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                      }
                      catch (Throwable localThrowable3)
                      {
                        L.e(localThrowable3);
                      }
                      continue;
                    }
                    finally
                    {
                      try
                      {
                        a.d().context.unbindService(jdField_this);
                        throw ((Throwable)localObject);
                      }
                      catch (Throwable localThrowable4)
                      {
                        L.e(localThrowable4);
                        continue;
                      }
                      a.2.this.d.quit();
                    }
                    try
                    {
                      a.d().context.unbindService(jdField_this);
                      a.2.this.a.remove(0);
                      if (!a.2.this.a.isEmpty())
                      {
                        a.2.this.b.post(a.2.1.this.a);
                        return;
                      }
                    }
                    catch (Throwable localThrowable1)
                    {
                      L.e(localThrowable1);
                    }
                  }
                }
              });
            }
            
            public void onServiceDisconnected(ComponentName paramAnonymous2ComponentName) {}
          }, 1);
          return;
        }
        catch (Throwable localThrowable)
        {
          L.e(localThrowable);
        }
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */