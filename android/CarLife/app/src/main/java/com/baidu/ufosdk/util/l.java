package com.baidu.ufosdk.util;

import android.os.Build.VERSION;
import java.lang.reflect.Field;

public final class l
{
  public static int a()
  {
    try
    {
      int i = Build.VERSION.class.getField("SDK_INT").getInt(null);
      return i;
    }
    catch (SecurityException localSecurityException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalAccessException localIllegalAccessException) {}
    return Integer.parseInt(Build.VERSION.SDK);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */