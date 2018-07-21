package com.baidu.carlife.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static List<String> a = new ArrayList();
  private static List<String> b = new ArrayList();
  private static List<String> c = new ArrayList();
  
  static
  {
    a.add("");
    b.add("SM-N9106W");
    b.add("SM-G9008V");
    b.add("SM-A8000");
    c.add("SM-G9200");
    c.add("MI NOTE PRO");
    c.add("E6653");
    c.add("NXT-CL00");
  }
  
  public static boolean a()
  {
    String str = Build.MODEL;
    return (!TextUtils.isEmpty(str)) && (a.contains(str.toUpperCase()));
  }
  
  public static boolean b()
  {
    String str = Build.MODEL;
    return (!TextUtils.isEmpty(str)) && (b.contains(str.toUpperCase()));
  }
  
  public static boolean c()
  {
    String str = Build.MODEL;
    return (!TextUtils.isEmpty(str)) && (c.contains(str.toUpperCase()));
  }
  
  public static boolean d()
  {
    return (x.b()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */