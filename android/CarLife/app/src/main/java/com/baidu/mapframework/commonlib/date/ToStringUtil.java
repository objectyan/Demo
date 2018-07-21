package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ToStringUtil
{
  private static final String a = "getClass";
  private static final String b = "clone";
  private static final String c = "hashCode";
  private static final String d = "toString";
  private static final String e = "get";
  private static final Object[] f = new Object[0];
  private static final Class[] g = new Class[0];
  private static final String h = "";
  private static final String i = "[circular reference]";
  private static final Logger j = Util.a(ToStringUtil.class);
  private static final String k = System.getProperty("line.separator");
  private static Pattern l = Pattern.compile("password", 2);
  private static String m = "****";
  
  private static Object a(Object paramObject, Method paramMethod)
  {
    localObject1 = null;
    try
    {
      Object localObject2 = paramMethod.invoke(paramObject, f);
      paramObject = localObject2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        b(paramObject, paramMethod);
        paramObject = localObject1;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        b(paramObject, paramMethod);
        paramObject = localObject1;
      }
    }
    return c(paramObject, paramMethod);
  }
  
  static String a(Object paramObject)
  {
    return a(paramObject, null, null);
  }
  
  static String a(Object paramObject, Class paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramObject, localStringBuilder);
    Method[] arrayOfMethod = paramObject.getClass().getDeclaredMethods();
    int i1 = arrayOfMethod.length;
    int n = 0;
    while (n < i1)
    {
      Method localMethod = arrayOfMethod[n];
      if (a(localMethod, paramObject.getClass())) {
        a(paramObject, localMethod, localStringBuilder, paramClass, paramString);
      }
      n += 1;
    }
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static String a(Method paramMethod)
  {
    String str = paramMethod.getName();
    paramMethod = str;
    if (str.startsWith("get")) {
      paramMethod = str.substring("get".length());
    }
    return paramMethod;
  }
  
  private static Method a(Class paramClass, String paramString)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, g);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      b(paramClass, paramString);
    }
    return null;
  }
  
  private static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramObject.getClass().getName());
    paramStringBuilder.append(" {");
    paramStringBuilder.append(k);
  }
  
  private static void a(Object paramObject, Method paramMethod, StringBuilder paramStringBuilder, Class paramClass, String paramString)
  {
    paramStringBuilder.append("");
    paramStringBuilder.append(a(paramMethod));
    paramStringBuilder.append(": ");
    paramObject = a(paramObject, paramMethod);
    if ((paramObject != null) && (paramObject.getClass().isArray())) {
      paramStringBuilder.append(Util.b(paramObject));
    }
    for (;;)
    {
      paramStringBuilder.append(k);
      return;
      if (paramClass == null)
      {
        paramStringBuilder.append(paramObject);
      }
      else if (paramClass == paramObject.getClass())
      {
        paramMethod = a(paramClass, paramString);
        if (a(paramMethod, paramClass)) {
          paramStringBuilder.append(a(paramObject, paramMethod));
        } else {
          paramStringBuilder.append("[circular reference]");
        }
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("}");
    paramStringBuilder.append(k);
  }
  
  private static boolean a(Method paramMethod, Class paramClass)
  {
    boolean bool = Modifier.isPublic(paramMethod.getModifiers());
    int n;
    int i1;
    label31:
    int i2;
    if (paramMethod.getParameterTypes().length == 0)
    {
      n = 1;
      if (paramMethod.getReturnType() == Void.TYPE) {
        break label123;
      }
      i1 = 1;
      if (paramMethod.getReturnType() != paramClass) {
        break label128;
      }
      i2 = 1;
      label42:
      if ((!paramMethod.getName().equals("clone")) && (!paramMethod.getName().equals("getClass")) && (!paramMethod.getName().equals("hashCode")) && (!paramMethod.getName().equals("toString"))) {
        break label134;
      }
    }
    label123:
    label128:
    label134:
    for (int i3 = 1;; i3 = 0)
    {
      if ((!bool) || (n == 0) || (i1 == 0) || (i3 != 0) || (i2 != 0)) {
        break label140;
      }
      return true;
      n = 0;
      break;
      i1 = 0;
      break label31;
      i2 = 0;
      break label42;
    }
    label140:
    return false;
  }
  
  private static void b(Class paramClass, String paramString)
  {
    j.severe("Reflection fails to get no-arg method named: " + Util.a(paramString) + " for class: " + paramClass.getName());
  }
  
  private static void b(Object paramObject, Method paramMethod)
  {
    j.severe("Cannot get return value using reflection. Class: " + paramObject.getClass().getName() + " Method: " + paramMethod.getName());
  }
  
  private static Object c(Object paramObject, Method paramMethod)
  {
    if (l.matcher(paramMethod.getName()).find()) {
      paramObject = m;
    }
    return paramObject;
  }
  
  public static void main(String... paramVarArgs)
  {
    paramVarArgs = new ArrayList();
    paramVarArgs.add("blah");
    paramVarArgs.add("blah");
    paramVarArgs.add("blah");
    new StringTokenizer("This is the end.");
    paramVarArgs = new Ping(null);
    Pong localPong = new Pong(null);
    paramVarArgs.setPong(localPong);
    localPong.setPing(paramVarArgs);
  }
  
  private static final class Ping
  {
    private ToStringUtil.Pong a;
    
    public Integer getId()
    {
      return new Integer(123);
    }
    
    public ToStringUtil.Pong getPong()
    {
      return this.a;
    }
    
    public String getUserPassword()
    {
      return "blah";
    }
    
    public void setPong(ToStringUtil.Pong paramPong)
    {
      this.a = paramPong;
    }
    
    public String toString()
    {
      return ToStringUtil.a(this);
    }
  }
  
  private static final class Pong
  {
    private ToStringUtil.Ping a;
    
    public ToStringUtil.Ping getPing()
    {
      return this.a;
    }
    
    public void setPing(ToStringUtil.Ping paramPing)
    {
      this.a = paramPing;
    }
    
    public String toString()
    {
      return ToStringUtil.a(this, ToStringUtil.Ping.class, "getId");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/ToStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */