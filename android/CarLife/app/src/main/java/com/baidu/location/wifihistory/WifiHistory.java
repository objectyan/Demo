package com.baidu.location.wifihistory;

import android.net.wifi.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.f.e;
import com.baidu.location.f.f;
import java.util.LinkedList;
import java.util.List;

public class WifiHistory
  implements Parcelable
{
  public static final Parcelable.Creator<WifiHistory> CREATOR = new Parcelable.Creator()
  {
    public WifiHistory a(Parcel paramAnonymousParcel)
    {
      return new WifiHistory(paramAnonymousParcel);
    }
    
    public WifiHistory[] a(int paramAnonymousInt)
    {
      return new WifiHistory[paramAnonymousInt];
    }
  };
  List<String> historyWifi = new LinkedList();
  long lastTime = 0L;
  List<ScanResult> lastWifi = null;
  boolean updateFlag = false;
  
  public WifiHistory() {}
  
  public WifiHistory(Parcel paramParcel)
  {
    try
    {
      paramParcel.readList(this.historyWifi, null);
      if (this.historyWifi == null) {
        this.historyWifi = new LinkedList();
      }
      paramParcel.readList(null, null);
      this.lastWifi = null;
      this.lastTime = paramParcel.readLong();
      return;
    }
    catch (Exception paramParcel) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getWifiHistory()
  {
    int k = 0;
    if ((this.historyWifi == null) || (this.historyWifi.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(512);
    int j = 3;
    int i;
    if (this.updateFlag)
    {
      i = 1;
      j = 4;
    }
    for (;;)
    {
      if (j > this.historyWifi.size()) {
        j = this.historyWifi.size();
      }
      for (;;)
      {
        if (i < j)
        {
          localStringBuilder.append("&wfh");
          localStringBuilder.append(k);
          localStringBuilder.append("=");
          localStringBuilder.append((String)this.historyWifi.get(i));
          i += 1;
          k += 1;
        }
        else
        {
          return localStringBuilder.toString();
        }
      }
      i = 0;
    }
  }
  
  void recordWifi(List<ScanResult> paramList)
  {
    this.lastWifi = paramList;
    paramList = e.a(5, paramList);
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList + ";" + System.currentTimeMillis() / 1000L;
      this.historyWifi.add(paramList);
      while (this.historyWifi.size() > 4) {
        this.historyWifi.remove(0);
      }
    }
  }
  
  void updateWifi(List<ScanResult> paramList)
  {
    if ((this.lastWifi != null) && (f.a(paramList, this.lastWifi, 0.5F))) {
      return;
    }
    this.updateFlag = true;
    recordWifi(paramList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.historyWifi);
    paramParcel.writeList(this.lastWifi);
    paramParcel.writeLong(this.lastTime);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/wifihistory/WifiHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */