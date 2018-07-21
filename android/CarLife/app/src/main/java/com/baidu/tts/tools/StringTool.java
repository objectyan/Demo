package com.baidu.tts.tools;

import java.util.Iterator;
import java.util.List;

public class StringTool
{
  public static String addDivider(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next());
    }
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static String addDivider(int[] paramArrayOfInt, String paramString)
  {
    if (paramArrayOfInt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfInt[0]);
      int i = 1;
      while (i < paramArrayOfInt.length)
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramArrayOfInt[i]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean isAllNumber(String paramString)
  {
    if (paramString != null) {
      return paramString.matches("^[0-9]{1,20}$");
    }
    return false;
  }
  
  public static boolean isEmpty(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() <= 0) {
      return true;
    }
    return false;
  }
  
  public static boolean isEqual(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/StringTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */