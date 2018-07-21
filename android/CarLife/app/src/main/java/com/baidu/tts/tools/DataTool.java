package com.baidu.tts.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataTool
{
  public static String[] connect(String[] paramArrayOfString, String[]... paramVarArgs)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString == null) {
      arrayOfString = new String[0];
    }
    int j = arrayOfString.length;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      paramArrayOfString = paramVarArgs[i];
      try
      {
        m = paramArrayOfString.length;
        j += m;
      }
      catch (Exception paramArrayOfString)
      {
        int m;
        for (;;) {}
      }
      i += 1;
    }
    paramArrayOfString = (String[])Arrays.copyOf(arrayOfString, j);
    j = arrayOfString.length;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      arrayOfString = paramVarArgs[i];
      try
      {
        System.arraycopy(arrayOfString, 0, paramArrayOfString, j, arrayOfString.length);
        m = arrayOfString.length;
        j += m;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return paramArrayOfString;
  }
  
  public static Set<String> copy(Set<String> paramSet)
  {
    if (paramSet == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add((String)paramSet.next());
    }
    return localHashSet;
  }
  
  public static Set<String> fromArrayToSet(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      HashSet localHashSet2 = new HashSet();
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        localHashSet1 = localHashSet2;
        if (i >= j) {
          break;
        }
        localHashSet2.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    HashSet localHashSet1 = null;
    return localHashSet1;
  }
  
  public static String[] fromSetToArray(Set<String> paramSet)
  {
    if (paramSet != null)
    {
      String[] arrayOfString = new String[paramSet.size()];
      paramSet.toArray(arrayOfString);
      return arrayOfString;
    }
    return null;
  }
  
  public static String getMapInnerValue(Map<String, Map<String, String>> paramMap, String paramString1, String paramString2)
  {
    if (paramMap != null)
    {
      paramMap = (Map)paramMap.get(paramString1);
      if (paramMap != null) {
        return (String)paramMap.get(paramString2);
      }
      return null;
    }
    return null;
  }
  
  public static String getMapValue(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return null;
    }
    return (String)paramMap.get(paramString);
  }
  
  public static Map<String, Map<String, String>> getSuitItem(Map<String, Map<String, String>> paramMap, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (isMapEmpty(paramMap)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Map localMap = (Map)paramMap.get(str1);
      String str2 = (String)localMap.get(paramString1);
      if (paramBoolean)
      {
        if (paramString2.equals(str2)) {
          localHashMap.put(str1, localMap);
        }
      }
      else if (!paramString2.equals(str2)) {
        localHashMap.put(str1, localMap);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, Integer> getSuitItem(Map<String, Integer> paramMap, boolean paramBoolean, int paramInt)
  {
    if (isMapEmpty(paramMap)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = ((Integer)paramMap.get(str)).intValue();
      if (paramBoolean)
      {
        if (paramInt == i) {
          localHashMap.put(str, Integer.valueOf(i));
        }
      }
      else if (paramInt != i) {
        localHashMap.put(str, Integer.valueOf(i));
      }
    }
    return localHashMap;
  }
  
  public static <T extends List<?>> boolean isListEmpty(T paramT)
  {
    return (paramT == null) || (paramT.isEmpty());
  }
  
  public static boolean isLong(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static <T extends Map<?, ?>> boolean isMapEmpty(T paramT)
  {
    return (paramT == null) || (paramT.isEmpty());
  }
  
  public static <T extends Set<?>> boolean isSetEmpty(T paramT)
  {
    return (paramT == null) || (paramT.isEmpty());
  }
  
  public static Map<String, String> putIfAbsent(Map<String, Map<String, String>> paramMap, String paramString)
  {
    Map localMap = (Map)paramMap.get(paramString);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      paramMap.put(paramString, localObject);
    }
    return (Map<String, String>)localObject;
  }
  
  public static void putMapItem(Map<String, Map<String, String>> paramMap, String paramString, Map<String, String> paramMap1)
  {
    Map localMap = (Map)paramMap.get(paramString);
    if (localMap == null)
    {
      paramMap.put(paramString, paramMap1);
      return;
    }
    localMap.putAll(paramMap1);
  }
  
  public static void putMapValue(Map<String, Map<String, String>> paramMap, String paramString1, String paramString2, String paramString3)
  {
    putIfAbsent(paramMap, paramString1).put(paramString2, paramString3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/DataTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */