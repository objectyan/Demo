package com.baidu.carlife.c.g;

import com.baidu.carlife.c.d.c;
import org.jetbrains.annotations.NotNull;

public class a
{
  public static c<String> a(int paramInt)
  {
    c localc = new c();
    localc.b(com.baidu.carlife.core.a.a().getString(paramInt));
    return localc;
  }
  
  public static <T> c<T> a(@NotNull T paramT)
  {
    c localc = new c();
    localc.b(paramT);
    return localc;
  }
  
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
    }
    return paramT;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */