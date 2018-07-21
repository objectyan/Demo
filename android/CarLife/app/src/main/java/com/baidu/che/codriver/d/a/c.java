package com.baidu.che.codriver.d.a;

import com.baidu.carlife.core.i;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(String paramString)
  {
    String str = "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(localMessageDigest.digest());
      return paramString.toLowerCase();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
  }
  
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Object localObject = a(paramMap);
    a((List)localObject);
    paramMap = new StringBuffer();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramMap.append(((a)((Iterator)localObject).next()).toString());
    }
    i.b("network", "str for signed: " + paramMap.toString());
    i.b("network", "key_sign: prefix=" + paramString1 + "; suffix=" + paramString2);
    return a(paramString1 + paramMap.toString() + paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = a[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static List<a> a(Map<String, String> paramMap)
  {
    localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new a(str, URLEncoder.encode((String)paramMap.get(str), "UTF-8")));
      }
      return localArrayList;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  private static void a(List<a> paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int a(c.a paramAnonymousa1, c.a paramAnonymousa2)
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
    
    public String toString()
    {
      return this.a + "=" + this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */