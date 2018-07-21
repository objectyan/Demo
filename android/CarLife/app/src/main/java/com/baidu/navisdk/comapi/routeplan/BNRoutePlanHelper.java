package com.baidu.navisdk.comapi.routeplan;

import android.content.res.Resources;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNRoutePlanHelper
{
  public static String getLackOfDataCities(boolean[] paramArrayOfBoolean)
  {
    Object localObject4 = "";
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < paramArrayOfBoolean.length)
      {
        localObject1 = localObject4;
        if ((paramArrayOfBoolean[i] != 0) && (!StringUtils.isEmpty((String)localObject4))) {}
      }
      try
      {
        localObject1 = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
        for (;;)
        {
          i += 1;
          localObject4 = localObject1;
          break;
          try
          {
            String str = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);
            localObject1 = localObject4;
            if (StringUtils.isEmpty(str)) {
              continue;
            }
            localObject1 = localObject4;
            if (str.equals("null")) {
              continue;
            }
            localObject1 = (String)localObject4 + "、" + str;
          }
          catch (Exception localException)
          {
            Object localObject2 = localObject4;
          }
          return (String)localObject4;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject3 = localObject4;
        }
      }
    }
  }
  
  private static String getLackOfDataTips(boolean[] paramArrayOfBoolean)
  {
    String str = JarUtils.getResources().getString(1711669598);
    Object localObject2 = null;
    int i = 0;
    if (i < paramArrayOfBoolean.length)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfBoolean[i] != 0) {
        if (!StringUtils.isEmpty((String)localObject2)) {
          break label56;
        }
      }
      label56:
      for (localObject1 = JarUtils.getResources().getString(RoutePlanParams.mProvince[i]);; localObject1 = (String)localObject2 + "、" + JarUtils.getResources().getString(RoutePlanParams.mProvince[i]))
      {
        i += 1;
        localObject2 = localObject1;
        break;
      }
    }
    if (StringUtils.isNotEmpty((String)localObject2)) {
      return str + (String)localObject2;
    }
    return JarUtils.getResources().getString(1711669597);
  }
  
  public static String transferEngineFailTypeToString(int paramInt)
  {
    int j = -1;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i != -1)
    {
      try
      {
        localObject = JarUtils.getResources().getString(i);
        return (String)localObject;
      }
      catch (Exception localException) {}
      i = 1711669570;
      continue;
      i = 1711669581;
      continue;
      i = 1711669582;
      continue;
      i = 1711669583;
      continue;
      i = 1711669584;
      continue;
      i = 1711669585;
      continue;
      i = 1711669586;
      continue;
      i = 1711669588;
      continue;
      i = 1711669589;
      continue;
      i = 1711669590;
      continue;
      i = 1711669591;
      continue;
      i = 1711669592;
      continue;
      i = 1711669593;
      continue;
      i = 1711669594;
      continue;
      i = 1711669595;
      continue;
      i = 1711669596;
      continue;
      localObject = new boolean[35];
      i = j;
      if (BNRoutePlaner.getInstance().getLackOfData((boolean[])localObject))
      {
        if (localObject[0] != 0) {
          return JarUtils.getResources().getString(1711669569);
        }
        return getLackOfDataTips((boolean[])localObject);
      }
    }
    Object localObject = JarUtils.getResources().getString(1711669578);
    return (String)localObject;
    return "晕，小度不知怎么走了，请重试一次吧~";
  }
  
  public static String transferGeneralFailTypeToString(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != -1) {}
      try
      {
        return JarUtils.getResources().getString(paramInt);
      }
      catch (Exception localException)
      {
        String str;
        return "";
      }
      str = JarUtils.getResources().getString(1711669578);
      return str;
      paramInt = 1711669569;
      continue;
      paramInt = 1711669575;
      continue;
      paramInt = 1711669595;
      continue;
      paramInt = 1711669570;
      continue;
      paramInt = 1711669572;
      continue;
      paramInt = 1711669578;
      continue;
      paramInt = 1711669576;
      continue;
      paramInt = 1711669577;
      continue;
      paramInt = 1711669574;
      continue;
      paramInt = 1711669573;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeplan/BNRoutePlanHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */