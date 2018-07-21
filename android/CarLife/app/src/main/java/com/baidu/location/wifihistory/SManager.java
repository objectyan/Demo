package com.baidu.location.wifihistory;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class SManager
  extends Service
{
  private ISManager.Stub mProvider = new ISManager.Stub()
  {
    public WifiHistory getInfo2()
      throws RemoteException
    {
      return SClient.getInstance().getWifiHistory();
    }
    
    public String getShareString01()
      throws RemoteException
    {
      return SManager.this.testStr;
    }
    
    public boolean setShareString01(String paramAnonymousString)
      throws RemoteException
    {
      SManager.access$002(SManager.this, paramAnonymousString);
      return false;
    }
  };
  private String testStr = "test 00";
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mProvider;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/wifihistory/SManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */