package com.baidu.mobstat;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class df
  implements Comparator<ScanResult>
{
  public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    return paramScanResult2.level - paramScanResult1.level;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */