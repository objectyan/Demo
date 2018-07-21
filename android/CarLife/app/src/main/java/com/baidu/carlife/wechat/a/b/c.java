package com.baidu.carlife.wechat.a.b;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;

public final class c
{
  private static final String a = "wechat";
  private static final boolean b = true;
  private static final int c = 6;
  
  private static int a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (paramInt1 < 6) {
      return -1;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = "wechat";; paramString1 = "wechat_" + paramString1)
    {
      Object localObject = new Throwable().getStackTrace()[paramInt2];
      String str1 = ((StackTraceElement)localObject).getFileName();
      String str2 = ((StackTraceElement)localObject).getMethodName();
      paramInt2 = ((StackTraceElement)localObject).getLineNumber();
      localObject = str1;
      if (str1 != null)
      {
        localObject = str1;
        if (str1.contains(".java")) {
          localObject = str1.replace(".java", "");
        }
      }
      return Log.println(paramInt1, paramString1, String.format("[%s.%s(): %d] %s", new Object[] { localObject, str2, Integer.valueOf(paramInt2), paramString2 }));
    }
  }
  
  private static int a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(paramInt, paramString1, paramString2 + '\n' + b(paramThrowable), 3);
  }
  
  public static int a(String paramString)
  {
    return a(2, "", paramString, 2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return a(2, paramString1, paramString2, 2);
  }
  
  public static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static int a(Throwable paramThrowable)
  {
    return a(6, "", b(paramThrowable), 2);
  }
  
  public static int b(String paramString)
  {
    return a(3, "", paramString, 2);
  }
  
  public static int b(String paramString1, String paramString2)
  {
    return a(3, paramString1, paramString2, 2);
  }
  
  public static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public static int c(String paramString)
  {
    return a(4, "", paramString, 2);
  }
  
  public static int c(String paramString1, String paramString2)
  {
    return a(4, paramString1, paramString2, 2);
  }
  
  public static int c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static int d(String paramString)
  {
    return a(5, "", paramString, 2);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    return a(5, paramString1, paramString2, 2);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static int e(String paramString)
  {
    return a(6, "", paramString, 2);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return a(6, paramString1, paramString2, 2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(6, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */