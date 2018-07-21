package com.baidu.ufosdk.util;

import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import java.util.HashMap;

public final class u
{
  public static String a(String paramString)
  {
    if (a.ag == null) {
      a.ag = UfoSDK.getChineseMap();
    }
    if (a.ag.containsKey(paramString)) {
      return (String)a.ag.get(paramString);
    }
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */