package com.baidu.platform.comapi.util;

import android.os.Build;
import android.text.TextUtils;

public class i
{
  public static String a = i.class.getSimpleName();
  public static final String b = "";
  private static final String c = "ro.build.version.emui";
  
  public static i a()
  {
    return a.a();
  }
  
  /* Error */
  public static Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 34	java/lang/Exception
    //   7: dup
    //   8: ldc 44
    //   10: invokespecial 47	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +17 -> 32
    //   18: aload_3
    //   19: ifnull +72 -> 91
    //   22: new 34	java/lang/Exception
    //   25: dup
    //   26: ldc 49
    //   28: invokespecial 47	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_3
    //   33: ifnonnull +13 -> 46
    //   36: new 34	java/lang/Exception
    //   39: dup
    //   40: ldc 51
    //   42: invokespecial 47	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: aload_2
    //   47: arraylength
    //   48: aload_3
    //   49: arraylength
    //   50: if_icmpeq +41 -> 91
    //   53: new 34	java/lang/Exception
    //   56: dup
    //   57: new 53	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   64: ldc 56
    //   66: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: arraylength
    //   71: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 65
    //   76: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: arraylength
    //   81: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 47	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   90: athrow
    //   91: aload_0
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 72	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   97: astore_0
    //   98: aload_0
    //   99: aconst_null
    //   100: aload_3
    //   101: invokevirtual 78	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: astore_0
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: getstatic 24	com/baidu/platform/comapi/util/i:a	Ljava/lang/String;
    //   111: aload_0
    //   112: invokevirtual 81	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   115: invokestatic 87	com/baidu/platform/comapi/util/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: getstatic 24	com/baidu/platform/comapi/util/i:a	Ljava/lang/String;
    //   124: aload_0
    //   125: invokevirtual 88	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   128: invokestatic 87	com/baidu/platform/comapi/util/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: getstatic 24	com/baidu/platform/comapi/util/i:a	Ljava/lang/String;
    //   137: aload_0
    //   138: invokevirtual 89	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   141: invokestatic 87	com/baidu/platform/comapi/util/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: getstatic 24	com/baidu/platform/comapi/util/i:a	Ljava/lang/String;
    //   150: aload_0
    //   151: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokestatic 87	com/baidu/platform/comapi/util/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aconst_null
    //   158: areturn
    //   159: astore_0
    //   160: getstatic 24	com/baidu/platform/comapi/util/i:a	Ljava/lang/String;
    //   163: aload_0
    //   164: invokevirtual 91	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   167: invokestatic 87	com/baidu/platform/comapi/util/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aconst_null
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramClass	Class
    //   0	172	1	paramString	String
    //   0	172	2	paramArrayOfClass	Class[]
    //   0	172	3	paramArrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   98	105	107	java/lang/IllegalAccessException
    //   91	98	120	java/lang/NoSuchMethodException
    //   98	105	120	java/lang/NoSuchMethodException
    //   108	118	120	java/lang/NoSuchMethodException
    //   134	144	120	java/lang/NoSuchMethodException
    //   160	170	120	java/lang/NoSuchMethodException
    //   98	105	133	java/lang/IllegalArgumentException
    //   91	98	146	java/lang/Exception
    //   98	105	146	java/lang/Exception
    //   108	118	146	java/lang/Exception
    //   134	144	146	java/lang/Exception
    //   160	170	146	java/lang/Exception
    //   98	105	159	java/lang/reflect/InvocationTargetException
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass, paramArrayOfObject);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      f.d(a, paramString1.getMessage());
      return null;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        f.d(a, paramString1.getMessage());
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        f.d(a, paramString1.getMessage());
      }
    }
  }
  
  public static String d()
  {
    String str = "";
    try
    {
      Object localObject = a("android.os.SystemProperties", "get", new Class[] { String.class, String.class }, new Object[] { "ro.build.version.emui", "" });
      if (localObject != null) {
        str = (String)localObject;
      }
      return str;
    }
    catch (Exception localException)
    {
      f.d(a, localException.getMessage());
    }
    return "";
  }
  
  public boolean b()
  {
    Object localObject = "";
    try
    {
      String str = Build.MANUFACTURER;
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.d(a, localException.getMessage());
      }
    }
    return "xiaomi".equalsIgnoreCase((String)localObject);
  }
  
  public boolean c()
  {
    Object localObject = "";
    try
    {
      String str = d();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.d(a, localException.getMessage());
      }
    }
    return !TextUtils.isEmpty((CharSequence)localObject);
  }
  
  private static class a
  {
    private static final i a = new i();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */