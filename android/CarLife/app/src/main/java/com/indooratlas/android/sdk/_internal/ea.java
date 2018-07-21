package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.net.wifi.ScanResult;

@TargetApi(17)
public abstract class ea
{
  public abstract int a(ScanResult paramScanResult);
  
  static class a
    extends ea
  {
    private static final String a = ee.a(a.class);
    private final ef<String, Long> b = new ef();
    private final StringBuilder c = new StringBuilder();
    
    private int a()
    {
      synchronized (this.b)
      {
        int i = this.b.size();
        return i;
      }
    }
    
    public final int a(ScanResult paramScanResult)
    {
      for (;;)
      {
        String str;
        Long localLong;
        long l;
        int i;
        try
        {
          synchronized (this.c)
          {
            this.c.setLength(0);
            str = paramScanResult.SSID + '|' + paramScanResult.BSSID;
            localLong = (Long)this.b.get(str);
            l = paramScanResult.timestamp;
            paramScanResult = this.b;
            if (localLong != null) {}
          }
        }
        finally {}
        try
        {
          this.b.put(str, Long.valueOf(l));
          i = 1;
          return i;
        }
        finally {}
        paramScanResult = finally;
        throw paramScanResult;
        if (localLong.longValue() == l)
        {
          a();
          i = -1;
        }
        else if (l > localLong.longValue())
        {
          a();
          this.b.put(str, Long.valueOf(l));
          i = 2;
        }
        else
        {
          a();
          this.b.put(str, Long.valueOf(l));
          i = 3;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */