package com.baidu.carlife.core;

import android.os.Message;
import java.util.ArrayList;
import java.util.List;

public class k
  implements h
{
  private static final int a = -1;
  private static List<j> b = new ArrayList();
  
  public static void a()
  {
    if (b != null) {
      b.clear();
    }
  }
  
  public static void a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      int i = 0;
      while (i < b.size())
      {
        j localj = (j)b.get(i);
        if ((localj != null) && (localj.isAdded(paramInt))) {
          localj.removeMessages(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, -1, -1, null, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, -1, null, paramInt3);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, null, paramInt4);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    a(paramInt1, paramInt2, paramInt3, paramObject, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      int i = 0;
      while (i < b.size())
      {
        j localj = (j)b.get(i);
        if ((localj != null) && (localj.isAdded(paramInt1))) {
          localj.sendMessageDelayed(Message.obtain(localj, paramInt1, paramInt2, paramInt3, paramObject), paramInt4);
        }
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramInt2, -1, paramObject);
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    a(paramInt, -1, -1, paramObject);
  }
  
  public static void a(j paramj)
  {
    if ((paramj == null) || (b.contains(paramj))) {
      return;
    }
    b.add(paramj);
  }
  
  public static void b(int paramInt)
  {
    a(paramInt, -1, -1, null);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, -1, null);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, null);
  }
  
  public static void b(j paramj)
  {
    if ((paramj == null) || (!b.contains(paramj))) {
      return;
    }
    b.remove(paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */