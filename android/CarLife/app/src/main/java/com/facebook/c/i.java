package com.facebook.c;

import com.facebook.common.internal.k;

public class i<T>
  extends a<T>
{
  public static <T> i<T> j()
  {
    return new i();
  }
  
  public boolean a(float paramFloat)
  {
    return super.a(paramFloat);
  }
  
  public boolean a(T paramT, boolean paramBoolean)
  {
    return super.a(k.a(paramT), paramBoolean);
  }
  
  public boolean a(Throwable paramThrowable)
  {
    return super.a((Throwable)k.a(paramThrowable));
  }
  
  public boolean b(T paramT)
  {
    return super.a(k.a(paramT), true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */