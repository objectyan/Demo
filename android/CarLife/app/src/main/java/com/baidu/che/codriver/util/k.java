package com.baidu.che.codriver.util;

import android.net.Uri;
import android.util.Base64;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class k
{
  private static final String a = "RCVrMnRK";
  private static final String b = "R21EVyNV";
  
  public static String a(String paramString)
    throws Exception
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = Uri.parse(paramString);
    Object localObject3 = ((Uri)localObject1).getQueryParameterNames().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      ((List)localObject2).add(new a(str, ((Uri)localObject1).getQueryParameter(str)));
    }
    a((List)localObject2);
    localObject1 = new StringBuffer();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(((a)localObject3).a).append("=").append(URLEncoder.encode(((a)localObject3).b, "UTF-8"));
    }
    localObject2 = new String(Base64.decode("RCVrMnRK".getBytes("UTF-8"), 0));
    localObject3 = new String(Base64.decode("R21EVyNV".getBytes("UTF-8"), 0));
    return paramString + "&sign=" + i.a(new StringBuilder().append((String)localObject2).append(((StringBuffer)localObject1).toString()).append((String)localObject3).toString());
  }
  
  private static void a(List<a> paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int a(k.a paramAnonymousa1, k.a paramAnonymousa2)
      {
        return paramAnonymousa1.a.compareTo(paramAnonymousa2.a);
      }
    });
  }
  
  private static class a
  {
    String a;
    String b;
    
    a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */