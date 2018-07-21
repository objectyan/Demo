package com.baidu.che.codriver.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.util.h;

public class CoDriverService
  extends Service
{
  private static final String a = "[sdk_server] CoDriverService";
  private b b;
  
  public IBinder onBind(Intent paramIntent)
  {
    h.b("[sdk_server] CoDriverService", "onBind");
    return this.b;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.b("[sdk_server] CoDriverService", "onCreate");
    this.b = new b();
    l.a().a(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/CoDriverService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */