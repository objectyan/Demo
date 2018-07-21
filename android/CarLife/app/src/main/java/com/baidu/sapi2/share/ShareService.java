package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountManager.ReceiveShareListener;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class ShareService
  extends Service
{
  private static Context a;
  private static LoginShareStrategy b;
  private static com.baidu.sapi2.b c;
  private static boolean d = false;
  private Handler e;
  
  void a(Context paramContext)
  {
    try
    {
      a = paramContext;
      c = com.baidu.sapi2.b.a(paramContext);
      b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
      d = true;
      return;
    }
    catch (IllegalStateException paramContext)
    {
      d = false;
    }
  }
  
  void a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle();
    ShareModel localShareModel = new ShareModel(ShareEvent.SYNC_ACK);
    Object localObject = c.d();
    localShareModel.a((SapiAccount)localObject);
    List localList = c.f();
    if (localObject != null)
    {
      ((SapiAccount)localObject).app = SapiUtils.getAppName(a);
      if ((localList.size() > 0) && (localList.contains(localObject)))
      {
        localList.set(localList.indexOf(localObject), localList.get(0));
        localList.set(0, localObject);
      }
    }
    for (;;)
    {
      localShareModel.a().addAll(localList);
      localShareModel.a().addAll(c.e());
      localObject = localShareModel.a().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SapiAccount)((Iterator)localObject).next()).app = SapiUtils.getAppName(a);
      }
      Collections.reverse(localList);
    }
    c.b(a, b, localShareModel);
    localBundle.putParcelable("LOGIN_SHARE_MODEL", localShareModel);
    if (c.o() != null) {
      localBundle.putString("RELOGIN_CREDENTIALS", b.a(a, c.o().toString()));
    }
    localBundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
    paramParcel.writeBundle(localBundle);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new a(null);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.e = new Handler(Looper.getMainLooper());
  }
  
  @TargetApi(5)
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    stopSelf();
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    stopSelf();
    return super.onUnbind(paramIntent);
  }
  
  private class a
    extends Binder
  {
    private a() {}
    
    protected boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2 = true;
      boolean bool1;
      if (!c.b(ShareService.this)) {
        bool1 = false;
      }
      ShareModel localShareModel;
      for (;;)
      {
        return bool1;
        if (SapiAccountManager.getReceiveShareListener() != null)
        {
          if (ShareService.a(ShareService.this) == null) {
            ShareService.a(ShareService.this, new Handler(Looper.getMainLooper()));
          }
          ShareService.a(ShareService.this).post(new Runnable()
          {
            public void run()
            {
              if (SapiAccountManager.getReceiveShareListener() != null) {
                SapiAccountManager.getReceiveShareListener().onReceiveShare();
              }
            }
          });
        }
        if (!ShareService.a()) {
          ShareService.this.a(ShareService.this);
        }
        bool1 = bool2;
        if (ShareService.a())
        {
          bool1 = bool2;
          if (ShareService.b() != LoginShareStrategy.DISABLED) {
            try
            {
              paramParcel1 = paramParcel1.readBundle(ShareModel.class.getClassLoader());
              localShareModel = (ShareModel)paramParcel1.getParcelable("LOGIN_SHARE_MODEL");
              bool1 = bool2;
              if (localShareModel != null) {
                if ((paramParcel1.getSerializable("RUNTIME_ENVIRONMENT") != null) && ((paramParcel1.getSerializable("RUNTIME_ENVIRONMENT") instanceof Domain)))
                {
                  bool1 = bool2;
                  if ((Domain)paramParcel1.getSerializable("RUNTIME_ENVIRONMENT") != SapiAccountManager.getInstance().getSapiConfiguration().environment) {}
                }
                else
                {
                  c.c(ShareService.c(), paramParcel1.getString("RELOGIN_CREDENTIALS"));
                  switch (ShareService.1.a[localShareModel.b().ordinal()])
                  {
                  case 1: 
                    c.a(ShareService.c(), ShareService.b(), localShareModel);
                    return true;
                  }
                }
              }
            }
            catch (Throwable paramParcel1)
            {
              L.e(paramParcel1);
              return true;
            }
          }
        }
      }
      c.a(ShareService.c(), localShareModel);
      return true;
      ShareService.this.a(paramParcel2);
      return true;
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/share/ShareService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */