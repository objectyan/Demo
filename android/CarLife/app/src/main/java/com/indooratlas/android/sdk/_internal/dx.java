package com.indooratlas.android.sdk._internal;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class dx
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public CharSequence i;
  public long j;
  public CharSequence k;
  
  public static List<dx> a(List<ScanResult> paramList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ScanResult localScanResult = (ScanResult)paramList.next();
      dx localdx = new dx();
      localdx.a = localScanResult.BSSID;
      localdx.b = localScanResult.SSID;
      localdx.c = localScanResult.capabilities;
      localdx.g = localScanResult.frequency;
      localdx.h = localScanResult.level;
      if (Build.VERSION.SDK_INT >= 17) {
        localdx.j = localScanResult.timestamp;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localdx.d = localScanResult.centerFreq0;
        localdx.e = localScanResult.centerFreq1;
        localdx.f = localScanResult.channelWidth;
        localdx.i = localScanResult.operatorFriendlyName;
        localdx.k = localScanResult.venueName;
      }
      localCopyOnWriteArrayList.add(localdx);
    }
    return localCopyOnWriteArrayList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */