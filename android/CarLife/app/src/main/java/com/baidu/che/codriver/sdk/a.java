package com.baidu.che.codriver.sdk;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.util.Log;

public class a
  implements IBinder.DeathRecipient
{
  public static final String a = "ClientDeathRecipient";
  private b b;
  private com.baidu.che.codriver.b c;
  private IBinder d;
  
  public a(b paramb, com.baidu.che.codriver.b paramb1)
  {
    if (paramb1 != null)
    {
      this.b = paramb;
      this.c = paramb1;
      this.d = paramb1.asBinder();
    }
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    Log.d("ClientDeathRecipient", "linkToDeath:" + this.d);
    try
    {
      this.d.linkToDeath(this, 0);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void b()
  {
    if (this.d == null) {
      return;
    }
    Log.d("ClientDeathRecipient", "unlinkToDeath:" + this.d);
    this.d.unlinkToDeath(this, 0);
    this.b = null;
  }
  
  public void binderDied()
  {
    Log.d("ClientDeathRecipient", "binderDied:" + this.d);
    if (this.b == null) {
      return;
    }
    try
    {
      this.b.a(this.c);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */