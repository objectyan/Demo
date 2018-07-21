package com.indooratlas.android.sdk._internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class n
{
  public static <T extends m> String a(T paramT)
  {
    if (paramT == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      a(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT)
    {
      return "Error printing proto: " + paramT.getMessage();
    }
    catch (InvocationTargetException paramT) {}
    return "Error printing proto: " + paramT.getMessage();
  }
  
  private static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private static void a(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    Object localObject1;
    int i;
    if (paramObject != null)
    {
      if (!(paramObject instanceof m)) {
        break label419;
      }
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(a(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localObject1 = paramObject.getClass();
      Object localObject2 = ((Class)localObject1).getFields();
      int n = localObject2.length;
      i = 0;
      String str;
      Object localObject3;
      while (i < n)
      {
        Object localObject4 = localObject2[i];
        j = ((Field)localObject4).getModifiers();
        str = ((Field)localObject4).getName();
        if ((!"cachedSize".equals(str)) && ((j & 0x1) == 1) && ((j & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
        {
          localObject3 = ((Field)localObject4).getType();
          localObject4 = ((Field)localObject4).get(paramObject);
          if ((((Class)localObject3).isArray()) && (((Class)localObject3).getComponentType() != Byte.TYPE))
          {
            if (localObject4 == null) {}
            for (j = 0;; j = Array.getLength(localObject4))
            {
              int k = 0;
              while (k < j)
              {
                a(str, Array.get(localObject4, k), paramStringBuffer1, paramStringBuffer2);
                k += 1;
              }
            }
          }
          a(str, localObject4, paramStringBuffer1, paramStringBuffer2);
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getMethods();
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        str = localObject2[i].getName();
        if (str.startsWith("set")) {
          str = str.substring(3);
        }
        for (;;)
        {
          try
          {
            localObject3 = ((Class)localObject1).getMethod("has" + str, new Class[0]);
            if (!((Boolean)((Method)localObject3).invoke(paramObject, new Object[0])).booleanValue()) {}
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            continue;
          }
          try
          {
            localObject3 = ((Class)localObject1).getMethod("get" + str, new Class[0]);
            a(str, ((Method)localObject3).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        i += 1;
      }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(m);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    for (;;)
    {
      return;
      label419:
      if (!(paramObject instanceof Map)) {
        break;
      }
      paramObject = (Map)paramObject;
      paramString = a(paramString);
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)paramObject).next();
        paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(" <\n");
        i = paramStringBuffer1.length();
        paramStringBuffer1.append("  ");
        a("key", ((Map.Entry)localObject1).getKey(), paramStringBuffer1, paramStringBuffer2);
        a("value", ((Map.Entry)localObject1).getValue(), paramStringBuffer1, paramStringBuffer2);
        paramStringBuffer1.setLength(i);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    paramString = a(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      paramString = (String)paramObject;
      if (!((String)paramObject).startsWith("http"))
      {
        paramString = (String)paramObject;
        if (((String)paramObject).length() > 200) {
          paramString = ((String)paramObject).substring(0, 200) + "[...]";
        }
      }
      paramString = b(paramString);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[])) {
        a((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j == 92) || (j == 34)) {
        paramStringBuffer.append('\\').append((char)j);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
    }
    paramStringBuffer.append('"');
  }
  
  private static String b(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */