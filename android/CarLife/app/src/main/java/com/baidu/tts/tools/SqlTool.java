package com.baidu.tts.tools;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SqlTool
{
  private static String a(Method paramMethod, Object paramObject)
  {
    try
    {
      paramMethod = (String)paramMethod.invoke(paramObject, (Object[])null);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod.printStackTrace();
    }
    return null;
  }
  
  private static String a(Method paramMethod1, Method paramMethod2, Object paramObject)
  {
    paramMethod1 = a(paramMethod1, paramObject);
    if (paramMethod1 != null)
    {
      paramMethod2 = a(paramMethod2, paramObject);
      if (paramMethod2 != null) {
        return paramMethod1 + " " + paramMethod2;
      }
    }
    return null;
  }
  
  public static String addPlaceholders(int paramInt)
  {
    int i = 1;
    if (paramInt < 1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?");
    while (i < paramInt)
    {
      localStringBuilder.append(",?");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String buildConditions(String paramString, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return null;
    }
    Object localObject = new ArrayList();
    int i = 0;
    String str;
    while (i < paramVarArgs.length)
    {
      str = paramVarArgs[i];
      if (!StringTool.isEmpty(str)) {
        ((List)localObject).add(str);
      }
      i += 1;
    }
    paramVarArgs = new StringBuilder();
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      paramVarArgs.append((String)((Iterator)localObject).next());
    }
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      paramVarArgs.append(" " + paramString + " ");
      paramVarArgs.append(str);
    }
    return paramVarArgs.toString();
  }
  
  public static String buildInCondition(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = new StringBuilder(paramString);
    paramString.append(" in (");
    paramString.append(addPlaceholders(paramArrayOfString.length));
    paramString.append(")");
    return paramString.toString();
  }
  
  public static String[] getSQLformat(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    String[] arrayOfString = new String[paramArrayOfString1.length + 1 + paramArrayOfString2.length + paramArrayOfString3.length];
    arrayOfString[0] = paramString;
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 1, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length + 1, paramArrayOfString2.length);
    System.arraycopy(paramArrayOfString3, 0, arrayOfString, paramArrayOfString1.length + 1 + paramArrayOfString2.length, paramArrayOfString3.length);
    return arrayOfString;
  }
  
  public static String sqlCreateTable(String paramString, Object[] paramArrayOfObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfObject != null)
      {
        localObject1 = paramArrayOfObject[0];
        localObject3 = localObject1.getClass();
      }
    }
    try
    {
      Method localMethod = ReflectTool.getSupportedMethod((Class)localObject3, "getColumnName", null);
      localObject3 = ReflectTool.getSupportedMethod((Class)localObject3, "getDataType", null);
      paramString = new StringBuilder("create Table " + paramString);
      String str = a(localMethod, (Method)localObject3, localObject1);
      localObject1 = localObject2;
      if (str != null)
      {
        paramString.append(" (" + str);
        int j = paramArrayOfObject.length;
        int i = 1;
        while (i < j)
        {
          paramString.append(",");
          paramString.append(a(localMethod, (Method)localObject3, paramArrayOfObject[i]));
          i += 1;
        }
        paramString.append(")");
        localObject1 = paramString.toString();
      }
      return (String)localObject1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String sqlDropTable(String paramString)
  {
    return "drop table if exists " + paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/SqlTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */