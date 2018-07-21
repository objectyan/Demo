package com.indooratlas.android.sdk._internal;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class fi
{
  public fh a = null;
  private int b = 10;
  
  public fi()
  {
    this((byte)0);
  }
  
  private fi(byte paramByte) {}
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(paramString1 + "\n");
    TreeMap localTreeMap;
    int i;
    String str;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      localTreeMap = new TreeMap();
      paramString2 = paramString2.split("&");
      i = 0;
      if (i < paramString2.length)
      {
        paramString1 = paramString2[i].split("=");
        str = paramString1[0].toLowerCase();
        if (paramString1.length <= 1) {
          break label319;
        }
      }
    }
    label319:
    for (paramString1 = paramString1[1];; paramString1 = "")
    {
      if (localTreeMap.containsKey(str) == true) {
        ((List)localTreeMap.get(str)).add(paramString1);
      }
      for (;;)
      {
        i += 1;
        break;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString1);
        localTreeMap.put(str, localArrayList);
      }
      paramString1 = localTreeMap.keySet().iterator();
      if (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localStringBuilder.append(paramString2 + ":");
        Collections.sort((List)localTreeMap.get(paramString2));
        paramString2 = (List)localTreeMap.get(paramString2);
      }
      int j;
      for (i = 0;; i = j)
      {
        if (i != 0) {
          localStringBuilder.append(',');
        }
        j = i + 1;
        localStringBuilder.append((String)paramString2.get(i));
        if (j >= paramString2.size())
        {
          localStringBuilder.append("\n");
          break;
          return localStringBuilder.toString();
        }
      }
    }
  }
  
  public static String a(Map<String, List<String>> paramMap)
    throws fl
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.toLowerCase().startsWith("x-ida-"))
      {
        if (((List)paramMap.get(str1)).size() != 1) {
          throw new fl("Invalid header count for: " + str1);
        }
        String str2 = (String)((List)paramMap.get(str1)).get(0);
        localStringBuilder.append(str1.toLowerCase().trim() + ":" + str2.toLowerCase().trim() + "\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public final String a(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    return this.a.a(paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */