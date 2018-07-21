package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.List;

public class f<E>
  extends ArrayList<E>
{
  private f(List<E> paramList)
  {
    super(paramList);
  }
  
  public static <E> f<E> a(List<E> paramList)
  {
    return new f(paramList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */