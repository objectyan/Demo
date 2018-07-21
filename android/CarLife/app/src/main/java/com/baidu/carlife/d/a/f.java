package com.baidu.carlife.d.a;

import android.util.Log;
import b.ab;
import b.ab.a;
import b.ac;
import b.ad;
import b.r.a;
import b.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class f
{
  private static final String a = "network_http";
  
  static ab a(String paramString)
  {
    Log.i("network_http", "GET url=" + paramString);
    return b(paramString).d();
  }
  
  static ab a(String paramString1, String paramString2)
  {
    paramString2 = ac.a(w.a("application/json; charset=utf-8"), paramString2);
    return b(paramString1).a(paramString2).d();
  }
  
  static ab a(String paramString, Map<String, String> paramMap)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i > 0) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append(String.format("%s=%s", new Object[] { str, URLEncoder.encode((String)paramMap.get(str), "UTF-8") }));
        i += 1;
      }
      return b(paramString).d();
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
      paramString = String.format("%s?%s", new Object[] { paramString, localStringBuffer.toString() });
      Log.i("network_http", "GET url=" + paramString);
    }
  }
  
  static Map<String, String> a(ad paramad)
  {
    localHashMap = new HashMap();
    try
    {
      paramad = paramad.a("Set-Cookie");
      int i = 0;
      int j = paramad.size();
      while (i < j)
      {
        String str = ((String)paramad.get(i)).split(";")[0].trim();
        localHashMap.put(str.split("=")[0], str.split("=")[1]);
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramad)
    {
      paramad.printStackTrace();
    }
  }
  
  private static ab.a b(String paramString)
  {
    return new ab.a().a(paramString).b("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36");
  }
  
  static ab b(String paramString, Map<String, String> paramMap)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (i > 0) {
            localStringBuffer.append("&");
          }
          if ("data".equals(str)) {
            localStringBuffer.append(String.format("%s=%s", new Object[] { str, paramMap.get(str) }));
          } else {
            localStringBuffer.append(String.format("%s=%s", new Object[] { str, URLEncoder.encode((String)paramMap.get(str), "UTF-8") }));
          }
        }
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        paramString = String.format("%s?%s", new Object[] { paramString, localStringBuffer.toString() });
        Log.i("network_http", "GET url=" + paramString);
        return b(paramString).d();
      }
      i += 1;
    }
  }
  
  static ab c(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    paramMap = new r.a();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramMap.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramMap = paramMap.a();
    return b(paramString).a(paramMap).d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/d/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */