package com.facebook.common.e;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class b
  implements c
{
  public static final b a = new b();
  private String b = "unknown";
  private int c = 5;
  
  public static b a()
  {
    return a;
  }
  
  private static String a(String paramString, Throwable paramThrowable)
  {
    return paramString + '\n' + a(paramThrowable);
  }
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.println(paramInt, b(paramString1), a(paramString2, paramThrowable));
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (this.b != null) {
      str = this.b + ":" + paramString;
    }
    return str;
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    Log.println(paramInt, b(paramString1), paramString2);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    b(paramInt, paramString1, paramString2);
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(2, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(String paramString1, String paramString2)
  {
    b(3, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public boolean b(int paramInt)
  {
    return this.c <= paramInt;
  }
  
  public void c(String paramString1, String paramString2)
  {
    b(4, paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    b(5, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    b(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void f(String paramString1, String paramString2)
  {
    b(6, paramString1, paramString2);
  }
  
  public void f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */