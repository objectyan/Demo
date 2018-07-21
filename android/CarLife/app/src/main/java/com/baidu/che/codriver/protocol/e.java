package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import com.baidu.che.codriver.util.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
{
  private static final String a = "UrlBuilder";
  private String b;
  private String c;
  private HashMap<String, String> d = new HashMap();
  private HashMap<String, String> e = new HashMap();
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str;
    Object localObject;
    do
    {
      return paramString1;
      str = paramString2 + "=";
      i = paramString1.indexOf("?");
      if (i < 0)
      {
        localObject = null;
        i = paramString1.indexOf("#");
        if (i < 0)
        {
          paramString2 = new StringBuilder(paramString1);
          paramString1 = (String)localObject;
        }
        for (;;)
        {
          paramString2.append("?").append(str).append(paramString3);
          if (paramString1 != null) {
            paramString2.append(paramString1);
          }
          return paramString2.toString();
          paramString2 = paramString1.substring(i);
          localObject = new StringBuilder(paramString1.substring(0, i));
          paramString1 = paramString2;
          paramString2 = (String)localObject;
        }
      }
    } while ((paramString1.indexOf("&" + str, i) >= 0) || (paramString1.indexOf("?" + str, i) >= 0));
    StringBuilder localStringBuilder = null;
    int i = paramString1.indexOf("#");
    if (i < 0)
    {
      paramString2 = new StringBuilder(paramString1);
      localObject = paramString1;
      paramString1 = localStringBuilder;
    }
    for (;;)
    {
      if ((!((String)localObject).endsWith("&")) && (!((String)localObject).endsWith("?"))) {
        paramString2.append("&");
      }
      paramString2.append(str).append(paramString3);
      if (paramString1 != null) {
        paramString2.append(paramString1);
      }
      return paramString2.toString();
      paramString2 = paramString1.substring(i);
      localObject = paramString1.substring(0, i);
      localStringBuilder = new StringBuilder((String)localObject);
      paramString1 = paramString2;
      paramString2 = localStringBuilder;
    }
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label122;
      }
      String str2 = (String)localIterator.next();
      Object localObject = null;
      try
      {
        String str1 = URLEncoder.encode((String)paramMap.get(str2), "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(str2 + "=" + (String)localObject);
    }
    label122:
    return localStringBuilder.toString();
  }
  
  public e a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public e a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      this.d.put(paramString1, paramString2);
      try
      {
        this.e.put(paramString1, URLEncoder.encode(paramString2, "UTF-8"));
        return this;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        return this;
      }
    }
    h.e("UrlBuilder", "buildParam key=" + paramString1 + " value=" + paramString2);
    return this;
  }
  
  public HashMap<String, String> a()
  {
    return this.d;
  }
  
  public e b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String b()
    throws e.a
  {
    if (TextUtils.isEmpty(this.b))
    {
      h.e("UrlBuilder", "host or request uri is empty");
      throw new a("host or request uri is empty");
    }
    String str1;
    String str3;
    if (TextUtils.isEmpty(this.c))
    {
      str1 = this.b;
      str3 = a(this.d);
      str2 = str1;
      if (!TextUtils.isEmpty(str3)) {
        if (str1.indexOf("?") >= 0) {
          break label260;
        }
      }
    }
    label260:
    for (String str2 = str1 + "?" + str3;; str2 = str1 + "&" + str3)
    {
      h.b("UrlBuilder", "getUrl(): " + str2);
      return str2;
      if ((this.b.endsWith("/")) && (this.c.startsWith("/")))
      {
        str1 = this.b + this.c.substring(1);
        break;
      }
      if ((!this.b.endsWith("/")) && (!this.c.startsWith("/")))
      {
        str1 = this.b + "/" + this.c;
        break;
      }
      str1 = this.b + this.c;
      break;
    }
  }
  
  public String c()
  {
    ArrayList localArrayList = new ArrayList(this.e.entrySet());
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(Map.Entry<String, String> paramAnonymousEntry1, Map.Entry<String, String> paramAnonymousEntry2)
      {
        return ((String)paramAnonymousEntry1.getKey()).compareTo((String)paramAnonymousEntry2.getKey());
      }
    });
    String str = "";
    int i = 0;
    while (i < localArrayList.size())
    {
      str = str + localArrayList.get(i);
      i += 1;
    }
    return str;
  }
  
  public static class a
    extends Exception
  {
    private static final long a = 4496218849022966611L;
    
    public a() {}
    
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */