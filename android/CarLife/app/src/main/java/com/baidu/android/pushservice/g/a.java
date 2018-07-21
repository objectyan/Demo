package com.baidu.android.pushservice.g;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.PushSettings;
import java.io.PrintWriter;
import java.io.StringWriter;

public class a
{
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    if ((PushSettings.c(paramContext)) && (paramString2 != null)) {
      Log.d("BDPushSDK-" + paramString1, paramString2);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable, Context paramContext)
  {
    b(paramString, a(paramThrowable), paramContext);
  }
  
  public static void b(String paramString1, String paramString2, Context paramContext)
  {
    if ((PushSettings.c(paramContext)) && (paramString2 != null)) {
      Log.e("BDPushSDK-" + paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2, Context paramContext)
  {
    if ((PushSettings.c(paramContext)) && (paramString2 != null)) {
      Log.i("BDPushSDK-" + paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Context paramContext)
  {
    if ((PushSettings.c(paramContext)) && (paramString2 != null)) {
      Log.w("BDPushSDK-" + paramString1, paramString2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */