package com.baidu.location.indoor;

import java.util.ArrayList;

public class b<T>
  extends ArrayList<T>
{
  private int a = 0;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean add(T paramT)
  {
    try
    {
      if (size() == this.a) {
        remove(0);
      }
      add(size(), paramT);
      return true;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      if (size() <= 3) {
        return;
      }
      int i = size() / 2;
      while (i > 0)
      {
        remove(0);
        i -= 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */