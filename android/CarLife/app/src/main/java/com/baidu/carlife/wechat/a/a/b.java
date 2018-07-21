package com.baidu.carlife.wechat.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class b
{
  public static final String a = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36";
  
  public static boolean a(Context paramContext)
  {
    paramContext = e(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = e(paramContext);
    if ((paramContext != null) && (paramContext.isConnected())) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = e(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isConnected())
      {
        bool1 = bool2;
        if (paramContext.getType() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String d(Context paramContext)
  {
    paramContext = e(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getTypeName();
  }
  
  private static NetworkInfo e(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */