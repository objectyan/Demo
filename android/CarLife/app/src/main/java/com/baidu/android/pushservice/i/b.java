package com.baidu.android.pushservice.i;

import java.util.concurrent.PriorityBlockingQueue;

public class b<E>
  extends PriorityBlockingQueue<E>
{
  public boolean offer(E paramE)
  {
    try
    {
      if (size() >= 20) {
        return false;
      }
      boolean bool = super.offer(paramE);
      return bool;
    }
    catch (Exception paramE) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */