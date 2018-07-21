package com.baidu.location.wifihistory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.ScanResult;
import android.os.IBinder;
import com.baidu.location.f;
import java.util.List;

public class SClient
{
  ISManager mShare = null;
  private WifiHistory mWHistory = null;
  
  public static SClient getInstance()
  {
    return a.a;
  }
  
  public WifiHistory getRemoteObject()
  {
    if (this.mShare == null) {
      return null;
    }
    try
    {
      WifiHistory localWifiHistory = this.mShare.getInfo2();
      return localWifiHistory;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public WifiHistory getWifiHistory()
  {
    return this.mWHistory;
  }
  
  public String getWifiHistoryString()
  {
    if (this.mWHistory != null) {
      return this.mWHistory.getWifiHistory();
    }
    return null;
  }
  
  public void start()
  {
    Intent localIntent = new Intent("com.baidu.location.locSManager");
    localIntent.setPackage("com.baidu.BaiduMap");
    try
    {
      f.getServiceContext().bindService(localIntent, new ServiceConnection()
      {
        public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          SClient.this.mShare = ISManager.Stub.asInterface(paramAnonymousIBinder);
          SClient.access$002(SClient.this, SClient.getInstance().getRemoteObject());
          if (SClient.this.mWHistory == null) {
            SClient.access$002(SClient.this, new WifiHistory());
          }
        }
        
        public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          SClient.this.mShare = null;
        }
      }, 1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void updateWifiHistory(List<ScanResult> paramList)
  {
    if (paramList == null) {}
    while (this.mWHistory == null) {
      return;
    }
    this.mWHistory.updateWifi(paramList);
  }
  
  static class a
  {
    static SClient a = new SClient();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/wifihistory/SClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */