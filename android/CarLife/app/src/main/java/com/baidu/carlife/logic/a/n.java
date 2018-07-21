package com.baidu.carlife.logic.a;

import android.webkit.URLUtil;

public class n
{
  public static n a()
  {
    return a.a();
  }
  
  public String a(String paramString)
  {
    if ((!URLUtil.isValidUrl(paramString)) && (!paramString.endsWith(".aac"))) {
      return null;
    }
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = "http:" + paramString;
    }
    paramString = str;
    if (str.contains("transcode=ts")) {
      paramString = str.replace("transcode=ts", "transcode=aac");
    }
    return paramString;
  }
  
  private static class a
  {
    private static final n a = new n(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */