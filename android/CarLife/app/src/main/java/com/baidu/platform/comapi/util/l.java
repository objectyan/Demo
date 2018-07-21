package com.baidu.platform.comapi.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class l
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 15728640;
  public static final int f = 20971520;
  
  public static int a()
  {
    String str = Environment.getExternalStorageState();
    if (str == null) {}
    while (str.equals("bad_removal")) {
      return 2;
    }
    if (str.equals("checking")) {}
    do
    {
      return 0;
      if (str.equals("mounted")) {
        return 0;
      }
      if ((str.equals("mounted_ro")) || (str.equals("nofs"))) {
        break;
      }
      if (str.equals("removed")) {
        return 3;
      }
      if (str.equals("shared")) {
        return 3;
      }
      if (str.equals("unmountable")) {
        break;
      }
    } while (!str.equals("unmounted"));
    return 3;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    int k = a();
    int j = k;
    long l1;
    long l2;
    if (k == 0)
    {
      StatFs localStatFs = b();
      l1 = localStatFs.getBlockSize();
      l2 = localStatFs.getFreeBlocks();
      if (!paramBoolean) {
        break label61;
      }
    }
    label61:
    for (int i = 15728640;; i = 0)
    {
      j = k;
      if (l1 * l2 < i + paramInt) {
        j = 1;
      }
      return j;
    }
  }
  
  public static StatFs b()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getPath());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */