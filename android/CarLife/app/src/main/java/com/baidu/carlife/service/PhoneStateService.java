package com.baidu.carlife.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.q;

public class PhoneStateService
  extends Service
{
  static final String a = "PhoneStateService";
  private TelephonyManager b;
  private a c = null;
  private final IBinder d = new b(null);
  
  public static void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    try
    {
      i.b("PhoneStateService", "============== PhoneStateService start");
      paramContext.startService(new Intent(paramContext, PhoneStateService.class));
      return;
    }
    catch (Exception paramContext)
    {
      i.a(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    try
    {
      i.b("PhoneStateService", "============== PhoneStateService stop");
      paramContext.stopService(new Intent(paramContext, PhoneStateService.class));
      return;
    }
    catch (Exception paramContext)
    {
      i.a(paramContext);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    i.b("PhoneStateService", "PhoneStateService onBind()");
    return this.d;
  }
  
  public void onCreate()
  {
    super.onCreate();
    i.b("PhoneStateService", "============== PhoneStateService onCreate()");
    this.b = ((TelephonyManager)getSystemService("phone"));
    this.b.listen(new a(null), 32);
  }
  
  public void onDestroy()
  {
    i.b("PhoneStateService", "PhoneStateService onDestroy()");
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    i.b("PhoneStateService", "PhoneStateService onRebind()");
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    i.b("PhoneStateService", "PhoneStateService onStart(), startId = " + paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    i.b("PhoneStateService", "PhoneStateService onStartCommand");
    if (this.c == null)
    {
      Log.e("PhoneStateService", "============== Service onStartCommand");
      this.b = ((TelephonyManager)getApplicationContext().getSystemService("phone"));
      this.c = new a(null);
      this.b.listen(this.c, 32);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    i.b("PhoneStateService", "PhoneStateService onUnbind()");
    return super.onUnbind(paramIntent);
  }
  
  private class a
    extends PhoneStateListener
  {
    private a() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      super.onCallStateChanged(paramInt, paramString);
      i.b("PhoneStateService", "============== PhoneState Changed :" + paramInt + " :: " + paramString);
      k.a(2030, paramInt, paramString);
      q.f().a(paramInt, paramString);
      switch (paramInt)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          i.b("PhoneStateService", "============== CALL_STATE_IDLE:");
          return;
          i.b("PhoneStateService", "============== CALL_STATE_RINGING: ");
        } while (!TextUtils.isEmpty(paramString));
        Log.d("PhoneStateService", "Cann't Get Phone Number");
        return;
      }
      i.b("PhoneStateService", "============== CALL_STATE_OFFHOOK:" + paramString);
    }
  }
  
  public class b
    extends Binder
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/service/PhoneStateService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */