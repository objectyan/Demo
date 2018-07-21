package com.baidu.che.codriver.util;

import android.util.Log;
import com.baidu.carlife.core.i;
import com.baidu.che.codriver.a;
import java.io.PrintStream;

public class h
{
  public static final String a = "CoDriver_TAG";
  
  public static void a()
  {
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (2 > localObject.length)) {}
    do
    {
      return;
      str = localObject[1];
    } while (str == null);
    localObject = str.getClassName();
    String str = str.getMethodName();
    b((String)localObject, "+++++" + str);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(paramInt)) {
      switch (paramInt)
      {
      default: 
        Log.e("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
      }
    }
    for (;;)
    {
      i.a("CoDriver_TAG", paramString1, paramString2);
      return;
      Log.v("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
      continue;
      Log.d("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
      continue;
      Log.i("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
      continue;
      Log.w("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
      continue;
      Log.e("CoDriver_TAG", paramString1 + ": " + paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    if (a(5))
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("Got exception: ");
      localStringBuilder.append(paramThrowable.toString());
      localStringBuilder.append("\n");
      System.out.println(localStringBuilder.toString());
      paramThrowable.printStackTrace(System.out);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt >= a.j;
  }
  
  public static void b()
  {
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (2 > localObject.length)) {}
    do
    {
      return;
      str = localObject[1];
    } while (str == null);
    localObject = str.getClassName();
    String str = str.getMethodName();
    b((String)localObject, "====>" + str);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void c()
  {
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (2 > localObject.length)) {}
    do
    {
      return;
      str = localObject[1];
    } while (str == null);
    localObject = str.getClassName();
    String str = str.getMethodName();
    b((String)localObject, "<====" + str);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */