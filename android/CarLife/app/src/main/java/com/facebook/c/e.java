package com.facebook.c;

import com.facebook.common.internal.m;

public class e
{
  public static <T> d<T> a(T paramT)
  {
    i locali = i.j();
    locali.b(paramT);
    return locali;
  }
  
  public static <T> d<T> a(Throwable paramThrowable)
  {
    i locali = i.j();
    locali.a(paramThrowable);
    return locali;
  }
  
  public static <T> m<d<T>> b(Throwable paramThrowable)
  {
    new m()
    {
      public d<T> a()
      {
        return e.a(this.a);
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */