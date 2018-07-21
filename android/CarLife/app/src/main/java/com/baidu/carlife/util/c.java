package com.baidu.carlife.util;

import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.core.a;
import com.baidu.navisdk.util.common.PackageUtil;

public class c
{
  public static final String a = "unknow";
  private static c b = new c();
  
  public static c a()
  {
    return b;
  }
  
  public static String b()
  {
    String str2 = CommonParam.getCUID(a.a());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknow";
    }
    return str1;
  }
  
  public static String c()
  {
    String str2 = PackageUtil.getChannel();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknow";
    }
    return str1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */