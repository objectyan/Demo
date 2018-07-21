package com.tencent.wxop.stat.b;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class t
  implements Comparator<ScanResult>
{
  public final int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    int i = Math.abs(paramScanResult1.level);
    int j = Math.abs(paramScanResult2.level);
    if (i > j) {
      return 1;
    }
    if (i == j) {
      return 0;
    }
    return -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */