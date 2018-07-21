package com.baidu.android.pushservice.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b
{
  public static void a(Context paramContext)
  {
    a(paramContext, (ArrayList)com.baidu.android.pushservice.b.b.a(paramContext).a.clone());
  }
  
  private static void a(Context paramContext, ArrayList<com.baidu.android.pushservice.b.f> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (com.baidu.android.pushservice.b.f)localIterator.next();
        if (localObject != null)
        {
          localObject = ((com.baidu.android.pushservice.b.f)localObject).c();
          try
          {
            paramContext.getPackageInfo((String)localObject, 0);
          }
          catch (Exception localException) {}
          if (TextUtils.isEmpty((CharSequence)localObject)) {}
        }
      }
      return;
    }
    finally {}
  }
  
  @SuppressLint({"InlinedApi"})
  public static void a(HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis() / 1000L;
    paramHashMap.put("timestamp", l + "");
    paramHashMap.put("expires", 86400L + l + "");
    paramHashMap.put("v", "1");
    try
    {
      paramHashMap.put("vcode", com.baidu.android.pushservice.k.f.a(URLEncoder.encode(l + "bccs", "UTF-8").getBytes(), false));
      return;
    }
    catch (UnsupportedEncodingException paramHashMap) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */